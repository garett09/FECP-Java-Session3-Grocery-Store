import java.util.Map;

import java.util.HashMap;

public class Inventory {
    HashMap<String, Integer> inventoryHashMap = new HashMap<>();

    Inventory() {
        inventoryHashMap = new HashMap<String, Integer>();
    }

    public String addProduct(String productName, int quantity) {
        if (productName == null || productName.isEmpty()) {
            return "Product name cannot be empty.";
        }
        if (quantity <= 0) {
            return "Invalid quantity. Please enter a positive number.";
        }
        if (inventoryHashMap.containsKey(productName)) {
            return productName + " already exists in the inventory. Please update the stock instead.";
        }
        inventoryHashMap.put(productName, quantity);
        return "Added " + productName + " with quantity: " + quantity;

    }

    public String viewInventory() {
        if (inventoryHashMap.isEmpty()) {
            return "Inventory is empty.";
        }
        inventoryHashMap.forEach((product, quantity) -> {
            System.out.println("Product: " + product + ", Quantity: " + quantity + " pcs");

        });
        return "Inventory displayed successfully.";
    }

       public String checkProduct(String productName) {
            if (inventoryHashMap.containsKey(productName)) {
                int quantity = inventoryHashMap.get(productName);
                return "Product: " + productName + ", Quantity: " + quantity;
            } else {
                return productName + " is not available in the inventory.";
            }
        }

        public String updateStock(String productName, int newQuantity) {
            if (newQuantity <= 0) {
                return "Invalid quantity. Please enter a positive number.";
            }
            if (productName == null || productName.isEmpty()) {
                return "Product name cannot be empty.";
            }
            if (inventoryHashMap.containsKey(productName)) {
                inventoryHashMap.put(productName, newQuantity);
                return "Updated " + productName + " to quantity: " + newQuantity;
            } else {
                return productName + " is not available in the inventory.";
            }
        }
}

