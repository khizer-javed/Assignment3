package com.example.khizzipool.assignment3;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder>
{
    private Context mcontext;
    private ArrayList<item> mitems;

    public RecyclerAdapter(Context mcontext, ArrayList<item> mitems) {
        this.mcontext = mcontext;
        this.mitems = mitems;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mcontext).inflate(R.layout.item,parent,false);
        return new RecyclerViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder recyclerViewHolder, int position) {
        item currentItem = mitems.get(position);
        String imageurl = currentItem.getmImageUrl();
        String CreatorName = currentItem.getmCreator();
        int Likescount = currentItem.getmLikes();

        recyclerViewHolder.mtextViewCreator.setText(CreatorName);
        recyclerViewHolder.mtextViewLikes.setText("Likes: " + Likescount);
        Picasso.with(mcontext).load(imageurl).fit().centerInside().into(recyclerViewHolder.mimageView);
    }

    @Override
    public int getItemCount() {
        return mitems.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder
    {
        public ImageView mimageView;
        public TextView mtextViewCreator;
        public TextView mtextViewLikes;

        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            mimageView = itemView.findViewById(R.id.Image);
            mtextViewCreator = itemView.findViewById(R.id.CreatorText);
            mtextViewLikes = itemView.findViewById(R.id.Likestext);
        }
    }
}
