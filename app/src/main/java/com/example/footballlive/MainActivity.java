package com.example.footballlive;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.SearchView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static String URL_DATA = "https://allsportsapi.com/api/football/?met=Livescore&APIkey=dc2997f918b945d8cad80e1ad00e1f6d59bf75f84a77899d61f5902ea6cf945a";
    public RecyclerView recyclerView;
    public RecyclerView.Adapter adapter;
    public List<listItem> listItems;
    public SwipeRefreshLayout swipeRefreshLayout;
    public BottomNavigationView btnnav;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.relative);
        swipeRefreshLayout = findViewById(R.id.swipe);
        btnnav= findViewById(R.id.navbar);






        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        listItems = new ArrayList<>();

        loadRecyclerView();
        adapter = new MyAdapter(listItems, getApplicationContext());
        recyclerView.setAdapter(adapter);

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                listItems.clear();
                loadRecyclerView();
                adapter.notifyDataSetChanged();
                swipeRefreshLayout.setRefreshing(false);
            }
        });
        btnnav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()){

                    case R.id.live:
                        Intent intent1 = new Intent(MainActivity.this,MainActivity.class);
                        MainActivity.this.startActivity(intent1);
                        break;

                    case R.id.fixtures:
                        Intent intent2 = new Intent(MainActivity.this,UpcomingFixture.class);
                        MainActivity.this.startActivity(intent2);
                        break;

                    case R.id.Table:
                        Intent intent3 = new Intent(MainActivity.this, LeagueTable.class);
                        MainActivity.this.startActivity(intent3);
                        break;

                    case R.id.video:
                        Intent intent4 = new Intent(MainActivity.this,Higlights.class);
                        MainActivity.this.startActivity(intent4);
                        break;



                }
                return false;
            }
        });
        btnnav.setItemIconTintList(null);




    }




    private void loadRecyclerView() {
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading.....");
        progressDialog.show();

    StringRequest stringRequest = new StringRequest(Request.Method.GET, URL_DATA,
            new Response.Listener<String>() {
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

                            Log.i("info", jsonObject1.getString("event_key"));
                            Log.i("info", jsonObject1.getString("event_date"));
                            Log.i("info", jsonObject1.getString("event_time"));
                            Log.i("info", jsonObject1.getString("event_home_team"));
                            Log.i("info", jsonObject1.getString("event_away_team"));
                            Log.i("info", jsonObject1.getString("event_final_result"));
                            Log.i("info", jsonObject1.getString("league_name"));
                            Log.i("info", jsonObject1.getString("event_home_formation"));
                            Log.i("info", jsonObject1.getString("event_away_formation"));

                            Log.i("info", jsonObject1.getString("event_status"));
                            Log.i("info", jsonObject1.getString("league_logo"));
                            Log.i("info3", jsonObject1.getString("goalscorers"));
                            Log.i("info3", jsonObject1.getString("cards"));
                            Log.i("info0", jsonObject1.getString("lineups"));

                            String data1 = "";
                            String data2 = "";
                            String data3 = "";
                            String data4 = "";
                            String data5 = "";
                            String data6 = "";
                            String data7 = "";
                            String data8 = "";
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

                            Log.i("infot", data1);
                            Log.i("infor", data2);
                            String cards = jsonObject1.getString("cards");

                            JSONArray jsonArray3 = new JSONArray(cards);
                            for (int k = 0; k < jsonArray3.length(); k++) {

                                JSONObject jsonObject3 = jsonArray3.getJSONObject(k);


                                Log.i("infoGoalTime", jsonObject3.getString("time"));
                                Log.i("infoGoalHome", jsonObject3.getString("home_fault"));
                                Log.i("infoGoalAway", jsonObject3.getString("away_fault"));

                                String timeC = jsonObject3.getString("time");
                                String homeC = jsonObject3.getString("home_fault");
                                String awayC = jsonObject3.getString("away_fault");
                                String typeC = jsonObject3.getString("card");

                                data3 +=  homeC + typeC + ",";
                                data4 += awayC + typeC + ",";


                            }
                            Log.i("inpo", data3);
                            Log.i("inpo", data4);

                            String lineup = jsonObject1.getString("lineups");
                            JSONObject JsonObject4 = jsonObject1.getJSONObject("lineups");
                            Log.i("info5677", lineup);

                            String hometeam = JsonObject4.getString("home_team");
                            Log.i("info568", hometeam);

                            JSONObject JsonObject5 = new JSONObject(hometeam);
                            JSONArray jsonArrayhome = JsonObject5.getJSONArray("starting_lineups");
                            for (int e = 0; e < jsonArrayhome.length(); e++) {

                                JSONObject jsonObject7 = jsonArrayhome.getJSONObject(e);

                                Log.i("inko33", jsonObject7.getString("player"));
                                Log.i("inko33", jsonObject7.getString("player_number"));

                                String Hteamplayers = jsonObject7.getString("player");
                                String Hteamplayersnum = jsonObject7.getString("player_number");

                                data5 += Hteamplayers + "(" + Hteamplayersnum + ")" + '\n';
                            }
                            Log.i("infoline9", data5);


                            String awayteam = JsonObject4.getString("away_team");
                            Log.i("info567", awayteam);

                            JSONObject JsonObject6 = new JSONObject(awayteam);
                            JSONArray jsonArrayaway = JsonObject6.getJSONArray("starting_lineups");
                            for (int d = 0; d < jsonArrayaway.length(); d++) {

                                JSONObject jsonObject8 = jsonArrayaway.getJSONObject(d);

                                Log.i("inko336", jsonObject8.getString("player"));
                                Log.i("inko336", jsonObject8.getString("player_number"));
                                String Ateamplayers = jsonObject8.getString("player");
                                String Ateamplayersnum = jsonObject8.getString("player_number");

                                data6 += Ateamplayers + "(" + Ateamplayersnum + ")" + '\n';
                            }
                            Log.i("infoline2", data6);


                            JSONArray jsonArrayhomesub = JsonObject5.getJSONArray("substitutes");
                            for (int q = 0; q < jsonArrayhomesub.length(); q++) {

                                JSONObject jsonObject9 = jsonArrayhomesub.getJSONObject(q);

                                Log.i("inko3378", jsonObject9.getString("player"));

                                String Hsubplayers = jsonObject9.getString("player");
                                data7 += Hsubplayers + '\n';

                            }
                            Log.i("infoline3", data7);
                            JSONArray jsonArrayawaysub = JsonObject6.getJSONArray("substitutes");
                            for (int w = 0; w < jsonArrayawaysub.length(); w++) {

                                JSONObject jsonObject10 = jsonArrayawaysub.getJSONObject(w);

                                Log.i("inko78", jsonObject10.getString("player"));
                                String Asubplayers = jsonObject10.getString("player");
                                data8 += Asubplayers + '\n';

                            }
                            Log.i("infoline4", data8);


                            listItem Item = new listItem(

                                    jsonObject1.getString("event_home_team"),
                                    jsonObject1.getString("event_status"),
                                    jsonObject1.getString("event_final_result"),
                                    jsonObject1.getString("event_away_team"),
                                    jsonObject1.getString("league_logo"),
                                    jsonObject1.getString("event_halftime_result"),
                                    jsonObject1.getString("event_home_formation"),
                                    jsonObject1.getString("event_away_formation"), data1,
                                    data2,
                                    data3,
                                    data4,
                                    data5, data6,
                                    data7, data8


                            );


                            listItems.add(Item);
                            Collections.reverse(listItems);

                            adapter.notifyDataSetChanged();


                        }

                    } catch (Exception e) {
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
    RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
        requestQueue.getCache().clear();


}



}



