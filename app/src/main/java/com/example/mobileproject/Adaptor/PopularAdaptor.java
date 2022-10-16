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
import com.example.mobileproject.R;

import java.util.ArrayList;

public class PopularAdaptor extends RecyclerView.Adapter<PopularAdaptor.ViewHolder> {
    ArrayList<ProductDomain> productDomains;

    public PopularAdaptor(ArrayList<ProductDomain> productDomains) {
        this.productDomains = productDomains;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_popular, parent, false);
        return new ViewHolder(inflate);
        //return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.prodName.setText(productDomains.get(position).getTitle());
        holder.prodFee.setText(String.valueOf(productDomains.get(position).getFee()));

        int drawbleRessourceId = holder.itemView.getContext().getResources().getIdentifier(productDomains.get(position).getPic(), "drawable", holder.itemView.getContext().getPackageName());
        System.out.println(drawbleRessourceId);
        Glide.with(holder.itemView.getContext())
                .load(drawbleRessourceId)
                .into(holder.prodPic);
    }

    @Override
    public int getItemCount() {
        return productDomains.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView prodName;
        ImageView prodPic;
        TextView prodFee;
        TextView addBtn;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            prodName=itemView.findViewById(R.id.prodName);
            prodPic=itemView.findViewById(R.id.prodPic);
            prodFee=itemView.findViewById(R.id.prodFee);
            addBtn=itemView.findViewById(R.id.addBtn);
        }
    }

}
