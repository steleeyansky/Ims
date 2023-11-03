package com.sirma.inventory.models;

import com.sirma.inventory.interfaces.*;

public abstract class AbstractItem implements Item, Categorizable, Breakable, Perishable, Sellable {
    private String id;
    private String name;
    private double price;
    private String category;
    private boolean isBreakable;
    private boolean isPerishable;

    public AbstractItem(String id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    @Override
    public String getDetails() {
        return String.format("ID: %s, Name: %s, Price: %.2f", id, name, price);
    }

    public abstract void displayDescription();


    @Override
    public void setCategory(String category) {
        this.category = category;
    }
    @Override
    public String getCategory() {
        return category;
    }

    @Override
    public boolean isBreakable() {
        return isBreakable;
    }

    public abstract void handleBreakage();

    @Override
    public boolean isPerishable() {
        return isPerishable;
    }

    public abstract void handleExpiration();

    @Override
    public double calculateValue() {
        return price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // Additional getters and setters for other fields
}
