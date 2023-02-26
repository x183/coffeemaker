package com.coffeemaker;

import com.coffeemaker.exceptions.RecipeException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RecipeChocolateTests {
    private Recipe recipe1;

    @Before
    public void init() throws Exception {
        recipe1 = new Recipe();
    }

    //getAmtChocolate
    @Test
    public void getAmtChocolateBeforeTest(){
        int amt = recipe1.getAmtChocolate();
        assertEquals(amt, 0);
    }

    @Test
    public void getAmtChocolateAfterTest() throws RecipeException {
        String set = "5";
        recipe1.setAmtChocolate(set);
        int amt = recipe1.getAmtChocolate();
        assertEquals(amt, 5);
    }

    //setAmtChocolate
    @Test
    public void setAmtChocolatePositiveTest(){
        try {
            recipe1.setAmtChocolate("42");
        } catch (RecipeException e) {
            fail();
        }
        assertEquals(recipe1.getAmtChocolate(), 42);
    }
    @Test
    public void setAmtChocolateZeroTest(){
        try {
            recipe1.setAmtChocolate("0");
        } catch (RecipeException e) {
            fail();
        }
        assertEquals(recipe1.getAmtChocolate(), 0);
    }
    @Test
    public void setAmtChocolateNegativeTest(){
        try {
            recipe1.setAmtChocolate("-3");
            fail();
        } catch (RecipeException e) {
            assertTrue(true);
        }
    }

    @Test
    public void setAmtChocolateNotIntTest(){
        try {
            recipe1.setAmtChocolate("hello");
            fail();
        } catch (RecipeException e) {
            assertTrue(true);
        }
    }
}
