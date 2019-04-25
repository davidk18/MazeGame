package com.group4.Interpreter;

import com.group4.Prototype.CharacterPrototype;
import junit.framework.*;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class CombinerTest {

    public CharacterPrototype character;
    WeaponCombiner combine;

    public CombinerTest(CharacterPrototype character){
        this.character = character;
        combine = new WeaponCombiner(character);
    }

    public CombinerTest(){}

    @Test
    public void testItemDamage(){
        assertTrue(character.getInventory().getItems().get(0).getDamage() == 40);
    }
    @Test
    public void testIsOperator(){
        assertTrue(combine.isOperator("+"));
        assertTrue(combine.isOperator("*"));
        assertTrue(combine.isOperator("-"));
    }

    @Test
    public void testPrefix(){
        assertEquals(20, combine.testPrefix("10 10 +"));
    }
}
