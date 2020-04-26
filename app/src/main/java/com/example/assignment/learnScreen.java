package com.example.assignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.gson.Gson;

import java.util.List;

public class learnScreen extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "fun with flags";
    public static final String TAG ="learnScreen";

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private Boolean wideScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn_screen);
        List<Countries> countries= Countries.getCountries();

        recyclerView = findViewById(R.id.List);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        wideScreen = findViewById(R.id.countryInfo) != null;


        CountryAdapter.RecyclerViewClickListener listener = new CountryAdapter.RecyclerViewClickListener() {
            @Override
            public void onClick(View view, int position) {
                Countries toDisplay = countries.get(position);
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

        mAdapter = new CountryAdapter(Countries.getCountries(),listener);
        recyclerView.setAdapter(mAdapter);

    }

    public void newActivity(Countries country) {
        Intent intent = new Intent(this, CountryInfoActivity.class);
        intent.putExtra("country", new Gson().toJson(country));
        startActivity(intent);
    }
}