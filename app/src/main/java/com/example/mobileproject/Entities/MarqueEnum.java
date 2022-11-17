package com.example.mobileproject.Entities;

public enum MarqueEnum {
    Cheese("Cheese"),
    Meat("Meat"),
    Mergez("Mergez"),
    Coke("Coke"),
    Frite("Frite");

    private String friendlyName;

    private MarqueEnum(String friendlyName) {
        this.friendlyName = friendlyName;
    }

    @Override
    public String toString() {
        return friendlyName;
    }
}
