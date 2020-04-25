package com.example.assignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import static android.view.View.*;

public class AchievementScreen extends AppCompatActivity  {
    private static final String TAG = "achievement";
    AchievementDatabase achievementDatabase;
    TextView first,second,third;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_achievement_screen);

        achievementDatabase = Room.databaseBuilder(getApplicationContext(), AchievementDatabase.class, "myDB")
                .build();
        new InsertScore().execute();

        first = findViewById(R.id.p1);

        second = findViewById(R.id.p2);
        third = findViewById(R.id.p3);

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

            int count = strings.size();

            for(int i=0;i<count;i++){
                if(strings.get(i).getLevel()==1){
                    first.setText(strings.get(i).getScore());
                }
            }

            for(int i=0;i<count;i++){
                if(strings.get(i).getLevel()==2){
                    second.setText(strings.get(i).getScore());
                }
            }

            for(int i=0;i<count;i++){
                if(strings.get(i).getLevel()==3){
                    third.setText(strings.get(i).getScore());
                }
            }

//            switch(count){
//                case 1:
//
//                    Log.d(TAG, "1 " +strings.get(0).getScore());
//                    first.setText(strings.get(0).getScore());
//                    break;
//                case 2:
//                    Log.d(TAG, "2 " +strings.get(0).getScore()+" "+ strings.get(1).getScore());
//                    first.setText(strings.get(0).getScore());
//                    second.setText(strings.get(1).getScore());
//                    break;
//                case 3:
//                    Log.d(TAG, "3 " +strings.get(0).getScore()+" "+ strings.get(1).getScore()+" "+ strings.get(2).getScore());
//                    first.setText(strings.get(0).getScore());
//                    second.setText(strings.get(1).getScore());
//                    third.setText(strings.get(2).getScore());
//                    break;
//                case 4:
//                    Log.d(TAG, "4 " +strings.get(0).getScore()+" "+ strings.get(1).getScore()+" "+ strings.get(2).getScore()+" "+ strings.get(3).getScore());
//                    first.setText(strings.get(0).getScore());
//                    second.setText(strings.get(1).getScore());
//                    third.setText(strings.get(2).getScore());
//
//                    break;
//                case 5:
//                    Log.d(TAG, "5 " +strings.get(0).getScore()+" "+ strings.get(1).getScore()+" "+ strings.get(2).getScore()+" "+ strings.get(3).getScore()+" "+ strings.get(4).getScore());
//                    first.setText(strings.get(0).getScore());
//                    second.setText(strings.get(1).getScore());
//                    third.setText(strings.get(2).getScore());
//
//                    break;
//            }




        }
    }
}
