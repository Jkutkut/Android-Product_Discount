package com.jkutkut.productdiscount.javabean;

import java.io.Serializable;

public class Product implements Serializable {
    private static final long serialVersionUID = 1L;

    private final String id;
    private final String name;
    private final String description;
    private final float price;

    public Product(String id, String name, String description, float price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    // Getters

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public float getPrice() {
        return price;
    }
}
