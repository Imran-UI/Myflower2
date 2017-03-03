package com.example.imran.myflower2.Ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.imran.myflower2.Controller.Constants;
import com.example.imran.myflower2.Model.Flower;
import com.example.imran.myflower2.R;
import com.squareup.picasso.Picasso;

public class Detail_Activity extends AppCompatActivity {

    ImageView image;
    TextView  category;
    TextView  price;
    TextView  instructions;
    TextView  name;
    TextView  productid;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_);

        Intent intent = getIntent();
        Flower flower = (Flower) intent.getSerializableExtra(Constants.Reference.flower);

        image= (ImageView) findViewById(R.id.flowerPhoto);
        category=(TextView) findViewById(R.id.flowerCategory);
        price = (TextView)findViewById(R.id.flowerPrice);
        instructions = (TextView) findViewById(R.id.flowerInstruction);
        name = (TextView) findViewById(R.id.flowerName);
        productid = (TextView) findViewById(R.id.flowerId);

        category.setText(flower.getCategory());
        price.setText(flower.getPrice());
        instructions.setText(flower.getInstructions());
        name.setText(flower.getName());
        productid.setText(flower.getProductId());


        Picasso.with(getApplicationContext())
                .load("http://services.hanselandpetal.com/photos/" + flower.getPhoto())
                .resize(100,100)
                .centerCrop()
                .into(image);







    }
}
