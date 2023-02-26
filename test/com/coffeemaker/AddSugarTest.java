package com.coffeemaker;

import com.coffeemaker.exceptions.InventoryException;
import com.coffeemaker.Inventory;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AddSugarTest {

    Inventory inventory;

    @Before
    public void setUp() {
        inventory = new Inventory();
    }

    @Test
    public void testAddSugar_CharacterInput() {

        assertThrows(InventoryException.class,
                () -> {
                    inventory.addSugar("abc");
                });
    }

    @Test
    public void testAddSugar_EmptyInput() {

        assertThrows(InventoryException.class,
                () -> {
                    inventory.addSugar("");
                });
    }

    @Test
    public void testAddSugar_NegativeNumber() {

        assertThrows(InventoryException.class, () -> {
            inventory.addSugar("-5");
        });

    }

    @Test
    public void testAddSugar_PositiveNumber() {

        try {
            inventory.addSugar("14");
        }catch (InventoryException e){
            fail("Should not throw InventoryException");
        }

        assertEquals(29, inventory.getSugar());
    }

    @Test
    public void testAddSugar_Zero() {

        try {
            inventory.addSugar("0");
        }catch (InventoryException e){
            fail("Should not throw InventoryException");
        }

        assertEquals(15, inventory.getSugar());
    }








}
