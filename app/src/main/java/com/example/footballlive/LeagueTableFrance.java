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

public class LeagueTableFrance extends AppCompatActivity {
    public static String URL_DATA8 = "https://allsportsapi.com/api/football/?&met=Standings&leagueId=176&APIkey=dc2997f918b945d8cad80e1ad00e1f6d59bf75f84a77899d61f5902ea6cf945a";
    public BottomNavigationView btnnav8;
    public RecyclerView recyclerView8;
    public RecyclerView.Adapter adapter8;
    public List<ListTableFrance> listTableFrances;

    public void selectleague (View view){


        PopupMenu popupMenu = new PopupMenu(this,view);
        popupMenu.inflate(R.menu.popup);
        popupMenu.show();
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){

                    case R.id.item1:
                        Intent intent1 = new Intent(LeagueTableFrance.this,LeagueTable.class);
                        LeagueTableFrance.this.startActivity(intent1);
                        break;


                    case R.id.item2:
                        Intent intent2 = new Intent(LeagueTableFrance.this,LeagueTablesSpain.class);
                        LeagueTableFrance.this.startActivity(intent2);
                        break;


                    case R.id.item3:
                        Intent intent3 = new Intent(LeagueTableFrance.this,LeagueTableItaly.class);
                        LeagueTableFrance.this.startActivity(intent3);
                        break;

                    case R.id.item4:
                        Intent intent4 = new Intent(LeagueTableFrance.this,LeagueTableGermany.class);
                        LeagueTableFrance.this.startActivity(intent4);
                        break;
                    case R.id.item5:
                        Intent intent5 = new Intent(LeagueTableFrance.this, LeagueTableFrance.class);
                        LeagueTableFrance.this.startActivity(intent5);
                        break;

                }
                return true;
            }
        });




    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_league_table_france);
        btnnav8= findViewById(R.id.navbar568);
        recyclerView8 = findViewById(R.id.relative788);

        recyclerView8.setHasFixedSize(true);
        recyclerView8.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

         listTableFrances = new ArrayList<>();


        loadRecyclerView8();



        adapter8= new MyAdapter8(listTableFrances,getApplicationContext());
        recyclerView8.setAdapter(adapter8);

        btnnav8.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){

                    case R.id.live:
                        Intent intent1 = new Intent(LeagueTableFrance.this,MainActivity.class);
                        LeagueTableFrance.this.startActivity(intent1);
                        break;

                    case R.id.fixtures:
                        Intent intent2 = new Intent(LeagueTableFrance.this,UpcomingFixture.class);
                        LeagueTableFrance.this.startActivity(intent2);
                        break;

                    case R.id.Table:
                        Intent intent3 = new Intent(LeagueTableFrance.this, LeagueTable.class);
                        LeagueTableFrance.this.startActivity(intent3);
                        break;

                    case R.id.video:
                        Intent intent4 = new Intent(LeagueTableFrance.this,Higlights.class);
                        LeagueTableFrance.this.startActivity(intent4);
                        break;



                }
                return false;
            }
        });
        btnnav8.setItemIconTintList(null);
    }

    private void loadRecyclerView8() {
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading.....");
        progressDialog.show();
        StringRequest stringRequest8 = new StringRequest(URL_DATA8, new Response.Listener<String>() {
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


                        ListTableFrance listTableFrance = new ListTableFrance(
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
                        listTableFrances.add(listTableFrance);
                        adapter8.notifyDataSetChanged();

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

        RequestQueue requestQueue8 = Volley.newRequestQueue(this);
        requestQueue8.add(stringRequest8);
    }
}