package com.example.assignment;


import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.assignment.InfoFromAPI.MainInfo;

import java.util.ArrayList;
import java.util.List;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.CountryViewHolder> {

    private static final String TAG = "CountryAdapter";

    //mCountries contain data from the API call
    private ArrayList<MainInfo> mCountries;
    private RecyclerViewClickListener mListener;


    public CountryAdapter(ArrayList<MainInfo> countries, RecyclerViewClickListener listener) {
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

        MainInfo countries = mCountries.get(position);
        holder.countryName.setText(countries.getName());
        holder.countryFlag.setImageResource(R.drawable.missing_flag);

        String url ="https://www.countries-ofthe-world.com/flags-normal/flag-of-";
        String forImage = countries.getName();

        //link from where flag images are being taken--->https://www.countries-ofthe-world.com/flags-of-the-world.html
        //customising the country name according to link on the site
        if(forImage.contains(" ")){
            forImage=forImage.replace(" ", "-");
        }


        url= url+forImage+".png";
        Log.d(TAG, url+" in adapter");
        Glide.with(holder.itemView).load(url)
                .error(R.drawable.missing_flag)        //if cannot load the image, load a missing_flag image
                        .into(holder.countryFlag);


    }


    @Override
    public int getItemCount() {
        return mCountries.size();
    }

    public void setCountries(List<MainInfo> newSet) {
        mCountries.clear();
        mCountries.addAll(newSet) ;
        notifyDataSetChanged();
    }
}