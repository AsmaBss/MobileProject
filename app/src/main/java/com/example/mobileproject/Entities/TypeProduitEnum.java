package com.example.mobileproject.Entities;

public enum TypeProduitEnum {
    TYPE1("TYPE1"),
    TYPE2("TYPE2"),
    TYPE3("TYPE3"),
    TYPE4("TYPE4"),
    TYPE5("TYPE5");

    private String friendlyName;

    private TypeProduitEnum(String friendlyName) {
        this.friendlyName = friendlyName;
    }

    @Override
    public String toString() {
        return friendlyName;
    }
}
