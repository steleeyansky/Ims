package com.sirma.inventory.models;

public class ElectronicsItem extends InventoryItem {
    private String brand;

    public ElectronicsItem(String id, String name, double price, String itemID, int quantity, String brand) {
        super(id, name, price, itemID, quantity);
        this.brand = brand;
    }


    @Override
    public double calculateValue() {
        double baseValue = super.calculateValue();
        if ("PremiumBrand".equals(brand)) {
            return baseValue * 1.2; // Premium brands have a 20% markup
        }
        return baseValue;
    }

    @Override
    public void displayDescription() {
        super.displayDescription();
        System.out.println("Brand: " + brand);
    }
}
