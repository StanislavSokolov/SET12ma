package com.example.set12ma.ui.main;

import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Chart {

    private final int SIZE_QUEUE = 16;

    private String name;
    private Queue<Entry> queue;
    private ArrayList<Entry> arrayList;
    private boolean enableShow;

    public void setData(float x, float y) {
        if (queue.size() > SIZE_QUEUE) {
            queue.remove();
        }
        queue.add(new Entry(x, y));
        arrayList = new ArrayList<>();
        for (Entry entry: queue) {
            arrayList.add(entry);
        }
    }

    public Chart(String name, boolean enableShow) {
        this.name = name;
        this.enableShow = enableShow;
        queue = new LinkedList<>();
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
