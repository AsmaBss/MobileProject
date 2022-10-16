package com.example.mobileproject;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class PanierActivity extends AppCompatActivity {
    private ConstraintLayout CheckoutBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panier);

        // Register
        CheckoutBtn = findViewById(R.id.CheckoutBtn);
        CheckoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PanierActivity.this, OrdercompleteActivity.class));
            }
        });
    }
}
