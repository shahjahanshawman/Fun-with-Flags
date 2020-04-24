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
                Intent level1 = new Intent(this, Level1Quiz.class);
                startActivity(level1);
                break;
            case R.id.level2:
                Intent level2 = new Intent(this, Level2Quiz.class);
                startActivity(level2);
                break;
            case R.id.level3:
                Intent level3 = new Intent(this, Level3Quiz.class);
                startActivity(level3);
                break;

            default:
                break;
        }
    }
}
