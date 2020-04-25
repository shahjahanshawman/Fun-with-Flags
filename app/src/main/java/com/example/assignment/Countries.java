
package com.example.assignment;

import android.graphics.drawable.Drawable;

import java.util.ArrayList;

public class Countries {

    String answers;
    int flag;
    int level;

    public Countries(String answers, int flag, int level){
        this.answers = answers;
        this.flag = flag;
        this.level = level;
    }

    public String getAnswers() {

        return answers;
    }

    public int getFlag() {

        return flag;
    }

    public void setAnswers(String answers) {

        this.answers = answers;
    }

    public void setFlag(int flag) {

        this.flag = flag;
    }

    public int getLevel() {

        return level;
    }

    public void setLevel(int level) {

        this.level = level;
    }

    public static ArrayList<Countries> getCountries() {
        ArrayList<Countries> countries = new ArrayList<>();

        //adds countries to list
        for(int i=0;i<new CountryDatabase().answers.length;i++){
            countries.add(new Countries(new CountryDatabase().answers[i], new CountryDatabase().flags[i], new CountryDatabase().level[i]));
        }
        return countries;
    }
}