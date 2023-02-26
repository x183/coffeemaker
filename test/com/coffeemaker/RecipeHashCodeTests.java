package com.coffeemaker;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class RecipeHashCodeTests {

    private Recipe recipe1;
    private Recipe recipe2;

    @Before
    public void init() throws Exception {
        recipe1 = new Recipe();
        recipe2 = new Recipe();
    }

    @Test
    public void SameNameSameHashTest(){
        String name = "Recipe";
        recipe1.setName(name);
        recipe2.setName(name);
        assertEquals(recipe1.hashCode(),recipe2.hashCode());
    }

    @Test
    public void DifferentNameDifferentHashTest(){
        recipe1.setName("name1");
        recipe2.setName("name2");
        assertNotEquals(recipe1.hashCode(),recipe2.hashCode());
    }

    @Test
    public void noNameSetSameHashTest(){
        assertEquals(recipe1.hashCode(),recipe2.hashCode());
    }

    @Test
    public void NullNameSameHashTest(){
        recipe1.setName(null); //Name can't be set to null, becomes "" instead
        recipe2.setName(null); //Name can't be set to null, becomes "" instead
        assertEquals(recipe1.hashCode(),recipe2.hashCode());
    }
}
