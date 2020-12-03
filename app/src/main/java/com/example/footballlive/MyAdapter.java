package com.example.footballlive;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>  {
    private List<listItem> listItems;

    private Context context;


    public MyAdapter(List<listItem> listItems,Context context) {
        this.listItems = listItems;



        this.context = context;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.example1,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final listItem listItem= listItems.get(position);

        holder.text1.setText(listItem.heading);
        holder.text2.setText(listItem.description);
        holder.text3.setText(listItem.heading2);
        holder.text4.setText(listItem.heading3);



        Picasso.with(context).load(listItem.getImageURL()).into(holder.image);
        holder.relative_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String matchresult= listItem.getHeading2();
                String awayTeam= listItem.getHeading3();
                String homeTeam= listItem.getHeading();
                String matchtime= listItem.getDescription();
                String imageLeague= listItem.getImageURL();
                String halfTime= listItem.getHalfTime();

                String hformation= listItem.getHomeFormation();
                String aformation= listItem.getAwayFormation();
                String scorerH= listItem.gethScore();
                String scorerA= listItem.getaScore();
                String cardH= listItem.getCardH();
                String cardA= listItem.getCardA();
                String homeline= listItem.getLineupH();
                String awayline= listItem.getLineupA();
                String homesub= listItem.getSubH();
                String awaysub= listItem.getSubA();

                Intent  intent= new Intent(v.getContext(),detaileScore.class);
                intent.putExtra("event_status",matchresult);
                intent.putExtra("event_status2",matchtime);
                intent.putExtra("event_home_team",homeTeam);
                intent.putExtra("event_away_team",awayTeam);
                intent.putExtra("league_logo",imageLeague);
                intent.putExtra("event_halftime_result",halfTime);

                intent.putExtra("event_home_formation",hformation);
                intent.putExtra("event_away_formation",aformation);
                intent.putExtra("data1",scorerH);
                intent.putExtra("data2",scorerA);
                intent.putExtra("data3",cardH);
                intent.putExtra("data4",cardA);
                intent.putExtra("data5",homeline);
                intent.putExtra("data6",awayline);
                intent.putExtra("data7",homesub);
                intent.putExtra("data8",awaysub);



                v.getContext().startActivities(new Intent[]{intent});



            }
        });


    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }




    public class ViewHolder extends RecyclerView.ViewHolder{

            public TextView text1;
            public TextView text2;
            public TextView text3;
            public TextView text4;
            public ImageView image;
            public RelativeLayout relative_layout;
        public TextView text5;
        public TextView text6;
        public TextView text7;
        public TextView text8;
        public TextView text9;
        public TextView text10;
        public TextView text11;
        public TextView text12;
        public TextView text13;
        public TextView text14;
        public TextView text15;



        public ViewHolder(@NonNull View itemView) {
            super(itemView);
           text1=(TextView) itemView.findViewById(R.id.textView11);
            text2=(TextView) itemView.findViewById(R.id.textView22);
            text3=(TextView) itemView.findViewById(R.id.textView33);
            text4=(TextView) itemView.findViewById(R.id.textView44);
            image=(ImageView) itemView.findViewById(R.id.image33);
            relative_layout=(RelativeLayout) itemView.findViewById(R.id.relativeLayout);
            text5=(TextView)itemView.findViewById(R.id.texthalf);
            text6=(TextView)itemView.findViewById(R.id.textHome);
            text7=(TextView)itemView.findViewById(R.id.textaway);
            text8=(TextView)itemView.findViewById(R.id.textHomecard);
            text9=(TextView)itemView.findViewById(R.id.textawaycard);
            text10=(TextView)itemView.findViewById(R.id.textHome);
            text11=(TextView)itemView.findViewById(R.id.textaway);
            text12=(TextView)itemView.findViewById(R.id.playerHome);
            text13=(TextView)itemView.findViewById(R.id.playerAway);
            text14=(TextView)itemView.findViewById(R.id.subHome);
            text15=(TextView)itemView.findViewById(R.id.subAway);



        }
    }




}
