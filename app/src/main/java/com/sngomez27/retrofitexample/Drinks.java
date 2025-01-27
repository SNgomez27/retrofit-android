package com.sngomez27.retrofitexample;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Drinks {
    @SerializedName("drinks")
    List<Coctail> drinks = new ArrayList<>();

    public class Coctail{
        @SerializedName("strDrink")
        public String Coctailname;
        @SerializedName("strDrinkThumb")
        public  String CoctailIamgenUrl;
        @SerializedName("idDrink")
        public String coctailId;
        @SerializedName("strInstructionsES")
        public String instruciones;


        public String getCoctailname() {
            return Coctailname;
        }

        public void setCoctailname(String coctailname) {
            Coctailname = coctailname;
        }

        public String getCoctailIamgenUrl() {
            return CoctailIamgenUrl;
        }

        public void setCoctailIamgenUrl(String coctailIamgenUrl) {
            CoctailIamgenUrl = coctailIamgenUrl;
        }

        public String getCoctailId() {
            return coctailId;
        }

        public void setCoctailId(String coctailId) {
            this.coctailId = coctailId;
        }

        public String getInstruciones() {
            return instruciones;
        }

        public void setInstruciones(String instruciones) {
            this.instruciones = instruciones;
        }
    }
    public  List<Coctail> getDrinks(){
        return drinks;
    }

    public void setDrinks(List<Coctail> drinks) {
        this.drinks = drinks;
    }
}
