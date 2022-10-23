package com.example.mobileproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.mobileproject.Entities.User;

public class UserDetailsActivity extends AppCompatActivity {
    private TextView firstname, lastname, email, address, phone, username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details);

        User user = new User();
        Intent intent = getIntent();
        user = (User) intent.getSerializableExtra("user");

        System.out.println("-------------------------------------------------------test "+ user.getPhone());

        username=findViewById(R.id.username);
        username.setText(user.getFirstname() + " " + user.getLastname());

        firstname=findViewById(R.id.firstname);
        firstname.setText(user.getFirstname());
        lastname=findViewById(R.id.lastname);
        lastname.setText(user.getLastname());
        email=findViewById(R.id.email);
        email.setText(user.getEmail());
        phone=findViewById(R.id.phone);
        phone.setText(user.getPhone()+"");
        address=findViewById(R.id.address);
        address.setText(user.getAddress());


    }
}