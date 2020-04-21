package com.example.assignment;

import retrofit2.Call;
import retrofit2.http.GET;

public interface FlagAPI {



    public interface CoinService {

        @GET("rest/v2/all")
        Call<Countries> getAllCountries();


    }

}
