package com.coffeemaker;

import com.coffeemaker.exceptions.RecipeException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RecipeMilkTests {
    private Recipe recipe1;

    @Before
    public void init() throws Exception {
        recipe1 = new Recipe();
    }

    //getAmtMilk
    @Test
    public void getAmtMilkBeforeTest(){
        int amt = recipe1.getAmtMilk();
        assertEquals(amt, 0);
    }

    @Test
    public void getAmtMilkAfterTest() throws RecipeException {
        String set = "5";
        recipe1.setAmtMilk(set);
        int amt = recipe1.getAmtMilk();
        assertEquals(amt, 5);
    }

    //setAmtMilk
    @Test
    public void setAmtMilkPositiveTest(){
        try {
            recipe1.setAmtMilk("42");
        } catch (RecipeException e) {
            fail();
        }
        assertEquals(recipe1.getAmtMilk(), 42);
    }
    @Test
    public void setAmtMilkZeroTest(){
        try {
            recipe1.setAmtMilk("0");
        } catch (RecipeException e) {
            fail();
        }
        assertEquals(recipe1.getAmtMilk(), 0);
    }
    @Test
    public void setAmtMilkNegativeTest(){
        try {
            recipe1.setAmtMilk("-3");
            fail();
        } catch (RecipeException e) {
            assertTrue(true);
        }
    }

    @Test
    public void setAmtMilkNotIntTest(){
        try {
            recipe1.setAmtMilk("hello");
            fail();
        } catch (RecipeException e) {
            assertTrue(true);
        }
    }
}
