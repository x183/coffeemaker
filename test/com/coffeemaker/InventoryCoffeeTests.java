package com.coffeemaker;

import com.coffeemaker.exceptions.InventoryException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class InventoryCoffeeTests {
    Inventory setCoffeeTestInventory,addCoffeeTestInventory;
    @Before
    public void beforeBeginning(){
        setCoffeeTestInventory = new Inventory();
        addCoffeeTestInventory = new Inventory();
    }
    @Test
    public void testSettingCoffeeNegative(){
        setCoffeeTestInventory.setCoffee(-1);
        assertTrue(setCoffeeTestInventory.getCoffee() >= 0);
    }
    @Test
    public void testSettingCoffeeZero(){
        setCoffeeTestInventory.setCoffee(0);
        assertEquals(0, setCoffeeTestInventory.getCoffee());
    }
    @Test
    public void TestSettingCoffeeNormal() {
        setCoffeeTestInventory.setCoffee(1);
        assertEquals(1, setCoffeeTestInventory.getCoffee());
    }

    @Test
    public void testAddCoffeeEmpty() {
        assertThrows(InventoryException.class, () -> {
            addCoffeeTestInventory.addCoffee("");
        });
    }
    @Test
    public void testAddCoffeeNegative(){
        assertThrows(InventoryException.class, () -> {
            addCoffeeTestInventory.addCoffee("-1");
        });
    }
    @Test
    public void testMaxIntCoffeeAddTesting() {
        addCoffeeTestInventory.setCoffee(1);
        try {
            addCoffeeTestInventory.addCoffee("2147483647");
            System.out.println(addCoffeeTestInventory.getCoffee());
        }catch(Exception e){
            fail("Big numbers shouldn't lead to an exception");
        }
        assertTrue(setCoffeeTestInventory.getCoffee() >= 0);
    }
    @Test
    public void testBigBigIntCoffeeAddTesting(){
        addCoffeeTestInventory.setCoffee(0);
        try {
            addCoffeeTestInventory.addCoffee("2147483650");
        }catch(Exception e){
            fail("Big numbers shouldn't lead to an exception");
        }
        assertTrue(addCoffeeTestInventory.getCoffee()>0);
    }
    @Test
    public void testAddCoffeeNormal(){
        addCoffeeTestInventory.setCoffee(5);
        try {
            addCoffeeTestInventory.addCoffee("5");
        }catch(Exception e){
            fail("Adding numbers shouldn't lead to an exception");
        }
        assertEquals(10,addCoffeeTestInventory.getCoffee());
    }
    @Test
    public void testAddCoffeeLetter(){
        assertThrows(InventoryException.class, () -> {
            addCoffeeTestInventory.addCoffee("a");
        });
           }
}
