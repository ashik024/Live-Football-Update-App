package com.example.footballlive;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

class MyAdapter6 extends RecyclerView.Adapter<MyAdapter6.ViewHolder> {
    public List<ListTableItaly>listTableItalies;
    public Context context;

    public MyAdapter6(List<ListTableItaly> listTableItalies, Context context) {
        this.listTableItalies = listTableItalies;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.example6,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ListTableItaly listTableItaly = listTableItalies.get(position);

        holder.text1.setText(listTableItaly.positionI);
        holder.text2.setText(listTableItaly.teamI);
        holder.text3.setText(listTableItaly.playedI);
        holder.text4.setText(listTableItaly.wonI);
        holder.text5.setText(listTableItaly.drawI);
        holder.text6.setText(listTableItaly.lostI);
        holder.text7.setText(listTableItaly.gdI);
        holder.text8.setText(listTableItaly.ptsI);


    }

    @Override
    public int getItemCount() {
        return listTableItalies.size();
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
            text1=(TextView) itemView.findViewById(R.id.place6);
            text2=(TextView) itemView.findViewById(R.id.team6);
            text3=(TextView) itemView.findViewById(R.id.play6);
            text4=(TextView) itemView.findViewById(R.id.win6);
            text5=(TextView)itemView.findViewById(R.id.draw6);
            text6=(TextView)itemView.findViewById(R.id.lost6);
            text7=(TextView)itemView.findViewById(R.id.goaldf6);
            text8=(TextView)itemView.findViewById(R.id.points6);
        }
    }
}
