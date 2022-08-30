package com.example.set12ma.ui.main;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import com.example.set12ma.R;

import java.util.ArrayList;

public class FragmentSetting extends Fragment {
    private static final String ARG_SECTION_NUMBER = "Setting";

    private SpaceStatus spaceStatus;
    private ResultReceiverStatusSpace resultReceiverStatusSpace;

    private UpDateGraphicalDisplay upDateGraphicalDisplay;
    private long timer = 500;

    private ArrayList<ArrayAdapter> arrayList;
    private Spinner spinner_adc_0_ch_0_color;
    private ArrayAdapter<String> adapter_color_adc_0_ch_0;
    private Spinner spinner_adc_0_ch_1_color;
    private ArrayAdapter<String> adapter_color_adc_0_ch_1;
    private Spinner spinner_adc_0_ch_2_color;
    private ArrayAdapter<String> adapter_color_adc_0_ch_2;
    private Spinner spinner_adc_0_ch_3_color;
    private ArrayAdapter<String> adapter_color_adc_0_ch_3;
    private Spinner spinner_adc_0_ch_4_color;
    private ArrayAdapter<String> adapter_color_adc_0_ch_4;
    private Spinner spinner_adc_0_ch_5_color;
    private ArrayAdapter<String> adapter_color_adc_0_ch_5;
    private Spinner spinner_adc_0_ch_6_color;
    private ArrayAdapter<String> adapter_color_adc_0_ch_6;
    private Spinner spinner_adc_0_ch_7_color;
    private ArrayAdapter<String> adapter_color_adc_0_ch_7;
    private Spinner spinner_adc_0_ch_8_color;
    private ArrayAdapter<String> adapter_color_adc_0_ch_8;
    private Spinner spinner_adc_0_ch_9_color;
    private ArrayAdapter<String> adapter_color_adc_0_ch_9;
    private Spinner spinner_adc_0_ch_10_color;
    private ArrayAdapter<String> adapter_color_adc_0_ch_10;
    private Spinner spinner_adc_0_ch_11_color;
    private ArrayAdapter<String> adapter_color_adc_0_ch_11;
    private Spinner spinner_adc_0_ch_12_color;
    private ArrayAdapter<String> adapter_color_adc_0_ch_12;
    private Spinner spinner_adc_0_ch_13_color;
    private ArrayAdapter<String> adapter_color_adc_0_ch_13;
    private Spinner spinner_adc_0_ch_14_color;
    private ArrayAdapter<String> adapter_color_adc_0_ch_14;
    private Spinner spinner_adc_0_ch_15_color;
    private ArrayAdapter<String> adapter_color_adc_0_ch_15;

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
        spinner_adc_0_ch_0_color.setSelection(3);
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_setting, container, false);



        arrayList = new ArrayList<>();

        spinner_adc_0_ch_0_color = root.findViewById(R.id.spinner_adc_0_ch_0_color);
        adapter_color_adc_0_ch_0 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item);
        adapter_color_adc_0_ch_0.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        arrayList.add(adapter_color_adc_0_ch_0);

        spinner_adc_0_ch_1_color = root.findViewById(R.id.spinner_adc_0_ch_1_color);
        adapter_color_adc_0_ch_1 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item);
        adapter_color_adc_0_ch_1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        arrayList.add(adapter_color_adc_0_ch_1);

        spinner_adc_0_ch_2_color = root.findViewById(R.id.spinner_adc_0_ch_2_color);
        adapter_color_adc_0_ch_2 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item);
        adapter_color_adc_0_ch_2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        arrayList.add(adapter_color_adc_0_ch_2);

        spinner_adc_0_ch_3_color = root.findViewById(R.id.spinner_adc_0_ch_3_color);
        adapter_color_adc_0_ch_3 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item);
        adapter_color_adc_0_ch_3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        arrayList.add(adapter_color_adc_0_ch_3);

        spinner_adc_0_ch_4_color = root.findViewById(R.id.spinner_adc_0_ch_4_color);
        adapter_color_adc_0_ch_4 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item);
        adapter_color_adc_0_ch_4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        arrayList.add(adapter_color_adc_0_ch_4);

        spinner_adc_0_ch_5_color = root.findViewById(R.id.spinner_adc_0_ch_5_color);
        adapter_color_adc_0_ch_5 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item);
        adapter_color_adc_0_ch_5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        arrayList.add(adapter_color_adc_0_ch_5);

        spinner_adc_0_ch_6_color = root.findViewById(R.id.spinner_adc_0_ch_6_color);
        adapter_color_adc_0_ch_6 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item);
        adapter_color_adc_0_ch_6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        arrayList.add(adapter_color_adc_0_ch_6);

        spinner_adc_0_ch_7_color = root.findViewById(R.id.spinner_adc_0_ch_7_color);
        adapter_color_adc_0_ch_7 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item);
        adapter_color_adc_0_ch_7.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        arrayList.add(adapter_color_adc_0_ch_7);

        spinner_adc_0_ch_8_color = root.findViewById(R.id.spinner_adc_0_ch_8_color);
        adapter_color_adc_0_ch_8 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item);
        adapter_color_adc_0_ch_8.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        arrayList.add(adapter_color_adc_0_ch_8);

        spinner_adc_0_ch_9_color = root.findViewById(R.id.spinner_adc_0_ch_9_color);
        adapter_color_adc_0_ch_9 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item);
        adapter_color_adc_0_ch_9.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        arrayList.add(adapter_color_adc_0_ch_9);

        spinner_adc_0_ch_10_color = root.findViewById(R.id.spinner_adc_0_ch_10_color);
        adapter_color_adc_0_ch_10 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item);
        adapter_color_adc_0_ch_10.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        arrayList.add(adapter_color_adc_0_ch_10);

        spinner_adc_0_ch_11_color = root.findViewById(R.id.spinner_adc_0_ch_11_color);
        adapter_color_adc_0_ch_11 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item);
        adapter_color_adc_0_ch_11.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        arrayList.add(adapter_color_adc_0_ch_11);

        spinner_adc_0_ch_12_color = root.findViewById(R.id.spinner_adc_0_ch_12_color);
        adapter_color_adc_0_ch_12 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item);
        adapter_color_adc_0_ch_12.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        arrayList.add(adapter_color_adc_0_ch_12);

        spinner_adc_0_ch_13_color = root.findViewById(R.id.spinner_adc_0_ch_13_color);
        adapter_color_adc_0_ch_13 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item);
        adapter_color_adc_0_ch_13.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        arrayList.add(adapter_color_adc_0_ch_13);

        spinner_adc_0_ch_14_color = root.findViewById(R.id.spinner_adc_0_ch_14_color);
        adapter_color_adc_0_ch_14 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item);
        adapter_color_adc_0_ch_14.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        arrayList.add(adapter_color_adc_0_ch_14);

        spinner_adc_0_ch_15_color = root.findViewById(R.id.spinner_adc_0_ch_15_color);
        adapter_color_adc_0_ch_15 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item);
        adapter_color_adc_0_ch_15.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        arrayList.add(adapter_color_adc_0_ch_15);

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

        spinner_adc_0_ch_0_color.setAdapter(adapter_color_adc_0_ch_0);
        spinner_adc_0_ch_1_color.setAdapter(adapter_color_adc_0_ch_1);
        spinner_adc_0_ch_2_color.setAdapter(adapter_color_adc_0_ch_2);
        spinner_adc_0_ch_3_color.setAdapter(adapter_color_adc_0_ch_3);
        spinner_adc_0_ch_4_color.setAdapter(adapter_color_adc_0_ch_4);
        spinner_adc_0_ch_5_color.setAdapter(adapter_color_adc_0_ch_5);
        spinner_adc_0_ch_6_color.setAdapter(adapter_color_adc_0_ch_6);
        spinner_adc_0_ch_7_color.setAdapter(adapter_color_adc_0_ch_7);
        spinner_adc_0_ch_8_color.setAdapter(adapter_color_adc_0_ch_8);
        spinner_adc_0_ch_9_color.setAdapter(adapter_color_adc_0_ch_9);
        spinner_adc_0_ch_10_color.setAdapter(adapter_color_adc_0_ch_10);
        spinner_adc_0_ch_11_color.setAdapter(adapter_color_adc_0_ch_11);
        spinner_adc_0_ch_12_color.setAdapter(adapter_color_adc_0_ch_12);
        spinner_adc_0_ch_13_color.setAdapter(adapter_color_adc_0_ch_13);
        spinner_adc_0_ch_14_color.setAdapter(adapter_color_adc_0_ch_14);
        spinner_adc_0_ch_15_color.setAdapter(adapter_color_adc_0_ch_15);

        AdapterView.OnItemSelectedListener itemSelectedListener_adc_0_ch_0 = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int itemSelectedFromTypeOfDevices = spinner_adc_0_ch_0_color.getSelectedItemPosition();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        };
        spinner_adc_0_ch_0_color.setOnItemSelectedListener(itemSelectedListener_adc_0_ch_0);

        AdapterView.OnItemSelectedListener itemSelectedListener_adc_0_ch_1 = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int itemSelectedFromTypeOfDevices = spinner_adc_0_ch_1_color.getSelectedItemPosition();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        };
        spinner_adc_0_ch_1_color.setOnItemSelectedListener(itemSelectedListener_adc_0_ch_1);

        AdapterView.OnItemSelectedListener itemSelectedListener_adc_0_ch_2 = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int itemSelectedFromTypeOfDevices = spinner_adc_0_ch_2_color.getSelectedItemPosition();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        };
        spinner_adc_0_ch_2_color.setOnItemSelectedListener(itemSelectedListener_adc_0_ch_2);

        AdapterView.OnItemSelectedListener itemSelectedListener_adc_0_ch_3 = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int itemSelectedFromTypeOfDevices = spinner_adc_0_ch_3_color.getSelectedItemPosition();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        };
        spinner_adc_0_ch_3_color.setOnItemSelectedListener(itemSelectedListener_adc_0_ch_3);

        AdapterView.OnItemSelectedListener itemSelectedListener_adc_0_ch_4 = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int itemSelectedFromTypeOfDevices = spinner_adc_0_ch_4_color.getSelectedItemPosition();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        };
        spinner_adc_0_ch_4_color.setOnItemSelectedListener(itemSelectedListener_adc_0_ch_4);

        AdapterView.OnItemSelectedListener itemSelectedListener_adc_0_ch_5 = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int itemSelectedFromTypeOfDevices = spinner_adc_0_ch_5_color.getSelectedItemPosition();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        };
        spinner_adc_0_ch_5_color.setOnItemSelectedListener(itemSelectedListener_adc_0_ch_5);

        AdapterView.OnItemSelectedListener itemSelectedListener_adc_0_ch_6 = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int itemSelectedFromTypeOfDevices = spinner_adc_0_ch_6_color.getSelectedItemPosition();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        };
        spinner_adc_0_ch_6_color.setOnItemSelectedListener(itemSelectedListener_adc_0_ch_6);

        AdapterView.OnItemSelectedListener itemSelectedListener_adc_0_ch_7 = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int itemSelectedFromTypeOfDevices = spinner_adc_0_ch_7_color.getSelectedItemPosition();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        };
        spinner_adc_0_ch_7_color.setOnItemSelectedListener(itemSelectedListener_adc_0_ch_7);

        AdapterView.OnItemSelectedListener itemSelectedListener_adc_0_ch_8 = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int itemSelectedFromTypeOfDevices = spinner_adc_0_ch_8_color.getSelectedItemPosition();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        };
        spinner_adc_0_ch_8_color.setOnItemSelectedListener(itemSelectedListener_adc_0_ch_8);

        AdapterView.OnItemSelectedListener itemSelectedListener_adc_0_ch_9 = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int itemSelectedFromTypeOfDevices = spinner_adc_0_ch_9_color.getSelectedItemPosition();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        };
        spinner_adc_0_ch_9_color.setOnItemSelectedListener(itemSelectedListener_adc_0_ch_9);

        AdapterView.OnItemSelectedListener itemSelectedListener_adc_0_ch_10 = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int itemSelectedFromTypeOfDevices = spinner_adc_0_ch_10_color.getSelectedItemPosition();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        };
        spinner_adc_0_ch_10_color.setOnItemSelectedListener(itemSelectedListener_adc_0_ch_10);

        AdapterView.OnItemSelectedListener itemSelectedListener_adc_0_ch_11 = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int itemSelectedFromTypeOfDevices = spinner_adc_0_ch_11_color.getSelectedItemPosition();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        };
        spinner_adc_0_ch_11_color.setOnItemSelectedListener(itemSelectedListener_adc_0_ch_11);

        AdapterView.OnItemSelectedListener itemSelectedListener_adc_0_ch_12 = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int itemSelectedFromTypeOfDevices = spinner_adc_0_ch_12_color.getSelectedItemPosition();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        };
        spinner_adc_0_ch_12_color.setOnItemSelectedListener(itemSelectedListener_adc_0_ch_12);

        AdapterView.OnItemSelectedListener itemSelectedListener_adc_0_ch_13 = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int itemSelectedFromTypeOfDevices = spinner_adc_0_ch_13_color.getSelectedItemPosition();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        };
        spinner_adc_0_ch_13_color.setOnItemSelectedListener(itemSelectedListener_adc_0_ch_13);

        AdapterView.OnItemSelectedListener itemSelectedListener_adc_0_ch_14 = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int itemSelectedFromTypeOfDevices = spinner_adc_0_ch_14_color.getSelectedItemPosition();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        };
        spinner_adc_0_ch_14_color.setOnItemSelectedListener(itemSelectedListener_adc_0_ch_14);

        AdapterView.OnItemSelectedListener itemSelectedListener_adc_0_ch_15 = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int itemSelectedFromTypeOfDevices = spinner_adc_0_ch_15_color.getSelectedItemPosition();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        };
        spinner_adc_0_ch_15_color.setOnItemSelectedListener(itemSelectedListener_adc_0_ch_15);



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
