package com.example.foodmania;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.foodmania.databinding.ActivitySignUpBinding;

public class ActivitySignUp extends AppCompatActivity {

    private String uname,rname,password,phone;

    DBHelperTwo dbHelper;

    private ActivitySignUpBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_sign_up);

        getSupportActionBar().hide();

        binding = ActivitySignUpBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);



        binding.goToSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivitySignUp.this,ActivityLogInPage.class);
                startActivity(intent);
                finish();
            }
        });

        dbHelper = new DBHelperTwo(this);

        binding.signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                uname = binding.Suname.getText().toString();
                rname = binding.SRname.getText().toString();
                password = binding.Spassword.getText().toString();
                phone = binding.Sphone.getText().toString();

                Log.d("UNAME","UserName is empty"+uname);

                if(uname.isEmpty()||password.isEmpty()||rname.isEmpty()||phone.isEmpty()) {
                    Toast.makeText(ActivitySignUp.this, "Can't Be Empty", Toast.LENGTH_SHORT).show();
                } else {
                    boolean result = dbHelper.checkUser(uname);
                    if(result == false) {
                        boolean Rresult = dbHelper.insertData(uname,rname,password,phone);
                        if(Rresult == true) {
                            Toast.makeText(ActivitySignUp.this, "Success\nNow you can login", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(ActivitySignUp.this,MainActivity.class);
                            startActivity(intent);
                            finish();
                        } else {
                            Toast.makeText(ActivitySignUp.this, "Something Went Wrong\nPlease try later", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(ActivitySignUp.this, "User Already Exists", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}