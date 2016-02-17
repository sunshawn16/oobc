package com.tw;

public class InchShower implements Shower {

    @Override
    public String show(Measure input) {
        return "Measure(" + input.getValue() + ", " + input.getUnit().getName() + ") ==> " + input.getRatedValue()+ " INCH";
    }

}
