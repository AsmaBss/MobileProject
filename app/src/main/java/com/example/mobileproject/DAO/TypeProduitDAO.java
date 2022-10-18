package com.example.mobileproject.DAO;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.mobileproject.Entities.TypeProduit;

import java.util.List;

public interface TypeProduitDAO {
    @Insert
    void insertOne(TypeProduit TypeProduit);
    @Delete
    void delete(TypeProduit TypeProduit);
    @Query("SELECT * FROM TypeProduit")
    List<TypeProduit> getAll();
}
