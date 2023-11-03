package com.sirma.inventory.models;

import java.util.List;

public class Order {
    private List<InventoryItem> items;
    private Payment payment;

    public Order(List<InventoryItem> items, Payment payment) {
        this.items = items;
        this.payment = payment;
    }

    public double calculateTotal() {
        double total = 0;
        for (InventoryItem item : items) {
            total += item.calculateValue();
        }
        return total;
    }

    public void processPayment() {
        if (payment.getAmount() >= calculateTotal()) {
            updateInventoryQuantities();
            System.out.println("Payment processed successfully.");
        } else {
            System.out.println("Insufficient funds. Unable to process payment.");
        }
    }

    private void updateInventoryQuantities() {
        for (InventoryItem item : items) {
            int currentQuantity = item.getQuantity();
            item.setQuantity(currentQuantity - 1);
        }
    }
}
