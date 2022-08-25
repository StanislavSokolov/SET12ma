package com.example.set12ma.ui.main;

import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;

public class Chart {
    private String name;
    private ArrayList<Entry> arrayList;
    private boolean enableShow;

    public void setData(float x, float y) {
        arrayList.add(new Entry(x, y));
    }

    public Chart(String name, boolean enableShow) {
        this.name = name;
        this.enableShow = enableShow;
        arrayList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Entry> getArrayList() {
        return arrayList;
    }

    public void setArrayList(ArrayList<Entry> arrayList) {
        this.arrayList = arrayList;
    }

    public boolean isEnableShow() {
        return enableShow;
    }

    public void setEnableShow(boolean enableShow) {
        this.enableShow = enableShow;
    }
}
