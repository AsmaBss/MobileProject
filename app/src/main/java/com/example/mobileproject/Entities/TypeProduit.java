package com.example.mobileproject.Entities;
import androidx.room.Entity;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
@Entity(tableName = "TypeProduit")
public class TypeProduit {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "NomTypeProduit")
    private String NomTypeProduit;

    public TypeProduit() {
    }

    public TypeProduit(String nomTypeProduit) {
        NomTypeProduit = nomTypeProduit;
    }

    public TypeProduit(int id, String nomTypeProduit) {
        this.id = id;
        NomTypeProduit = nomTypeProduit;
    }

    @Override
    public String toString() {
        return "TypeProduit{" +
                "id=" + id +
                ", NomTypeProduit='" + NomTypeProduit + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomTypeProduit() {
        return NomTypeProduit;
    }

    public void setNomTypeProduit(String nomTypeProduit) {
        NomTypeProduit = nomTypeProduit;
    }
}
