package com.coffeemaker;

import com.coffeemaker.Recipe;
import com.coffeemaker.exceptions.RecipeException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RecipeCoffeeTests {
    private Recipe recipe1;

    @Before
    public void init() throws Exception {
        recipe1 = new Recipe();
    }

    //getAmtCoffee
    @Test
    public void getAmtCoffeeBeforeTest(){
        int amt = recipe1.getAmtCoffee();
        assertEquals(amt, 0);
    }

    @Test
    public void getAmtCoffeeAfterTest() throws RecipeException {
        String set = "5";
        recipe1.setAmtCoffee(set);
        int amt = recipe1.getAmtCoffee();
        assertEquals(amt, 5);
    }

    //setAmtCoffee
    @Test
    public void setAmtCoffeePositiveTest(){
        try {
            recipe1.setAmtCoffee("42");
        } catch (RecipeException e) {
            fail();
        }
        assertEquals(recipe1.getAmtCoffee(), 42);
    }
    @Test
    public void setAmtCoffeeZeroTest(){
        try {
            recipe1.setAmtCoffee("0");
        } catch (RecipeException e) {
            fail();
        }
        assertEquals(recipe1.getAmtCoffee(), 0);
    }
    @Test
    public void setAmtCoffeeNegativeTest(){
        try {
            recipe1.setAmtCoffee("-3");
            fail();
        } catch (RecipeException e) {
            assertTrue(true);
        }
    }
    @Test
    public void setAmtCoffeeNotIntTest(){
        try {
            recipe1.setAmtCoffee("hello");
            fail();
        } catch (RecipeException e) {
            assertTrue(true);
        }
    }
}
