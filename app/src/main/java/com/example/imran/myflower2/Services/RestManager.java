package com.example.imran.myflower2.Services;

import com.example.imran.myflower2.Controller.Constants;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class RestManager {

    private FlowerApi flowerapi;

    public FlowerApi getFlowerapi() {
        if(flowerapi == null){

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(Constants.HTTP.Base_url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            flowerapi = retrofit.create(FlowerApi.class);

        }


        return flowerapi;
    }
}
