package com.example.mobileproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.room.Database;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.mobileproject.Database.AppDatabase;

public class IntroActivity extends AppCompatActivity {
    private ConstraintLayout loginBtn, registerBtn;
    private AppDatabase database;

    /*@Override
    protected void onDestroy() {
        AppDatabase.destroyInstance();
        System.out.println("-------------------------------------------------------------------------------------------------------------------------- destroy");
        super.onDestroy();
    }*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        /*database = AppDatabase.getAppDatabase(getApplicationContext());
        System.out.println("------------------------------------------------------------------ all -------- ");
        System.out.println(database.userDao().getAll());*/

        // Login
        loginBtn=findViewById(R.id.login);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(IntroActivity.this, LoginActivity.class));
            }
        });

        // Register
        registerBtn=findViewById(R.id.register);
        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(IntroActivity.this, RegisterActivity.class));
            }
        });
    }
}