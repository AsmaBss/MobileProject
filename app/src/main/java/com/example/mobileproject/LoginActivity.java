package com.example.mobileproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

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

        database = AppDatabase.getAppDatabase(getApplicationContext());
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);

        // Login
        loginBtn=findViewById(R.id.loginBtn);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if( email.getText().toString().isEmpty() || password.getText().toString().isEmpty() ){
                    Toast.makeText(getApplicationContext(), "Fill all fields!", Toast.LENGTH_SHORT).show();
                }else{
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            User user = database.userDao().getUser(email.getText().toString(), password.getText().toString());
                            if(user == null){
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        Toast.makeText(getApplicationContext(), "Invalid Credentials!", Toast.LENGTH_SHORT).show();
                                    }
                                });
                            }
                            else{
                                startActivity(new Intent(LoginActivity.this, MainActivity.class)
                                        .putExtra("email",user.getEmail()));
                            }
                        }
                    }).start();
                }
            }
        });
    }
}