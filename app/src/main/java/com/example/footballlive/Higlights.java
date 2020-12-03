package com.example.footballlive;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Higlights extends AppCompatActivity {
        public String URL_DATA4 ="https://allsportsapi.com/api/football/?&met=Videos&eventId=76387&APIkey=dc2997f918b945d8cad80e1ad00e1f6d59bf75f84a77899d61f5902ea6cf945a";
    public RecyclerView recyclerView4;
    public RecyclerView.Adapter adapter4;
  public List<ListHighlights> listHighlights;
    public SwipeRefreshLayout swipeRefreshLayout2;
    public BottomNavigationView btnnav4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_higlights);
        recyclerView4=  findViewById(R.id.relative45);
        btnnav4= findViewById(R.id.navbar55);
        recyclerView4.setHasFixedSize(true);
        recyclerView4.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        listHighlights = new ArrayList<>();

        loadRecyclerView4();

        btnnav4.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){

                    case R.id.live:
                        Intent intent1 = new Intent(Higlights.this,MainActivity.class);
                        Higlights.this.startActivity(intent1);
                        break;

                    case R.id.fixtures:
                        Intent intent2 = new Intent(Higlights.this,UpcomingFixture.class);
                        Higlights.this.startActivity(intent2);
                        break;

                    case R.id.Table:
                        Intent intent3 = new Intent(Higlights.this, LeagueTable.class);
                        Higlights.this.startActivity(intent3);
                        break;

                    case R.id.video:
                        Intent intent4 = new Intent(Higlights.this,Higlights.class);
                        Higlights.this.startActivity(intent4);
                        break;



                }
                return false;
            }
        });
        btnnav4.setItemIconTintList(null);
    }

    private void loadRecyclerView4() {
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading.....");
        progressDialog.show();


        StringRequest stringRequest4 = new StringRequest(URL_DATA4, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                progressDialog.dismiss();

            try {
                JSONObject jsonObject = new JSONObject(response);
                String result = jsonObject.getString("result");

                Log.i("info", result);
                JSONArray jsonArray = new JSONArray(result);

                for (int i = 0; i < jsonArray.length(); i++) {

                    JSONObject jsonObject1 = jsonArray.getJSONObject(i);

                    Log.i("info", jsonObject1.getString("video_title_full"));
                    Log.i("info", jsonObject1.getString("video_title"));
                    Log.i("info", jsonObject1.getString("video_url"));


                    ListHighlights listHighlight = new ListHighlights(

                            jsonObject1.getString("video_title_full"),
                            jsonObject1.getString("video_title"),
                            jsonObject1.getString("video_url")



                    );


                    listHighlights.add(listHighlight);
                    adapter4 = new Myadapter4(listHighlights,getApplicationContext());
                    recyclerView4.setAdapter(adapter4);
                }

            }catch (Exception e){
                e.printStackTrace();
            }



            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        RequestQueue requestQueue4 = Volley.newRequestQueue(this);
        requestQueue4.add(stringRequest4);
    }
}