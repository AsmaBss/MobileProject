package com.example.mobileproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.mobileproject.Entities.DataConvertor;
import com.example.mobileproject.Entities.User;

import java.io.Serializable;

public class ProfileActivity extends AppCompatActivity {
    private LinearLayout account, logout;
    private TextView username, email;
    private ImageView imageLogout,homeImage, imageUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        User user=new User();
        Intent intent = getIntent();
        user= (User) intent.getSerializableExtra("user");

        username=findViewById(R.id.username);
        username.setText(user.getFirstname() + " " + user.getLastname());
        email=findViewById(R.id.emailUser);
        email.setText(user.getEmail());
        imageUser=findViewById(R.id.imageUser);
        imageUser.setImageBitmap(DataConvertor.convertByteArrayToImage(user.getPic()));

        account=findViewById(R.id.account);
        account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User user=new User();
                user= (User) intent.getSerializableExtra("user");
                startActivity(new Intent(ProfileActivity.this, UserDetailsActivity.class)
                        .putExtra("user", (Serializable) user));
            }
        });
        logout=findViewById(R.id.logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ProfileActivity.this, LoginActivity.class));
            }
        });
        homeImage=findViewById(R.id.homeImage);
        homeImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ProfileActivity.this, MainActivity.class));
            }
        });
    }
}