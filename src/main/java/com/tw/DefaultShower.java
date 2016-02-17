package com.tw;

import com.tw.model.Unit;

public class DefaultShower implements Shower {
    @Override
    public String show(Measure input) {
        Unit unit = input.getUnit().getHighest();
        String result = "";
        int currentRate = input.getUnit().getCumulativeRate();
        int multiple = input.getValue() / currentRate;
        int remainder = input.getValue() - multiple * currentRate;
        do {
            result = showWithUnit(unit, result, multiple);
            currentRate = currentRate / unit.getRate();
            if (currentRate == 0) break;
            multiple = remainder / currentRate;
            remainder = remainder - multiple * currentRate;

            if (null != unit.getNext()) {
                unit = unit.getNext();
            } else break;
        } while (remainder != 0 || multiple != 0);

        return result;
    }

    private String showWithUnit(Unit unit, String result, int multiple) {
        if (multiple != 0) {
            if (!result.equals("")) {
                result += " ";
            }
            result = result + multiple + " " + unit.getName();
        }
        return result;
    }
}
