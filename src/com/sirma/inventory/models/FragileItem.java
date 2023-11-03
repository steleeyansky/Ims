package com.sirma.inventory.models;

public class FragileItem extends InventoryItem {
    private String fragileCareInstructions;

    public FragileItem(String id, String name, double price, String itemID, int quantity, String fragileCareInstructions) {
        super(id, name, price, itemID, quantity);
        this.fragileCareInstructions = fragileCareInstructions;
    }
    @Override
    public void displayDescription() {
        super.displayDescription();
        System.out.println("Fragile Care Instructions: " + fragileCareInstructions);
    }

    @Override
    public void handleBreakage() {
        System.out.println("Handling breakage for fragile item: " + getName());
    }

}
