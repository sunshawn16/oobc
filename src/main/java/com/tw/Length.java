package com.tw;

public class Length {
    private int value;
    private Unit unit;


    public Length(Unit unit, int value) {
        this.unit = unit;
        this.value = value;
    }

    public static Length createInch(Unit inch, int value) {
        return new Length(inch, value);
    }

    public static Length createFeet(Unit fect, int value) {
        return new Length(fect, value);
    }

    public static Length createMile(Unit mile, int value) {
        return new Length(mile, value);
    }

    public static Length createYard(Unit yard, int value) {
        return new Length(yard, value);
    }

    public int getValue() {
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

        Length length = (Length) o;

        return this.getValue() == length.getValue();

    }

    @Override
    public int hashCode() {
        return value;
    }

    public String show(Unit unit) {

        while (!unit.getName().equals(this.unit.getName())) {
            this.value = this.value * this.unit.getRate();
            this.unit = this.unit.getNext();
        }
        return this.value + " "+unit.getName();
    }
}
