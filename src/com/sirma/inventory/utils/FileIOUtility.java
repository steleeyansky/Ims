package com.sirma.inventory.utils;

import com.sirma.inventory.models.InventoryItem;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileIOUtility {
    public static void saveInventoryToFile(List<InventoryItem> inventory, String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (InventoryItem item : inventory) {
                writer.write(item.toCSV());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static List<InventoryItem> loadInventoryFromFile(String filename) {
        List<InventoryItem> inventory = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            boolean isHeader = true; // Flag to check if the current line is the header

            while ((line = reader.readLine()) != null) {
                if (isHeader) {
                    isHeader = false; // Skip the header line
                    continue;
                }

                InventoryItem item = InventoryItem.fromCSV(line);
                inventory.add(item);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return inventory;
    }

}
