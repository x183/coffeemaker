package com.coffeemaker;

import com.coffeemaker.exceptions.RecipeException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RecipeNameTests {
    private Recipe recipe1;

    @Before
    public void init() throws Exception {
        recipe1 = new Recipe();
    }

    //getName
    @Test
    public void getNameBeforeTest(){
        String name = recipe1.getName();
        assertEquals(name, "");
    }

    @Test
    public void getNameAfterTest(){
        String set = "best recipe";
        recipe1.setName(set);
        String name = recipe1.getName();
        assertEquals(name, set);
    }

    @Test
    public void setNameTest(){
        String set = "the best recipe";
        recipe1.setName(set);
        String name = recipe1.getName();
        assertEquals(name, set);
    }

}