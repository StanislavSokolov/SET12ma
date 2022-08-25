package com.example.set12ma.ui.main;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import com.example.set12ma.R;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class FragmentADC extends Fragment {
    private static final String ARG_SECTION_NUMBER = "ADC";

    private int startCellNumber = 96;
    private int stopCellNumber = 208;

    private ArrayList<Button> arrayListButton;
    private ArrayList<TextView> arrayListTextView;
    private ArrayList<Switch> arrayListSwitch;
    private SpaceAddress spaceAddress;
    private ResultReceiverAddressSpace resultReceiverAddressSpace;
    private SpaceStatus spaceStatus;
    private ResultReceiverStatusSpace resultReceiverStatusSpace;

    private UpDateGraphicalDisplay upDateGraphicalDisplay;
    private long timer = 1000;

    FloatingActionButton fab;

    private ArrayList<Chart> arrayListChart;

    private int time = 0;

    private Switch switch_adc_0_0;
    private Switch switch_adc_0_1;
    private Switch switch_adc_0_2;
    private Switch switch_adc_0_3;
    private Switch switch_adc_0_4;
    private Switch switch_adc_0_5;
    private Switch switch_adc_0_6;
    private Switch switch_adc_0_7;
    private Switch switch_adc_0_8;
    private Switch switch_adc_0_9;
    private Switch switch_adc_0_10;
    private Switch switch_adc_0_11;
    private Switch switch_adc_0_12;
    private Switch switch_adc_0_13;
    private Switch switch_adc_0_14;
    private Switch switch_adc_0_15;

    private Switch switch_adc_1_0;
    private Switch switch_adc_1_1;
    private Switch switch_adc_1_2;
    private Switch switch_adc_1_3;
    private Switch switch_adc_1_4;
    private Switch switch_adc_1_5;
    private Switch switch_adc_1_6;
    private Switch switch_adc_1_7;
    private Switch switch_adc_1_8;
    private Switch switch_adc_1_9;
    private Switch switch_adc_1_10;
    private Switch switch_adc_1_11;
    private Switch switch_adc_1_12;
    private Switch switch_adc_1_13;
    private Switch switch_adc_1_14;
    private Switch switch_adc_1_15;

    private Switch switch_adc_2_0;
    private Switch switch_adc_2_1;
    private Switch switch_adc_2_2;
    private Switch switch_adc_2_3;
    private Switch switch_adc_2_4;
    private Switch switch_adc_2_5;
    private Switch switch_adc_2_6;
    private Switch switch_adc_2_7;
    private Switch switch_adc_2_8;
    private Switch switch_adc_2_9;
    private Switch switch_adc_2_10;
    private Switch switch_adc_2_11;
    private Switch switch_adc_2_12;
    private Switch switch_adc_2_13;
    private Switch switch_adc_2_14;
    private Switch switch_adc_2_15;



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        resultReceiverAddressSpace = (ResultReceiverAddressSpace) context;
        resultReceiverStatusSpace = (ResultReceiverStatusSpace) context;
    }

    private PageViewModel pageViewModel;

    public static FragmentADC newInstance(int index) {
        FragmentADC fragment = new FragmentADC();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_SECTION_NUMBER, index);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageViewModel = ViewModelProviders.of(this).get(PageViewModel.class);
        int index = 1;
        if (getArguments() != null) {
            index = getArguments().getInt(ARG_SECTION_NUMBER);
        }
        pageViewModel.setIndex(index);
        spaceAddress = resultReceiverAddressSpace.getSpaceAddress();
        spaceStatus = resultReceiverStatusSpace.getSpaceStatus();
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_adc, container, false);

        arrayListChart = new ArrayList<>();
        arrayListChart.add(new Chart(new ArrayList<Line>(), (LineChart) root.findViewById(R.id.chart0), 0));
        arrayListChart.add(new Chart(new ArrayList<Line>(), (LineChart) root.findViewById(R.id.chart1), 1));
        arrayListChart.add(new Chart(new ArrayList<Line>(), (LineChart) root.findViewById(R.id.chart2), 2));

        for (Chart chart: arrayListChart) {
            for (int i = 0; i <16; i++) {
                chart.addArrayList(new Line("ADC" + i, false));
            }
        }

        fab = root.findViewById(R.id.fab_SET12MA);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

            }
        });
        arrayListTextView = new ArrayList<>();
        arrayListButton = new ArrayList<>();
        arrayListSwitch = new ArrayList<>();

        TextView textViewValue_adc_0_0 = root.findViewById(R.id.textViewValue_adc_0_0);
        arrayListTextView.add(textViewValue_adc_0_0);
        TextView textViewValue_adc_0_1 = root.findViewById(R.id.textViewValue_adc_0_1);
        arrayListTextView.add(textViewValue_adc_0_1);
        TextView textViewValue_adc_0_2 = root.findViewById(R.id.textViewValue_adc_0_2);
        arrayListTextView.add(textViewValue_adc_0_2);
        TextView textViewValue_adc_0_3 = root.findViewById(R.id.textViewValue_adc_0_3);
        arrayListTextView.add(textViewValue_adc_0_3);
        TextView textViewValue_adc_0_4 = root.findViewById(R.id.textViewValue_adc_0_4);
        arrayListTextView.add(textViewValue_adc_0_4);
        TextView textViewValue_adc_0_5 = root.findViewById(R.id.textViewValue_adc_0_5);
        arrayListTextView.add(textViewValue_adc_0_5);
        TextView textViewValue_adc_0_6 = root.findViewById(R.id.textViewValue_adc_0_6);
        arrayListTextView.add(textViewValue_adc_0_6);
        TextView textViewValue_adc_0_7 = root.findViewById(R.id.textViewValue_adc_0_7);
        arrayListTextView.add(textViewValue_adc_0_7);
        TextView textViewValue_adc_0_8 = root.findViewById(R.id.textViewValue_adc_0_8);
        arrayListTextView.add(textViewValue_adc_0_8);
        TextView textViewValue_adc_0_9 = root.findViewById(R.id.textViewValue_adc_0_9);
        arrayListTextView.add(textViewValue_adc_0_9);
        TextView textViewValue_adc_0_10 = root.findViewById(R.id.textViewValue_adc_0_10);
        arrayListTextView.add(textViewValue_adc_0_10);
        TextView textViewValue_adc_0_11 = root.findViewById(R.id.textViewValue_adc_0_11);
        arrayListTextView.add(textViewValue_adc_0_11);
        TextView textViewValue_adc_0_12 = root.findViewById(R.id.textViewValue_adc_0_12);
        arrayListTextView.add(textViewValue_adc_0_12);
        TextView textViewValue_adc_0_13 = root.findViewById(R.id.textViewValue_adc_0_13);
        arrayListTextView.add(textViewValue_adc_0_13);
        TextView textViewValue_adc_0_14 = root.findViewById(R.id.textViewValue_adc_0_14);
        arrayListTextView.add(textViewValue_adc_0_14);
        TextView textViewValue_adc_0_15 = root.findViewById(R.id.textViewValue_adc_0_15);
        arrayListTextView.add(textViewValue_adc_0_15);

        TextView textViewValue_adc_1_0 = root.findViewById(R.id.textViewValue_adc_1_0);
        arrayListTextView.add(textViewValue_adc_1_0);
        TextView textViewValue_adc_1_1 = root.findViewById(R.id.textViewValue_adc_1_1);
        arrayListTextView.add(textViewValue_adc_1_1);
        TextView textViewValue_adc_1_2 = root.findViewById(R.id.textViewValue_adc_1_2);
        arrayListTextView.add(textViewValue_adc_1_2);
        TextView textViewValue_adc_1_3 = root.findViewById(R.id.textViewValue_adc_1_3);
        arrayListTextView.add(textViewValue_adc_1_3);
        TextView textViewValue_adc_1_4 = root.findViewById(R.id.textViewValue_adc_1_4);
        arrayListTextView.add(textViewValue_adc_1_4);
        TextView textViewValue_adc_1_5 = root.findViewById(R.id.textViewValue_adc_1_5);
        arrayListTextView.add(textViewValue_adc_1_5);
        TextView textViewValue_adc_1_6 = root.findViewById(R.id.textViewValue_adc_1_6);
        arrayListTextView.add(textViewValue_adc_1_6);
        TextView textViewValue_adc_1_7 = root.findViewById(R.id.textViewValue_adc_1_7);
        arrayListTextView.add(textViewValue_adc_1_7);
        TextView textViewValue_adc_1_8 = root.findViewById(R.id.textViewValue_adc_1_8);
        arrayListTextView.add(textViewValue_adc_1_8);
        TextView textViewValue_adc_1_9 = root.findViewById(R.id.textViewValue_adc_1_9);
        arrayListTextView.add(textViewValue_adc_1_9);
        TextView textViewValue_adc_1_10 = root.findViewById(R.id.textViewValue_adc_1_10);
        arrayListTextView.add(textViewValue_adc_1_10);
        TextView textViewValue_adc_1_11 = root.findViewById(R.id.textViewValue_adc_1_11);
        arrayListTextView.add(textViewValue_adc_1_11);
        TextView textViewValue_adc_1_12 = root.findViewById(R.id.textViewValue_adc_1_12);
        arrayListTextView.add(textViewValue_adc_1_12);
        TextView textViewValue_adc_1_13 = root.findViewById(R.id.textViewValue_adc_1_13);
        arrayListTextView.add(textViewValue_adc_1_13);
        TextView textViewValue_adc_1_14 = root.findViewById(R.id.textViewValue_adc_1_14);
        arrayListTextView.add(textViewValue_adc_1_14);
        TextView textViewValue_adc_1_15 = root.findViewById(R.id.textViewValue_adc_1_15);
        arrayListTextView.add(textViewValue_adc_1_15);

        TextView textViewValue_adc_2_0 = root.findViewById(R.id.textViewValue_adc_2_0);
        arrayListTextView.add(textViewValue_adc_2_0);
        TextView textViewValue_adc_2_1 = root.findViewById(R.id.textViewValue_adc_2_1);
        arrayListTextView.add(textViewValue_adc_2_1);
        TextView textViewValue_adc_2_2 = root.findViewById(R.id.textViewValue_adc_2_2);
        arrayListTextView.add(textViewValue_adc_2_2);
        TextView textViewValue_adc_2_3 = root.findViewById(R.id.textViewValue_adc_2_3);
        arrayListTextView.add(textViewValue_adc_2_3);
        TextView textViewValue_adc_2_4 = root.findViewById(R.id.textViewValue_adc_2_4);
        arrayListTextView.add(textViewValue_adc_2_4);
        TextView textViewValue_adc_2_5 = root.findViewById(R.id.textViewValue_adc_2_5);
        arrayListTextView.add(textViewValue_adc_2_5);
        TextView textViewValue_adc_2_6 = root.findViewById(R.id.textViewValue_adc_2_6);
        arrayListTextView.add(textViewValue_adc_2_6);
        TextView textViewValue_adc_2_7 = root.findViewById(R.id.textViewValue_adc_2_7);
        arrayListTextView.add(textViewValue_adc_2_7);
        TextView textViewValue_adc_2_8 = root.findViewById(R.id.textViewValue_adc_2_8);
        arrayListTextView.add(textViewValue_adc_2_8);
        TextView textViewValue_adc_2_9 = root.findViewById(R.id.textViewValue_adc_2_9);
        arrayListTextView.add(textViewValue_adc_2_9);
        TextView textViewValue_adc_2_10 = root.findViewById(R.id.textViewValue_adc_2_10);
        arrayListTextView.add(textViewValue_adc_2_10);
        TextView textViewValue_adc_2_11 = root.findViewById(R.id.textViewValue_adc_2_11);
        arrayListTextView.add(textViewValue_adc_2_11);
        TextView textViewValue_adc_2_12 = root.findViewById(R.id.textViewValue_adc_2_12);
        arrayListTextView.add(textViewValue_adc_2_12);
        TextView textViewValue_adc_2_13 = root.findViewById(R.id.textViewValue_adc_2_13);
        arrayListTextView.add(textViewValue_adc_2_13);
        TextView textViewValue_adc_2_14 = root.findViewById(R.id.textViewValue_adc_2_14);
        arrayListTextView.add(textViewValue_adc_2_14);
        TextView textViewValue_adc_2_15 = root.findViewById(R.id.textViewValue_adc_2_15);
        arrayListTextView.add(textViewValue_adc_2_15);

        Button indicator_button_adc_0_0 = root.findViewById(R.id.indicator_button_adc_0_0);
        arrayListButton.add(indicator_button_adc_0_0);
        Button indicator_button_adc_0_1 = root.findViewById(R.id.indicator_button_adc_0_1);
        arrayListButton.add(indicator_button_adc_0_1);
        Button indicator_button_adc_0_2 = root.findViewById(R.id.indicator_button_adc_0_2);
        arrayListButton.add(indicator_button_adc_0_2);
        Button indicator_button_adc_0_3 = root.findViewById(R.id.indicator_button_adc_0_3);
        arrayListButton.add(indicator_button_adc_0_3);
        Button indicator_button_adc_0_4 = root.findViewById(R.id.indicator_button_adc_0_4);
        arrayListButton.add(indicator_button_adc_0_4);
        Button indicator_button_adc_0_5 = root.findViewById(R.id.indicator_button_adc_0_5);
        arrayListButton.add(indicator_button_adc_0_5);
        Button indicator_button_adc_0_6 = root.findViewById(R.id.indicator_button_adc_0_6);
        arrayListButton.add(indicator_button_adc_0_6);
        Button indicator_button_adc_0_7 = root.findViewById(R.id.indicator_button_adc_0_7);
        arrayListButton.add(indicator_button_adc_0_7);
        Button indicator_button_adc_0_8 = root.findViewById(R.id.indicator_button_adc_0_8);
        arrayListButton.add(indicator_button_adc_0_8);
        Button indicator_button_adc_0_9 = root.findViewById(R.id.indicator_button_adc_0_9);
        arrayListButton.add(indicator_button_adc_0_9);
        Button indicator_button_adc_0_10 = root.findViewById(R.id.indicator_button_adc_0_10);
        arrayListButton.add(indicator_button_adc_0_10);
        Button indicator_button_adc_0_11 = root.findViewById(R.id.indicator_button_adc_0_11);
        arrayListButton.add(indicator_button_adc_0_11);
        Button indicator_button_adc_0_12 = root.findViewById(R.id.indicator_button_adc_0_12);
        arrayListButton.add(indicator_button_adc_0_12);
        Button indicator_button_adc_0_13 = root.findViewById(R.id.indicator_button_adc_0_13);
        arrayListButton.add(indicator_button_adc_0_13);
        Button indicator_button_adc_0_14 = root.findViewById(R.id.indicator_button_adc_0_14);
        arrayListButton.add(indicator_button_adc_0_14);
        Button indicator_button_adc_0_15 = root.findViewById(R.id.indicator_button_adc_0_15);
        arrayListButton.add(indicator_button_adc_0_15);

        Button indicator_button_adc_1_0 = root.findViewById(R.id.indicator_button_adc_1_0);
        arrayListButton.add(indicator_button_adc_1_0);
        Button indicator_button_adc_1_1 = root.findViewById(R.id.indicator_button_adc_1_1);
        arrayListButton.add(indicator_button_adc_1_1);
        Button indicator_button_adc_1_2 = root.findViewById(R.id.indicator_button_adc_1_2);
        arrayListButton.add(indicator_button_adc_1_2);
        Button indicator_button_adc_1_3 = root.findViewById(R.id.indicator_button_adc_1_3);
        arrayListButton.add(indicator_button_adc_1_3);
        Button indicator_button_adc_1_4 = root.findViewById(R.id.indicator_button_adc_1_4);
        arrayListButton.add(indicator_button_adc_1_4);
        Button indicator_button_adc_1_5 = root.findViewById(R.id.indicator_button_adc_1_5);
        arrayListButton.add(indicator_button_adc_1_5);
        Button indicator_button_adc_1_6 = root.findViewById(R.id.indicator_button_adc_1_6);
        arrayListButton.add(indicator_button_adc_1_6);
        Button indicator_button_adc_1_7 = root.findViewById(R.id.indicator_button_adc_1_7);
        arrayListButton.add(indicator_button_adc_1_7);
        Button indicator_button_adc_1_8 = root.findViewById(R.id.indicator_button_adc_1_8);
        arrayListButton.add(indicator_button_adc_1_8);
        Button indicator_button_adc_1_9 = root.findViewById(R.id.indicator_button_adc_1_9);
        arrayListButton.add(indicator_button_adc_1_9);
        Button indicator_button_adc_1_10 = root.findViewById(R.id.indicator_button_adc_1_10);
        arrayListButton.add(indicator_button_adc_1_10);
        Button indicator_button_adc_1_11 = root.findViewById(R.id.indicator_button_adc_1_11);
        arrayListButton.add(indicator_button_adc_1_11);
        Button indicator_button_adc_1_12 = root.findViewById(R.id.indicator_button_adc_1_12);
        arrayListButton.add(indicator_button_adc_1_12);
        Button indicator_button_adc_1_13 = root.findViewById(R.id.indicator_button_adc_1_13);
        arrayListButton.add(indicator_button_adc_1_13);
        Button indicator_button_adc_1_14 = root.findViewById(R.id.indicator_button_adc_1_14);
        arrayListButton.add(indicator_button_adc_1_14);
        Button indicator_button_adc_1_15 = root.findViewById(R.id.indicator_button_adc_1_15);
        arrayListButton.add(indicator_button_adc_1_15);

        Button indicator_button_adc_2_0 = root.findViewById(R.id.indicator_button_adc_2_0);
        arrayListButton.add(indicator_button_adc_2_0);
        Button indicator_button_adc_2_1 = root.findViewById(R.id.indicator_button_adc_2_1);
        arrayListButton.add(indicator_button_adc_2_1);
        Button indicator_button_adc_2_2 = root.findViewById(R.id.indicator_button_adc_2_2);
        arrayListButton.add(indicator_button_adc_2_2);
        Button indicator_button_adc_2_3 = root.findViewById(R.id.indicator_button_adc_2_3);
        arrayListButton.add(indicator_button_adc_2_3);
        Button indicator_button_adc_2_4 = root.findViewById(R.id.indicator_button_adc_2_4);
        arrayListButton.add(indicator_button_adc_2_4);
        Button indicator_button_adc_2_5 = root.findViewById(R.id.indicator_button_adc_2_5);
        arrayListButton.add(indicator_button_adc_2_5);
        Button indicator_button_adc_2_6 = root.findViewById(R.id.indicator_button_adc_2_6);
        arrayListButton.add(indicator_button_adc_2_6);
        Button indicator_button_adc_2_7 = root.findViewById(R.id.indicator_button_adc_2_7);
        arrayListButton.add(indicator_button_adc_2_7);
        Button indicator_button_adc_2_8 = root.findViewById(R.id.indicator_button_adc_2_8);
        arrayListButton.add(indicator_button_adc_2_8);
        Button indicator_button_adc_2_9 = root.findViewById(R.id.indicator_button_adc_2_9);
        arrayListButton.add(indicator_button_adc_2_9);
        Button indicator_button_adc_2_10 = root.findViewById(R.id.indicator_button_adc_2_10);
        arrayListButton.add(indicator_button_adc_2_10);
        Button indicator_button_adc_2_11 = root.findViewById(R.id.indicator_button_adc_2_11);
        arrayListButton.add(indicator_button_adc_2_11);
        Button indicator_button_adc_2_12 = root.findViewById(R.id.indicator_button_adc_2_12);
        arrayListButton.add(indicator_button_adc_2_12);
        Button indicator_button_adc_2_13 = root.findViewById(R.id.indicator_button_adc_2_13);
        arrayListButton.add(indicator_button_adc_2_13);
        Button indicator_button_adc_2_14 = root.findViewById(R.id.indicator_button_adc_2_14);
        arrayListButton.add(indicator_button_adc_2_14);
        Button indicator_button_adc_2_15 = root.findViewById(R.id.indicator_button_adc_2_15);
        arrayListButton.add(indicator_button_adc_2_15);

        switch_adc_0_0 = root.findViewById(R.id.switch_adc_0_0);
        switch_adc_0_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show(0, 0, switch_adc_0_0.isChecked());
            }
        });
        arrayListSwitch.add(switch_adc_0_0);
        switch_adc_0_1 = root.findViewById(R.id.switch_adc_0_1);
        switch_adc_0_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show(0, 1, switch_adc_0_1.isChecked());
            }
        });
        arrayListSwitch.add(switch_adc_0_1);
        switch_adc_0_2 = root.findViewById(R.id.switch_adc_0_2);
        switch_adc_0_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show(0, 2, switch_adc_0_2.isChecked());
            }
        });
        arrayListSwitch.add(switch_adc_0_2);
        switch_adc_0_3 = root.findViewById(R.id.switch_adc_0_3);
        switch_adc_0_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show(0, 3, switch_adc_0_3.isChecked());
            }
        });
        arrayListSwitch.add(switch_adc_0_3);
        switch_adc_0_4 = root.findViewById(R.id.switch_adc_0_4);
        switch_adc_0_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show(0, 4, switch_adc_0_4.isChecked());
            }
        });
        arrayListSwitch.add(switch_adc_0_4);
        switch_adc_0_5 = root.findViewById(R.id.switch_adc_0_5);
        switch_adc_0_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show(0, 5, switch_adc_0_5.isChecked());
            }
        });
        arrayListSwitch.add(switch_adc_0_5);
        switch_adc_0_6 = root.findViewById(R.id.switch_adc_0_6);
        switch_adc_0_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show(0, 6, switch_adc_0_6.isChecked());
            }
        });
        arrayListSwitch.add(switch_adc_0_6);
        switch_adc_0_7 = root.findViewById(R.id.switch_adc_0_7);
        switch_adc_0_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show(0, 7, switch_adc_0_7.isChecked());
            }
        });
        arrayListSwitch.add(switch_adc_0_7);
        switch_adc_0_8 = root.findViewById(R.id.switch_adc_0_8);
        switch_adc_0_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show(0, 8, switch_adc_0_8.isChecked());
            }
        });
        arrayListSwitch.add(switch_adc_0_8);
        switch_adc_0_9 = root.findViewById(R.id.switch_adc_0_9);
        switch_adc_0_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show(0, 9, switch_adc_0_9.isChecked());
            }
        });
        arrayListSwitch.add(switch_adc_0_9);
        switch_adc_0_10 = root.findViewById(R.id.switch_adc_0_10);
        switch_adc_0_10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show(0, 10, switch_adc_0_10.isChecked());
            }
        });
        arrayListSwitch.add(switch_adc_0_10);
        switch_adc_0_11 = root.findViewById(R.id.switch_adc_0_11);
        switch_adc_0_11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show(0, 11, switch_adc_0_11.isChecked());
            }
        });
        arrayListSwitch.add(switch_adc_0_11);
        switch_adc_0_12 = root.findViewById(R.id.switch_adc_0_12);
        switch_adc_0_12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show(0, 12, switch_adc_0_12.isChecked());
            }
        });
        arrayListSwitch.add(switch_adc_0_12);
        switch_adc_0_13 = root.findViewById(R.id.switch_adc_0_13);
        switch_adc_0_13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show(0, 13, switch_adc_0_13.isChecked());
            }
        });
        arrayListSwitch.add(switch_adc_0_13);
        switch_adc_0_14 = root.findViewById(R.id.switch_adc_0_14);
        switch_adc_0_14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show(0, 14, switch_adc_0_14.isChecked());
            }
        });
        arrayListSwitch.add(switch_adc_0_14);
        switch_adc_0_15 = root.findViewById(R.id.switch_adc_0_15);
        switch_adc_0_15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show(0, 15, switch_adc_0_15.isChecked());
            }
        });
        arrayListSwitch.add(switch_adc_0_15);

        switch_adc_1_0 = root.findViewById(R.id.switch_adc_1_0);
        switch_adc_1_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show(1, 0, switch_adc_1_0.isChecked());
            }
        });
        arrayListSwitch.add(switch_adc_1_0);
        switch_adc_1_1 = root.findViewById(R.id.switch_adc_1_1);
        switch_adc_1_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show(1, 1, switch_adc_1_1.isChecked());
            }
        });
        arrayListSwitch.add(switch_adc_1_1);
        switch_adc_1_2 = root.findViewById(R.id.switch_adc_1_2);
        switch_adc_1_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show(1, 2, switch_adc_1_2.isChecked());
            }
        });
        arrayListSwitch.add(switch_adc_1_2);
        switch_adc_1_3 = root.findViewById(R.id.switch_adc_1_3);
        switch_adc_1_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show(1, 3, switch_adc_1_3.isChecked());
            }
        });
        arrayListSwitch.add(switch_adc_1_3);
        switch_adc_1_4 = root.findViewById(R.id.switch_adc_1_4);
        switch_adc_1_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show(1, 4, switch_adc_1_4.isChecked());
            }
        });
        arrayListSwitch.add(switch_adc_1_4);
        switch_adc_1_5 = root.findViewById(R.id.switch_adc_1_5);
        switch_adc_1_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show(1, 5, switch_adc_1_5.isChecked());
            }
        });
        arrayListSwitch.add(switch_adc_1_5);
        switch_adc_1_6 = root.findViewById(R.id.switch_adc_1_6);
        switch_adc_1_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show(1, 6, switch_adc_1_6.isChecked());
            }
        });
        arrayListSwitch.add(switch_adc_1_6);
        switch_adc_1_7 = root.findViewById(R.id.switch_adc_1_7);
        switch_adc_1_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show(1, 7, switch_adc_1_7.isChecked());
            }
        });
        arrayListSwitch.add(switch_adc_1_7);
        switch_adc_1_8 = root.findViewById(R.id.switch_adc_1_8);
        switch_adc_1_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show(1, 8, switch_adc_1_8.isChecked());
            }
        });
        arrayListSwitch.add(switch_adc_1_8);
        switch_adc_1_9 = root.findViewById(R.id.switch_adc_1_9);
        switch_adc_1_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show(1, 9, switch_adc_1_9.isChecked());
            }
        });
        arrayListSwitch.add(switch_adc_1_9);
        switch_adc_1_10 = root.findViewById(R.id.switch_adc_1_10);
        switch_adc_1_10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show(1, 10, switch_adc_1_10.isChecked());
            }
        });
        arrayListSwitch.add(switch_adc_1_10);
        switch_adc_1_11 = root.findViewById(R.id.switch_adc_1_11);
        switch_adc_1_11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show(1, 11, switch_adc_1_11.isChecked());
            }
        });
        arrayListSwitch.add(switch_adc_1_11);
        switch_adc_1_12 = root.findViewById(R.id.switch_adc_1_12);
        switch_adc_1_12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show(1, 12, switch_adc_1_12.isChecked());
            }
        });
        arrayListSwitch.add(switch_adc_1_12);
        switch_adc_1_13 = root.findViewById(R.id.switch_adc_1_13);
        switch_adc_1_13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show(1, 13, switch_adc_1_13.isChecked());
            }
        });
        arrayListSwitch.add(switch_adc_1_13);
        switch_adc_1_14 = root.findViewById(R.id.switch_adc_1_14);
        switch_adc_1_14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show(1, 14, switch_adc_1_14.isChecked());
            }
        });
        arrayListSwitch.add(switch_adc_1_14);
        switch_adc_1_15 = root.findViewById(R.id.switch_adc_1_15);
        switch_adc_1_15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show(1, 15, switch_adc_1_15.isChecked());
            }
        });
        arrayListSwitch.add(switch_adc_1_15);

        switch_adc_2_0 = root.findViewById(R.id.switch_adc_2_0);
        switch_adc_2_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show(2, 0, switch_adc_2_0.isChecked());
            }
        });
        arrayListSwitch.add(switch_adc_2_0);
        switch_adc_2_1 = root.findViewById(R.id.switch_adc_2_1);
        switch_adc_2_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show(2, 1, switch_adc_2_1.isChecked());
            }
        });
        arrayListSwitch.add(switch_adc_2_1);
        switch_adc_2_2 = root.findViewById(R.id.switch_adc_2_2);
        switch_adc_2_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show(2, 2, switch_adc_2_2.isChecked());
            }
        });
        arrayListSwitch.add(switch_adc_2_2);
        switch_adc_2_3 = root.findViewById(R.id.switch_adc_2_3);
        switch_adc_2_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show(2, 3, switch_adc_2_3.isChecked());
            }
        });
        arrayListSwitch.add(switch_adc_2_3);
        switch_adc_2_4 = root.findViewById(R.id.switch_adc_2_4);
        switch_adc_2_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show(2, 4, switch_adc_2_4.isChecked());
            }
        });
        arrayListSwitch.add(switch_adc_2_4);
        switch_adc_2_5 = root.findViewById(R.id.switch_adc_2_5);
        switch_adc_2_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show(2, 5, switch_adc_2_5.isChecked());
            }
        });
        arrayListSwitch.add(switch_adc_2_5);
        switch_adc_2_6 = root.findViewById(R.id.switch_adc_2_6);
        switch_adc_2_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show(2, 6, switch_adc_2_6.isChecked());
            }
        });
        arrayListSwitch.add(switch_adc_2_6);
        switch_adc_2_7 = root.findViewById(R.id.switch_adc_2_7);
        switch_adc_2_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show(2, 7, switch_adc_2_7.isChecked());
            }
        });
        arrayListSwitch.add(switch_adc_2_7);
        switch_adc_2_8 = root.findViewById(R.id.switch_adc_2_8);
        switch_adc_2_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show(2, 8, switch_adc_2_8.isChecked());
            }
        });
        arrayListSwitch.add(switch_adc_2_8);
        switch_adc_2_9 = root.findViewById(R.id.switch_adc_2_9);
        switch_adc_2_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show(2, 9, switch_adc_2_9.isChecked());
            }
        });
        arrayListSwitch.add(switch_adc_2_9);
        switch_adc_2_10 = root.findViewById(R.id.switch_adc_2_10);
        switch_adc_2_10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show(2, 10, switch_adc_2_10.isChecked());
            }
        });
        arrayListSwitch.add(switch_adc_2_10);
        switch_adc_2_11 = root.findViewById(R.id.switch_adc_2_11);
        switch_adc_2_11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show(2, 11, switch_adc_2_11.isChecked());
            }
        });
        arrayListSwitch.add(switch_adc_2_11);
        switch_adc_2_12 = root.findViewById(R.id.switch_adc_2_12);
        switch_adc_2_12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show(2, 12, switch_adc_2_12.isChecked());
            }
        });
        arrayListSwitch.add(switch_adc_2_12);
        switch_adc_2_13 = root.findViewById(R.id.switch_adc_2_13);
        switch_adc_2_13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show(2, 13, switch_adc_2_13.isChecked());
            }
        });
        arrayListSwitch.add(switch_adc_2_13);
        switch_adc_2_14 = root.findViewById(R.id.switch_adc_2_14);
        switch_adc_2_14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show(2, 14, switch_adc_2_14.isChecked());
            }
        });
        arrayListSwitch.add(switch_adc_2_14);
        switch_adc_2_15 = root.findViewById(R.id.switch_adc_2_15);
        switch_adc_2_15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show(2, 15, switch_adc_2_15.isChecked());
            }
        });
        arrayListSwitch.add(switch_adc_2_15);

        upDateValues();

        upDateGraphicalDisplay = new UpDateGraphicalDisplay();
        upDateGraphicalDisplay.start();

        return root;
    }

    @Override
    public void onPause() {
        super.onPause();
        upDateGraphicalDisplay.interrupt();
    }

    public void upDateValues() {
        for (int i = 0; i < 48; i++) {
            int value = spaceAddress.getAddressSpace(stopCellNumber + i);
            arrayListTextView.get(i).setText(String.valueOf(value));
            if (value > 0)
                arrayListButton.get(i).setBackgroundColor(Color.RED);
            else arrayListButton.get(i).setBackgroundColor(Color.GREEN);
        }
    }

    public void addValueToLine(ArrayList<Line> arrayList, int time, int adc) {
        int i = 0;
        for (Line line : arrayList) {
            line.setData(time, spaceAddress.getAddressSpace(stopCellNumber + i + adc*16));
            i = i + 1;
        }
    }

    public void upDateChart(ArrayList<Line> arrayList, LineChart lineChart) {
        ArrayList<ILineDataSet> dataSets = new ArrayList();
        for (Line line : arrayList) {
            if (line.isEnableShow()) {
                dataSets.add(new LineDataSet(line.getArrayList(), line.getName()));
            }
        }
        LineData data = new LineData(dataSets);
        lineChart.setData(data);
        lineChart.invalidate();
    }

    public void show(int adc, int channel, boolean b) {
        arrayListChart.get(adc).getArrayList().get(channel).setEnableShow(b);
    }

    public class UpDateGraphicalDisplay extends Thread {
        @Override
        public void run() {
            super.run();
            while (true) {
                try {
                    UpDateGraphicalDisplay.sleep(timer);
                    upDateValues();
                } catch (InterruptedException e) {
                    break;
                }
                if (spaceStatus.isReadyFlagToExchangeData()) {
                    time = time + 1;
                    for (Chart chart: arrayListChart) {
                        addValueToLine(chart.getArrayList(), time, chart.getAdc());
                        upDateChart(chart.getArrayList(), chart.getLineChart());
                    }
                } else {
                    time = 0;
                }

            }
        }

        public UpDateGraphicalDisplay() {
        }
    }
}
