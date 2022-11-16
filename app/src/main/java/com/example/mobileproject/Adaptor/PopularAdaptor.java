package com.example.mobileproject.Adaptor;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.mobileproject.DetailProduitActivity;
import com.example.mobileproject.Domain.CategoryDomain;
import com.example.mobileproject.Domain.ProductDomain;
import com.example.mobileproject.Entities.Produit;
import com.example.mobileproject.R;

import java.io.Serializable;
import java.util.ArrayList;

public class PopularAdaptor extends RecyclerView.Adapter<PopularAdaptor.ViewHolder> {
    ArrayList<Produit> produits;

    public PopularAdaptor(ArrayList<Produit> produits) {
        this.produits = produits;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_popular, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.prodName.setText(produits.get(position).getNom());
        holder.prodColor.setText("Couleur: " + produits.get(position).getCouleur());
        holder.prodMarque.setText("Marque: " + produits.get(position).getMarque().name());
        holder.prodType.setText("Type: " + produits.get(position).getTypeProduit().name());
        holder.prodFee.setText(String.valueOf(produits.get(position).getPrix()));
        //holder.onClick();
    }

    @Override
    public int getItemCount() {
        return produits.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView prodName;
        TextView prodColor;
        TextView prodMarque;
        TextView prodType;
        TextView prodFee;
        TextView addBtn;
        private final Context context;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            context = itemView.getContext();
            prodName=itemView.findViewById(R.id.prodName);
            prodColor=itemView.findViewById(R.id.prodColor);
            prodMarque=itemView.findViewById(R.id.prodMarque);
            prodType=itemView.findViewById(R.id.prodType);
            prodFee=itemView.findViewById(R.id.prodFee);
            addBtn=itemView.findViewById(R.id.addBtn);
            itemView.setClickable(true);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Produit produit = produits.get(getAdapterPosition()+1);
            //Toast.makeText(context,"The Item Clicked is: "+ getAdapterPosition(),Toast.LENGTH_SHORT).show();
            final Intent intent = new Intent(context, DetailProduitActivity.class);
            context.startActivity(intent.putExtra("produit", (Serializable) produit));
        }
    }

}
