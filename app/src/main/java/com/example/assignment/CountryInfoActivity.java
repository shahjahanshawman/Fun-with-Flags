package com.example.assignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;

import com.example.assignment.InfoFromAPI.MainInfo;
import com.google.gson.Gson;

public class CountryInfoActivity extends AppCompatActivity {

    MainInfo toDisplay;
    //when using smaller screen learnScreen activates this activity and then goes to CountryInfoFragment

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_info);
        String jsonMyObject;
        Intent i = getIntent();
        if(i.getExtras() != null) {
            Bundle extras = i.getExtras();
            jsonMyObject = extras.getString("country");
            toDisplay = new Gson().fromJson(jsonMyObject, MainInfo.class);

        }



        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        Fragment fragment = new CountryInfoFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("country", toDisplay);
        fragment.setArguments(bundle);
        transaction.replace(R.id.scrollActivity, fragment);
        transaction.commit();

    }
}