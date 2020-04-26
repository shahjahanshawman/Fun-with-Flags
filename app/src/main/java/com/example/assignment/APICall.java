package com.example.assignment;
import com.example.assignment.InfoFromAPI.MainInfo;

import retrofit2.Call;
import retrofit2.http.GET;


public interface APICall {

    @GET("/rest/v2/all")
    Call<CountryResponse> getAllCountries();
}
