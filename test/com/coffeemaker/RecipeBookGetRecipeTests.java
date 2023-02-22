package com.coffeemaker;
import com.coffeemaker.exceptions.RecipeException;

import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Test;

public class RecipeBookGetRecipeTests {

    private RecipeBook rb;
    private Recipe r1;
    private Recipe r2;

    @Before
    public void setUp() throws RecipeException {

        rb = new RecipeBook();
        r1 = new Recipe();
        r1.setName("Coffee");
        r1.setAmtChocolate("0");
        r1.setAmtCoffee("3");
        r1.setAmtMilk("1");
        r1.setAmtSugar("1");
        r1.setPrice("50");

        //Set up for r2
        r2 = new Recipe();
        r2.setName("Mocha");
        r2.setAmtChocolate("20");
        r2.setAmtCoffee("3");
        r2.setAmtMilk("1");
        r2.setAmtSugar("1");
        r2.setPrice("75");

    }


    @Test
    public void testGetRecipes_WithRecipes() {

        boolean appended1 = rb.addRecipe(r1);
        boolean appended2 = rb.addRecipe(r2);

        //TODO: Should I check if the return values are true as well ?
        assertTrue(appended1);
        assertTrue(appended2);

        Recipe[] expectedArr = rb.getRecipes();
        Recipe[] actualArr = {r1, r2, null, null};

        assertArrayEquals(expectedArr, actualArr);
        assertEquals(expectedArr.length, 4);

    }

    @Test
    public void testGetRecipes_NoRecipes() {

        Recipe[] expectedArr = rb.getRecipes();
        Recipe[] actualArr = {null, null, null, null};

        assertArrayEquals(expectedArr, actualArr);
        assertEquals(expectedArr.length, 4);

    }
}
