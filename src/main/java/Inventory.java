import java.util.HashMap;

public class Inventory {
    private HashMap<String, Integer> inventoryHashMap = new HashMap<>();

    public Inventory() {
        inventoryHashMap = new HashMap<String, Integer>();
    }
    public void addProduct(String productName, int quantity) {
        if (quantity <= 0) {
            System.out.println("Invalid quantity. Please enter a positive number.");
            return;
        }
        inventoryHashMap.put(productName, inventoryHashMap.getOrDefault(productName, 0) + quantity);
        System.out.println("Added " + quantity + " of " + productName + " to the inventory.");
    }

    public void viewInventory(){
        if (inventoryHashMap.isEmpty()) {
            System.out.println("Inventory is empty.");
        } else {
            System.out.println("Current Inventory:");
            inventoryHashMap.forEach((product, quantity) ->
                System.out.println(product + ": " + quantity));

            }
        }
        public void checkProduct(String productName){
            if (inventoryHashMap.containsKey(productName)) {
                System.out.println(productName + " is available with quantity: " + inventoryHashMap.get(productName));
            } else {
                System.out.println(productName + " is not available in the inventory.");
            }
        }
    }
