package com.sirma.inventory.models;

public class GroceryItem extends InventoryItem {
    private String expirationDate;

    public GroceryItem(String id, String name, double price, String itemID, int quantity, String expirationDate) {
        super(id, name, price, itemID, quantity);
        this.expirationDate = expirationDate;
    }

    @Override
    public void displayDescription() {
        super.displayDescription();
        System.out.println("Expiration Date: " + expirationDate);
    }

    @Override
    public void handleExpiration() {
        System.out.println("Checking expiration date for item: " + getName());
    }
}
