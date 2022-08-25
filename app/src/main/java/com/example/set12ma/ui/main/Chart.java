package com.example.set12ma.ui.main;

import com.github.mikephil.charting.charts.LineChart;

import java.util.ArrayList;

public class Chart {
    private ArrayList<Line> arrayList;
    private LineChart lineChart;

    public ArrayList<Line> getArrayList() {
        return arrayList;
    }

    public void setArrayList(ArrayList<Line> arrayList) {
        this.arrayList = arrayList;
    }

    public LineChart getLineChart() {
        return lineChart;
    }

    public void setLineChart(LineChart lineChart) {
        this.lineChart = lineChart;
    }

    public Chart(ArrayList<Line> arrayList, LineChart lineChart) {
        this.arrayList = arrayList;
        this.lineChart = lineChart;
    }

    public void addArrayList(Line line) {
        arrayList.add(line);
    }
}
