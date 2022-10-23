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
import com.example.mobileproject.Adaptor.PopularAdaptor;
import com.example.mobileproject.Domain.CategoryDomain;
import com.example.mobileproject.Domain.ProductDomain;
import com.example.mobileproject.Entities.User;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
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
        //
        nav_ajouterproduit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, AjouterProduitActivity.class));
            }
        });
        //userlabel text
        //user_label.setText();
        // Profile
        profile = findViewById(R.id.profileBtn);
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ProfileActivity.class));
            }
        });
    }


    private void recyclerViewCategory(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewCategoryList=findViewById(R.id.recyclerViewCateg);
        recyclerViewCategoryList.setLayoutManager(linearLayoutManager);

        ArrayList<CategoryDomain> category = new ArrayList<>();
        category.add(new CategoryDomain("cat1", "cat_1"));
        category.add(new CategoryDomain("cat2", "cat_2"));
        category.add(new CategoryDomain("cat3", "cat_3"));
        category.add(new CategoryDomain("cat4", "cat_4"));
        category.add(new CategoryDomain("cat5", "cat_5"));
        adapterCategory = new CategoryAdaptor(category);
        recyclerViewCategoryList.setAdapter(adapterCategory);
    }

    private void recyclerViewPopular(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewPopularList=findViewById(R.id.recyclerViewPop);
        recyclerViewPopularList.setLayoutManager(linearLayoutManager);

        ArrayList<ProductDomain> products = new ArrayList<>();
        products.add(new ProductDomain("prod1","cat_2","prod1", 1.0));
        products.add(new ProductDomain("prod2","cat_2","prod2", 1.0));
        products.add(new ProductDomain("prod3","cat_2","prod3", 3.0));
        adapterPopular=new PopularAdaptor(products);
        recyclerViewPopularList.setAdapter(adapterPopular);

    }
}