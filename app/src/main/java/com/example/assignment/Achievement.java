package com.example.assignment;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.List;

@Entity
public class Achievement {

    @NonNull
    String score;

    @PrimaryKey
    int row;

    public Achievement(String score, int row){

        this.score=score;
        this.row = row;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public String getScore() {

        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }


}

