package com.tw;

import com.tw.model.VolumeUnit;
import org.junit.Test;

import static com.tw.Measure.*;
import static com.tw.model.LengthUnit.*;
import static com.tw.model.VolumeUnit.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class MeasureTest {
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
    public void Inch13PlusInch11EaqualsFeet2() throws Exception {
        Measure inch13 = createInch(INCH, 13);
        Measure inch11 = createInch(INCH, 11);
        Measure feet = createFeet(FEET, 2);

        assertThat(inch13.plus(inch11), is(feet));
    }

    @Test
    public void Feet3PlusYard2EqualsYard3() throws Exception {
        Measure feet = createFeet(FEET, 3);
        Measure yard = createYard(YARD, 2);
        Measure result = createYard(YARD, 3);

        assertThat(feet.plus(yard), is(result));
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

        assertThat(volume1.plus(volume2), is(result));
    }

    @Test
    public void TBSP2ShouldEqualsOZ1AndShowInTBSP() throws Exception {
        assertThat(createOZ(OZ,1).show(new DefaultShower()),is("1 OZ"));
    }

    @Test
    public void showInInch() throws Exception {
        assertThat(createFeet(FEET, 2).show(new InchShower()),is("Measure(2, FEET) ==> 24 INCH"));
        assertThat(createYard(YARD, 2).show(new InchShower()),is("Measure(2, YARD) ==> 72 INCH"));
    }

    @Test
    public void Yard1750shouldShowAs1750Yard() throws Exception {
        assertThat(createYard(YARD, 1750).show(new DefaultShower()), is("1750 YARD"));
    }

    @Test
    public void TSP6ShouldShowAsOZ1() throws Exception {
        assertThat(createTSP(TSP, 6).show(new DefaultShower()), is("1 OZ"));
    }

    @Test
    public void Inch15ShouldShowAsFeet1Inch3() throws Exception {
        assertThat(createInch(INCH,15).show(new DefaultShower()),is("1 FEET 3 INCH"));
    }

    @Test
    public void TSP5ShouldShowAs1TBSP2TSP() throws Exception {
        assertThat(createTSP(TSP, 5).show(new DefaultShower()),is("1 TBSP 2 TSP"));
    }

    @Test
    public void TSP10ShouldShowAs1OZ1TBSP1TSP() throws Exception {
        assertThat(createTSP(TSP, 10).show(new DefaultShower()),is("1 OZ 1 TBSP 1 TSP"));
    }

}