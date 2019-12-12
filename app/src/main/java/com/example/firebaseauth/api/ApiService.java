package com.example.firebaseauth.api;

import com.example.firebaseauth.entities.Panel;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService {
    @GET("solar/")
    Call<List<Panel>> getPanels();

    @POST("solar/")
    Call<Panel> createPanel(@Body Panel panel);
}