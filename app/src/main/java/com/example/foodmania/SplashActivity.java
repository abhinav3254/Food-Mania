package com.example.foodmania;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        getSupportActionBar().hide(); // this is will my action bar

        Thread thread = new Thread(){


            public void run(){
                try {
                    sleep(4000);
                }catch (Exception e){
                    e.printStackTrace();
                }finally {

                    Intent intent = new Intent(SplashActivity.this,MainActivity.class);
                    startActivity(intent);
                    finish(); //  if we don't add this method then it will again move us to splash screen to prevent this.
                }
            }
        };thread.start();

    }
}