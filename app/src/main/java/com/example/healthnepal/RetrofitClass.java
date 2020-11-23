package com.example.healthnepal;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClass {
    private static RetrofitClass mInstance;

    public static RetrofitClass getInstance(){
        if(mInstance==null){
            mInstance = new RetrofitClass();
        }
        return  mInstance;
    }

    public JsonPlaceHolderApi getJsonApi(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);
        return jsonPlaceHolderApi;
    }
}
