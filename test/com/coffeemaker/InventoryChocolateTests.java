package com.coffeemaker;

import com.coffeemaker.exceptions.InventoryException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class InventoryChocolateTests {
    Inventory setChocolateTestInventory,addChocolateTestInventory;
    @Before
    public void beforeBeginning(){
        setChocolateTestInventory = new Inventory();
        addChocolateTestInventory = new Inventory();
    }
    @Test
    public void testSettingChocolateNegative(){
        setChocolateTestInventory.setChocolate(-1);
        assertTrue(setChocolateTestInventory.getChocolate() >= 0);
    }
    @Test
    public void testSettingChocolateZero(){
        setChocolateTestInventory.setChocolate(0);
        assertEquals(0, setChocolateTestInventory.getChocolate());
    }
    @Test
    public void TestSettingChocolateNormal() {
        setChocolateTestInventory.setChocolate(1);
        assertEquals(1, setChocolateTestInventory.getChocolate());
    }

    @Test
    public void testAddChocolateEmpty() {
        assertThrows(InventoryException.class, () -> {
            addChocolateTestInventory.addChocolate("");
        });
    }
    @Test
    public void testAddChocolateNegative(){
        assertThrows(InventoryException.class, () -> {
            addChocolateTestInventory.addChocolate("-1");
        });
    }
    @Test
    public void testMaxIntChocolateAddTesting() {
        addChocolateTestInventory.setChocolate(1);
        try {
            addChocolateTestInventory.addChocolate("2147483647");
            System.out.println(addChocolateTestInventory.getChocolate());
        }catch(Exception e){
            fail("Big numbers shouldn't lead to an exception");
        }
        assertTrue(setChocolateTestInventory.getChocolate() >= 0);
    }
    @Test
    public void testBigBigIntChocolateAddTesting(){
        addChocolateTestInventory.setChocolate(0);
        try {
            addChocolateTestInventory.addChocolate("2147483650");
        }catch(Exception e){
            fail("Big numbers shouldn't lead to an exception");
        }
        assertTrue(addChocolateTestInventory.getChocolate()>0);
    }
    @Test
    public void testAddChocolateNormal(){
        addChocolateTestInventory.setChocolate(5);
        try {
            addChocolateTestInventory.addChocolate("5");
        }catch(Exception e){
            fail("Adding numbers shouldn't lead to an exception");
        }
        assertEquals(10,addChocolateTestInventory.getChocolate());
    }

}
