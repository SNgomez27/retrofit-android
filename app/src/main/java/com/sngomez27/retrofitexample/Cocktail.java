package com.sngomez27.retrofitexample;


import com.google.gson.annotations.SerializedName;

public class Cocktail {

    @SerializedName("name")
    private  String name;

    @SerializedName("image")
    private  String imagenUrl;

    @SerializedName("id")
    private String id;

    public Cocktail(String name, String id, String imagenUrl) {
        this.name = name;
        this.id = id;
        this.imagenUrl = imagenUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImagenUrl() {
        return imagenUrl;
    }

    public void setImagenUrl(String imagenUrl) {
        this.imagenUrl = imagenUrl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
