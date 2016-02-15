package com.tw.model;

public enum LengthUnit implements Unit {

    INCH(1, null,"INCH"), FEET(12, INCH,"FEET"), YARD(3, FEET,"YARD"), MILE(1760, YARD,"MILE");

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
    public LengthUnit getbasic() {
        return INCH;
    }

}
