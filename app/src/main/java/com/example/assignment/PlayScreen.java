package com.example.assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PlayScreen extends AppCompatActivity implements View.OnClickListener {

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

        Button options = findViewById(R.id.optBtn);
        options.setOnClickListener(this);


    }

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

            default:
                break;
        }
    }
}
