package com.sirma.inventory.utils;

import com.sirma.inventory.models.InventoryItem;

import java.io.*;
import java.util.List;

public class FileIOUtility {

    public static void saveInventoryToFile(List<InventoryItem> inventory, String filename) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
            out.writeObject(inventory);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<InventoryItem> loadInventoryFromFile(String filename) {
        List<InventoryItem> inventory = null;
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
            inventory = (List<InventoryItem>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return inventory;
    }
}
