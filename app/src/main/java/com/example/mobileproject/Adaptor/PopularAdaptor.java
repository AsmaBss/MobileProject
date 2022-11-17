package com.example.mobileproject.Adaptor;


import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
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
import com.example.mobileproject.Entities.DataConvertor;
import com.example.mobileproject.Entities.Produit;
import com.example.mobileproject.MainActivity;
import com.example.mobileproject.PanierActivity;
import com.example.mobileproject.R;
import com.example.mobileproject.RegisterActivity;

import java.io.Serializable;
import java.util.ArrayList;

public class PopularAdaptor extends RecyclerView.Adapter<PopularAdaptor.ViewHolder> {
    ArrayList<Produit> produits;
    MainActivity Mc;
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
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.prodName.setText(produits.get(position).getNom());
        holder.imageProd.setImageBitmap(DataConvertor.convertByteArrayToImage(produits.get(position).getImage()));
        holder.addBtn.setText("add item"); //+String.valueOf(produits.get(position).getId())
        holder.addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    Intent intent = new Intent(view.getContext(), PanierActivity.class);
                    view.getContext().startActivity(intent);
                System.out.println(produits.get(position).getId());

            }
        });
        //
        holder.Supprimerbtn.setText("delete item");
        holder.Supprimerbtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                builder.setTitle(R.string.app_name);
                builder.setMessage("êtes-vous sûr de vouloir supprimer "+produits.get(position).getNom()+" ?");
                builder.setIcon(R.drawable.icon);
                //
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                        produits.remove(produits.get(position));
                        notifyDataSetChanged();
                        System.out.println("List des Produits "+produits);

                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                    }
                });
                //
                AlertDialog alert = builder.create();
                alert.show();
            }
        });
    }
    @Override
    public int getItemCount() {
        return produits.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView prodName;
        TextView addBtn;
        TextView Supprimerbtn;
        ImageView imageProd;
        private final Context context;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            context = itemView.getContext();
            prodName=itemView.findViewById(R.id.prodName);
            imageProd=itemView.findViewById(R.id.imageProd);
            addBtn=itemView.findViewById(R.id.addBtn);
            Supprimerbtn=itemView.findViewById(R.id.Supprimerbtn);
            itemView.setClickable(true);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Produit produit = produits.get(getAdapterPosition());
            //Toast.makeText(context,"The Item Clicked is: "+ getAdapterPosition(),Toast.LENGTH_SHORT).show();
            final Intent intent = new Intent(context, DetailProduitActivity.class);
            context.startActivity(intent.putExtra("produit", (Serializable) produit));
        }
    }

}
