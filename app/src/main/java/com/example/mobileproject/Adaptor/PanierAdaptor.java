package com.example.mobileproject.Adaptor;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.mobileproject.Entities.Produit;
import com.example.mobileproject.R;

import java.util.ArrayList;

public class PanierAdaptor extends RecyclerView.Adapter<PanierAdaptor.ViewHolder>{
    ArrayList<Produit> productDomains;

    public PanierAdaptor(ArrayList<Produit> productDomains) {
        this.productDomains = productDomains;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_panierproduit, parent, false);
        return new ViewHolder(inflate);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.prodName.setText(productDomains.get(position).getNom());
        holder.prodColor.setText(productDomains.get(position).getCouleur());
        holder.prodMarque.setText(productDomains.get(position).getMarque().name());
        holder.prodType.setText(productDomains.get(position).getTypeProduit().name());
        holder.prodFee.setText(String.valueOf(productDomains.get(position).getPrix()));
        holder.floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                builder.setTitle(R.string.app_name);
                builder.setMessage("êtes-vous sûr de vouloir supprimer "+productDomains.get(position).getNom()+" ?");
                builder.setIcon(R.drawable.icon);
                //
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                        productDomains.remove(productDomains.get(position));
                        notifyDataSetChanged();
                        System.out.println("List des productDomains "+productDomains);

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
        return productDomains.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView prodName;
        TextView prodColor;
        TextView prodMarque;
        TextView prodType;
        TextView prodFee;
        TextView addBtn;
        com.google.android.material.floatingactionbutton.FloatingActionButton floatingActionButton;
        TextView addquantité;
        TextView decreasequantité;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            prodName=itemView.findViewById(R.id.prodName);
            prodColor=itemView.findViewById(R.id.prodColor);
            prodMarque=itemView.findViewById(R.id.prodMarque);
            prodType=itemView.findViewById(R.id.prodType);
            prodFee=itemView.findViewById(R.id.prodFee);
            addBtn=itemView.findViewById(R.id.addBtn);
            floatingActionButton=itemView.findViewById(R.id.floatingActionButton);
            //
            addquantité =itemView.findViewById(R.id.addquantité);
            decreasequantité=itemView.findViewById(R.id.decreasequantité);
        }
    }
}
