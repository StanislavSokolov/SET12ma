package com.example.set12ma.ui.main;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import com.example.set12ma.R;

import java.util.ArrayList;

public class FragmentOutput extends Fragment {
    private static final String LOG_TAG = "AndroidExample";
    private static final String ARG_SECTION_NUMBER = "Output";

    private int sectionNumber = 0;
    private int startCellNumber = 48;

    private ArrayList<Switch> arrayList;
    private SpaceAddress spaceAddress;
    private SpaceStatus spaceStatus;
    private ResultReceiverAddressSpace resultReceiverAddressSpace;
    private ResultReceiverStatusSpace resultReceiverStatusSpace;

    private UpDateGraphicalDisplay upDateGraphicalDisplay;
    private long timer = 500;

    boolean latch = true;

    private Switch switch_out_0_0;
    private Switch switch_out_0_1;
    private Switch switch_out_0_2;
    private Switch switch_out_0_3;
    private Switch switch_out_0_4;
    private Switch switch_out_0_5;
    private Switch switch_out_0_6;
    private Switch switch_out_0_7;
    private Switch switch_out_0_8;
    private Switch switch_out_0_9;
    private Switch switch_out_0_10;
    private Switch switch_out_0_11;
    private Switch switch_out_0_12;
    private Switch switch_out_0_13;
    private Switch switch_out_0_14;
    private Switch switch_out_0_15;

    private Switch switch_out_1_0;
    private Switch switch_out_1_1;
    private Switch switch_out_1_2;
    private Switch switch_out_1_3;
    private Switch switch_out_1_4;
    private Switch switch_out_1_5;
    private Switch switch_out_1_6;
    private Switch switch_out_1_7;
    private Switch switch_out_1_8;
    private Switch switch_out_1_9;
    private Switch switch_out_1_10;
    private Switch switch_out_1_11;
    private Switch switch_out_1_12;
    private Switch switch_out_1_13;
    private Switch switch_out_1_14;
    private Switch switch_out_1_15;

    private Switch switch_out_2_0;
    private Switch switch_out_2_1;
    private Switch switch_out_2_2;
    private Switch switch_out_2_3;
    private Switch switch_out_2_4;
    private Switch switch_out_2_5;
    private Switch switch_out_2_6;
    private Switch switch_out_2_7;
    private Switch switch_out_2_8;
    private Switch switch_out_2_9;
    private Switch switch_out_2_10;
    private Switch switch_out_2_11;
    private Switch switch_out_2_12;
    private Switch switch_out_2_13;
    private Switch switch_out_2_14;
    private Switch switch_out_2_15;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        resultReceiverAddressSpace = (ResultReceiverAddressSpace) context;
        resultReceiverStatusSpace = (ResultReceiverStatusSpace) context;
    }

    private PageViewModel pageViewModel;

    public static FragmentOutput newInstance(int index) {
        FragmentOutput fragment = new FragmentOutput();
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
        View root = inflater.inflate(R.layout.fragment_output, container, false);

        arrayList = new ArrayList();

        switch_out_0_0 = root.findViewById(R.id.switch_out_0_0);
        switch_out_0_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch_out_0_0.isChecked()) {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber,0, 1));
                    spaceAddress.setAddressSpace(startCellNumber + 0, 1);
                } else {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber,0, 0));
                    spaceAddress.setAddressSpace(startCellNumber + 0, 0);
                }
            }
        });
        arrayList.add(switch_out_0_0);
        switch_out_0_1 = root.findViewById(R.id.switch_out_0_1);
        switch_out_0_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch_out_0_1.isChecked()) {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber,1, 1));
                    spaceAddress.setAddressSpace(startCellNumber + 1, 1);
                } else {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber,1, 0));
                    spaceAddress.setAddressSpace(startCellNumber + 1, 0);
                }
            }
        });
        arrayList.add(switch_out_0_1);
        switch_out_0_2 = root.findViewById(R.id.switch_out_0_2);
        switch_out_0_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch_out_0_2.isChecked()) {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber, 2, 1));
                    spaceAddress.setAddressSpace(startCellNumber + 2, 1);
                } else {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber,2, 0));
                    spaceAddress.setAddressSpace(startCellNumber + 2, 0);
                }
            }
        });
        arrayList.add(switch_out_0_2);
        switch_out_0_3 = root.findViewById(R.id.switch_out_0_3);
        switch_out_0_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch_out_0_3.isChecked()) {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber, 3, 1));
                    spaceAddress.setAddressSpace(startCellNumber + 3, 1);
                } else {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber,3, 0));
                    spaceAddress.setAddressSpace(startCellNumber + 3, 0);
                }
            }
        });
        arrayList.add(switch_out_0_3);
        switch_out_0_4 = root.findViewById(R.id.switch_out_0_4);
        switch_out_0_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch_out_0_4.isChecked()) {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber, 4, 1));
                    spaceAddress.setAddressSpace(startCellNumber + 4, 1);
                } else {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber,4, 0));
                    spaceAddress.setAddressSpace(startCellNumber + 4, 0);
                }
            }
        });
        arrayList.add(switch_out_0_4);
        switch_out_0_5 = root.findViewById(R.id.switch_out_0_5);
        switch_out_0_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch_out_0_5.isChecked()) {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber, 5, 1));
                    spaceAddress.setAddressSpace(startCellNumber + 5, 1);
                } else {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber,5, 0));
                    spaceAddress.setAddressSpace(startCellNumber + 5, 0);
                }
            }
        });
        arrayList.add(switch_out_0_5);
        switch_out_0_6 = root.findViewById(R.id.switch_out_0_6);
        switch_out_0_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch_out_0_6.isChecked()) {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber, 6, 1));
                    spaceAddress.setAddressSpace(startCellNumber + 6, 1);
                } else {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber,6, 0));
                    spaceAddress.setAddressSpace(startCellNumber + 6, 0);
                }
            }
        });
        arrayList.add(switch_out_0_6);
        switch_out_0_7 = root.findViewById(R.id.switch_out_0_7);
        switch_out_0_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch_out_0_7.isChecked()) {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber, 7, 1));
                    spaceAddress.setAddressSpace(startCellNumber + 7, 1);
                } else {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber,7, 0));
                    spaceAddress.setAddressSpace(startCellNumber + 7, 0);
                }
            }
        });
        arrayList.add(switch_out_0_7);
        switch_out_0_8 = root.findViewById(R.id.switch_out_0_8);
        switch_out_0_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch_out_0_8.isChecked()) {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber, 8, 1));
                    spaceAddress.setAddressSpace(startCellNumber + 8, 1);
                } else {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber,8, 0));
                    spaceAddress.setAddressSpace(startCellNumber + 8, 0);
                }
            }
        });
        arrayList.add(switch_out_0_8);
        switch_out_0_9 = root.findViewById(R.id.switch_out_0_9);
        switch_out_0_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch_out_0_9.isChecked()) {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber, 9, 1));
                    spaceAddress.setAddressSpace(startCellNumber + 9, 1);
                } else {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber,9, 0));
                    spaceAddress.setAddressSpace(startCellNumber + 9, 0);
                }
            }
        });
        arrayList.add(switch_out_0_9);
        switch_out_0_10 = root.findViewById(R.id.switch_out_0_10);
        switch_out_0_10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch_out_0_10.isChecked()) {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber, 10, 1));
                    spaceAddress.setAddressSpace(startCellNumber + 10, 1);
                } else {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber,10, 0));
                    spaceAddress.setAddressSpace(startCellNumber + 10, 0);
                }
            }
        });
        arrayList.add(switch_out_0_10);
        switch_out_0_11 = root.findViewById(R.id.switch_out_0_11);
        switch_out_0_11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch_out_0_11.isChecked()) {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber, 11, 1));
                    spaceAddress.setAddressSpace(startCellNumber + 11, 1);
                } else {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber,11, 0));
                    spaceAddress.setAddressSpace(startCellNumber + 11, 0);
                }
            }
        });
        arrayList.add(switch_out_0_11);
        switch_out_0_12 = root.findViewById(R.id.switch_out_0_12);
        switch_out_0_12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch_out_0_12.isChecked()) {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber, 12, 1));
                    spaceAddress.setAddressSpace(startCellNumber + 12, 1);
                } else {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber,12, 0));
                    spaceAddress.setAddressSpace(startCellNumber + 12, 0);
                }
            }
        });
        arrayList.add(switch_out_0_12);
        switch_out_0_13 = root.findViewById(R.id.switch_out_0_13);
        switch_out_0_13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch_out_0_13.isChecked()) {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber, 13, 1));
                    spaceAddress.setAddressSpace(startCellNumber + 13, 1);
                } else {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber,13, 0));
                    spaceAddress.setAddressSpace(startCellNumber + 13, 0);
                }
            }
        });
        arrayList.add(switch_out_0_13);
        switch_out_0_14 = root.findViewById(R.id.switch_out_0_14);
        switch_out_0_14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch_out_0_14.isChecked()) {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber, 14, 1));
                    spaceAddress.setAddressSpace(startCellNumber + 14, 1);
                } else {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber,14, 0));
                    spaceAddress.setAddressSpace(startCellNumber + 14, 0);
                }
            }
        });
        arrayList.add(switch_out_0_14);
        switch_out_0_15 = root.findViewById(R.id.switch_out_0_15);
        switch_out_0_15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch_out_0_15.isChecked()) {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber, 15, 1));
                    spaceAddress.setAddressSpace(startCellNumber + 15, 1);
                } else {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber,15, 0));
                    spaceAddress.setAddressSpace(startCellNumber + 15, 0);
                }
            }
        });
        arrayList.add(switch_out_0_15);

        switch_out_1_0 = root.findViewById(R.id.switch_out_1_0);
        switch_out_1_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch_out_1_0.isChecked()) {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber, 16, 1));
                    spaceAddress.setAddressSpace(startCellNumber + 16, 1);
                } else {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber,16, 0));
                    spaceAddress.setAddressSpace(startCellNumber + 16, 0);
                }
            }
        });
        arrayList.add(switch_out_1_0);
        switch_out_1_1 = root.findViewById(R.id.switch_out_1_1);
        switch_out_1_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch_out_1_1.isChecked()) {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber, 17, 1));
                    spaceAddress.setAddressSpace(startCellNumber + 17, 1);
                } else {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber,17, 0));
                    spaceAddress.setAddressSpace(startCellNumber + 17, 0);
                }
            }
        });
        arrayList.add(switch_out_1_1);
        switch_out_1_2 = root.findViewById(R.id.switch_out_1_2);
        switch_out_1_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch_out_1_2.isChecked()) {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber, 18, 1));
                    spaceAddress.setAddressSpace(startCellNumber + 18, 1);
                } else {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber,18, 0));
                    spaceAddress.setAddressSpace(startCellNumber + 18, 0);
                }
            }
        });
        arrayList.add(switch_out_1_2);
        switch_out_1_3 = root.findViewById(R.id.switch_out_1_3);
        switch_out_1_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch_out_1_3.isChecked()) {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber, 19, 1));
                    spaceAddress.setAddressSpace(startCellNumber + 19, 1);
                } else {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber,19, 0));
                    spaceAddress.setAddressSpace(startCellNumber + 19, 0);
                }
            }
        });
        arrayList.add(switch_out_1_3);
        switch_out_1_4 = root.findViewById(R.id.switch_out_1_4);
        switch_out_1_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch_out_1_4.isChecked()) {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber, 20, 1));
                    spaceAddress.setAddressSpace(startCellNumber + 20, 1);
                } else {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber,20, 0));
                    spaceAddress.setAddressSpace(startCellNumber + 20, 0);
                }
            }
        });
        arrayList.add(switch_out_1_4);
        switch_out_1_5 = root.findViewById(R.id.switch_out_1_5);
        switch_out_1_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch_out_1_5.isChecked()) {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber, 21, 1));
                    spaceAddress.setAddressSpace(startCellNumber + 21, 1);
                } else {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber,21, 0));
                    spaceAddress.setAddressSpace(startCellNumber + 21, 0);
                }
            }
        });
        arrayList.add(switch_out_1_5);
        switch_out_1_6 = root.findViewById(R.id.switch_out_1_6);
        switch_out_1_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch_out_1_6.isChecked()) {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber, 22, 1));
                    spaceAddress.setAddressSpace(startCellNumber + 22, 1);
                } else {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber,22, 0));
                    spaceAddress.setAddressSpace(startCellNumber + 22, 0);
                }
            }
        });
        arrayList.add(switch_out_1_6);
        switch_out_1_7 = root.findViewById(R.id.switch_out_1_7);
        switch_out_1_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch_out_1_7.isChecked()) {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber, 23, 1));
                    spaceAddress.setAddressSpace(startCellNumber + 23, 1);
                } else {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber,23, 0));
                    spaceAddress.setAddressSpace(startCellNumber + 23, 0);
                }
            }
        });
        arrayList.add(switch_out_1_7);
        switch_out_1_8 = root.findViewById(R.id.switch_out_1_8);
        switch_out_1_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch_out_1_8.isChecked()) {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber, 24, 1));
                    spaceAddress.setAddressSpace(startCellNumber + 24, 1);
                } else {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber,24, 0));
                    spaceAddress.setAddressSpace(startCellNumber + 24, 0);
                }
            }
        });
        arrayList.add(switch_out_1_8);
        switch_out_1_9 = root.findViewById(R.id.switch_out_1_9);
        switch_out_1_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch_out_1_9.isChecked()) {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber, 25, 1));
                    spaceAddress.setAddressSpace(startCellNumber + 25, 1);
                } else {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber,25, 0));
                    spaceAddress.setAddressSpace(startCellNumber + 25, 0);
                }
            }
        });
        arrayList.add(switch_out_1_9);
        switch_out_1_10 = root.findViewById(R.id.switch_out_1_10);
        switch_out_1_10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch_out_1_10.isChecked()) {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber, 26, 1));
                    spaceAddress.setAddressSpace(startCellNumber + 26, 1);
                } else {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber,26, 0));
                    spaceAddress.setAddressSpace(startCellNumber + 26, 0);
                }
            }
        });
        arrayList.add(switch_out_1_10);
        switch_out_1_11 = root.findViewById(R.id.switch_out_1_11);
        switch_out_1_11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch_out_1_11.isChecked()) {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber, 27, 1));
                    spaceAddress.setAddressSpace(startCellNumber + 27, 1);
                } else {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber,27, 0));
                    spaceAddress.setAddressSpace(startCellNumber + 27, 0);
                }
            }
        });
        arrayList.add(switch_out_1_11);
        switch_out_1_12 = root.findViewById(R.id.switch_out_1_12);
        switch_out_1_12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch_out_1_12.isChecked()) {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber, 28, 1));
                    spaceAddress.setAddressSpace(startCellNumber + 28, 1);
                } else {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber,28, 0));
                    spaceAddress.setAddressSpace(startCellNumber + 28, 0);
                }
            }
        });
        arrayList.add(switch_out_1_12);
        switch_out_1_13 = root.findViewById(R.id.switch_out_1_13);
        switch_out_1_13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch_out_1_13.isChecked()) {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber, 29, 1));
                    spaceAddress.setAddressSpace(startCellNumber + 29, 1);
                } else {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber,29, 0));
                    spaceAddress.setAddressSpace(startCellNumber + 29, 0);
                }
            }
        });
        arrayList.add(switch_out_1_13);
        switch_out_1_14 = root.findViewById(R.id.switch_out_1_14);
        switch_out_1_14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch_out_1_14.isChecked()) {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber, 30, 1));
                    spaceAddress.setAddressSpace(startCellNumber + 30, 1);
                } else {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber,30, 0));
                    spaceAddress.setAddressSpace(startCellNumber + 30, 0);
                }
            }
        });
        arrayList.add(switch_out_1_14);
        switch_out_1_15 = root.findViewById(R.id.switch_out_1_15);
        switch_out_1_15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch_out_1_15.isChecked()) {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber, 31, 1));
                    spaceAddress.setAddressSpace(startCellNumber + 31, 1);
                } else {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber,31, 0));
                    spaceAddress.setAddressSpace(startCellNumber + 31, 0);
                }
            }
        });
        arrayList.add(switch_out_1_15);

        switch_out_2_0 = root.findViewById(R.id.switch_out_2_0);
        switch_out_2_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch_out_2_0.isChecked()) {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber, 32, 1));
                    spaceAddress.setAddressSpace(startCellNumber + 32, 1);
                } else {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber,32, 0));
                    spaceAddress.setAddressSpace(startCellNumber + 32, 0);
                }
            }
        });
        arrayList.add(switch_out_2_0);
        switch_out_2_1 = root.findViewById(R.id.switch_out_2_1);
        switch_out_2_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch_out_2_1.isChecked()) {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber, 33, 1));
                    spaceAddress.setAddressSpace(startCellNumber + 33, 1);
                } else {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber,33, 0));
                    spaceAddress.setAddressSpace(startCellNumber + 33, 0);
                }
            }
        });
        arrayList.add(switch_out_2_1);
        switch_out_2_2 = root.findViewById(R.id.switch_out_2_2);
        switch_out_2_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch_out_2_2.isChecked()) {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber, 34, 1));
                    spaceAddress.setAddressSpace(startCellNumber + 34, 1);
                } else {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber,34, 0));
                    spaceAddress.setAddressSpace(startCellNumber + 34, 0);
                }
            }
        });
        arrayList.add(switch_out_2_2);
        switch_out_2_3 = root.findViewById(R.id.switch_out_2_3);
        switch_out_2_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch_out_2_3.isChecked()) {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber, 35, 1));
                    spaceAddress.setAddressSpace(startCellNumber + 35, 1);
                } else {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber,35, 0));
                    spaceAddress.setAddressSpace(startCellNumber + 35, 0);
                }
            }
        });
        arrayList.add(switch_out_2_3);
        switch_out_2_4 = root.findViewById(R.id.switch_out_2_4);
        switch_out_2_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch_out_2_4.isChecked()) {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber, 36, 1));
                    spaceAddress.setAddressSpace(startCellNumber + 36, 1);
                } else {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber,36, 0));
                    spaceAddress.setAddressSpace(startCellNumber + 36, 0);
                }
            }
        });
        arrayList.add(switch_out_2_4);
        switch_out_2_5 = root.findViewById(R.id.switch_out_2_5);
        switch_out_2_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch_out_2_5.isChecked()) {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber, 37, 1));
                    spaceAddress.setAddressSpace(startCellNumber + 37, 1);
                } else {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber,37, 0));
                    spaceAddress.setAddressSpace(startCellNumber + 37, 0);
                }
            }
        });
        arrayList.add(switch_out_2_5);
        switch_out_2_6 = root.findViewById(R.id.switch_out_2_6);
        switch_out_2_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch_out_2_6.isChecked()) {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber, 38, 1));
                    spaceAddress.setAddressSpace(startCellNumber + 38, 1);
                } else {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber,38, 0));
                    spaceAddress.setAddressSpace(startCellNumber + 38, 0);
                }
            }
        });
        arrayList.add(switch_out_2_6);
        switch_out_2_7 = root.findViewById(R.id.switch_out_2_7);
        switch_out_2_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch_out_2_7.isChecked()) {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber, 39, 1));
                    spaceAddress.setAddressSpace(startCellNumber + 39, 1);
                } else {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber,39, 0));
                    spaceAddress.setAddressSpace(startCellNumber + 39, 0);
                }
            }
        });
        arrayList.add(switch_out_2_7);
        switch_out_2_8 = root.findViewById(R.id.switch_out_2_8);
        switch_out_2_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch_out_2_8.isChecked()) {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber, 40, 1));
                    spaceAddress.setAddressSpace(startCellNumber + 40, 1);
                } else {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber,40, 0));
                    spaceAddress.setAddressSpace(startCellNumber + 40, 0);
                }
            }
        });
        arrayList.add(switch_out_2_8);
        switch_out_2_9 = root.findViewById(R.id.switch_out_2_9);
        switch_out_2_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch_out_2_9.isChecked()) {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber, 41, 1));
                    spaceAddress.setAddressSpace(startCellNumber + 41, 1);
                } else {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber,41, 0));
                    spaceAddress.setAddressSpace(startCellNumber + 41, 0);
                }
            }
        });
        arrayList.add(switch_out_2_9);
        switch_out_2_10 = root.findViewById(R.id.switch_out_2_10);
        switch_out_2_10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch_out_2_10.isChecked()) {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber, 42, 1));
                    spaceAddress.setAddressSpace(startCellNumber + 42, 1);
                } else {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber,42, 0));
                    spaceAddress.setAddressSpace(startCellNumber + 42, 0);
                }
            }
        });
        arrayList.add(switch_out_2_10);
        switch_out_2_11 = root.findViewById(R.id.switch_out_2_11);
        switch_out_2_11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch_out_2_11.isChecked()) {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber, 43, 1));
                    spaceAddress.setAddressSpace(startCellNumber + 43, 1);
                } else {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber,43, 0));
                    spaceAddress.setAddressSpace(startCellNumber + 43, 0);
                }
            }
        });
        arrayList.add(switch_out_2_11);
        switch_out_2_12 = root.findViewById(R.id.switch_out_2_12);
        switch_out_2_12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch_out_2_12.isChecked()) {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber, 44, 1));
                    spaceAddress.setAddressSpace(startCellNumber + 44, 1);
                } else {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber,44, 0));
                    spaceAddress.setAddressSpace(startCellNumber + 44, 0);
                }
            }
        });
        arrayList.add(switch_out_2_12);
        switch_out_2_13 = root.findViewById(R.id.switch_out_2_13);
        switch_out_2_13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch_out_2_13.isChecked()) {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber, 45, 1));
                    spaceAddress.setAddressSpace(startCellNumber + 45, 1);
                } else {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber,45, 0));
                    spaceAddress.setAddressSpace(startCellNumber + 45, 0);
                }
            }
        });
        arrayList.add(switch_out_2_13);
        switch_out_2_14 = root.findViewById(R.id.switch_out_2_14);
        switch_out_2_14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch_out_2_14.isChecked()) {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber, 46, 1));
                    spaceAddress.setAddressSpace(startCellNumber + 46, 1);
                } else {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber,46, 0));
                    spaceAddress.setAddressSpace(startCellNumber + 46, 0);
                }
            }
        });
        arrayList.add(switch_out_2_14);
        switch_out_2_15 = root.findViewById(R.id.switch_out_2_15);
        switch_out_2_15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch_out_2_15.isChecked()) {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber, 47, 1));
                    spaceAddress.setAddressSpace(startCellNumber + 47, 1);
                } else {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber,47, 0));
                    spaceAddress.setAddressSpace(startCellNumber + 47, 0);
                }
            }
        });
        arrayList.add(switch_out_2_15);

        upDateValues();
        upDateEnables();

        upDateGraphicalDisplay = new UpDateGraphicalDisplay();
        upDateGraphicalDisplay.start();

        return root;
    }

    @Override
    public void onPause() {
        super.onPause();
        upDateGraphicalDisplay.interrupt();
    }

    private void upDateEnables() {
        if (spaceStatus.isReadyFlagRecordingInitialValues()) {
                switch_out_0_0.post(new Runnable() {
                    @Override
                    public void run() {
                        switch_out_0_0.setEnabled(false);
                    }
                });
                switch_out_0_1.post(new Runnable() {
                    @Override
                    public void run() {
                        switch_out_0_1.setEnabled(false);
                    }
                });
                switch_out_0_2.post(new Runnable() {
                    @Override
                    public void run() {
                        switch_out_0_2.setEnabled(false);
                    }
                });
                switch_out_0_3.post(new Runnable() {
                    @Override
                    public void run() {
                        switch_out_0_3.setEnabled(false);
                    }
                });
                switch_out_0_4.post(new Runnable() {
                    @Override
                    public void run() {
                        switch_out_0_4.setEnabled(false);
                    }
                });
                switch_out_0_5.post(new Runnable() {
                    @Override
                    public void run() {
                        switch_out_0_5.setEnabled(false);
                    }
                });
                switch_out_0_6.post(new Runnable() {
                    @Override
                    public void run() {
                        switch_out_0_6.setEnabled(false);
                    }
                });
                switch_out_0_7.post(new Runnable() {
                    @Override
                    public void run() {
                        switch_out_0_7.setEnabled(false);
                    }
                });switch_out_0_8.post(new Runnable() {
                    @Override
                    public void run() {
                        switch_out_0_8.setEnabled(false);
                    }
                });
                switch_out_0_9.post(new Runnable() {
                    @Override
                    public void run() {
                        switch_out_0_9.setEnabled(false);
                    }
                });
                switch_out_0_10.post(new Runnable() {
                    @Override
                    public void run() {
                        switch_out_0_10.setEnabled(false);
                    }
                });
                switch_out_0_11.post(new Runnable() {
                    @Override
                    public void run() {
                        switch_out_0_11.setEnabled(false);
                    }
                });
                switch_out_0_12.post(new Runnable() {
                    @Override
                    public void run() {
                        switch_out_0_12.setEnabled(false);
                    }
                });
                switch_out_0_13.post(new Runnable() {
                    @Override
                    public void run() {
                        switch_out_0_13.setEnabled(false);
                    }
                });
                switch_out_0_14.post(new Runnable() {
                    @Override
                    public void run() {
                        switch_out_0_14.setEnabled(false);
                    }
                });
                switch_out_0_15.post(new Runnable() {
                    @Override
                    public void run() {
                        switch_out_0_15.setEnabled(false);
                    }
                });

                switch_out_1_0.post(new Runnable() {
                    @Override
                    public void run() {
                        switch_out_1_0.setEnabled(false);
                    }
                });
                switch_out_1_1.post(new Runnable() {
                    @Override
                    public void run() {
                        switch_out_1_1.setEnabled(false);
                    }
                });
                switch_out_1_2.post(new Runnable() {
                    @Override
                    public void run() {
                        switch_out_1_2.setEnabled(false);
                    }
                });
                switch_out_1_3.post(new Runnable() {
                    @Override
                    public void run() {
                        switch_out_1_3.setEnabled(false);
                    }
                });
                switch_out_1_4.post(new Runnable() {
                    @Override
                    public void run() {
                        switch_out_1_4.setEnabled(false);
                    }
                });
                switch_out_1_5.post(new Runnable() {
                    @Override
                    public void run() {
                        switch_out_1_5.setEnabled(false);
                    }
                });
                switch_out_1_6.post(new Runnable() {
                    @Override
                    public void run() {
                        switch_out_1_6.setEnabled(false);
                    }
                });
                switch_out_1_7.post(new Runnable() {
                    @Override
                    public void run() {
                        switch_out_1_7.setEnabled(false);
                    }
                });switch_out_1_8.post(new Runnable() {
                    @Override
                    public void run() {
                        switch_out_1_8.setEnabled(false);
                    }
                });
                switch_out_1_9.post(new Runnable() {
                    @Override
                    public void run() {
                        switch_out_1_9.setEnabled(false);
                    }
                });
                switch_out_1_10.post(new Runnable() {
                    @Override
                    public void run() {
                        switch_out_1_10.setEnabled(false);
                    }
                });
                switch_out_1_11.post(new Runnable() {
                    @Override
                    public void run() {
                        switch_out_1_11.setEnabled(false);
                    }
                });
                switch_out_1_12.post(new Runnable() {
                    @Override
                    public void run() {
                        switch_out_1_12.setEnabled(false);
                    }
                });
                switch_out_1_13.post(new Runnable() {
                    @Override
                    public void run() {
                        switch_out_1_13.setEnabled(false);
                    }
                });
                switch_out_1_14.post(new Runnable() {
                    @Override
                    public void run() {
                        switch_out_1_14.setEnabled(false);
                    }
                });
                switch_out_1_15.post(new Runnable() {
                    @Override
                    public void run() {
                        switch_out_1_15.setEnabled(false);
                    }
                });

                switch_out_2_0.post(new Runnable() {
                    @Override
                    public void run() {
                        switch_out_2_0.setEnabled(false);
                    }
                });
                switch_out_2_1.post(new Runnable() {
                    @Override
                    public void run() {
                        switch_out_2_1.setEnabled(false);
                    }
                });
                switch_out_2_2.post(new Runnable() {
                    @Override
                    public void run() {
                        switch_out_2_2.setEnabled(false);
                    }
                });
                switch_out_2_3.post(new Runnable() {
                    @Override
                    public void run() {
                        switch_out_2_3.setEnabled(false);
                    }
                });
                switch_out_2_4.post(new Runnable() {
                    @Override
                    public void run() {
                        switch_out_2_4.setEnabled(false);
                    }
                });
                switch_out_2_5.post(new Runnable() {
                    @Override
                    public void run() {
                        switch_out_2_5.setEnabled(false);
                    }
                });
                switch_out_2_6.post(new Runnable() {
                    @Override
                    public void run() {
                        switch_out_2_6.setEnabled(false);
                    }
                });
                switch_out_2_7.post(new Runnable() {
                    @Override
                    public void run() {
                        switch_out_2_7.setEnabled(false);
                    }
                });switch_out_2_8.post(new Runnable() {
                    @Override
                    public void run() {
                        switch_out_2_8.setEnabled(false);
                    }
                });
                switch_out_2_9.post(new Runnable() {
                    @Override
                    public void run() {
                        switch_out_2_9.setEnabled(false);
                    }
                });
                switch_out_2_10.post(new Runnable() {
                    @Override
                    public void run() {
                        switch_out_2_10.setEnabled(false);
                    }
                });
                switch_out_2_11.post(new Runnable() {
                    @Override
                    public void run() {
                        switch_out_2_11.setEnabled(false);
                    }
                });
                switch_out_2_12.post(new Runnable() {
                    @Override
                    public void run() {
                        switch_out_2_12.setEnabled(false);
                    }
                });
                switch_out_2_13.post(new Runnable() {
                    @Override
                    public void run() {
                        switch_out_2_13.setEnabled(false);
                    }
                });
                switch_out_2_14.post(new Runnable() {
                    @Override
                    public void run() {
                        switch_out_2_14.setEnabled(false);
                    }
                });
                switch_out_2_15.post(new Runnable() {
                    @Override
                    public void run() {
                        switch_out_2_15.setEnabled(false);
                    }
                });
        } else {
                switch_out_0_0.post(new Runnable() {
                    @Override
                    public void run() {
                        switch_out_0_0.setEnabled(true);
                    }
                });
                switch_out_0_1.post(new Runnable() {
                    @Override
                    public void run() {
                        switch_out_0_1.setEnabled(true);
                    }
                });
                switch_out_0_2.post(new Runnable() {
                    @Override
                    public void run() {
                        switch_out_0_2.setEnabled(true);
                    }
                });
                switch_out_0_3.post(new Runnable() {
                    @Override
                    public void run() {
                        switch_out_0_3.setEnabled(true);
                    }
                });
                switch_out_0_4.post(new Runnable() {
                    @Override
                    public void run() {
                        switch_out_0_4.setEnabled(true);
                    }
                });
                switch_out_0_5.post(new Runnable() {
                    @Override
                    public void run() {
                        switch_out_0_5.setEnabled(true);
                    }
                });
                switch_out_0_6.post(new Runnable() {
                    @Override
                    public void run() {
                        switch_out_0_6.setEnabled(true);
                    }
                });
                switch_out_0_7.post(new Runnable() {
                    @Override
                    public void run() {
                        switch_out_0_7.setEnabled(true);
                    }
                });switch_out_0_8.post(new Runnable() {
                    @Override
                    public void run() {
                        switch_out_0_8.setEnabled(true);
                    }
                });
                switch_out_0_9.post(new Runnable() {
                    @Override
                    public void run() {
                        switch_out_0_9.setEnabled(true);
                    }
                });
                switch_out_0_10.post(new Runnable() {
                    @Override
                    public void run() {
                        switch_out_0_10.setEnabled(true);
                    }
                });
                switch_out_0_11.post(new Runnable() {
                    @Override
                    public void run() {
                        switch_out_0_11.setEnabled(true);
                    }
                });
                switch_out_0_12.post(new Runnable() {
                    @Override
                    public void run() {
                        switch_out_0_12.setEnabled(true);
                    }
                });
                switch_out_0_13.post(new Runnable() {
                    @Override
                    public void run() {
                        switch_out_0_13.setEnabled(true);
                    }
                });
                switch_out_0_14.post(new Runnable() {
                    @Override
                    public void run() {
                        switch_out_0_14.setEnabled(true);
                    }
                });
                switch_out_0_15.post(new Runnable() {
                    @Override
                    public void run() {
                        switch_out_0_15.setEnabled(true);
                    }
                });

                switch_out_1_0.post(new Runnable() {
                    @Override
                    public void run() {
                        switch_out_1_0.setEnabled(true);
                    }
                });
                switch_out_1_1.post(new Runnable() {
                    @Override
                    public void run() {
                        switch_out_1_1.setEnabled(true);
                    }
                });
                switch_out_1_2.post(new Runnable() {
                    @Override
                    public void run() {
                        switch_out_1_2.setEnabled(true);
                    }
                });
                switch_out_1_3.post(new Runnable() {
                    @Override
                    public void run() {
                        switch_out_1_3.setEnabled(true);
                    }
                });
                switch_out_1_4.post(new Runnable() {
                    @Override
                    public void run() {
                        switch_out_1_4.setEnabled(true);
                    }
                });
                switch_out_1_5.post(new Runnable() {
                    @Override
                    public void run() {
                        switch_out_1_5.setEnabled(true);
                    }
                });
                switch_out_1_6.post(new Runnable() {
                    @Override
                    public void run() {
                        switch_out_1_6.setEnabled(true);
                    }
                });
                switch_out_1_7.post(new Runnable() {
                    @Override
                    public void run() {
                        switch_out_1_7.setEnabled(true);
                    }
                });switch_out_1_8.post(new Runnable() {
                    @Override
                    public void run() {
                        switch_out_1_8.setEnabled(true);
                    }
                });
                switch_out_1_9.post(new Runnable() {
                    @Override
                    public void run() {
                        switch_out_1_9.setEnabled(true);
                    }
                });
                switch_out_1_10.post(new Runnable() {
                    @Override
                    public void run() {
                        switch_out_1_10.setEnabled(true);
                    }
                });
                switch_out_1_11.post(new Runnable() {
                    @Override
                    public void run() {
                        switch_out_1_11.setEnabled(true);
                    }
                });
                switch_out_1_12.post(new Runnable() {
                    @Override
                    public void run() {
                        switch_out_1_12.setEnabled(true);
                    }
                });
                switch_out_1_13.post(new Runnable() {
                    @Override
                    public void run() {
                        switch_out_1_13.setEnabled(true);
                    }
                });
                switch_out_1_14.post(new Runnable() {
                    @Override
                    public void run() {
                        switch_out_1_14.setEnabled(true);
                    }
                });
                switch_out_1_15.post(new Runnable() {
                    @Override
                    public void run() {
                        switch_out_1_15.setEnabled(true);
                    }
                });

                switch_out_2_0.post(new Runnable() {
                    @Override
                    public void run() {
                        switch_out_2_0.setEnabled(true);
                    }
                });
                switch_out_2_1.post(new Runnable() {
                    @Override
                    public void run() {
                        switch_out_2_1.setEnabled(true);
                    }
                });
                switch_out_2_2.post(new Runnable() {
                    @Override
                    public void run() {
                        switch_out_2_2.setEnabled(true);
                    }
                });
                switch_out_2_3.post(new Runnable() {
                    @Override
                    public void run() {
                        switch_out_2_3.setEnabled(true);
                    }
                });
                switch_out_2_4.post(new Runnable() {
                    @Override
                    public void run() {
                        switch_out_2_4.setEnabled(true);
                    }
                });
                switch_out_2_5.post(new Runnable() {
                    @Override
                    public void run() {
                        switch_out_2_5.setEnabled(true);
                    }
                });
                switch_out_2_6.post(new Runnable() {
                    @Override
                    public void run() {
                        switch_out_2_6.setEnabled(true);
                    }
                });
                switch_out_2_7.post(new Runnable() {
                    @Override
                    public void run() {
                        switch_out_2_7.setEnabled(true);
                    }
                });switch_out_2_8.post(new Runnable() {
                    @Override
                    public void run() {
                        switch_out_2_8.setEnabled(true);
                    }
                });
                switch_out_2_9.post(new Runnable() {
                    @Override
                    public void run() {
                        switch_out_2_9.setEnabled(true);
                    }
                });
                switch_out_2_10.post(new Runnable() {
                    @Override
                    public void run() {
                        switch_out_2_10.setEnabled(true);
                    }
                });
                switch_out_2_11.post(new Runnable() {
                    @Override
                    public void run() {
                        switch_out_2_11.setEnabled(true);
                    }
                });
                switch_out_2_12.post(new Runnable() {
                    @Override
                    public void run() {
                        switch_out_2_12.setEnabled(true);
                    }
                });
                switch_out_2_13.post(new Runnable() {
                    @Override
                    public void run() {
                        switch_out_2_13.setEnabled(true);
                    }
                });
                switch_out_2_14.post(new Runnable() {
                    @Override
                    public void run() {
                        switch_out_2_14.setEnabled(true);
                    }
                });
                switch_out_2_15.post(new Runnable() {
                    @Override
                    public void run() {
                        switch_out_2_15.setEnabled(true);
                    }
                });
        }
    }

    private void upDateValues() {
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i).isChecked()) {
                spaceAddress.setAddressSpace(startCellNumber + i, 1);
            }
            else {
                spaceAddress.setAddressSpace(startCellNumber + i, 0);
            }
        }
    }


    public class UpDateGraphicalDisplay extends Thread {
        @Override
        public void run() {
            super.run();
            while (true) {
                try {
                    UpDateGraphicalDisplay.sleep(timer);
                } catch (InterruptedException e) {
                    break;
                }
                if (spaceStatus.isReadyFlagRecordingInitialValues()) {
                    if (latch) {
                        upDateEnables();
                        latch = false;
                    }
                } else {
                    if (!latch) {
                        upDateEnables();
                        latch = true;
                    }
                }
            }
        }

        public UpDateGraphicalDisplay() {
        }
    }
}
