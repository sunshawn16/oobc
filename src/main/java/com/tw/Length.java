package com.tw;

public final class Length extends UnitStore{

    public Length(Unit unit, int value) {
        super(unit, value);
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

    public void showInInch() {
        System.out.println("LENGTH("+ this.getValue() +", "+ this.getUnit().getName() +") ==> "+show(Unit.INCH));
    }
}
