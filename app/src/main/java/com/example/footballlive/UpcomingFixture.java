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

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class UpcomingFixture extends AppCompatActivity {


    public Calendar calendar= Calendar.getInstance();
    public SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd");
    public String date = simpleDateFormat.format(calendar.getTime());



    public String URL_DATA2 = "https://allsportsapi.com/api/football/?met=Fixtures&APIkey=dc2997f918b945d8cad80e1ad00e1f6d59bf75f84a77899d61f5902ea6cf945a&from="+date+"&to="+date+"";
    public RecyclerView recyclerView2;
    public RecyclerView.Adapter adapter2;
    public List<ListItemFixture> listItemFixtures;

    public BottomNavigationView btnnav2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upcoming_fixture);
        recyclerView2=  findViewById(R.id.relativeUp);
        btnnav2= findViewById(R.id.navbarUp);
        recyclerView2.setHasFixedSize(true);
        recyclerView2.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        Log.i("onmoo",date);

        listItemFixtures = new ArrayList<>();






        loadRecyclerView2();
        btnnav2.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){

                    case R.id.live:
                        Intent intent1 = new Intent(UpcomingFixture.this,MainActivity.class);
                        UpcomingFixture.this.startActivity(intent1);
                        break;

                    case R.id.fixtures:
                        Intent intent2 = new Intent(UpcomingFixture.this,UpcomingFixture.class);
                        UpcomingFixture.this.startActivity(intent2);
                        break;

                    case R.id.Table:
                        Intent intent3 = new Intent(UpcomingFixture.this, LeagueTable.class);
                        UpcomingFixture.this.startActivity(intent3);
                        break;

                    case R.id.video:
                        Intent intent4 = new Intent(UpcomingFixture.this,Higlights.class);
                        UpcomingFixture.this.startActivity(intent4);
                        break;



                }
                return false;
            }
        });
        btnnav2.setItemIconTintList(null);





    }

    private void loadRecyclerView2() {
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading.....");
        progressDialog.show();


        StringRequest stringRequest2 = new StringRequest(URL_DATA2, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Log.i("info",response);
                progressDialog.dismiss();
           try {

               JSONObject jsonObject = new JSONObject(response);
               String result = jsonObject.getString("result");

               Log.i("info", result);
               JSONArray jsonArray = new JSONArray(result);

               for (int i = 0; i < jsonArray.length(); i++) {

                   JSONObject jsonObject1 = jsonArray.getJSONObject(i);

                   Log.i("info", jsonObject1.getString("event_home_team"));
                   Log.i("info", jsonObject1.getString("event_away_team"));
                   Log.i("info", jsonObject1.getString("event_date"));
                   Log.i("info", jsonObject1.getString("event_halftime_result"));
                   Log.i("info", jsonObject1.getString("event_final_result"));
                   Log.i("info", jsonObject1.getString("league_name"));
                   Log.i("info", jsonObject1.getString("home_team_logo"));
                   Log.i("info", jsonObject1.getString("away_team_logo"));

                   String data1 = "";
                   String data2 = "";

                   String goalscorers = jsonObject1.getString("goalscorers");
                   JSONArray jsonArray2 = new JSONArray(goalscorers);
                   for (int j = 0; j < jsonArray2.length(); j++) {

                       JSONObject jsonObject2 = jsonArray2.getJSONObject(j);


                       Log.i("infoGoalTime", jsonObject2.getString("time"));
                       Log.i("infoGoalHome", jsonObject2.getString("home_scorer"));
                       Log.i("infoGoalAway", jsonObject2.getString("away_scorer"));

                       String time = jsonObject2.getString("time");
                       String homeS = jsonObject2.getString("home_scorer");
                       String awayS = jsonObject2.getString("away_scorer");

                       data1 += homeS + ",";
                       data2 +=  awayS + ",";


                   }

                  ListItemFixture listItemFixture = new ListItemFixture(

                           jsonObject1.getString("event_home_team"),
                           jsonObject1.getString("event_away_team"),
                           jsonObject1.getString("event_date"),
                           jsonObject1.getString("event_halftime_result"),
                           jsonObject1.getString("event_final_result"),
                           jsonObject1.getString("league_name"),
                           jsonObject1.getString("home_team_logo"),
                           jsonObject1.getString("away_team_logo"), data1,
                           data2


                   );


                   listItemFixtures.add(listItemFixture);
                   adapter2 = new Myadapter2(listItemFixtures,getApplicationContext());
                   recyclerView2.setAdapter(adapter2);



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

            RequestQueue requestQueue2 = Volley.newRequestQueue(this);
            requestQueue2.add(stringRequest2);


    }
}