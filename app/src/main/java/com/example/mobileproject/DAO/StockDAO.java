package com.example.mobileproject.DAO;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.mobileproject.Entities.Stock;

import java.util.List;

public interface StockDAO {
    @Insert
    void insertOne(Stock Stock);
    @Delete
    void delete(Stock Stock);
    @Query("SELECT * FROM Stock")
    List<Stock> getAll();
}
