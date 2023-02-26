package com.coffeemaker;

import com.coffeemaker.exceptions.InventoryException;
import com.coffeemaker.exceptions.RecipeException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CoffeeMakerMakeCoffeeTests {

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
        r5.setName("Hot Chocolate");
        r5.setAmtChocolate("20");
        r5.setAmtCoffee("17");
        r5.setAmtMilk("4");
        r5.setAmtSugar("1");
        r5.setPrice("85");

    }

    @Test
    public void testMakeCoffee_IndexOutOfBound() {

        assertThrows(IndexOutOfBoundsException.class,
                () -> {
                    cf.makeCoffee(5, 100);
                });
    }

    @Test
    public void testMakeCoffee_NegativeIndex() {

        assertThrows(IndexOutOfBoundsException.class,
                () -> {
                    cf.makeCoffee(-1, 100);
                });
    }

    @Test
    public void testMakeCoffee_ValidIndexButNull() {

        cf.addRecipe(r2);
        cf.addRecipe(r3);

        assertEquals(100, cf.makeCoffee(2,100));

    }

    @Test
    public void testMakeCoffee_ValidIndexButLowMoney() {

        cf.addRecipe(r4);
        cf.addRecipe(r1);

        assertEquals(20, cf.makeCoffee(1,20));
    }

    @Test
    public void testMakeCoffee_ValidIndexButNegativeMoney() {

        cf.addRecipe(r4);
        cf.addRecipe(r2);

        assertEquals(-5, cf.makeCoffee(1, -5));

    }

    @Test
    public void testMakeCoffee_ValidIndexAndMoneyButLowInventory() {

        cf.addRecipe(r2);
        cf.addRecipe(r3);

        assertEquals(200, cf.makeCoffee(0, 200));

    }

    @Test
    public void testMakeCoffee_ValidIndexAndMoneyButHalfLowInventory() {

        cf.addRecipe(r5);
        cf.addRecipe(r3);

        assertEquals(100, cf.makeCoffee(0, 100));
    }

    @Test
    public void testMakeCoffee_ValidIndexAndMoneyAndEnoughInventory() {

        cf.addRecipe(r3);

        assertEquals(150, cf.makeCoffee(0, 250));

    }







}
