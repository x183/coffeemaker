package com.coffeemaker;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RecipeToStringTests {

    private Recipe recipe1;

    @Before
    public void init() throws Exception {
        recipe1 = new Recipe();
        recipe1.setName("Recipe");
    }

    @Test
    public void getNameBeforeTest(){
        String name = recipe1.getName();
        assertEquals(name, "Recipe");
    }
}
