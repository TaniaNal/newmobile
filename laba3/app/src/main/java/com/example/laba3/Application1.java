package com.example.laba3;

import android.app.Application;

import com.google.firebase.auth.FirebaseAuth;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Application1 extends Application {

    private MoviesApi apiService;
    private FirebaseAuth auth;

    public void onCreate()
    {
        super.onCreate();
        auth = FirebaseAuth.getInstance();
        apiService = createApiService();
    }

    public FirebaseAuth getAuth(){
        return auth;
    }

    public MoviesApi getApiService(){
        return apiService;
    }

    private MoviesApi createApiService(){
        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://us-central1-lab1a-8fab9.cloudfunctions.net/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(MoviesApi.class);
    }
}
