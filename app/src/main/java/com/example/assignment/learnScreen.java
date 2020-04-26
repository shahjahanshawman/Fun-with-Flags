package com.example.assignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;

import com.example.assignment.InfoFromAPI.MainInfo;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class learnScreen extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "fun with flags";
    public static final String TAG ="learnScreen";

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private Boolean wideScreen;
    List<MainInfo> info = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn_screen);
        //List<Countries> countries= Countries.getCountries();

        recyclerView = findViewById(R.id.List);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        new Task().execute();  //calling the API

        wideScreen = findViewById(R.id.countryInfo) != null;


        CountryAdapter.RecyclerViewClickListener listener = new CountryAdapter.RecyclerViewClickListener() {
            @Override
            public void onClick(View view, int position) {
                MainInfo toDisplay = info.get(position);
                if (wideScreen) {
                    final FragmentManager fragmentManager = getSupportFragmentManager();
                    FragmentTransaction transaction = fragmentManager.beginTransaction();
                    CountryInfoFragment fragment = new CountryInfoFragment();
                    Bundle arguments = new Bundle();
                    arguments.putSerializable("country",toDisplay);

                    fragment.setArguments(arguments);
                    transaction.replace(R.id.countryInfo, fragment);
                    transaction.commit();
                } else {
                    newActivity(toDisplay);
                }
            }
        };

        mAdapter = new CountryAdapter(new ArrayList<>(),listener);
        recyclerView.setAdapter(mAdapter);

    }

    public void newActivity(MainInfo country) {
        Intent intent = new Intent(this, CountryInfoActivity.class);
        intent.putExtra("country", new Gson().toJson(country));
        startActivity(intent);
    }




    ////https://stackoverflow.com/questions/42623437/parse-json-array-response-using-retrofit-gson
    //https://medium.com/@dds861/json-parsing-using-retrofit-and-recycleview-2300d9fdcf15
    //the api used returns a JSON array so used the above links to realise we have to use a list if...
    //response starts with a JSON Array


    private class Task extends AsyncTask<Void,Integer, Integer> {
        @Override
        protected Integer doInBackground(Void... voids) {
            Retrofit retrofit = new Retrofit.Builder().baseUrl("https://restcountries.eu")
                    .addConverterFactory(GsonConverterFactory.create()).build();

            APICall service = retrofit.create(APICall.class);
            Call<List<MainInfo>> countryCall = service.getAllCountries();
            Response<List<MainInfo>> response = null;
            try {
                response = countryCall.execute();
            } catch (IOException e) {
                e.printStackTrace();
            }

            info = response.body();


            return null;

        }

        @Override
        protected void onPostExecute(Integer integer) {
            super.onPostExecute(integer);
            ((CountryAdapter) mAdapter).setCountries(info);
        }
    }



}