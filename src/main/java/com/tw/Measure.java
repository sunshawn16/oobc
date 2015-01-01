package com.tw;

import com.tw.model.LengthUnit;
import com.tw.model.Unit;

public class Measure {
    private int value;
    private Unit unit;

    public Measure(Unit unit, int value) {
        this.unit = unit;
        this.value = value;
    }

    public static Measure createInch(Unit inch, int value) {
        return new Measure(inch, value);
    }

    public static Measure createFeet(Unit fect, int value) {
        return new Measure(fect, value);
    }

    public static Measure createMile(Unit mile, int value) {
        return new Measure(mile, value);
    }

    public static Measure createYard(Unit yard, int value) {
        return new Measure(yard, value);
    }

    public static Measure createTBSP(Unit TBSP, int value) {
        return new Measure(TBSP, value);
    }

    public static Measure createTSP(Unit TSP, int value) {
        return new Measure(TSP, value);
    }

    public static Measure createOZ(Unit OZ, int value) {
        return new Measure(OZ, value);
    }


    public int getValue() {
        return value;
    }

    public Unit getUnit() {
        return unit;
    }

    public int getRatedValue() {
        while (null != unit.getNext()) {
            this.value = this.value * this.unit.getRate();
            unit = unit.getNext();
        }
        return this.value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Measure measure = (Measure) o;

        return this.getRatedValue() == measure.getRatedValue();

    }

    @Override
    public int hashCode() {
        return value;
    }


    public Measure plus(Measure measure) {
        return new Measure(this.unit.getBasic(), this.getRatedValue() + measure.getRatedValue());
    }

    public String show(Unit unit) {
        while (!unit.getName().equals(this.unit.getName())) {
            this.value = this.value * this.unit.getRate();
            this.unit = this.unit.getNext();
        }
        return this.value + " " + unit.getName();
    }

    public String showInInch() {
        return "Measure(" + this.getValue() + ", " + this.getUnit().getName() + ") ==> " + show(LengthUnit.INCH);
    }

    public String show() {
        int multiple = this.getValue() / this.getUnit().getHigherUnit().getRate();
        int remainder = this.getValue() % this.getUnit().getHigherUnit().getRate();
        String result = "";
        if (multiple != 0) {
            result = multiple + " " + this.getUnit().getHigherUnit().getName();
        }
        if (remainder != 0) {
            if (multiple != 0) {
                result += " ";
            }
            result = result + remainder + " " + this.getUnit().getName();
        } else {
            result = result + "";
        }
        return result;
    }
}

