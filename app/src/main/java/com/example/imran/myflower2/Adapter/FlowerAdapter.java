package com.example.imran.myflower2.Adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.imran.myflower2.Controller.Constants;
import com.example.imran.myflower2.Model.Flower;
import com.example.imran.myflower2.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;



public class FlowerAdapter extends RecyclerView.Adapter<FlowerAdapter.Holder> {

    public List<Flower>  flowerslist = new ArrayList<>() ;

    public FlowerclickListner listner;

    public FlowerAdapter(FlowerclickListner listner) {
        this.listner = listner;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {

        View row = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item,null,false);


        return new Holder(row);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {

        Flower currflower = flowerslist.get(position);
        holder.name.setText(currflower.getName());
        holder.price.setText(currflower.getPrice());
        Picasso.with(holder.itemView.getContext())
                .load(Constants.HTTP.Base_url + "/photos/" + currflower.getPhoto() )
                .resize(50, 50)
                .centerCrop()
                .into(holder.photo);



    }

    @Override
    public int getItemCount() {
        return flowerslist.size();
    }

    public void addFlower(Flower dumflower) {

        flowerslist.add(dumflower);
    }

    public Flower getselectedflower(int position) {

        return flowerslist.get(position);

    }

    public class Holder extends RecyclerView.ViewHolder implements RecyclerView.OnClickListener{

        ImageView photo;
        TextView price,name;

        public Holder(View itemView) {
            super(itemView);
            price = (TextView) itemView.findViewById(R.id.flowerPrice);
            name =(TextView) itemView.findViewById(R.id.flowerName);
            photo = (ImageView) itemView.findViewById(R.id.flowerPhoto);
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            listner.onClick(getLayoutPosition());

        }
    }

    public interface FlowerclickListner{

        void onClick(int position);


    }

}
