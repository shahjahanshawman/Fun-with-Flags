package com.example.assignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class quiz extends AppCompatActivity {
    private static final String TAG = "quiz";
    private Adapter mAdapter;
    List<Countries> countries;
    private Random randomGenerator=  new Random();
    ImageView fg;
    Button answer1, answer2, answer3, answer4;
    TextView result;
    int turn = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        countries = new ArrayList<>();
        for(int i=0;i<new CountryDatabase().answers.length;i++){
            countries.add(new Countries(new CountryDatabase().answers[i], new CountryDatabase().flags[i]));
        }

        Collections.shuffle(countries);


         fg = findViewById(R.id.flag);

         answer1 = findViewById(R.id.country1);
         answer2 = findViewById(R.id.country2);
         answer3 = findViewById(R.id.country3);
         answer4 = findViewById(R.id.country4);
         result = findViewById(R.id.result);
         //result.setVisibility(View.GONE);
         setQuestion(turn);


        answer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(answer1.getText().toString().equalsIgnoreCase(countries.get(turn-1).getName())){
                    result.setText("Correct!");
                    //result.setVisibility(View.VISIBLE);
                    result.setTextColor(0xFF43D110);

                    if(turn<countries.size()){
                        turn++;
                        setQuestion(turn);
                    } else {
                        result.setText("Game Over!");
                        //result.setVisibility(View.VISIBLE);
                        result.setTextColor(0xFF43D110);

//                        finish();
                    }
                } else {
                    result.setText("Incorrect!");
                    result.setTextColor(0xFFD11010);
                    //result.setVisibility(View.VISIBLE);
                    turn++;
                    setQuestion(turn);
//                    finish();
                }
            }
        });

        answer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(answer2.getText().toString().equalsIgnoreCase(countries.get(turn-1).getName())){
                    result.setText("Correct!");
                    result.setTextColor(0xFF43D110);
                    //result.setVisibility(View.VISIBLE);
                    if(turn<countries.size()){
                        turn++;
                        setQuestion(turn);
                    } else {
                        result.setText("Game Over!");
                        result.setTextColor(0xFF43D110);
                        //result.setVisibility(View.VISIBLE);

//                        finish();
                    }
                } else {
                    result.setText("Incorrect!");
                    result.setTextColor(0xFFD11010);
                    //result.setVisibility(View.VISIBLE);
                    turn++;
                    setQuestion(turn);
//                    finish();

                }
            }
        });


        answer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(answer3.getText().toString().equalsIgnoreCase(countries.get(turn-1).getName())){
                    result.setText("Correct!");
                    result.setTextColor(0xFF43D110);
                    //result.setVisibility(View.VISIBLE);
                    if(turn<countries.size()){
                        turn++;
                        setQuestion(turn);
                    } else {
                        result.setText("Game Over!");
                        result.setTextColor(0xFF43D110);
                       // result.setVisibility(View.VISIBLE);

//                        finish();
                    }
                } else {
                    result.setText("Incorrect!");
                    result.setTextColor(0xFFD11010);
                    //result.setVisibility(View.VISIBLE);
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
                   // result.setVisibility(View.VISIBLE);
                    if(turn<countries.size()){
                        turn++;
                        setQuestion(turn);
                    } else {
                        result.setText("Game Over!");
                        result.setTextColor(0xFF43D110);
                      //  result.setVisibility(View.VISIBLE);

//                        finish();
                    }
                } else {
                    result.setText("Incorrect!");
                    result.setTextColor(0xFFD11010);
                   // result.setVisibility(View.VISIBLE);
                    turn++;
                    setQuestion(turn);
                    //finish();

                }
            }
        });


    }




    private void setQuestion(int number) {
        Log.d(TAG, countries.get(number-1).getName());
        fg.setImageResource(countries.get(number-1).getFlag());
//        fg.setImageResource(R.drawable.;
//        Glide.with(this)
//                .load((countries.get(number-1).getFlag()))
//                .into(fg);


        int correctAnswer= randomGenerator.nextInt(4)+1;

        int firstButton = number-1;
        int secondButton;
        int thirdButton;
        int fourthButton;

        switch (correctAnswer){
            case 1:
                answer1.setText(countries.get(firstButton).getName());

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
}
