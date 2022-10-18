package com.example.mobileproject.Entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Marque")
public class Marque {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "NomMarque")
    private String NomMarque;

    public Marque() {
    }

    public Marque(String nomMarque) {
        NomMarque = nomMarque;
    }

    public Marque(int id, String nomMarque) {
        this.id = id;
        NomMarque = nomMarque;
    }

    @Override
    public String toString() {
        return "Marque{" +
                "id=" + id +
                ", NomMarque='" + NomMarque + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomMarque() {
        return NomMarque;
    }

    public void setNomMarque(String nomMarque) {
        NomMarque = nomMarque;
    }
}
