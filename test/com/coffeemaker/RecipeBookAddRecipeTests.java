package com.coffeemaker;
import com.coffeemaker.exceptions.RecipeException;

import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Test;

public class RecipeBookAddRecipeTests {

    private RecipeBook rb;
    private Recipe r1;
    private Recipe r2;
    private Recipe r3;
    private Recipe r4;
    private Recipe r5;

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

        //Set up for r3
        r3 = new Recipe();
        r3.setName("Latte");
        r3.setAmtChocolate("0");
        r3.setAmtCoffee("3");
        r3.setAmtMilk("3");
        r3.setAmtSugar("1");
        r3.setPrice("100");

        //Set up for r4
        r4 = new Recipe();
        r4.setName("Hot Chocolate");
        r4.setAmtChocolate("4");
        r4.setAmtCoffee("0");
        r4.setAmtMilk("1");
        r4.setAmtSugar("1");
        r4.setPrice("65");

        //Set up for r5
        r5 = new Recipe();
        r5.setName("Cappuccino");
        r5.setAmtChocolate("1");
        r5.setAmtCoffee("30");
        r5.setAmtMilk("20");
        r5.setAmtSugar("1");
        r5.setPrice("85");


    }

    @Test
    public void testAddRecipe_Normal() {

        assertTrue(rb.addRecipe(r1));

        Recipe[] recipes = rb.getRecipes();
        Recipe[] expected = {r1, null, null, null};

        assertArrayEquals(expected, recipes);

    }

    @Test
    public void testAddRecipe_AddNullRecipe() {

        assertThrows(NullPointerException.class,
                () -> {
                    rb.addRecipe(null);
                });

    }

    @Test
    public void testAddRecipe_AddDefaultRecipe() {

        assertFalse(rb.addRecipe(new Recipe()));

        Recipe[] recipes = rb.getRecipes();
        Recipe[] expected  = {null, null, null, null};

        assertArrayEquals(expected , recipes);

    }

    @Test
    public void testAddRecipe_AddDuplicateRecipe() {

        assertTrue(rb.addRecipe(r2));
        assertTrue(rb.addRecipe(r3));
        assertFalse(rb.addRecipe(r3));

        Recipe[] recipes = rb.getRecipes();
        Recipe[] expected = {r2, r3, null, null};

        assertArrayEquals(expected, recipes);

    }

    @Test
    public void testAddRecipe_AddDuplicateNameRecipes() {

        Recipe copyName = new Recipe();
        try {
            copyName.setName(r3.getName());
            copyName.setAmtChocolate("7");
            copyName.setAmtCoffee("14");
            copyName.setAmtMilk("5");
            copyName.setAmtSugar("10");
            copyName.setPrice("90");
        }catch (RecipeException e){
            fail("Should not throw RecipeException");
        }

        assertTrue(rb.addRecipe(r2));
        assertTrue(rb.addRecipe(r3));
        assertFalse(rb.addRecipe(copyName));

        Recipe[] recipes = rb.getRecipes();
        Recipe[] expected = {r2, r3, null, null};

        assertArrayEquals(expected, recipes);

    }

    @Test
    public void testAddRecipe_AddToFullArray() {

        assertTrue(rb.addRecipe(r1));
        assertTrue(rb.addRecipe(r2));
        assertTrue(rb.addRecipe(r3));
        assertTrue(rb.addRecipe(r4));
        assertFalse(rb.addRecipe(r5));


        Recipe[] recipes = rb.getRecipes();
        Recipe[] expected = {r1, r2, r3, r4};

        assertArrayEquals(expected, recipes);

    }
}

