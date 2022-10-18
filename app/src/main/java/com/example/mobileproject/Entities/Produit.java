package com.example.mobileproject.Entities;

import androidx.room.Entity;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Produit")
public class Produit {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "nom")
    private String nom;
    @ColumnInfo(name = "description")
    private String description;
    @ColumnInfo(name = "couleur")
    private String couleur;
    @ColumnInfo(name = "prix")
    private float prix;
    @ColumnInfo(name = "TypeProduit")
    private TypeProduit TypeProduit;
    @ColumnInfo(name = "image")
    private String image;
    @ColumnInfo(name = "Marque")
    private Marque Marque;

    public Produit() {
    }

    public Produit(String nom, String description, String couleur, float prix, com.example.mobileproject.Entities.TypeProduit typeProduit, String image, com.example.mobileproject.Entities.Marque marque) {
        this.nom = nom;
        this.description = description;
        this.couleur = couleur;
        this.prix = prix;
        TypeProduit = typeProduit;
        this.image = image;
        Marque = marque;
    }

    public Produit(int id, String nom, String description, String couleur, float prix, com.example.mobileproject.Entities.TypeProduit typeProduit, String image, com.example.mobileproject.Entities.Marque marque) {
        this.id = id;
        this.nom = nom;
        this.description = description;
        this.couleur = couleur;
        this.prix = prix;
        TypeProduit = typeProduit;
        this.image = image;
        Marque = marque;
    }

    @Override
    public String toString() {
        return "Produit{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", description='" + description + '\'' +
                ", couleur='" + couleur + '\'' +
                ", prix=" + prix +
                ", TypeProduit=" + TypeProduit +
                ", image='" + image + '\'' +
                ", Marque=" + Marque +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public com.example.mobileproject.Entities.TypeProduit getTypeProduit() {
        return TypeProduit;
    }

    public void setTypeProduit(com.example.mobileproject.Entities.TypeProduit typeProduit) {
        TypeProduit = typeProduit;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public com.example.mobileproject.Entities.Marque getMarque() {
        return Marque;
    }

    public void setMarque(com.example.mobileproject.Entities.Marque marque) {
        Marque = marque;
    }
}
