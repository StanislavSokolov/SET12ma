package com.example.set12ma.ui.main;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import com.example.set12ma.R;

import java.util.ArrayList;

public class FragmentADC extends Fragment {
    private static final String ARG_SECTION_NUMBER = "ADC";

    private int startCellNumber = 96;
    private int stopCellNumber = 208;

    private ArrayList<Button> arrayListButton;
    private ArrayList<TextView> arrayListTextView;
    private SpaceAddress spaceAddress;
    private ResultReceiverAddressSpace resultReceiverAddressSpace;

    private UpDateGraphicalDisplay upDateGraphicalDisplay;
    private long timer = 500;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        resultReceiverAddressSpace = (ResultReceiverAddressSpace) context;
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
        upDateGraphicalDisplay = new UpDateGraphicalDisplay();
        upDateGraphicalDisplay.start();
        spaceAddress = resultReceiverAddressSpace.getSpaceAddress();
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_adc, container, false);

        arrayListTextView = new ArrayList<>();
        arrayListButton = new ArrayList<>();

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

        upDateValues();

        return root;
    }

    public void upDateValues() {
        for (int i = 0; i < 48; i++) {
            arrayListTextView.get(i).setText(String.valueOf(spaceAddress.getAddressSpace(stopCellNumber + i)));
            if (spaceAddress.getAddressSpace(startCellNumber + i) > 0)
                arrayListButton.get(i).setBackgroundColor(Color.RED);
            else arrayListButton.get(i).setBackgroundColor(Color.GREEN);
        }
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
                    e.printStackTrace();
                }
            }
        }

        public UpDateGraphicalDisplay() {
        }
    }
}
