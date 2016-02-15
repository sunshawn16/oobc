package com.tw;

import com.tw.model.VolumeUnit;
import org.junit.Test;

import static com.tw.model.LengthUnit.*;
import static com.tw.Measure.*;
import static com.tw.model.VolumeUnit.TBSP;
import static com.tw.model.VolumeUnit.TSP;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class LengthTest {
    @Test
    public void test3MileEquals3Mile() throws Exception {
        Measure mile1 = createMile(MILE, 3);
        Measure mile2 = createMile(MILE, 3);
        assertEquals(mile1, mile2);
    }

    @Test
    public void test3MileEquals2Mile() throws Exception {
        Measure mile1 =createMile(MILE, 3);
        Measure mile2 =createMile(MILE, 2);

        assertNotEquals(mile1, mile2);
    }

    @Test
    public void test3MileEquals4Mile() throws Exception {
        Measure mile1 = createMile(MILE, 3);
        Measure mile2 = createMile(MILE, 4);
        assertNotEquals(mile1, mile2);
    }

    @Test
    public void MileShouldEquals1760Yard() throws Exception {
        Measure mile = createMile(MILE, 1);
        Measure yard = createYard(YARD, 1760);
        assertEquals(mile, yard);
    }

    @Test
    public void Yard3ShouldEqualsYard3() throws Exception {
        Measure yard1 = createYard(YARD, 3);
        Measure yard2 = createYard(YARD, 3);
        assertEquals(yard1, yard2);
    }

    @Test
    public void Yard1ShouldNotEqualsYard1761() throws Exception {
        Measure mile = createMile(MILE, 1);
        Measure yard = createYard(YARD, 1761);
        assertNotEquals(mile, yard);
    }

    @Test
    public void Yard3ShouldNotEqualsYard4() throws Exception {
        Measure yard1 = createYard(YARD, 3);
        Measure yard2 = createYard(YARD, 4);
        assertNotEquals(yard1, yard2);
    }

    @Test
    public void Yard3ShouldNotEqualsFeet4() throws Exception {
        Measure yard = createYard(YARD, 3);
        Measure feet = createFeet(FEET, 4);
        assertNotEquals(yard, feet);
    }

    @Test
    public void Yard1ShouldEqualsFeet3AndShowInFeet() throws Exception {
        Measure yard = createYard(YARD, 1);
        Measure feet = createFeet(FEET, 3);

        System.out.println(yard.show(FEET));
    }

    @Test
    public void Feet1ShouldEqualsInch12AndShowInInch() throws Exception {
        Measure feet = createFeet(FEET, 1);

        System.out.println(feet.show(INCH));
    }

    @Test
    public void Inch13PlusInch11EaqualsFeet2() throws Exception {
        Measure inch13 = createInch(INCH, 13);
        Measure inch11 = createInch(INCH, 11);
        Measure feet = createFeet(FEET, 2);

        assertThat(inch13.plus(inch11), is(feet));   
    }

    @Test
    public void TBSP1EqualsTSP3() throws Exception {
        Measure volume1 = createTBSP(TBSP, 1);
        Measure volume2 = createTSP(TSP, 3);

        assertEquals(volume1, volume2);
    }

    @Test
    public void TBSP2plusOZ3EqualsOZ4() throws Exception {
        Measure volume1 = createTBSP(VolumeUnit.TBSP, 2);
        Measure volume2 = createOZ(VolumeUnit.OZ, 3);
        Measure result = createOZ(VolumeUnit.OZ, 4);

        assertThat(volume1.plus(volume2), is(result.getRatedValue()));
    }

    @Test
    public void showInInch() throws Exception {
        createFeet(FEET, 2).showInInch();
        createYard(YARD, 2).showInInch();
    }
}