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
import com.example.mobileproject.Entities.Marque;
import com.example.mobileproject.R;

import java.util.ArrayList;

public class MarqueAdaptor extends RecyclerView.Adapter<MarqueAdaptor.ViewHolder> {
    ArrayList<Marque> marques;

    public MarqueAdaptor(ArrayList<Marque> marques) {
        this.marques = marques;
    }

    @NonNull
    @Override
    public MarqueAdaptor.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_category, parent, false);
        return new MarqueAdaptor.ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull MarqueAdaptor.ViewHolder holder, int position) {
        holder.categoryName.setText(marques.get(position).getNomMarque().name());
        String picUrl = "";
        switch (position){
            case 0 : {
                picUrl="cat_1";
                holder.mainLayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(), R.drawable.cat_background));
                break;
            }
            case 1 : {
                picUrl="cat_2";
                holder.mainLayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(), R.drawable.cat_background));
                break;
            }
            case 2 : {
                picUrl="cat_3";
                holder.mainLayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(), R.drawable.cat_background));
                break;
            }
            case 3 : {
                picUrl="cat_4";
                holder.mainLayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(), R.drawable.cat_background));
                break;
            }
            case 4 : {
                picUrl="cat_5";
                holder.mainLayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(), R.drawable.cat_background));
                break;
            }
        }
        int drawbleRessourceId = holder.itemView.getContext().getResources().getIdentifier(picUrl, "drawable", holder.itemView.getContext().getPackageName());
        System.out.println(drawbleRessourceId);
        Glide.with(holder.itemView.getContext())
                .load(drawbleRessourceId)
                .into(holder.categoryPic);
    }

    @Override
    public int getItemCount() {
        return marques.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView categoryName;
        ImageView categoryPic;
        ConstraintLayout mainLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            categoryName=itemView.findViewById(R.id.categoryName);
            categoryPic=itemView.findViewById(R.id.categoryPic);
            mainLayout=itemView.findViewById(R.id.mainLayout);
        }
    }
}
