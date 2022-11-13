package com.example.mobileproject.Entities;

public enum MarqueEnum {
    MARQUE1("MARQUE1"),
    MARQUE2("MARQUE2"),
    MARQUE3("MARQUE3"),
    MARQUE4("MARQUE4"),
    MARQUE5("MARQUE5");

    private String friendlyName;

    private MarqueEnum(String friendlyName) {
        this.friendlyName = friendlyName;
    }

    @Override
    public String toString() {
        return friendlyName;
    }
}
