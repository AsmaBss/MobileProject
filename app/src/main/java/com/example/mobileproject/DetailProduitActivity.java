package com.example.mobileproject;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.mobileproject.Database.AppDatabase;
import com.example.mobileproject.Entities.Produit;

public class DetailProduitActivity  extends AppCompatActivity {
    private AppDatabase database;
    private TextView produit_titre, produit_description, produit_marque, produit_type, produit_couleur, total;
    private ConstraintLayout addProduitPanier;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detaillesproduit);

        Produit produit =new Produit();
        Intent intent = getIntent();
        produit= (Produit) intent.getSerializableExtra("produit");

        database = AppDatabase.getAppDatabase(getApplicationContext());
        produit_titre = findViewById(R.id.produit_titre);
        produit_titre.setText(produit.getNom());
        produit_description = findViewById(R.id.produit_description);
        produit_description.setText(produit.getDescription());
        produit_marque = findViewById(R.id.produit_marque);
        produit_marque.setText("Marque : " + produit.getMarque());
        produit_type = findViewById(R.id.produit_type);
        produit_type.setText("Type : " + produit.getTypeProduit());
        produit_couleur = findViewById(R.id.produit_couleur);
        produit_couleur.setText("Couleur : " + produit.getCouleur());
        total = findViewById(R.id.Total);
        total.setText(produit.getPrix()+"");



    }
}
