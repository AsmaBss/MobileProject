package com.example.mobileproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.mobileproject.Adaptor.CategoryAdaptor;
import com.example.mobileproject.Adaptor.MarqueAdaptor;
import com.example.mobileproject.Adaptor.PopularAdaptor;
import com.example.mobileproject.Database.AppDatabase;
import com.example.mobileproject.Domain.CategoryDomain;
import com.example.mobileproject.Domain.ProductDomain;
import com.example.mobileproject.Entities.Marque;
import com.example.mobileproject.Entities.MarqueEnum;
import com.example.mobileproject.Entities.Produit;
import com.example.mobileproject.Entities.User;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private AppDatabase database;
    private RecyclerView.Adapter adapterCategory, adapterPopular;
    private RecyclerView recyclerViewCategoryList, recyclerViewPopularList;
    private ConstraintLayout nav_ajouterproduit;
    private TextView user_label;
    private LinearLayout profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewCategory();
        recyclerViewPopular();
        //nav_ajouterproduit
        nav_ajouterproduit=findViewById(R.id.nav_ajouterproduit);
        //
        //get User
        user_label=findViewById(R.id.userlabel);
        User user=new User();
        Intent intent = getIntent();
        user= (User) intent.getSerializableExtra("user");
        user_label.setText("Welcome "+user.getFirstname()+" "+user.getLastname());

        nav_ajouterproduit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, AjouterProduitActivity.class));
            }
        });

        profile = findViewById(R.id.profileBtn);
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User user=new User();
                user= (User) intent.getSerializableExtra("user");
                startActivity(new Intent(MainActivity.this, ProfileActivity.class)
                        .putExtra("user", (Serializable) user));
            }
        });
    }

    private void recyclerViewCategory(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewCategoryList=findViewById(R.id.recyclerViewCateg);
        recyclerViewCategoryList.setLayoutManager(linearLayoutManager);

        ArrayList<Marque> category = new ArrayList<>();
        category.add(new Marque(1, MarqueEnum.MARQUE1, "cat_1"));
        category.add(new Marque(2, MarqueEnum.MARQUE2, "cat_2"));
        category.add(new Marque(3, MarqueEnum.MARQUE3, "cat_3"));
        category.add(new Marque(4, MarqueEnum.MARQUE4, "cat_4"));
        category.add(new Marque(5, MarqueEnum.MARQUE5, "cat_5"));
        adapterCategory = new MarqueAdaptor(category);
        recyclerViewCategoryList.setAdapter(adapterCategory);
    }

    private void recyclerViewPopular(){
        database = AppDatabase.getAppDatabase(getApplicationContext());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewPopularList=findViewById(R.id.recyclerViewPop);
        recyclerViewPopularList.setLayoutManager(linearLayoutManager);
        ArrayList<Produit> produits = new ArrayList<>();
        produits = (ArrayList<Produit>) database.produitDAO().getAll();
        System.out.println("--------------------------------------------------------------------------- " + database.produitDAO().getAll());
        //ArrayList<ProductDomain> products = new ArrayList<>();
        /*products.add(new ProductDomain("prod1","cat_2","prod1", 1.0));
        products.add(new ProductDomain("prod2","cat_2","prod2", 1.0));
        products.add(new ProductDomain("prod3","cat_2","prod3", 3.0));*/
        adapterPopular=new PopularAdaptor(produits);
        recyclerViewPopularList.setAdapter(adapterPopular);



    }
}