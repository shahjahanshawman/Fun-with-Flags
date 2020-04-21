package com.example.assignment;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface FlagAPI {

        @GET("rest/v2/all")
        Call<CountryResponse> getAllCountries();

        @GET("data/{flag}")
        Call<Integer> getFlag(@Path("flag") String flag);

}
//data/afg.svg