package com.coffeemaker;

import com.coffeemaker.exceptions.RecipeException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RecipeSugarTests {
    private Recipe recipe1;

    @Before
    public void init() throws Exception {
        recipe1 = new Recipe();
    }

    //getAmtSugar
    @Test
    public void getAmtSugarBeforeTest(){
        int amt = recipe1.getAmtSugar();
        assertEquals(amt, 0);
    }

    @Test
    public void getAmtSugarAfterTest() throws RecipeException {
        String set = "5";
        recipe1.setAmtSugar(set);
        int amt = recipe1.getAmtSugar();
        assertEquals(amt, 5);
    }

    //setAmtSugar
    @Test
    public void setAmtSugarPositiveTest(){
        try {
            recipe1.setAmtSugar("42");
        } catch (RecipeException e) {
            fail();
        }
        assertEquals(recipe1.getAmtSugar(), 42);
    }
    @Test
    public void setAmtSugarZeroTest(){
        try {
            recipe1.setAmtSugar("0");
        } catch (RecipeException e) {
            fail();
        }
        assertEquals(recipe1.getAmtSugar(), 0);
    }
    @Test
    public void setAmtSugarNegativeTest(){
        try {
            recipe1.setAmtSugar("-3");
            fail();
        } catch (RecipeException e) {
            assertTrue(true);
        }
    }

    @Test
    public void setAmtSugarNotIntTest(){
        try {
            recipe1.setAmtSugar("hello");
            fail();
        } catch (RecipeException e) {
            assertTrue(true);
        }
    }
}
