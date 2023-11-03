package com.sirma.inventory.models;

public class InventoryItem extends AbstractItem {
    private String itemID;
    private int quantity; // Quantity of the item in inventory

    public InventoryItem(String id, String name, double price, String itemID, int quantity) {
        super(id, name, price);
        this.itemID = itemID;
        this.quantity = quantity;
    }

    public InventoryItem(String id, String name, double price, String category, boolean isBreakable, boolean isPerishable, int quantity) {
        super(id, name, price, category, isBreakable, isPerishable);
        this.itemID = id; // Use 'id' to set 'itemID'
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

    public String toCSV() {
        // Convert the attributes of InventoryItem to a CSV formatted string
        return String.join(",",
                getItemID(),
                getName(),
                String.valueOf(getPrice()),
                getCategory(),
                String.valueOf(isBreakable()),
                String.valueOf(isPerishable()),
                String.valueOf(getQuantity())
        );
    }

    public static InventoryItem fromCSV(String csv) {
        String[] attributes = csv.split(",");

        String itemID = attributes[0];
        String name = attributes[1];
        double price = Double.parseDouble(attributes[2]);
        String category = attributes[3];
        boolean isBreakable = Boolean.parseBoolean(attributes[4]);
        boolean isPerishable = Boolean.parseBoolean(attributes[5]);
        int quantity = Integer.parseInt(attributes[6]);

        return new InventoryItem(itemID, name, price, category, isBreakable, isPerishable, quantity);
    }

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

