package com.example.assignment;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    //set timer 3000 = 2 seconds
    private static int SPLASH_SCREEN = 2000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "Reached onCreate Main");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // creates handler to set a timer to go to the play screen
        new Handler().postDelayed(new Runnable () {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this,PlayScreen.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_SCREEN);
    }
}
