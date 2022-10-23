package com.example.mobileproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class AjouterProduitActivity extends AppCompatActivity {
    private ConstraintLayout AjouterProduitBtn;
    String[] Types={"Type1","Type2","Type3","Type4","Type5"};
    String[] Marques={"Marque1","Marque2","Marque3","Marque4","Marque5"};
    AutoCompleteTextView Marque;
    AutoCompleteTextView Type;
    ArrayAdapter<String> MarqueAdapteritems;
    ArrayAdapter<String> TypeAdapteritems;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajouterproduit);
        //
        Marque=findViewById(R.id.marque_produit);
        Type=findViewById(R.id.type_produit);

        TypeAdapteritems = new ArrayAdapter<String>(this,R.layout.list_types,Types);
        MarqueAdapteritems = new ArrayAdapter<String>(this,R.layout.list_types,Marques);

        Marque.setAdapter(MarqueAdapteritems);
        Type.setAdapter(TypeAdapteritems);

        Marque.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    String item= adapterView.getItemAtPosition(i).toString();
                        Toast.makeText(getApplicationContext(), "Item: "+item, Toast.LENGTH_SHORT).show();
                    }
                }
        );

        Type.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        String item= adapterView.getItemAtPosition(i).toString();
                        Toast.makeText(getApplicationContext(), "Item: "+item, Toast.LENGTH_SHORT).show();
                    }
                }
        );

        AjouterProduitBtn=findViewById(R.id.AjouterProduitBtn);
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
