package com.example.imran.myflower2.Ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.imran.myflower2.Adapter.FlowerAdapter;
import com.example.imran.myflower2.Controller.Constants;
import com.example.imran.myflower2.Model.Flower;
import com.example.imran.myflower2.R;
import com.example.imran.myflower2.Services.RestManager;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements FlowerAdapter.FlowerclickListner{

    RecyclerView mrecycle ;
    RestManager manager;
    FlowerAdapter adapter = new FlowerAdapter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mrecycle = (RecyclerView) findViewById(R.id.recyclerView);
        mrecycle.setHasFixedSize(true);
        mrecycle.setRecycledViewPool(new RecyclerView.RecycledViewPool());
        mrecycle.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false));
        mrecycle.setAdapter(adapter);


        manager = new RestManager();
        Call<List<Flower>> listCall = manager.getFlowerapi().getALlFlowers();
        listCall.enqueue(new Callback<List<Flower>>() {
            @Override
            public void onResponse(Call<List<Flower>> call, Response<List<Flower>> response) {
                if(response.isSuccessful()){
                    List<Flower> flowerlist = response.body();
                    for(int i=0;i<flowerlist.size();i++){
                        Flower dumflower = flowerlist.get(i);
                        adapter.addFlower(dumflower);
                    }

                }else{
                    int statuscode = response.code();
                }
            }

            @Override
            public void onFailure(Call<List<Flower>> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"unable to load",Toast.LENGTH_LONG).show();

            }
        });



    }

    @Override
    public void onClick(int position) {
        Flower selectedflower = adapter.getselectedflower(position);
        Intent intent = new Intent(MainActivity.this,Detail_Activity.class);
        intent.putExtra(Constants.Reference.flower,selectedflower);
        startActivity(intent);
    }
}
