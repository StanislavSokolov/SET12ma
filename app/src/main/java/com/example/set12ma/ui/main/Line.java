package com.example.set12ma.ui.main;

import android.graphics.Color;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Line {

    private final int SIZE_QUEUE = 16;

    private String name;
    private Queue<Entry> queue;
    private ArrayList<Entry> arrayList;
    private boolean enableShow;

    public int getColor() {
        int color = 0;
        switch (this.color) {
            case 0: color = Color.GREEN; break;
            case 1: color = Color.RED; break;
            case 2: color = Color.BLUE; break;
            case 3: color = Color.CYAN; break;
            case 4: color = Color.GRAY; break;
            case 5: color = Color.WHITE; break;
            case 6: color = Color.YELLOW; break;
            case 7: color = Color.MAGENTA; break;
            case 8: color = Color.GREEN; break;
            case 9: color = Color.RED; break;
            case 10: color = Color.BLUE; break;
            case 11: color = Color.CYAN; break;
            case 12: color = Color.GRAY; break;
            case 13: color = Color.WHITE; break;
            case 14: color = Color.YELLOW; break;
            case 15: color = Color.MAGENTA; break;
        }
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    private int color = 0;

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

    public Line(String name, boolean enableShow, int color) {
        this.name = name;
        this.enableShow = enableShow;
        this.color = color;
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
