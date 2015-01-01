package com.tw.model;

public enum LengthUnit implements Unit {

    INCH(1, null, "INCH"), FEET(12, INCH, "FEET"), YARD(3, FEET, "YARD"), MILE(1760, YARD, "MILE");

    private final int rate;
    private Unit next;
    private String name;


    LengthUnit(int rate, Unit next, String name) {
        this.rate = rate;
        this.next = next;
        this.name = name;
    }

    @Override
    public int getRate() {
        return rate;
    }

    @Override
    public Unit getNext() {
        return next;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public LengthUnit getBasic() {
        return INCH;
    }

    @Override
    public LengthUnit getHighest() {
        return MILE;
    }

    @Override
    public Unit getHigherUnit() {
        Unit higherUnit = getBasic();
        for (LengthUnit lengthUnit : LengthUnit.values()) {
            if (null == lengthUnit.getNext()) {
                higherUnit = getBasic();
            } else if (lengthUnit.getNext().getName().equals(this.getName())) {
                higherUnit = lengthUnit;
            }
        }
        return higherUnit;
    }


}
