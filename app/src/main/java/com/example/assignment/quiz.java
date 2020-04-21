package com.example.assignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class quiz extends AppCompatActivity {
    private static final String TAG = "quiz";
    private Adapter mAdapter;
    List<Countries> countries;
    private Random randomGenerator=  new Random();
    ImageView fg = findViewById(R.id.flag);
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        ImageView fg = findViewById(R.id.flag);
        new MyTask().execute();


    }

    private class MyTask extends AsyncTask<Void, Integer,Integer> {

        @Override
        protected Integer doInBackground(Void... voids) {

            Retrofit retrofit = new Retrofit.Builder().baseUrl("https://restcountries.eu/")
                    .addConverterFactory(GsonConverterFactory.create()).build();

            FlagAPI service = retrofit.create(FlagAPI.class);
            Call<CountryResponse> countryCall = service.getAllCountries();

            //gets all the countries
            Response<CountryResponse> response = null;
            try {
                response = countryCall.execute();
            } catch (IOException e) {
                e.printStackTrace();
            }

            countries = response.body().getData();
            //getting a random country
            int index = randomGenerator.nextInt(countries.size());
            Countries cnt = countries.get(index);
            //getting the string for the flag image(the link is stored as an image)
            String flag = cnt.getFlag();
            flag = flag +".svg";

            //using the link to do an API call to get the image
            Call<Integer> flagCall = service.getFlag(flag);

            Response<Integer> flagResponse = null;
            try {
                flagResponse = flagCall.execute();
            } catch (IOException e) {
                e.printStackTrace();
            }
            //storing the image as a int
            int flagImage = flagResponse.body();

            //setting the image
            fg.setImageResource(flagImage);

            return null;
        }



        @Override
        protected void onPostExecute(Integer integer) {

            super.onPostExecute(integer);
        }
    }
}
