package com.sngomez27.retrofitexample;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


import java.util.List;

public class MainActivity extends AppCompatActivity {

   List<Drinks.Coctail> lista;
   RecyclerView principal;

@Override
   protected void onCreate(Bundle savedInstanceState){
    super.onCreate(savedInstanceState);
    EdgeToEdge.enable(this);
    setContentView(R.layout.activity_main);
    principal = findViewById(R.id.Cocktails);
    principal.setLayoutManager(new GridLayoutManager(getApplicationContext(),2));
    verCocktail();
}
public void verCocktail(){
    Button button = findViewById(R.id.buscar);
    button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            EditText editText = findViewById(R.id.textoo);
            String filtros = editText.getText().toString();
            Call<Drinks> call = apiClient.getClient().create(ApiInterface.class).getDrinkByLicour(filtros);
            call.enqueue(new Callback<Drinks>() {
                @Override
                public void onResponse(Call<Drinks> call, Response<Drinks> response) {
                    if (response.isSuccessful()) {
                        Drinks drinks = response.body();
                        lista = drinks.getDrinks();
                        DrinkAdapter adapter = new DrinkAdapter(lista,MainActivity.this);
                        principal.setAdapter(adapter);
                    }
                }

                @Override
                public void onFailure(Call<Drinks> call, Throwable throwable) {

                }
            });
        }
    });
}

}