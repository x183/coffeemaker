package com.coffeemaker;

import com.coffeemaker.exceptions.RecipeException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CoffeeMakerEditRecipeTests {

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
    public void testEditRecipe_IndexOutOfBound() {

        assertThrows(IndexOutOfBoundsException.class,
                () -> {
                    cf.editRecipe(5, r4);
                });
    }

    @Test
    public void testEditRecipe_NegativeIndex() {

        assertThrows(IndexOutOfBoundsException.class,
                () -> {
                    cf.editRecipe(-1, r4);
                });
    }

    @Test
    public void testEditRecipe_ValidIndexButNull() {

        cf.addRecipe(r2);
        cf.addRecipe(r3);

        assertNull(cf.editRecipe(2, r5));

        Recipe[] recipes = cf.getRecipes();
        Recipe[] expected = {r2,r3,null,null};

        assertArrayEquals(expected, recipes);
    }

    @Test
    public void testEditRecipe_ValidIndexValidRecipe() {

        cf.addRecipe(r2);
        cf.addRecipe(r3);
        cf.addRecipe(r1);

        String name = cf.editRecipe(2, r5);

        assertNotNull(name);
        assertEquals(name, r1.getName());

        Recipe[] recipes = cf.getRecipes();
        Recipe[] expected = {r2,r3,r5,null};

        assertArrayEquals(expected, recipes);
    }

    @Test
    public void testEditRecipe_ValidIndexWithNullRecipe() {

        cf.addRecipe(r2);
        cf.addRecipe(r3);

        assertThrows(NullPointerException.class,
                () -> {
                    cf.editRecipe(1, null);
                });

    }

    @Test
    public void testEditRecipe_ValidIndexWithDefaultRecipe() {

        cf.addRecipe(r4);
        cf.addRecipe(r2);

        assertNull(cf.editRecipe(1, new Recipe()));

        Recipe[] recipes = cf.getRecipes();
        Recipe[] expected = {r4,r2,null,null};

        assertArrayEquals(expected, recipes);
    }


    @Test
    public void testEditRecipe_ValidIndexWithDuplicateRecipe() {

        cf.addRecipe(r3);
        cf.addRecipe(r5);
        cf.addRecipe(r2);

        assertNull(cf.editRecipe(1, r3));

        Recipe[] recipes = cf.getRecipes();
        Recipe[] expected = {r3,r5,r2,null};

        assertArrayEquals(expected, recipes);
    }
}
