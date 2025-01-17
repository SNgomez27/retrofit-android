package com.sngomez27.retrofitexample;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
       ApiInterface apiInterface = apiClient.getClient().create(ApiInterface.class);
        Call<List<Cocktail>> call = apiInterface.getCocktails();
        call.enqueue(new Callback<List<Cocktail>>() {
            @Override
            public void onResponse(Call<List<Cocktail>> call, Response<List<Cocktail>> response) {
                TextView textView = findViewById(R.id.principal);
                textView.setText((CharSequence) response.body());

            }

            @Override
            public void onFailure(Call<List<Cocktail>> call, Throwable throwable) {

            }
        });

    }
}