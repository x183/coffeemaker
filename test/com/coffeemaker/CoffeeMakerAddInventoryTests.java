package com.coffeemaker;

import com.coffeemaker.exceptions.InventoryException;
import com.coffeemaker.exceptions.RecipeException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CoffeeMakerAddInventoryTests {

    private CoffeeMaker cf;

    @Before
    public void setUp() throws RecipeException{
        cf = new CoffeeMaker();
    }

    @Test
    public void testAddInventory_NegativeAmtCoffee() {

        assertThrows(InventoryException.class,
                () -> {
                    cf.addInventory("-2", "3", "1", "1");
                });

    }

    @Test
    public void testAddInventory_NegativeAmtMilk() {

        assertThrows(InventoryException.class,
                () -> {
                    cf.addInventory("2", "-3", "1", "1");
                });

    }

    @Test
    public void testAddInventory_NegativeAmtSugar() {

        assertThrows(InventoryException.class,
                () -> {
                    cf.addInventory("2", "3", "-1", "1");
                });

    }

    @Test
    public void testAddInventory_NegativeAmtChocolate() {

        assertThrows(InventoryException.class,
                () -> {
                    cf.addInventory("-2", "3", "1", "-1");
                });

    }

    @Test
    public void testAddInventory_CharAmtCoffee() {

        assertThrows(InventoryException.class,
                () -> {
                    cf.addInventory("a", "3", "1", "1");
                });

    }

    @Test
    public void testAddInventory_CharAmtMilk() {

        assertThrows(InventoryException.class,
                () -> {
                    cf.addInventory("2", "b", "1", "1");
                });

    }

    @Test
    public void testAddInventory_CharAmtSugar() {

        assertThrows(InventoryException.class,
                () -> {
                    cf.addInventory("2", "3", "c", "1");
                });

    }

    @Test
    public void testAddInventory_CharAmtChocolate() {

        assertThrows(InventoryException.class,
                () -> {
                    cf.addInventory("2", "3", "1", "d");
                });

    }

    @Test
    public void testAddInventory_EmptyAmtCoffee() {

        assertThrows(InventoryException.class,
                () -> {
                    cf.addInventory("", "3", "1", "1");
                });

    }

    @Test
    public void testAddInventory_EmptyAmtMilk() {

        assertThrows(InventoryException.class,
                () -> {
                    cf.addInventory("2", "", "1", "1");
                });

    }

    @Test
    public void testAddInventory_EmptyAmtSugar() {

        assertThrows(InventoryException.class,
                () -> {
                    cf.addInventory("2", "3", "", "1");
                });

    }

    @Test
    public void testAddInventory_EmptyAmtChocolate() {

        assertThrows(InventoryException.class,
                () -> {
                    cf.addInventory("2", "3", "1", "");
                });

    }

    @Test
    public void testAddInventory_NullAmtCoffee() {

        assertThrows(InventoryException.class,
                () -> {
                    cf.addInventory(null, "3", "1", "1");
                });

    }

    @Test
    public void testAddInventory_NullAmtMilk() {

        assertThrows(InventoryException.class,
                () -> {
                    cf.addInventory("2", null, "1", "1");
                });

    }

    @Test
    public void testAddInventory_NullAmtSugar() {

        assertThrows(InventoryException.class,
                () -> {
                    cf.addInventory("2", "3", null, "1");
                });

    }

    @Test
    public void testAddInventory_NullAmtChocolate() {

        assertThrows(InventoryException.class,
                () -> {
                    cf.addInventory("2", "3", "1", null);
                });

    }

    @Test
    public void testAddInventory_ValidAmtZeroSugar() {

        try {
            cf.addInventory("2", "3", "0", "1");
        }catch (InventoryException e){
            fail(e.getMessage());
        }

        String expectedInvent = cf.checkInventory();
        String actualInvent = "Coffee: 17\nMilk: 18\nSugar: 15\nChocolate: 16\n";

        assertEquals(expectedInvent, actualInvent);
    }

    @Test
    public void testAddInventory_ValidAmtPositiveSugar() {

        try {
            cf.addInventory("2", "3", "5", "1");
        }catch (InventoryException e){
            fail(e.getMessage());
        }

        String expectedInvent = cf.checkInventory();
        String actualInvent = "Coffee: 17\nMilk: 18\nSugar: 20\nChocolate: 16\n";

        assertEquals(expectedInvent, actualInvent);
    }
}
