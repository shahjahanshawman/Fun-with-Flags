package com.example.assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class selectLevel extends AppCompatActivity implements View.OnClickListener {

    Button level1, level2, level3, back;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_level);

        back = findViewById(R.id.back);
        back.setOnClickListener(this);

        level1 = findViewById(R.id.level1);
        level1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.back:
                Intent back = new Intent(this, PlayScreen.class);
                startActivity(back);
                break;

            case R.id.level1:
                Intent level1 = new Intent(this, quiz.class);
                startActivity(level1);
                break;

            default:
                break;
        }
    }
}
