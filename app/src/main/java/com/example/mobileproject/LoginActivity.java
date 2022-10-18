package com.example.mobileproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.mobileproject.Database.AppDatabase;
import com.example.mobileproject.Entities.User;

public class LoginActivity extends AppCompatActivity {
    private ConstraintLayout loginBtn;
    private EditText email, password;
    private AppDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //AddUser Exemple :
        database = AppDatabase.getAppDatabase(getApplicationContext());
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        /*loginBtn.setOnClickListener(e->{
         database.userDao().insertOne(new User(email.getText().toString(), password.getText().toString()));
         });*/

        //AppDatabase.getAppDatabase(getApplicationContext()).userDao().deleteAll();
        System.out.println("All users ======= "+ database.userDao().getAll());

        // Login
        loginBtn=findViewById(R.id.loginBtn);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                database.userDao().insertOne(new User(email.getText().toString(), password.getText().toString()));
                startActivity(new Intent(LoginActivity.this, MainActivity.class));
                System.out.println(database.userDao().getAll());
            }
        });
    }
}