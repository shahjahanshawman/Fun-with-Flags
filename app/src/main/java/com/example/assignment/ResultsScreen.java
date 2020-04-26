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

import static android.view.View.*;

public class ResultsScreen extends AppCompatActivity implements OnClickListener {
    private static final String TAG = "ResultsScreen";
    ResultsDatabase resultsDatabase;
    TextView first,second,third;
    Button back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results_screen);

        resultsDatabase = Room.databaseBuilder(getApplicationContext(), ResultsDatabase.class, "myDB")
                .build();
        new InsertScore().execute();

        first = findViewById(R.id.p1);

        second = findViewById(R.id.p2);
        third = findViewById(R.id.p3);
        back = findViewById(R.id.back);
        back.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent goHome = new Intent(this, MainMenu.class );
        startActivity(goHome);
    }


    //gets the latest score for each level
    private class InsertScore extends AsyncTask<Void,Void, List<Results>> {
        @Override
        protected List<Results> doInBackground(Void... voids) {

            List<Results> newList = resultsDatabase.resultsDAO().getScores();
            return newList;
        }

        @Override
        protected void onPostExecute(List<Results> strings) {
            super.onPostExecute(strings);

            int count = strings.size();

            //setText based on which levels have been played
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
        }
    }
}
