package com.coffeemaker;
import com.coffeemaker.exceptions.RecipeException;

import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Test;

public class RecipeBookEditRecipeTests {

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
        r5.setAmtCoffee("3");
        r5.setAmtMilk("1");
        r5.setAmtSugar("1");
        r5.setPrice("85");


    }

    @Test
    public void testEditRecipe_OutOfBoundIndex() {
        boolean appended1 = rb.addRecipe(r1);
        assertTrue(appended1);

        //TODO: Should I catch this exceptions or is this a fault in the code ?
        assertThrows(IndexOutOfBoundsException.class,
                () -> {
                    String name = rb.editRecipe(4, r2);
                });

    }

    @Test
    public void testEditRecipe_NegativeIndex() {
        boolean appended1 = rb.addRecipe(r2);
        assertTrue(appended1);

        //TODO: Should I catch this exceptions or is this a fault in the code ?
        assertThrows(IndexOutOfBoundsException.class,
                () -> {
                    String name = rb.editRecipe(-1, r5);
                });
    }

    @Test
    public void testEditRecipe_CorrectIndexButNull() {
        boolean appended1 = rb.addRecipe(r2);
        boolean appended2 = rb.addRecipe(r3);

        assertTrue(appended1);
        assertTrue(appended2);

        String name = rb.editRecipe(2, r4);

        Recipe[] expectedArr = rb.getRecipes();
        Recipe[] actualArr = {r2,r3,null,null};

        assertNull(name);
        assertArrayEquals(expectedArr, actualArr);

    }

    @Test
    public void testEditRecipe_CorrectIndexWithNullRecipe() {
        boolean appended1 = rb.addRecipe(r1);
        boolean appended2 = rb.addRecipe(r4);
        boolean appended3 = rb.addRecipe(r5);

        assertTrue(appended1);
        assertTrue(appended2);
        assertTrue(appended3);

        assertThrows(NullPointerException.class,
                () -> {
                    String name = rb.editRecipe(2, null);
                });

    }

    @Test
    public void testEditRecipe_CorrectIndexWithRecipe() {
        boolean appended1 = rb.addRecipe(r2);
        boolean appended2 = rb.addRecipe(r3);
        boolean appended3 = rb.addRecipe(r4);

        assertTrue(appended1);
        assertTrue(appended2);
        assertTrue(appended3);

        String name = rb.editRecipe(2, r5);
        Recipe[] expectedArr = rb.getRecipes();
        Recipe[] actualArr = {r2,r3,r5,null};

        assertNotNull(name);
        assertEquals(name, r4.getName());
        assertArrayEquals(expectedArr, actualArr);
    }

    @Test
    public void testEditRecipe_CorrectIndexWithDuplicateRecipe() {
        boolean appended1 = rb.addRecipe(r4);
        boolean appended2 = rb.addRecipe(r1);
        boolean appended3 = rb.addRecipe(r2);

        assertTrue(appended1);
        assertTrue(appended2);
        assertTrue(appended3);


        String name = rb.editRecipe(2, r4);
        Recipe[] expectedArr = rb.getRecipes();
        Recipe[] actualArr = {r4,r1,r4,null};

        assertNotNull(name);
        assertEquals(name, r2.getName());
        assertArrayEquals(expectedArr, actualArr);
    }

}
