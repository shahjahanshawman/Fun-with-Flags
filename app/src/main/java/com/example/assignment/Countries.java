
package com.example.assignment;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Countries {

    String name;
    int flag;

    public Countries(String name, int flag){
        this.name=name;
        this.flag=flag;
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
}