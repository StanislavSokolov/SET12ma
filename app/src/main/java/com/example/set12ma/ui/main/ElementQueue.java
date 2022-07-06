package com.example.set12ma.ui.main;

public class ElementQueue {
    private int sectionNumber;
    private int id;
    private int data;

    public ElementQueue(int sectionNumber, int id, int data) {
        this.sectionNumber = sectionNumber;
        this.id = id;
        this.data = data;
    }

    public int getSectionNumber() {
        return sectionNumber;
    }

    public int getId() {
        return id;
    }

    public int getData() {
        return data;
    }
}
