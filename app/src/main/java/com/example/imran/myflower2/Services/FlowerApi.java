package com.example.imran.myflower2.Services;

import com.example.imran.myflower2.Model.Flower;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;


public interface FlowerApi {

    @GET("/feeds/flowers.json")
    Call<List<Flower>> getALlFlowers();

}
