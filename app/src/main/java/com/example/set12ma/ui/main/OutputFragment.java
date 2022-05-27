package com.example.set12ma.ui.main;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import com.example.set12ma.R;

import java.util.ArrayList;

public class OutputFragment extends Fragment implements View.OnClickListener {
//    static BluetoothConnectedThread bluetoothConnectedThread;


    private static final String ARG_SECTION_NUMBER = "Output";
    private static final String LOG_TAG = "AndroidExample";
    private ArrayList<Switch> arrayList;
    private byte[] bytes;

    private AddressSpace addressSpace;
    private int startCellNumber = 48;

    private ResultReceiver resultReceiver;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        resultReceiver = (ResultReceiver) context;
    }

    private PageViewModel pageViewModel;

    public static OutputFragment newInstance(int index) {
        OutputFragment fragment = new OutputFragment();
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
        View root = inflater.inflate(R.layout.fragment_output, container, false);
        arrayList = new ArrayList();
        bytes = new byte[48];

        Switch switch_out_0_0 = root.findViewById(R.id.switch_out_0_0);
        switch_out_0_0.setOnClickListener(this);
        arrayList.add(switch_out_0_0);
        Switch switch_out_0_1 = root.findViewById(R.id.switch_out_0_1);
        switch_out_0_1.setOnClickListener(this);
        arrayList.add(switch_out_0_1);
        Switch switch_out_0_2 = root.findViewById(R.id.switch_out_0_2);
        switch_out_0_2.setOnClickListener(this);
        arrayList.add(switch_out_0_2);
        Switch switch_out_0_3 = root.findViewById(R.id.switch_out_0_3);
        switch_out_0_3.setOnClickListener(this);
        arrayList.add(switch_out_0_3);
        Switch switch_out_0_4 = root.findViewById(R.id.switch_out_0_4);
        switch_out_0_4.setOnClickListener(this);
        arrayList.add(switch_out_0_4);
        Switch switch_out_0_5 = root.findViewById(R.id.switch_out_0_5);
        switch_out_0_5.setOnClickListener(this);
        arrayList.add(switch_out_0_5);
        Switch switch_out_0_6 = root.findViewById(R.id.switch_out_0_6);
        switch_out_0_6.setOnClickListener(this);
        arrayList.add(switch_out_0_6);
        Switch switch_out_0_7 = root.findViewById(R.id.switch_out_0_7);
        switch_out_0_7.setOnClickListener(this);
        arrayList.add(switch_out_0_7);
        Switch switch_out_0_8 = root.findViewById(R.id.switch_out_0_8);
        switch_out_0_8.setOnClickListener(this);
        arrayList.add(switch_out_0_8);
        Switch switch_out_0_9 = root.findViewById(R.id.switch_out_0_9);
        switch_out_0_9.setOnClickListener(this);
        arrayList.add(switch_out_0_9);
        Switch switch_out_0_10 = root.findViewById(R.id.switch_out_0_10);
        switch_out_0_10.setOnClickListener(this);
        arrayList.add(switch_out_0_10);
        Switch switch_out_0_11 = root.findViewById(R.id.switch_out_0_11);
        switch_out_0_11.setOnClickListener(this);
        arrayList.add(switch_out_0_11);
        Switch switch_out_0_12 = root.findViewById(R.id.switch_out_0_12);
        switch_out_0_12.setOnClickListener(this);
        arrayList.add(switch_out_0_12);
        Switch switch_out_0_13 = root.findViewById(R.id.switch_out_0_13);
        switch_out_0_13.setOnClickListener(this);
        arrayList.add(switch_out_0_13);
        Switch switch_out_0_14 = root.findViewById(R.id.switch_out_0_14);
        switch_out_0_14.setOnClickListener(this);
        arrayList.add(switch_out_0_14);
        Switch switch_out_0_15 = root.findViewById(R.id.switch_out_0_15);
        switch_out_0_15.setOnClickListener(this);
        arrayList.add(switch_out_0_15);

        Switch switch_out_1_0 = root.findViewById(R.id.switch_out_1_0);
        switch_out_1_0.setOnClickListener(this);
        arrayList.add(switch_out_1_0);
        Switch switch_out_1_1 = root.findViewById(R.id.switch_out_1_1);
        switch_out_1_1.setOnClickListener(this);
        arrayList.add(switch_out_1_1);
        Switch switch_out_1_2 = root.findViewById(R.id.switch_out_1_2);
        switch_out_1_2.setOnClickListener(this);
        arrayList.add(switch_out_1_2);
        Switch switch_out_1_3 = root.findViewById(R.id.switch_out_1_3);
        switch_out_1_3.setOnClickListener(this);
        arrayList.add(switch_out_1_3);
        Switch switch_out_1_4 = root.findViewById(R.id.switch_out_1_4);
        switch_out_1_4.setOnClickListener(this);
        arrayList.add(switch_out_1_4);
        Switch switch_out_1_5 = root.findViewById(R.id.switch_out_1_5);
        switch_out_1_5.setOnClickListener(this);
        arrayList.add(switch_out_1_5);
        Switch switch_out_1_6 = root.findViewById(R.id.switch_out_1_6);
        switch_out_1_6.setOnClickListener(this);
        arrayList.add(switch_out_1_6);
        Switch switch_out_1_7 = root.findViewById(R.id.switch_out_1_7);
        switch_out_1_7.setOnClickListener(this);
        arrayList.add(switch_out_1_7);
        Switch switch_out_1_8 = root.findViewById(R.id.switch_out_1_8);
        switch_out_1_8.setOnClickListener(this);
        arrayList.add(switch_out_1_8);
        Switch switch_out_1_9 = root.findViewById(R.id.switch_out_1_9);
        switch_out_1_9.setOnClickListener(this);
        arrayList.add(switch_out_1_9);
        Switch switch_out_1_10 = root.findViewById(R.id.switch_out_1_10);
        switch_out_1_10.setOnClickListener(this);
        arrayList.add(switch_out_1_10);
        Switch switch_out_1_11 = root.findViewById(R.id.switch_out_1_11);
        switch_out_1_11.setOnClickListener(this);
        arrayList.add(switch_out_1_11);
        Switch switch_out_1_12 = root.findViewById(R.id.switch_out_1_12);
        switch_out_1_12.setOnClickListener(this);
        arrayList.add(switch_out_1_12);
        Switch switch_out_1_13 = root.findViewById(R.id.switch_out_1_13);
        switch_out_1_13.setOnClickListener(this);
        arrayList.add(switch_out_1_13);
        Switch switch_out_1_14 = root.findViewById(R.id.switch_out_1_14);
        switch_out_1_14.setOnClickListener(this);
        arrayList.add(switch_out_1_14);
        Switch switch_out_1_15 = root.findViewById(R.id.switch_out_1_15);
        switch_out_1_15.setOnClickListener(this);
        arrayList.add(switch_out_1_15);

        Switch switch_out_2_0 = root.findViewById(R.id.switch_out_2_0);
        switch_out_2_0.setOnClickListener(this);
        arrayList.add(switch_out_2_0);
        Switch switch_out_2_1 = root.findViewById(R.id.switch_out_2_1);
        switch_out_2_1.setOnClickListener(this);
        arrayList.add(switch_out_2_1);
        Switch switch_out_2_2 = root.findViewById(R.id.switch_out_2_2);
        switch_out_2_2.setOnClickListener(this);
        arrayList.add(switch_out_2_2);
        Switch switch_out_2_3 = root.findViewById(R.id.switch_out_2_3);
        switch_out_2_3.setOnClickListener(this);
        arrayList.add(switch_out_2_3);
        Switch switch_out_2_4 = root.findViewById(R.id.switch_out_2_4);
        switch_out_2_4.setOnClickListener(this);
        arrayList.add(switch_out_2_4);
        Switch switch_out_2_5 = root.findViewById(R.id.switch_out_2_5);
        switch_out_2_5.setOnClickListener(this);
        arrayList.add(switch_out_2_5);
        Switch switch_out_2_6 = root.findViewById(R.id.switch_out_2_6);
        switch_out_2_6.setOnClickListener(this);
        arrayList.add(switch_out_2_6);
        Switch switch_out_2_7 = root.findViewById(R.id.switch_out_2_7);
        switch_out_2_7.setOnClickListener(this);
        arrayList.add(switch_out_2_7);
        Switch switch_out_2_8 = root.findViewById(R.id.switch_out_2_8);
        switch_out_2_8.setOnClickListener(this);
        arrayList.add(switch_out_2_8);
        Switch switch_out_2_9 = root.findViewById(R.id.switch_out_2_9);
        switch_out_2_9.setOnClickListener(this);
        arrayList.add(switch_out_2_9);
        Switch switch_out_2_10 = root.findViewById(R.id.switch_out_2_10);
        switch_out_2_10.setOnClickListener(this);
        arrayList.add(switch_out_2_10);
        Switch switch_out_2_11 = root.findViewById(R.id.switch_out_2_11);
        switch_out_2_11.setOnClickListener(this);
        arrayList.add(switch_out_2_11);
        Switch switch_out_2_12 = root.findViewById(R.id.switch_out_2_12);
        switch_out_2_12.setOnClickListener(this);
        arrayList.add(switch_out_2_12);
        Switch switch_out_2_13 = root.findViewById(R.id.switch_out_2_13);
        switch_out_2_13.setOnClickListener(this);
        arrayList.add(switch_out_2_13);
        Switch switch_out_2_14 = root.findViewById(R.id.switch_out_2_14);
        switch_out_2_14.setOnClickListener(this);
        arrayList.add(switch_out_2_14);
        Switch switch_out_2_15 = root.findViewById(R.id.switch_out_2_15);
        switch_out_2_15.setOnClickListener(this);
        arrayList.add(switch_out_2_15);

        addressSpace = resultReceiver.getAddressSpace();



        return root;
    }

    @Override
    public void onClick(View v){
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i).isChecked()) {
                addressSpace.setAddressSpace(startCellNumber + i, 1);
            }
            else {
                addressSpace.setAddressSpace(startCellNumber + i, 0);
            }
        }
    }

//    public static void setBluetoothConnectedTread(BluetoothConnectedThread btConnectedThread) {
////        bluetoothConnectedThread = btConnectedThread;
//    }


}
