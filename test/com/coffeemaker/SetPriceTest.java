package com.coffeemaker;

import com.coffeemaker.exceptions.RecipeException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SetPriceTest {

    Recipe zeroPrice;
    @Before
    public void initiateRecipes(){
        zeroPrice = new Recipe();
    }

    @Test
    public void testSetZero(){
        try{
        zeroPrice.setPrice("0");
        }catch(Exception e){
            fail("Zero should be a perfectly acceptable value and the program shouldn't crash");
        }
        assertEquals(0,zeroPrice.getPrice());
    }

    @Test
    public void  testPositivePrice(){
        try{
            zeroPrice.setPrice("15");
        }catch(Exception e){
            fail("The program shouldn't crash from intended use");
        }
        assertEquals(15,zeroPrice.getPrice());
    }

    @Test
    public void testLetterPrice(){
        assertThrows(
                RecipeException.class, () -> {
            zeroPrice.setPrice("fifteen");
                }
        );
        //fail("Setting the price to a non-numerical value is illogical and should therefore lead to the process' termination");
    }

    @Test
    public void testNegativePrice(){
        assertThrows(
                RecipeException.class, () -> {
                    zeroPrice.setPrice("-5");
                }
        );
    }
}
