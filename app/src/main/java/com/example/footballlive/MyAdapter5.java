package com.example.footballlive;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

class MyAdapter5 extends RecyclerView.Adapter<MyAdapter5.ViewHolder> {
    public List<ListTableSpain> listTableSpains;
    public Context context;

    public MyAdapter5(List<ListTableSpain> listTableSpains, Context context) {
        this.listTableSpains = listTableSpains;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.example5,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ListTableSpain listTableSpain = listTableSpains.get(position);

        holder.text1.setText(listTableSpain.positionS);
        holder.text2.setText(listTableSpain.teamS);
        holder.text3.setText(listTableSpain.playedS);
        holder.text4.setText(listTableSpain.wonS);
        holder.text5.setText(listTableSpain.drawS);
        holder.text6.setText(listTableSpain.lostS);
        holder.text7.setText(listTableSpain.gdS);
        holder.text8.setText(listTableSpain.ptsS);

    }

    @Override
    public int getItemCount() {
        return listTableSpains.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

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
            text1=(TextView) itemView.findViewById(R.id.place5);
            text2=(TextView) itemView.findViewById(R.id.team5);
            text3=(TextView) itemView.findViewById(R.id.play5);
            text4=(TextView) itemView.findViewById(R.id.win5);
            text5=(TextView)itemView.findViewById(R.id.draw5);
            text6=(TextView)itemView.findViewById(R.id.lost5);
            text7=(TextView)itemView.findViewById(R.id.goaldf5);
            text8=(TextView)itemView.findViewById(R.id.points5);
        }
    }
}
