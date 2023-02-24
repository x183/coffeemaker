package com.coffeemaker;

import com.coffeemaker.exceptions.RecipeException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CoffeeMakerDeleteRecipeTests {

    private CoffeeMaker cf;
    private Recipe r1;
    private Recipe r2;
    private Recipe r3;
    private Recipe r4;
    private Recipe r5;

    @Before
    public void setUp() throws RecipeException{

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
        r5.setAmtCoffee("3");
        r5.setAmtMilk("1");
        r5.setAmtSugar("1");
        r5.setPrice("85");


    }

    @Test
    public void testDeleteRecipe_IndexOutOfBound() {

        assertThrows(IndexOutOfBoundsException.class,
                () -> {
                    cf.deleteRecipe(5);
                });
    }

    @Test
    public void testDeleteRecipe_NegativeIndex() {

        assertThrows(IndexOutOfBoundsException.class,
                () -> {
                    cf.deleteRecipe(-1);
                });
    }

    @Test
    public void testDeleteRecipe_ValidIndexNullRecipe() {

        cf.addRecipe(r2);
        cf.addRecipe(r3);

        assertNull(cf.deleteRecipe(2));

        Recipe[] recipes = cf.getRecipes();
        Recipe[] expected  = {r2,r3,null,null};

        assertArrayEquals(expected , recipes);
    }

    @Test
    public void testDeleteRecipe_ValidIndexValidRecipe() {

        cf.addRecipe(r2);
        cf.addRecipe(r3);
        cf.addRecipe(r5);

        String name = cf.deleteRecipe(2);

        assertNotNull(name);
        assertEquals(name, r5.getName());

        Recipe[] recipes = cf.getRecipes();
        Recipe[] expected = {r2,r3,null,null};

        assertArrayEquals(expected, recipes);
    }
}
