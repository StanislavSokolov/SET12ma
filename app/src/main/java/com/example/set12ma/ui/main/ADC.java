package com.example.set12ma.ui.main;

public class ADC {
    private String name;
    private int plus;
    private int minus;
    private int color;
    private int register;

    public int getRegister() {
        return register;
    }

    public void setRegister(int register) {
        this.register = register;
    }

    public ADC(String name, int plus, int minus, int color, int register) {
        this.name = name;
        if (plus > 2048) plus = 2048; else this.plus = plus;
        if (minus < -2048) minus = -2048; else this.minus = minus;
        this.color = color;
        this.register = register;
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
