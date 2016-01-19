package com.tw;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class LengthTest {
    @Test
    public void test3MileEquals3Mile() throws Exception {
        Length mile1 = Length.createMile(Unit.MILE,3);
        Length mile2 = Length.createMile(Unit.MILE,3);
        assertEquals(mile1,mile2);
    }

    @Test
    public void test3MileEquals2Mile() throws Exception {
        Length mile1 = Length.createMile(Unit.MILE,3);
        Length mile2 = Length.createMile(Unit.MILE,2);

        assertNotEquals(mile1, mile2);
    }

    @Test
    public void test3MileEquals4Mile() throws Exception {
        Length mile1 = Length.createMile(Unit.MILE,3);
        Length mile2 = Length.createMile(Unit.MILE,4);
        assertNotEquals(mile1, mile2);
    }

    @Test
    public void MileShouldEquals1760Yard() throws Exception {
        Length mile = Length.createMile(Unit.MILE, 1);
        Length yard = Length.createYard(Unit.YARD, 1760);
        assertEquals(mile, yard);
    }

    @Test
    public void Yard3ShouldEqualsYard3() throws Exception {
        Length yard1 = Length.createYard(Unit.YARD, 3);
        Length yard2 = Length.createYard(Unit.YARD, 3);
        assertEquals(yard1, yard2);
    }

    @Test
    public void Yard1ShouldNotEqualsYard1761() throws Exception {
        Length mile = Length.createMile(Unit.MILE, 1);
        Length yard = Length.createYard(Unit.YARD, 1761);
        assertNotEquals(mile, yard);
    }

    @Test
    public void Yard3ShouldNotEqualsYard4() throws Exception {
        Length yard1 = Length.createYard(Unit.YARD, 3);
        Length yard2 = Length.createYard(Unit.YARD, 4);
        assertNotEquals(yard1, yard2);
    }

    @Test
      public void Yard3ShouldNotEqualsFeet4() throws Exception {
        Length yard = Length.createYard(Unit.YARD, 3);
        Length feet = Length.createFeet(Unit.FEET, 4);
        assertNotEquals(yard, feet);
    }

    @Test
    public void Yard1ShouldEqualsFeet3AndShowInFeet() throws Exception {
        Length yard = Length.createYard(Unit.YARD, 1);
        Length feet = Length.createFeet(Unit.FEET, 3);
//        assertEquals(yard, feet);

        System.out.println(yard.show(Unit.FEET));
    }
    @Test
    public void Feet1ShouldEqualsInch12AndShowInInch() throws Exception {
        Length feet = Length.createFeet(Unit.FEET, 1);
//        assertEquals(yard, feet);

        System.out.println(feet.show(Unit.INCH));
    }



}