package com.example.set12ma.ui.main;

import android.content.Context;
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

import java.util.ArrayList;
// Add "implements View.OnClickListener" if you want to have one listener on all switch
public class FragmentTK extends Fragment{

    private static final String ARG_SECTION_NUMBER = "TK";

    private int sectionNumber = 1;
    private int startCellNumber = 144;
    private int stopCellNumber = 208;

    private ArrayList<Switch> arrayList;
    private SpaceAddress spaceAddress;
    private SpaceStatus spaceStatus;
    private ResultReceiverAddressSpace resultReceiverAddressSpace;
    private ResultReceiverStatusSpace resultReceiverStatusSpace;

    private UpDateGraphicalDisplay upDateGraphicalDisplay;
    private long timer = 500;

    private Switch switch_tk_0_0;
    private Switch switch_tk_0_1;
    private Switch switch_tk_0_2;
    private Switch switch_tk_0_3;
    private Switch switch_tk_0_4;
    private Switch switch_tk_0_5;
    private Switch switch_tk_0_6;
    private Switch switch_tk_0_7;

    private Switch switch_tk_1_0;
    private Switch switch_tk_1_1;
    private Switch switch_tk_1_2;
    private Switch switch_tk_1_3;
    private Switch switch_tk_1_4;
    private Switch switch_tk_1_5;
    private Switch switch_tk_1_6;
    private Switch switch_tk_1_7;

    private Switch switch_tk_2_0;
    private Switch switch_tk_2_1;
    private Switch switch_tk_2_2;
    private Switch switch_tk_2_3;
    private Switch switch_tk_2_4;
    private Switch switch_tk_2_5;
    private Switch switch_tk_2_6;
    private Switch switch_tk_2_7;

    private Switch switch_tk_3_0;
    private Switch switch_tk_3_1;
    private Switch switch_tk_3_2;
    private Switch switch_tk_3_3;
    private Switch switch_tk_3_4;
    private Switch switch_tk_3_5;
    private Switch switch_tk_3_6;
    private Switch switch_tk_3_7;

    private Switch switch_tk_4_0;
    private Switch switch_tk_4_1;
    private Switch switch_tk_4_2;
    private Switch switch_tk_4_3;
    private Switch switch_tk_4_4;
    private Switch switch_tk_4_5;
    private Switch switch_tk_4_6;
    private Switch switch_tk_4_7;

    private Switch switch_tk_5_0;
    private Switch switch_tk_5_1;
    private Switch switch_tk_5_2;
    private Switch switch_tk_5_3;
    private Switch switch_tk_5_4;
    private Switch switch_tk_5_5;
    private Switch switch_tk_5_6;
    private Switch switch_tk_5_7;

    private Switch switch_tk_6_0;
    private Switch switch_tk_6_1;
    private Switch switch_tk_6_2;
    private Switch switch_tk_6_3;
    private Switch switch_tk_6_4;
    private Switch switch_tk_6_5;
    private Switch switch_tk_6_6;
    private Switch switch_tk_6_7;

    private Switch switch_tk_7_0;
    private Switch switch_tk_7_1;
    private Switch switch_tk_7_2;
    private Switch switch_tk_7_3;
    private Switch switch_tk_7_4;
    private Switch switch_tk_7_5;
    private Switch switch_tk_7_6;
    private Switch switch_tk_7_7;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        resultReceiverAddressSpace = (ResultReceiverAddressSpace) context;
        resultReceiverStatusSpace = (ResultReceiverStatusSpace) context;
    }

    private PageViewModel pageViewModel;

    public static FragmentTK newInstance(int index) {
        FragmentTK fragment = new FragmentTK();
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
        View root = inflater.inflate(R.layout.fragment_tk, container, false);

        arrayList = new ArrayList();

        switch_tk_0_0 = root.findViewById(R.id.switch_tk_0_0);
        switch_tk_0_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch_tk_0_0.isChecked()) {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber,0, 1));
                    spaceAddress.setAddressSpace(startCellNumber + 0, 1);
                } else {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber,0, 0));
                    spaceAddress.setAddressSpace(startCellNumber + 0, 0);
                }
            }
        });
        arrayList.add(switch_tk_0_0);
        switch_tk_0_1 = root.findViewById(R.id.switch_tk_0_1);
        switch_tk_0_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch_tk_0_0.isChecked()) {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber,0, 1));
                    spaceAddress.setAddressSpace(startCellNumber + 0, 1);
                } else {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber,0, 0));
                    spaceAddress.setAddressSpace(startCellNumber + 0, 0);
                }
            }
        });
        arrayList.add(switch_tk_0_1);
        switch_tk_0_2 = root.findViewById(R.id.switch_tk_0_2);
        switch_tk_0_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch_tk_0_2.isChecked()) {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber,0, 1));
                    spaceAddress.setAddressSpace(startCellNumber + 0, 1);
                } else {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber,0, 0));
                    spaceAddress.setAddressSpace(startCellNumber + 0, 0);
                }
            }
        });
        arrayList.add(switch_tk_0_2);
        switch_tk_0_3 = root.findViewById(R.id.switch_tk_0_3);
        switch_tk_0_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch_tk_0_3.isChecked()) {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber,0, 1));
                    spaceAddress.setAddressSpace(startCellNumber + 0, 1);
                } else {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber,0, 0));
                    spaceAddress.setAddressSpace(startCellNumber + 0, 0);
                }
            }
        });
        arrayList.add(switch_tk_0_3);
        switch_tk_0_4 = root.findViewById(R.id.switch_tk_0_4);
        switch_tk_0_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch_tk_0_4.isChecked()) {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber,0, 1));
                    spaceAddress.setAddressSpace(startCellNumber + 0, 1);
                } else {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber,0, 0));
                    spaceAddress.setAddressSpace(startCellNumber + 0, 0);
                }
            }
        });
        arrayList.add(switch_tk_0_4);
        switch_tk_0_5 = root.findViewById(R.id.switch_tk_0_5);
        switch_tk_0_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch_tk_0_5.isChecked()) {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber,0, 1));
                    spaceAddress.setAddressSpace(startCellNumber + 0, 1);
                } else {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber,0, 0));
                    spaceAddress.setAddressSpace(startCellNumber + 0, 0);
                }
            }
        });
        arrayList.add(switch_tk_0_5);
        switch_tk_0_6 = root.findViewById(R.id.switch_tk_0_6);
        switch_tk_0_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch_tk_0_6.isChecked()) {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber,0, 1));
                    spaceAddress.setAddressSpace(startCellNumber + 0, 1);
                } else {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber,0, 0));
                    spaceAddress.setAddressSpace(startCellNumber + 0, 0);
                }
            }
        });
        arrayList.add(switch_tk_0_6);
        switch_tk_0_7 = root.findViewById(R.id.switch_tk_0_7);
        switch_tk_0_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch_tk_0_7.isChecked()) {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber,0, 1));
                    spaceAddress.setAddressSpace(startCellNumber + 0, 1);
                } else {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber,0, 0));
                    spaceAddress.setAddressSpace(startCellNumber + 0, 0);
                }
            }
        });
        arrayList.add(switch_tk_0_7);

        switch_tk_1_0 = root.findViewById(R.id.switch_tk_1_0);
        switch_tk_1_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch_tk_1_0.isChecked()) {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber,0, 1));
                    spaceAddress.setAddressSpace(startCellNumber + 0, 1);
                } else {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber,0, 0));
                    spaceAddress.setAddressSpace(startCellNumber + 0, 0);
                }
            }
        });
        arrayList.add(switch_tk_1_0);
        switch_tk_1_1 = root.findViewById(R.id.switch_tk_1_1);
        switch_tk_1_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch_tk_1_1.isChecked()) {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber,0, 1));
                    spaceAddress.setAddressSpace(startCellNumber + 0, 1);
                } else {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber,0, 0));
                    spaceAddress.setAddressSpace(startCellNumber + 0, 0);
                }
            }
        });
        arrayList.add(switch_tk_1_1);
        switch_tk_1_2 = root.findViewById(R.id.switch_tk_1_2);
        switch_tk_1_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch_tk_1_2.isChecked()) {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber,0, 1));
                    spaceAddress.setAddressSpace(startCellNumber + 0, 1);
                } else {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber,0, 0));
                    spaceAddress.setAddressSpace(startCellNumber + 0, 0);
                }
            }
        });
        arrayList.add(switch_tk_1_2);
        switch_tk_1_3 = root.findViewById(R.id.switch_tk_1_3);
        switch_tk_1_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch_tk_1_3.isChecked()) {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber,0, 1));
                    spaceAddress.setAddressSpace(startCellNumber + 0, 1);
                } else {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber,0, 0));
                    spaceAddress.setAddressSpace(startCellNumber + 0, 0);
                }
            }
        });
        arrayList.add(switch_tk_1_3);
        switch_tk_1_4 = root.findViewById(R.id.switch_tk_1_4);
        switch_tk_1_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch_tk_1_4.isChecked()) {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber,0, 1));
                    spaceAddress.setAddressSpace(startCellNumber + 0, 1);
                } else {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber,0, 0));
                    spaceAddress.setAddressSpace(startCellNumber + 0, 0);
                }
            }
        });
        arrayList.add(switch_tk_1_4);
        switch_tk_1_5 = root.findViewById(R.id.switch_tk_1_5);
        switch_tk_1_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch_tk_1_5.isChecked()) {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber,0, 1));
                    spaceAddress.setAddressSpace(startCellNumber + 0, 1);
                } else {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber,0, 0));
                    spaceAddress.setAddressSpace(startCellNumber + 0, 0);
                }
            }
        });
        arrayList.add(switch_tk_1_5);
        switch_tk_1_6 = root.findViewById(R.id.switch_tk_1_6);
        switch_tk_1_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch_tk_1_6.isChecked()) {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber,0, 1));
                    spaceAddress.setAddressSpace(startCellNumber + 0, 1);
                } else {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber,0, 0));
                    spaceAddress.setAddressSpace(startCellNumber + 0, 0);
                }
            }
        });
        arrayList.add(switch_tk_1_6);
        switch_tk_1_7 = root.findViewById(R.id.switch_tk_1_7);
        switch_tk_1_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch_tk_1_7.isChecked()) {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber,0, 1));
                    spaceAddress.setAddressSpace(startCellNumber + 0, 1);
                } else {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber,0, 0));
                    spaceAddress.setAddressSpace(startCellNumber + 0, 0);
                }
            }
        });
        arrayList.add(switch_tk_1_7);

        switch_tk_2_0 = root.findViewById(R.id.switch_tk_2_0);
        switch_tk_2_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch_tk_2_0.isChecked()) {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber,0, 1));
                    spaceAddress.setAddressSpace(startCellNumber + 0, 1);
                } else {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber,0, 0));
                    spaceAddress.setAddressSpace(startCellNumber + 0, 0);
                }
            }
        });
        arrayList.add(switch_tk_2_0);
        switch_tk_2_1 = root.findViewById(R.id.switch_tk_2_1);
        switch_tk_2_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch_tk_2_1.isChecked()) {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber,0, 1));
                    spaceAddress.setAddressSpace(startCellNumber + 0, 1);
                } else {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber,0, 0));
                    spaceAddress.setAddressSpace(startCellNumber + 0, 0);
                }
            }
        });
        arrayList.add(switch_tk_2_1);
        switch_tk_2_2 = root.findViewById(R.id.switch_tk_2_2);
        switch_tk_2_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch_tk_2_2.isChecked()) {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber,0, 1));
                    spaceAddress.setAddressSpace(startCellNumber + 0, 1);
                } else {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber,0, 0));
                    spaceAddress.setAddressSpace(startCellNumber + 0, 0);
                }
            }
        });
        arrayList.add(switch_tk_2_2);
        switch_tk_2_3 = root.findViewById(R.id.switch_tk_2_3);
        switch_tk_2_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch_tk_2_3.isChecked()) {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber,0, 1));
                    spaceAddress.setAddressSpace(startCellNumber + 0, 1);
                } else {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber,0, 0));
                    spaceAddress.setAddressSpace(startCellNumber + 0, 0);
                }
            }
        });
        arrayList.add(switch_tk_2_3);
        switch_tk_2_4 = root.findViewById(R.id.switch_tk_2_4);
        switch_tk_2_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch_tk_2_4.isChecked()) {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber,0, 1));
                    spaceAddress.setAddressSpace(startCellNumber + 0, 1);
                } else {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber,0, 0));
                    spaceAddress.setAddressSpace(startCellNumber + 0, 0);
                }
            }
        });
        arrayList.add(switch_tk_2_4);
        switch_tk_2_5 = root.findViewById(R.id.switch_tk_2_5);
        switch_tk_2_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch_tk_2_5.isChecked()) {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber,0, 1));
                    spaceAddress.setAddressSpace(startCellNumber + 0, 1);
                } else {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber,0, 0));
                    spaceAddress.setAddressSpace(startCellNumber + 0, 0);
                }
            }
        });
        arrayList.add(switch_tk_2_5);
        switch_tk_2_6 = root.findViewById(R.id.switch_tk_2_6);
        switch_tk_2_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch_tk_2_6.isChecked()) {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber,0, 1));
                    spaceAddress.setAddressSpace(startCellNumber + 0, 1);
                } else {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber,0, 0));
                    spaceAddress.setAddressSpace(startCellNumber + 0, 0);
                }
            }
        });
        arrayList.add(switch_tk_2_6);
        switch_tk_2_7 = root.findViewById(R.id.switch_tk_2_7);
        switch_tk_2_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch_tk_2_7.isChecked()) {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber,0, 1));
                    spaceAddress.setAddressSpace(startCellNumber + 0, 1);
                } else {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber,0, 0));
                    spaceAddress.setAddressSpace(startCellNumber + 0, 0);
                }
            }
        });
        arrayList.add(switch_tk_2_7);

        switch_tk_3_0 = root.findViewById(R.id.switch_tk_3_0);
        switch_tk_3_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch_tk_3_0.isChecked()) {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber,0, 1));
                    spaceAddress.setAddressSpace(startCellNumber + 0, 1);
                } else {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber,0, 0));
                    spaceAddress.setAddressSpace(startCellNumber + 0, 0);
                }
            }
        });
        arrayList.add(switch_tk_3_0);
        switch_tk_3_1 = root.findViewById(R.id.switch_tk_3_1);
        switch_tk_3_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch_tk_3_1.isChecked()) {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber,0, 1));
                    spaceAddress.setAddressSpace(startCellNumber + 0, 1);
                } else {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber,0, 0));
                    spaceAddress.setAddressSpace(startCellNumber + 0, 0);
                }
            }
        });
        arrayList.add(switch_tk_3_1);
        switch_tk_3_2 = root.findViewById(R.id.switch_tk_3_2);
        switch_tk_3_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch_tk_3_2.isChecked()) {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber,0, 1));
                    spaceAddress.setAddressSpace(startCellNumber + 0, 1);
                } else {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber,0, 0));
                    spaceAddress.setAddressSpace(startCellNumber + 0, 0);
                }
            }
        });
        arrayList.add(switch_tk_3_2);
        switch_tk_3_3 = root.findViewById(R.id.switch_tk_3_3);
        switch_tk_3_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch_tk_3_3.isChecked()) {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber,0, 1));
                    spaceAddress.setAddressSpace(startCellNumber + 0, 1);
                } else {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber,0, 0));
                    spaceAddress.setAddressSpace(startCellNumber + 0, 0);
                }
            }
        });
        arrayList.add(switch_tk_3_3);
        switch_tk_3_4 = root.findViewById(R.id.switch_tk_3_4);
        switch_tk_3_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch_tk_3_4.isChecked()) {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber,0, 1));
                    spaceAddress.setAddressSpace(startCellNumber + 0, 1);
                } else {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber,0, 0));
                    spaceAddress.setAddressSpace(startCellNumber + 0, 0);
                }
            }
        });
        arrayList.add(switch_tk_3_4);
        switch_tk_3_5 = root.findViewById(R.id.switch_tk_3_5);
        switch_tk_3_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch_tk_3_5.isChecked()) {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber,0, 1));
                    spaceAddress.setAddressSpace(startCellNumber + 0, 1);
                } else {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber,0, 0));
                    spaceAddress.setAddressSpace(startCellNumber + 0, 0);
                }
            }
        });
        arrayList.add(switch_tk_3_5);
        switch_tk_3_6 = root.findViewById(R.id.switch_tk_3_6);
        switch_tk_3_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch_tk_3_6.isChecked()) {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber,0, 1));
                    spaceAddress.setAddressSpace(startCellNumber + 0, 1);
                } else {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber,0, 0));
                    spaceAddress.setAddressSpace(startCellNumber + 0, 0);
                }
            }
        });
        arrayList.add(switch_tk_3_6);
        switch_tk_3_7 = root.findViewById(R.id.switch_tk_3_7);
        switch_tk_3_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch_tk_3_7.isChecked()) {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber,0, 1));
                    spaceAddress.setAddressSpace(startCellNumber + 0, 1);
                } else {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber,0, 0));
                    spaceAddress.setAddressSpace(startCellNumber + 0, 0);
                }
            }
        });
        arrayList.add(switch_tk_3_7);

        switch_tk_4_0 = root.findViewById(R.id.switch_tk_4_0);
        switch_tk_4_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch_tk_4_0.isChecked()) {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber,0, 1));
                    spaceAddress.setAddressSpace(startCellNumber + 0, 1);
                } else {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber,0, 0));
                    spaceAddress.setAddressSpace(startCellNumber + 0, 0);
                }
            }
        });
        arrayList.add(switch_tk_4_0);
        switch_tk_4_1 = root.findViewById(R.id.switch_tk_4_1);
        switch_tk_4_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch_tk_4_1.isChecked()) {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber,0, 1));
                    spaceAddress.setAddressSpace(startCellNumber + 0, 1);
                } else {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber,0, 0));
                    spaceAddress.setAddressSpace(startCellNumber + 0, 0);
                }
            }
        });
        arrayList.add(switch_tk_4_1);
        switch_tk_4_2 = root.findViewById(R.id.switch_tk_4_2);
        switch_tk_4_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch_tk_4_2.isChecked()) {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber,0, 1));
                    spaceAddress.setAddressSpace(startCellNumber + 0, 1);
                } else {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber,0, 0));
                    spaceAddress.setAddressSpace(startCellNumber + 0, 0);
                }
            }
        });
        arrayList.add(switch_tk_4_2);
        switch_tk_4_3 = root.findViewById(R.id.switch_tk_4_3);
        switch_tk_4_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch_tk_4_3.isChecked()) {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber,0, 1));
                    spaceAddress.setAddressSpace(startCellNumber + 0, 1);
                } else {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber,0, 0));
                    spaceAddress.setAddressSpace(startCellNumber + 0, 0);
                }
            }
        });
        arrayList.add(switch_tk_4_3);
        switch_tk_4_4 = root.findViewById(R.id.switch_tk_4_4);
        switch_tk_4_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch_tk_4_4.isChecked()) {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber,0, 1));
                    spaceAddress.setAddressSpace(startCellNumber + 0, 1);
                } else {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber,0, 0));
                    spaceAddress.setAddressSpace(startCellNumber + 0, 0);
                }
            }
        });
        arrayList.add(switch_tk_4_4);
        switch_tk_4_5 = root.findViewById(R.id.switch_tk_4_5);
        switch_tk_4_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch_tk_4_5.isChecked()) {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber,0, 1));
                    spaceAddress.setAddressSpace(startCellNumber + 0, 1);
                } else {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber,0, 0));
                    spaceAddress.setAddressSpace(startCellNumber + 0, 0);
                }
            }
        });
        arrayList.add(switch_tk_4_5);
        switch_tk_4_6 = root.findViewById(R.id.switch_tk_4_6);
        switch_tk_4_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch_tk_4_6.isChecked()) {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber,0, 1));
                    spaceAddress.setAddressSpace(startCellNumber + 0, 1);
                } else {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber,0, 0));
                    spaceAddress.setAddressSpace(startCellNumber + 0, 0);
                }
            }
        });
        arrayList.add(switch_tk_4_6);
        switch_tk_4_7 = root.findViewById(R.id.switch_tk_4_7);
        switch_tk_4_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch_tk_4_7.isChecked()) {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber,0, 1));
                    spaceAddress.setAddressSpace(startCellNumber + 0, 1);
                } else {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber,0, 0));
                    spaceAddress.setAddressSpace(startCellNumber + 0, 0);
                }
            }
        });
        arrayList.add(switch_tk_4_7);

        switch_tk_5_0 = root.findViewById(R.id.switch_tk_5_0);
        switch_tk_5_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch_tk_5_0.isChecked()) {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber,0, 1));
                    spaceAddress.setAddressSpace(startCellNumber + 0, 1);
                } else {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber,0, 0));
                    spaceAddress.setAddressSpace(startCellNumber + 0, 0);
                }
            }
        });
        arrayList.add(switch_tk_5_0);
        switch_tk_5_1 = root.findViewById(R.id.switch_tk_5_1);
        switch_tk_5_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch_tk_5_1.isChecked()) {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber,0, 1));
                    spaceAddress.setAddressSpace(startCellNumber + 0, 1);
                } else {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber,0, 0));
                    spaceAddress.setAddressSpace(startCellNumber + 0, 0);
                }
            }
        });
        arrayList.add(switch_tk_5_1);
        switch_tk_5_2 = root.findViewById(R.id.switch_tk_5_2);
        switch_tk_5_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch_tk_5_2.isChecked()) {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber,0, 1));
                    spaceAddress.setAddressSpace(startCellNumber + 0, 1);
                } else {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber,0, 0));
                    spaceAddress.setAddressSpace(startCellNumber + 0, 0);
                }
            }
        });
        arrayList.add(switch_tk_5_2);
        switch_tk_5_3 = root.findViewById(R.id.switch_tk_5_3);
        switch_tk_5_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch_tk_5_3.isChecked()) {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber,0, 1));
                    spaceAddress.setAddressSpace(startCellNumber + 0, 1);
                } else {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber,0, 0));
                    spaceAddress.setAddressSpace(startCellNumber + 0, 0);
                }
            }
        });
        arrayList.add(switch_tk_5_3);
        switch_tk_5_4 = root.findViewById(R.id.switch_tk_5_4);
        switch_tk_5_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch_tk_5_4.isChecked()) {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber,0, 1));
                    spaceAddress.setAddressSpace(startCellNumber + 0, 1);
                } else {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber,0, 0));
                    spaceAddress.setAddressSpace(startCellNumber + 0, 0);
                }
            }
        });
        arrayList.add(switch_tk_5_4);
        switch_tk_5_5 = root.findViewById(R.id.switch_tk_5_5);
        switch_tk_5_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch_tk_5_5.isChecked()) {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber,0, 1));
                    spaceAddress.setAddressSpace(startCellNumber + 0, 1);
                } else {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber,0, 0));
                    spaceAddress.setAddressSpace(startCellNumber + 0, 0);
                }
            }
        });
        arrayList.add(switch_tk_5_5);
        switch_tk_5_6 = root.findViewById(R.id.switch_tk_5_6);
        switch_tk_5_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch_tk_5_6.isChecked()) {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber,0, 1));
                    spaceAddress.setAddressSpace(startCellNumber + 0, 1);
                } else {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber,0, 0));
                    spaceAddress.setAddressSpace(startCellNumber + 0, 0);
                }
            }
        });
        arrayList.add(switch_tk_5_6);
        switch_tk_5_7 = root.findViewById(R.id.switch_tk_5_7);
        switch_tk_5_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch_tk_5_7.isChecked()) {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber,0, 1));
                    spaceAddress.setAddressSpace(startCellNumber + 0, 1);
                } else {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber,0, 0));
                    spaceAddress.setAddressSpace(startCellNumber + 0, 0);
                }
            }
        });
        arrayList.add(switch_tk_5_7);

        switch_tk_6_0 = root.findViewById(R.id.switch_tk_6_0);
        switch_tk_6_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch_tk_6_0.isChecked()) {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber,0, 1));
                    spaceAddress.setAddressSpace(startCellNumber + 0, 1);
                } else {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber,0, 0));
                    spaceAddress.setAddressSpace(startCellNumber + 0, 0);
                }
            }
        });
        arrayList.add(switch_tk_6_0);
        switch_tk_6_1 = root.findViewById(R.id.switch_tk_6_1);
        switch_tk_6_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch_tk_6_1.isChecked()) {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber,0, 1));
                    spaceAddress.setAddressSpace(startCellNumber + 0, 1);
                } else {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber,0, 0));
                    spaceAddress.setAddressSpace(startCellNumber + 0, 0);
                }
            }
        });
        arrayList.add(switch_tk_6_1);
        switch_tk_6_2 = root.findViewById(R.id.switch_tk_6_2);
        switch_tk_6_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch_tk_6_2.isChecked()) {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber,0, 1));
                    spaceAddress.setAddressSpace(startCellNumber + 0, 1);
                } else {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber,0, 0));
                    spaceAddress.setAddressSpace(startCellNumber + 0, 0);
                }
            }
        });
        arrayList.add(switch_tk_6_2);
        switch_tk_6_3 = root.findViewById(R.id.switch_tk_6_3);
        switch_tk_6_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch_tk_6_3.isChecked()) {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber,0, 1));
                    spaceAddress.setAddressSpace(startCellNumber + 0, 1);
                } else {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber,0, 0));
                    spaceAddress.setAddressSpace(startCellNumber + 0, 0);
                }
            }
        });
        arrayList.add(switch_tk_6_3);
        switch_tk_6_4 = root.findViewById(R.id.switch_tk_6_4);
        switch_tk_6_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch_tk_6_4.isChecked()) {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber,0, 1));
                    spaceAddress.setAddressSpace(startCellNumber + 0, 1);
                } else {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber,0, 0));
                    spaceAddress.setAddressSpace(startCellNumber + 0, 0);
                }
            }
        });
        arrayList.add(switch_tk_6_4);
        switch_tk_6_5 = root.findViewById(R.id.switch_tk_6_5);
        switch_tk_6_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch_tk_6_5.isChecked()) {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber,0, 1));
                    spaceAddress.setAddressSpace(startCellNumber + 0, 1);
                } else {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber,0, 0));
                    spaceAddress.setAddressSpace(startCellNumber + 0, 0);
                }
            }
        });
        arrayList.add(switch_tk_6_5);
        switch_tk_6_6 = root.findViewById(R.id.switch_tk_6_6);
        switch_tk_6_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch_tk_6_6.isChecked()) {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber,0, 1));
                    spaceAddress.setAddressSpace(startCellNumber + 0, 1);
                } else {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber,0, 0));
                    spaceAddress.setAddressSpace(startCellNumber + 0, 0);
                }
            }
        });
        arrayList.add(switch_tk_6_6);
        switch_tk_6_7 = root.findViewById(R.id.switch_tk_6_7);
        switch_tk_6_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch_tk_6_7.isChecked()) {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber,0, 1));
                    spaceAddress.setAddressSpace(startCellNumber + 0, 1);
                } else {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber,0, 0));
                    spaceAddress.setAddressSpace(startCellNumber + 0, 0);
                }
            }
        });
        arrayList.add(switch_tk_6_7);

        switch_tk_7_0 = root.findViewById(R.id.switch_tk_7_0);
        switch_tk_7_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch_tk_7_0.isChecked()) {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber,0, 1));
                    spaceAddress.setAddressSpace(startCellNumber + 0, 1);
                } else {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber,0, 0));
                    spaceAddress.setAddressSpace(startCellNumber + 0, 0);
                }
            }
        });
        arrayList.add(switch_tk_7_0);
        switch_tk_7_1 = root.findViewById(R.id.switch_tk_7_1);
        switch_tk_7_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch_tk_7_1.isChecked()) {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber,0, 1));
                    spaceAddress.setAddressSpace(startCellNumber + 0, 1);
                } else {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber,0, 0));
                    spaceAddress.setAddressSpace(startCellNumber + 0, 0);
                }
            }
        });
        arrayList.add(switch_tk_7_1);
        switch_tk_7_2 = root.findViewById(R.id.switch_tk_7_2);
        switch_tk_7_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch_tk_7_2.isChecked()) {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber,0, 1));
                    spaceAddress.setAddressSpace(startCellNumber + 0, 1);
                } else {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber,0, 0));
                    spaceAddress.setAddressSpace(startCellNumber + 0, 0);
                }
            }
        });
        arrayList.add(switch_tk_7_2);
        switch_tk_7_3 = root.findViewById(R.id.switch_tk_7_3);
        switch_tk_7_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch_tk_7_3.isChecked()) {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber,0, 1));
                    spaceAddress.setAddressSpace(startCellNumber + 0, 1);
                } else {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber,0, 0));
                    spaceAddress.setAddressSpace(startCellNumber + 0, 0);
                }
            }
        });
        arrayList.add(switch_tk_7_3);
        switch_tk_7_4 = root.findViewById(R.id.switch_tk_7_4);
        switch_tk_7_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch_tk_7_4.isChecked()) {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber,0, 1));
                    spaceAddress.setAddressSpace(startCellNumber + 0, 1);
                } else {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber,0, 0));
                    spaceAddress.setAddressSpace(startCellNumber + 0, 0);
                }
            }
        });
        arrayList.add(switch_tk_7_4);
        switch_tk_7_5 = root.findViewById(R.id.switch_tk_7_5);
        switch_tk_7_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch_tk_7_5.isChecked()) {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber,0, 1));
                    spaceAddress.setAddressSpace(startCellNumber + 0, 1);
                } else {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber,0, 0));
                    spaceAddress.setAddressSpace(startCellNumber + 0, 0);
                }
            }
        });
        arrayList.add(switch_tk_7_5);
        switch_tk_7_6 = root.findViewById(R.id.switch_tk_7_6);
        switch_tk_7_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch_tk_7_6.isChecked()) {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber,0, 1));
                    spaceAddress.setAddressSpace(startCellNumber + 0, 1);
                } else {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber,0, 0));
                    spaceAddress.setAddressSpace(startCellNumber + 0, 0);
                }
            }
        });
        arrayList.add(switch_tk_7_6);
        switch_tk_7_7 = root.findViewById(R.id.switch_tk_7_7);
        switch_tk_7_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch_tk_7_7.isChecked()) {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber,0, 1));
                    spaceAddress.setAddressSpace(startCellNumber + 0, 1);
                } else {
                    spaceAddress.setElementQueue(new ElementQueue(sectionNumber,0, 0));
                    spaceAddress.setAddressSpace(startCellNumber + 0, 0);
                }
            }
        });
        arrayList.add(switch_tk_7_7);

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

    private void upDateEnables() {
        if (spaceStatus.isReadyFlagRecordingInitialValues()) {
            switch_tk_0_0.post(new Runnable() {
                @Override
                public void run() {
                    switch_tk_0_0.setEnabled(false);
                }
            });
            switch_tk_0_1.post(new Runnable() {
                @Override
                public void run() {
                    switch_tk_0_1.setEnabled(false);
                }
            });
            switch_tk_0_2.post(new Runnable() {
                @Override
                public void run() {
                    switch_tk_0_2.setEnabled(false);
                }
            });
            switch_tk_0_3.post(new Runnable() {
                @Override
                public void run() {
                    switch_tk_0_3.setEnabled(false);
                }
            });
            switch_tk_0_4.post(new Runnable() {
                @Override
                public void run() {
                    switch_tk_0_4.setEnabled(false);
                }
            });
            switch_tk_0_5.post(new Runnable() {
                @Override
                public void run() {
                    switch_tk_0_5.setEnabled(false);
                }
            });
            switch_tk_0_6.post(new Runnable() {
                @Override
                public void run() {
                    switch_tk_0_6.setEnabled(false);
                }
            });
            switch_tk_0_7.post(new Runnable() {
                @Override
                public void run() {
                    switch_tk_0_7.setEnabled(false);
                }
            });

            switch_tk_1_0.post(new Runnable() {
                @Override
                public void run() {
                    switch_tk_1_0.setEnabled(false);
                }
            });
            switch_tk_1_1.post(new Runnable() {
                @Override
                public void run() {
                    switch_tk_1_1.setEnabled(false);
                }
            });
            switch_tk_1_2.post(new Runnable() {
                @Override
                public void run() {
                    switch_tk_1_2.setEnabled(false);
                }
            });
            switch_tk_1_3.post(new Runnable() {
                @Override
                public void run() {
                    switch_tk_1_3.setEnabled(false);
                }
            });
            switch_tk_1_4.post(new Runnable() {
                @Override
                public void run() {
                    switch_tk_1_4.setEnabled(false);
                }
            });
            switch_tk_1_5.post(new Runnable() {
                @Override
                public void run() {
                    switch_tk_1_5.setEnabled(false);
                }
            });
            switch_tk_1_6.post(new Runnable() {
                @Override
                public void run() {
                    switch_tk_1_6.setEnabled(false);
                }
            });
            switch_tk_1_7.post(new Runnable() {
                @Override
                public void run() {
                    switch_tk_1_7.setEnabled(false);
                }
            });

            switch_tk_2_0.post(new Runnable() {
                @Override
                public void run() {
                    switch_tk_2_0.setEnabled(false);
                }
            });
            switch_tk_2_1.post(new Runnable() {
                @Override
                public void run() {
                    switch_tk_2_1.setEnabled(false);
                }
            });
            switch_tk_2_2.post(new Runnable() {
                @Override
                public void run() {
                    switch_tk_2_2.setEnabled(false);
                }
            });
            switch_tk_2_3.post(new Runnable() {
                @Override
                public void run() {
                    switch_tk_2_3.setEnabled(false);
                }
            });
            switch_tk_2_4.post(new Runnable() {
                @Override
                public void run() {
                    switch_tk_2_4.setEnabled(false);
                }
            });
            switch_tk_2_5.post(new Runnable() {
                @Override
                public void run() {
                    switch_tk_2_5.setEnabled(false);
                }
            });
            switch_tk_2_6.post(new Runnable() {
                @Override
                public void run() {
                    switch_tk_2_6.setEnabled(false);
                }
            });
            switch_tk_2_7.post(new Runnable() {
                @Override
                public void run() {
                    switch_tk_2_7.setEnabled(false);
                }
            });

            switch_tk_3_0.post(new Runnable() {
                @Override
                public void run() {
                    switch_tk_3_0.setEnabled(false);
                }
            });
            switch_tk_3_1.post(new Runnable() {
                @Override
                public void run() {
                    switch_tk_3_1.setEnabled(false);
                }
            });
            switch_tk_3_2.post(new Runnable() {
                @Override
                public void run() {
                    switch_tk_3_2.setEnabled(false);
                }
            });
            switch_tk_3_3.post(new Runnable() {
                @Override
                public void run() {
                    switch_tk_3_3.setEnabled(false);
                }
            });
            switch_tk_3_4.post(new Runnable() {
                @Override
                public void run() {
                    switch_tk_3_4.setEnabled(false);
                }
            });
            switch_tk_3_5.post(new Runnable() {
                @Override
                public void run() {
                    switch_tk_3_5.setEnabled(false);
                }
            });
            switch_tk_3_6.post(new Runnable() {
                @Override
                public void run() {
                    switch_tk_3_6.setEnabled(false);
                }
            });
            switch_tk_3_7.post(new Runnable() {
                @Override
                public void run() {
                    switch_tk_3_7.setEnabled(false);
                }
            });

            switch_tk_4_0.post(new Runnable() {
                @Override
                public void run() {
                    switch_tk_4_0.setEnabled(false);
                }
            });
            switch_tk_4_1.post(new Runnable() {
                @Override
                public void run() {
                    switch_tk_4_1.setEnabled(false);
                }
            });
            switch_tk_4_2.post(new Runnable() {
                @Override
                public void run() {
                    switch_tk_4_2.setEnabled(false);
                }
            });
            switch_tk_4_3.post(new Runnable() {
                @Override
                public void run() {
                    switch_tk_4_3.setEnabled(false);
                }
            });
            switch_tk_4_4.post(new Runnable() {
                @Override
                public void run() {
                    switch_tk_4_4.setEnabled(false);
                }
            });
            switch_tk_4_5.post(new Runnable() {
                @Override
                public void run() {
                    switch_tk_4_5.setEnabled(false);
                }
            });
            switch_tk_4_6.post(new Runnable() {
                @Override
                public void run() {
                    switch_tk_4_6.setEnabled(false);
                }
            });
            switch_tk_4_7.post(new Runnable() {
                @Override
                public void run() {
                    switch_tk_4_7.setEnabled(false);
                }
            });

            switch_tk_5_0.post(new Runnable() {
                @Override
                public void run() {
                    switch_tk_5_0.setEnabled(false);
                }
            });
            switch_tk_5_1.post(new Runnable() {
                @Override
                public void run() {
                    switch_tk_5_1.setEnabled(false);
                }
            });
            switch_tk_5_2.post(new Runnable() {
                @Override
                public void run() {
                    switch_tk_5_2.setEnabled(false);
                }
            });
            switch_tk_5_3.post(new Runnable() {
                @Override
                public void run() {
                    switch_tk_5_3.setEnabled(false);
                }
            });
            switch_tk_5_4.post(new Runnable() {
                @Override
                public void run() {
                    switch_tk_5_4.setEnabled(false);
                }
            });
            switch_tk_5_5.post(new Runnable() {
                @Override
                public void run() {
                    switch_tk_5_5.setEnabled(false);
                }
            });
            switch_tk_5_6.post(new Runnable() {
                @Override
                public void run() {
                    switch_tk_5_6.setEnabled(false);
                }
            });
            switch_tk_5_7.post(new Runnable() {
                @Override
                public void run() {
                    switch_tk_5_7.setEnabled(false);
                }
            });

            switch_tk_6_0.post(new Runnable() {
                @Override
                public void run() {
                    switch_tk_6_0.setEnabled(false);
                }
            });
            switch_tk_6_1.post(new Runnable() {
                @Override
                public void run() {
                    switch_tk_6_1.setEnabled(false);
                }
            });
            switch_tk_6_2.post(new Runnable() {
                @Override
                public void run() {
                    switch_tk_6_2.setEnabled(false);
                }
            });
            switch_tk_6_3.post(new Runnable() {
                @Override
                public void run() {
                    switch_tk_6_3.setEnabled(false);
                }
            });
            switch_tk_6_4.post(new Runnable() {
                @Override
                public void run() {
                    switch_tk_6_4.setEnabled(false);
                }
            });
            switch_tk_6_5.post(new Runnable() {
                @Override
                public void run() {
                    switch_tk_6_5.setEnabled(false);
                }
            });
            switch_tk_6_6.post(new Runnable() {
                @Override
                public void run() {
                    switch_tk_6_6.setEnabled(false);
                }
            });
            switch_tk_6_7.post(new Runnable() {
                @Override
                public void run() {
                    switch_tk_6_7.setEnabled(false);
                }
            });

            switch_tk_7_0.post(new Runnable() {
                @Override
                public void run() {
                    switch_tk_7_0.setEnabled(false);
                }
            });
            switch_tk_7_1.post(new Runnable() {
                @Override
                public void run() {
                    switch_tk_7_1.setEnabled(false);
                }
            });
            switch_tk_7_2.post(new Runnable() {
                @Override
                public void run() {
                    switch_tk_7_2.setEnabled(false);
                }
            });
            switch_tk_7_3.post(new Runnable() {
                @Override
                public void run() {
                    switch_tk_7_3.setEnabled(false);
                }
            });
            switch_tk_7_4.post(new Runnable() {
                @Override
                public void run() {
                    switch_tk_7_4.setEnabled(false);
                }
            });
            switch_tk_7_5.post(new Runnable() {
                @Override
                public void run() {
                    switch_tk_7_5.setEnabled(false);
                }
            });
            switch_tk_7_6.post(new Runnable() {
                @Override
                public void run() {
                    switch_tk_7_6.setEnabled(false);
                }
            });
            switch_tk_7_7.post(new Runnable() {
                @Override
                public void run() {
                    switch_tk_7_7.setEnabled(false);
                }
            });
        } else {
            switch_tk_0_0.post(new Runnable() {
                @Override
                public void run() {
                    switch_tk_0_0.setEnabled(true);
                }
            });
            switch_tk_0_1.post(new Runnable() {
                @Override
                public void run() {
                    switch_tk_0_1.setEnabled(true);
                }
            });
            switch_tk_0_2.post(new Runnable() {
                @Override
                public void run() {
                    switch_tk_0_2.setEnabled(true);
                }
            });
            switch_tk_0_3.post(new Runnable() {
                @Override
                public void run() {
                    switch_tk_0_3.setEnabled(true);
                }
            });
            switch_tk_0_4.post(new Runnable() {
                @Override
                public void run() {
                    switch_tk_0_4.setEnabled(true);
                }
            });
            switch_tk_0_5.post(new Runnable() {
                @Override
                public void run() {
                    switch_tk_0_5.setEnabled(true);
                }
            });
            switch_tk_0_6.post(new Runnable() {
                @Override
                public void run() {
                    switch_tk_0_6.setEnabled(true);
                }
            });
            switch_tk_0_7.post(new Runnable() {
                @Override
                public void run() {
                    switch_tk_0_7.setEnabled(true);
                }
            });

            switch_tk_1_0.post(new Runnable() {
                @Override
                public void run() {
                    switch_tk_1_0.setEnabled(true);
                }
            });
            switch_tk_1_1.post(new Runnable() {
                @Override
                public void run() {
                    switch_tk_1_1.setEnabled(true);
                }
            });
            switch_tk_1_2.post(new Runnable() {
                @Override
                public void run() {
                    switch_tk_1_2.setEnabled(true);
                }
            });
            switch_tk_1_3.post(new Runnable() {
                @Override
                public void run() {
                    switch_tk_1_3.setEnabled(true);
                }
            });
            switch_tk_1_4.post(new Runnable() {
                @Override
                public void run() {
                    switch_tk_1_4.setEnabled(true);
                }
            });
            switch_tk_1_5.post(new Runnable() {
                @Override
                public void run() {
                    switch_tk_1_5.setEnabled(true);
                }
            });
            switch_tk_1_6.post(new Runnable() {
                @Override
                public void run() {
                    switch_tk_1_6.setEnabled(true);
                }
            });
            switch_tk_1_7.post(new Runnable() {
                @Override
                public void run() {
                    switch_tk_1_7.setEnabled(true);
                }
            });

            switch_tk_2_0.post(new Runnable() {
                @Override
                public void run() {
                    switch_tk_2_0.setEnabled(true);
                }
            });
            switch_tk_2_1.post(new Runnable() {
                @Override
                public void run() {
                    switch_tk_2_1.setEnabled(true);
                }
            });
            switch_tk_2_2.post(new Runnable() {
                @Override
                public void run() {
                    switch_tk_2_2.setEnabled(true);
                }
            });
            switch_tk_2_3.post(new Runnable() {
                @Override
                public void run() {
                    switch_tk_2_3.setEnabled(true);
                }
            });
            switch_tk_2_4.post(new Runnable() {
                @Override
                public void run() {
                    switch_tk_2_4.setEnabled(true);
                }
            });
            switch_tk_2_5.post(new Runnable() {
                @Override
                public void run() {
                    switch_tk_2_5.setEnabled(true);
                }
            });
            switch_tk_2_6.post(new Runnable() {
                @Override
                public void run() {
                    switch_tk_2_6.setEnabled(true);
                }
            });
            switch_tk_2_7.post(new Runnable() {
                @Override
                public void run() {
                    switch_tk_2_7.setEnabled(true);
                }
            });

            switch_tk_3_0.post(new Runnable() {
                @Override
                public void run() {
                    switch_tk_3_0.setEnabled(true);
                }
            });
            switch_tk_3_1.post(new Runnable() {
                @Override
                public void run() {
                    switch_tk_3_1.setEnabled(true);
                }
            });
            switch_tk_3_2.post(new Runnable() {
                @Override
                public void run() {
                    switch_tk_3_2.setEnabled(true);
                }
            });
            switch_tk_3_3.post(new Runnable() {
                @Override
                public void run() {
                    switch_tk_3_3.setEnabled(true);
                }
            });
            switch_tk_3_4.post(new Runnable() {
                @Override
                public void run() {
                    switch_tk_3_4.setEnabled(true);
                }
            });
            switch_tk_3_5.post(new Runnable() {
                @Override
                public void run() {
                    switch_tk_3_5.setEnabled(true);
                }
            });
            switch_tk_3_6.post(new Runnable() {
                @Override
                public void run() {
                    switch_tk_3_6.setEnabled(true);
                }
            });
            switch_tk_3_7.post(new Runnable() {
                @Override
                public void run() {
                    switch_tk_3_7.setEnabled(true);
                }
            });

            switch_tk_4_0.post(new Runnable() {
                @Override
                public void run() {
                    switch_tk_4_0.setEnabled(true);
                }
            });
            switch_tk_4_1.post(new Runnable() {
                @Override
                public void run() {
                    switch_tk_4_1.setEnabled(true);
                }
            });
            switch_tk_4_2.post(new Runnable() {
                @Override
                public void run() {
                    switch_tk_4_2.setEnabled(true);
                }
            });
            switch_tk_4_3.post(new Runnable() {
                @Override
                public void run() {
                    switch_tk_4_3.setEnabled(true);
                }
            });
            switch_tk_4_4.post(new Runnable() {
                @Override
                public void run() {
                    switch_tk_4_4.setEnabled(true);
                }
            });
            switch_tk_4_5.post(new Runnable() {
                @Override
                public void run() {
                    switch_tk_4_5.setEnabled(true);
                }
            });
            switch_tk_4_6.post(new Runnable() {
                @Override
                public void run() {
                    switch_tk_4_6.setEnabled(true);
                }
            });
            switch_tk_4_7.post(new Runnable() {
                @Override
                public void run() {
                    switch_tk_4_7.setEnabled(true);
                }
            });

            switch_tk_5_0.post(new Runnable() {
                @Override
                public void run() {
                    switch_tk_5_0.setEnabled(true);
                }
            });
            switch_tk_5_1.post(new Runnable() {
                @Override
                public void run() {
                    switch_tk_5_1.setEnabled(true);
                }
            });
            switch_tk_5_2.post(new Runnable() {
                @Override
                public void run() {
                    switch_tk_5_2.setEnabled(true);
                }
            });
            switch_tk_5_3.post(new Runnable() {
                @Override
                public void run() {
                    switch_tk_5_3.setEnabled(true);
                }
            });
            switch_tk_5_4.post(new Runnable() {
                @Override
                public void run() {
                    switch_tk_5_4.setEnabled(true);
                }
            });
            switch_tk_5_5.post(new Runnable() {
                @Override
                public void run() {
                    switch_tk_5_5.setEnabled(true);
                }
            });
            switch_tk_5_6.post(new Runnable() {
                @Override
                public void run() {
                    switch_tk_5_6.setEnabled(true);
                }
            });
            switch_tk_5_7.post(new Runnable() {
                @Override
                public void run() {
                    switch_tk_5_7.setEnabled(true);
                }
            });

            switch_tk_6_0.post(new Runnable() {
                @Override
                public void run() {
                    switch_tk_6_0.setEnabled(true);
                }
            });
            switch_tk_6_1.post(new Runnable() {
                @Override
                public void run() {
                    switch_tk_6_1.setEnabled(true);
                }
            });
            switch_tk_6_2.post(new Runnable() {
                @Override
                public void run() {
                    switch_tk_6_2.setEnabled(true);
                }
            });
            switch_tk_6_3.post(new Runnable() {
                @Override
                public void run() {
                    switch_tk_6_3.setEnabled(true);
                }
            });
            switch_tk_6_4.post(new Runnable() {
                @Override
                public void run() {
                    switch_tk_6_4.setEnabled(true);
                }
            });
            switch_tk_6_5.post(new Runnable() {
                @Override
                public void run() {
                    switch_tk_6_5.setEnabled(true);
                }
            });
            switch_tk_6_6.post(new Runnable() {
                @Override
                public void run() {
                    switch_tk_6_6.setEnabled(true);
                }
            });
            switch_tk_6_7.post(new Runnable() {
                @Override
                public void run() {
                    switch_tk_6_7.setEnabled(true);
                }
            });

            switch_tk_7_0.post(new Runnable() {
                @Override
                public void run() {
                    switch_tk_7_0.setEnabled(true);
                }
            });
            switch_tk_7_1.post(new Runnable() {
                @Override
                public void run() {
                    switch_tk_7_1.setEnabled(true);
                }
            });
            switch_tk_7_2.post(new Runnable() {
                @Override
                public void run() {
                    switch_tk_7_2.setEnabled(true);
                }
            });
            switch_tk_7_3.post(new Runnable() {
                @Override
                public void run() {
                    switch_tk_7_3.setEnabled(true);
                }
            });
            switch_tk_7_4.post(new Runnable() {
                @Override
                public void run() {
                    switch_tk_7_4.setEnabled(true);
                }
            });
            switch_tk_7_5.post(new Runnable() {
                @Override
                public void run() {
                    switch_tk_7_5.setEnabled(true);
                }
            });
            switch_tk_7_6.post(new Runnable() {
                @Override
                public void run() {
                    switch_tk_7_6.setEnabled(true);
                }
            });
            switch_tk_7_7.post(new Runnable() {
                @Override
                public void run() {
                    switch_tk_7_7.setEnabled(true);
                }
            });
        }
    }

//    @Override
//    public void onClick(View v){
//        for (int i = 0; i < arrayList.size(); i++) {
//            if (arrayList.get(i).isChecked()) {
//                spaceAddress.setAddressSpace(startCellNumber + i, 1);
//            }
//            else {
//                spaceAddress.setAddressSpace(startCellNumber + i, 0);
//            }
//        }
//    }

    public class UpDateGraphicalDisplay extends Thread {
        @Override
        public void run() {
            super.run();
            boolean latch = true;
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
