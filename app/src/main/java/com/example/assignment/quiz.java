package com.example.assignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class quiz extends AppCompatActivity {
    private static final String TAG = "quiz";
    private Adapter mAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        new MyTask().execute();


    }

    private class MyTask extends AsyncTask<Void, Integer,Integer> {

        @Override
        protected Integer doInBackground(Void... voids) {

            Retrofit retrofit = new Retrofit.Builder().baseUrl("https://restcountries.eu/")
                    .addConverterFactory(GsonConverterFactory.create()).build();

            FlagAPI service = retrofit.create(FlagAPI.class);
            Call<Countries> countryCall = service.;
            return null;
        }



        @Override
        protected void onPostExecute(Integer integer) {

            super.onPostExecute(integer);
        }
    }
}
