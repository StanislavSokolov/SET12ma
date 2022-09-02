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

    private ArrayList<Spinner> spinnerArrayListAdc;
    private ArrayList<ArrayAdapter> adapterArrayListAdc;
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

    private ArrayList<EditText> editTextArrayListNameAdc;

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

    private EditText editText_adc_1_ch_0_name;
    private EditText editText_adc_1_ch_1_name;
    private EditText editText_adc_1_ch_2_name;
    private EditText editText_adc_1_ch_3_name;
    private EditText editText_adc_1_ch_4_name;
    private EditText editText_adc_1_ch_5_name;
    private EditText editText_adc_1_ch_6_name;
    private EditText editText_adc_1_ch_7_name;
    private EditText editText_adc_1_ch_8_name;
    private EditText editText_adc_1_ch_9_name;
    private EditText editText_adc_1_ch_10_name;
    private EditText editText_adc_1_ch_11_name;
    private EditText editText_adc_1_ch_12_name;
    private EditText editText_adc_1_ch_13_name;
    private EditText editText_adc_1_ch_14_name;
    private EditText editText_adc_1_ch_15_name;

    private EditText editText_adc_2_ch_0_name;
    private EditText editText_adc_2_ch_1_name;
    private EditText editText_adc_2_ch_2_name;
    private EditText editText_adc_2_ch_3_name;
    private EditText editText_adc_2_ch_4_name;
    private EditText editText_adc_2_ch_5_name;
    private EditText editText_adc_2_ch_6_name;
    private EditText editText_adc_2_ch_7_name;
    private EditText editText_adc_2_ch_8_name;
    private EditText editText_adc_2_ch_9_name;
    private EditText editText_adc_2_ch_10_name;
    private EditText editText_adc_2_ch_11_name;
    private EditText editText_adc_2_ch_12_name;
    private EditText editText_adc_2_ch_13_name;
    private EditText editText_adc_2_ch_14_name;
    private EditText editText_adc_2_ch_15_name;

    private ArrayList<EditText> editTextArrayListRegisterAdc;

    private EditText editText_adc_0_ch_0_register;
    private EditText editText_adc_0_ch_1_register;
    private EditText editText_adc_0_ch_2_register;
    private EditText editText_adc_0_ch_3_register;
    private EditText editText_adc_0_ch_4_register;
    private EditText editText_adc_0_ch_5_register;
    private EditText editText_adc_0_ch_6_register;
    private EditText editText_adc_0_ch_7_register;
    private EditText editText_adc_0_ch_8_register;
    private EditText editText_adc_0_ch_9_register;
    private EditText editText_adc_0_ch_10_register;
    private EditText editText_adc_0_ch_11_register;
    private EditText editText_adc_0_ch_12_register;
    private EditText editText_adc_0_ch_13_register;
    private EditText editText_adc_0_ch_14_register;
    private EditText editText_adc_0_ch_15_register;

    private EditText editText_adc_1_ch_0_register;
    private EditText editText_adc_1_ch_1_register;
    private EditText editText_adc_1_ch_2_register;
    private EditText editText_adc_1_ch_3_register;
    private EditText editText_adc_1_ch_4_register;
    private EditText editText_adc_1_ch_5_register;
    private EditText editText_adc_1_ch_6_register;
    private EditText editText_adc_1_ch_7_register;
    private EditText editText_adc_1_ch_8_register;
    private EditText editText_adc_1_ch_9_register;
    private EditText editText_adc_1_ch_10_register;
    private EditText editText_adc_1_ch_11_register;
    private EditText editText_adc_1_ch_12_register;
    private EditText editText_adc_1_ch_13_register;
    private EditText editText_adc_1_ch_14_register;
    private EditText editText_adc_1_ch_15_register;

    private EditText editText_adc_2_ch_0_register;
    private EditText editText_adc_2_ch_1_register;
    private EditText editText_adc_2_ch_2_register;
    private EditText editText_adc_2_ch_3_register;
    private EditText editText_adc_2_ch_4_register;
    private EditText editText_adc_2_ch_5_register;
    private EditText editText_adc_2_ch_6_register;
    private EditText editText_adc_2_ch_7_register;
    private EditText editText_adc_2_ch_8_register;
    private EditText editText_adc_2_ch_9_register;
    private EditText editText_adc_2_ch_10_register;
    private EditText editText_adc_2_ch_11_register;
    private EditText editText_adc_2_ch_12_register;
    private EditText editText_adc_2_ch_13_register;
    private EditText editText_adc_2_ch_14_register;
    private EditText editText_adc_2_ch_15_register;

    private ArrayList<EditText> editTextArrayListPlusAdc;

    private EditText editText_adc_0_ch_0_plus;
    private EditText editText_adc_0_ch_1_plus;
    private EditText editText_adc_0_ch_2_plus;
    private EditText editText_adc_0_ch_3_plus;
    private EditText editText_adc_0_ch_4_plus;
    private EditText editText_adc_0_ch_5_plus;
    private EditText editText_adc_0_ch_6_plus;
    private EditText editText_adc_0_ch_7_plus;
    private EditText editText_adc_0_ch_8_plus;
    private EditText editText_adc_0_ch_9_plus;
    private EditText editText_adc_0_ch_10_plus;
    private EditText editText_adc_0_ch_11_plus;
    private EditText editText_adc_0_ch_12_plus;
    private EditText editText_adc_0_ch_13_plus;
    private EditText editText_adc_0_ch_14_plus;
    private EditText editText_adc_0_ch_15_plus;

    private EditText editText_adc_1_ch_0_plus;
    private EditText editText_adc_1_ch_1_plus;
    private EditText editText_adc_1_ch_2_plus;
    private EditText editText_adc_1_ch_3_plus;
    private EditText editText_adc_1_ch_4_plus;
    private EditText editText_adc_1_ch_5_plus;
    private EditText editText_adc_1_ch_6_plus;
    private EditText editText_adc_1_ch_7_plus;
    private EditText editText_adc_1_ch_8_plus;
    private EditText editText_adc_1_ch_9_plus;
    private EditText editText_adc_1_ch_10_plus;
    private EditText editText_adc_1_ch_11_plus;
    private EditText editText_adc_1_ch_12_plus;
    private EditText editText_adc_1_ch_13_plus;
    private EditText editText_adc_1_ch_14_plus;
    private EditText editText_adc_1_ch_15_plus;

    private EditText editText_adc_2_ch_0_plus;
    private EditText editText_adc_2_ch_1_plus;
    private EditText editText_adc_2_ch_2_plus;
    private EditText editText_adc_2_ch_3_plus;
    private EditText editText_adc_2_ch_4_plus;
    private EditText editText_adc_2_ch_5_plus;
    private EditText editText_adc_2_ch_6_plus;
    private EditText editText_adc_2_ch_7_plus;
    private EditText editText_adc_2_ch_8_plus;
    private EditText editText_adc_2_ch_9_plus;
    private EditText editText_adc_2_ch_10_plus;
    private EditText editText_adc_2_ch_11_plus;
    private EditText editText_adc_2_ch_12_plus;
    private EditText editText_adc_2_ch_13_plus;
    private EditText editText_adc_2_ch_14_plus;
    private EditText editText_adc_2_ch_15_plus;

    private ArrayList<EditText> editTextArrayListMinusAdc;

    private EditText editText_adc_0_ch_0_minus;
    private EditText editText_adc_0_ch_1_minus;
    private EditText editText_adc_0_ch_2_minus;
    private EditText editText_adc_0_ch_3_minus;
    private EditText editText_adc_0_ch_4_minus;
    private EditText editText_adc_0_ch_5_minus;
    private EditText editText_adc_0_ch_6_minus;
    private EditText editText_adc_0_ch_7_minus;
    private EditText editText_adc_0_ch_8_minus;
    private EditText editText_adc_0_ch_9_minus;
    private EditText editText_adc_0_ch_10_minus;
    private EditText editText_adc_0_ch_11_minus;
    private EditText editText_adc_0_ch_12_minus;
    private EditText editText_adc_0_ch_13_minus;
    private EditText editText_adc_0_ch_14_minus;
    private EditText editText_adc_0_ch_15_minus;

    private EditText editText_adc_1_ch_0_minus;
    private EditText editText_adc_1_ch_1_minus;
    private EditText editText_adc_1_ch_2_minus;
    private EditText editText_adc_1_ch_3_minus;
    private EditText editText_adc_1_ch_4_minus;
    private EditText editText_adc_1_ch_5_minus;
    private EditText editText_adc_1_ch_6_minus;
    private EditText editText_adc_1_ch_7_minus;
    private EditText editText_adc_1_ch_8_minus;
    private EditText editText_adc_1_ch_9_minus;
    private EditText editText_adc_1_ch_10_minus;
    private EditText editText_adc_1_ch_11_minus;
    private EditText editText_adc_1_ch_12_minus;
    private EditText editText_adc_1_ch_13_minus;
    private EditText editText_adc_1_ch_14_minus;
    private EditText editText_adc_1_ch_15_minus;

    private EditText editText_adc_2_ch_0_minus;
    private EditText editText_adc_2_ch_1_minus;
    private EditText editText_adc_2_ch_2_minus;
    private EditText editText_adc_2_ch_3_minus;
    private EditText editText_adc_2_ch_4_minus;
    private EditText editText_adc_2_ch_5_minus;
    private EditText editText_adc_2_ch_6_minus;
    private EditText editText_adc_2_ch_7_minus;
    private EditText editText_adc_2_ch_8_minus;
    private EditText editText_adc_2_ch_9_minus;
    private EditText editText_adc_2_ch_10_minus;
    private EditText editText_adc_2_ch_11_minus;
    private EditText editText_adc_2_ch_12_minus;
    private EditText editText_adc_2_ch_13_minus;
    private EditText editText_adc_2_ch_14_minus;
    private EditText editText_adc_2_ch_15_minus;

    private ArrayList<Switch> switchArrayListEnableAdc;

    private Switch switch_acd_0_ch_0_enable;
    private Switch switch_acd_0_ch_1_enable;
    private Switch switch_acd_0_ch_2_enable;
    private Switch switch_acd_0_ch_3_enable;
    private Switch switch_acd_0_ch_4_enable;
    private Switch switch_acd_0_ch_5_enable;
    private Switch switch_acd_0_ch_6_enable;
    private Switch switch_acd_0_ch_7_enable;
    private Switch switch_acd_0_ch_8_enable;
    private Switch switch_acd_0_ch_9_enable;
    private Switch switch_acd_0_ch_10_enable;
    private Switch switch_acd_0_ch_11_enable;
    private Switch switch_acd_0_ch_12_enable;
    private Switch switch_acd_0_ch_13_enable;
    private Switch switch_acd_0_ch_14_enable;
    private Switch switch_acd_0_ch_15_enable;

    private Switch switch_acd_1_ch_0_enable;
    private Switch switch_acd_1_ch_1_enable;
    private Switch switch_acd_1_ch_2_enable;
    private Switch switch_acd_1_ch_3_enable;
    private Switch switch_acd_1_ch_4_enable;
    private Switch switch_acd_1_ch_5_enable;
    private Switch switch_acd_1_ch_6_enable;
    private Switch switch_acd_1_ch_7_enable;
    private Switch switch_acd_1_ch_8_enable;
    private Switch switch_acd_1_ch_9_enable;
    private Switch switch_acd_1_ch_10_enable;
    private Switch switch_acd_1_ch_11_enable;
    private Switch switch_acd_1_ch_12_enable;
    private Switch switch_acd_1_ch_13_enable;
    private Switch switch_acd_1_ch_14_enable;
    private Switch switch_acd_1_ch_15_enable;

    private Switch switch_acd_2_ch_0_enable;
    private Switch switch_acd_2_ch_1_enable;
    private Switch switch_acd_2_ch_2_enable;
    private Switch switch_acd_2_ch_3_enable;
    private Switch switch_acd_2_ch_4_enable;
    private Switch switch_acd_2_ch_5_enable;
    private Switch switch_acd_2_ch_6_enable;
    private Switch switch_acd_2_ch_7_enable;
    private Switch switch_acd_2_ch_8_enable;
    private Switch switch_acd_2_ch_9_enable;
    private Switch switch_acd_2_ch_10_enable;
    private Switch switch_acd_2_ch_11_enable;
    private Switch switch_acd_2_ch_12_enable;
    private Switch switch_acd_2_ch_13_enable;
    private Switch switch_acd_2_ch_14_enable;
    private Switch switch_acd_2_ch_15_enable;


////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private ArrayList<EditText> editTextArrayListNameIn;

    private EditText editText_in_0_ch_0_name;
    private EditText editText_in_0_ch_1_name;
    private EditText editText_in_0_ch_2_name;
    private EditText editText_in_0_ch_3_name;
    private EditText editText_in_0_ch_4_name;
    private EditText editText_in_0_ch_5_name;
    private EditText editText_in_0_ch_6_name;
    private EditText editText_in_0_ch_7_name;
    private EditText editText_in_0_ch_8_name;
    private EditText editText_in_0_ch_9_name;
    private EditText editText_in_0_ch_10_name;
    private EditText editText_in_0_ch_11_name;
    private EditText editText_in_0_ch_12_name;
    private EditText editText_in_0_ch_13_name;
    private EditText editText_in_0_ch_14_name;
    private EditText editText_in_0_ch_15_name;

    private EditText editText_in_1_ch_0_name;
    private EditText editText_in_1_ch_1_name;
    private EditText editText_in_1_ch_2_name;
    private EditText editText_in_1_ch_3_name;
    private EditText editText_in_1_ch_4_name;
    private EditText editText_in_1_ch_5_name;
    private EditText editText_in_1_ch_6_name;
    private EditText editText_in_1_ch_7_name;
    private EditText editText_in_1_ch_8_name;
    private EditText editText_in_1_ch_9_name;
    private EditText editText_in_1_ch_10_name;
    private EditText editText_in_1_ch_11_name;
    private EditText editText_in_1_ch_12_name;
    private EditText editText_in_1_ch_13_name;
    private EditText editText_in_1_ch_14_name;
    private EditText editText_in_1_ch_15_name;

    private EditText editText_in_2_ch_0_name;
    private EditText editText_in_2_ch_1_name;
    private EditText editText_in_2_ch_2_name;
    private EditText editText_in_2_ch_3_name;
    private EditText editText_in_2_ch_4_name;
    private EditText editText_in_2_ch_5_name;
    private EditText editText_in_2_ch_6_name;
    private EditText editText_in_2_ch_7_name;
    private EditText editText_in_2_ch_8_name;
    private EditText editText_in_2_ch_9_name;
    private EditText editText_in_2_ch_10_name;
    private EditText editText_in_2_ch_11_name;
    private EditText editText_in_2_ch_12_name;
    private EditText editText_in_2_ch_13_name;
    private EditText editText_in_2_ch_14_name;
    private EditText editText_in_2_ch_15_name;

    private ArrayList<EditText> editTextArrayListRegisterIn;

    private EditText editText_in_0_ch_0_register;
    private EditText editText_in_0_ch_1_register;
    private EditText editText_in_0_ch_2_register;
    private EditText editText_in_0_ch_3_register;
    private EditText editText_in_0_ch_4_register;
    private EditText editText_in_0_ch_5_register;
    private EditText editText_in_0_ch_6_register;
    private EditText editText_in_0_ch_7_register;
    private EditText editText_in_0_ch_8_register;
    private EditText editText_in_0_ch_9_register;
    private EditText editText_in_0_ch_10_register;
    private EditText editText_in_0_ch_11_register;
    private EditText editText_in_0_ch_12_register;
    private EditText editText_in_0_ch_13_register;
    private EditText editText_in_0_ch_14_register;
    private EditText editText_in_0_ch_15_register;

    private EditText editText_in_1_ch_0_register;
    private EditText editText_in_1_ch_1_register;
    private EditText editText_in_1_ch_2_register;
    private EditText editText_in_1_ch_3_register;
    private EditText editText_in_1_ch_4_register;
    private EditText editText_in_1_ch_5_register;
    private EditText editText_in_1_ch_6_register;
    private EditText editText_in_1_ch_7_register;
    private EditText editText_in_1_ch_8_register;
    private EditText editText_in_1_ch_9_register;
    private EditText editText_in_1_ch_10_register;
    private EditText editText_in_1_ch_11_register;
    private EditText editText_in_1_ch_12_register;
    private EditText editText_in_1_ch_13_register;
    private EditText editText_in_1_ch_14_register;
    private EditText editText_in_1_ch_15_register;

    private EditText editText_in_2_ch_0_register;
    private EditText editText_in_2_ch_1_register;
    private EditText editText_in_2_ch_2_register;
    private EditText editText_in_2_ch_3_register;
    private EditText editText_in_2_ch_4_register;
    private EditText editText_in_2_ch_5_register;
    private EditText editText_in_2_ch_6_register;
    private EditText editText_in_2_ch_7_register;
    private EditText editText_in_2_ch_8_register;
    private EditText editText_in_2_ch_9_register;
    private EditText editText_in_2_ch_10_register;
    private EditText editText_in_2_ch_11_register;
    private EditText editText_in_2_ch_12_register;
    private EditText editText_in_2_ch_13_register;
    private EditText editText_in_2_ch_14_register;
    private EditText editText_in_2_ch_15_register;

    private ArrayList<Switch> switchArrayListEnableIn;

    private Switch switch_acd_in_ch_0_enable;
    private Switch switch_acd_in_ch_1_enable;
    private Switch switch_acd_in_ch_2_enable;
    private Switch switch_acd_in_ch_3_enable;
    private Switch switch_acd_in_ch_4_enable;
    private Switch switch_acd_in_ch_5_enable;
    private Switch switch_acd_in_ch_6_enable;
    private Switch switch_acd_in_ch_7_enable;
    private Switch switch_acd_in_ch_8_enable;
    private Switch switch_acd_in_ch_9_enable;
    private Switch switch_acd_in_ch_10_enable;
    private Switch switch_acd_in_ch_11_enable;
    private Switch switch_acd_in_ch_12_enable;
    private Switch switch_acd_in_ch_13_enable;
    private Switch switch_acd_in_ch_14_enable;
    private Switch switch_acd_in_ch_15_enable;

    private Switch switch_in_1_ch_0_enable;
    private Switch switch_in_1_ch_1_enable;
    private Switch switch_in_1_ch_2_enable;
    private Switch switch_in_1_ch_3_enable;
    private Switch switch_in_1_ch_4_enable;
    private Switch switch_in_1_ch_5_enable;
    private Switch switch_in_1_ch_6_enable;
    private Switch switch_in_1_ch_7_enable;
    private Switch switch_in_1_ch_8_enable;
    private Switch switch_in_1_ch_9_enable;
    private Switch switch_in_1_ch_10_enable;
    private Switch switch_in_1_ch_11_enable;
    private Switch switch_in_1_ch_12_enable;
    private Switch switch_in_1_ch_13_enable;
    private Switch switch_in_1_ch_14_enable;
    private Switch switch_in_1_ch_15_enable;

    private Switch switch_in_2_ch_0_enable;
    private Switch switch_in_2_ch_1_enable;
    private Switch switch_in_2_ch_2_enable;
    private Switch switch_in_2_ch_3_enable;
    private Switch switch_in_2_ch_4_enable;
    private Switch switch_in_2_ch_5_enable;
    private Switch switch_in_2_ch_6_enable;
    private Switch switch_in_2_ch_7_enable;
    private Switch switch_in_2_ch_8_enable;
    private Switch switch_in_2_ch_9_enable;
    private Switch switch_in_2_ch_10_enable;
    private Switch switch_in_2_ch_11_enable;
    private Switch switch_in_2_ch_12_enable;
    private Switch switch_in_2_ch_13_enable;
    private Switch switch_in_2_ch_14_enable;
    private Switch switch_in_2_ch_15_enable;

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


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
        for (Spinner spinner: spinnerArrayListAdc) {
            spinner.setSelection(spaceSetting.getAdcArrayList().get(i).getColor());
            i= i + 1;
        }
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_setting, container, false);


        spinnerArrayListAdc = new ArrayList<>();
        adapterArrayListAdc = new ArrayList<>();

        spinner_adc_0_ch_0_color = root.findViewById(R.id.spinner_adc_0_ch_0_color);
        adapter_color_adc_0_ch_0 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item);
        adapter_color_adc_0_ch_0.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterArrayListAdc.add(adapter_color_adc_0_ch_0);
        spinnerArrayListAdc.add(spinner_adc_0_ch_0_color);

        spinner_adc_0_ch_1_color = root.findViewById(R.id.spinner_adc_0_ch_1_color);
        adapter_color_adc_0_ch_1 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item);
        adapter_color_adc_0_ch_1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterArrayListAdc.add(adapter_color_adc_0_ch_1);
        spinnerArrayListAdc.add(spinner_adc_0_ch_1_color);

        spinner_adc_0_ch_2_color = root.findViewById(R.id.spinner_adc_0_ch_2_color);
        adapter_color_adc_0_ch_2 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item);
        adapter_color_adc_0_ch_2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterArrayListAdc.add(adapter_color_adc_0_ch_2);
        spinnerArrayListAdc.add(spinner_adc_0_ch_2_color);

        spinner_adc_0_ch_3_color = root.findViewById(R.id.spinner_adc_0_ch_3_color);
        adapter_color_adc_0_ch_3 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item);
        adapter_color_adc_0_ch_3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterArrayListAdc.add(adapter_color_adc_0_ch_3);
        spinnerArrayListAdc.add(spinner_adc_0_ch_3_color);

        spinner_adc_0_ch_4_color = root.findViewById(R.id.spinner_adc_0_ch_4_color);
        adapter_color_adc_0_ch_4 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item);
        adapter_color_adc_0_ch_4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterArrayListAdc.add(adapter_color_adc_0_ch_4);
        spinnerArrayListAdc.add(spinner_adc_0_ch_4_color);

        spinner_adc_0_ch_5_color = root.findViewById(R.id.spinner_adc_0_ch_5_color);
        adapter_color_adc_0_ch_5 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item);
        adapter_color_adc_0_ch_5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterArrayListAdc.add(adapter_color_adc_0_ch_5);
        spinnerArrayListAdc.add(spinner_adc_0_ch_5_color);

        spinner_adc_0_ch_6_color = root.findViewById(R.id.spinner_adc_0_ch_6_color);
        adapter_color_adc_0_ch_6 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item);
        adapter_color_adc_0_ch_6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterArrayListAdc.add(adapter_color_adc_0_ch_6);
        spinnerArrayListAdc.add(spinner_adc_0_ch_6_color);

        spinner_adc_0_ch_7_color = root.findViewById(R.id.spinner_adc_0_ch_7_color);
        adapter_color_adc_0_ch_7 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item);
        adapter_color_adc_0_ch_7.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterArrayListAdc.add(adapter_color_adc_0_ch_7);
        spinnerArrayListAdc.add(spinner_adc_0_ch_7_color);

        spinner_adc_0_ch_8_color = root.findViewById(R.id.spinner_adc_0_ch_8_color);
        adapter_color_adc_0_ch_8 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item);
        adapter_color_adc_0_ch_8.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterArrayListAdc.add(adapter_color_adc_0_ch_8);
        spinnerArrayListAdc.add(spinner_adc_0_ch_8_color);

        spinner_adc_0_ch_9_color = root.findViewById(R.id.spinner_adc_0_ch_9_color);
        adapter_color_adc_0_ch_9 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item);
        adapter_color_adc_0_ch_9.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterArrayListAdc.add(adapter_color_adc_0_ch_9);
        spinnerArrayListAdc.add(spinner_adc_0_ch_9_color);

        spinner_adc_0_ch_10_color = root.findViewById(R.id.spinner_adc_0_ch_10_color);
        adapter_color_adc_0_ch_10 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item);
        adapter_color_adc_0_ch_10.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterArrayListAdc.add(adapter_color_adc_0_ch_10);
        spinnerArrayListAdc.add(spinner_adc_0_ch_10_color);

        spinner_adc_0_ch_11_color = root.findViewById(R.id.spinner_adc_0_ch_11_color);
        adapter_color_adc_0_ch_11 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item);
        adapter_color_adc_0_ch_11.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterArrayListAdc.add(adapter_color_adc_0_ch_11);
        spinnerArrayListAdc.add(spinner_adc_0_ch_11_color);

        spinner_adc_0_ch_12_color = root.findViewById(R.id.spinner_adc_0_ch_12_color);
        adapter_color_adc_0_ch_12 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item);
        adapter_color_adc_0_ch_12.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterArrayListAdc.add(adapter_color_adc_0_ch_12);
        spinnerArrayListAdc.add(spinner_adc_0_ch_12_color);

        spinner_adc_0_ch_13_color = root.findViewById(R.id.spinner_adc_0_ch_13_color);
        adapter_color_adc_0_ch_13 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item);
        adapter_color_adc_0_ch_13.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterArrayListAdc.add(adapter_color_adc_0_ch_13);
        spinnerArrayListAdc.add(spinner_adc_0_ch_13_color);

        spinner_adc_0_ch_14_color = root.findViewById(R.id.spinner_adc_0_ch_14_color);
        adapter_color_adc_0_ch_14 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item);
        adapter_color_adc_0_ch_14.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterArrayListAdc.add(adapter_color_adc_0_ch_14);
        spinnerArrayListAdc.add(spinner_adc_0_ch_14_color);

        spinner_adc_0_ch_15_color = root.findViewById(R.id.spinner_adc_0_ch_15_color);
        adapter_color_adc_0_ch_15 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item);
        adapter_color_adc_0_ch_15.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterArrayListAdc.add(adapter_color_adc_0_ch_15);
        spinnerArrayListAdc.add(spinner_adc_0_ch_15_color);

        for (ArrayAdapter arrayAdapter: adapterArrayListAdc) {
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

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        editTextArrayListNameAdc = new ArrayList<>();

        editText_adc_0_ch_0_name = root.findViewById(R.id.editText_adc_0_ch_0_name);
        editTextArrayListNameAdc.add(editText_adc_0_ch_0_name);
        editText_adc_0_ch_1_name = root.findViewById(R.id.editText_adc_0_ch_1_name);
        editTextArrayListNameAdc.add(editText_adc_0_ch_1_name);
        editText_adc_0_ch_2_name = root.findViewById(R.id.editText_adc_0_ch_2_name);
        editTextArrayListNameAdc.add(editText_adc_0_ch_2_name);
        editText_adc_0_ch_3_name = root.findViewById(R.id.editText_adc_0_ch_3_name);
        editTextArrayListNameAdc.add(editText_adc_0_ch_3_name);
        editText_adc_0_ch_4_name = root.findViewById(R.id.editText_adc_0_ch_4_name);
        editTextArrayListNameAdc.add(editText_adc_0_ch_4_name);
        editText_adc_0_ch_5_name = root.findViewById(R.id.editText_adc_0_ch_5_name);
        editTextArrayListNameAdc.add(editText_adc_0_ch_5_name);
        editText_adc_0_ch_6_name = root.findViewById(R.id.editText_adc_0_ch_6_name);
        editTextArrayListNameAdc.add(editText_adc_0_ch_6_name);
        editText_adc_0_ch_7_name = root.findViewById(R.id.editText_adc_0_ch_7_name);
        editTextArrayListNameAdc.add(editText_adc_0_ch_7_name);
        editText_adc_0_ch_8_name = root.findViewById(R.id.editText_adc_0_ch_8_name);
        editTextArrayListNameAdc.add(editText_adc_0_ch_8_name);
        editText_adc_0_ch_9_name = root.findViewById(R.id.editText_adc_0_ch_9_name);
        editTextArrayListNameAdc.add(editText_adc_0_ch_9_name);
        editText_adc_0_ch_10_name = root.findViewById(R.id.editText_adc_0_ch_10_name);
        editTextArrayListNameAdc.add(editText_adc_0_ch_10_name);
        editText_adc_0_ch_11_name = root.findViewById(R.id.editText_adc_0_ch_11_name);
        editTextArrayListNameAdc.add(editText_adc_0_ch_11_name);
        editText_adc_0_ch_12_name = root.findViewById(R.id.editText_adc_0_ch_12_name);
        editTextArrayListNameAdc.add(editText_adc_0_ch_12_name);
        editText_adc_0_ch_13_name = root.findViewById(R.id.editText_adc_0_ch_13_name);
        editTextArrayListNameAdc.add(editText_adc_0_ch_13_name);
        editText_adc_0_ch_14_name = root.findViewById(R.id.editText_adc_0_ch_14_name);
        editTextArrayListNameAdc.add(editText_adc_0_ch_14_name);
        editText_adc_0_ch_15_name = root.findViewById(R.id.editText_adc_0_ch_15_name);
        editTextArrayListNameAdc.add(editText_adc_0_ch_15_name);

        editText_adc_1_ch_0_name = root.findViewById(R.id.editText_adc_1_ch_0_name);
        editTextArrayListNameAdc.add(editText_adc_1_ch_0_name);
        editText_adc_1_ch_1_name = root.findViewById(R.id.editText_adc_1_ch_1_name);
        editTextArrayListNameAdc.add(editText_adc_1_ch_1_name);
        editText_adc_1_ch_2_name = root.findViewById(R.id.editText_adc_1_ch_2_name);
        editTextArrayListNameAdc.add(editText_adc_1_ch_2_name);
        editText_adc_1_ch_3_name = root.findViewById(R.id.editText_adc_1_ch_3_name);
        editTextArrayListNameAdc.add(editText_adc_1_ch_3_name);
        editText_adc_1_ch_4_name = root.findViewById(R.id.editText_adc_1_ch_4_name);
        editTextArrayListNameAdc.add(editText_adc_1_ch_4_name);
        editText_adc_1_ch_5_name = root.findViewById(R.id.editText_adc_1_ch_5_name);
        editTextArrayListNameAdc.add(editText_adc_1_ch_5_name);
        editText_adc_1_ch_6_name = root.findViewById(R.id.editText_adc_1_ch_6_name);
        editTextArrayListNameAdc.add(editText_adc_1_ch_6_name);
        editText_adc_1_ch_7_name = root.findViewById(R.id.editText_adc_1_ch_7_name);
        editTextArrayListNameAdc.add(editText_adc_1_ch_7_name);
        editText_adc_1_ch_8_name = root.findViewById(R.id.editText_adc_1_ch_8_name);
        editTextArrayListNameAdc.add(editText_adc_1_ch_8_name);
        editText_adc_1_ch_9_name = root.findViewById(R.id.editText_adc_1_ch_9_name);
        editTextArrayListNameAdc.add(editText_adc_1_ch_9_name);
        editText_adc_1_ch_10_name = root.findViewById(R.id.editText_adc_1_ch_10_name);
        editTextArrayListNameAdc.add(editText_adc_1_ch_10_name);
        editText_adc_1_ch_11_name = root.findViewById(R.id.editText_adc_1_ch_11_name);
        editTextArrayListNameAdc.add(editText_adc_1_ch_11_name);
        editText_adc_1_ch_12_name = root.findViewById(R.id.editText_adc_1_ch_12_name);
        editTextArrayListNameAdc.add(editText_adc_1_ch_12_name);
        editText_adc_1_ch_13_name = root.findViewById(R.id.editText_adc_1_ch_13_name);
        editTextArrayListNameAdc.add(editText_adc_1_ch_13_name);
        editText_adc_1_ch_14_name = root.findViewById(R.id.editText_adc_1_ch_14_name);
        editTextArrayListNameAdc.add(editText_adc_1_ch_14_name);
        editText_adc_1_ch_15_name = root.findViewById(R.id.editText_adc_1_ch_15_name);
        editTextArrayListNameAdc.add(editText_adc_1_ch_15_name);

        editText_adc_2_ch_0_name = root.findViewById(R.id.editText_adc_2_ch_0_name);
        editTextArrayListNameAdc.add(editText_adc_2_ch_0_name);
        editText_adc_2_ch_1_name = root.findViewById(R.id.editText_adc_2_ch_1_name);
        editTextArrayListNameAdc.add(editText_adc_2_ch_1_name);
        editText_adc_2_ch_2_name = root.findViewById(R.id.editText_adc_2_ch_2_name);
        editTextArrayListNameAdc.add(editText_adc_2_ch_2_name);
        editText_adc_2_ch_3_name = root.findViewById(R.id.editText_adc_2_ch_3_name);
        editTextArrayListNameAdc.add(editText_adc_2_ch_3_name);
        editText_adc_2_ch_4_name = root.findViewById(R.id.editText_adc_2_ch_4_name);
        editTextArrayListNameAdc.add(editText_adc_2_ch_4_name);
        editText_adc_2_ch_5_name = root.findViewById(R.id.editText_adc_2_ch_5_name);
        editTextArrayListNameAdc.add(editText_adc_2_ch_5_name);
        editText_adc_2_ch_6_name = root.findViewById(R.id.editText_adc_2_ch_6_name);
        editTextArrayListNameAdc.add(editText_adc_2_ch_6_name);
        editText_adc_2_ch_7_name = root.findViewById(R.id.editText_adc_2_ch_7_name);
        editTextArrayListNameAdc.add(editText_adc_2_ch_7_name);
        editText_adc_2_ch_8_name = root.findViewById(R.id.editText_adc_2_ch_8_name);
        editTextArrayListNameAdc.add(editText_adc_2_ch_8_name);
        editText_adc_2_ch_9_name = root.findViewById(R.id.editText_adc_2_ch_9_name);
        editTextArrayListNameAdc.add(editText_adc_2_ch_9_name);
        editText_adc_2_ch_10_name = root.findViewById(R.id.editText_adc_2_ch_10_name);
        editTextArrayListNameAdc.add(editText_adc_2_ch_10_name);
        editText_adc_2_ch_11_name = root.findViewById(R.id.editText_adc_2_ch_11_name);
        editTextArrayListNameAdc.add(editText_adc_2_ch_11_name);
        editText_adc_2_ch_12_name = root.findViewById(R.id.editText_adc_2_ch_12_name);
        editTextArrayListNameAdc.add(editText_adc_2_ch_12_name);
        editText_adc_2_ch_13_name = root.findViewById(R.id.editText_adc_2_ch_13_name);
        editTextArrayListNameAdc.add(editText_adc_2_ch_13_name);
        editText_adc_2_ch_14_name = root.findViewById(R.id.editText_adc_2_ch_14_name);
        editTextArrayListNameAdc.add(editText_adc_2_ch_14_name);
        editText_adc_2_ch_15_name = root.findViewById(R.id.editText_adc_2_ch_15_name);
        editTextArrayListNameAdc.add(editText_adc_2_ch_15_name);

        int i = 0;
        for (final EditText editText: editTextArrayListNameAdc) {
            editText.setText(String.valueOf(spaceSetting.getAdcArrayList().get(i).getName()));
            final int finalI = i;
            editText.setOnKeyListener(new View.OnKeyListener() {
                @Override
                public boolean onKey(View v, int keyCode, KeyEvent event) {
                    if(event.getAction() == KeyEvent.ACTION_DOWN && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                        String text = editText.getText().toString();
                        if (!text.equals("")) {
                            if (finalI < 16) spaceSetting.setSharedPreferences("adc_0_" + finalI + "_name", text);
                            else if (finalI < 32) spaceSetting.setSharedPreferences("adc_1_" + finalI + "_name", text);
                            else spaceSetting.setSharedPreferences("adc_2_" + finalI + "_name", text);
                            spaceSetting.getAdcArrayList().get(finalI).setName(text);
                        }
                    }
                    return true;
                }
            });
            i = i + 1;
        }

//        editText_adc_0_ch_0_name.setOnKeyListener(new View.OnKeyListener() {
//            @Override
//            public boolean onKey(View v, int keyCode, KeyEvent event) {
//                if(event.getAction() == KeyEvent.ACTION_DOWN && (keyCode == KeyEvent.KEYCODE_ENTER)) {
//                    String text = editText_adc_0_ch_0_name.getText().toString();
//                    if (!text.equals("")) {
//                        spaceSetting.setSharedPreferences("adc_0_0_name", text);
//                        spaceSetting.getAdcArrayList().get(0).setName(text);
//                    }
//                }
//                return true;
//            }
//        });
//
//        editText_adc_0_ch_1_name.setOnKeyListener(new View.OnKeyListener() {
//            @Override
//            public boolean onKey(View v, int keyCode, KeyEvent event) {
//                if(event.getAction() == KeyEvent.ACTION_DOWN && (keyCode == KeyEvent.KEYCODE_ENTER)) {
//                    String text = editText_adc_0_ch_1_name.getText().toString();
//                    if (!text.equals("")) {
//                        spaceSetting.setSharedPreferences("adc_0_1_name", text);
//                        spaceSetting.getAdcArrayList().get(1).setName(text);
//                    }
//                }
//                return true;
//            }
//        });
//
//        editText_adc_0_ch_2_name.setOnKeyListener(new View.OnKeyListener() {
//            @Override
//            public boolean onKey(View v, int keyCode, KeyEvent event) {
//                if(event.getAction() == KeyEvent.ACTION_DOWN && (keyCode == KeyEvent.KEYCODE_ENTER)) {
//                    String text = editText_adc_0_ch_2_name.getText().toString();
//                    if (!text.equals("")) {
//                        spaceSetting.setSharedPreferences("adc_0_2_name", text);
//                        spaceSetting.getAdcArrayList().get(2).setName(text);
//                    }
//                }
//                return true;
//            }
//        });
//
//        editText_adc_0_ch_3_name.setOnKeyListener(new View.OnKeyListener() {
//            @Override
//            public boolean onKey(View v, int keyCode, KeyEvent event) {
//                if(event.getAction() == KeyEvent.ACTION_DOWN && (keyCode == KeyEvent.KEYCODE_ENTER)) {
//                    String text = editText_adc_0_ch_3_name.getText().toString();
//                    if (!text.equals("")) {
//                        spaceSetting.setSharedPreferences("adc_0_3_name", text);
//                        spaceSetting.getAdcArrayList().get(3).setName(text);
//                    }
//                }
//                return true;
//            }
//        });
//
//        editText_adc_0_ch_4_name.setOnKeyListener(new View.OnKeyListener() {
//            @Override
//            public boolean onKey(View v, int keyCode, KeyEvent event) {
//                if(event.getAction() == KeyEvent.ACTION_DOWN && (keyCode == KeyEvent.KEYCODE_ENTER)) {
//                    String text = editText_adc_0_ch_4_name.getText().toString();
//                    if (!text.equals("")) {
//                        spaceSetting.setSharedPreferences("adc_0_4_name", text);
//                        spaceSetting.getAdcArrayList().get(4).setName(text);
//                    }
//                }
//                return true;
//            }
//        });
//
//        editText_adc_0_ch_5_name.setOnKeyListener(new View.OnKeyListener() {
//            @Override
//            public boolean onKey(View v, int keyCode, KeyEvent event) {
//                if(event.getAction() == KeyEvent.ACTION_DOWN && (keyCode == KeyEvent.KEYCODE_ENTER)) {
//                    String text = editText_adc_0_ch_5_name.getText().toString();
//                    if (!text.equals("")) {
//                        spaceSetting.setSharedPreferences("adc_0_5_name", text);
//                        spaceSetting.getAdcArrayList().get(5).setName(text);
//                    }
//                }
//                return true;
//            }
//        });
//
//        editText_adc_0_ch_6_name.setOnKeyListener(new View.OnKeyListener() {
//            @Override
//            public boolean onKey(View v, int keyCode, KeyEvent event) {
//                if(event.getAction() == KeyEvent.ACTION_DOWN && (keyCode == KeyEvent.KEYCODE_ENTER)) {
//                    String text = editText_adc_0_ch_6_name.getText().toString();
//                    if (!text.equals("")) {
//                        spaceSetting.setSharedPreferences("adc_0_6_name", text);
//                        spaceSetting.getAdcArrayList().get(6).setName(text);
//                    }
//                }
//                return true;
//            }
//        });
//
//        editText_adc_0_ch_7_name.setOnKeyListener(new View.OnKeyListener() {
//            @Override
//            public boolean onKey(View v, int keyCode, KeyEvent event) {
//                if(event.getAction() == KeyEvent.ACTION_DOWN && (keyCode == KeyEvent.KEYCODE_ENTER)) {
//                    String text = editText_adc_0_ch_7_name.getText().toString();
//                    if (!text.equals("")) {
//                        spaceSetting.setSharedPreferences("adc_0_7_name", text);
//                        spaceSetting.getAdcArrayList().get(7).setName(text);
//                    }
//                }
//                return true;
//            }
//        });
//
//        editText_adc_0_ch_8_name.setOnKeyListener(new View.OnKeyListener() {
//            @Override
//            public boolean onKey(View v, int keyCode, KeyEvent event) {
//                if(event.getAction() == KeyEvent.ACTION_DOWN && (keyCode == KeyEvent.KEYCODE_ENTER)) {
//                    String text = editText_adc_0_ch_8_name.getText().toString();
//                    if (!text.equals("")) {
//                        spaceSetting.setSharedPreferences("adc_0_8_name", text);
//                        spaceSetting.getAdcArrayList().get(8).setName(text);
//                    }
//                }
//                return true;
//            }
//        });
//
//        editText_adc_0_ch_9_name.setOnKeyListener(new View.OnKeyListener() {
//            @Override
//            public boolean onKey(View v, int keyCode, KeyEvent event) {
//                if(event.getAction() == KeyEvent.ACTION_DOWN && (keyCode == KeyEvent.KEYCODE_ENTER)) {
//                    String text = editText_adc_0_ch_9_name.getText().toString();
//                    if (!text.equals("")) {
//                        spaceSetting.setSharedPreferences("adc_0_9_name", text);
//                        spaceSetting.getAdcArrayList().get(9).setName(text);
//                    }
//                }
//                return true;
//            }
//        });
//
//        editText_adc_0_ch_10_name.setOnKeyListener(new View.OnKeyListener() {
//            @Override
//            public boolean onKey(View v, int keyCode, KeyEvent event) {
//                if(event.getAction() == KeyEvent.ACTION_DOWN && (keyCode == KeyEvent.KEYCODE_ENTER)) {
//                    String text = editText_adc_0_ch_10_name.getText().toString();
//                    if (!text.equals("")) {
//                        spaceSetting.setSharedPreferences("adc_0_10_name", text);
//                        spaceSetting.getAdcArrayList().get(10).setName(text);
//                    }
//                }
//                return true;
//            }
//        });
//
//        editText_adc_0_ch_11_name.setOnKeyListener(new View.OnKeyListener() {
//            @Override
//            public boolean onKey(View v, int keyCode, KeyEvent event) {
//                if(event.getAction() == KeyEvent.ACTION_DOWN && (keyCode == KeyEvent.KEYCODE_ENTER)) {
//                    String text = editText_adc_0_ch_11_name.getText().toString();
//                    if (!text.equals("")) {
//                        spaceSetting.setSharedPreferences("adc_0_11_name", text);
//                        spaceSetting.getAdcArrayList().get(11).setName(text);
//                    }
//                }
//                return true;
//            }
//        });
//
//        editText_adc_0_ch_12_name.setOnKeyListener(new View.OnKeyListener() {
//            @Override
//            public boolean onKey(View v, int keyCode, KeyEvent event) {
//                if(event.getAction() == KeyEvent.ACTION_DOWN && (keyCode == KeyEvent.KEYCODE_ENTER)) {
//                    String text = editText_adc_0_ch_12_name.getText().toString();
//                    if (!text.equals("")) {
//                        spaceSetting.setSharedPreferences("adc_0_12_name", text);
//                        spaceSetting.getAdcArrayList().get(12).setName(text);
//                    }
//                }
//                return true;
//            }
//        });
//
//        editText_adc_0_ch_13_name.setOnKeyListener(new View.OnKeyListener() {
//            @Override
//            public boolean onKey(View v, int keyCode, KeyEvent event) {
//                if(event.getAction() == KeyEvent.ACTION_DOWN && (keyCode == KeyEvent.KEYCODE_ENTER)) {
//                    String text = editText_adc_0_ch_13_name.getText().toString();
//                    if (!text.equals("")) {
//                        spaceSetting.setSharedPreferences("adc_0_13_name", text);
//                        spaceSetting.getAdcArrayList().get(13).setName(text);
//                    }
//                }
//                return true;
//            }
//        });
//
//        editText_adc_0_ch_14_name.setOnKeyListener(new View.OnKeyListener() {
//            @Override
//            public boolean onKey(View v, int keyCode, KeyEvent event) {
//                if(event.getAction() == KeyEvent.ACTION_DOWN && (keyCode == KeyEvent.KEYCODE_ENTER)) {
//                    String text = editText_adc_0_ch_14_name.getText().toString();
//                    if (!text.equals("")) {
//                        spaceSetting.setSharedPreferences("adc_0_14_name", text);
//                        spaceSetting.getAdcArrayList().get(14).setName(text);
//                    }
//                }
//                return true;
//            }
//        });
//
//        editText_adc_0_ch_15_name.setOnKeyListener(new View.OnKeyListener() {
//            @Override
//            public boolean onKey(View v, int keyCode, KeyEvent event) {
//                if(event.getAction() == KeyEvent.ACTION_DOWN && (keyCode == KeyEvent.KEYCODE_ENTER)) {
//                    String text = editText_adc_0_ch_15_name.getText().toString();
//                    if (!text.equals("")) {
//                        spaceSetting.setSharedPreferences("adc_0_15_name", text);
//                        spaceSetting.getAdcArrayList().get(15).setName(text);
//                    }
//                }
//                return true;
//            }
//        });

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        editTextArrayListRegisterAdc = new ArrayList<>();

        editText_adc_0_ch_0_register = root.findViewById(R.id.editText_adc_0_ch_0_register);
        editTextArrayListRegisterAdc.add(editText_adc_0_ch_0_register);
        editText_adc_0_ch_1_register = root.findViewById(R.id.editText_adc_0_ch_1_register);
        editTextArrayListRegisterAdc.add(editText_adc_0_ch_1_register);
        editText_adc_0_ch_2_register = root.findViewById(R.id.editText_adc_0_ch_2_register);
        editTextArrayListRegisterAdc.add(editText_adc_0_ch_2_register);
        editText_adc_0_ch_3_register = root.findViewById(R.id.editText_adc_0_ch_3_register);
        editTextArrayListRegisterAdc.add(editText_adc_0_ch_3_register);
        editText_adc_0_ch_4_register = root.findViewById(R.id.editText_adc_0_ch_4_register);
        editTextArrayListRegisterAdc.add(editText_adc_0_ch_4_register);
        editText_adc_0_ch_5_register = root.findViewById(R.id.editText_adc_0_ch_5_register);
        editTextArrayListRegisterAdc.add(editText_adc_0_ch_5_register);
        editText_adc_0_ch_6_register = root.findViewById(R.id.editText_adc_0_ch_6_register);
        editTextArrayListRegisterAdc.add(editText_adc_0_ch_6_register);
        editText_adc_0_ch_7_register = root.findViewById(R.id.editText_adc_0_ch_7_register);
        editTextArrayListRegisterAdc.add(editText_adc_0_ch_7_register);
        editText_adc_0_ch_8_register = root.findViewById(R.id.editText_adc_0_ch_8_register);
        editTextArrayListRegisterAdc.add(editText_adc_0_ch_8_register);
        editText_adc_0_ch_9_register = root.findViewById(R.id.editText_adc_0_ch_9_register);
        editTextArrayListRegisterAdc.add(editText_adc_0_ch_9_register);
        editText_adc_0_ch_10_register = root.findViewById(R.id.editText_adc_0_ch_10_register);
        editTextArrayListRegisterAdc.add(editText_adc_0_ch_10_register);
        editText_adc_0_ch_11_register = root.findViewById(R.id.editText_adc_0_ch_11_register);
        editTextArrayListRegisterAdc.add(editText_adc_0_ch_11_register);
        editText_adc_0_ch_12_register = root.findViewById(R.id.editText_adc_0_ch_12_register);
        editTextArrayListRegisterAdc.add(editText_adc_0_ch_12_register);
        editText_adc_0_ch_13_register = root.findViewById(R.id.editText_adc_0_ch_13_register);
        editTextArrayListRegisterAdc.add(editText_adc_0_ch_13_register);
        editText_adc_0_ch_14_register = root.findViewById(R.id.editText_adc_0_ch_14_register);
        editTextArrayListRegisterAdc.add(editText_adc_0_ch_14_register);
        editText_adc_0_ch_15_register = root.findViewById(R.id.editText_adc_0_ch_15_register);
        editTextArrayListRegisterAdc.add(editText_adc_0_ch_15_register);

        editText_adc_1_ch_0_register = root.findViewById(R.id.editText_adc_1_ch_0_register);
        editTextArrayListRegisterAdc.add(editText_adc_1_ch_0_register);
        editText_adc_1_ch_1_register = root.findViewById(R.id.editText_adc_1_ch_1_register);
        editTextArrayListRegisterAdc.add(editText_adc_1_ch_1_register);
        editText_adc_1_ch_2_register = root.findViewById(R.id.editText_adc_1_ch_2_register);
        editTextArrayListRegisterAdc.add(editText_adc_1_ch_2_register);
        editText_adc_1_ch_3_register = root.findViewById(R.id.editText_adc_1_ch_3_register);
        editTextArrayListRegisterAdc.add(editText_adc_1_ch_3_register);
        editText_adc_1_ch_4_register = root.findViewById(R.id.editText_adc_1_ch_4_register);
        editTextArrayListRegisterAdc.add(editText_adc_1_ch_4_register);
        editText_adc_1_ch_5_register = root.findViewById(R.id.editText_adc_1_ch_5_register);
        editTextArrayListRegisterAdc.add(editText_adc_1_ch_5_register);
        editText_adc_1_ch_6_register = root.findViewById(R.id.editText_adc_1_ch_6_register);
        editTextArrayListRegisterAdc.add(editText_adc_1_ch_6_register);
        editText_adc_1_ch_7_register = root.findViewById(R.id.editText_adc_1_ch_7_register);
        editTextArrayListRegisterAdc.add(editText_adc_1_ch_7_register);
        editText_adc_1_ch_8_register = root.findViewById(R.id.editText_adc_1_ch_8_register);
        editTextArrayListRegisterAdc.add(editText_adc_1_ch_8_register);
        editText_adc_1_ch_9_register = root.findViewById(R.id.editText_adc_1_ch_9_register);
        editTextArrayListRegisterAdc.add(editText_adc_1_ch_9_register);
        editText_adc_1_ch_10_register = root.findViewById(R.id.editText_adc_1_ch_10_register);
        editTextArrayListRegisterAdc.add(editText_adc_1_ch_10_register);
        editText_adc_1_ch_11_register = root.findViewById(R.id.editText_adc_1_ch_11_register);
        editTextArrayListRegisterAdc.add(editText_adc_1_ch_11_register);
        editText_adc_1_ch_12_register = root.findViewById(R.id.editText_adc_1_ch_12_register);
        editTextArrayListRegisterAdc.add(editText_adc_1_ch_12_register);
        editText_adc_1_ch_13_register = root.findViewById(R.id.editText_adc_1_ch_13_register);
        editTextArrayListRegisterAdc.add(editText_adc_1_ch_13_register);
        editText_adc_1_ch_14_register = root.findViewById(R.id.editText_adc_1_ch_14_register);
        editTextArrayListRegisterAdc.add(editText_adc_1_ch_14_register);
        editText_adc_1_ch_15_register = root.findViewById(R.id.editText_adc_1_ch_15_register);
        editTextArrayListRegisterAdc.add(editText_adc_1_ch_15_register);

        editText_adc_2_ch_0_register = root.findViewById(R.id.editText_adc_2_ch_0_register);
        editTextArrayListRegisterAdc.add(editText_adc_2_ch_0_register);
        editText_adc_2_ch_1_register = root.findViewById(R.id.editText_adc_2_ch_1_register);
        editTextArrayListRegisterAdc.add(editText_adc_2_ch_1_register);
        editText_adc_2_ch_2_register = root.findViewById(R.id.editText_adc_2_ch_2_register);
        editTextArrayListRegisterAdc.add(editText_adc_2_ch_2_register);
        editText_adc_2_ch_3_register = root.findViewById(R.id.editText_adc_2_ch_3_register);
        editTextArrayListRegisterAdc.add(editText_adc_2_ch_3_register);
        editText_adc_2_ch_4_register = root.findViewById(R.id.editText_adc_2_ch_4_register);
        editTextArrayListRegisterAdc.add(editText_adc_2_ch_4_register);
        editText_adc_2_ch_5_register = root.findViewById(R.id.editText_adc_2_ch_5_register);
        editTextArrayListRegisterAdc.add(editText_adc_2_ch_5_register);
        editText_adc_2_ch_6_register = root.findViewById(R.id.editText_adc_2_ch_6_register);
        editTextArrayListRegisterAdc.add(editText_adc_2_ch_6_register);
        editText_adc_2_ch_7_register = root.findViewById(R.id.editText_adc_2_ch_7_register);
        editTextArrayListRegisterAdc.add(editText_adc_2_ch_7_register);
        editText_adc_2_ch_8_register = root.findViewById(R.id.editText_adc_2_ch_8_register);
        editTextArrayListRegisterAdc.add(editText_adc_2_ch_8_register);
        editText_adc_2_ch_9_register = root.findViewById(R.id.editText_adc_2_ch_9_register);
        editTextArrayListRegisterAdc.add(editText_adc_2_ch_9_register);
        editText_adc_2_ch_10_register = root.findViewById(R.id.editText_adc_2_ch_10_register);
        editTextArrayListRegisterAdc.add(editText_adc_2_ch_10_register);
        editText_adc_2_ch_11_register = root.findViewById(R.id.editText_adc_2_ch_11_register);
        editTextArrayListRegisterAdc.add(editText_adc_2_ch_11_register);
        editText_adc_2_ch_12_register = root.findViewById(R.id.editText_adc_2_ch_12_register);
        editTextArrayListRegisterAdc.add(editText_adc_2_ch_12_register);
        editText_adc_2_ch_13_register = root.findViewById(R.id.editText_adc_2_ch_13_register);
        editTextArrayListRegisterAdc.add(editText_adc_2_ch_13_register);
        editText_adc_2_ch_14_register = root.findViewById(R.id.editText_adc_2_ch_14_register);
        editTextArrayListRegisterAdc.add(editText_adc_2_ch_14_register);
        editText_adc_2_ch_15_register = root.findViewById(R.id.editText_adc_2_ch_15_register);
        editTextArrayListRegisterAdc.add(editText_adc_2_ch_15_register);

        i = 0;
        for (final EditText editText: editTextArrayListRegisterAdc) {
            editText.setText(String.valueOf(spaceSetting.getAdcArrayList().get(i).getRegister()));
            final int finalI = i;
            editText.setOnKeyListener(new View.OnKeyListener() {
                @Override
                public boolean onKey(View v, int keyCode, KeyEvent event) {
                    if(event.getAction() == KeyEvent.ACTION_DOWN && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                        String text = editText.getText().toString();
                        if (!text.equals("")) {
                            int register = Integer.parseInt(text);
                            if (finalI < 16) spaceSetting.setSharedPreferences("adc_0_" + finalI + "_register", register);
                            else if (finalI < 32) spaceSetting.setSharedPreferences("adc_1_" + finalI + "_register", register);
                            else spaceSetting.setSharedPreferences("adc_2_" + finalI + "_register", register);
                            spaceSetting.getAdcArrayList().get(finalI).setRegister(register);
                        }
                    }
                    return true;
                }
            });
            i = i + 1;
        }

//        editText_adc_0_ch_0_register.setOnKeyListener(new View.OnKeyListener() {
//            @Override
//            public boolean onKey(View v, int keyCode, KeyEvent event) {
//                if(event.getAction() == KeyEvent.ACTION_DOWN && (keyCode == KeyEvent.KEYCODE_ENTER)) {
//                    String text = editText_adc_0_ch_0_register.getText().toString();
//                    if (!text.equals("")) {
//                        int register = Integer.parseInt(text);
//                        spaceSetting.setSharedPreferences("adc_0_0_register", register);
//                        spaceSetting.getAdcArrayList().get(0).setRegister(register);
//                    }
//                }
//                return true;
//            }
//        });
//
//        editText_adc_0_ch_1_register.setOnKeyListener(new View.OnKeyListener() {
//            @Override
//            public boolean onKey(View v, int keyCode, KeyEvent event) {
//                if(event.getAction() == KeyEvent.ACTION_DOWN && (keyCode == KeyEvent.KEYCODE_ENTER)) {
//                    String text = editText_adc_0_ch_1_register.getText().toString();
//                    if (!text.equals("")) {
//                        int register = Integer.parseInt(text);
//                        spaceSetting.setSharedPreferences("adc_0_1_register", register);
//                        spaceSetting.getAdcArrayList().get(1).setRegister(register);
//                    }
//                }
//                return true;
//            }
//        });
//
//        editText_adc_0_ch_2_register.setOnKeyListener(new View.OnKeyListener() {
//            @Override
//            public boolean onKey(View v, int keyCode, KeyEvent event) {
//                if(event.getAction() == KeyEvent.ACTION_DOWN && (keyCode == KeyEvent.KEYCODE_ENTER)) {
//                    String text = editText_adc_0_ch_2_register.getText().toString();
//                    if (!text.equals("")) {
//                        int register = Integer.parseInt(text);
//                        spaceSetting.setSharedPreferences("adc_0_2_register", register);
//                        spaceSetting.getAdcArrayList().get(2).setRegister(register);
//                    }
//                }
//                return true;
//            }
//        });
//
//        editText_adc_0_ch_3_register.setOnKeyListener(new View.OnKeyListener() {
//            @Override
//            public boolean onKey(View v, int keyCode, KeyEvent event) {
//                if(event.getAction() == KeyEvent.ACTION_DOWN && (keyCode == KeyEvent.KEYCODE_ENTER)) {
//                    String text = editText_adc_0_ch_3_register.getText().toString();
//                    if (!text.equals("")) {
//                        int register = Integer.parseInt(text);
//                        spaceSetting.setSharedPreferences("adc_0_3_register", register);
//                        spaceSetting.getAdcArrayList().get(3).setRegister(register);
//                    }
//                }
//                return true;
//            }
//        });
//
//        editText_adc_0_ch_4_register.setOnKeyListener(new View.OnKeyListener() {
//            @Override
//            public boolean onKey(View v, int keyCode, KeyEvent event) {
//                if(event.getAction() == KeyEvent.ACTION_DOWN && (keyCode == KeyEvent.KEYCODE_ENTER)) {
//                    String text = editText_adc_0_ch_4_register.getText().toString();
//                    if (!text.equals("")) {
//                        int register = Integer.parseInt(text);
//                        spaceSetting.setSharedPreferences("adc_0_4_register", register);
//                        spaceSetting.getAdcArrayList().get(4).setRegister(register);
//                    }
//                }
//                return true;
//            }
//        });
//
//        editText_adc_0_ch_5_register.setOnKeyListener(new View.OnKeyListener() {
//            @Override
//            public boolean onKey(View v, int keyCode, KeyEvent event) {
//                if(event.getAction() == KeyEvent.ACTION_DOWN && (keyCode == KeyEvent.KEYCODE_ENTER)) {
//                    String text = editText_adc_0_ch_5_register.getText().toString();
//                    if (!text.equals("")) {
//                        int register = Integer.parseInt(text);
//                        spaceSetting.setSharedPreferences("adc_0_5_register", register);
//                        spaceSetting.getAdcArrayList().get(5).setRegister(register);
//                    }
//                }
//                return true;
//            }
//        });
//
//        editText_adc_0_ch_6_register.setOnKeyListener(new View.OnKeyListener() {
//            @Override
//            public boolean onKey(View v, int keyCode, KeyEvent event) {
//                if(event.getAction() == KeyEvent.ACTION_DOWN && (keyCode == KeyEvent.KEYCODE_ENTER)) {
//                    String text = editText_adc_0_ch_6_register.getText().toString();
//                    if (!text.equals("")) {
//                        int register = Integer.parseInt(text);
//                        spaceSetting.setSharedPreferences("adc_0_6_register", register);
//                        spaceSetting.getAdcArrayList().get(6).setRegister(register);
//                    }
//                }
//                return true;
//            }
//        });
//
//        editText_adc_0_ch_7_register.setOnKeyListener(new View.OnKeyListener() {
//            @Override
//            public boolean onKey(View v, int keyCode, KeyEvent event) {
//                if(event.getAction() == KeyEvent.ACTION_DOWN && (keyCode == KeyEvent.KEYCODE_ENTER)) {
//                    String text = editText_adc_0_ch_7_register.getText().toString();
//                    if (!text.equals("")) {
//                        int register = Integer.parseInt(text);
//                        spaceSetting.setSharedPreferences("adc_0_7_register", register);
//                        spaceSetting.getAdcArrayList().get(7).setRegister(register);
//                    }
//                }
//                return true;
//            }
//        });
//
//        editText_adc_0_ch_8_register.setOnKeyListener(new View.OnKeyListener() {
//            @Override
//            public boolean onKey(View v, int keyCode, KeyEvent event) {
//                if(event.getAction() == KeyEvent.ACTION_DOWN && (keyCode == KeyEvent.KEYCODE_ENTER)) {
//                    String text = editText_adc_0_ch_8_register.getText().toString();
//                    if (!text.equals("")) {
//                        int register = Integer.parseInt(text);
//                        spaceSetting.setSharedPreferences("adc_0_8_register", register);
//                        spaceSetting.getAdcArrayList().get(8).setRegister(register);
//                    }
//                }
//                return true;
//            }
//        });
//
//        editText_adc_0_ch_9_register.setOnKeyListener(new View.OnKeyListener() {
//            @Override
//            public boolean onKey(View v, int keyCode, KeyEvent event) {
//                if(event.getAction() == KeyEvent.ACTION_DOWN && (keyCode == KeyEvent.KEYCODE_ENTER)) {
//                    String text = editText_adc_0_ch_9_register.getText().toString();
//                    if (!text.equals("")) {
//                        int register = Integer.parseInt(text);
//                        spaceSetting.setSharedPreferences("adc_0_9_register", register);
//                        spaceSetting.getAdcArrayList().get(9).setRegister(register);
//                    }
//                }
//                return true;
//            }
//        });
//
//        editText_adc_0_ch_10_register.setOnKeyListener(new View.OnKeyListener() {
//            @Override
//            public boolean onKey(View v, int keyCode, KeyEvent event) {
//                if(event.getAction() == KeyEvent.ACTION_DOWN && (keyCode == KeyEvent.KEYCODE_ENTER)) {
//                    String text = editText_adc_0_ch_10_register.getText().toString();
//                    if (!text.equals("")) {
//                        int register = Integer.parseInt(text);
//                        spaceSetting.setSharedPreferences("adc_0_10_register", register);
//                        spaceSetting.getAdcArrayList().get(10).setRegister(register);
//                    }
//                }
//                return true;
//            }
//        });
//
//        editText_adc_0_ch_11_register.setOnKeyListener(new View.OnKeyListener() {
//            @Override
//            public boolean onKey(View v, int keyCode, KeyEvent event) {
//                if(event.getAction() == KeyEvent.ACTION_DOWN && (keyCode == KeyEvent.KEYCODE_ENTER)) {
//                    String text = editText_adc_0_ch_11_register.getText().toString();
//                    if (!text.equals("")) {
//                        int register = Integer.parseInt(text);
//                        spaceSetting.setSharedPreferences("adc_0_11_register", register);
//                        spaceSetting.getAdcArrayList().get(11).setRegister(register);
//                    }
//                }
//                return true;
//            }
//        });
//
//        editText_adc_0_ch_12_register.setOnKeyListener(new View.OnKeyListener() {
//            @Override
//            public boolean onKey(View v, int keyCode, KeyEvent event) {
//                if(event.getAction() == KeyEvent.ACTION_DOWN && (keyCode == KeyEvent.KEYCODE_ENTER)) {
//                    String text = editText_adc_0_ch_12_register.getText().toString();
//                    if (!text.equals("")) {
//                        int register = Integer.parseInt(text);
//                        spaceSetting.setSharedPreferences("adc_0_12_register", register);
//                        spaceSetting.getAdcArrayList().get(12).setRegister(register);
//                    }
//                }
//                return true;
//            }
//        });
//
//        editText_adc_0_ch_13_register.setOnKeyListener(new View.OnKeyListener() {
//            @Override
//            public boolean onKey(View v, int keyCode, KeyEvent event) {
//                if(event.getAction() == KeyEvent.ACTION_DOWN && (keyCode == KeyEvent.KEYCODE_ENTER)) {
//                    String text = editText_adc_0_ch_13_register.getText().toString();
//                    if (!text.equals("")) {
//                        int register = Integer.parseInt(text);
//                        spaceSetting.setSharedPreferences("adc_0_13_register", register);
//                        spaceSetting.getAdcArrayList().get(13).setRegister(register);
//                    }
//                }
//                return true;
//            }
//        });
//
//        editText_adc_0_ch_14_register.setOnKeyListener(new View.OnKeyListener() {
//            @Override
//            public boolean onKey(View v, int keyCode, KeyEvent event) {
//                if(event.getAction() == KeyEvent.ACTION_DOWN && (keyCode == KeyEvent.KEYCODE_ENTER)) {
//                    String text = editText_adc_0_ch_14_register.getText().toString();
//                    if (!text.equals("")) {
//                        int register = Integer.parseInt(text);
//                        spaceSetting.setSharedPreferences("adc_0_14_register", register);
//                        spaceSetting.getAdcArrayList().get(14).setRegister(register);
//                    }
//                }
//                return true;
//            }
//        });
//
//        editText_adc_0_ch_15_register.setOnKeyListener(new View.OnKeyListener() {
//            @Override
//            public boolean onKey(View v, int keyCode, KeyEvent event) {
//                if(event.getAction() == KeyEvent.ACTION_DOWN && (keyCode == KeyEvent.KEYCODE_ENTER)) {
//                    String text = editText_adc_0_ch_15_register.getText().toString();
//                    if (!text.equals("")) {
//                        int register = Integer.parseInt(text);
//                        spaceSetting.setSharedPreferences("adc_0_15_register", register);
//                        spaceSetting.getAdcArrayList().get(15).setRegister(register);
//                    }
//                }
//                return true;
//            }
//        });

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        editTextArrayListPlusAdc = new ArrayList<>();

        editText_adc_0_ch_0_plus = root.findViewById(R.id.editText_adc_0_ch_0_plus);
        editTextArrayListPlusAdc.add(editText_adc_0_ch_0_plus);
        editText_adc_0_ch_1_plus = root.findViewById(R.id.editText_adc_0_ch_1_plus);
        editTextArrayListPlusAdc.add(editText_adc_0_ch_1_plus);
        editText_adc_0_ch_2_plus = root.findViewById(R.id.editText_adc_0_ch_2_plus);
        editTextArrayListPlusAdc.add(editText_adc_0_ch_2_plus);
        editText_adc_0_ch_3_plus = root.findViewById(R.id.editText_adc_0_ch_3_plus);
        editTextArrayListPlusAdc.add(editText_adc_0_ch_3_plus);
        editText_adc_0_ch_4_plus = root.findViewById(R.id.editText_adc_0_ch_4_plus);
        editTextArrayListPlusAdc.add(editText_adc_0_ch_4_plus);
        editText_adc_0_ch_5_plus = root.findViewById(R.id.editText_adc_0_ch_5_plus);
        editTextArrayListPlusAdc.add(editText_adc_0_ch_5_plus);
        editText_adc_0_ch_6_plus = root.findViewById(R.id.editText_adc_0_ch_6_plus);
        editTextArrayListPlusAdc.add(editText_adc_0_ch_6_plus);
        editText_adc_0_ch_7_plus = root.findViewById(R.id.editText_adc_0_ch_7_plus);
        editTextArrayListPlusAdc.add(editText_adc_0_ch_7_plus);
        editText_adc_0_ch_8_plus = root.findViewById(R.id.editText_adc_0_ch_8_plus);
        editTextArrayListPlusAdc.add(editText_adc_0_ch_8_plus);
        editText_adc_0_ch_9_plus = root.findViewById(R.id.editText_adc_0_ch_9_plus);
        editTextArrayListPlusAdc.add(editText_adc_0_ch_9_plus);
        editText_adc_0_ch_10_plus = root.findViewById(R.id.editText_adc_0_ch_10_plus);
        editTextArrayListPlusAdc.add(editText_adc_0_ch_10_plus);
        editText_adc_0_ch_11_plus = root.findViewById(R.id.editText_adc_0_ch_11_plus);
        editTextArrayListPlusAdc.add(editText_adc_0_ch_11_plus);
        editText_adc_0_ch_12_plus = root.findViewById(R.id.editText_adc_0_ch_12_plus);
        editTextArrayListPlusAdc.add(editText_adc_0_ch_12_plus);
        editText_adc_0_ch_13_plus = root.findViewById(R.id.editText_adc_0_ch_13_plus);
        editTextArrayListPlusAdc.add(editText_adc_0_ch_13_plus);
        editText_adc_0_ch_14_plus = root.findViewById(R.id.editText_adc_0_ch_14_plus);
        editTextArrayListPlusAdc.add(editText_adc_0_ch_14_plus);
        editText_adc_0_ch_15_plus = root.findViewById(R.id.editText_adc_0_ch_15_plus);
        editTextArrayListPlusAdc.add(editText_adc_0_ch_15_plus);

        editText_adc_1_ch_0_plus = root.findViewById(R.id.editText_adc_1_ch_0_plus);
        editTextArrayListPlusAdc.add(editText_adc_1_ch_0_plus);
        editText_adc_1_ch_1_plus = root.findViewById(R.id.editText_adc_1_ch_1_plus);
        editTextArrayListPlusAdc.add(editText_adc_1_ch_1_plus);
        editText_adc_1_ch_2_plus = root.findViewById(R.id.editText_adc_1_ch_2_plus);
        editTextArrayListPlusAdc.add(editText_adc_1_ch_2_plus);
        editText_adc_1_ch_3_plus = root.findViewById(R.id.editText_adc_1_ch_3_plus);
        editTextArrayListPlusAdc.add(editText_adc_1_ch_3_plus);
        editText_adc_1_ch_4_plus = root.findViewById(R.id.editText_adc_1_ch_4_plus);
        editTextArrayListPlusAdc.add(editText_adc_1_ch_4_plus);
        editText_adc_1_ch_5_plus = root.findViewById(R.id.editText_adc_1_ch_5_plus);
        editTextArrayListPlusAdc.add(editText_adc_1_ch_5_plus);
        editText_adc_1_ch_6_plus = root.findViewById(R.id.editText_adc_1_ch_6_plus);
        editTextArrayListPlusAdc.add(editText_adc_1_ch_6_plus);
        editText_adc_1_ch_7_plus = root.findViewById(R.id.editText_adc_1_ch_7_plus);
        editTextArrayListPlusAdc.add(editText_adc_1_ch_7_plus);
        editText_adc_1_ch_8_plus = root.findViewById(R.id.editText_adc_1_ch_8_plus);
        editTextArrayListPlusAdc.add(editText_adc_1_ch_8_plus);
        editText_adc_1_ch_9_plus = root.findViewById(R.id.editText_adc_1_ch_9_plus);
        editTextArrayListPlusAdc.add(editText_adc_1_ch_9_plus);
        editText_adc_1_ch_10_plus = root.findViewById(R.id.editText_adc_1_ch_10_plus);
        editTextArrayListPlusAdc.add(editText_adc_1_ch_10_plus);
        editText_adc_1_ch_11_plus = root.findViewById(R.id.editText_adc_1_ch_11_plus);
        editTextArrayListPlusAdc.add(editText_adc_1_ch_11_plus);
        editText_adc_1_ch_12_plus = root.findViewById(R.id.editText_adc_1_ch_12_plus);
        editTextArrayListPlusAdc.add(editText_adc_1_ch_12_plus);
        editText_adc_1_ch_13_plus = root.findViewById(R.id.editText_adc_1_ch_13_plus);
        editTextArrayListPlusAdc.add(editText_adc_1_ch_13_plus);
        editText_adc_1_ch_14_plus = root.findViewById(R.id.editText_adc_1_ch_14_plus);
        editTextArrayListPlusAdc.add(editText_adc_1_ch_14_plus);
        editText_adc_1_ch_15_plus = root.findViewById(R.id.editText_adc_1_ch_15_plus);
        editTextArrayListPlusAdc.add(editText_adc_1_ch_15_plus);

        editText_adc_2_ch_0_plus = root.findViewById(R.id.editText_adc_2_ch_0_plus);
        editTextArrayListPlusAdc.add(editText_adc_2_ch_0_plus);
        editText_adc_2_ch_1_plus = root.findViewById(R.id.editText_adc_2_ch_1_plus);
        editTextArrayListPlusAdc.add(editText_adc_2_ch_1_plus);
        editText_adc_2_ch_2_plus = root.findViewById(R.id.editText_adc_2_ch_2_plus);
        editTextArrayListPlusAdc.add(editText_adc_2_ch_2_plus);
        editText_adc_2_ch_3_plus = root.findViewById(R.id.editText_adc_2_ch_3_plus);
        editTextArrayListPlusAdc.add(editText_adc_2_ch_3_plus);
        editText_adc_2_ch_4_plus = root.findViewById(R.id.editText_adc_2_ch_4_plus);
        editTextArrayListPlusAdc.add(editText_adc_2_ch_4_plus);
        editText_adc_2_ch_5_plus = root.findViewById(R.id.editText_adc_2_ch_5_plus);
        editTextArrayListPlusAdc.add(editText_adc_2_ch_5_plus);
        editText_adc_2_ch_6_plus = root.findViewById(R.id.editText_adc_2_ch_6_plus);
        editTextArrayListPlusAdc.add(editText_adc_2_ch_6_plus);
        editText_adc_2_ch_7_plus = root.findViewById(R.id.editText_adc_2_ch_7_plus);
        editTextArrayListPlusAdc.add(editText_adc_2_ch_7_plus);
        editText_adc_2_ch_8_plus = root.findViewById(R.id.editText_adc_2_ch_8_plus);
        editTextArrayListPlusAdc.add(editText_adc_2_ch_8_plus);
        editText_adc_2_ch_9_plus = root.findViewById(R.id.editText_adc_2_ch_9_plus);
        editTextArrayListPlusAdc.add(editText_adc_2_ch_9_plus);
        editText_adc_2_ch_10_plus = root.findViewById(R.id.editText_adc_2_ch_10_plus);
        editTextArrayListPlusAdc.add(editText_adc_2_ch_10_plus);
        editText_adc_2_ch_11_plus = root.findViewById(R.id.editText_adc_2_ch_11_plus);
        editTextArrayListPlusAdc.add(editText_adc_2_ch_11_plus);
        editText_adc_2_ch_12_plus = root.findViewById(R.id.editText_adc_2_ch_12_plus);
        editTextArrayListPlusAdc.add(editText_adc_2_ch_12_plus);
        editText_adc_2_ch_13_plus = root.findViewById(R.id.editText_adc_2_ch_13_plus);
        editTextArrayListPlusAdc.add(editText_adc_2_ch_13_plus);
        editText_adc_2_ch_14_plus = root.findViewById(R.id.editText_adc_2_ch_14_plus);
        editTextArrayListPlusAdc.add(editText_adc_2_ch_14_plus);
        editText_adc_2_ch_15_plus = root.findViewById(R.id.editText_adc_2_ch_15_plus);
        editTextArrayListPlusAdc.add(editText_adc_2_ch_15_plus);

        i = 0;
        for (final EditText editText: editTextArrayListPlusAdc) {
            editText.setText(String.valueOf(spaceSetting.getAdcArrayList().get(i).getPlus()));
            final int finalI = i;
            editText.setOnKeyListener(new View.OnKeyListener() {
                @Override
                public boolean onKey(View v, int keyCode, KeyEvent event) {
                    if(event.getAction() == KeyEvent.ACTION_DOWN && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                        String text = editText.getText().toString();
                        if (!text.equals("")) {
                            int plus = Integer.parseInt(text);
                            if (finalI < 16) spaceSetting.setSharedPreferences("adc_0_" + finalI + "_plus", plus);
                            else if (finalI < 32) spaceSetting.setSharedPreferences("adc_1_" + finalI + "_plus", plus);
                            else spaceSetting.setSharedPreferences("adc_2_" + finalI + "_plus", plus);
                            spaceSetting.getAdcArrayList().get(finalI).setPlus(plus);
                        }
                    }
                    return true;
                }
            });
            i = i + 1;
        }

//        editText_adc_0_ch_0_plus.setOnKeyListener(new View.OnKeyListener() {
//            @Override
//            public boolean onKey(View v, int keyCode, KeyEvent event) {
//                if(event.getAction() == KeyEvent.ACTION_DOWN && (keyCode == KeyEvent.KEYCODE_ENTER)) {
//                    String text = editText_adc_0_ch_0_plus.getText().toString();
//                    if (!text.equals("")) {
//                        int plus = Integer.parseInt(text);
//                        spaceSetting.setSharedPreferences("adc_0_0_plus", plus);
//                        spaceSetting.getAdcArrayList().get(0).setRegister(plus);
//                    }
//                }
//                return true;
//            }
//        });
//
//        editText_adc_0_ch_1_plus.setOnKeyListener(new View.OnKeyListener() {
//            @Override
//            public boolean onKey(View v, int keyCode, KeyEvent event) {
//                if(event.getAction() == KeyEvent.ACTION_DOWN && (keyCode == KeyEvent.KEYCODE_ENTER)) {
//                    String text = editText_adc_0_ch_1_plus.getText().toString();
//                    if (!text.equals("")) {
//                        int plus = Integer.parseInt(text);
//                        spaceSetting.setSharedPreferences("adc_0_1_plus", plus);
//                        spaceSetting.getAdcArrayList().get(1).setRegister(plus);
//                    }
//                }
//                return true;
//            }
//        });
//
//        editText_adc_0_ch_2_plus.setOnKeyListener(new View.OnKeyListener() {
//            @Override
//            public boolean onKey(View v, int keyCode, KeyEvent event) {
//                if(event.getAction() == KeyEvent.ACTION_DOWN && (keyCode == KeyEvent.KEYCODE_ENTER)) {
//                    String text = editText_adc_0_ch_2_plus.getText().toString();
//                    if (!text.equals("")) {
//                        int plus = Integer.parseInt(text);
//                        spaceSetting.setSharedPreferences("adc_0_2_plus", plus);
//                        spaceSetting.getAdcArrayList().get(2).setRegister(plus);
//                    }
//                }
//                return true;
//            }
//        });
//
//        editText_adc_0_ch_3_plus.setOnKeyListener(new View.OnKeyListener() {
//            @Override
//            public boolean onKey(View v, int keyCode, KeyEvent event) {
//                if(event.getAction() == KeyEvent.ACTION_DOWN && (keyCode == KeyEvent.KEYCODE_ENTER)) {
//                    String text = editText_adc_0_ch_3_plus.getText().toString();
//                    if (!text.equals("")) {
//                        int plus = Integer.parseInt(text);
//                        spaceSetting.setSharedPreferences("adc_0_3_plus", plus);
//                        spaceSetting.getAdcArrayList().get(3).setRegister(plus);
//                    }
//                }
//                return true;
//            }
//        });
//
//        editText_adc_0_ch_4_plus.setOnKeyListener(new View.OnKeyListener() {
//            @Override
//            public boolean onKey(View v, int keyCode, KeyEvent event) {
//                if(event.getAction() == KeyEvent.ACTION_DOWN && (keyCode == KeyEvent.KEYCODE_ENTER)) {
//                    String text = editText_adc_0_ch_4_plus.getText().toString();
//                    if (!text.equals("")) {
//                        int plus = Integer.parseInt(text);
//                        spaceSetting.setSharedPreferences("adc_0_4_plus", plus);
//                        spaceSetting.getAdcArrayList().get(4).setRegister(plus);
//                    }
//                }
//                return true;
//            }
//        });
//
//        editText_adc_0_ch_5_plus.setOnKeyListener(new View.OnKeyListener() {
//            @Override
//            public boolean onKey(View v, int keyCode, KeyEvent event) {
//                if(event.getAction() == KeyEvent.ACTION_DOWN && (keyCode == KeyEvent.KEYCODE_ENTER)) {
//                    String text = editText_adc_0_ch_5_plus.getText().toString();
//                    if (!text.equals("")) {
//                        int plus = Integer.parseInt(text);
//                        spaceSetting.setSharedPreferences("adc_0_5_plus", plus);
//                        spaceSetting.getAdcArrayList().get(5).setRegister(plus);
//                    }
//                }
//                return true;
//            }
//        });
//
//        editText_adc_0_ch_6_plus.setOnKeyListener(new View.OnKeyListener() {
//            @Override
//            public boolean onKey(View v, int keyCode, KeyEvent event) {
//                if(event.getAction() == KeyEvent.ACTION_DOWN && (keyCode == KeyEvent.KEYCODE_ENTER)) {
//                    String text = editText_adc_0_ch_6_plus.getText().toString();
//                    if (!text.equals("")) {
//                        int plus = Integer.parseInt(text);
//                        spaceSetting.setSharedPreferences("adc_0_6_plus", plus);
//                        spaceSetting.getAdcArrayList().get(6).setRegister(plus);
//                    }
//                }
//                return true;
//            }
//        });
//
//        editText_adc_0_ch_7_plus.setOnKeyListener(new View.OnKeyListener() {
//            @Override
//            public boolean onKey(View v, int keyCode, KeyEvent event) {
//                if(event.getAction() == KeyEvent.ACTION_DOWN && (keyCode == KeyEvent.KEYCODE_ENTER)) {
//                    String text = editText_adc_0_ch_7_plus.getText().toString();
//                    if (!text.equals("")) {
//                        int plus = Integer.parseInt(text);
//                        spaceSetting.setSharedPreferences("adc_0_7_plus", plus);
//                        spaceSetting.getAdcArrayList().get(7).setRegister(plus);
//                    }
//                }
//                return true;
//            }
//        });
//
//        editText_adc_0_ch_8_plus.setOnKeyListener(new View.OnKeyListener() {
//            @Override
//            public boolean onKey(View v, int keyCode, KeyEvent event) {
//                if(event.getAction() == KeyEvent.ACTION_DOWN && (keyCode == KeyEvent.KEYCODE_ENTER)) {
//                    String text = editText_adc_0_ch_8_plus.getText().toString();
//                    if (!text.equals("")) {
//                        int plus = Integer.parseInt(text);
//                        spaceSetting.setSharedPreferences("adc_0_8_plus", plus);
//                        spaceSetting.getAdcArrayList().get(8).setRegister(plus);
//                    }
//                }
//                return true;
//            }
//        });
//
//        editText_adc_0_ch_9_plus.setOnKeyListener(new View.OnKeyListener() {
//            @Override
//            public boolean onKey(View v, int keyCode, KeyEvent event) {
//                if(event.getAction() == KeyEvent.ACTION_DOWN && (keyCode == KeyEvent.KEYCODE_ENTER)) {
//                    String text = editText_adc_0_ch_9_plus.getText().toString();
//                    if (!text.equals("")) {
//                        int plus = Integer.parseInt(text);
//                        spaceSetting.setSharedPreferences("adc_0_9_plus", plus);
//                        spaceSetting.getAdcArrayList().get(9).setRegister(plus);
//                    }
//                }
//                return true;
//            }
//        });
//
//        editText_adc_0_ch_10_plus.setOnKeyListener(new View.OnKeyListener() {
//            @Override
//            public boolean onKey(View v, int keyCode, KeyEvent event) {
//                if(event.getAction() == KeyEvent.ACTION_DOWN && (keyCode == KeyEvent.KEYCODE_ENTER)) {
//                    String text = editText_adc_0_ch_10_plus.getText().toString();
//                    if (!text.equals("")) {
//                        int plus = Integer.parseInt(text);
//                        spaceSetting.setSharedPreferences("adc_0_10_plus", plus);
//                        spaceSetting.getAdcArrayList().get(10).setRegister(plus);
//                    }
//                }
//                return true;
//            }
//        });
//
//        editText_adc_0_ch_11_plus.setOnKeyListener(new View.OnKeyListener() {
//            @Override
//            public boolean onKey(View v, int keyCode, KeyEvent event) {
//                if(event.getAction() == KeyEvent.ACTION_DOWN && (keyCode == KeyEvent.KEYCODE_ENTER)) {
//                    String text = editText_adc_0_ch_11_plus.getText().toString();
//                    if (!text.equals("")) {
//                        int plus = Integer.parseInt(text);
//                        spaceSetting.setSharedPreferences("adc_0_11_plus", plus);
//                        spaceSetting.getAdcArrayList().get(11).setRegister(plus);
//                    }
//                }
//                return true;
//            }
//        });
//
//        editText_adc_0_ch_12_plus.setOnKeyListener(new View.OnKeyListener() {
//            @Override
//            public boolean onKey(View v, int keyCode, KeyEvent event) {
//                if(event.getAction() == KeyEvent.ACTION_DOWN && (keyCode == KeyEvent.KEYCODE_ENTER)) {
//                    String text = editText_adc_0_ch_12_plus.getText().toString();
//                    if (!text.equals("")) {
//                        int plus = Integer.parseInt(text);
//                        spaceSetting.setSharedPreferences("adc_0_12_plus", plus);
//                        spaceSetting.getAdcArrayList().get(12).setRegister(plus);
//                    }
//                }
//                return true;
//            }
//        });
//
//        editText_adc_0_ch_13_plus.setOnKeyListener(new View.OnKeyListener() {
//            @Override
//            public boolean onKey(View v, int keyCode, KeyEvent event) {
//                if(event.getAction() == KeyEvent.ACTION_DOWN && (keyCode == KeyEvent.KEYCODE_ENTER)) {
//                    String text = editText_adc_0_ch_13_plus.getText().toString();
//                    if (!text.equals("")) {
//                        int plus = Integer.parseInt(text);
//                        spaceSetting.setSharedPreferences("adc_0_13_plus", plus);
//                        spaceSetting.getAdcArrayList().get(13).setRegister(plus);
//                    }
//                }
//                return true;
//            }
//        });
//
//        editText_adc_0_ch_14_plus.setOnKeyListener(new View.OnKeyListener() {
//            @Override
//            public boolean onKey(View v, int keyCode, KeyEvent event) {
//                if(event.getAction() == KeyEvent.ACTION_DOWN && (keyCode == KeyEvent.KEYCODE_ENTER)) {
//                    String text = editText_adc_0_ch_14_plus.getText().toString();
//                    if (!text.equals("")) {
//                        int plus = Integer.parseInt(text);
//                        spaceSetting.setSharedPreferences("adc_0_14_plus", plus);
//                        spaceSetting.getAdcArrayList().get(14).setRegister(plus);
//                    }
//                }
//                return true;
//            }
//        });
//
//        editText_adc_0_ch_15_plus.setOnKeyListener(new View.OnKeyListener() {
//            @Override
//            public boolean onKey(View v, int keyCode, KeyEvent event) {
//                if(event.getAction() == KeyEvent.ACTION_DOWN && (keyCode == KeyEvent.KEYCODE_ENTER)) {
//                    String text = editText_adc_0_ch_15_plus.getText().toString();
//                    if (!text.equals("")) {
//                        int plus = Integer.parseInt(text);
//                        spaceSetting.setSharedPreferences("adc_0_15_plus", plus);
//                        spaceSetting.getAdcArrayList().get(15).setRegister(plus);
//                    }
//                }
//                return true;
//            }
//        });

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        editTextArrayListMinusAdc = new ArrayList<>();

        editText_adc_0_ch_0_minus = root.findViewById(R.id.editText_adc_0_ch_0_minus);
        editTextArrayListMinusAdc.add(editText_adc_0_ch_0_minus);
        editText_adc_0_ch_1_minus = root.findViewById(R.id.editText_adc_0_ch_1_minus);
        editTextArrayListMinusAdc.add(editText_adc_0_ch_1_minus);
        editText_adc_0_ch_2_minus = root.findViewById(R.id.editText_adc_0_ch_2_minus);
        editTextArrayListMinusAdc.add(editText_adc_0_ch_2_minus);
        editText_adc_0_ch_3_minus = root.findViewById(R.id.editText_adc_0_ch_3_minus);
        editTextArrayListMinusAdc.add(editText_adc_0_ch_3_minus);
        editText_adc_0_ch_4_minus = root.findViewById(R.id.editText_adc_0_ch_4_minus);
        editTextArrayListMinusAdc.add(editText_adc_0_ch_4_minus);
        editText_adc_0_ch_5_minus = root.findViewById(R.id.editText_adc_0_ch_5_minus);
        editTextArrayListMinusAdc.add(editText_adc_0_ch_5_minus);
        editText_adc_0_ch_6_minus = root.findViewById(R.id.editText_adc_0_ch_6_minus);
        editTextArrayListMinusAdc.add(editText_adc_0_ch_6_minus);
        editText_adc_0_ch_7_minus = root.findViewById(R.id.editText_adc_0_ch_7_minus);
        editTextArrayListMinusAdc.add(editText_adc_0_ch_7_minus);
        editText_adc_0_ch_8_minus = root.findViewById(R.id.editText_adc_0_ch_8_minus);
        editTextArrayListMinusAdc.add(editText_adc_0_ch_8_minus);
        editText_adc_0_ch_9_minus = root.findViewById(R.id.editText_adc_0_ch_9_minus);
        editTextArrayListMinusAdc.add(editText_adc_0_ch_9_minus);
        editText_adc_0_ch_10_minus = root.findViewById(R.id.editText_adc_0_ch_10_minus);
        editTextArrayListMinusAdc.add(editText_adc_0_ch_10_minus);
        editText_adc_0_ch_11_minus = root.findViewById(R.id.editText_adc_0_ch_11_minus);
        editTextArrayListMinusAdc.add(editText_adc_0_ch_11_minus);
        editText_adc_0_ch_12_minus = root.findViewById(R.id.editText_adc_0_ch_12_minus);
        editTextArrayListMinusAdc.add(editText_adc_0_ch_12_minus);
        editText_adc_0_ch_13_minus = root.findViewById(R.id.editText_adc_0_ch_13_minus);
        editTextArrayListMinusAdc.add(editText_adc_0_ch_13_minus);
        editText_adc_0_ch_14_minus = root.findViewById(R.id.editText_adc_0_ch_14_minus);
        editTextArrayListMinusAdc.add(editText_adc_0_ch_14_minus);
        editText_adc_0_ch_15_minus = root.findViewById(R.id.editText_adc_0_ch_15_minus);
        editTextArrayListMinusAdc.add(editText_adc_0_ch_15_minus);

        editText_adc_1_ch_0_minus = root.findViewById(R.id.editText_adc_1_ch_0_minus);
        editTextArrayListMinusAdc.add(editText_adc_1_ch_0_minus);
        editText_adc_1_ch_1_minus = root.findViewById(R.id.editText_adc_1_ch_1_minus);
        editTextArrayListMinusAdc.add(editText_adc_1_ch_1_minus);
        editText_adc_1_ch_2_minus = root.findViewById(R.id.editText_adc_1_ch_2_minus);
        editTextArrayListMinusAdc.add(editText_adc_1_ch_2_minus);
        editText_adc_1_ch_3_minus = root.findViewById(R.id.editText_adc_1_ch_3_minus);
        editTextArrayListMinusAdc.add(editText_adc_1_ch_3_minus);
        editText_adc_1_ch_4_minus = root.findViewById(R.id.editText_adc_1_ch_4_minus);
        editTextArrayListMinusAdc.add(editText_adc_1_ch_4_minus);
        editText_adc_1_ch_5_minus = root.findViewById(R.id.editText_adc_1_ch_5_minus);
        editTextArrayListMinusAdc.add(editText_adc_1_ch_5_minus);
        editText_adc_1_ch_6_minus = root.findViewById(R.id.editText_adc_1_ch_6_minus);
        editTextArrayListMinusAdc.add(editText_adc_1_ch_6_minus);
        editText_adc_1_ch_7_minus = root.findViewById(R.id.editText_adc_1_ch_7_minus);
        editTextArrayListMinusAdc.add(editText_adc_1_ch_7_minus);
        editText_adc_1_ch_8_minus = root.findViewById(R.id.editText_adc_1_ch_8_minus);
        editTextArrayListMinusAdc.add(editText_adc_1_ch_8_minus);
        editText_adc_1_ch_9_minus = root.findViewById(R.id.editText_adc_1_ch_9_minus);
        editTextArrayListMinusAdc.add(editText_adc_1_ch_9_minus);
        editText_adc_1_ch_10_minus = root.findViewById(R.id.editText_adc_1_ch_10_minus);
        editTextArrayListMinusAdc.add(editText_adc_1_ch_10_minus);
        editText_adc_1_ch_11_minus = root.findViewById(R.id.editText_adc_1_ch_11_minus);
        editTextArrayListMinusAdc.add(editText_adc_1_ch_11_minus);
        editText_adc_1_ch_12_minus = root.findViewById(R.id.editText_adc_1_ch_12_minus);
        editTextArrayListMinusAdc.add(editText_adc_1_ch_12_minus);
        editText_adc_1_ch_13_minus = root.findViewById(R.id.editText_adc_1_ch_13_minus);
        editTextArrayListMinusAdc.add(editText_adc_1_ch_13_minus);
        editText_adc_1_ch_14_minus = root.findViewById(R.id.editText_adc_1_ch_14_minus);
        editTextArrayListMinusAdc.add(editText_adc_1_ch_14_minus);
        editText_adc_1_ch_15_minus = root.findViewById(R.id.editText_adc_1_ch_15_minus);
        editTextArrayListMinusAdc.add(editText_adc_1_ch_15_minus);

        editText_adc_2_ch_0_minus = root.findViewById(R.id.editText_adc_2_ch_0_minus);
        editTextArrayListMinusAdc.add(editText_adc_2_ch_0_minus);
        editText_adc_2_ch_1_minus = root.findViewById(R.id.editText_adc_2_ch_1_minus);
        editTextArrayListMinusAdc.add(editText_adc_2_ch_1_minus);
        editText_adc_2_ch_2_minus = root.findViewById(R.id.editText_adc_2_ch_2_minus);
        editTextArrayListMinusAdc.add(editText_adc_2_ch_2_minus);
        editText_adc_2_ch_3_minus = root.findViewById(R.id.editText_adc_2_ch_3_minus);
        editTextArrayListMinusAdc.add(editText_adc_2_ch_3_minus);
        editText_adc_2_ch_4_minus = root.findViewById(R.id.editText_adc_2_ch_4_minus);
        editTextArrayListMinusAdc.add(editText_adc_2_ch_4_minus);
        editText_adc_2_ch_5_minus = root.findViewById(R.id.editText_adc_2_ch_5_minus);
        editTextArrayListMinusAdc.add(editText_adc_2_ch_5_minus);
        editText_adc_2_ch_6_minus = root.findViewById(R.id.editText_adc_2_ch_6_minus);
        editTextArrayListMinusAdc.add(editText_adc_2_ch_6_minus);
        editText_adc_2_ch_7_minus = root.findViewById(R.id.editText_adc_2_ch_7_minus);
        editTextArrayListMinusAdc.add(editText_adc_2_ch_7_minus);
        editText_adc_2_ch_8_minus = root.findViewById(R.id.editText_adc_2_ch_8_minus);
        editTextArrayListMinusAdc.add(editText_adc_2_ch_8_minus);
        editText_adc_2_ch_9_minus = root.findViewById(R.id.editText_adc_2_ch_9_minus);
        editTextArrayListMinusAdc.add(editText_adc_2_ch_9_minus);
        editText_adc_2_ch_10_minus = root.findViewById(R.id.editText_adc_2_ch_10_minus);
        editTextArrayListMinusAdc.add(editText_adc_2_ch_10_minus);
        editText_adc_2_ch_11_minus = root.findViewById(R.id.editText_adc_2_ch_11_minus);
        editTextArrayListMinusAdc.add(editText_adc_2_ch_11_minus);
        editText_adc_2_ch_12_minus = root.findViewById(R.id.editText_adc_2_ch_12_minus);
        editTextArrayListMinusAdc.add(editText_adc_2_ch_12_minus);
        editText_adc_2_ch_13_minus = root.findViewById(R.id.editText_adc_2_ch_13_minus);
        editTextArrayListMinusAdc.add(editText_adc_2_ch_13_minus);
        editText_adc_2_ch_14_minus = root.findViewById(R.id.editText_adc_2_ch_14_minus);
        editTextArrayListMinusAdc.add(editText_adc_2_ch_14_minus);
        editText_adc_2_ch_15_minus = root.findViewById(R.id.editText_adc_2_ch_15_minus);
        editTextArrayListMinusAdc.add(editText_adc_2_ch_15_minus);

        i = 0;
        for (final EditText editText: editTextArrayListMinusAdc) {
            editText.setText(String.valueOf(spaceSetting.getAdcArrayList().get(i).getMinus()));
            final int finalI = i;
            editText.setOnKeyListener(new View.OnKeyListener() {
                @Override
                public boolean onKey(View v, int keyCode, KeyEvent event) {
                    if(event.getAction() == KeyEvent.ACTION_DOWN && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                        String text = editText.getText().toString();
                        if (!text.equals("")) {
                            int minus = Integer.parseInt(text);
                            if (finalI < 16) spaceSetting.setSharedPreferences("adc_0_" + finalI + "_minus", minus);
                            else if (finalI < 32) spaceSetting.setSharedPreferences("adc_1_" + finalI + "_minus", minus);
                            else spaceSetting.setSharedPreferences("adc_2_" + finalI + "_minus", minus);
                            spaceSetting.getAdcArrayList().get(finalI).setMinus(minus);
                        }
                    }
                    return true;
                }
            });
            i = i + 1;
        }

//        editText_adc_0_ch_0_minus.setOnKeyListener(new View.OnKeyListener() {
//            @Override
//            public boolean onKey(View v, int keyCode, KeyEvent event) {
//                if(event.getAction() == KeyEvent.ACTION_DOWN && (keyCode == KeyEvent.KEYCODE_ENTER)) {
//                    String text = editText_adc_0_ch_0_minus.getText().toString();
//                    if (!text.equals("")) {
//                        int minus = Integer.parseInt(text);
//                        spaceSetting.setSharedPreferences("adc_0_0_minus", minus);
//                        spaceSetting.getAdcArrayList().get(0).setRegister(minus);
//                    }
//                }
//                return true;
//            }
//        });
//
//        editText_adc_0_ch_1_minus.setOnKeyListener(new View.OnKeyListener() {
//            @Override
//            public boolean onKey(View v, int keyCode, KeyEvent event) {
//                if(event.getAction() == KeyEvent.ACTION_DOWN && (keyCode == KeyEvent.KEYCODE_ENTER)) {
//                    String text = editText_adc_0_ch_1_minus.getText().toString();
//                    if (!text.equals("")) {
//                        int minus = Integer.parseInt(text);
//                        spaceSetting.setSharedPreferences("adc_0_1_minus", minus);
//                        spaceSetting.getAdcArrayList().get(1).setRegister(minus);
//                    }
//                }
//                return true;
//            }
//        });
//
//        editText_adc_0_ch_2_minus.setOnKeyListener(new View.OnKeyListener() {
//            @Override
//            public boolean onKey(View v, int keyCode, KeyEvent event) {
//                if(event.getAction() == KeyEvent.ACTION_DOWN && (keyCode == KeyEvent.KEYCODE_ENTER)) {
//                    String text = editText_adc_0_ch_2_minus.getText().toString();
//                    if (!text.equals("")) {
//                        int minus = Integer.parseInt(text);
//                        spaceSetting.setSharedPreferences("adc_0_2_minus", minus);
//                        spaceSetting.getAdcArrayList().get(2).setRegister(minus);
//                    }
//                }
//                return true;
//            }
//        });
//
//        editText_adc_0_ch_3_minus.setOnKeyListener(new View.OnKeyListener() {
//            @Override
//            public boolean onKey(View v, int keyCode, KeyEvent event) {
//                if(event.getAction() == KeyEvent.ACTION_DOWN && (keyCode == KeyEvent.KEYCODE_ENTER)) {
//                    String text = editText_adc_0_ch_3_minus.getText().toString();
//                    if (!text.equals("")) {
//                        int minus = Integer.parseInt(text);
//                        spaceSetting.setSharedPreferences("adc_0_3_minus", minus);
//                        spaceSetting.getAdcArrayList().get(3).setRegister(minus);
//                    }
//                }
//                return true;
//            }
//        });
//
//        editText_adc_0_ch_4_minus.setOnKeyListener(new View.OnKeyListener() {
//            @Override
//            public boolean onKey(View v, int keyCode, KeyEvent event) {
//                if(event.getAction() == KeyEvent.ACTION_DOWN && (keyCode == KeyEvent.KEYCODE_ENTER)) {
//                    String text = editText_adc_0_ch_4_minus.getText().toString();
//                    if (!text.equals("")) {
//                        int minus = Integer.parseInt(text);
//                        spaceSetting.setSharedPreferences("adc_0_4_minus", minus);
//                        spaceSetting.getAdcArrayList().get(4).setRegister(minus);
//                    }
//                }
//                return true;
//            }
//        });
//
//        editText_adc_0_ch_5_minus.setOnKeyListener(new View.OnKeyListener() {
//            @Override
//            public boolean onKey(View v, int keyCode, KeyEvent event) {
//                if(event.getAction() == KeyEvent.ACTION_DOWN && (keyCode == KeyEvent.KEYCODE_ENTER)) {
//                    String text = editText_adc_0_ch_5_minus.getText().toString();
//                    if (!text.equals("")) {
//                        int minus = Integer.parseInt(text);
//                        spaceSetting.setSharedPreferences("adc_0_5_minus", minus);
//                        spaceSetting.getAdcArrayList().get(5).setRegister(minus);
//                    }
//                }
//                return true;
//            }
//        });
//
//        editText_adc_0_ch_6_minus.setOnKeyListener(new View.OnKeyListener() {
//            @Override
//            public boolean onKey(View v, int keyCode, KeyEvent event) {
//                if(event.getAction() == KeyEvent.ACTION_DOWN && (keyCode == KeyEvent.KEYCODE_ENTER)) {
//                    String text = editText_adc_0_ch_6_minus.getText().toString();
//                    if (!text.equals("")) {
//                        int minus = Integer.parseInt(text);
//                        spaceSetting.setSharedPreferences("adc_0_6_minus", minus);
//                        spaceSetting.getAdcArrayList().get(6).setRegister(minus);
//                    }
//                }
//                return true;
//            }
//        });
//
//        editText_adc_0_ch_7_minus.setOnKeyListener(new View.OnKeyListener() {
//            @Override
//            public boolean onKey(View v, int keyCode, KeyEvent event) {
//                if(event.getAction() == KeyEvent.ACTION_DOWN && (keyCode == KeyEvent.KEYCODE_ENTER)) {
//                    String text = editText_adc_0_ch_7_minus.getText().toString();
//                    if (!text.equals("")) {
//                        int minus = Integer.parseInt(text);
//                        spaceSetting.setSharedPreferences("adc_0_7_minus", minus);
//                        spaceSetting.getAdcArrayList().get(7).setRegister(minus);
//                    }
//                }
//                return true;
//            }
//        });
//
//        editText_adc_0_ch_8_minus.setOnKeyListener(new View.OnKeyListener() {
//            @Override
//            public boolean onKey(View v, int keyCode, KeyEvent event) {
//                if(event.getAction() == KeyEvent.ACTION_DOWN && (keyCode == KeyEvent.KEYCODE_ENTER)) {
//                    String text = editText_adc_0_ch_8_minus.getText().toString();
//                    if (!text.equals("")) {
//                        int minus = Integer.parseInt(text);
//                        spaceSetting.setSharedPreferences("adc_0_8_minus", minus);
//                        spaceSetting.getAdcArrayList().get(8).setRegister(minus);
//                    }
//                }
//                return true;
//            }
//        });
//
//        editText_adc_0_ch_9_minus.setOnKeyListener(new View.OnKeyListener() {
//            @Override
//            public boolean onKey(View v, int keyCode, KeyEvent event) {
//                if(event.getAction() == KeyEvent.ACTION_DOWN && (keyCode == KeyEvent.KEYCODE_ENTER)) {
//                    String text = editText_adc_0_ch_9_minus.getText().toString();
//                    if (!text.equals("")) {
//                        int minus = Integer.parseInt(text);
//                        spaceSetting.setSharedPreferences("adc_0_9_minus", minus);
//                        spaceSetting.getAdcArrayList().get(9).setRegister(minus);
//                    }
//                }
//                return true;
//            }
//        });
//
//        editText_adc_0_ch_10_minus.setOnKeyListener(new View.OnKeyListener() {
//            @Override
//            public boolean onKey(View v, int keyCode, KeyEvent event) {
//                if(event.getAction() == KeyEvent.ACTION_DOWN && (keyCode == KeyEvent.KEYCODE_ENTER)) {
//                    String text = editText_adc_0_ch_10_minus.getText().toString();
//                    if (!text.equals("")) {
//                        int minus = Integer.parseInt(text);
//                        spaceSetting.setSharedPreferences("adc_0_10_minus", minus);
//                        spaceSetting.getAdcArrayList().get(10).setRegister(minus);
//                    }
//                }
//                return true;
//            }
//        });
//
//        editText_adc_0_ch_11_minus.setOnKeyListener(new View.OnKeyListener() {
//            @Override
//            public boolean onKey(View v, int keyCode, KeyEvent event) {
//                if(event.getAction() == KeyEvent.ACTION_DOWN && (keyCode == KeyEvent.KEYCODE_ENTER)) {
//                    String text = editText_adc_0_ch_11_minus.getText().toString();
//                    if (!text.equals("")) {
//                        int minus = Integer.parseInt(text);
//                        spaceSetting.setSharedPreferences("adc_0_11_minus", minus);
//                        spaceSetting.getAdcArrayList().get(11).setRegister(minus);
//                    }
//                }
//                return true;
//            }
//        });
//
//        editText_adc_0_ch_12_minus.setOnKeyListener(new View.OnKeyListener() {
//            @Override
//            public boolean onKey(View v, int keyCode, KeyEvent event) {
//                if(event.getAction() == KeyEvent.ACTION_DOWN && (keyCode == KeyEvent.KEYCODE_ENTER)) {
//                    String text = editText_adc_0_ch_12_minus.getText().toString();
//                    if (!text.equals("")) {
//                        int minus = Integer.parseInt(text);
//                        spaceSetting.setSharedPreferences("adc_0_12_minus", minus);
//                        spaceSetting.getAdcArrayList().get(12).setRegister(minus);
//                    }
//                }
//                return true;
//            }
//        });
//
//        editText_adc_0_ch_13_minus.setOnKeyListener(new View.OnKeyListener() {
//            @Override
//            public boolean onKey(View v, int keyCode, KeyEvent event) {
//                if(event.getAction() == KeyEvent.ACTION_DOWN && (keyCode == KeyEvent.KEYCODE_ENTER)) {
//                    String text = editText_adc_0_ch_13_minus.getText().toString();
//                    if (!text.equals("")) {
//                        int minus = Integer.parseInt(text);
//                        spaceSetting.setSharedPreferences("adc_0_13_minus", minus);
//                        spaceSetting.getAdcArrayList().get(13).setRegister(minus);
//                    }
//                }
//                return true;
//            }
//        });
//
//        editText_adc_0_ch_14_minus.setOnKeyListener(new View.OnKeyListener() {
//            @Override
//            public boolean onKey(View v, int keyCode, KeyEvent event) {
//                if(event.getAction() == KeyEvent.ACTION_DOWN && (keyCode == KeyEvent.KEYCODE_ENTER)) {
//                    String text = editText_adc_0_ch_14_minus.getText().toString();
//                    if (!text.equals("")) {
//                        int minus = Integer.parseInt(text);
//                        spaceSetting.setSharedPreferences("adc_0_14_minus", minus);
//                        spaceSetting.getAdcArrayList().get(14).setRegister(minus);
//                    }
//                }
//                return true;
//            }
//        });
//
//        editText_adc_0_ch_15_minus.setOnKeyListener(new View.OnKeyListener() {
//            @Override
//            public boolean onKey(View v, int keyCode, KeyEvent event) {
//                if(event.getAction() == KeyEvent.ACTION_DOWN && (keyCode == KeyEvent.KEYCODE_ENTER)) {
//                    String text = editText_adc_0_ch_15_minus.getText().toString();
//                    if (!text.equals("")) {
//                        int minus = Integer.parseInt(text);
//                        spaceSetting.setSharedPreferences("adc_0_15_minus", minus);
//                        spaceSetting.getAdcArrayList().get(15).setRegister(minus);
//                    }
//                }
//                return true;
//            }
//        });

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        switchArrayListEnableAdc = new ArrayList<>();

        switch_acd_0_ch_0_enable = root.findViewById(R.id.switch_adc_0_ch_0_enable);
        switchArrayListEnableAdc.add(switch_acd_0_ch_0_enable);
        switch_acd_0_ch_1_enable = root.findViewById(R.id.switch_adc_0_ch_1_enable);
        switchArrayListEnableAdc.add(switch_acd_0_ch_1_enable);
        switch_acd_0_ch_2_enable = root.findViewById(R.id.switch_adc_0_ch_2_enable);
        switchArrayListEnableAdc.add(switch_acd_0_ch_2_enable);
        switch_acd_0_ch_3_enable = root.findViewById(R.id.switch_adc_0_ch_3_enable);
        switchArrayListEnableAdc.add(switch_acd_0_ch_3_enable);
        switch_acd_0_ch_4_enable = root.findViewById(R.id.switch_adc_0_ch_4_enable);
        switchArrayListEnableAdc.add(switch_acd_0_ch_4_enable);
        switch_acd_0_ch_5_enable = root.findViewById(R.id.switch_adc_0_ch_5_enable);
        switchArrayListEnableAdc.add(switch_acd_0_ch_5_enable);
        switch_acd_0_ch_6_enable = root.findViewById(R.id.switch_adc_0_ch_6_enable);
        switchArrayListEnableAdc.add(switch_acd_0_ch_6_enable);
        switch_acd_0_ch_7_enable = root.findViewById(R.id.switch_adc_0_ch_7_enable);
        switchArrayListEnableAdc.add(switch_acd_0_ch_7_enable);
        switch_acd_0_ch_8_enable = root.findViewById(R.id.switch_adc_0_ch_8_enable);
        switchArrayListEnableAdc.add(switch_acd_0_ch_8_enable);
        switch_acd_0_ch_9_enable = root.findViewById(R.id.switch_adc_0_ch_9_enable);
        switchArrayListEnableAdc.add(switch_acd_0_ch_9_enable);
        switch_acd_0_ch_10_enable = root.findViewById(R.id.switch_adc_0_ch_10_enable);
        switchArrayListEnableAdc.add(switch_acd_0_ch_10_enable);
        switch_acd_0_ch_11_enable = root.findViewById(R.id.switch_adc_0_ch_11_enable);
        switchArrayListEnableAdc.add(switch_acd_0_ch_11_enable);
        switch_acd_0_ch_12_enable = root.findViewById(R.id.switch_adc_0_ch_12_enable);
        switchArrayListEnableAdc.add(switch_acd_0_ch_12_enable);
        switch_acd_0_ch_13_enable = root.findViewById(R.id.switch_adc_0_ch_13_enable);
        switchArrayListEnableAdc.add(switch_acd_0_ch_13_enable);
        switch_acd_0_ch_14_enable = root.findViewById(R.id.switch_adc_0_ch_14_enable);
        switchArrayListEnableAdc.add(switch_acd_0_ch_14_enable);
        switch_acd_0_ch_15_enable = root.findViewById(R.id.switch_adc_0_ch_15_enable);
        switchArrayListEnableAdc.add(switch_acd_0_ch_15_enable);

        switch_acd_1_ch_0_enable = root.findViewById(R.id.switch_adc_1_ch_0_enable);
        switchArrayListEnableAdc.add(switch_acd_1_ch_0_enable);
        switch_acd_1_ch_1_enable = root.findViewById(R.id.switch_adc_1_ch_1_enable);
        switchArrayListEnableAdc.add(switch_acd_1_ch_1_enable);
        switch_acd_1_ch_2_enable = root.findViewById(R.id.switch_adc_1_ch_2_enable);
        switchArrayListEnableAdc.add(switch_acd_1_ch_2_enable);
        switch_acd_1_ch_3_enable = root.findViewById(R.id.switch_adc_1_ch_3_enable);
        switchArrayListEnableAdc.add(switch_acd_1_ch_3_enable);
        switch_acd_1_ch_4_enable = root.findViewById(R.id.switch_adc_1_ch_4_enable);
        switchArrayListEnableAdc.add(switch_acd_1_ch_4_enable);
        switch_acd_1_ch_5_enable = root.findViewById(R.id.switch_adc_1_ch_5_enable);
        switchArrayListEnableAdc.add(switch_acd_1_ch_5_enable);
        switch_acd_1_ch_6_enable = root.findViewById(R.id.switch_adc_1_ch_6_enable);
        switchArrayListEnableAdc.add(switch_acd_1_ch_6_enable);
        switch_acd_1_ch_7_enable = root.findViewById(R.id.switch_adc_1_ch_7_enable);
        switchArrayListEnableAdc.add(switch_acd_1_ch_7_enable);
        switch_acd_1_ch_8_enable = root.findViewById(R.id.switch_adc_1_ch_8_enable);
        switchArrayListEnableAdc.add(switch_acd_1_ch_8_enable);
        switch_acd_1_ch_9_enable = root.findViewById(R.id.switch_adc_1_ch_9_enable);
        switchArrayListEnableAdc.add(switch_acd_1_ch_9_enable);
        switch_acd_1_ch_10_enable = root.findViewById(R.id.switch_adc_1_ch_10_enable);
        switchArrayListEnableAdc.add(switch_acd_1_ch_10_enable);
        switch_acd_1_ch_11_enable = root.findViewById(R.id.switch_adc_1_ch_11_enable);
        switchArrayListEnableAdc.add(switch_acd_1_ch_11_enable);
        switch_acd_1_ch_12_enable = root.findViewById(R.id.switch_adc_1_ch_12_enable);
        switchArrayListEnableAdc.add(switch_acd_1_ch_12_enable);
        switch_acd_1_ch_13_enable = root.findViewById(R.id.switch_adc_1_ch_13_enable);
        switchArrayListEnableAdc.add(switch_acd_1_ch_13_enable);
        switch_acd_1_ch_14_enable = root.findViewById(R.id.switch_adc_1_ch_14_enable);
        switchArrayListEnableAdc.add(switch_acd_1_ch_14_enable);
        switch_acd_1_ch_15_enable = root.findViewById(R.id.switch_adc_1_ch_15_enable);
        switchArrayListEnableAdc.add(switch_acd_1_ch_15_enable);

        switch_acd_2_ch_0_enable = root.findViewById(R.id.switch_adc_2_ch_0_enable);
        switchArrayListEnableAdc.add(switch_acd_2_ch_0_enable);
        switch_acd_2_ch_1_enable = root.findViewById(R.id.switch_adc_2_ch_1_enable);
        switchArrayListEnableAdc.add(switch_acd_2_ch_1_enable);
        switch_acd_2_ch_2_enable = root.findViewById(R.id.switch_adc_2_ch_2_enable);
        switchArrayListEnableAdc.add(switch_acd_2_ch_2_enable);
        switch_acd_2_ch_3_enable = root.findViewById(R.id.switch_adc_2_ch_3_enable);
        switchArrayListEnableAdc.add(switch_acd_2_ch_3_enable);
        switch_acd_2_ch_4_enable = root.findViewById(R.id.switch_adc_2_ch_4_enable);
        switchArrayListEnableAdc.add(switch_acd_2_ch_4_enable);
        switch_acd_2_ch_5_enable = root.findViewById(R.id.switch_adc_2_ch_5_enable);
        switchArrayListEnableAdc.add(switch_acd_2_ch_5_enable);
        switch_acd_2_ch_6_enable = root.findViewById(R.id.switch_adc_2_ch_6_enable);
        switchArrayListEnableAdc.add(switch_acd_2_ch_6_enable);
        switch_acd_2_ch_7_enable = root.findViewById(R.id.switch_adc_2_ch_7_enable);
        switchArrayListEnableAdc.add(switch_acd_2_ch_7_enable);
        switch_acd_2_ch_8_enable = root.findViewById(R.id.switch_adc_2_ch_8_enable);
        switchArrayListEnableAdc.add(switch_acd_2_ch_8_enable);
        switch_acd_2_ch_9_enable = root.findViewById(R.id.switch_adc_2_ch_9_enable);
        switchArrayListEnableAdc.add(switch_acd_2_ch_9_enable);
        switch_acd_2_ch_10_enable = root.findViewById(R.id.switch_adc_2_ch_10_enable);
        switchArrayListEnableAdc.add(switch_acd_2_ch_10_enable);
        switch_acd_2_ch_11_enable = root.findViewById(R.id.switch_adc_2_ch_11_enable);
        switchArrayListEnableAdc.add(switch_acd_2_ch_11_enable);
        switch_acd_2_ch_12_enable = root.findViewById(R.id.switch_adc_2_ch_12_enable);
        switchArrayListEnableAdc.add(switch_acd_2_ch_12_enable);
        switch_acd_2_ch_13_enable = root.findViewById(R.id.switch_adc_2_ch_13_enable);
        switchArrayListEnableAdc.add(switch_acd_2_ch_13_enable);
        switch_acd_2_ch_14_enable = root.findViewById(R.id.switch_adc_2_ch_14_enable);
        switchArrayListEnableAdc.add(switch_acd_2_ch_14_enable);
        switch_acd_2_ch_15_enable = root.findViewById(R.id.switch_adc_2_ch_15_enable);
        switchArrayListEnableAdc.add(switch_acd_2_ch_15_enable);

        i = 0;
        for (final Switch switchFromList: switchArrayListEnableAdc) {
            switchFromList.setChecked(spaceSetting.getAdcArrayList().get(i).isEnable());
            final int finalI = i;
            switchFromList.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (switchFromList.isChecked()) {
                        spaceSetting.getAdcArrayList().get(finalI).setEnable(true);
                        if (finalI < 16) spaceSetting.setSharedPreferences("adc_0_" + finalI + "_enable", true);
                        else if (finalI < 32) spaceSetting.setSharedPreferences("adc_1_" + finalI + "_enable", true);
                        else spaceSetting.setSharedPreferences("adc_2_" + finalI + "_enable", true);
                    }
                    else {
                        spaceSetting.getAdcArrayList().get(finalI).setEnable(false);
                        if (finalI < 16) spaceSetting.setSharedPreferences("adc_0_" + finalI + "_enable", false);
                        else if (finalI < 32) spaceSetting.setSharedPreferences("adc_1_" + finalI + "_enable", false);
                        else spaceSetting.setSharedPreferences("adc_2_" + finalI + "_enable", false);
                    }
                }
            });
            i = i + 1;
        }


////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        editTextArrayListNameIn = new ArrayList<>();

        editText_in_0_ch_0_name = root.findViewById(R.id.editText_in_0_ch_0_name);
        editTextArrayListNameIn.add(editText_in_0_ch_0_name);
        editText_in_0_ch_1_name = root.findViewById(R.id.editText_in_0_ch_1_name);
        editTextArrayListNameIn.add(editText_in_0_ch_1_name);
        editText_in_0_ch_2_name = root.findViewById(R.id.editText_in_0_ch_2_name);
        editTextArrayListNameIn.add(editText_in_0_ch_2_name);
        editText_in_0_ch_3_name = root.findViewById(R.id.editText_in_0_ch_3_name);
        editTextArrayListNameIn.add(editText_in_0_ch_3_name);
        editText_in_0_ch_4_name = root.findViewById(R.id.editText_in_0_ch_4_name);
        editTextArrayListNameIn.add(editText_in_0_ch_4_name);
        editText_in_0_ch_5_name = root.findViewById(R.id.editText_in_0_ch_5_name);
        editTextArrayListNameIn.add(editText_in_0_ch_5_name);
        editText_in_0_ch_6_name = root.findViewById(R.id.editText_in_0_ch_6_name);
        editTextArrayListNameIn.add(editText_in_0_ch_6_name);
        editText_in_0_ch_7_name = root.findViewById(R.id.editText_in_0_ch_7_name);
        editTextArrayListNameIn.add(editText_in_0_ch_7_name);
        editText_in_0_ch_8_name = root.findViewById(R.id.editText_in_0_ch_8_name);
        editTextArrayListNameIn.add(editText_in_0_ch_8_name);
        editText_in_0_ch_9_name = root.findViewById(R.id.editText_in_0_ch_9_name);
        editTextArrayListNameIn.add(editText_in_0_ch_9_name);
        editText_in_0_ch_10_name = root.findViewById(R.id.editText_in_0_ch_10_name);
        editTextArrayListNameIn.add(editText_in_0_ch_10_name);
        editText_in_0_ch_11_name = root.findViewById(R.id.editText_in_0_ch_11_name);
        editTextArrayListNameIn.add(editText_in_0_ch_11_name);
        editText_in_0_ch_12_name = root.findViewById(R.id.editText_in_0_ch_12_name);
        editTextArrayListNameIn.add(editText_in_0_ch_12_name);
        editText_in_0_ch_13_name = root.findViewById(R.id.editText_in_0_ch_13_name);
        editTextArrayListNameIn.add(editText_in_0_ch_13_name);
        editText_in_0_ch_14_name = root.findViewById(R.id.editText_in_0_ch_14_name);
        editTextArrayListNameIn.add(editText_in_0_ch_14_name);
        editText_in_0_ch_15_name = root.findViewById(R.id.editText_in_0_ch_15_name);
        editTextArrayListNameIn.add(editText_in_0_ch_15_name);

        editText_in_1_ch_0_name = root.findViewById(R.id.editText_in_1_ch_0_name);
        editTextArrayListNameIn.add(editText_in_1_ch_0_name);
        editText_in_1_ch_1_name = root.findViewById(R.id.editText_in_1_ch_1_name);
        editTextArrayListNameIn.add(editText_in_1_ch_1_name);
        editText_in_1_ch_2_name = root.findViewById(R.id.editText_in_1_ch_2_name);
        editTextArrayListNameIn.add(editText_in_1_ch_2_name);
        editText_in_1_ch_3_name = root.findViewById(R.id.editText_in_1_ch_3_name);
        editTextArrayListNameIn.add(editText_in_1_ch_3_name);
        editText_in_1_ch_4_name = root.findViewById(R.id.editText_in_1_ch_4_name);
        editTextArrayListNameIn.add(editText_in_1_ch_4_name);
        editText_in_1_ch_5_name = root.findViewById(R.id.editText_in_1_ch_5_name);
        editTextArrayListNameIn.add(editText_in_1_ch_5_name);
        editText_in_1_ch_6_name = root.findViewById(R.id.editText_in_1_ch_6_name);
        editTextArrayListNameIn.add(editText_in_1_ch_6_name);
        editText_in_1_ch_7_name = root.findViewById(R.id.editText_in_1_ch_7_name);
        editTextArrayListNameIn.add(editText_in_1_ch_7_name);
        editText_in_1_ch_8_name = root.findViewById(R.id.editText_in_1_ch_8_name);
        editTextArrayListNameIn.add(editText_in_1_ch_8_name);
        editText_in_1_ch_9_name = root.findViewById(R.id.editText_in_1_ch_9_name);
        editTextArrayListNameIn.add(editText_in_1_ch_9_name);
        editText_in_1_ch_10_name = root.findViewById(R.id.editText_in_1_ch_10_name);
        editTextArrayListNameIn.add(editText_in_1_ch_10_name);
        editText_in_1_ch_11_name = root.findViewById(R.id.editText_in_1_ch_11_name);
        editTextArrayListNameIn.add(editText_in_1_ch_11_name);
        editText_in_1_ch_12_name = root.findViewById(R.id.editText_in_1_ch_12_name);
        editTextArrayListNameIn.add(editText_in_1_ch_12_name);
        editText_in_1_ch_13_name = root.findViewById(R.id.editText_in_1_ch_13_name);
        editTextArrayListNameIn.add(editText_in_1_ch_13_name);
        editText_in_1_ch_14_name = root.findViewById(R.id.editText_in_1_ch_14_name);
        editTextArrayListNameIn.add(editText_in_1_ch_14_name);
        editText_in_1_ch_15_name = root.findViewById(R.id.editText_in_1_ch_15_name);
        editTextArrayListNameIn.add(editText_in_1_ch_15_name);

        editText_in_2_ch_0_name = root.findViewById(R.id.editText_in_2_ch_0_name);
        editTextArrayListNameIn.add(editText_in_2_ch_0_name);
        editText_in_2_ch_1_name = root.findViewById(R.id.editText_in_2_ch_1_name);
        editTextArrayListNameIn.add(editText_in_2_ch_1_name);
        editText_in_2_ch_2_name = root.findViewById(R.id.editText_in_2_ch_2_name);
        editTextArrayListNameIn.add(editText_in_2_ch_2_name);
        editText_in_2_ch_3_name = root.findViewById(R.id.editText_in_2_ch_3_name);
        editTextArrayListNameIn.add(editText_in_2_ch_3_name);
        editText_in_2_ch_4_name = root.findViewById(R.id.editText_in_2_ch_4_name);
        editTextArrayListNameIn.add(editText_in_2_ch_4_name);
        editText_in_2_ch_5_name = root.findViewById(R.id.editText_in_2_ch_5_name);
        editTextArrayListNameIn.add(editText_in_2_ch_5_name);
        editText_in_2_ch_6_name = root.findViewById(R.id.editText_in_2_ch_6_name);
        editTextArrayListNameIn.add(editText_in_2_ch_6_name);
        editText_in_2_ch_7_name = root.findViewById(R.id.editText_in_2_ch_7_name);
        editTextArrayListNameIn.add(editText_in_2_ch_7_name);
        editText_in_2_ch_8_name = root.findViewById(R.id.editText_in_2_ch_8_name);
        editTextArrayListNameIn.add(editText_in_2_ch_8_name);
        editText_in_2_ch_9_name = root.findViewById(R.id.editText_in_2_ch_9_name);
        editTextArrayListNameIn.add(editText_in_2_ch_9_name);
        editText_in_2_ch_10_name = root.findViewById(R.id.editText_in_2_ch_10_name);
        editTextArrayListNameIn.add(editText_in_2_ch_10_name);
        editText_in_2_ch_11_name = root.findViewById(R.id.editText_in_2_ch_11_name);
        editTextArrayListNameIn.add(editText_in_2_ch_11_name);
        editText_in_2_ch_12_name = root.findViewById(R.id.editText_in_2_ch_12_name);
        editTextArrayListNameIn.add(editText_in_2_ch_12_name);
        editText_in_2_ch_13_name = root.findViewById(R.id.editText_in_2_ch_13_name);
        editTextArrayListNameIn.add(editText_in_2_ch_13_name);
        editText_in_2_ch_14_name = root.findViewById(R.id.editText_in_2_ch_14_name);
        editTextArrayListNameIn.add(editText_in_2_ch_14_name);
        editText_in_2_ch_15_name = root.findViewById(R.id.editText_in_2_ch_15_name);
        editTextArrayListNameIn.add(editText_in_2_ch_15_name);

        i = 0;
        for (final EditText editText: editTextArrayListNameIn) {
            editText.setText(String.valueOf(spaceSetting.getInArrayList().get(i).getName()));
            final int finalI = i;
            editText.setOnKeyListener(new View.OnKeyListener() {
                @Override
                public boolean onKey(View v, int keyCode, KeyEvent event) {
                    if(event.getAction() == KeyEvent.ACTION_DOWN && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                        String text = editText.getText().toString();
                        if (!text.equals("")) {
                            if (finalI < 16) spaceSetting.setSharedPreferences("in_0_" + finalI + "_name", text);
                            else if (finalI < 32) spaceSetting.setSharedPreferences("in_1_" + finalI + "_name", text);
                            else spaceSetting.setSharedPreferences("in_2_" + finalI + "_name", text);
                            spaceSetting.getInArrayList().get(finalI).setName(text);
                        }
                    }
                    return true;
                }
            });
            i = i + 1;
        }

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        editTextArrayListRegisterIn = new ArrayList<>();

        editText_adc_0_ch_0_register = root.findViewById(R.id.editText_adc_0_ch_0_register);
        editTextArrayListRegisterIn.add(editText_adc_0_ch_0_register);
        editText_adc_0_ch_1_register = root.findViewById(R.id.editText_adc_0_ch_1_register);
        editTextArrayListRegisterIn.add(editText_adc_0_ch_1_register);
        editText_adc_0_ch_2_register = root.findViewById(R.id.editText_adc_0_ch_2_register);
        editTextArrayListRegisterIn.add(editText_adc_0_ch_2_register);
        editText_adc_0_ch_3_register = root.findViewById(R.id.editText_adc_0_ch_3_register);
        editTextArrayListRegisterIn.add(editText_adc_0_ch_3_register);
        editText_adc_0_ch_4_register = root.findViewById(R.id.editText_adc_0_ch_4_register);
        editTextArrayListRegisterIn.add(editText_adc_0_ch_4_register);
        editText_adc_0_ch_5_register = root.findViewById(R.id.editText_adc_0_ch_5_register);
        editTextArrayListRegisterIn.add(editText_adc_0_ch_5_register);
        editText_adc_0_ch_6_register = root.findViewById(R.id.editText_adc_0_ch_6_register);
        editTextArrayListRegisterIn.add(editText_adc_0_ch_6_register);
        editText_adc_0_ch_7_register = root.findViewById(R.id.editText_adc_0_ch_7_register);
        editTextArrayListRegisterIn.add(editText_adc_0_ch_7_register);
        editText_adc_0_ch_8_register = root.findViewById(R.id.editText_adc_0_ch_8_register);
        editTextArrayListRegisterIn.add(editText_adc_0_ch_8_register);
        editText_adc_0_ch_9_register = root.findViewById(R.id.editText_adc_0_ch_9_register);
        editTextArrayListRegisterIn.add(editText_adc_0_ch_9_register);
        editText_adc_0_ch_10_register = root.findViewById(R.id.editText_adc_0_ch_10_register);
        editTextArrayListRegisterIn.add(editText_adc_0_ch_10_register);
        editText_adc_0_ch_11_register = root.findViewById(R.id.editText_adc_0_ch_11_register);
        editTextArrayListRegisterIn.add(editText_adc_0_ch_11_register);
        editText_adc_0_ch_12_register = root.findViewById(R.id.editText_adc_0_ch_12_register);
        editTextArrayListRegisterIn.add(editText_adc_0_ch_12_register);
        editText_adc_0_ch_13_register = root.findViewById(R.id.editText_adc_0_ch_13_register);
        editTextArrayListRegisterIn.add(editText_adc_0_ch_13_register);
        editText_adc_0_ch_14_register = root.findViewById(R.id.editText_adc_0_ch_14_register);
        editTextArrayListRegisterIn.add(editText_adc_0_ch_14_register);
        editText_adc_0_ch_15_register = root.findViewById(R.id.editText_adc_0_ch_15_register);
        editTextArrayListRegisterIn.add(editText_adc_0_ch_15_register);

        editText_adc_1_ch_0_register = root.findViewById(R.id.editText_adc_1_ch_0_register);
        editTextArrayListRegisterIn.add(editText_adc_1_ch_0_register);
        editText_adc_1_ch_1_register = root.findViewById(R.id.editText_adc_1_ch_1_register);
        editTextArrayListRegisterIn.add(editText_adc_1_ch_1_register);
        editText_adc_1_ch_2_register = root.findViewById(R.id.editText_adc_1_ch_2_register);
        editTextArrayListRegisterIn.add(editText_adc_1_ch_2_register);
        editText_adc_1_ch_3_register = root.findViewById(R.id.editText_adc_1_ch_3_register);
        editTextArrayListRegisterIn.add(editText_adc_1_ch_3_register);
        editText_adc_1_ch_4_register = root.findViewById(R.id.editText_adc_1_ch_4_register);
        editTextArrayListRegisterIn.add(editText_adc_1_ch_4_register);
        editText_adc_1_ch_5_register = root.findViewById(R.id.editText_adc_1_ch_5_register);
        editTextArrayListRegisterIn.add(editText_adc_1_ch_5_register);
        editText_adc_1_ch_6_register = root.findViewById(R.id.editText_adc_1_ch_6_register);
        editTextArrayListRegisterIn.add(editText_adc_1_ch_6_register);
        editText_adc_1_ch_7_register = root.findViewById(R.id.editText_adc_1_ch_7_register);
        editTextArrayListRegisterIn.add(editText_adc_1_ch_7_register);
        editText_adc_1_ch_8_register = root.findViewById(R.id.editText_adc_1_ch_8_register);
        editTextArrayListRegisterIn.add(editText_adc_1_ch_8_register);
        editText_adc_1_ch_9_register = root.findViewById(R.id.editText_adc_1_ch_9_register);
        editTextArrayListRegisterIn.add(editText_adc_1_ch_9_register);
        editText_adc_1_ch_10_register = root.findViewById(R.id.editText_adc_1_ch_10_register);
        editTextArrayListRegisterIn.add(editText_adc_1_ch_10_register);
        editText_adc_1_ch_11_register = root.findViewById(R.id.editText_adc_1_ch_11_register);
        editTextArrayListRegisterIn.add(editText_adc_1_ch_11_register);
        editText_adc_1_ch_12_register = root.findViewById(R.id.editText_adc_1_ch_12_register);
        editTextArrayListRegisterIn.add(editText_adc_1_ch_12_register);
        editText_adc_1_ch_13_register = root.findViewById(R.id.editText_adc_1_ch_13_register);
        editTextArrayListRegisterIn.add(editText_adc_1_ch_13_register);
        editText_adc_1_ch_14_register = root.findViewById(R.id.editText_adc_1_ch_14_register);
        editTextArrayListRegisterIn.add(editText_adc_1_ch_14_register);
        editText_adc_1_ch_15_register = root.findViewById(R.id.editText_adc_1_ch_15_register);
        editTextArrayListRegisterIn.add(editText_adc_1_ch_15_register);

        editText_adc_2_ch_0_register = root.findViewById(R.id.editText_adc_2_ch_0_register);
        editTextArrayListRegisterIn.add(editText_adc_2_ch_0_register);
        editText_adc_2_ch_1_register = root.findViewById(R.id.editText_adc_2_ch_1_register);
        editTextArrayListRegisterIn.add(editText_adc_2_ch_1_register);
        editText_adc_2_ch_2_register = root.findViewById(R.id.editText_adc_2_ch_2_register);
        editTextArrayListRegisterIn.add(editText_adc_2_ch_2_register);
        editText_adc_2_ch_3_register = root.findViewById(R.id.editText_adc_2_ch_3_register);
        editTextArrayListRegisterIn.add(editText_adc_2_ch_3_register);
        editText_adc_2_ch_4_register = root.findViewById(R.id.editText_adc_2_ch_4_register);
        editTextArrayListRegisterIn.add(editText_adc_2_ch_4_register);
        editText_adc_2_ch_5_register = root.findViewById(R.id.editText_adc_2_ch_5_register);
        editTextArrayListRegisterIn.add(editText_adc_2_ch_5_register);
        editText_adc_2_ch_6_register = root.findViewById(R.id.editText_adc_2_ch_6_register);
        editTextArrayListRegisterIn.add(editText_adc_2_ch_6_register);
        editText_adc_2_ch_7_register = root.findViewById(R.id.editText_adc_2_ch_7_register);
        editTextArrayListRegisterIn.add(editText_adc_2_ch_7_register);
        editText_adc_2_ch_8_register = root.findViewById(R.id.editText_adc_2_ch_8_register);
        editTextArrayListRegisterIn.add(editText_adc_2_ch_8_register);
        editText_adc_2_ch_9_register = root.findViewById(R.id.editText_adc_2_ch_9_register);
        editTextArrayListRegisterIn.add(editText_adc_2_ch_9_register);
        editText_adc_2_ch_10_register = root.findViewById(R.id.editText_adc_2_ch_10_register);
        editTextArrayListRegisterIn.add(editText_adc_2_ch_10_register);
        editText_adc_2_ch_11_register = root.findViewById(R.id.editText_adc_2_ch_11_register);
        editTextArrayListRegisterIn.add(editText_adc_2_ch_11_register);
        editText_adc_2_ch_12_register = root.findViewById(R.id.editText_adc_2_ch_12_register);
        editTextArrayListRegisterIn.add(editText_adc_2_ch_12_register);
        editText_adc_2_ch_13_register = root.findViewById(R.id.editText_adc_2_ch_13_register);
        editTextArrayListRegisterIn.add(editText_adc_2_ch_13_register);
        editText_adc_2_ch_14_register = root.findViewById(R.id.editText_adc_2_ch_14_register);
        editTextArrayListRegisterIn.add(editText_adc_2_ch_14_register);
        editText_adc_2_ch_15_register = root.findViewById(R.id.editText_adc_2_ch_15_register);
        editTextArrayListRegisterIn.add(editText_adc_2_ch_15_register);

        i = 0;
        for (final EditText editText: editTextArrayListRegisterIn) {
            editText.setText(String.valueOf(spaceSetting.getInArrayList().get(i).getRegister()));
            final int finalI = i;
            editText.setOnKeyListener(new View.OnKeyListener() {
                @Override
                public boolean onKey(View v, int keyCode, KeyEvent event) {
                    if(event.getAction() == KeyEvent.ACTION_DOWN && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                        String text = editText.getText().toString();
                        if (!text.equals("")) {
                            int register = Integer.parseInt(text);
                            if (finalI < 16) spaceSetting.setSharedPreferences("in_0_" + finalI + "_register", register);
                            else if (finalI < 32) spaceSetting.setSharedPreferences("in_1_" + finalI + "_register", register);
                            else spaceSetting.setSharedPreferences("in_2_" + finalI + "_register", register);
                            spaceSetting.getInArrayList().get(finalI).setRegister(register);
                        }
                    }
                    return true;
                }
            });
            i = i + 1;
        }

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        switchArrayListEnableIn = new ArrayList<>();

        switch_acd_0_ch_0_enable = root.findViewById(R.id.switch_adc_0_ch_0_enable);
        switchArrayListEnableIn.add(switch_acd_0_ch_0_enable);
        switch_acd_0_ch_1_enable = root.findViewById(R.id.switch_adc_0_ch_1_enable);
        switchArrayListEnableIn.add(switch_acd_0_ch_1_enable);
        switch_acd_0_ch_2_enable = root.findViewById(R.id.switch_adc_0_ch_2_enable);
        switchArrayListEnableIn.add(switch_acd_0_ch_2_enable);
        switch_acd_0_ch_3_enable = root.findViewById(R.id.switch_adc_0_ch_3_enable);
        switchArrayListEnableIn.add(switch_acd_0_ch_3_enable);
        switch_acd_0_ch_4_enable = root.findViewById(R.id.switch_adc_0_ch_4_enable);
        switchArrayListEnableIn.add(switch_acd_0_ch_4_enable);
        switch_acd_0_ch_5_enable = root.findViewById(R.id.switch_adc_0_ch_5_enable);
        switchArrayListEnableIn.add(switch_acd_0_ch_5_enable);
        switch_acd_0_ch_6_enable = root.findViewById(R.id.switch_adc_0_ch_6_enable);
        switchArrayListEnableIn.add(switch_acd_0_ch_6_enable);
        switch_acd_0_ch_7_enable = root.findViewById(R.id.switch_adc_0_ch_7_enable);
        switchArrayListEnableIn.add(switch_acd_0_ch_7_enable);
        switch_acd_0_ch_8_enable = root.findViewById(R.id.switch_adc_0_ch_8_enable);
        switchArrayListEnableIn.add(switch_acd_0_ch_8_enable);
        switch_acd_0_ch_9_enable = root.findViewById(R.id.switch_adc_0_ch_9_enable);
        switchArrayListEnableIn.add(switch_acd_0_ch_9_enable);
        switch_acd_0_ch_10_enable = root.findViewById(R.id.switch_adc_0_ch_10_enable);
        switchArrayListEnableIn.add(switch_acd_0_ch_10_enable);
        switch_acd_0_ch_11_enable = root.findViewById(R.id.switch_adc_0_ch_11_enable);
        switchArrayListEnableIn.add(switch_acd_0_ch_11_enable);
        switch_acd_0_ch_12_enable = root.findViewById(R.id.switch_adc_0_ch_12_enable);
        switchArrayListEnableIn.add(switch_acd_0_ch_12_enable);
        switch_acd_0_ch_13_enable = root.findViewById(R.id.switch_adc_0_ch_13_enable);
        switchArrayListEnableIn.add(switch_acd_0_ch_13_enable);
        switch_acd_0_ch_14_enable = root.findViewById(R.id.switch_adc_0_ch_14_enable);
        switchArrayListEnableIn.add(switch_acd_0_ch_14_enable);
        switch_acd_0_ch_15_enable = root.findViewById(R.id.switch_adc_0_ch_15_enable);
        switchArrayListEnableIn.add(switch_acd_0_ch_15_enable);

        switch_acd_1_ch_0_enable = root.findViewById(R.id.switch_adc_1_ch_0_enable);
        switchArrayListEnableIn.add(switch_acd_1_ch_0_enable);
        switch_acd_1_ch_1_enable = root.findViewById(R.id.switch_adc_1_ch_1_enable);
        switchArrayListEnableIn.add(switch_acd_1_ch_1_enable);
        switch_acd_1_ch_2_enable = root.findViewById(R.id.switch_adc_1_ch_2_enable);
        switchArrayListEnableIn.add(switch_acd_1_ch_2_enable);
        switch_acd_1_ch_3_enable = root.findViewById(R.id.switch_adc_1_ch_3_enable);
        switchArrayListEnableIn.add(switch_acd_1_ch_3_enable);
        switch_acd_1_ch_4_enable = root.findViewById(R.id.switch_adc_1_ch_4_enable);
        switchArrayListEnableIn.add(switch_acd_1_ch_4_enable);
        switch_acd_1_ch_5_enable = root.findViewById(R.id.switch_adc_1_ch_5_enable);
        switchArrayListEnableIn.add(switch_acd_1_ch_5_enable);
        switch_acd_1_ch_6_enable = root.findViewById(R.id.switch_adc_1_ch_6_enable);
        switchArrayListEnableIn.add(switch_acd_1_ch_6_enable);
        switch_acd_1_ch_7_enable = root.findViewById(R.id.switch_adc_1_ch_7_enable);
        switchArrayListEnableIn.add(switch_acd_1_ch_7_enable);
        switch_acd_1_ch_8_enable = root.findViewById(R.id.switch_adc_1_ch_8_enable);
        switchArrayListEnableIn.add(switch_acd_1_ch_8_enable);
        switch_acd_1_ch_9_enable = root.findViewById(R.id.switch_adc_1_ch_9_enable);
        switchArrayListEnableIn.add(switch_acd_1_ch_9_enable);
        switch_acd_1_ch_10_enable = root.findViewById(R.id.switch_adc_1_ch_10_enable);
        switchArrayListEnableIn.add(switch_acd_1_ch_10_enable);
        switch_acd_1_ch_11_enable = root.findViewById(R.id.switch_adc_1_ch_11_enable);
        switchArrayListEnableIn.add(switch_acd_1_ch_11_enable);
        switch_acd_1_ch_12_enable = root.findViewById(R.id.switch_adc_1_ch_12_enable);
        switchArrayListEnableIn.add(switch_acd_1_ch_12_enable);
        switch_acd_1_ch_13_enable = root.findViewById(R.id.switch_adc_1_ch_13_enable);
        switchArrayListEnableIn.add(switch_acd_1_ch_13_enable);
        switch_acd_1_ch_14_enable = root.findViewById(R.id.switch_adc_1_ch_14_enable);
        switchArrayListEnableIn.add(switch_acd_1_ch_14_enable);
        switch_acd_1_ch_15_enable = root.findViewById(R.id.switch_adc_1_ch_15_enable);
        switchArrayListEnableIn.add(switch_acd_1_ch_15_enable);

        switch_acd_2_ch_0_enable = root.findViewById(R.id.switch_adc_2_ch_0_enable);
        switchArrayListEnableIn.add(switch_acd_2_ch_0_enable);
        switch_acd_2_ch_1_enable = root.findViewById(R.id.switch_adc_2_ch_1_enable);
        switchArrayListEnableIn.add(switch_acd_2_ch_1_enable);
        switch_acd_2_ch_2_enable = root.findViewById(R.id.switch_adc_2_ch_2_enable);
        switchArrayListEnableIn.add(switch_acd_2_ch_2_enable);
        switch_acd_2_ch_3_enable = root.findViewById(R.id.switch_adc_2_ch_3_enable);
        switchArrayListEnableIn.add(switch_acd_2_ch_3_enable);
        switch_acd_2_ch_4_enable = root.findViewById(R.id.switch_adc_2_ch_4_enable);
        switchArrayListEnableIn.add(switch_acd_2_ch_4_enable);
        switch_acd_2_ch_5_enable = root.findViewById(R.id.switch_adc_2_ch_5_enable);
        switchArrayListEnableIn.add(switch_acd_2_ch_5_enable);
        switch_acd_2_ch_6_enable = root.findViewById(R.id.switch_adc_2_ch_6_enable);
        switchArrayListEnableIn.add(switch_acd_2_ch_6_enable);
        switch_acd_2_ch_7_enable = root.findViewById(R.id.switch_adc_2_ch_7_enable);
        switchArrayListEnableIn.add(switch_acd_2_ch_7_enable);
        switch_acd_2_ch_8_enable = root.findViewById(R.id.switch_adc_2_ch_8_enable);
        switchArrayListEnableIn.add(switch_acd_2_ch_8_enable);
        switch_acd_2_ch_9_enable = root.findViewById(R.id.switch_adc_2_ch_9_enable);
        switchArrayListEnableIn.add(switch_acd_2_ch_9_enable);
        switch_acd_2_ch_10_enable = root.findViewById(R.id.switch_adc_2_ch_10_enable);
        switchArrayListEnableIn.add(switch_acd_2_ch_10_enable);
        switch_acd_2_ch_11_enable = root.findViewById(R.id.switch_adc_2_ch_11_enable);
        switchArrayListEnableIn.add(switch_acd_2_ch_11_enable);
        switch_acd_2_ch_12_enable = root.findViewById(R.id.switch_adc_2_ch_12_enable);
        switchArrayListEnableIn.add(switch_acd_2_ch_12_enable);
        switch_acd_2_ch_13_enable = root.findViewById(R.id.switch_adc_2_ch_13_enable);
        switchArrayListEnableIn.add(switch_acd_2_ch_13_enable);
        switch_acd_2_ch_14_enable = root.findViewById(R.id.switch_adc_2_ch_14_enable);
        switchArrayListEnableIn.add(switch_acd_2_ch_14_enable);
        switch_acd_2_ch_15_enable = root.findViewById(R.id.switch_adc_2_ch_15_enable);
        switchArrayListEnableIn.add(switch_acd_2_ch_15_enable);

        i = 0;
        for (final Switch switchFromList: switchArrayListEnableIn) {
            switchFromList.setChecked(spaceSetting.getInArrayList().get(i).isEnable());
            final int finalI = i;
            switchFromList.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (switchFromList.isChecked()) {
                        spaceSetting.getInArrayList().get(finalI).setEnable(true);
                        if (finalI < 16) spaceSetting.setSharedPreferences("in_0_" + finalI + "_enable", true);
                        else if (finalI < 32) spaceSetting.setSharedPreferences("in_1_" + finalI + "_enable", true);
                        else spaceSetting.setSharedPreferences("in_2_" + finalI + "_enable", true);
                    }
                    else {
                        spaceSetting.getInArrayList().get(finalI).setEnable(false);
                        if (finalI < 16) spaceSetting.setSharedPreferences("in_0_" + finalI + "_enable", false);
                        else if (finalI < 32) spaceSetting.setSharedPreferences("in_1_" + finalI + "_enable", false);
                        else spaceSetting.setSharedPreferences("in_2_" + finalI + "_enable", false);
                    }
                }
            });
            i = i + 1;
        }

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
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
