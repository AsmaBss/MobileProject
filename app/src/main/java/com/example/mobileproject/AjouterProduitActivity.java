package com.example.mobileproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuAdapter;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.mobileproject.Adaptor.MarqueAdaptor;
import com.example.mobileproject.Database.AppDatabase;
import com.example.mobileproject.Entities.MarqueEnum;
import com.example.mobileproject.Entities.Produit;
import com.example.mobileproject.Entities.TypeProduitEnum;

public class AjouterProduitActivity extends AppCompatActivity {
    private AppDatabase database;
    private ConstraintLayout AjouterProduitBtn;
    private EditText nom_produit, couleur_produit, prix_produit, description_produit;
    private AutoCompleteTextView marque_produit, type_produit;

    AutoCompleteTextView Marque;
    AutoCompleteTextView Type;
    String selectedMarque;
    String selectedType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajouterproduit);

        database = AppDatabase.getAppDatabase(getApplicationContext());
        nom_produit=findViewById(R.id.nom_produit);
        couleur_produit=findViewById(R.id.couleur_produit);
        prix_produit=findViewById(R.id.prix_produit);
        description_produit=findViewById(R.id.description_produit);
        type_produit=findViewById(R.id.type_produit);
        marque_produit=findViewById(R.id.marque_produit);

        marque_produit.setAdapter(new ArrayAdapter<MarqueEnum>(this, R.layout.list_types, MarqueEnum.values()));
        marque_produit.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        String item= adapterView.getItemAtPosition(i).toString();
                        selectedMarque=item;
                        System.out.println(" ----------------------------------------------------------------------------------------------------- " + selectedMarque);
                        Toast.makeText(getApplicationContext(), "Item: "+item, Toast.LENGTH_SHORT).show();
                    }
                }
        );

        type_produit.setAdapter(new ArrayAdapter<TypeProduitEnum>(this, R.layout.list_types, TypeProduitEnum.values()));
        type_produit.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        String item= adapterView.getItemAtPosition(i).toString();
                        selectedType=item;
                        System.out.println(" ----------------------------------------------------------------------------------------------------- " + selectedType);
                        Toast.makeText(getApplicationContext(), "Item: "+item, Toast.LENGTH_SHORT).show();
                    }
                }
        );

        AjouterProduitBtn=findViewById(R.id.AjouterProduitBtn);
        AjouterProduitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                database.produitDAO().insertOne(new Produit(
                        nom_produit.getText().toString(), description_produit.getText().toString(),
                        couleur_produit.getText().toString(), Float.parseFloat(prix_produit.getText().toString()),
                        TypeProduitEnum.valueOf(selectedType), MarqueEnum.valueOf(selectedMarque)));
                System.out.println("****************************************************************************************** " + database.produitDAO().getAll());
                finish();
                startActivity(new Intent(AjouterProduitActivity.this, MainActivity.class));
            }
        });

    }
}
