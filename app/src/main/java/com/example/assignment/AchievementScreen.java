package com.example.assignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class AchievementScreen extends AppCompatActivity implements View.OnClickListener {
    AchievementDatabase achievementDatabase;
    TextView first,second,third,fourth,fifth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_achievement_screen);
        Button back = findViewById(R.id.back);
        back.setOnClickListener(this);
        achievementDatabase = Room.databaseBuilder(getApplicationContext(), AchievementDatabase.class, "myDB")
                .build();
        new InsertScore().execute();

        first = findViewById(R.id.p1);
        second = findViewById(R.id.p2);
        third = findViewById(R.id.p3);
        fourth = findViewById(R.id.p4);
        fifth = findViewById(R.id.p5);
    }

    @Override
    public void onClick(View v) {
        Intent back = new Intent(this, PlayScreen.class);
        startActivity(back);
    }

    private class InsertScore extends AsyncTask<Void,Void, List<Achievement>> {
        @Override
        protected List<Achievement> doInBackground(Void... voids) {

            List<Achievement> newList =achievementDatabase.achievementDAO().getScores();
            return newList;
        }

        @Override
        protected void onPostExecute(List<Achievement> strings) {
            super.onPostExecute(strings);
            first.setText(strings.get(0).getScore());
            second.setText(strings.get(1).getScore());
            third.setText(strings.get(2).getScore());
            fourth.setText(strings.get(3).getScore());
            fifth.setText(strings.get(4).getScore());


        }
    }
}
