package com.example.assignment;

import com.example.assignment.InfoFromAPI.MainInfo;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CountryResponse {

    @SerializedName("data")
    @Expose
    private List<MainInfo> data = null;



    public List<MainInfo> getData() {

        return data;
    }

    public void setData(List<MainInfo> data) {

        this.data = data;
    }


}


