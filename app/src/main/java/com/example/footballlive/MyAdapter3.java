package com.example.footballlive;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

class MyAdapter3 extends RecyclerView.Adapter<MyAdapter3.ViewHolder> {
    public List<ListTable> listTables;
    public Context context;

    public MyAdapter3(List<ListTable> listTables, Context context) {
        this.listTables = listTables;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.example3,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ListTable listtable =listTables.get(position);

        holder.text1.setText(listtable.position);
        holder.text2.setText(listtable.team);
        holder.text3.setText(listtable.played);
        holder.text4.setText(listtable.won);
        holder.text5.setText(listtable.draw);
        holder.text6.setText(listtable.lost);
        holder.text7.setText(listtable.gd);
        holder.text8.setText(listtable.pts);

    }

    @Override
    public int getItemCount() {
        return listTables.size();
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
            text1=(TextView) itemView.findViewById(R.id.place);
            text2=(TextView) itemView.findViewById(R.id.team);
            text3=(TextView) itemView.findViewById(R.id.play);
            text4=(TextView) itemView.findViewById(R.id.win);
            text5=(TextView)itemView.findViewById(R.id.draw);
            text6=(TextView)itemView.findViewById(R.id.lost);
            text7=(TextView)itemView.findViewById(R.id.goaldf);
            text8=(TextView)itemView.findViewById(R.id.points);
        }
    }
}
