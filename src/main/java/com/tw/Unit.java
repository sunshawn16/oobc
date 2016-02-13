package com.tw;

public enum Unit {
    INCH(1, null,"INCH"), FEET(12, INCH,"FEET"), YARD(3, FEET,"YARD"), MILE(1760, YARD,"MILE"), TSP(1, null, "TSP"), TBSP(3, TSP, "TBSP"),OZ(2, TBSP, "OZ");
    private final int rate;
    private Unit next;
    private String name;


    Unit(int rate, Unit next, String name) {
        this.rate = rate;
        this.next = next;
        this.name = name;
    }

    public int getRate() {
        return rate;
    }

    public Unit getNext() {
        return next;
    }


    public String getName() {
        return name;
    }


}
