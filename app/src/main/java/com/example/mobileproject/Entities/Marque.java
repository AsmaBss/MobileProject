package com.example.mobileproject.Entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Marque")
public class Marque {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "NomMarque")
    private MarqueEnum NomMarque;
    //private String NomMarque;
    @ColumnInfo(name = "picMarque")
    private String picMarque;

    public Marque() {
    }

    public Marque(MarqueEnum nomMarque) {
        NomMarque = nomMarque;
    }

    public Marque(int id, MarqueEnum nomMarque, String picMarque) {
        this.id = id;
        NomMarque = nomMarque;
        this.picMarque = picMarque;
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

    public MarqueEnum getNomMarque() {
        return NomMarque;
    }

    public void setNomMarque(MarqueEnum nomMarque) {
        NomMarque = nomMarque;
    }
}
