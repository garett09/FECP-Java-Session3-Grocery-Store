import java.util.Scanner;

public class Main {

    public static String capitalize(String str)
    {
        if(str == null || str.length()<=1) return str;
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }
        public static void main(String[] args) {
            int userChoice = 0;
            Scanner input = new Scanner(System.in);
            Inventory inventory = new Inventory();

            inventory.addProduct("Apples", 10);


            while(userChoice <=7){
                System.out.println("=== Buni's Grocery Inventory Menu ===");
                System.out.println("1. View Inventory");
                System.out.println("2. Add Product");
                System.out.println("3. Check Product");
                System.out.println("4. Update Stock");
                System.out.println("5. Remove Product");
                System.out.println("6. Exit");

                while(!input.hasNextInt()) {
                    System.out.println("Invalid Input. Please input between 1 and 5");
                    input.next();
                    System.out.println("Choose your option:");
                }
                userChoice = input.nextInt();
                input.nextLine();

                switch(userChoice) {
                    case 1:
                        System.out.println("Viewing Inventory...");
                        System.out.println(inventory.viewInventory());
                        break;
                    case 2:
                        System.out.print("Enter product name: ");
                        String productName = input.nextLine();
                        productName = capitalize(productName);
                        System.out.print("Enter quantity: ");
                        while (!input.hasNextInt()) {
                            System.out.println("Invalid Input. Please input a whole number");
                            input.next();
                            System.out.print("Enter quantity: ");
                        }
                        int quantity = input.nextInt();
                        inventory.addProduct(productName, quantity);
                        break;
                    case 3:
                        System.out.print("Enter product name to check: ");
                        String checkProductName = input.nextLine();
                        checkProductName = capitalize(checkProductName);
                        String checkResult = inventory.checkProduct(checkProductName);
                        System.out.println(checkResult);
                        break;
                    case 4:
                        System.out.print("Enter product name to update: ");
                        String updateProductName = input.nextLine();
                        updateProductName = capitalize(updateProductName);
                        if (!inventory.inventoryHashMap.containsKey(updateProductName)) {
                            System.out.println("Product not found in inventory.");
                            break;
                        }
                        System.out.print("Enter new quantity: ");
                        while (!input.hasNextInt()) {
                            System.out.println("Invalid Input. Please input a whole number");
                            input.next();
                            System.out.print("Enter new quantity: ");
                        }
                        int newQuantity = input.nextInt();
                        String updateResult = inventory.updateStock(updateProductName, newQuantity);
                        System.out.println(updateResult);
                        break;
                    case 5:
                        System.out.print("Enter product name to remove: ");
                        String removeProductName = input.nextLine();
                        removeProductName = capitalize(removeProductName);
                        if (!inventory.inventoryHashMap.containsKey(removeProductName)) {
                            System.out.println("Product not found in inventory.");
                            break;
                        }
                        String removeResult = inventory.removeProduct(removeProductName);
                        System.out.println(removeResult);
                        break;
                    case 6:
                        System.out.println("Exiting the program. Thank you for using Buni's Grocery Inventory!");
                        return;
                    default:
                        System.out.println("Invalid option. Please choose between 1 and 6.");
                        break;

                }
                }
            }

    }
