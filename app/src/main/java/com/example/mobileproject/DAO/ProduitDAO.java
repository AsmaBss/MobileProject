package com.example.mobileproject.DAO;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.mobileproject.Entities.Produit;

import java.util.List;

public interface ProduitDAO {
    @Insert
    void insertOne(Produit produit);
    @Delete
    void delete(Produit produit);
    @Query("SELECT * FROM Produit")
    List<Produit> getAll();
}
