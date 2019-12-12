package com.example.firebaseauth.utils;

import android.app.Application;

import com.example.firebaseauth.api.ApiService;
import com.google.firebase.auth.FirebaseAuth;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApplicationEx extends Application {

    private ApiService apiService;
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

    public ApiService getApiService(){
        return apiService;
    }

    private ApiService createApiService(){
        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://vxynj7feha.execute-api.us-west-2.amazonaws.com/dev/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(ApiService.class);
    }
}