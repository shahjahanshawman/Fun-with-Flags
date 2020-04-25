package com.example.assignment;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.CountryViewHolder> {

    private static final String TAG = "CountryAdapter";


    private ArrayList<Countries> mCountries;
    private RecyclerViewClickListener mListener;


    public CountryAdapter(ArrayList<Countries> countries, RecyclerViewClickListener listener) {
        mCountries = countries;
        mListener = listener;

    }

    public interface RecyclerViewClickListener {
        void onClick(View view, int position);
    }

    public class CountryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView countryName;
        private ImageView countryFlag;


        public CountryViewHolder(View v, RecyclerViewClickListener listener) {
            super(v);

            mListener = listener;
            v.setOnClickListener(this);
            countryName = itemView.findViewById(R.id.countryName);
            countryFlag = itemView.findViewById(R.id.countryFlag);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick (View view) {
            int position = getAdapterPosition();
            mListener.onClick(view, getAdapterPosition());
        }
    }


    @Override
    public CountryAdapter.CountryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v =LayoutInflater.from(parent.getContext()).inflate(R.layout.countries, parent, false);
        return new CountryViewHolder(v, mListener);
    }

    //Override the onBindViewHolder method to be able to access widgets inside the view
    @Override
    public void onBindViewHolder(CountryViewHolder holder, int position) {

        Countries countries = mCountries.get(position);
        holder.countryName.setText(countries.getAnswers());
        holder.countryFlag.setImageResource(countries.getFlag());
    }


    @Override
    public int getItemCount() {
        return mCountries.size();
    }

}
