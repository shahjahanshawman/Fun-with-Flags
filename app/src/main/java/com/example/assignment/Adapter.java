package com.example.assignment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    private static final String TAG = "MyAdapter";
    ArrayList<Countries> countries;
    private int[] images;



    public Adapter(ArrayList<Countries> myDataSet, int[] pics) {

        countries = myDataSet;
        images = pics;

    }



    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {


        TextView countryName;
        ImageView image;
        Button startQuiz;

        public MyViewHolder(View itemView) {
            super(itemView);

            countryName = itemView.findViewById(R.id.country);
            image = itemView.findViewById(R.id.image);
            startQuiz = itemView.findViewById((R.id.startQuiz));
            startQuiz.setOnClickListener(this);
        }


        @Override
        public void onClick(View v) {

        }
    }

    @NonNull
    @Override
    public Adapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final Countries country = countries.get(position);

        int image_id = images[position];
        String name= country.getCountry();

        holder.countryName.setText(country.getCountry());
        holder.image.setImageResource(image_id);

    }




   

    @Override
    public int getItemCount() {
        return countries.size();
    }

}
