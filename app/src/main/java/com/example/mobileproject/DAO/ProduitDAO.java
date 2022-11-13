package com.example.mobileproject.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.mobileproject.Entities.Produit;
import com.example.mobileproject.Entities.User;

import java.util.List;

@Dao
public interface ProduitDAO {
    @Insert
    void insertOne(Produit produit);
    @Delete
    void delete(Produit produit);
    @Query("SELECT * FROM produit")
    List<Produit> getAll();
}
