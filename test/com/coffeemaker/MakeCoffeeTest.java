package com.coffeemaker;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MakeCoffeeTest {

    CoffeeMaker cm;
    @Before
    public void beforeTesting(){
        cm = new CoffeeMaker();
    }
    @Test
    public void makeNoRecipeTest(){
        assertEquals(10,cm.makeCoffee(1,10));
    }
}
