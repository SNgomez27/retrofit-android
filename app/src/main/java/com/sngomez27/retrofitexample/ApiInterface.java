package com.sngomez27.retrofitexample;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("filter.php")
    Call<Drinks> getDrinkByLicour(@Query("i")String licour);
    @GET("lookup.php")
    Call<Drinks> getDrinkByid(@Query("i")String id);
}
