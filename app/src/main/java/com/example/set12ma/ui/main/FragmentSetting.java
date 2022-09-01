package com.example.set12ma.ui.main;

import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
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

    private SpaceSetting spaceSetting;
    private ResultReceiverSettingSpace resultReceiverSettingSpace;

    private UpDateGraphicalDisplay upDateGraphicalDisplay;
    private long timer = 500;

    private ArrayList<Spinner> spinnerArrayList;
    private ArrayList<ArrayAdapter> adapterArrayList;
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

    private ArrayList<EditText> editTextArrayListName;
    private EditText editText_adc_0_ch_0_name;
    private EditText editText_adc_0_ch_1_name;
    private EditText editText_adc_0_ch_2_name;
    private EditText editText_adc_0_ch_3_name;
    private EditText editText_adc_0_ch_4_name;
    private EditText editText_adc_0_ch_5_name;
    private EditText editText_adc_0_ch_6_name;
    private EditText editText_adc_0_ch_7_name;
    private EditText editText_adc_0_ch_8_name;
    private EditText editText_adc_0_ch_9_name;
    private EditText editText_adc_0_ch_10_name;
    private EditText editText_adc_0_ch_11_name;
    private EditText editText_adc_0_ch_12_name;
    private EditText editText_adc_0_ch_13_name;
    private EditText editText_adc_0_ch_14_name;
    private EditText editText_adc_0_ch_15_name;



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        resultReceiverStatusSpace = (ResultReceiverStatusSpace) context;
        resultReceiverSettingSpace = (ResultReceiverSettingSpace) context;
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
        spaceSetting = resultReceiverSettingSpace.getSpaceSetting();
    }

    @Override
    public void onResume() {
        super.onResume();
        int i = 0;
        for (Spinner spinner: spinnerArrayList) {
            spinner.setSelection(spaceSetting.getAdcArrayList().get(i).getColor());
            i= i + 1;
        }
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_setting, container, false);


        spinnerArrayList = new ArrayList<>();
        adapterArrayList = new ArrayList<>();

        spinner_adc_0_ch_0_color = root.findViewById(R.id.spinner_adc_0_ch_0_color);
        adapter_color_adc_0_ch_0 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item);
        adapter_color_adc_0_ch_0.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterArrayList.add(adapter_color_adc_0_ch_0);
        spinnerArrayList.add(spinner_adc_0_ch_0_color);

        spinner_adc_0_ch_1_color = root.findViewById(R.id.spinner_adc_0_ch_1_color);
        adapter_color_adc_0_ch_1 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item);
        adapter_color_adc_0_ch_1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterArrayList.add(adapter_color_adc_0_ch_1);
        spinnerArrayList.add(spinner_adc_0_ch_1_color);

        spinner_adc_0_ch_2_color = root.findViewById(R.id.spinner_adc_0_ch_2_color);
        adapter_color_adc_0_ch_2 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item);
        adapter_color_adc_0_ch_2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterArrayList.add(adapter_color_adc_0_ch_2);
        spinnerArrayList.add(spinner_adc_0_ch_2_color);

        spinner_adc_0_ch_3_color = root.findViewById(R.id.spinner_adc_0_ch_3_color);
        adapter_color_adc_0_ch_3 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item);
        adapter_color_adc_0_ch_3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterArrayList.add(adapter_color_adc_0_ch_3);
        spinnerArrayList.add(spinner_adc_0_ch_3_color);

        spinner_adc_0_ch_4_color = root.findViewById(R.id.spinner_adc_0_ch_4_color);
        adapter_color_adc_0_ch_4 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item);
        adapter_color_adc_0_ch_4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterArrayList.add(adapter_color_adc_0_ch_4);
        spinnerArrayList.add(spinner_adc_0_ch_4_color);

        spinner_adc_0_ch_5_color = root.findViewById(R.id.spinner_adc_0_ch_5_color);
        adapter_color_adc_0_ch_5 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item);
        adapter_color_adc_0_ch_5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterArrayList.add(adapter_color_adc_0_ch_5);
        spinnerArrayList.add(spinner_adc_0_ch_5_color);

        spinner_adc_0_ch_6_color = root.findViewById(R.id.spinner_adc_0_ch_6_color);
        adapter_color_adc_0_ch_6 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item);
        adapter_color_adc_0_ch_6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterArrayList.add(adapter_color_adc_0_ch_6);
        spinnerArrayList.add(spinner_adc_0_ch_6_color);

        spinner_adc_0_ch_7_color = root.findViewById(R.id.spinner_adc_0_ch_7_color);
        adapter_color_adc_0_ch_7 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item);
        adapter_color_adc_0_ch_7.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterArrayList.add(adapter_color_adc_0_ch_7);
        spinnerArrayList.add(spinner_adc_0_ch_7_color);

        spinner_adc_0_ch_8_color = root.findViewById(R.id.spinner_adc_0_ch_8_color);
        adapter_color_adc_0_ch_8 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item);
        adapter_color_adc_0_ch_8.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterArrayList.add(adapter_color_adc_0_ch_8);
        spinnerArrayList.add(spinner_adc_0_ch_8_color);

        spinner_adc_0_ch_9_color = root.findViewById(R.id.spinner_adc_0_ch_9_color);
        adapter_color_adc_0_ch_9 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item);
        adapter_color_adc_0_ch_9.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterArrayList.add(adapter_color_adc_0_ch_9);
        spinnerArrayList.add(spinner_adc_0_ch_9_color);

        spinner_adc_0_ch_10_color = root.findViewById(R.id.spinner_adc_0_ch_10_color);
        adapter_color_adc_0_ch_10 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item);
        adapter_color_adc_0_ch_10.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterArrayList.add(adapter_color_adc_0_ch_10);
        spinnerArrayList.add(spinner_adc_0_ch_10_color);

        spinner_adc_0_ch_11_color = root.findViewById(R.id.spinner_adc_0_ch_11_color);
        adapter_color_adc_0_ch_11 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item);
        adapter_color_adc_0_ch_11.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterArrayList.add(adapter_color_adc_0_ch_11);
        spinnerArrayList.add(spinner_adc_0_ch_11_color);

        spinner_adc_0_ch_12_color = root.findViewById(R.id.spinner_adc_0_ch_12_color);
        adapter_color_adc_0_ch_12 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item);
        adapter_color_adc_0_ch_12.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterArrayList.add(adapter_color_adc_0_ch_12);
        spinnerArrayList.add(spinner_adc_0_ch_12_color);

        spinner_adc_0_ch_13_color = root.findViewById(R.id.spinner_adc_0_ch_13_color);
        adapter_color_adc_0_ch_13 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item);
        adapter_color_adc_0_ch_13.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterArrayList.add(adapter_color_adc_0_ch_13);
        spinnerArrayList.add(spinner_adc_0_ch_13_color);

        spinner_adc_0_ch_14_color = root.findViewById(R.id.spinner_adc_0_ch_14_color);
        adapter_color_adc_0_ch_14 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item);
        adapter_color_adc_0_ch_14.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterArrayList.add(adapter_color_adc_0_ch_14);
        spinnerArrayList.add(spinner_adc_0_ch_14_color);

        spinner_adc_0_ch_15_color = root.findViewById(R.id.spinner_adc_0_ch_15_color);
        adapter_color_adc_0_ch_15 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item);
        adapter_color_adc_0_ch_15.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterArrayList.add(adapter_color_adc_0_ch_15);
        spinnerArrayList.add(spinner_adc_0_ch_15_color);

        for (ArrayAdapter arrayAdapter: adapterArrayList) {
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
                int itemSelected = spinner_adc_0_ch_0_color.getSelectedItemPosition();
                spaceSetting.setSharedPreferences("adc_0_0_color", itemSelected);
                spaceSetting.getAdcArrayList().get(0).setColor(itemSelected);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        };
        spinner_adc_0_ch_0_color.setOnItemSelectedListener(itemSelectedListener_adc_0_ch_0);

        AdapterView.OnItemSelectedListener itemSelectedListener_adc_0_ch_1 = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int itemSelected = spinner_adc_0_ch_1_color.getSelectedItemPosition();
                spaceSetting.setSharedPreferences("adc_0_1_color", itemSelected);
                spaceSetting.getAdcArrayList().get(1).setColor(itemSelected);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        };
        spinner_adc_0_ch_1_color.setOnItemSelectedListener(itemSelectedListener_adc_0_ch_1);

        AdapterView.OnItemSelectedListener itemSelectedListener_adc_0_ch_2 = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int itemSelected = spinner_adc_0_ch_2_color.getSelectedItemPosition();
                spaceSetting.setSharedPreferences("adc_0_2_color", itemSelected);
                spaceSetting.getAdcArrayList().get(2).setColor(itemSelected);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        };
        spinner_adc_0_ch_2_color.setOnItemSelectedListener(itemSelectedListener_adc_0_ch_2);

        AdapterView.OnItemSelectedListener itemSelectedListener_adc_0_ch_3 = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int itemSelected = spinner_adc_0_ch_3_color.getSelectedItemPosition();
                spaceSetting.setSharedPreferences("adc_0_3_color", itemSelected);
                spaceSetting.getAdcArrayList().get(3).setColor(itemSelected);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        };
        spinner_adc_0_ch_3_color.setOnItemSelectedListener(itemSelectedListener_adc_0_ch_3);

        AdapterView.OnItemSelectedListener itemSelectedListener_adc_0_ch_4 = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int itemSelected = spinner_adc_0_ch_4_color.getSelectedItemPosition();
                spaceSetting.setSharedPreferences("adc_0_4_color", itemSelected);
                spaceSetting.getAdcArrayList().get(4).setColor(itemSelected);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        };
        spinner_adc_0_ch_4_color.setOnItemSelectedListener(itemSelectedListener_adc_0_ch_4);

        AdapterView.OnItemSelectedListener itemSelectedListener_adc_0_ch_5 = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int itemSelected = spinner_adc_0_ch_5_color.getSelectedItemPosition();
                spaceSetting.setSharedPreferences("adc_0_5_color", itemSelected);
                spaceSetting.getAdcArrayList().get(5).setColor(itemSelected);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        };
        spinner_adc_0_ch_5_color.setOnItemSelectedListener(itemSelectedListener_adc_0_ch_5);

        AdapterView.OnItemSelectedListener itemSelectedListener_adc_0_ch_6 = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int itemSelected = spinner_adc_0_ch_6_color.getSelectedItemPosition();
                spaceSetting.setSharedPreferences("adc_0_6_color", itemSelected);
                spaceSetting.getAdcArrayList().get(6).setColor(itemSelected);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        };
        spinner_adc_0_ch_6_color.setOnItemSelectedListener(itemSelectedListener_adc_0_ch_6);

        AdapterView.OnItemSelectedListener itemSelectedListener_adc_0_ch_7 = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int itemSelected = spinner_adc_0_ch_7_color.getSelectedItemPosition();
                spaceSetting.setSharedPreferences("adc_0_7_color", itemSelected);
                spaceSetting.getAdcArrayList().get(7).setColor(itemSelected);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        };
        spinner_adc_0_ch_7_color.setOnItemSelectedListener(itemSelectedListener_adc_0_ch_7);

        AdapterView.OnItemSelectedListener itemSelectedListener_adc_0_ch_8 = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int itemSelected = spinner_adc_0_ch_8_color.getSelectedItemPosition();
                spaceSetting.setSharedPreferences("adc_0_8_color", itemSelected);
                spaceSetting.getAdcArrayList().get(8).setColor(itemSelected);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        };
        spinner_adc_0_ch_8_color.setOnItemSelectedListener(itemSelectedListener_adc_0_ch_8);

        AdapterView.OnItemSelectedListener itemSelectedListener_adc_0_ch_9 = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int itemSelected = spinner_adc_0_ch_9_color.getSelectedItemPosition();
                spaceSetting.setSharedPreferences("adc_0_9_color", itemSelected);
                spaceSetting.getAdcArrayList().get(9).setColor(itemSelected);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        };
        spinner_adc_0_ch_9_color.setOnItemSelectedListener(itemSelectedListener_adc_0_ch_9);

        AdapterView.OnItemSelectedListener itemSelectedListener_adc_0_ch_10 = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int itemSelected = spinner_adc_0_ch_10_color.getSelectedItemPosition();
                spaceSetting.setSharedPreferences("adc_0_10_color", itemSelected);
                spaceSetting.getAdcArrayList().get(10).setColor(itemSelected);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        };
        spinner_adc_0_ch_10_color.setOnItemSelectedListener(itemSelectedListener_adc_0_ch_10);

        AdapterView.OnItemSelectedListener itemSelectedListener_adc_0_ch_11 = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int itemSelected = spinner_adc_0_ch_11_color.getSelectedItemPosition();
                spaceSetting.setSharedPreferences("adc_0_11_color", itemSelected);
                spaceSetting.getAdcArrayList().get(11).setColor(itemSelected);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        };
        spinner_adc_0_ch_11_color.setOnItemSelectedListener(itemSelectedListener_adc_0_ch_11);

        AdapterView.OnItemSelectedListener itemSelectedListener_adc_0_ch_12 = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int itemSelected = spinner_adc_0_ch_12_color.getSelectedItemPosition();
                spaceSetting.setSharedPreferences("adc_0_12_color", itemSelected);
                spaceSetting.getAdcArrayList().get(12).setColor(itemSelected);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        };
        spinner_adc_0_ch_12_color.setOnItemSelectedListener(itemSelectedListener_adc_0_ch_12);

        AdapterView.OnItemSelectedListener itemSelectedListener_adc_0_ch_13 = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int itemSelected = spinner_adc_0_ch_13_color.getSelectedItemPosition();
                spaceSetting.setSharedPreferences("adc_0_13_color", itemSelected);
                spaceSetting.getAdcArrayList().get(13).setColor(itemSelected);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        };
        spinner_adc_0_ch_13_color.setOnItemSelectedListener(itemSelectedListener_adc_0_ch_13);

        AdapterView.OnItemSelectedListener itemSelectedListener_adc_0_ch_14 = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int itemSelected = spinner_adc_0_ch_14_color.getSelectedItemPosition();
                spaceSetting.setSharedPreferences("adc_0_14_color", itemSelected);
                spaceSetting.getAdcArrayList().get(14).setColor(itemSelected);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        };
        spinner_adc_0_ch_14_color.setOnItemSelectedListener(itemSelectedListener_adc_0_ch_14);

        AdapterView.OnItemSelectedListener itemSelectedListener_adc_0_ch_15 = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int itemSelected = spinner_adc_0_ch_15_color.getSelectedItemPosition();
                spaceSetting.setSharedPreferences("adc_0_15_color", itemSelected);
                spaceSetting.getAdcArrayList().get(15).setColor(itemSelected);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        };
        spinner_adc_0_ch_15_color.setOnItemSelectedListener(itemSelectedListener_adc_0_ch_15);

        editTextArrayListName = new ArrayList<>();

        editText_adc_0_ch_0_name = root.findViewById(R.id.editText_adc_0_ch_0_name);
        editTextArrayListName.add(editText_adc_0_ch_0_name);
        editText_adc_0_ch_1_name = root.findViewById(R.id.editText_adc_0_ch_1_name);
        editTextArrayListName.add(editText_adc_0_ch_1_name);
        editText_adc_0_ch_2_name = root.findViewById(R.id.editText_adc_0_ch_2_name);
        editTextArrayListName.add(editText_adc_0_ch_2_name);
        editText_adc_0_ch_3_name = root.findViewById(R.id.editText_adc_0_ch_3_name);
        editTextArrayListName.add(editText_adc_0_ch_3_name);
        editText_adc_0_ch_4_name = root.findViewById(R.id.editText_adc_0_ch_4_name);
        editTextArrayListName.add(editText_adc_0_ch_4_name);
        editText_adc_0_ch_5_name = root.findViewById(R.id.editText_adc_0_ch_5_name);
        editTextArrayListName.add(editText_adc_0_ch_5_name);
        editText_adc_0_ch_6_name = root.findViewById(R.id.editText_adc_0_ch_6_name);
        editTextArrayListName.add(editText_adc_0_ch_6_name);
        editText_adc_0_ch_7_name = root.findViewById(R.id.editText_adc_0_ch_7_name);
        editTextArrayListName.add(editText_adc_0_ch_7_name);
        editText_adc_0_ch_8_name = root.findViewById(R.id.editText_adc_0_ch_8_name);
        editTextArrayListName.add(editText_adc_0_ch_8_name);
        editText_adc_0_ch_9_name = root.findViewById(R.id.editText_adc_0_ch_9_name);
        editTextArrayListName.add(editText_adc_0_ch_9_name);
        editText_adc_0_ch_10_name = root.findViewById(R.id.editText_adc_0_ch_10_name);
        editTextArrayListName.add(editText_adc_0_ch_10_name);
        editText_adc_0_ch_11_name = root.findViewById(R.id.editText_adc_0_ch_11_name);
        editTextArrayListName.add(editText_adc_0_ch_11_name);
        editText_adc_0_ch_12_name = root.findViewById(R.id.editText_adc_0_ch_12_name);
        editTextArrayListName.add(editText_adc_0_ch_12_name);
        editText_adc_0_ch_13_name = root.findViewById(R.id.editText_adc_0_ch_13_name);
        editTextArrayListName.add(editText_adc_0_ch_13_name);
        editText_adc_0_ch_14_name = root.findViewById(R.id.editText_adc_0_ch_14_name);
        editTextArrayListName.add(editText_adc_0_ch_14_name);
        editText_adc_0_ch_15_name = root.findViewById(R.id.editText_adc_0_ch_15_name);
        editTextArrayListName.add(editText_adc_0_ch_15_name);

        int i = 0;
        for (EditText editText: editTextArrayListName) {
            editText.setText(spaceSetting.getAdcArrayList().get(i).getName());
            i = i + 1;
        }

        editText_adc_0_ch_0_name.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if(event.getAction() == KeyEvent.ACTION_DOWN && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    String text = editText_adc_0_ch_0_name.getText().toString();
                    if (!text.equals("")) {
                        spaceSetting.setSharedPreferences("adc_0_0_name", text);
                        spaceSetting.getAdcArrayList().get(0).setName(text);
                    }
                }
                return true;
            }
        });

        editText_adc_0_ch_1_name.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if(event.getAction() == KeyEvent.ACTION_DOWN && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    String text = editText_adc_0_ch_1_name.getText().toString();
                    if (!text.equals("")) {
                        spaceSetting.setSharedPreferences("adc_0_1_name", text);
                        spaceSetting.getAdcArrayList().get(1).setName(text);
                    }
                }
                return true;
            }
        });

        editText_adc_0_ch_2_name.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if(event.getAction() == KeyEvent.ACTION_DOWN && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    String text = editText_adc_0_ch_2_name.getText().toString();
                    if (!text.equals("")) {
                        spaceSetting.setSharedPreferences("adc_0_2_name", text);
                        spaceSetting.getAdcArrayList().get(2).setName(text);
                    }
                }
                return true;
            }
        });

        editText_adc_0_ch_3_name.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if(event.getAction() == KeyEvent.ACTION_DOWN && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    String text = editText_adc_0_ch_3_name.getText().toString();
                    if (!text.equals("")) {
                        spaceSetting.setSharedPreferences("adc_0_3_name", text);
                        spaceSetting.getAdcArrayList().get(3).setName(text);
                    }
                }
                return true;
            }
        });

        editText_adc_0_ch_4_name.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if(event.getAction() == KeyEvent.ACTION_DOWN && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    String text = editText_adc_0_ch_4_name.getText().toString();
                    if (!text.equals("")) {
                        spaceSetting.setSharedPreferences("adc_0_4_name", text);
                        spaceSetting.getAdcArrayList().get(4).setName(text);
                    }
                }
                return true;
            }
        });

        editText_adc_0_ch_5_name.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if(event.getAction() == KeyEvent.ACTION_DOWN && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    String text = editText_adc_0_ch_5_name.getText().toString();
                    if (!text.equals("")) {
                        spaceSetting.setSharedPreferences("adc_0_5_name", text);
                        spaceSetting.getAdcArrayList().get(5).setName(text);
                    }
                }
                return true;
            }
        });

        editText_adc_0_ch_6_name.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if(event.getAction() == KeyEvent.ACTION_DOWN && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    String text = editText_adc_0_ch_6_name.getText().toString();
                    if (!text.equals("")) {
                        spaceSetting.setSharedPreferences("adc_0_6_name", text);
                        spaceSetting.getAdcArrayList().get(6).setName(text);
                    }
                }
                return true;
            }
        });

        editText_adc_0_ch_7_name.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if(event.getAction() == KeyEvent.ACTION_DOWN && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    String text = editText_adc_0_ch_7_name.getText().toString();
                    if (!text.equals("")) {
                        spaceSetting.setSharedPreferences("adc_0_7_name", text);
                        spaceSetting.getAdcArrayList().get(7).setName(text);
                    }
                }
                return true;
            }
        });

        editText_adc_0_ch_8_name.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if(event.getAction() == KeyEvent.ACTION_DOWN && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    String text = editText_adc_0_ch_8_name.getText().toString();
                    if (!text.equals("")) {
                        spaceSetting.setSharedPreferences("adc_0_8_name", text);
                        spaceSetting.getAdcArrayList().get(8).setName(text);
                    }
                }
                return true;
            }
        });

        editText_adc_0_ch_9_name.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if(event.getAction() == KeyEvent.ACTION_DOWN && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    String text = editText_adc_0_ch_9_name.getText().toString();
                    if (!text.equals("")) {
                        spaceSetting.setSharedPreferences("adc_0_9_name", text);
                        spaceSetting.getAdcArrayList().get(9).setName(text);
                    }
                }
                return true;
            }
        });

        editText_adc_0_ch_10_name.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if(event.getAction() == KeyEvent.ACTION_DOWN && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    String text = editText_adc_0_ch_10_name.getText().toString();
                    if (!text.equals("")) {
                        spaceSetting.setSharedPreferences("adc_0_10_name", text);
                        spaceSetting.getAdcArrayList().get(10).setName(text);
                    }
                }
                return true;
            }
        });

        editText_adc_0_ch_11_name.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if(event.getAction() == KeyEvent.ACTION_DOWN && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    String text = editText_adc_0_ch_11_name.getText().toString();
                    if (!text.equals("")) {
                        spaceSetting.setSharedPreferences("adc_0_11_name", text);
                        spaceSetting.getAdcArrayList().get(11).setName(text);
                    }
                }
                return true;
            }
        });

        editText_adc_0_ch_12_name.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if(event.getAction() == KeyEvent.ACTION_DOWN && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    String text = editText_adc_0_ch_12_name.getText().toString();
                    if (!text.equals("")) {
                        spaceSetting.setSharedPreferences("adc_0_12_name", text);
                        spaceSetting.getAdcArrayList().get(12).setName(text);
                    }
                }
                return true;
            }
        });

        editText_adc_0_ch_13_name.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if(event.getAction() == KeyEvent.ACTION_DOWN && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    String text = editText_adc_0_ch_13_name.getText().toString();
                    if (!text.equals("")) {
                        spaceSetting.setSharedPreferences("adc_0_13_name", text);
                        spaceSetting.getAdcArrayList().get(13).setName(text);
                    }
                }
                return true;
            }
        });

        editText_adc_0_ch_14_name.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if(event.getAction() == KeyEvent.ACTION_DOWN && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    String text = editText_adc_0_ch_14_name.getText().toString();
                    if (!text.equals("")) {
                        spaceSetting.setSharedPreferences("adc_0_14_name", text);
                        spaceSetting.getAdcArrayList().get(14).setName(text);
                    }
                }
                return true;
            }
        });

        editText_adc_0_ch_15_name.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if(event.getAction() == KeyEvent.ACTION_DOWN && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    String text = editText_adc_0_ch_15_name.getText().toString();
                    if (!text.equals("")) {
                        spaceSetting.setSharedPreferences("adc_0_15_name", text);
                        spaceSetting.getAdcArrayList().get(15).setName(text);
                    }
                }
                return true;
            }
        });


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
