package com.example.set12ma.ui.main;

public class InOut {
    private String name;
    private int register;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRegister() {
        return register;
    }

    public void setRegister(int register) {
        this.register = register;
    }

    public InOut(String name, int register) {
        this.name = name;
        this.register = register;
    }
}
