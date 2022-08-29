package com.example.set12ma.ui.main;

public class ADC {
    private String name;
    private int plus;
    private int minus;
    private int color;

    public ADC(String name, int plus, int minus, int color) {
        this.name = name;
        this.plus = plus;
        this.minus = minus;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPlus() {
        return plus;
    }

    public void setPlus(int plus) {
        this.plus = plus;
    }

    public int getMinus() {
        return minus;
    }

    public void setMinus(int minus) {
        this.minus = minus;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }
}
