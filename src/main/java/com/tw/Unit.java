package com.tw;

public enum Unit {
    INCH(1, null,"INCH"), FEET(12, INCH,"FEET"), YARD(3, FEET,"YARD"), MILE(1760, YARD,"MILE"), TBSP(3, INCH, "TBSP"), TSP(1, INCH, "TSP"), OZ(6, INCH, "OZ");
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
