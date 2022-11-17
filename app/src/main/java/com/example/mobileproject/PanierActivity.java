package com.example.mobileproject;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.pdf.PdfDocument;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mobileproject.Adaptor.MarqueAdaptor;
import com.example.mobileproject.Adaptor.PanierAdaptor;
import com.example.mobileproject.Entities.Marque;
import com.example.mobileproject.Entities.MarqueEnum;
import com.example.mobileproject.Entities.Produit;
import com.example.mobileproject.Entities.TypeProduitEnum;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class PanierActivity extends AppCompatActivity {
    private ConstraintLayout CheckoutBtn;
    private RecyclerView.Adapter adapterPanier;
    private RecyclerView recyclerViewPanierList;
    private TextView Total;
    float PrixTot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panier);
        //
        //Intent Store_Total = getIntent();

        recyclerViewPanier();
        //
        //Bundle bundle = getIntent().getExtras();
        //PrixTot = bundle.getFloat("TotalFee");
        //System.out.println("Value Total :"+PrixTot);
        //
        // Register
        CheckoutBtn = findViewById(R.id.CheckoutBtn);
        CheckoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(PanierActivity.this, OrdercompleteActivity.class));
            }
        });
    }
    private void recyclerViewPanier(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerViewPanierList=findViewById(R.id.RV_Panier);
        recyclerViewPanierList.setLayoutManager(linearLayoutManager);
        //
        Total=findViewById(R.id.Total);
        //
        ArrayList<Produit> produitspanier = new ArrayList<>();
        produitspanier.add(new Produit("testernom","testeurdescription","bleu",(float)18, TypeProduitEnum.TYPE1,MarqueEnum.MARQUE2));
        produitspanier.add(new Produit("testernom2","testeurdescription2","red",(float)22, TypeProduitEnum.TYPE2,MarqueEnum.MARQUE3));
        for (Produit P:produitspanier) {
            PrixTot=PrixTot+P.getPrix();
        }
        adapterPanier = new PanierAdaptor(produitspanier);
        recyclerViewPanierList.setAdapter(adapterPanier);
        Total.setText(PrixTot+" DT");
    }
}
