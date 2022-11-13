package com.example.mobileproject.Adaptor;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.mobileproject.Domain.CategoryDomain;
import com.example.mobileproject.Domain.ProductDomain;
import com.example.mobileproject.Entities.Produit;
import com.example.mobileproject.R;

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
    }

    @Override
    public int getItemCount() {
        return produits.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView prodName;
        TextView prodColor;
        TextView prodMarque;
        TextView prodType;
        TextView prodFee;
        TextView addBtn;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            prodName=itemView.findViewById(R.id.prodName);
            prodColor=itemView.findViewById(R.id.prodColor);
            prodMarque=itemView.findViewById(R.id.prodMarque);
            prodType=itemView.findViewById(R.id.prodType);
            prodFee=itemView.findViewById(R.id.prodFee);
            addBtn=itemView.findViewById(R.id.addBtn);
        }
    }

}
