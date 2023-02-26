package com.coffeemaker;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RecipeEqualsTests {

    private Recipe recipe1;
    private Recipe recipe2;
    private Recipe recipe3;
    private Inventory inv;

    @Before
    public void init() {
        recipe1 = new Recipe();
        recipe2 = new Recipe();
        inv = new Inventory();
    }

    @Test
    public void sameObjEqualTest(){
        assertTrue(recipe1.equals(recipe1));
    }

    @Test
    public void objNotEqualNullObjTest(){
        assertFalse(recipe1.equals(recipe3));
    }

    @Test
    public void objNotEqualDiffClassTest(){
        assertFalse(recipe1.equals(inv));
    }

    @Test
    public void objNotEqualsNullNameTest(){
        recipe1.setName("Recipe");
        recipe2.setName(null); //Name can't be set to null, becomes "" instead
        assertFalse(recipe1.equals(recipe2));
    }

    @Test
    public void diffNameNotEqualFirstNullSecondNotNullTest(){
        recipe1.setName(null); //Name can't be set to null, becomes "" instead
        recipe2.setName("name2");
        assertFalse(recipe1.equals(recipe2));
    }

    @Test
    public void bothNameNullEqualTest(){
        recipe1.setName(null); //Name can't be set to null, becomes "" instead
        recipe2.setName(null); //Name can't be set to null, becomes "" instead
        assertTrue(recipe1.equals(recipe2));
    }

    @Test
    public void diffNameNotEqualTest(){
        recipe1.setName("name1");
        recipe2.setName("name2");
        assertFalse(recipe1.equals(recipe2));
    }

    @Test
    public void sameNameEqualTest(){
        String name = "best recipe";
        recipe1.setName(name);
        recipe2.setName(name);
        assertTrue(recipe1.equals(recipe2));
    }
}
