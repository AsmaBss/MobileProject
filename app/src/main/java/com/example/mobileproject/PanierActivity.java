package com.example.mobileproject;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.mobileproject.Adaptor.MarqueAdaptor;
import com.example.mobileproject.Adaptor.PanierAdaptor;
import com.example.mobileproject.Entities.Marque;
import com.example.mobileproject.Entities.MarqueEnum;
import com.example.mobileproject.Entities.Produit;
import com.example.mobileproject.Entities.TypeProduitEnum;

import java.util.ArrayList;

public class PanierActivity extends AppCompatActivity {
    private ConstraintLayout CheckoutBtn;
    private RecyclerView.Adapter adapterPanier;
    private RecyclerView recyclerViewPanierList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panier);
        //
        recyclerViewPanier();
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

        ArrayList<Produit> produitspanier = new ArrayList<>();
        produitspanier.add(new Produit("testernom","testeurdescription","bleu",(float)18, TypeProduitEnum.TYPE1,MarqueEnum.MARQUE2));
        produitspanier.add(new Produit("testernom2","testeurdescription2","red",(float)22, TypeProduitEnum.TYPE2,MarqueEnum.MARQUE3));
        adapterPanier = new PanierAdaptor(produitspanier);
        recyclerViewPanierList.setAdapter(adapterPanier);
    }
}
