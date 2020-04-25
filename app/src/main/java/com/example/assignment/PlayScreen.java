package com.example.assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PlayScreen extends AppCompatActivity implements View.OnClickListener {

    //play screen will act as the menu screen

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_screen);

        Button play = findViewById(R.id.playBtn);
        play.setOnClickListener(this);

        Button learn = findViewById(R.id.lrnBtn);
        learn.setOnClickListener(this);

        Button achievements = findViewById(R.id.achBtn);
        achievements.setOnClickListener(this);

        Button help = findViewById(R.id.helpBtn);
        help.setOnClickListener(this);


    }

    // switch for onclick buttons
    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.playBtn:
                Intent playIntent = new Intent(this, selectLevel.class);
                startActivity(playIntent);
                break;

            case R.id.helpBtn:
                Intent btnIntent = new Intent(this, helpScreen.class);
                startActivity(btnIntent);
                break;

            case R.id.achBtn:
                Intent achIntent = new Intent(this, AchievementScreen.class);
                startActivity(achIntent);
                break;

            case R.id.lrnBtn:
                Intent lrnIntent = new Intent(this, learnScreen.class);
                startActivity(lrnIntent);
                break;

            default:
                break;
        }
    }
}
