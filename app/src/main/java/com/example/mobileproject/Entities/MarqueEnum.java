package com.example.mobileproject.Entities;

public enum MarqueEnum {
    MARQUE1("Cheese"),
    MARQUE2("Meat"),
    MARQUE3("Mergez"),
    MARQUE4("Coke"),
    MARQUE5("Frite");

    private String friendlyName;

    private MarqueEnum(String friendlyName) {
        this.friendlyName = friendlyName;
    }

    @Override
    public String toString() {
        return friendlyName;
    }
}
