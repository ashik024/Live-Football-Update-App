package com.example.footballlive;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONObject;

public class detaileScore extends AppCompatActivity {

    public static String URL_DATA2="https://allsportsapi.com/api/football/?met=Livescore&APIkey=dc2997f918b945d8cad80e1ad00e1f6d59bf75f84a77899d61f5902ea6cf945a";

    TextView hometeam;
    TextView awayteam;
    ImageView leagueimage;
    TextView scoreft;
    TextView scoreht;
    TextView homescorer;
    TextView awaydcorer;
    TextView homepcard;
    TextView awaypcard;
    TextView homeformation;
    TextView awayformation;
    TextView time;
    TextView homeLineUP;
    TextView awayLineUP;
    TextView homesubstitute;
    TextView awaysubstitute;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detaile_score);
        hometeam=findViewById(R.id.hometeamname);
         awayteam=findViewById(R.id.awayteamname);
         leagueimage=findViewById(R.id.image77);
         scoreft=findViewById(R.id.scoreText);
         scoreht=findViewById(R.id.texthalf);
        homescorer=findViewById(R.id.textHome);
        awaydcorer=findViewById(R.id.textaway);
        homepcard=findViewById(R.id.textHomescore);
        awaypcard=findViewById(R.id.textawayscore);
        homeformation=findViewById(R.id.textHomecard);
        awayformation=findViewById(R.id.textawaycard);
        time=findViewById(R.id.time);
        homeLineUP=findViewById(R.id.playerHome);
        awayLineUP=findViewById(R.id.playerAway);
        homesubstitute=findViewById(R.id.subHome);
        awaysubstitute=findViewById(R.id.subAway);


        Intent intent=getIntent();
        Bundle extra= intent.getExtras();
        if(extra != null){
            String currentScore = extra.getString("event_status");
            scoreft.setText(currentScore);
            String currenthteam = extra.getString("event_home_team");
            hometeam.setText(currenthteam);
            String currentateam = extra.getString("event_away_team");
            awayteam.setText(currentateam);
            String currenttime = extra.getString("event_status2");
            time.setText(currenttime+"'");
            String currentleageimg = extra.getString("league_logo");
            Picasso.with(this).load(currentleageimg).into(leagueimage);
            String halfftime = extra.getString("event_halftime_result");
            scoreht.setText("HT:"+halfftime);
            String formationh = extra.getString("event_home_formation");
            homeformation.setText(formationh);
            String formationy = extra.getString("event_away_formation");
            awayformation.setText(formationy);
            String homeScor = extra.getString("data1");
            homescorer.setText(homeScor);
            String awayscor = extra.getString("data2");
            awaydcorer.setText(awayscor);
            String homecard = extra.getString("data3");
            homepcard.setText(homecard);

            String awaycard = extra.getString("data4");
            awaypcard.setText(awaycard);

            String homeplayerline = extra.getString("data5");
            homeLineUP.setText(homeplayerline);
            String awayplaerline = extra.getString("data6");
            awayLineUP.setText(awayplaerline);
            String hsub = extra.getString("data7");
            homesubstitute.setText(hsub);
            String asub = extra.getString("data8");
            awaysubstitute.setText(asub);



        }




    }


}