package com.example.assignment;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    private static final String TAG = "MyAdapter";
    ArrayList<Countries> countries;
    private int[] images;
    Context context;


    public Adapter(Context ct, ArrayList<Countries> myDataSet, int[] pics) {
        //had to use this context thing to get Onclick to work
        context = ct;
        countries = myDataSet;
        images = pics;

    }


    public static class MyViewHolder extends RecyclerView.ViewHolder {


        TextView countryName;
        ImageView image;
        Button startQuiz;


        public MyViewHolder(View itemView) {
            super(itemView);

            countryName = itemView.findViewById(R.id.country);
            image = itemView.findViewById(R.id.image);
            startQuiz = itemView.findViewById((R.id.startQuiz));

        }
    }

    @NonNull
    @Override
    public Adapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(R.layout.row, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final Countries country = countries.get(position);

        int image_id = images[position];
        //String name = country.getCountry();

       // holder.countryName.setText(country.getCountry());
        holder.image.setImageResource(image_id);

        holder.startQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, quiz.class);
                context.startActivity(intent);
            }
        });

    }


    @Override
    public int getItemCount() {
        return countries.size();
    }

}
