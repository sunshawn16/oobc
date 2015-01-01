package com.tw.model;

public interface Unit {

    int getRate();

    Unit getNext();

    String getName();

    Unit getBasic();

    Unit getHighest();

    Unit getHigherUnit();
}
