package com.coffeemaker;

import com.coffeemaker.exceptions.InventoryException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class InventoryMilkTests {
    Inventory setMilkTestInventory,addMilkTestInventory;
    @Before
    public void beforeBeginning(){
        setMilkTestInventory = new Inventory();
        addMilkTestInventory = new Inventory();
    }
    @Test
    public void testSettingMilkNegative(){
        setMilkTestInventory.setMilk(-1);
        assertTrue(setMilkTestInventory.getMilk() >= 0);
    }
    @Test
    public void testSettingMilkZero(){
        setMilkTestInventory.setMilk(0);
        assertEquals(0, setMilkTestInventory.getMilk());
    }
    @Test
    public void TestSettingMilkNormal() {
        setMilkTestInventory.setMilk(1);
        assertEquals(1, setMilkTestInventory.getMilk());
    }

    @Test
    public void testAddMilkEmpty() {
        assertThrows(InventoryException.class, () -> {
            addMilkTestInventory.addMilk("");
        });
    }
    @Test
    public void testAddMilkNegative(){
        assertThrows(InventoryException.class, () -> {
            addMilkTestInventory.addMilk("-1");
        });
    }
    @Test
    public void testMaxIntMilkAddTesting() {
        addMilkTestInventory.setMilk(1);
        try {
            addMilkTestInventory.addMilk("2147483647");
            System.out.println(addMilkTestInventory.getMilk());
        }catch(Exception e){
            fail("Big numbers shouldn't lead to an exception");
        }
        assertTrue(setMilkTestInventory.getMilk() >= 0);
    }
    @Test
    public void testBigBigIntMilkAddTesting(){
        addMilkTestInventory.setMilk(0);
        try {
            addMilkTestInventory.addMilk("2147483650");
        }catch(Exception e){
            fail("Big numbers shouldn't lead to an exception");
        }
        assertTrue(addMilkTestInventory.getMilk()>0);
    }
    @Test
    public void testAddMilkNormal(){
        addMilkTestInventory.setMilk(5);
        try {
            addMilkTestInventory.addMilk("5");
        }catch(Exception e){
            fail("Adding numbers shouldn't lead to an exception");
        }
        assertEquals(10,addMilkTestInventory.getMilk());
    }
}
