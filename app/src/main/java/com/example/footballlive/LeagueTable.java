package com.example.footballlive;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.Toast;

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

public class LeagueTable extends AppCompatActivity {
    public static String URL_DATA3 = "https://allsportsapi.com/api/football/?&met=Standings&leagueId=148&APIkey=dc2997f918b945d8cad80e1ad00e1f6d59bf75f84a77899d61f5902ea6cf945a";
    public BottomNavigationView btnnav3;
    public RecyclerView recyclerView3;
    public RecyclerView.Adapter adapter3;
    public List<ListTable> listTables;
        public void selectleague (View view){


            PopupMenu popupMenu = new PopupMenu(this,view);
            popupMenu.inflate(R.menu.popup);
            popupMenu.show();
            popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem item) {
                  switch (item.getItemId()){

                      case R.id.item1:
                          Intent intent1 = new Intent(LeagueTable.this,LeagueTable.class);
                          LeagueTable.this.startActivity(intent1);
                          break;


                      case R.id.item2:
                          Intent intent2 = new Intent(LeagueTable.this,LeagueTablesSpain.class);
                          LeagueTable.this.startActivity(intent2);
                          break;


                      case R.id.item3:
                          Intent intent3 = new Intent(LeagueTable.this,LeagueTableItaly.class);
                          LeagueTable.this.startActivity(intent3);
                          break;

                      case R.id.item4:
                          Intent intent4 = new Intent(LeagueTable.this,LeagueTableGermany.class);
                          LeagueTable.this.startActivity(intent4);
                          break;
                      case R.id.item5:
                          Intent intent5 = new Intent(LeagueTable.this, LeagueTableFrance.class);
                          LeagueTable.this.startActivity(intent5);
                          break;

                  }
                    return true;
                }
            });




        }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_league_table);
        recyclerView3 = findViewById(R.id.relative78);
        btnnav3= (BottomNavigationView) findViewById(R.id.navbartt);
        recyclerView3.setHasFixedSize(true);
        recyclerView3.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        listTables = new ArrayList<>();


        loadRecyclerView3();
        adapter3 = new MyAdapter3(listTables,getApplicationContext());
        recyclerView3.setAdapter(adapter3);
        btnnav3.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){

                    case R.id.live:
                        Intent intent1 = new Intent(LeagueTable.this,MainActivity.class);
                        LeagueTable.this.startActivity(intent1);
                        break;

                    case R.id.fixtures:
                        Intent intent2 = new Intent(LeagueTable.this,UpcomingFixture.class);
                        LeagueTable.this.startActivity(intent2);
                        break;

                    case R.id.Table:
                        Intent intent3 = new Intent(LeagueTable.this, LeagueTable.class);
                        LeagueTable.this.startActivity(intent3);
                        break;

                    case R.id.video:
                        Intent intent4 = new Intent(LeagueTable.this,Higlights.class);
                        LeagueTable.this.startActivity(intent4);
                        break;



                }
                return false;
            }
        });
        btnnav3.setItemIconTintList(null);
    }

    private void loadRecyclerView3() {
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading.....");
        progressDialog.show();
        StringRequest stringRequest3 = new StringRequest(URL_DATA3, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                progressDialog.dismiss();
                try {

                    JSONObject jsonObject = new JSONObject(response);
                    String result = jsonObject.getString("result");

                    Log.i("info", result);

                    JSONObject jsonObject2 = new JSONObject(result);

                    String result2 = jsonObject2.getString("total");


                    JSONArray jsonArray = new JSONArray(result2);

                    for (int i = 0; i < jsonArray.length(); i++) {

                        JSONObject jsonObject1 = jsonArray.getJSONObject(i);

                        Log.i("info", jsonObject1.getString("standing_place"));
                        Log.i("info", jsonObject1.getString("standing_team"));
                        Log.i("info", jsonObject1.getString("standing_P"));
                        Log.i("info", jsonObject1.getString("standing_W"));
                        Log.i("info", jsonObject1.getString("standing_D"));
                        Log.i("info", jsonObject1.getString("standing_L"));
                        Log.i("info", jsonObject1.getString("standing_GD"));
                        Log.i("info", jsonObject1.getString("standing_PTS"));
                        Log.i("info", jsonObject1.getString("league_season"));

                    ListTable listTable = new ListTable(
                            jsonObject1.getString("standing_place"),
                            jsonObject1.getString("standing_team"),
                            jsonObject1.getString("standing_P"),
                            jsonObject1.getString("standing_W"),
                            jsonObject1.getString("standing_D"),
                            jsonObject1.getString("standing_L"),
                            jsonObject1.getString("standing_GD"),
                            jsonObject1.getString("standing_PTS"),
                            jsonObject1.getString("league_season")




                    );
                        listTables.add(listTable);

                        adapter3.notifyDataSetChanged();

                    }



                }catch (Exception e){
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "error", Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();

            }
        });

        RequestQueue requestQueue3 = Volley.newRequestQueue(this);
        requestQueue3.add(stringRequest3);

    }
}