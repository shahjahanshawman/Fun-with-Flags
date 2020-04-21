package com.example.assignment;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CountryResponse {

    @SerializedName("data")
    @Expose
    private List<Countries> data = null;



    public List<Countries> getData() {

        return data;
    }

    public void setData(List<Countries> data) {

        this.data = data;
    }


}


