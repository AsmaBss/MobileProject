package com.example.mobileproject.DAO;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.mobileproject.Entities.Marque;

import java.util.List;

public interface MarqueDAO {
    @Insert
    void insertOne(Marque Marque);
    @Delete
    void delete(Marque Marque);
    @Query("SELECT * FROM Marque")
    List<Marque> getAll();
}
