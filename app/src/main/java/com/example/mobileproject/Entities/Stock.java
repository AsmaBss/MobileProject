package com.example.mobileproject.Entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Stock")
public class Stock {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "quantité")
    private int quantité;
    @ColumnInfo(name = "id_produit")
    private int idproduit;
    @ColumnInfo(name = "id_user")
    private int iduser;

    public Stock(){
    }

    @Override
    public String toString() {
        return "Stock{" +
                "id=" + id +
                ", quantité=" + quantité +
                ", idproduit=" + idproduit +
                ", iduser=" + iduser +
                '}';
    }

    public Stock(int quantité, int idproduit, int iduser) {
        this.quantité = quantité;
        this.idproduit = idproduit;
        this.iduser = iduser;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantité() {
        return quantité;
    }

    public void setQuantité(int quantité) {
        this.quantité = quantité;
    }

    public int getIdproduit() {
        return idproduit;
    }

    public void setIdproduit(int idproduit) {
        this.idproduit = idproduit;
    }

    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }
}
