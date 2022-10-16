package com.example.mobileproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class LoginActivity extends AppCompatActivity {
    private ConstraintLayout loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        /*
            AddUser Exemple :
                database = AppDatabase.getAppDatabase(getApplicationContext());
                btn.setOnClickListener(e->{
                    database.userDao().insertOne(new User(name.getText().toString(), pwd.getText().toString()));
                });
         */

        // Login
        loginBtn=findViewById(R.id.loginBtn);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, MainActivity.class));
            }
        });
    }
}