package com.example.tripathi.amit;

import retrofit2.Call;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;



public interface ApiInterface {

    @Headers("Content-Type: application/json")
    @POST("/")
    Call<String> getData(@Query("i") String i,
                              @Query("apikey") String apikey);

}