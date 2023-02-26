package com.coffeemaker;

import com.coffeemaker.exceptions.RecipeException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RecipePriceTests {
    private Recipe recipe1;

    @Before
    public void init() throws Exception {
        recipe1 = new Recipe();
    }

    //getPrice
    @Test
    public void getPriceBeforeTest(){
        int amt = recipe1.getPrice();
        assertEquals(amt, 0);
    }

    @Test
    public void getPriceAfterTest() throws RecipeException {
        String set = "5";
        recipe1.setPrice(set);
        int amt = recipe1.getPrice();
        assertEquals(amt, 5);
    }

    //setPrice
    @Test
    public void setPricePositiveTest(){
        try {
            recipe1.setPrice("42");
        } catch (RecipeException e) {
            fail();
        }
        assertEquals(recipe1.getPrice(), 42);
    }
    @Test
    public void setPriceZeroTest(){
        try {
            recipe1.setPrice("0");
        } catch (RecipeException e) {
            fail();
        }
        assertEquals(recipe1.getPrice(), 0);
    }
    @Test
    public void setPriceNegativeTest(){
        try {
            recipe1.setPrice("-3");
            fail();
        } catch (RecipeException e) {
            assertTrue(true);
        }
    }

    @Test
    public void setPriceNotIntTest(){
        try {
            recipe1.setPrice("hello");
            fail();
        } catch (RecipeException e) {
            assertTrue(true);
        }
    }
}
