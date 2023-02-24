package com.coffeemaker;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class MakeCoffeeTest {

    CoffeeMaker coffeeNoRecipe, coffeeExpensive, coffeeNoIngredients, coffeeNormal;
    Recipe expensive,resourceIntensive,normalRecipe;
    @Before
    public void beforeTesting(){
        coffeeNoRecipe = new CoffeeMaker();
        coffeeExpensive = new CoffeeMaker();
        coffeeNoIngredients = new CoffeeMaker();
        coffeeNormal = new CoffeeMaker();

        expensive = new Recipe();
        resourceIntensive = new Recipe();
        normalRecipe = new Recipe();

        try{
        expensive.setPrice("100");
        resourceIntensive.setPrice("25");
        resourceIntensive.setAmtCoffee("25");
        resourceIntensive.setAmtMilk("25");
            resourceIntensive.setAmtSugar("25");
            resourceIntensive.setAmtChocolate("25");

        normalRecipe.setAmtMilk("10");
            normalRecipe.setAmtCoffee("10");
            normalRecipe.setPrice("5");

        }catch (Exception e){
            fail("Oopsie woopsie, someone made a fucky wucky");
        }
    }
    @Test
    public void makeNoRecipeTest(){
        assertEquals(10, coffeeNoRecipe.makeCoffee(1,10));
    }
    @Test
    public void makeCoffeeTooFewCoin(){
        coffeeExpensive.addRecipe(expensive);
        assertEquals(10,coffeeExpensive.makeCoffee(0,10));
    }
    @Test
    public void makeCoffeeNoIngredients(){
        coffeeNoIngredients.addRecipe(resourceIntensive);
        assertEquals(30,coffeeNoIngredients.makeCoffee(0,30));
    }
    @Test
    public void makeCoffeeNormal(){
        coffeeNormal.addRecipe(normalRecipe);
        assertEquals(5,coffeeNormal.makeCoffee(0,10));

    }
}
