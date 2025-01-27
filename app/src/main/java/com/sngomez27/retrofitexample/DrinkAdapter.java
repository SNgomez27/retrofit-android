package com.sngomez27.retrofitexample;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DrinkAdapter extends RecyclerView.Adapter<DrinkAdapter.MyViewHolder> {

    private List<Drinks.Coctail> drinks;
    private  List <Drinks.Coctail> drinksnuevos;
    private Context context;
        ViewGroup parent;

            public DrinkAdapter (List<Drinks.Coctail> drinks, Context context){
                this.drinks = drinks;
                this.context = context;
            }

    @NonNull
    @Override
    public DrinkAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.coctail_cardview,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DrinkAdapter.MyViewHolder holder, int position) {
       holder.bind(drinks.get(position).getCoctailname(),drinks.get(position).CoctailIamgenUrl);

       holder.itemView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               View detail = LayoutInflater.from(context)
                       .inflate(R.layout.cardpopup, parent, false);
               ImageView detallesImagen = detail.findViewById(R.id.imageView);
               Glide.with(view)
                       .load(drinks.get(holder.getAdapterPosition()).getCoctailIamgenUrl())
                       .into(detallesImagen);

               TextView nameText = detail.findViewById(R.id.Nombre);
               nameText.setText(drinks.get(holder.getAdapterPosition()).getCoctailname());

               TextView idText = detail.findViewById(R.id.idCocktail);
               idText.setText(drinks.get(holder.getAdapterPosition()).getCoctailId());

               Call<Drinks> call = apiClient.getClient().create(ApiInterface.class).getDrinkByid(drinks.get(holder.getAdapterPosition()).getCoctailId());
                call.enqueue(new Callback<Drinks>() {
                    @Override
                    public void onResponse(Call<Drinks> call, Response<Drinks> response) {
                        if (response.isSuccessful()){
                            Drinks drinks1 = response.body();
                            drinksnuevos = drinks1.getDrinks();


                            TextView intructsText = detail.findViewById(R.id.Intruciones);
                            String instruciones = drinksnuevos.get(0).getInstruciones();
                            if (instruciones!= null && !instruciones.isEmpty()){
                                intructsText.setText(instruciones);
                            }else{
                                intructsText.setText("Instruccion no encontrada");
                            }
                        }
                    }
                    @Override
                    public void onFailure(Call<Drinks> call, Throwable throwable) {

                    }
                });
               MaterialAlertDialogBuilder materialAlertDialogBuilder = new MaterialAlertDialogBuilder(context)
                       .setView(detail)
                       .setNegativeButton("salir", new DialogInterface.OnClickListener() {
                           @Override
                           public void onClick(DialogInterface dialogInterface, int i) {

                           }
                       });
                materialAlertDialogBuilder.show();
           }
       });

    }

    @Override
    public int getItemCount() {
        return drinks.size();
    }

    public  static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tPalabra;
        ImageView tImage;

        public  MyViewHolder(@NonNull View itemView){
            super(itemView);
            tPalabra = itemView.findViewById(R.id.nombreDrink);
            tImage = itemView.findViewById(R.id.fotito);
        }
        public void bind ( String text, String urlImagen){
             tPalabra.setText(text);
            Glide.with(itemView)
                    .load(urlImagen)
                    .into(tImage);
        }
    }
}
