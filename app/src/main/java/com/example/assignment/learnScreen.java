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

        new Task().execute();

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

            info=response.body();
//            String toAdd = response.body().toString();
//            Type listType = new TypeToken<List<MainInfo>>() {}.getType();
            //info = Gson(toAdd, listType);
//            for(int i=0;i<response.body().size();i++) {
//                info
//            }
//            //String jsonString = response.body().toString();
////            Type listType = new TypeToken<List<MainInfo>>() {}.getType();
////            info = new Gson().fromJson(jsonString, listType);
//            for(int i=0;i<response.body().size();i++){
//                String jsonString = response.body().toString();
//                Type listType = new TypeToken<List<MainInfo>>() {}.getType();
//                info = new Gson().fromJson(jsonString, listType);
//                //info.addAll(response.body().get());
//            }

            return null;

        }

        @Override
        protected void onPostExecute(Integer integer) {
            super.onPostExecute(integer);
            ((CountryAdapter) mAdapter).setCountries(info);
        }
    }



}