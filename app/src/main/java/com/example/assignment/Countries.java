
package com.example.assignment;

import android.graphics.drawable.Drawable;

import java.io.Serializable;
import java.util.ArrayList;

public class Countries implements Serializable {

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

}