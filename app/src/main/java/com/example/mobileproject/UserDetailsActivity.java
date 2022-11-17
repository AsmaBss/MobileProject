package com.example.mobileproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.mobileproject.Entities.DataConvertor;
import com.example.mobileproject.Entities.User;

import java.io.Serializable;

public class UserDetailsActivity extends AppCompatActivity {
    private TextView firstname, lastname, email, address, phone, username;
    private ImageView imageUser;
    private LinearLayout homeBtn, profileBtn;
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
        imageUser=findViewById(R.id.userImage);
        imageUser.setImageBitmap(DataConvertor.convertByteArrayToImage(user.getPic()));

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
        //
        profileBtn = findViewById(R.id.profileBtn);
        profileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(UserDetailsActivity.this, ProfileActivity.class));
            }
        });
        //
        homeBtn=findViewById(R.id.homeBtn);
        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(UserDetailsActivity.this, MainActivity.class));
            }
        });

    }
}