package com.example.assignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;

public class quiz extends AppCompatActivity {
    private static final String TAG = "quiz";
    private Adapter mAdapter;

    ArrayList<Countries> countries;
    private int[] images = {R.drawable.pic1, R.drawable.pic2, R.drawable.pic3, R.drawable.pic4, R.drawable.pic5,
            R.drawable.pic6, R.drawable.pic7, R.drawable.pic8};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        countries = Countries.getCountries();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        RecyclerView rView = findViewById(R.id.recycler_view);
        rView.setHasFixedSize(true);
        rView.setLayoutManager(new LinearLayoutManager(this));


        mAdapter = new Adapter(this, countries, images);
        rView.setAdapter(mAdapter);
    }

    private void clickResponse(int position) {
        Log.d(TAG, "clickResponse: pressed " + position);

        Countries country = countries.get(position);

    }
}
