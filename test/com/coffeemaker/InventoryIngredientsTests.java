package com.coffeemaker;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class InventoryIngredientsTests {
    Recipe normalRecipe, tooMuchCoffeeRecipe, tooMuchMilkRecipe, tooMuchSugarRecipe, tooMuchChocolateRecipe;
    Inventory normalInventory, noTouchyInventory;
    @Before
    public void beforeTests(){
        normalRecipe = new Recipe();
        tooMuchChocolateRecipe = new Recipe();
        tooMuchCoffeeRecipe = new Recipe();
        tooMuchMilkRecipe = new Recipe();
        tooMuchSugarRecipe = new Recipe();

        normalInventory = new Inventory();
        noTouchyInventory = new Inventory();

        try {
            normalRecipe.setAmtCoffee("100");
            normalRecipe.setAmtChocolate("100");
            normalRecipe.setAmtMilk("100");
            normalRecipe.setAmtSugar("100");

            tooMuchSugarRecipe.setAmtSugar("200");
            tooMuchChocolateRecipe.setAmtChocolate("200");
            tooMuchMilkRecipe.setAmtMilk("200");
            tooMuchCoffeeRecipe.setAmtCoffee("200");
        }catch(Exception e){
            fail("Setting normal values shouldn't be a problem");
        }
            normalInventory.setCoffee(100);
            normalInventory.setChocolate(100);
            normalInventory.setMilk(100);
            normalInventory.setSugar(100);
    }
    @Test
    public void testNormalUse(){
        normalInventory.useIngredients(normalRecipe);
        assertEquals("Coffee; 0\nMilk: 0\nSugar: 0\nChocolate: 0\n", normalInventory.toString());
    }

    @Test
    public void testTooMuchCoffee(){
        assertFalse(noTouchyInventory.useIngredients(tooMuchCoffeeRecipe));
    }
    @Test
    public void testTooMuchMilk(){
        assertFalse(noTouchyInventory.useIngredients(tooMuchMilkRecipe));
    }
    @Test
    public void testTooMuchSugar(){
        assertFalse(noTouchyInventory.useIngredients(tooMuchSugarRecipe));
    }
    @Test
    public void testTooMuchChocolate(){
        assertFalse(noTouchyInventory.useIngredients(tooMuchChocolateRecipe));
    }

}
