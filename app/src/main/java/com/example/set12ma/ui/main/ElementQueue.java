package com.example.set12ma.ui.main;

public class ElementQueue {
    private int register;
    private int data;

    public ElementQueue(int register, int data) {
        this.register = register;
        this.data = data;
    }

    public int getRegister() {
        return register;
    }

    public int getData() {
        return data;
    }
}
