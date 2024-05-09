package com.example.newsapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    Context context;
    ArrayList<ModelClass> modelClassArrayList;

    public Adapter(Context context, ArrayList<ModelClass> modelClassArrayList) {
        this.context = context;
        this.modelClassArrayList = modelClassArrayList;
    }

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.layout_item, null,false );
        return  new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {
        final int positionFinal = position;

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, webView.class);
                intent.putExtra("url", modelClassArrayList.get(positionFinal).getUrl());
                context.startActivity(intent);
            }
        });

        holder.mtime.setText("Published At:-"+modelClassArrayList.get(position).getPublishedAt());
        holder.mauthur.setText(modelClassArrayList.get(position).getAuthor());
        holder.mheading.setText(modelClassArrayList.get(position).getTitle());
        holder.mcontent.setText(modelClassArrayList.get(position).getDescription());
        Glide.with(context).load(modelClassArrayList.get(position).getUrlToImage()).into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return modelClassArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView mheading, mcontent, mauthur, mtime;
        CardView cardView;
        ImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mheading=itemView.findViewById(R.id.mainheading);
            mcontent=itemView.findViewById(R.id.content);
            mauthur=itemView.findViewById(R.id.author);
            mtime=itemView.findViewById(R.id.time);
            imageView=itemView.findViewById(R.id.imageview);
            cardView=itemView.findViewById(R.id.cardview);


        }
    }
}
