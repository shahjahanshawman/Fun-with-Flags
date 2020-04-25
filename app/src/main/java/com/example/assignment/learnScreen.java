package com.example.assignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

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

        recyclerView = findViewById(R.id.List);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        wideScreen = findViewById(R.id.countryInfo) != null;


        CountryAdapter.RecyclerViewClickListener listener = new CountryAdapter.RecyclerViewClickListener() {
            @Override
            public void onClick(View view, int position) {
                if (wideScreen) {
                    final FragmentManager fragmentManager = getSupportFragmentManager();
                    FragmentTransaction transaction = fragmentManager.beginTransaction();
                    Bundle arguments = new Bundle();
                    arguments.putInt("position",position);
                    CountryInfoFragment fragment = new CountryInfoFragment();
                    fragment.setArguments(arguments);
                    transaction.replace(R.id.countryInfo, fragment);
                    transaction.commit();
                } else {
                    newActivity(position);
                }
            }
        };

        mAdapter = new CountryAdapter(Countries.getCountries(),listener);
        recyclerView.setAdapter(mAdapter);

    }

    public void newActivity(int position) {
        Intent intent = new Intent(this, CountryInfoActivity.class);
        intent.putExtra(EXTRA_MESSAGE, position);
        startActivity(intent);
    }
}
