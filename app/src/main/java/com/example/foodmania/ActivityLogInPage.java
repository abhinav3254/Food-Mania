package com.example.foodmania;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.foodmania.databinding.ActivityLogInPageBinding;

public class ActivityLogInPage extends AppCompatActivity {

    private ActivityLogInPageBinding binding;

    String uname,password;


    DBHelperTwo dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_log_in_page);

        getSupportActionBar().hide();

        binding = ActivityLogInPageBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.goToSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityLogInPage.this,ActivitySignUp.class);
                startActivity(intent);
                finish();
            }
        });


        dbHelper = new DBHelperTwo(this);

        binding.logInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uname = binding.logInUname.getText().toString();
                password = binding.logInPassword.getText().toString();

                if(uname.isEmpty() || password.isEmpty()) {
                    Toast.makeText(ActivityLogInPage.this, "Can't Be Empty", Toast.LENGTH_SHORT).show();
                } else {
                    boolean ans = dbHelper.checkUserNamePassWord(uname,password);

                    if(ans == true) {
                        Toast.makeText(ActivityLogInPage.this, "Success", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(ActivityLogInPage.this,MainActivity.class);
                        startActivity(intent);
                        finish();
                    } else {
                        Toast.makeText(ActivityLogInPage.this, "Incorrect Password", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }
}