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
    int level;

    public Achievement(String score, int level){

        this.score=score;
        this.level = level;
    }

    public int getLevel() {

        return level;
    }

    public void setLevel(int level) {

        this.level = level;
    }

    public String getScore() {

        return score;
    }

    public void setScore(String score) {

        this.score = score;
    }


}

