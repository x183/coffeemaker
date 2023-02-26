package com.coffeemaker;

import com.coffeemaker.exceptions.InventoryException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class InventorySugarTests {
    Inventory setSugarTestInventory,addSugarTestInventory;
    @Before
    public void beforeBeginning(){
        setSugarTestInventory = new Inventory();
        addSugarTestInventory = new Inventory();
    }
    @Test
    public void testSettingSugarNegative(){
        setSugarTestInventory.setSugar(-1);
        assertTrue(setSugarTestInventory.getSugar() >= 0);
    }
    @Test
    public void testSettingSugarZero(){
        setSugarTestInventory.setSugar(0);
        assertEquals(0, setSugarTestInventory.getSugar());
    }
    @Test
    public void TestSettingSugarNormal() {
        setSugarTestInventory.setSugar(1);
        assertEquals(1, setSugarTestInventory.getSugar());
    }

    @Test
    public void testAddSugarEmpty() {
        assertThrows(InventoryException.class, () -> {
            addSugarTestInventory.addSugar("");
        });
    }
    @Test
    public void testAddSugarNegative(){
        assertThrows(InventoryException.class, () -> {
            addSugarTestInventory.addSugar("-1");
        });
    }
    @Test
    public void testMaxIntSugarAddTesting() {
        addSugarTestInventory.setSugar(1);
        try {
            addSugarTestInventory.addSugar("2147483647");
            System.out.println(addSugarTestInventory.getSugar());
        }catch(Exception e){
            fail("Big numbers shouldn't lead to an exception");
        }
        assertTrue(setSugarTestInventory.getSugar() >= 0);
    }
    @Test
    public void testBigBigIntSugarAddTesting(){
        addSugarTestInventory.setSugar(0);
        try {
            addSugarTestInventory.addSugar("2147483650");
        }catch(Exception e){
            fail("Big numbers shouldn't lead to an exception");
        }
        assertTrue(addSugarTestInventory.getSugar()>0);
    }
    @Test
    public void testAddSugarNormal(){
        addSugarTestInventory.setSugar(5);
        try {
            addSugarTestInventory.addSugar("5");
        }catch(Exception e){
            fail("Adding numbers shouldn't lead to an exception");
        }
        assertEquals(10,addSugarTestInventory.getSugar());
    }

    @Test
    public void testAddSugarLetter(){
        assertThrows(InventoryException.class, () -> {
            addSugarTestInventory.addSugar("a");
        });
    }
}
