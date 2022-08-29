package com.example.set12ma.ui.main;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import com.example.set12ma.R;

import java.io.*;
import java.util.ArrayList;

public class FragmentSetting extends Fragment {
    private static final String ARG_SECTION_NUMBER = "Setting";

    private SpaceStatus spaceStatus;
    private ResultReceiverStatusSpace resultReceiverStatusSpace;

    private UpDateGraphicalDisplay upDateGraphicalDisplay;
    private long timer = 500;

    private ArrayList<ArrayAdapter> arrayList;
    private Spinner spinner_adc_0_ch_0;
    private ArrayAdapter<String> adapter_Color_adc_0_ch_0;
    private Spinner spinner_adc_0_ch_1;
    private ArrayAdapter<String> adapter_Color_adc_0_ch_1;
    private Spinner spinner_adc_0_ch_2;
    private ArrayAdapter<String> adapter_Color_adc_0_ch_2;
    private Spinner spinner_adc_0_ch_3;
    private ArrayAdapter<String> adapter_Color_adc_0_ch_3;
    private Spinner spinner_adc_0_ch_4;
    private ArrayAdapter<String> adapter_Color_adc_0_ch_4;
    private Spinner spinner_adc_0_ch_5;
    private ArrayAdapter<String> adapter_Color_adc_0_ch_5;
    private Spinner spinner_adc_0_ch_6;
    private ArrayAdapter<String> adapter_Color_adc_0_ch_6;
    private Spinner spinner_adc_0_ch_7;
    private ArrayAdapter<String> adapter_Color_adc_0_ch_7;
    private Spinner spinner_adc_0_ch_8;
    private ArrayAdapter<String> adapter_Color_adc_0_ch_8;
    private Spinner spinner_adc_0_ch_9;
    private ArrayAdapter<String> adapter_Color_adc_0_ch_9;
    private Spinner spinner_adc_0_ch_10;
    private ArrayAdapter<String> adapter_Color_adc_0_ch_10;
    private Spinner spinner_adc_0_ch_11;
    private ArrayAdapter<String> adapter_Color_adc_0_ch_11;
    private Spinner spinner_adc_0_ch_12;
    private ArrayAdapter<String> adapter_Color_adc_0_ch_12;
    private Spinner spinner_adc_0_ch_13;
    private ArrayAdapter<String> adapter_Color_adc_0_ch_13;
    private Spinner spinner_adc_0_ch_14;
    private ArrayAdapter<String> adapter_Color_adc_0_ch_14;
    private Spinner spinner_adc_0_ch_15;
    private ArrayAdapter<String> adapter_Color_adc_0_ch_15;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        resultReceiverStatusSpace = (ResultReceiverStatusSpace) context;
    }

    private PageViewModel pageViewModel;

    public static FragmentSetting newInstance(int index) {
        FragmentSetting fragment = new FragmentSetting();
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
        spaceStatus = resultReceiverStatusSpace.getSpaceStatus();
    }

    @Override
    public void onResume() {
        super.onResume();
        spinner_adc_0_ch_0.setSelection(3);
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_setting, container, false);



        arrayList = new ArrayList<>();

        spinner_adc_0_ch_0 = root.findViewById(R.id.spinner_adc_0_ch_0);
        adapter_Color_adc_0_ch_0 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item);
        adapter_Color_adc_0_ch_0.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        arrayList.add(adapter_Color_adc_0_ch_0);

        spinner_adc_0_ch_1 = root.findViewById(R.id.spinner_adc_0_ch_1);
        adapter_Color_adc_0_ch_1 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item);
        adapter_Color_adc_0_ch_1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        arrayList.add(adapter_Color_adc_0_ch_1);

        spinner_adc_0_ch_2 = root.findViewById(R.id.spinner_adc_0_ch_2);
        adapter_Color_adc_0_ch_2 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item);
        adapter_Color_adc_0_ch_2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        arrayList.add(adapter_Color_adc_0_ch_2);

        spinner_adc_0_ch_3 = root.findViewById(R.id.spinner_adc_0_ch_3);
        adapter_Color_adc_0_ch_3 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item);
        adapter_Color_adc_0_ch_3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        arrayList.add(adapter_Color_adc_0_ch_3);

        spinner_adc_0_ch_4 = root.findViewById(R.id.spinner_adc_0_ch_4);
        adapter_Color_adc_0_ch_4 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item);
        adapter_Color_adc_0_ch_4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        arrayList.add(adapter_Color_adc_0_ch_4);

        spinner_adc_0_ch_5 = root.findViewById(R.id.spinner_adc_0_ch_5);
        adapter_Color_adc_0_ch_5 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item);
        adapter_Color_adc_0_ch_5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        arrayList.add(adapter_Color_adc_0_ch_5);

        spinner_adc_0_ch_6 = root.findViewById(R.id.spinner_adc_0_ch_6);
        adapter_Color_adc_0_ch_6 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item);
        adapter_Color_adc_0_ch_6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        arrayList.add(adapter_Color_adc_0_ch_6);

        spinner_adc_0_ch_7 = root.findViewById(R.id.spinner_adc_0_ch_7);
        adapter_Color_adc_0_ch_7 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item);
        adapter_Color_adc_0_ch_7.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        arrayList.add(adapter_Color_adc_0_ch_7);

        spinner_adc_0_ch_8 = root.findViewById(R.id.spinner_adc_0_ch_8);
        adapter_Color_adc_0_ch_8 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item);
        adapter_Color_adc_0_ch_8.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        arrayList.add(adapter_Color_adc_0_ch_8);

        spinner_adc_0_ch_9 = root.findViewById(R.id.spinner_adc_0_ch_9);
        adapter_Color_adc_0_ch_9 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item);
        adapter_Color_adc_0_ch_9.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        arrayList.add(adapter_Color_adc_0_ch_9);

        spinner_adc_0_ch_10 = root.findViewById(R.id.spinner_adc_0_ch_10);
        adapter_Color_adc_0_ch_10 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item);
        adapter_Color_adc_0_ch_10.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        arrayList.add(adapter_Color_adc_0_ch_10);

        spinner_adc_0_ch_11 = root.findViewById(R.id.spinner_adc_0_ch_11);
        adapter_Color_adc_0_ch_11 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item);
        adapter_Color_adc_0_ch_11.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        arrayList.add(adapter_Color_adc_0_ch_11);

        spinner_adc_0_ch_12 = root.findViewById(R.id.spinner_adc_0_ch_12);
        adapter_Color_adc_0_ch_12 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item);
        adapter_Color_adc_0_ch_12.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        arrayList.add(adapter_Color_adc_0_ch_12);

        spinner_adc_0_ch_13 = root.findViewById(R.id.spinner_adc_0_ch_13);
        adapter_Color_adc_0_ch_13 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item);
        adapter_Color_adc_0_ch_13.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        arrayList.add(adapter_Color_adc_0_ch_13);

        spinner_adc_0_ch_14 = root.findViewById(R.id.spinner_adc_0_ch_14);
        adapter_Color_adc_0_ch_14 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item);
        adapter_Color_adc_0_ch_14.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        arrayList.add(adapter_Color_adc_0_ch_14);

        spinner_adc_0_ch_15 = root.findViewById(R.id.spinner_adc_0_ch_15);
        adapter_Color_adc_0_ch_15 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item);
        adapter_Color_adc_0_ch_15.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        arrayList.add(adapter_Color_adc_0_ch_15);

        for (ArrayAdapter arrayAdapter: arrayList) {
            arrayAdapter.add("Color.GREEN");
            arrayAdapter.add("Color.RED");
            arrayAdapter.add("Color.BLUE");
            arrayAdapter.add("Color.CYAN");
            arrayAdapter.add("Color.GRAY");
            arrayAdapter.add("Color.WHITE");
            arrayAdapter.add("Color.YELLOW");
            arrayAdapter.add("Color.MAGENTA");
        }

        spinner_adc_0_ch_0.setAdapter(adapter_Color_adc_0_ch_0);
        spinner_adc_0_ch_1.setAdapter(adapter_Color_adc_0_ch_1);
        spinner_adc_0_ch_2.setAdapter(adapter_Color_adc_0_ch_2);
        spinner_adc_0_ch_3.setAdapter(adapter_Color_adc_0_ch_3);
        spinner_adc_0_ch_4.setAdapter(adapter_Color_adc_0_ch_4);
        spinner_adc_0_ch_5.setAdapter(adapter_Color_adc_0_ch_5);
        spinner_adc_0_ch_6.setAdapter(adapter_Color_adc_0_ch_6);
        spinner_adc_0_ch_7.setAdapter(adapter_Color_adc_0_ch_7);
        spinner_adc_0_ch_8.setAdapter(adapter_Color_adc_0_ch_8);
        spinner_adc_0_ch_9.setAdapter(adapter_Color_adc_0_ch_9);
        spinner_adc_0_ch_10.setAdapter(adapter_Color_adc_0_ch_10);
        spinner_adc_0_ch_11.setAdapter(adapter_Color_adc_0_ch_11);
        spinner_adc_0_ch_12.setAdapter(adapter_Color_adc_0_ch_12);
        spinner_adc_0_ch_13.setAdapter(adapter_Color_adc_0_ch_13);
        spinner_adc_0_ch_14.setAdapter(adapter_Color_adc_0_ch_14);
        spinner_adc_0_ch_15.setAdapter(adapter_Color_adc_0_ch_15);

        AdapterView.OnItemSelectedListener itemSelectedListener_adc_0_ch_0 = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int itemSelectedFromTypeOfDevices = spinner_adc_0_ch_0.getSelectedItemPosition();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        };
        spinner_adc_0_ch_0.setOnItemSelectedListener(itemSelectedListener_adc_0_ch_0);

        AdapterView.OnItemSelectedListener itemSelectedListener_adc_0_ch_1 = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int itemSelectedFromTypeOfDevices = spinner_adc_0_ch_1.getSelectedItemPosition();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        };
        spinner_adc_0_ch_1.setOnItemSelectedListener(itemSelectedListener_adc_0_ch_1);

        AdapterView.OnItemSelectedListener itemSelectedListener_adc_0_ch_2 = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int itemSelectedFromTypeOfDevices = spinner_adc_0_ch_2.getSelectedItemPosition();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        };
        spinner_adc_0_ch_2.setOnItemSelectedListener(itemSelectedListener_adc_0_ch_2);

        AdapterView.OnItemSelectedListener itemSelectedListener_adc_0_ch_3 = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int itemSelectedFromTypeOfDevices = spinner_adc_0_ch_3.getSelectedItemPosition();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        };
        spinner_adc_0_ch_3.setOnItemSelectedListener(itemSelectedListener_adc_0_ch_3);

        AdapterView.OnItemSelectedListener itemSelectedListener_adc_0_ch_4 = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int itemSelectedFromTypeOfDevices = spinner_adc_0_ch_4.getSelectedItemPosition();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        };
        spinner_adc_0_ch_4.setOnItemSelectedListener(itemSelectedListener_adc_0_ch_4);

        AdapterView.OnItemSelectedListener itemSelectedListener_adc_0_ch_5 = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int itemSelectedFromTypeOfDevices = spinner_adc_0_ch_5.getSelectedItemPosition();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        };
        spinner_adc_0_ch_5.setOnItemSelectedListener(itemSelectedListener_adc_0_ch_5);

        AdapterView.OnItemSelectedListener itemSelectedListener_adc_0_ch_6 = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int itemSelectedFromTypeOfDevices = spinner_adc_0_ch_6.getSelectedItemPosition();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        };
        spinner_adc_0_ch_6.setOnItemSelectedListener(itemSelectedListener_adc_0_ch_6);

        AdapterView.OnItemSelectedListener itemSelectedListener_adc_0_ch_7 = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int itemSelectedFromTypeOfDevices = spinner_adc_0_ch_7.getSelectedItemPosition();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        };
        spinner_adc_0_ch_7.setOnItemSelectedListener(itemSelectedListener_adc_0_ch_7);

        AdapterView.OnItemSelectedListener itemSelectedListener_adc_0_ch_8 = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int itemSelectedFromTypeOfDevices = spinner_adc_0_ch_8.getSelectedItemPosition();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        };
        spinner_adc_0_ch_8.setOnItemSelectedListener(itemSelectedListener_adc_0_ch_8);

        AdapterView.OnItemSelectedListener itemSelectedListener_adc_0_ch_9 = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int itemSelectedFromTypeOfDevices = spinner_adc_0_ch_9.getSelectedItemPosition();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        };
        spinner_adc_0_ch_9.setOnItemSelectedListener(itemSelectedListener_adc_0_ch_9);

        AdapterView.OnItemSelectedListener itemSelectedListener_adc_0_ch_10 = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int itemSelectedFromTypeOfDevices = spinner_adc_0_ch_10.getSelectedItemPosition();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        };
        spinner_adc_0_ch_10.setOnItemSelectedListener(itemSelectedListener_adc_0_ch_10);

        AdapterView.OnItemSelectedListener itemSelectedListener_adc_0_ch_11 = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int itemSelectedFromTypeOfDevices = spinner_adc_0_ch_11.getSelectedItemPosition();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        };
        spinner_adc_0_ch_11.setOnItemSelectedListener(itemSelectedListener_adc_0_ch_11);

        AdapterView.OnItemSelectedListener itemSelectedListener_adc_0_ch_12 = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int itemSelectedFromTypeOfDevices = spinner_adc_0_ch_12.getSelectedItemPosition();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        };
        spinner_adc_0_ch_12.setOnItemSelectedListener(itemSelectedListener_adc_0_ch_12);

        AdapterView.OnItemSelectedListener itemSelectedListener_adc_0_ch_13 = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int itemSelectedFromTypeOfDevices = spinner_adc_0_ch_13.getSelectedItemPosition();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        };
        spinner_adc_0_ch_13.setOnItemSelectedListener(itemSelectedListener_adc_0_ch_13);

        AdapterView.OnItemSelectedListener itemSelectedListener_adc_0_ch_14 = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int itemSelectedFromTypeOfDevices = spinner_adc_0_ch_14.getSelectedItemPosition();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        };
        spinner_adc_0_ch_14.setOnItemSelectedListener(itemSelectedListener_adc_0_ch_14);

        AdapterView.OnItemSelectedListener itemSelectedListener_adc_0_ch_15 = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int itemSelectedFromTypeOfDevices = spinner_adc_0_ch_15.getSelectedItemPosition();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        };
        spinner_adc_0_ch_15.setOnItemSelectedListener(itemSelectedListener_adc_0_ch_15);



        return root;
    }

    public class UpDateGraphicalDisplay extends Thread {

        boolean latch = false;

        @Override
        public void run() {
            while (true) {

            }

        }

        public UpDateGraphicalDisplay() {
        }
    }
}
