package com.example.foodmania;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;

import com.example.foodmania.Adapters.MainAdapter;
import com.example.foodmania.Models.MainModel;
import com.example.foodmania.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        // if we want freedom from find view by id then do this and add
//        buildFeatures{
//            viewBinding true
//        }
        // in the gradle file

        binding = ActivityMainBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());


        ArrayList<MainModel> list = new ArrayList<>();

        list.add(new MainModel(R.drawable.burger_cheese,"Burger Cheese",
                "5"," Swiss or blue cheese" +
                "which gives a cheeseburger a nice “tang” with bold flavor."));
        list.add(new MainModel(R.drawable.burger_coke,"Burger Coke",
                "6"," Burger with 1 2L coca cola free!!"));

        list.add(new MainModel(R.drawable.mushroom,"Mushroom",
                "9","Crunchy and Hot Spicy Mushroom"));
        list.add(new MainModel(R.drawable.burger_king1,"Burger with Coffee",
                "25","Complete Snaks Time"));
        list.add(new MainModel(R.drawable.cake,"Cake",
                "50","Complete party time"));
        list.add(new MainModel(R.drawable.chinese,"Chinese",
                "30","Noodles with Extra cheese and Indian Spice On It"));
        list.add(new MainModel(R.drawable.cofee,"Coffee",
                "15","Break Time "+
                " Home Delivery Within 5 min, fast delivery"));
        list.add(new MainModel(R.drawable.cake_11,"Cake",
                "55","Huge Cake With Cherry"));
        list.add(new MainModel(R.drawable.coca_cola,"Soft Drink",
                "19","Remove your Hotness with Chilling soft Drinks"));

        // setting up adapter
        MainAdapter adapter = new MainAdapter(list,this);
        binding.recyclerview.setAdapter(adapter);

        // setting up layout
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.recyclerview.setLayoutManager(layoutManager);
    }

    // My Orders Section on the top right of the of the Main Activity
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.orders:
                startActivity(new Intent(MainActivity.this,OderActivity.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}