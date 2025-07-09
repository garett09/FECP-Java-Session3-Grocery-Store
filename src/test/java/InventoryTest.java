import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class InventoryTest {

    private Inventory inventory;

    @BeforeEach
    void setUp() {
        inventory = new Inventory();
    }

    @Test
    //Adding a new product with a valid quantity.
    void testAddBananaProductValid() {
        String result = inventory.addProduct("Banana", 30);
        assertEquals("Added Banana with quantity: 30", result);
    }

    @Test
    //Adding a new product with an invalid quantity (zero).
    void testAddMangoProductInvalidZero() {
        String result = inventory.addProduct("Mango", 0);
        assertEquals("Invalid quantity. Please enter a positive number.", result);
    }
    @Test
    //Adding a new product that already exists in the inventory.
    void testAddOrangeProductAlreadyExists() {
        inventory.addProduct("Orange", 20);
        String result = inventory.addProduct("Orange", 15);
        System.out.println(inventory.viewInventory());
        assertEquals("Orange already exists in the inventory. Please update the stock instead.", result);
    }

    @Test
    //Adding a new product that already exists but the quantity will override the old quantity.
    void testAddMilkProductAlreadyExistsOverride() {
        inventory.addProduct("Milk", 10);
        String result = inventory.addProduct("Milk", 20);
        System.out.println(inventory.viewInventory());
        assertEquals("Milk already exists in the inventory. Please update the stock instead.", result);
    }

    @Test
    //Check for an existing product
    void testCheckExistingProduct(){
        inventory.addProduct("Peanut", 10);
        inventory.checkProduct("Peanut");
        String result = inventory.checkProduct("Peanut");
        assertEquals("Product: Peanut, Quantity: 10", result);
    }

    @Test
    //Check Milk product that stock is 20
    void testCheckMilkProductStockIs20(){
        inventory.addProduct("Milk", 20);
        String result = inventory.checkProduct("Milk");
        assertEquals("Product: Milk, Quantity: 20", result);
    }

    @Test
    //Check for a product that does not exist
    void testProductThatDoesNotExist(){
        String result = inventory.checkProduct("Watermelon");
        assertEquals("Watermelon is not available in the inventory.", result);
    }

    @Test
    //Check for Ice Cream expect product not found.
    void testCheckIceCreamProductNotFound() {
        String result = inventory.checkProduct("Ice Cream");
        assertEquals("Ice Cream is not available in the inventory.", result);
    }

    




}