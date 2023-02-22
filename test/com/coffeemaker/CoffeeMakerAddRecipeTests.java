package com.coffeemaker;

import com.coffeemaker.exceptions.RecipeException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CoffeeMakerAddRecipeTests {

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
    public void testAddRecipe_NullRecipe() {
        assertThrows(NullPointerException.class,
                () -> {
                    boolean add = cf.addRecipe(null);
                });

    }

    @Test
    public void testAddRecipe_ValidRecipe() {

        boolean add = cf.addRecipe(r1);
        assertTrue(add);

        Recipe[] expectedArr = cf.getRecipes();
        Recipe[] actualArr = {r1,null,null,null};

        assertArrayEquals(expectedArr, actualArr);
    }

    @Test
    public void testAddRecipe_DuplicateRecipes() {

        boolean add1 = cf.addRecipe(r3);
        boolean add2 = cf.addRecipe(r3);

        assertTrue(add1);
        assertFalse(add2);

        Recipe[] expectedArr = cf.getRecipes();
        Recipe[] actualArr = {r3,null,null,null};

        assertArrayEquals(expectedArr, actualArr);

    }

    @Test
    public void testAddRecipe_DefaultRecipe() {

        boolean add = cf.addRecipe(new Recipe());

        assertTrue(add);

        Recipe[] expectedArr = cf.getRecipes();
        Recipe[] actualArr = {new Recipe(),null,null,null};

        assertArrayEquals(expectedArr, actualArr);
    }

    @Test
    public void testAddRecipe_TooManyRecipes() {

        boolean add1 = cf.addRecipe(r1);
        boolean add2 = cf.addRecipe(r2);
        boolean add3 = cf.addRecipe(r3);
        boolean add4 = cf.addRecipe(r4);
        boolean add5 = cf.addRecipe(r5);

        assertTrue(add1);
        assertTrue(add2);
        assertTrue(add3);
        assertTrue(add4);
        assertFalse(add5);

        Recipe[] expectedArr = cf.getRecipes();
        Recipe[] actualArr = {r1,r2,r3,r4};

        assertArrayEquals(expectedArr, actualArr);

    }
}
