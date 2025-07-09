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
    void testAddBananaProductInvalidZero() {
        String result = inventory.addProduct("Mango", 0);
        assertEquals("Invalid quantity. Please enter a positive number.", result);
    }
    @Test
    //Adding a new product that already exists in the inventory.
    void testAddBananaProductAlreadyExists() {
        inventory.addProduct("Orange", 20);
        String result = inventory.addProduct("Orange", 15);
        System.out.println(inventory.viewInventory());
        assertEquals("Orange already exists in the inventory. Please update the stock instead.", result);
    }
    


}