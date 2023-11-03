package com.sirma.inventory.models;

public class InventoryItem extends AbstractItem {
    private String itemID; // Unique identifier for each inventory item
    private int quantity; // Quantity of the item in inventory

    public InventoryItem(String id, String name, double price, String itemID, int quantity) {
        super(id, name, price);
        this.itemID = itemID;
        this.quantity = quantity;
    }

    // Getters and setters for itemID and quantity
    public String getItemID() {
        return itemID;
    }

    public void setItemID(String itemID) {
        this.itemID = itemID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // Concrete implementation of displayDescription() from AbstractItem
    @Override
    public void displayDescription() {
        System.out.println("Item ID: " + getItemID() + ", Name: " + getName() + ", Price: " + getPrice() + ", Quantity: " + getQuantity());
    }

    @Override
    public void handleBreakage() {
    }

    @Override
    public void handleExpiration() {
    }

    @Override
    public void handlePerishable() {
    }

    @Override
    public boolean isSellable() {
        return false;
    }

    @Override
    public void handleSellable() {

    }
}

