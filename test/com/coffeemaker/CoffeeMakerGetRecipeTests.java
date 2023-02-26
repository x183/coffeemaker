package com.coffeemaker;

import com.coffeemaker.exceptions.RecipeException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CoffeeMakerGetRecipeTests {

    private CoffeeMaker cf;
    private Recipe r1;
    private Recipe r2;

    @Before
    public void setUp() throws RecipeException {

        cf = new CoffeeMaker();
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

        cf.addRecipe(r1);
        cf.addRecipe(r2);

        Recipe[] recipes = cf.getRecipes();
        Recipe[] expected  = {r1, r2, null, null};

        assertArrayEquals(expected, recipes);
        assertEquals(4, recipes.length);

    }

    @Test
    public void testGetRecipes_NoRecipes() {

        Recipe[] recipes = cf.getRecipes();
        Recipe[] expected = {null, null, null, null};

        assertArrayEquals(expected, recipes);
        assertEquals(4, recipes.length);

    }
}
