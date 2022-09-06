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

public class FragmentInput extends Fragment {
    private static final String ARG_SECTION_NUMBER = "Input";

    private int startCellNumber = 0;
    private int stopCellNumber = 48;

    private ArrayList<Button> arrayListButton;
    private ArrayList<TextView> arrayListText;
    private SpaceAddress spaceAddress;
    private SpaceSetting spaceSetting;
    private ResultReceiverAddressSpace resultReceiverAddressSpace;
    private ResultReceiverSettingSpace resultReceiverSettingSpace;

    private UpDateGraphicalDisplay upDateGraphicalDisplay;
    private long timer = 500;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        resultReceiverAddressSpace = (ResultReceiverAddressSpace) context;
        resultReceiverSettingSpace = (ResultReceiverSettingSpace) context;
    }

    private PageViewModel pageViewModel;

    public static FragmentInput newInstance(int index) {
        FragmentInput fragment = new FragmentInput();
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
        spaceSetting = resultReceiverSettingSpace.getSpaceSetting();
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_input, container, false);

        arrayListButton = new ArrayList<>();
        arrayListText = new ArrayList<>();

        Button indicator_button_in_0_0 = root.findViewById(R.id.indicator_button_in_0_0);
        arrayListButton.add(indicator_button_in_0_0);
        Button indicator_button_in_0_1 = root.findViewById(R.id.indicator_button_in_0_1);
        arrayListButton.add(indicator_button_in_0_1);
        Button indicator_button_in_0_2 = root.findViewById(R.id.indicator_button_in_0_2);
        arrayListButton.add(indicator_button_in_0_2);
        Button indicator_button_in_0_3 = root.findViewById(R.id.indicator_button_in_0_3);
        arrayListButton.add(indicator_button_in_0_3);
        Button indicator_button_in_0_4 = root.findViewById(R.id.indicator_button_in_0_4);
        arrayListButton.add(indicator_button_in_0_4);
        Button indicator_button_in_0_5 = root.findViewById(R.id.indicator_button_in_0_5);
        arrayListButton.add(indicator_button_in_0_5);
        Button indicator_button_in_0_6 = root.findViewById(R.id.indicator_button_in_0_6);
        arrayListButton.add(indicator_button_in_0_6);
        Button indicator_button_in_0_7 = root.findViewById(R.id.indicator_button_in_0_7);
        arrayListButton.add(indicator_button_in_0_7);
        Button indicator_button_in_0_8 = root.findViewById(R.id.indicator_button_in_0_8);
        arrayListButton.add(indicator_button_in_0_8);
        Button indicator_button_in_0_9 = root.findViewById(R.id.indicator_button_in_0_9);
        arrayListButton.add(indicator_button_in_0_9);
        Button indicator_button_in_0_10 = root.findViewById(R.id.indicator_button_in_0_10);
        arrayListButton.add(indicator_button_in_0_10);
        Button indicator_button_in_0_11 = root.findViewById(R.id.indicator_button_in_0_11);
        arrayListButton.add(indicator_button_in_0_11);
        Button indicator_button_in_0_12 = root.findViewById(R.id.indicator_button_in_0_12);
        arrayListButton.add(indicator_button_in_0_12);
        Button indicator_button_in_0_13 = root.findViewById(R.id.indicator_button_in_0_13);
        arrayListButton.add(indicator_button_in_0_13);
        Button indicator_button_in_0_14 = root.findViewById(R.id.indicator_button_in_0_14);
        arrayListButton.add(indicator_button_in_0_14);
        Button indicator_button_in_0_15 = root.findViewById(R.id.indicator_button_in_0_15);
        arrayListButton.add(indicator_button_in_0_15);

        Button indicator_button_in_1_0 = root.findViewById(R.id.indicator_button_in_1_0);
        arrayListButton.add(indicator_button_in_1_0);
        Button indicator_button_in_1_1 = root.findViewById(R.id.indicator_button_in_1_1);
        arrayListButton.add(indicator_button_in_1_1);
        Button indicator_button_in_1_2 = root.findViewById(R.id.indicator_button_in_1_2);
        arrayListButton.add(indicator_button_in_1_2);
        Button indicator_button_in_1_3 = root.findViewById(R.id.indicator_button_in_1_3);
        arrayListButton.add(indicator_button_in_1_3);
        Button indicator_button_in_1_4 = root.findViewById(R.id.indicator_button_in_1_4);
        arrayListButton.add(indicator_button_in_1_4);
        Button indicator_button_in_1_5 = root.findViewById(R.id.indicator_button_in_1_5);
        arrayListButton.add(indicator_button_in_1_5);
        Button indicator_button_in_1_6 = root.findViewById(R.id.indicator_button_in_1_6);
        arrayListButton.add(indicator_button_in_1_6);
        Button indicator_button_in_1_7 = root.findViewById(R.id.indicator_button_in_1_7);
        arrayListButton.add(indicator_button_in_1_7);
        Button indicator_button_in_1_8 = root.findViewById(R.id.indicator_button_in_1_8);
        arrayListButton.add(indicator_button_in_1_8);
        Button indicator_button_in_1_9 = root.findViewById(R.id.indicator_button_in_1_9);
        arrayListButton.add(indicator_button_in_1_9);
        Button indicator_button_in_1_10 = root.findViewById(R.id.indicator_button_in_1_10);
        arrayListButton.add(indicator_button_in_1_10);
        Button indicator_button_in_1_11 = root.findViewById(R.id.indicator_button_in_1_11);
        arrayListButton.add(indicator_button_in_1_11);
        Button indicator_button_in_1_12 = root.findViewById(R.id.indicator_button_in_1_12);
        arrayListButton.add(indicator_button_in_1_12);
        Button indicator_button_in_1_13 = root.findViewById(R.id.indicator_button_in_1_13);
        arrayListButton.add(indicator_button_in_1_13);
        Button indicator_button_in_1_14 = root.findViewById(R.id.indicator_button_in_1_14);
        arrayListButton.add(indicator_button_in_1_14);
        Button indicator_button_in_1_15 = root.findViewById(R.id.indicator_button_in_1_15);
        arrayListButton.add(indicator_button_in_1_15);

        Button indicator_button_in_2_0 = root.findViewById(R.id.indicator_button_in_2_0);
        arrayListButton.add(indicator_button_in_2_0);
        Button indicator_button_in_2_1 = root.findViewById(R.id.indicator_button_in_2_1);
        arrayListButton.add(indicator_button_in_2_1);
        Button indicator_button_in_2_2 = root.findViewById(R.id.indicator_button_in_2_2);
        arrayListButton.add(indicator_button_in_2_2);
        Button indicator_button_in_2_3 = root.findViewById(R.id.indicator_button_in_2_3);
        arrayListButton.add(indicator_button_in_2_3);
        Button indicator_button_in_2_4 = root.findViewById(R.id.indicator_button_in_2_4);
        arrayListButton.add(indicator_button_in_2_4);
        Button indicator_button_in_2_5 = root.findViewById(R.id.indicator_button_in_2_5);
        arrayListButton.add(indicator_button_in_2_5);
        Button indicator_button_in_2_6 = root.findViewById(R.id.indicator_button_in_2_6);
        arrayListButton.add(indicator_button_in_2_6);
        Button indicator_button_in_2_7 = root.findViewById(R.id.indicator_button_in_2_7);
        arrayListButton.add(indicator_button_in_2_7);
        Button indicator_button_in_2_8 = root.findViewById(R.id.indicator_button_in_2_8);
        arrayListButton.add(indicator_button_in_2_8);
        Button indicator_button_in_2_9 = root.findViewById(R.id.indicator_button_in_2_9);
        arrayListButton.add(indicator_button_in_2_9);
        Button indicator_button_in_2_10 = root.findViewById(R.id.indicator_button_in_2_10);
        arrayListButton.add(indicator_button_in_2_10);
        Button indicator_button_in_2_11 = root.findViewById(R.id.indicator_button_in_2_11);
        arrayListButton.add(indicator_button_in_2_11);
        Button indicator_button_in_2_12 = root.findViewById(R.id.indicator_button_in_2_12);
        arrayListButton.add(indicator_button_in_2_12);
        Button indicator_button_in_2_13 = root.findViewById(R.id.indicator_button_in_2_13);
        arrayListButton.add(indicator_button_in_2_13);
        Button indicator_button_in_2_14 = root.findViewById(R.id.indicator_button_in_2_14);
        arrayListButton.add(indicator_button_in_2_14);
        Button indicator_button_in_2_15 = root.findViewById(R.id.indicator_button_in_2_15);
        arrayListButton.add(indicator_button_in_2_15);

        TextView textViewIn_0_0 = root.findViewById(R.id.textView_in_0_0);
        arrayListText.add(textViewIn_0_0);
        TextView textViewIn_0_1 = root.findViewById(R.id.textView_in_0_1);
        arrayListText.add(textViewIn_0_1);
        TextView textViewIn_0_2 = root.findViewById(R.id.textView_in_0_2);
        arrayListText.add(textViewIn_0_2);
        TextView textViewIn_0_3 = root.findViewById(R.id.textView_in_0_3);
        arrayListText.add(textViewIn_0_3);
        TextView textViewIn_0_4 = root.findViewById(R.id.textView_in_0_4);
        arrayListText.add(textViewIn_0_4);
        TextView textViewIn_0_5 = root.findViewById(R.id.textView_in_0_5);
        arrayListText.add(textViewIn_0_5);
        TextView textViewIn_0_6 = root.findViewById(R.id.textView_in_0_6);
        arrayListText.add(textViewIn_0_6);
        TextView textViewIn_0_7 = root.findViewById(R.id.textView_in_0_7);
        arrayListText.add(textViewIn_0_7);
        TextView textViewIn_0_8 = root.findViewById(R.id.textView_in_0_8);
        arrayListText.add(textViewIn_0_8);
        TextView textViewIn_0_9 = root.findViewById(R.id.textView_in_0_9);
        arrayListText.add(textViewIn_0_9);
        TextView textViewIn_0_10 = root.findViewById(R.id.textView_in_0_10);
        arrayListText.add(textViewIn_0_10);
        TextView textViewIn_0_11 = root.findViewById(R.id.textView_in_0_11);
        arrayListText.add(textViewIn_0_11);
        TextView textViewIn_0_12 = root.findViewById(R.id.textView_in_0_12);
        arrayListText.add(textViewIn_0_12);
        TextView textViewIn_0_13 = root.findViewById(R.id.textView_in_0_13);
        arrayListText.add(textViewIn_0_13);
        TextView textViewIn_0_14 = root.findViewById(R.id.textView_in_0_14);
        arrayListText.add(textViewIn_0_14);
        TextView textViewIn_0_15 = root.findViewById(R.id.textView_in_0_15);
        arrayListText.add(textViewIn_0_15);

        TextView textViewIn_1_0 = root.findViewById(R.id.textView_in_1_0);
        arrayListText.add(textViewIn_1_0);
        TextView textViewIn_1_1 = root.findViewById(R.id.textView_in_1_1);
        arrayListText.add(textViewIn_1_1);
        TextView textViewIn_1_2 = root.findViewById(R.id.textView_in_1_2);
        arrayListText.add(textViewIn_1_2);
        TextView textViewIn_1_3 = root.findViewById(R.id.textView_in_1_3);
        arrayListText.add(textViewIn_1_3);
        TextView textViewIn_1_4 = root.findViewById(R.id.textView_in_1_4);
        arrayListText.add(textViewIn_1_4);
        TextView textViewIn_1_5 = root.findViewById(R.id.textView_in_1_5);
        arrayListText.add(textViewIn_1_5);
        TextView textViewIn_1_6 = root.findViewById(R.id.textView_in_1_6);
        arrayListText.add(textViewIn_1_6);
        TextView textViewIn_1_7 = root.findViewById(R.id.textView_in_1_7);
        arrayListText.add(textViewIn_1_7);
        TextView textViewIn_1_8 = root.findViewById(R.id.textView_in_1_8);
        arrayListText.add(textViewIn_1_8);
        TextView textViewIn_1_9 = root.findViewById(R.id.textView_in_1_9);
        arrayListText.add(textViewIn_1_9);
        TextView textViewIn_1_10 = root.findViewById(R.id.textView_in_1_10);
        arrayListText.add(textViewIn_1_10);
        TextView textViewIn_1_11 = root.findViewById(R.id.textView_in_1_11);
        arrayListText.add(textViewIn_1_11);
        TextView textViewIn_1_12 = root.findViewById(R.id.textView_in_1_12);
        arrayListText.add(textViewIn_1_12);
        TextView textViewIn_1_13 = root.findViewById(R.id.textView_in_1_13);
        arrayListText.add(textViewIn_1_13);
        TextView textViewIn_1_14 = root.findViewById(R.id.textView_in_1_14);
        arrayListText.add(textViewIn_1_14);
        TextView textViewIn_1_15 = root.findViewById(R.id.textView_in_1_15);
        arrayListText.add(textViewIn_1_15);

        TextView textViewIn_2_0 = root.findViewById(R.id.textView_in_2_0);
        arrayListText.add(textViewIn_2_0);
        TextView textViewIn_2_1 = root.findViewById(R.id.textView_in_2_1);
        arrayListText.add(textViewIn_2_1);
        TextView textViewIn_2_2 = root.findViewById(R.id.textView_in_2_2);
        arrayListText.add(textViewIn_2_2);
        TextView textViewIn_2_3 = root.findViewById(R.id.textView_in_2_3);
        arrayListText.add(textViewIn_2_3);
        TextView textViewIn_2_4 = root.findViewById(R.id.textView_in_2_4);
        arrayListText.add(textViewIn_2_4);
        TextView textViewIn_2_5 = root.findViewById(R.id.textView_in_2_5);
        arrayListText.add(textViewIn_2_5);
        TextView textViewIn_2_6 = root.findViewById(R.id.textView_in_2_6);
        arrayListText.add(textViewIn_2_6);
        TextView textViewIn_2_7 = root.findViewById(R.id.textView_in_2_7);
        arrayListText.add(textViewIn_2_7);
        TextView textViewIn_2_8 = root.findViewById(R.id.textView_in_2_8);
        arrayListText.add(textViewIn_2_8);
        TextView textViewIn_2_9 = root.findViewById(R.id.textView_in_2_9);
        arrayListText.add(textViewIn_2_9);
        TextView textViewIn_2_10 = root.findViewById(R.id.textView_in_2_10);
        arrayListText.add(textViewIn_2_10);
        TextView textViewIn_2_11 = root.findViewById(R.id.textView_in_2_11);
        arrayListText.add(textViewIn_2_11);
        TextView textViewIn_2_12 = root.findViewById(R.id.textView_in_2_12);
        arrayListText.add(textViewIn_2_12);
        TextView textViewIn_2_13 = root.findViewById(R.id.textView_in_2_13);
        arrayListText.add(textViewIn_2_13);
        TextView textViewIn_2_14 = root.findViewById(R.id.textView_in_2_14);
        arrayListText.add(textViewIn_2_14);
        TextView textViewIn_2_15 = root.findViewById(R.id.textView_in_2_15);
        arrayListText.add(textViewIn_2_15);


        upDateValues();

        upDateGraphicalDisplay = new UpDateGraphicalDisplay();
        upDateGraphicalDisplay.start();

        return root;
    }

    @Override
    public void onPause() {
        super.onPause();
//        upDateGraphicalDisplay.interrupt();
    }

    public void upDateValues() {
        for (int i = 0; i < stopCellNumber; i++) {
            if (spaceAddress.getAddressSpace(startCellNumber + i) == 0)
                arrayListButton.get(i).setBackgroundColor(Color.RED);
            else arrayListButton.get(i).setBackgroundColor(Color.GREEN);
        }
        int j = 0;
        for (TextView textView: arrayListText) {
            textView.setText(spaceSetting.getInArrayList().get(j).getName());
            j = j + 1;
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
                    break;
                }
            }
        }

        public UpDateGraphicalDisplay() {
        }
    }
}
