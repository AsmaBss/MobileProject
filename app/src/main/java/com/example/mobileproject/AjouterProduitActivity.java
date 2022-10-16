package com.example.mobileproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class AjouterProduitActivity extends AppCompatActivity {
    private ConstraintLayout AjouterProduitBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajouterproduit);

        // Register
        AjouterProduitBtn=findViewById(R.id.AjouterProduitBtn);
        AjouterProduitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AjouterProduitActivity.this, PanierActivity.class));
            }
        });

    }
}
