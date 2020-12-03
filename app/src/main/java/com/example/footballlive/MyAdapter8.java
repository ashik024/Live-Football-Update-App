package com.example.footballlive;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

class MyAdapter8 extends RecyclerView.Adapter<MyAdapter8.ViewHolder> {

    public List<ListTableFrance> listTableFrances;
    public Context context;

    public MyAdapter8(List<ListTableFrance> listTableFrances, Context context) {
        this.listTableFrances = listTableFrances;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.example8,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        ListTableFrance listTableFrance = listTableFrances.get(position);

        holder.text1.setText(listTableFrance.positionF);
        holder.text2.setText(listTableFrance.teamF);
        holder.text3.setText(listTableFrance.playedF);
        holder.text4.setText(listTableFrance.wonF);
        holder.text5.setText(listTableFrance.drawF);
        holder.text6.setText(listTableFrance.lostF);
        holder.text7.setText(listTableFrance.gdF);
        holder.text8.setText(listTableFrance.ptsF);


    }

    @Override
    public int getItemCount() {
        return listTableFrances.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView text1;
        public TextView text2;
        public TextView text3;
        public TextView text4;
        public TextView text5;
        public TextView text6;
        public TextView text7;
        public TextView text8;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            text1=(TextView) itemView.findViewById(R.id.place8);
            text2=(TextView) itemView.findViewById(R.id.team8);
            text3=(TextView) itemView.findViewById(R.id.play8);
            text4=(TextView) itemView.findViewById(R.id.win8);
            text5=(TextView)itemView.findViewById(R.id.draw8);
            text6=(TextView)itemView.findViewById(R.id.lost8);
            text7=(TextView)itemView.findViewById(R.id.goaldf8);
            text8=(TextView)itemView.findViewById(R.id.points8);
        }
    }
}
