package com.coffeemaker;

import com.coffeemaker.exceptions.RecipeException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class AdditionalMutantTests {
    Recipe chocolateAmtRecipe;
    CoffeeMaker getPriceTestMaker;
    @Before
    public void initRecipe(){
        chocolateAmtRecipe = new Recipe();
        try{
            chocolateAmtRecipe.setAmtChocolate("5");
        }catch (Exception e){
            fail("Oopsie woopsie, we've made a fucky wucky, please hold.");
        }
    }
    /*
    useful 1: In Recipe change the line this.amtChocolate = amtChocolate; in setAmtChocolate() in if condition to this.amtChocolate += amtChocolate;. It counts as “Shortcut Operator Replacement”. This mutant is valid and useful since it requires a specifically-designed test to kill this mutant.
*/
    @Test
    public void testChocolateAmtAddition(){
        try{
            chocolateAmtRecipe.setAmtChocolate("2");
        }catch(RecipeException e){
            fail("Well, this wasn't supposed to happen");
        }catch (Exception e){
            fail("Uwu, someone made an ewwow, please wepot this incident to youw closest supewiow");
        }
        assertEquals(2,chocolateAmtRecipe.getAmtChocolate());
    }

    @Before
    public void initCoffeeMaker(){
        getPriceTestMaker = new CoffeeMaker();
        Recipe normal = new Recipe();
        try {
            normal.setPrice("10");
            normal.setAmtCoffee("3");
        }catch(RecipeException e){
            fail("Unhandled exception at line -1");
        }catch(Exception e){
            fail("Oh noes, something went wrong, good luck figuring it out!");
        }
        getPriceTestMaker.addRecipe(normal);
    }
    /*
    useful 2:  In CoffeeMaker change this line getRecipes()[recipeToPurchase].getPrice() <= amtPaid in else if
 = on line 91 in coffeemaker (ror)

     */
    @Test
    public void testCoffeeMakerExactPrice(){
        int result = getPriceTestMaker.makeCoffee(0,10);
        assertEquals(0,result);
    }
}
