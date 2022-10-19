package com.example.mobileproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.mobileproject.Database.AppDatabase;
import com.example.mobileproject.Entities.User;

public class RegisterActivity extends AppCompatActivity {
    private ConstraintLayout registerBtn;
    private EditText firstname, lastname, email, password, address, phone, pic;
    private AppDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        database = AppDatabase.getAppDatabase(getApplicationContext());
        firstname=findViewById(R.id.firstname);
        lastname=findViewById(R.id.lastname);
        email=findViewById(R.id.email);
        password=findViewById(R.id.password);
        address=findViewById(R.id.address);
        phone=findViewById(R.id.phone);
        //pic=findViewById(R.id.pic);

        // Register
        registerBtn=findViewById(R.id.registerBtn);
        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                database.userDao().insertOne(new User(firstname.getText().toString(), lastname.getText().toString(),
                        email.getText().toString(), password.getText().toString(),
                        address.getText().toString(), Integer.parseInt(phone.getText().toString())));
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                System.out.println("----------------------------------------------------------");
                System.out.println("----------------------------------------------------------");
                System.out.println(database.userDao().getAll());
                System.out.println("----------------------------------------------------------");
                System.out.println("----------------------------------------------------------");
            }
        });
    }

}