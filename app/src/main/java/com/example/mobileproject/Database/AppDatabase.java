package com.example.mobileproject.Database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.mobileproject.DAO.ProduitDAO;
import com.example.mobileproject.DAO.UserDAO;
import com.example.mobileproject.Entities.Produit;
import com.example.mobileproject.Entities.Stock;
import com.example.mobileproject.Entities.User;

@Database(entities = {User.class, Produit.class, Stock.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase instance;
    public abstract UserDAO userDao() ;
    public abstract ProduitDAO produitDAO();
    public static AppDatabase getAppDatabase(Context context){
        if(instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "database")
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;

    }
    /*public static void destroyInstance() {
        instance = null;
    }*/
}
