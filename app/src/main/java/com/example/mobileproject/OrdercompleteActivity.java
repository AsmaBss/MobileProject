package com.example.mobileproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class OrdercompleteActivity extends AppCompatActivity {
    private ConstraintLayout VoirCommandeBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ordercomplete);

        // Register
        VoirCommandeBtn = findViewById(R.id.VoirCommandeBtn);
        VoirCommandeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(OrdercompleteActivity.this, MainActivity.class));
            }
        });
    }
}