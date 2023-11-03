package com.sirma.inventory.ui;

import com.sirma.inventory.models.InventoryItem;
import com.sirma.inventory.utils.FileIOUtility;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CLI {

    private List<InventoryItem> inventory;
    private Scanner scanner = new Scanner(System.in);

    public CLI() {
        this.inventory = FileIOUtility.loadInventoryFromFile("src/com/sirma/inventory/ui/data.csv");
    }

    public void start() {
        while (true) {
            displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();
            handleUserChoice(choice);
        }
    }

    private void displayMenu() {
        System.out.println("1. Add Item");
        System.out.println("2. Remove Item");
        System.out.println("3. Display Items");
        System.out.println("4. Orders... --- TODO");
        System.out.println("4. Exit");
        System.out.print("Enter choice: ");
    }

    private void handleUserChoice(int choice) {
        switch (choice) {
            case 1:
                addItem();
                break;
            case 2:
                removeItem();
                break;
            case 3:
                displayItems();
                break;
            case 4:
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice. Please enter a number between 1 and 4.");
        }
    }

    private void addItem() {
        scanner.nextLine(); // Consume any leftover newline
        System.out.println("Enter item details:");

        System.out.print("Item ID: ");
        String itemID = scanner.nextLine();

        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Price: ");
        double price = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        System.out.print("Category: ");
        String category = scanner.nextLine();

        System.out.print("Is the item breakable? (true/false): ");
        boolean isBreakable = scanner.nextBoolean();
        scanner.nextLine(); // Consume newline

        System.out.print("Is the item perishable? (true/false): ");
        boolean isPerishable = scanner.nextBoolean();
        scanner.nextLine(); // Consume newline

        System.out.print("Quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        InventoryItem newItem = new InventoryItem(itemID, name, price, category, isBreakable, isPerishable, quantity);
        inventory.add(newItem);

        // Save the updated inventory to the file
        FileIOUtility.saveInventoryToFile(inventory, "src/com/sirma/inventory/ui/data.csv");

        System.out.println("Item added successfully!");
    }


    private void removeItem() {
        System.out.print("Enter the Item ID of the item to remove: ");
        String itemID = scanner.next();

        InventoryItem itemToRemove = null;
        for (InventoryItem item : inventory) {
            if (item.getItemID().equals(itemID)) {
                itemToRemove = item;
                break;
            }
        }

        if (itemToRemove != null) {
            inventory.remove(itemToRemove);
            FileIOUtility.saveInventoryToFile(inventory, "src/com/sirma/inventory/ui/data.csv");
            System.out.println("Item removed successfully!");
        } else {
            System.out.println("Item not found.");
        }
    }

    private void displayItems() {
        System.out.println("1. Display all items");
        System.out.println("2. Display items from a specific category");
        System.out.println("3. Display fragile items");
        System.out.print("Enter choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // consume the remaining newline

        switch (choice) {
            case 1:
                displayAllItems();
                break;
            case 2:
                displayItemsByCategory();
                break;
            case 3:
                displayFragileItems();
                break;
            default:
                System.out.println("Invalid choice. Please enter a number between 1 and 3.");
        }
    }

    private void displayAllItems() {
        for (InventoryItem item : inventory) {
            item.displayDescription();
        }
    }

    private void displayItemsByCategory() {
        List<String> categories = getUniqueCategories();

        System.out.println("Select a category:");
        for (int i = 0; i < categories.size(); i++) {
            System.out.println((i+1) + ". " + categories.get(i));
        }

        System.out.print("Enter choice: ");
        int choice = scanner.nextInt();

        if (choice > 0 && choice <= categories.size()) {
            String selectedCategory = categories.get(choice - 1);
            for (InventoryItem item : inventory) {
                if (selectedCategory.equalsIgnoreCase(item.getCategory())) {
                    item.displayDescription();
                }
            }
        } else {
            System.out.println("Invalid choice. Please select a valid category.");
        }
    }

    private List<String> getUniqueCategories() {
        List<String> categories = new ArrayList<>();
        for (InventoryItem item : inventory) {
            String category = item.getCategory();
            if (!categories.contains(category)) {
                categories.add(category);
            }
        }
        return categories;
    }


    private void displayFragileItems() {
        for (InventoryItem item : inventory) {
            if (item.isBreakable()) {
                item.displayDescription();
            }
        }
    }

}
