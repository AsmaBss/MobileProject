package com.example.mobileproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.mobileproject.Entities.User;

import java.io.Serializable;

public class ProfileActivity extends AppCompatActivity {
 private LinearLayout account;
 private TextView username, email;

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
    }
}