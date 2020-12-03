package com.example.footballlive;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;



import java.util.List;

public class Myadapter4 extends RecyclerView.Adapter<Myadapter4.ViewHolder> {

     List<ListHighlights> listHighlights;
     Context context4;

    public Myadapter4(List<ListHighlights> listHighlights, Context context4) {
        this.listHighlights = listHighlights;
        this.context4 = context4;
    }

    @NonNull
     @Override
     public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
         View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.example4,parent,false);
         return new ViewHolder(v);
     }

     @Override
     public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
         final ListHighlights listHighlight =listHighlights.get(position);
         holder.textView1.setText(listHighlight.getTitle1());
         holder.textView2.setText(listHighlight.getTitle2());
         holder.videoView.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {

                    String url =listHighlight.getVideoURL();
                 Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse(url));


                 v.getContext().startActivity(intent);

             }
         });




     }

     @Override
     public int getItemCount() {
         return listHighlights.size();
     }

     public class ViewHolder extends RecyclerView.ViewHolder{

         TextView textView1;
         TextView textView2;
         VideoView videoView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView1 = (TextView) itemView.findViewById(R.id.textVideo2);
            textView2 = (TextView) itemView.findViewById(R.id.textVideo1);
            videoView =(VideoView) itemView.findViewById(R.id.videoView);

        }
    }


}
