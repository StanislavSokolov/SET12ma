package com.example.set12ma.ui.main;

import com.github.mikephil.charting.charts.LineChart;

import java.util.ArrayList;

public class Chart {
    private ArrayList<Line> arrayList;
    private LineChart lineChart;
    private int adc;

    public int getAdc() {
        return adc;
    }

    public void setAdc(int adc) {
        this.adc = adc;
    }

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

    public Chart(ArrayList<Line> arrayList, LineChart lineChart, int adc) {
        this.arrayList = arrayList;
        this.lineChart = lineChart;
        this.adc = adc;
    }

    public void addArrayList(Line line) {
        arrayList.add(line);
    }
}
