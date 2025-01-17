package com.sngomez27.retrofitexample;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("cokctails-array-json")
    Call<List<Cocktail>> getCocktails();
}
