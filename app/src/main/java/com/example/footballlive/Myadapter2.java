package com.example.footballlive;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

class Myadapter2 extends RecyclerView.Adapter<Myadapter2.ViewHolder> {

    public List<ListItemFixture> listItemFixtures;
    public Context context2;

    public Myadapter2(List<ListItemFixture> listItemFixtures, Context context2) {
        this.listItemFixtures = listItemFixtures;
        this.context2 = context2;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.example2,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ListItemFixture listItemFixture = listItemFixtures.get(position);
        holder.textView1.setText(listItemFixture.getHometeam());
        holder.textView2.setText(listItemFixture.getAwayteam());
        holder.textView3.setText(listItemFixture.getFinalresult());
        holder.textView4.setText(listItemFixture.getLeague());
        holder.textView5.setText(listItemFixture.getHalftime());
        holder.textView6.setText(listItemFixture.getDate());
        holder.textView7.setText(listItemFixture.getHgoalscorers());
        holder.textView8.setText(listItemFixture.getAgoalscorers());
        Picasso.with(context2).load(listItemFixture.getHomelogo()).into(holder.imageView1);
        Picasso.with(context2).load(listItemFixture.getAwaylogo()).into(holder.imageView2);

    }

    @Override
    public int getItemCount() {
        return listItemFixtures.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView textView1;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        TextView textView5;
        TextView textView6;
        TextView textView7;
        TextView textView8;
        ImageView imageView1;
        ImageView imageView2;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView1 = itemView.findViewById(R.id.hname);
            textView2 = itemView.findViewById(R.id.aname);
            textView3 = itemView.findViewById(R.id.score);
            textView4 = itemView.findViewById(R.id.league);
            textView5 = itemView.findViewById(R.id.htscore);
            textView6 = itemView.findViewById(R.id.date);
            textView7 = itemView.findViewById(R.id.hgoalscorer);
            textView8 = itemView.findViewById(R.id.agoalscorer);
            imageView1=itemView.findViewById(R.id.hlogo);
            imageView2=itemView.findViewById(R.id.alogo);
        }
    }






}
