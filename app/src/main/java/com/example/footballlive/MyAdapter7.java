package com.example.footballlive;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

class MyAdapter7 extends RecyclerView.Adapter<MyAdapter7.ViewHolder> {

    public List<ListTableGermany> listTableGermanies;
    public Context context;

    public MyAdapter7(List<ListTableGermany> listTableGermanies, Context context) {
        this.listTableGermanies = listTableGermanies;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.example7,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ListTableGermany listTableGermany = listTableGermanies.get(position);

        holder.text1.setText(listTableGermany.positionG);
        holder.text2.setText(listTableGermany.teamG);
        holder.text3.setText(listTableGermany.playedG);
        holder.text4.setText(listTableGermany.wonG);
        holder.text5.setText(listTableGermany.drawG);
        holder.text6.setText(listTableGermany.lostG);
        holder.text7.setText(listTableGermany.gdG);
        holder.text8.setText(listTableGermany.ptsG);

    }

    @Override
    public int getItemCount() {
        return listTableGermanies.size();
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
            text1=(TextView) itemView.findViewById(R.id.place7);
            text2=(TextView) itemView.findViewById(R.id.team7);
            text3=(TextView) itemView.findViewById(R.id.play7);
            text4=(TextView) itemView.findViewById(R.id.win7);
            text5=(TextView)itemView.findViewById(R.id.draw7);
            text6=(TextView)itemView.findViewById(R.id.lost7);
            text7=(TextView)itemView.findViewById(R.id.goaldf7);
            text8=(TextView)itemView.findViewById(R.id.points7);
        }
    }
}
