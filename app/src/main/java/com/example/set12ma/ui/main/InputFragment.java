package com.example.set12ma.ui.main;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Switch;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import com.example.set12ma.R;

import java.util.ArrayList;

public class InputFragment extends Fragment {
    private static final String ARG_SECTION_NUMBER = "Input";

    private int startCellNumber = 0;
    private int stopCellNumber = 48;

    private ArrayList<Button> arrayList;
    private AddressSpace addressSpace;
    private ResultReceiver resultReceiver;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        resultReceiver = (ResultReceiver) context;
    }

    private PageViewModel pageViewModel;

    public static InputFragment newInstance(int index) {
        InputFragment fragment = new InputFragment();
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
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_input, container, false);

        arrayList = new ArrayList<>();


        Button indicator_button_in_0_0 = root.findViewById(R.id.indicator_button_in_0_0);
        arrayList.add(indicator_button_in_0_0);
        Button indicator_button_in_0_1 = root.findViewById(R.id.indicator_button_in_0_1);
        arrayList.add(indicator_button_in_0_1);
        Button indicator_button_in_0_2 = root.findViewById(R.id.indicator_button_in_0_2);
        arrayList.add(indicator_button_in_0_2);
        Button indicator_button_in_0_3 = root.findViewById(R.id.indicator_button_in_0_3);
        arrayList.add(indicator_button_in_0_3);
        Button indicator_button_in_0_4 = root.findViewById(R.id.indicator_button_in_0_4);
        arrayList.add(indicator_button_in_0_4);
        Button indicator_button_in_0_5 = root.findViewById(R.id.indicator_button_in_0_5);
        arrayList.add(indicator_button_in_0_5);
        Button indicator_button_in_0_6 = root.findViewById(R.id.indicator_button_in_0_6);
        arrayList.add(indicator_button_in_0_6);
        Button indicator_button_in_0_7 = root.findViewById(R.id.indicator_button_in_0_7);
        arrayList.add(indicator_button_in_0_7);
        Button indicator_button_in_0_8 = root.findViewById(R.id.indicator_button_in_0_8);
        arrayList.add(indicator_button_in_0_8);
        Button indicator_button_in_0_9 = root.findViewById(R.id.indicator_button_in_0_9);
        arrayList.add(indicator_button_in_0_9);
        Button indicator_button_in_0_10 = root.findViewById(R.id.indicator_button_in_0_10);
        arrayList.add(indicator_button_in_0_10);
        Button indicator_button_in_0_11 = root.findViewById(R.id.indicator_button_in_0_11);
        arrayList.add(indicator_button_in_0_11);
        Button indicator_button_in_0_12 = root.findViewById(R.id.indicator_button_in_0_12);
        arrayList.add(indicator_button_in_0_12);
        Button indicator_button_in_0_13 = root.findViewById(R.id.indicator_button_in_0_13);
        arrayList.add(indicator_button_in_0_13);
        Button indicator_button_in_0_14 = root.findViewById(R.id.indicator_button_in_0_14);
        arrayList.add(indicator_button_in_0_14);
        Button indicator_button_in_0_15 = root.findViewById(R.id.indicator_button_in_0_15);
        arrayList.add(indicator_button_in_0_15);

        Button indicator_button_in_1_0 = root.findViewById(R.id.indicator_button_in_1_0);
        arrayList.add(indicator_button_in_1_0);
        Button indicator_button_in_1_1 = root.findViewById(R.id.indicator_button_in_1_1);
        arrayList.add(indicator_button_in_1_1);
        Button indicator_button_in_1_2 = root.findViewById(R.id.indicator_button_in_1_2);
        arrayList.add(indicator_button_in_1_2);
        Button indicator_button_in_1_3 = root.findViewById(R.id.indicator_button_in_1_3);
        arrayList.add(indicator_button_in_1_3);
        Button indicator_button_in_1_4 = root.findViewById(R.id.indicator_button_in_1_4);
        arrayList.add(indicator_button_in_1_4);
        Button indicator_button_in_1_5 = root.findViewById(R.id.indicator_button_in_1_5);
        arrayList.add(indicator_button_in_1_5);
        Button indicator_button_in_1_6 = root.findViewById(R.id.indicator_button_in_1_6);
        arrayList.add(indicator_button_in_1_6);
        Button indicator_button_in_1_7 = root.findViewById(R.id.indicator_button_in_1_7);
        arrayList.add(indicator_button_in_1_7);
        Button indicator_button_in_1_8 = root.findViewById(R.id.indicator_button_in_1_8);
        arrayList.add(indicator_button_in_1_8);
        Button indicator_button_in_1_9 = root.findViewById(R.id.indicator_button_in_1_9);
        arrayList.add(indicator_button_in_1_9);
        Button indicator_button_in_1_10 = root.findViewById(R.id.indicator_button_in_1_10);
        arrayList.add(indicator_button_in_1_10);
        Button indicator_button_in_1_11 = root.findViewById(R.id.indicator_button_in_1_11);
        arrayList.add(indicator_button_in_1_11);
        Button indicator_button_in_1_12 = root.findViewById(R.id.indicator_button_in_1_12);
        arrayList.add(indicator_button_in_1_12);
        Button indicator_button_in_1_13 = root.findViewById(R.id.indicator_button_in_1_13);
        arrayList.add(indicator_button_in_1_13);
        Button indicator_button_in_1_14 = root.findViewById(R.id.indicator_button_in_1_14);
        arrayList.add(indicator_button_in_1_14);
        Button indicator_button_in_1_15 = root.findViewById(R.id.indicator_button_in_1_15);
        arrayList.add(indicator_button_in_1_15);

        Button indicator_button_in_2_0 = root.findViewById(R.id.indicator_button_in_2_0);
        arrayList.add(indicator_button_in_2_0);
        Button indicator_button_in_2_1 = root.findViewById(R.id.indicator_button_in_2_1);
        arrayList.add(indicator_button_in_2_1);
        Button indicator_button_in_2_2 = root.findViewById(R.id.indicator_button_in_2_2);
        arrayList.add(indicator_button_in_2_2);
        Button indicator_button_in_2_3 = root.findViewById(R.id.indicator_button_in_2_3);
        arrayList.add(indicator_button_in_2_3);
        Button indicator_button_in_2_4 = root.findViewById(R.id.indicator_button_in_2_4);
        arrayList.add(indicator_button_in_2_4);
        Button indicator_button_in_2_5 = root.findViewById(R.id.indicator_button_in_2_5);
        arrayList.add(indicator_button_in_2_5);
        Button indicator_button_in_2_6 = root.findViewById(R.id.indicator_button_in_2_6);
        arrayList.add(indicator_button_in_2_6);
        Button indicator_button_in_2_7 = root.findViewById(R.id.indicator_button_in_2_7);
        arrayList.add(indicator_button_in_2_7);
        Button indicator_button_in_2_8 = root.findViewById(R.id.indicator_button_in_2_8);
        arrayList.add(indicator_button_in_2_8);
        Button indicator_button_in_2_9 = root.findViewById(R.id.indicator_button_in_2_9);
        arrayList.add(indicator_button_in_2_9);
        Button indicator_button_in_2_10 = root.findViewById(R.id.indicator_button_in_2_10);
        arrayList.add(indicator_button_in_2_10);
        Button indicator_button_in_2_11 = root.findViewById(R.id.indicator_button_in_2_11);
        arrayList.add(indicator_button_in_2_11);
        Button indicator_button_in_2_12 = root.findViewById(R.id.indicator_button_in_2_12);
        arrayList.add(indicator_button_in_2_12);
        Button indicator_button_in_2_13 = root.findViewById(R.id.indicator_button_in_2_13);
        arrayList.add(indicator_button_in_2_13);
        Button indicator_button_in_2_14 = root.findViewById(R.id.indicator_button_in_2_14);
        arrayList.add(indicator_button_in_2_14);
        Button indicator_button_in_2_15 = root.findViewById(R.id.indicator_button_in_2_15);
        arrayList.add(indicator_button_in_2_15);

        addressSpace = resultReceiver.getAddressSpace();

        upDateValues();

        return root;
    }

    @Override
    public void onStart() {
        super.onStart();
        addressSpace = resultReceiver.getAddressSpace();
        upDateValues();
    }

    public void upDateValues() {
        for (int i = 0; i < stopCellNumber; i++) {
            if (addressSpace.getAddressSpace(startCellNumber + i) == 0)
                arrayList.get(i).setBackgroundColor(Color.RED);
            else arrayList.get(i).setBackgroundColor(Color.GREEN);
        }
    }
}
