package com.example.laba3;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MoviesApi {
    @GET("movies")
    Call<List<Movies>> getPanels();
}
