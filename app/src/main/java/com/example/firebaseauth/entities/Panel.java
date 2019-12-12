package com.example.firebaseauth.entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Panel {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("model")
    @Expose
    private String model;
    @SerializedName("power")
    @Expose
    private String power;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("capacity")
    @Expose
    private String capacity;
    @SerializedName("photo_url")
    @Expose
    private String photoUrl;

    public Panel(String model, String power, String capacity, String address, String photoUrl) {
        this.model = model;
        this.power = power;
        this.capacity = capacity;
        this.address = address;
        this.photoUrl = photoUrl;
    }

    public Integer getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public String getPower() {
        return power;
    }

    public String getCapacity() {
        return capacity;
    }

    public String getAddress() {
        return address;
    }

    public String getPhotoUrl(){
        return  photoUrl;
    }
}