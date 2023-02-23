package com.coffeemaker;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class MakeCoffeeTest {

    CoffeeMaker coffeeNoRecipe, coffeeExpensive, coffeeNoIngredients, coffeeNormal;
    Recipe expensive,resourceIntensive;
    @Before
    public void beforeTesting(){
        coffeeNoRecipe = new CoffeeMaker();
        coffeeExpensive = new CoffeeMaker();
        coffeeNoIngredients = new CoffeeMaker();
        coffeeNormal = new CoffeeMaker();

        expensive = new Recipe();
        resourceIntensive = new Recipe();

        try{
        expensive.setPrice("100");
        resourceIntensive.setPrice("5");
        resourceIntensive.setAmtCoffee("5");
        resourceIntensive.setAmtMilk("5");

        coffeeNoIngredients.addInventory("0","0","0","0");
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
}
