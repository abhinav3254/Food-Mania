package com.example.foodmania;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.example.foodmania.Adapters.OrdersAdapter;
import com.example.foodmania.Models.OrderModels;
import com.example.foodmania.databinding.ActivityOderBinding;

import java.util.ArrayList;

public class OderActivity extends AppCompatActivity {

    ActivityOderBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOderBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());


        // getting and setting all the orders into the array list
        DBHelper helper = new DBHelper(this);
        ArrayList<OrderModels> list = helper.getOrders();


//        list.add(new OrderModels(R.drawable.burger_cheese,"cheese Burger"
//                ,"5","12245545454"));
//        list.add(new OrderModels(R.drawable.burger_coke,"Burger Coke"
//                ,"6","12245545458"));
//
//        list.add(new OrderModels(R.drawable.mushroom,"Mushroom"
//                ,"9","12245545454"));
//        list.add(new OrderModels(R.drawable.burger_king1,"Burger with Coffee",
//                "25","12245545458"));
//
//        list.add(new OrderModels(R.drawable.cake,"Cake",
//                "50","12245545454"));
//        list.add(new OrderModels(R.drawable.chinese,"Chinese",
//                "30","12245545458"));
//
//        list.add(new OrderModels(R.drawable.cofee,"Coffee",
//                "15","12245545454"));
//        list.add(new OrderModels(R.drawable.cake_11,"Cake",
//                "55","12245545458"));
//
//        list.add(new OrderModels(R.drawable.coca_cola,"Soft Drink",
//                "19","12245545458"));


        OrdersAdapter ordersAdapter = new OrdersAdapter(list,this);
        binding.orderRecyclerView.setAdapter(ordersAdapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.orderRecyclerView.setLayoutManager(layoutManager);
    }
}