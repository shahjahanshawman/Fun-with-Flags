package com.example.assignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.SplittableRandom;

public class Level1Quiz extends AppCompatActivity {
    private static final String TAG = "quiz";
    private Adapter mAdapter;
    List<Countries> countries;
    private Random randomGenerator=  new Random();
    private AchievementDatabase achievementDatabase;
    ImageView fg;
    Button answer1, answer2, answer3, answer4;
    TextView result;
    int turn = 1;
    int lastScore;
    List<Achievement> scores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level1_quiz);

        countries = new ArrayList<>();
        //adds countries to list
        for(int i=0;i<new CountryDatabase().answers.length;i++){
            if( new CountryDatabase().level[i]==1){
                countries.add(new Countries(new CountryDatabase().answers[i], new CountryDatabase().flags[i],1));
            }
        }


        //shuffles the list
        Collections.shuffle(countries);

        achievementDatabase = Room.databaseBuilder(getApplicationContext(), AchievementDatabase.class, "myDB")
                .build();

         fg = findViewById(R.id.flag);

         answer1 = findViewById(R.id.country1);
         answer2 = findViewById(R.id.country2);
         answer3 = findViewById(R.id.country3);
         answer4 = findViewById(R.id.country4);
         result = findViewById(R.id.result);
         result.setVisibility(View.GONE);

         //sets the flag and button- turn keeps count on the list
         setQuestion(turn);


        answer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(answer1.getText().toString().equalsIgnoreCase(countries.get(turn-1).getName())){
                    result.setText("Correct!");    //checks for correct answer
                    result.setVisibility(View.VISIBLE);
                    result.setTextColor(0xFF43D110);
                    lastScore++;
                    //checks if end of list
                    if(turn<10){
                        turn++;
                        setQuestion(turn);
                    } else {
                        result.setText("Game Over!");
                        result.setVisibility(View.VISIBLE);
                        result.setTextColor(0xFF43D110);
                        new insertScore().execute();
                        Intent seeScore = new Intent(getApplicationContext(), AchievementScreen.class);
                        startActivity(seeScore);
                        //setLastScore(lastScore);


                    }
                } else {
                    //output for wrong answer
                    result.setText("Wrong!");
                    result.setTextColor(0xFFD11010);
                    result.setVisibility(View.VISIBLE);
                    turn++;
                    setQuestion(turn);

                }
            }
        });

        answer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(answer2.getText().toString().equalsIgnoreCase(countries.get(turn-1).getName())){
                    result.setText("Correct!");
                    result.setTextColor(0xFF43D110);
                    result.setVisibility(View.VISIBLE);
                    lastScore++;
                    if(turn<10){
                        turn++;
                        setQuestion(turn);
                    } else {
                        result.setText("Game Over!");
                        result.setTextColor(0xFF43D110);
                        result.setVisibility(View.VISIBLE);
//                        setLastScore(lastScore);
                        new insertScore().execute();
                        Intent seeScore = new Intent(getApplicationContext(), AchievementScreen.class);
                        startActivity(seeScore);

                    }
                } else {
                    result.setText("Wrong!");
                    result.setTextColor(0xFFD11010);
                    result.setVisibility(View.VISIBLE);
                    turn++;
                    setQuestion(turn);


                }
            }
        });


        answer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(answer3.getText().toString().equalsIgnoreCase(countries.get(turn-1).getName())){
                    result.setText("Correct!");
                    result.setTextColor(0xFF43D110);
                    result.setVisibility(View.VISIBLE);
                    lastScore++;
                    if(turn<10){
                        turn++;
                        setQuestion(turn);
                    } else {
                        result.setText("Game Over!");
                        result.setTextColor(0xFF43D110);
                        result.setVisibility(View.VISIBLE);
//                        setLastScore(lastScore);
                        new insertScore().execute();
                        Intent seeScore = new Intent(getApplicationContext(), AchievementScreen.class);
                        startActivity(seeScore);
                    }
                } else {
                    result.setText("Wrong!");
                    result.setTextColor(0xFFD11010);
                    result.setVisibility(View.VISIBLE);
                    turn++;
                    setQuestion(turn);
                    //finish();

                }
            }
        });


        answer4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(answer4.getText().toString().equalsIgnoreCase(countries.get(turn-1).getName())){
                    result.setText("Correct!");
                    result.setTextColor(0xFF43D110);
                    result.setVisibility(View.VISIBLE);
                    lastScore++;
                    if(turn<10){
                        turn++;
                        setQuestion(turn);
                    } else {
                        result.setText("Game Over!");
                        result.setTextColor(0xFF43D110);
                        result.setVisibility(View.VISIBLE);
//                        setLastScore(lastScore);
                        new insertScore().execute();
                        Intent seeScore = new Intent(getApplicationContext(), AchievementScreen.class);
                        startActivity(seeScore);
                    }
                } else {
                    result.setText("Wrong! You Lost!");
                    result.setTextColor(0xFFD11010);
                    result.setVisibility(View.VISIBLE);
                    turn++;
                    setQuestion(turn);


                }
            }
        });


    }




    private void setQuestion(int number) {
        Log.d(TAG, countries.get(number-1).getName());
        //sets image
        fg.setImageResource(countries.get(number-1).getFlag());


        //finds a number where the correct answer will be put
        int correctAnswer= randomGenerator.nextInt(4)+1;

        int firstButton = number-1;
        int secondButton;
        int thirdButton;
        int fourthButton;

        switch (correctAnswer){
            case 1:
                //finds a country for first button
                answer1.setText(countries.get(firstButton).getName());

                do{
                    secondButton= randomGenerator.nextInt(countries.size());
                } while (secondButton==firstButton); //checks two countries are not the same

                do{
                    thirdButton= randomGenerator.nextInt(countries.size());
                } while (thirdButton==firstButton || thirdButton==secondButton);

                do{
                    fourthButton= randomGenerator.nextInt(countries.size());
                } while (fourthButton==firstButton || fourthButton==secondButton|| fourthButton==thirdButton) ;

                answer2.setText(countries.get(secondButton).getName());
                answer3.setText(countries.get(thirdButton).getName());
                answer4.setText(countries.get(fourthButton).getName());
                break;

            case 2:

                answer2.setText(countries.get(firstButton).getName());

                do{
                    secondButton= randomGenerator.nextInt(countries.size());
                } while (secondButton==firstButton);

                do{
                    thirdButton= randomGenerator.nextInt(countries.size());
                } while (thirdButton==firstButton || thirdButton==secondButton);

                do{
                    fourthButton= randomGenerator.nextInt(countries.size());
                } while (fourthButton==firstButton || fourthButton==secondButton|| fourthButton==thirdButton) ;

                answer1.setText(countries.get(secondButton).getName());
                answer3.setText(countries.get(thirdButton).getName());
                answer4.setText(countries.get(fourthButton).getName());
                break;
            case 3:
                answer3.setText(countries.get(firstButton).getName());

                do{
                    secondButton= randomGenerator.nextInt(countries.size());
                } while (secondButton==firstButton);

                do{
                    thirdButton= randomGenerator.nextInt(countries.size());
                } while (thirdButton==firstButton || thirdButton==secondButton);

                do{
                    fourthButton= randomGenerator.nextInt(countries.size());
                } while (fourthButton==firstButton || fourthButton==secondButton|| fourthButton==thirdButton) ;

                answer2.setText(countries.get(secondButton).getName());
                answer1.setText(countries.get(thirdButton).getName());
                answer4.setText(countries.get(fourthButton).getName());
                break;
            case 4:
                answer4.setText(countries.get(firstButton).getName());

                do{
                    secondButton= randomGenerator.nextInt(countries.size());
                } while (secondButton==firstButton);

                do{
                    thirdButton= randomGenerator.nextInt(countries.size());
                } while (thirdButton==firstButton || thirdButton==secondButton);

                do{
                    fourthButton= randomGenerator.nextInt(countries.size());
                } while (fourthButton==firstButton || fourthButton==secondButton|| fourthButton==thirdButton) ;

                answer2.setText(countries.get(secondButton).getName());
                answer3.setText(countries.get(thirdButton).getName());
                answer1.setText(countries.get(fourthButton).getName());
                break;

        }
    }

    private void setLastScore(int number) {



    }

    private class insertScore  extends AsyncTask<Void,Integer,Integer> {


        @Override
        protected Integer doInBackground(Void... voids) {
//            setLastScore(lastScore);
            scores = achievementDatabase.achievementDAO().getScores();

            String score = Integer.toString(lastScore);
            score = score + "/10";

            int count = scores.size();
            if (count < 5) {
                Achievement toAdd = new Achievement(score, count + 1);

                scores.add(0, toAdd);
                achievementDatabase.achievementDAO().deleteScores();
                achievementDatabase.achievementDAO().insertAll(scores);
            } else {

                scores.remove(scores.size() - 1);
                Achievement toAdd = new Achievement(score, count + 1);
                scores.add(0, toAdd);
                achievementDatabase.achievementDAO().deleteScores();
                achievementDatabase.achievementDAO().insertAll(scores);

            }
            return null;
        }

        @Override
        protected void onPostExecute(Integer integer) {
            super.onPostExecute(integer);
        }
    }
}
