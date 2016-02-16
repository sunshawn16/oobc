package com.tw.model;

public enum VolumeUnit implements Unit {
    TSP(1, null, "TSP") , TBSP(3, TSP, "TBSP"), OZ(2, TBSP, "OZ");

    private final int rate;
    private Unit next;

    private String name;


    VolumeUnit(int rate, Unit next, String name) {
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
    public VolumeUnit getBasic() {
       return TSP;
    }

    @Override
    public VolumeUnit getHighest() {
        return OZ;
    }

    @Override
    public int getCumulativeRate() {
        Unit unit = getHighest();
        int rate = 1;
        while (!this.getName().equals(unit.getName())){
            rate = rate * unit.getRate();
            unit = unit.getNext();
        }
        return rate;
    }

}
