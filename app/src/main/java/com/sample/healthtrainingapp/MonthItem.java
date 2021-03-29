package com.sample.healthtrainingapp;

public class MonthItem {
    private int dayValue;   // 날짜만 찍겠다.

    public MonthItem() {
        this.dayValue = 0;
    }

    public MonthItem(int dayValue) {
        this.dayValue = dayValue;
    }

    public int getDayValue() {return dayValue; }

    public void setDayValue(int dayValue) { this.dayValue = dayValue; }

    @Override
    public String toString() {
        return "MonthItem{" +
                "dayValue=" + dayValue +
                '}';
    }
}
