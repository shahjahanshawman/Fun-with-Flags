
package com.example.assignment;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Countries {

    String name;
    int flag;
    int level;

    public Countries(String name, int flag, int level){
        this.name=name;
        this.flag=flag;
        this.level = level;
    }

    public String getName() {

        return name;
    }

    public int getFlag() {

        return flag;
    }

    public void setName(String name) {

        this.name = name;
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