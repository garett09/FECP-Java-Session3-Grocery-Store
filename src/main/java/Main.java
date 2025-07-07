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
                        inventory.viewInventory();
                        break;
                    case 2:
                        System.out.print("Enter product name: ");
                        String productName = input.nextLine();
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
                        if (inventory.inventoryHashMap.containsKey(checkProductName)) {
                            System.out.println(checkProductName + " is available with quantity: " + inventory.inventoryHashMap.get(checkProductName));
                        } else {
                            System.out.println(checkProductName + " is not available in the inventory.");
                        }
                        break;
                }
            }





    }
}
