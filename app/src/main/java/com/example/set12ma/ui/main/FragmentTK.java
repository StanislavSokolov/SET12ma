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
    private SpaceSetting spaceSetting;
    private ResultReceiverAddressSpace resultReceiverAddressSpace;
    private ResultReceiverStatusSpace resultReceiverStatusSpace;
    private ResultReceiverSettingSpace resultReceiverSettingSpace;

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
        resultReceiverSettingSpace = (ResultReceiverSettingSpace) context;
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
        spaceSetting = resultReceiverSettingSpace.getSpaceSetting();
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
                    spaceAddress.setElementQueue(new ElementQueue(spaceSetting.getTkArrayList().get(0).getRegister(), 1));
                    spaceAddress.setAddressSpace(startCellNumber + 0, 1);
                } else {
                    spaceAddress.setElementQueue(new ElementQueue(spaceSetting.getTkArrayList().get(0).getRegister(), 0));
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
                    spaceAddress.setElementQueue(new ElementQueue(spaceSetting.getTkArrayList().get(1).getRegister(), 1));
                    spaceAddress.setAddressSpace(startCellNumber + 1, 1);
                } else {
                    spaceAddress.setElementQueue(new ElementQueue(spaceSetting.getTkArrayList().get(1).getRegister(), 0));
                    spaceAddress.setAddressSpace(startCellNumber + 1, 0);
                }
            }
        });
        arrayList.add(switch_tk_0_1);
        switch_tk_0_2 = root.findViewById(R.id.switch_tk_0_2);
        switch_tk_0_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch_tk_0_2.isChecked()) {
                    spaceAddress.setElementQueue(new ElementQueue(spaceSetting.getTkArrayList().get(2).getRegister(), 1));
                    spaceAddress.setAddressSpace(startCellNumber + 2, 1);
                } else {
                    spaceAddress.setElementQueue(new ElementQueue(spaceSetting.getTkArrayList().get(2).getRegister(), 0));
                    spaceAddress.setAddressSpace(startCellNumber + 2, 0);
                }
            }
        });
        arrayList.add(switch_tk_0_2);
        switch_tk_0_3 = root.findViewById(R.id.switch_tk_0_3);
        switch_tk_0_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch_tk_0_3.isChecked()) {
                    spaceAddress.setElementQueue(new ElementQueue(spaceSetting.getTkArrayList().get(3).getRegister(), 1));
                    spaceAddress.setAddressSpace(startCellNumber + 3, 1);
                } else {
                    spaceAddress.setElementQueue(new ElementQueue(spaceSetting.getTkArrayList().get(3).getRegister(), 0));
                    spaceAddress.setAddressSpace(startCellNumber + 3, 0);
                }
            }
        });
        arrayList.add(switch_tk_0_3);
        switch_tk_0_4 = root.findViewById(R.id.switch_tk_0_4);
        switch_tk_0_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch_tk_0_4.isChecked()) {
                    spaceAddress.setElementQueue(new ElementQueue(spaceSetting.getTkArrayList().get(4).getRegister(), 1));
                    spaceAddress.setAddressSpace(startCellNumber + 4, 1);
                } else {
                    spaceAddress.setElementQueue(new ElementQueue(spaceSetting.getTkArrayList().get(4).getRegister(), 0));
                    spaceAddress.setAddressSpace(startCellNumber + 4, 0);
                }
            }
        });
        arrayList.add(switch_tk_0_4);
        switch_tk_0_5 = root.findViewById(R.id.switch_tk_0_5);
        switch_tk_0_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch_tk_0_5.isChecked()) {
                    spaceAddress.setElementQueue(new ElementQueue(spaceSetting.getTkArrayList().get(5).getRegister(), 1));
                    spaceAddress.setAddressSpace(startCellNumber + 5, 1);
                } else {
                    spaceAddress.setElementQueue(new ElementQueue(spaceSetting.getTkArrayList().get(5).getRegister(), 0));
                    spaceAddress.setAddressSpace(startCellNumber + 5, 0);
                }
            }
        });
        arrayList.add(switch_tk_0_5);
        switch_tk_0_6 = root.findViewById(R.id.switch_tk_0_6);
        switch_tk_0_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch_tk_0_6.isChecked()) {
                    spaceAddress.setElementQueue(new ElementQueue(spaceSetting.getTkArrayList().get(6).getRegister(), 1));
                    spaceAddress.setAddressSpace(startCellNumber + 6, 1);
                } else {
                    spaceAddress.setElementQueue(new ElementQueue(spaceSetting.getTkArrayList().get(6).getRegister(), 0));
                    spaceAddress.setAddressSpace(startCellNumber + 6, 0);
                }
            }
        });
        arrayList.add(switch_tk_0_6);
        switch_tk_0_7 = root.findViewById(R.id.switch_tk_0_7);
        switch_tk_0_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch_tk_0_7.isChecked()) {
                    spaceAddress.setElementQueue(new ElementQueue(spaceSetting.getTkArrayList().get(7).getRegister(), 1));
                    spaceAddress.setAddressSpace(startCellNumber + 7, 1);
                } else {
                    spaceAddress.setElementQueue(new ElementQueue(spaceSetting.getTkArrayList().get(7).getRegister(), 0));
                    spaceAddress.setAddressSpace(startCellNumber + 7, 0);
                }
            }
        });
        arrayList.add(switch_tk_0_7);

        switch_tk_1_0 = root.findViewById(R.id.switch_tk_1_0);
        switch_tk_1_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch_tk_1_0.isChecked()) {
                    spaceAddress.setElementQueue(new ElementQueue(spaceSetting.getTkArrayList().get(8).getRegister(), 1));
                    spaceAddress.setAddressSpace(startCellNumber + 8, 1);
                } else {
                    spaceAddress.setElementQueue(new ElementQueue(spaceSetting.getTkArrayList().get(8).getRegister(), 0));
                    spaceAddress.setAddressSpace(startCellNumber + 8, 0);
                }
            }
        });
        arrayList.add(switch_tk_1_0);
        switch_tk_1_1 = root.findViewById(R.id.switch_tk_1_1);
        switch_tk_1_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch_tk_1_1.isChecked()) {
                    spaceAddress.setElementQueue(new ElementQueue(spaceSetting.getTkArrayList().get(9).getRegister(), 1));
                    spaceAddress.setAddressSpace(startCellNumber + 9, 1);
                } else {
                    spaceAddress.setElementQueue(new ElementQueue(spaceSetting.getTkArrayList().get(9).getRegister(), 0));
                    spaceAddress.setAddressSpace(startCellNumber + 9, 0);
                }
            }
        });
        arrayList.add(switch_tk_1_1);
        switch_tk_1_2 = root.findViewById(R.id.switch_tk_1_2);
        switch_tk_1_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch_tk_1_2.isChecked()) {
                    spaceAddress.setElementQueue(new ElementQueue(spaceSetting.getTkArrayList().get(10).getRegister(), 1));
                    spaceAddress.setAddressSpace(startCellNumber + 10, 1);
                } else {
                    spaceAddress.setElementQueue(new ElementQueue(spaceSetting.getTkArrayList().get(10).getRegister(), 0));
                    spaceAddress.setAddressSpace(startCellNumber + 10, 0);
                }
            }
        });
        arrayList.add(switch_tk_1_2);
        switch_tk_1_3 = root.findViewById(R.id.switch_tk_1_3);
        switch_tk_1_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch_tk_1_3.isChecked()) {
                    spaceAddress.setElementQueue(new ElementQueue(spaceSetting.getTkArrayList().get(11).getRegister(), 1));
                    spaceAddress.setAddressSpace(startCellNumber + 11, 1);
                } else {
                    spaceAddress.setElementQueue(new ElementQueue(spaceSetting.getTkArrayList().get(11).getRegister(), 0));
                    spaceAddress.setAddressSpace(startCellNumber + 11, 0);
                }
            }
        });
        arrayList.add(switch_tk_1_3);
        switch_tk_1_4 = root.findViewById(R.id.switch_tk_1_4);
        switch_tk_1_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch_tk_1_4.isChecked()) {
                    spaceAddress.setElementQueue(new ElementQueue(spaceSetting.getTkArrayList().get(12).getRegister(), 1));
                    spaceAddress.setAddressSpace(startCellNumber + 12, 1);
                } else {
                    spaceAddress.setElementQueue(new ElementQueue(spaceSetting.getTkArrayList().get(12).getRegister(), 0));
                    spaceAddress.setAddressSpace(startCellNumber + 12, 0);
                }
            }
        });
        arrayList.add(switch_tk_1_4);
        switch_tk_1_5 = root.findViewById(R.id.switch_tk_1_5);
        switch_tk_1_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch_tk_1_5.isChecked()) {
                    spaceAddress.setElementQueue(new ElementQueue(spaceSetting.getTkArrayList().get(13).getRegister(), 1));
                    spaceAddress.setAddressSpace(startCellNumber + 13, 1);
                } else {
                    spaceAddress.setElementQueue(new ElementQueue(spaceSetting.getTkArrayList().get(13).getRegister(), 0));
                    spaceAddress.setAddressSpace(startCellNumber + 13, 0);
                }
            }
        });
        arrayList.add(switch_tk_1_5);
        switch_tk_1_6 = root.findViewById(R.id.switch_tk_1_6);
        switch_tk_1_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch_tk_1_6.isChecked()) {
                    spaceAddress.setElementQueue(new ElementQueue(spaceSetting.getTkArrayList().get(14).getRegister(), 1));
                    spaceAddress.setAddressSpace(startCellNumber + 14, 1);
                } else {
                    spaceAddress.setElementQueue(new ElementQueue(spaceSetting.getTkArrayList().get(14).getRegister(), 0));
                    spaceAddress.setAddressSpace(startCellNumber + 14, 0);
                }
            }
        });
        arrayList.add(switch_tk_1_6);
        switch_tk_1_7 = root.findViewById(R.id.switch_tk_1_7);
        switch_tk_1_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch_tk_1_7.isChecked()) {
                    spaceAddress.setElementQueue(new ElementQueue(spaceSetting.getTkArrayList().get(15).getRegister(), 1));
                    spaceAddress.setAddressSpace(startCellNumber + 15, 1);
                } else {
                    spaceAddress.setElementQueue(new ElementQueue(spaceSetting.getTkArrayList().get(15).getRegister(), 0));
                    spaceAddress.setAddressSpace(startCellNumber + 15, 0);
                }
            }
        });
        arrayList.add(switch_tk_1_7);

        switch_tk_2_0 = root.findViewById(R.id.switch_tk_2_0);
        switch_tk_2_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch_tk_2_0.isChecked()) {
                    spaceAddress.setElementQueue(new ElementQueue(spaceSetting.getTkArrayList().get(16).getRegister(), 1));
                    spaceAddress.setAddressSpace(startCellNumber + 16, 1);
                } else {
                    spaceAddress.setElementQueue(new ElementQueue(spaceSetting.getTkArrayList().get(16).getRegister(), 0));
                    spaceAddress.setAddressSpace(startCellNumber + 16, 0);
                }
            }
        });
        arrayList.add(switch_tk_2_0);
        switch_tk_2_1 = root.findViewById(R.id.switch_tk_2_1);
        switch_tk_2_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch_tk_2_1.isChecked()) {
                    spaceAddress.setElementQueue(new ElementQueue(spaceSetting.getTkArrayList().get(17).getRegister(), 1));
                    spaceAddress.setAddressSpace(startCellNumber + 17, 1);
                } else {
                    spaceAddress.setElementQueue(new ElementQueue(spaceSetting.getTkArrayList().get(17).getRegister(), 0));
                    spaceAddress.setAddressSpace(startCellNumber + 17, 0);
                }
            }
        });
        arrayList.add(switch_tk_2_1);
        switch_tk_2_2 = root.findViewById(R.id.switch_tk_2_2);
        switch_tk_2_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch_tk_2_2.isChecked()) {
                    spaceAddress.setElementQueue(new ElementQueue(spaceSetting.getTkArrayList().get(18).getRegister(), 1));
                    spaceAddress.setAddressSpace(startCellNumber + 18, 1);
                } else {
                    spaceAddress.setElementQueue(new ElementQueue(spaceSetting.getTkArrayList().get(18).getRegister(), 0));
                    spaceAddress.setAddressSpace(startCellNumber + 18, 0);
                }
            }
        });
        arrayList.add(switch_tk_2_2);
        switch_tk_2_3 = root.findViewById(R.id.switch_tk_2_3);
        switch_tk_2_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch_tk_2_3.isChecked()) {
                    spaceAddress.setElementQueue(new ElementQueue(spaceSetting.getTkArrayList().get(19).getRegister(), 1));
                    spaceAddress.setAddressSpace(startCellNumber + 19, 1);
                } else {
                    spaceAddress.setElementQueue(new ElementQueue(spaceSetting.getTkArrayList().get(19).getRegister(), 0));
                    spaceAddress.setAddressSpace(startCellNumber + 19, 0);
                }
            }
        });
        arrayList.add(switch_tk_2_3);
        switch_tk_2_4 = root.findViewById(R.id.switch_tk_2_4);
        switch_tk_2_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch_tk_2_4.isChecked()) {
                    spaceAddress.setElementQueue(new ElementQueue(spaceSetting.getTkArrayList().get(20).getRegister(), 1));
                    spaceAddress.setAddressSpace(startCellNumber + 20, 1);
                } else {
                    spaceAddress.setElementQueue(new ElementQueue(spaceSetting.getTkArrayList().get(20).getRegister(), 0));
                    spaceAddress.setAddressSpace(startCellNumber + 20, 0);
                }
            }
        });
        arrayList.add(switch_tk_2_4);
        switch_tk_2_5 = root.findViewById(R.id.switch_tk_2_5);
        switch_tk_2_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch_tk_2_5.isChecked()) {
                    spaceAddress.setElementQueue(new ElementQueue(spaceSetting.getTkArrayList().get(21).getRegister(), 1));
                    spaceAddress.setAddressSpace(startCellNumber + 21, 1);
                } else {
                    spaceAddress.setElementQueue(new ElementQueue(spaceSetting.getTkArrayList().get(21).getRegister(), 0));
                    spaceAddress.setAddressSpace(startCellNumber + 21, 0);
                }
            }
        });
        arrayList.add(switch_tk_2_5);
        switch_tk_2_6 = root.findViewById(R.id.switch_tk_2_6);
        switch_tk_2_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch_tk_2_6.isChecked()) {
                    spaceAddress.setElementQueue(new ElementQueue(spaceSetting.getTkArrayList().get(22).getRegister(), 1));
                    spaceAddress.setAddressSpace(startCellNumber + 22, 1);
                } else {
                    spaceAddress.setElementQueue(new ElementQueue(spaceSetting.getTkArrayList().get(22).getRegister(), 0));
                    spaceAddress.setAddressSpace(startCellNumber + 22, 0);
                }
            }
        });
        arrayList.add(switch_tk_2_6);
        switch_tk_2_7 = root.findViewById(R.id.switch_tk_2_7);
        switch_tk_2_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch_tk_2_7.isChecked()) {
                    spaceAddress.setElementQueue(new ElementQueue(spaceSetting.getTkArrayList().get(23).getRegister(), 1));
                    spaceAddress.setAddressSpace(startCellNumber + 23, 1);
                } else {
                    spaceAddress.setElementQueue(new ElementQueue(spaceSetting.getTkArrayList().get(23).getRegister(), 0));
                    spaceAddress.setAddressSpace(startCellNumber + 23, 0);
                }
            }
        });
        arrayList.add(switch_tk_2_7);

        switch_tk_3_0 = root.findViewById(R.id.switch_tk_3_0);
        switch_tk_3_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch_tk_3_0.isChecked()) {
                    spaceAddress.setElementQueue(new ElementQueue(spaceSetting.getTkArrayList().get(24).getRegister(), 1));
                    spaceAddress.setAddressSpace(startCellNumber + 24, 1);
                } else {
                    spaceAddress.setElementQueue(new ElementQueue(spaceSetting.getTkArrayList().get(24).getRegister(), 0));
                    spaceAddress.setAddressSpace(startCellNumber + 24, 0);
                }
            }
        });
        arrayList.add(switch_tk_3_0);
        switch_tk_3_1 = root.findViewById(R.id.switch_tk_3_1);
        switch_tk_3_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch_tk_3_1.isChecked()) {
                    spaceAddress.setElementQueue(new ElementQueue(spaceSetting.getTkArrayList().get(25).getRegister(), 1));
                    spaceAddress.setAddressSpace(startCellNumber + 25, 1);
                } else {
                    spaceAddress.setElementQueue(new ElementQueue(spaceSetting.getTkArrayList().get(25).getRegister(), 0));
                    spaceAddress.setAddressSpace(startCellNumber + 25, 0);
                }
            }
        });
        arrayList.add(switch_tk_3_1);
        switch_tk_3_2 = root.findViewById(R.id.switch_tk_3_2);
        switch_tk_3_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch_tk_3_2.isChecked()) {
                    spaceAddress.setElementQueue(new ElementQueue(spaceSetting.getTkArrayList().get(26).getRegister(), 1));
                    spaceAddress.setAddressSpace(startCellNumber + 26, 1);
                } else {
                    spaceAddress.setElementQueue(new ElementQueue(spaceSetting.getTkArrayList().get(26).getRegister(), 0));
                    spaceAddress.setAddressSpace(startCellNumber + 26, 0);
                }
            }
        });
        arrayList.add(switch_tk_3_2);
        switch_tk_3_3 = root.findViewById(R.id.switch_tk_3_3);
        switch_tk_3_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch_tk_3_3.isChecked()) {
                    spaceAddress.setElementQueue(new ElementQueue(spaceSetting.getTkArrayList().get(27).getRegister(), 1));
                    spaceAddress.setAddressSpace(startCellNumber + 27, 1);
                } else {
                    spaceAddress.setElementQueue(new ElementQueue(spaceSetting.getTkArrayList().get(27).getRegister(), 0));
                    spaceAddress.setAddressSpace(startCellNumber + 27, 0);
                }
            }
        });
        arrayList.add(switch_tk_3_3);
        switch_tk_3_4 = root.findViewById(R.id.switch_tk_3_4);
        switch_tk_3_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch_tk_3_4.isChecked()) {
                    spaceAddress.setElementQueue(new ElementQueue(spaceSetting.getTkArrayList().get(28).getRegister(), 1));
                    spaceAddress.setAddressSpace(startCellNumber + 28, 1);
                } else {
                    spaceAddress.setElementQueue(new ElementQueue(spaceSetting.getTkArrayList().get(28).getRegister(), 0));
                    spaceAddress.setAddressSpace(startCellNumber + 28, 0);
                }
            }
        });
        arrayList.add(switch_tk_3_4);
        switch_tk_3_5 = root.findViewById(R.id.switch_tk_3_5);
        switch_tk_3_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch_tk_3_5.isChecked()) {
                    spaceAddress.setElementQueue(new ElementQueue(spaceSetting.getTkArrayList().get(29).getRegister(), 1));
                    spaceAddress.setAddressSpace(startCellNumber + 29, 1);
                } else {
                    spaceAddress.setElementQueue(new ElementQueue(spaceSetting.getTkArrayList().get(29).getRegister(), 0));
                    spaceAddress.setAddressSpace(startCellNumber + 29, 0);
                }
            }
        });
        arrayList.add(switch_tk_3_5);
        switch_tk_3_6 = root.findViewById(R.id.switch_tk_3_6);
        switch_tk_3_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch_tk_3_6.isChecked()) {
                    spaceAddress.setElementQueue(new ElementQueue(spaceSetting.getTkArrayList().get(30).getRegister(), 1));
                    spaceAddress.setAddressSpace(startCellNumber + 30, 1);
                } else {
                    spaceAddress.setElementQueue(new ElementQueue(spaceSetting.getTkArrayList().get(30).getRegister(), 0));
                    spaceAddress.setAddressSpace(startCellNumber + 30, 0);
                }
            }
        });
        arrayList.add(switch_tk_3_6);
        switch_tk_3_7 = root.findViewById(R.id.switch_tk_3_7);
        switch_tk_3_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch_tk_3_7.isChecked()) {
                    spaceAddress.setElementQueue(new ElementQueue(spaceSetting.getTkArrayList().get(31).getRegister(), 1));
                    spaceAddress.setAddressSpace(startCellNumber + 31, 1);
                } else {
                    spaceAddress.setElementQueue(new ElementQueue(spaceSetting.getTkArrayList().get(31).getRegister(), 0));
                    spaceAddress.setAddressSpace(startCellNumber + 31, 0);
                }
            }
        });
        arrayList.add(switch_tk_3_7);

        switch_tk_4_0 = root.findViewById(R.id.switch_tk_4_0);
        switch_tk_4_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch_tk_4_0.isChecked()) {
                    spaceAddress.setElementQueue(new ElementQueue(spaceSetting.getTkArrayList().get(32).getRegister(), 1));
                    spaceAddress.setAddressSpace(startCellNumber + 32, 1);
                } else {
                    spaceAddress.setElementQueue(new ElementQueue(spaceSetting.getTkArrayList().get(32).getRegister(), 0));
                    spaceAddress.setAddressSpace(startCellNumber + 32, 0);
                }
            }
        });
        arrayList.add(switch_tk_4_0);
        switch_tk_4_1 = root.findViewById(R.id.switch_tk_4_1);
        switch_tk_4_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch_tk_4_1.isChecked()) {
                    spaceAddress.setElementQueue(new ElementQueue(spaceSetting.getTkArrayList().get(33).getRegister(), 1));
                    spaceAddress.setAddressSpace(startCellNumber + 33, 1);
                } else {
                    spaceAddress.setElementQueue(new ElementQueue(spaceSetting.getTkArrayList().get(33).getRegister(), 0));
                    spaceAddress.setAddressSpace(startCellNumber + 33, 0);
                }
            }
        });
        arrayList.add(switch_tk_4_1);
        switch_tk_4_2 = root.findViewById(R.id.switch_tk_4_2);
        switch_tk_4_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch_tk_4_2.isChecked()) {
                    spaceAddress.setElementQueue(new ElementQueue(spaceSetting.getTkArrayList().get(34).getRegister(), 1));
                    spaceAddress.setAddressSpace(startCellNumber + 34, 1);
                } else {
                    spaceAddress.setElementQueue(new ElementQueue(spaceSetting.getTkArrayList().get(34).getRegister(), 0));
                    spaceAddress.setAddressSpace(startCellNumber + 34, 0);
                }
            }
        });
        arrayList.add(switch_tk_4_2);
        switch_tk_4_3 = root.findViewById(R.id.switch_tk_4_3);
        switch_tk_4_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch_tk_4_3.isChecked()) {
                    spaceAddress.setElementQueue(new ElementQueue(spaceSetting.getTkArrayList().get(35).getRegister(), 1));
                    spaceAddress.setAddressSpace(startCellNumber + 35, 1);
                } else {
                    spaceAddress.setElementQueue(new ElementQueue(spaceSetting.getTkArrayList().get(35).getRegister(), 0));
                    spaceAddress.setAddressSpace(startCellNumber + 35, 0);
                }
            }
        });
        arrayList.add(switch_tk_4_3);
        switch_tk_4_4 = root.findViewById(R.id.switch_tk_4_4);
        switch_tk_4_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch_tk_4_4.isChecked()) {
                    spaceAddress.setElementQueue(new ElementQueue(spaceSetting.getTkArrayList().get(36).getRegister(), 1));
                    spaceAddress.setAddressSpace(startCellNumber + 36, 1);
                } else {
                    spaceAddress.setElementQueue(new ElementQueue(spaceSetting.getTkArrayList().get(36).getRegister(), 0));
                    spaceAddress.setAddressSpace(startCellNumber + 36, 0);
                }
            }
        });
        arrayList.add(switch_tk_4_4);
        switch_tk_4_5 = root.findViewById(R.id.switch_tk_4_5);
        switch_tk_4_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch_tk_4_5.isChecked()) {
                    spaceAddress.setElementQueue(new ElementQueue(spaceSetting.getTkArrayList().get(37).getRegister(), 1));
                    spaceAddress.setAddressSpace(startCellNumber + 37, 1);
                } else {
                    spaceAddress.setElementQueue(new ElementQueue(spaceSetting.getTkArrayList().get(37).getRegister(), 0));
                    spaceAddress.setAddressSpace(startCellNumber + 37, 0);
                }
            }
        });
        arrayList.add(switch_tk_4_5);
        switch_tk_4_6 = root.findViewById(R.id.switch_tk_4_6);
        switch_tk_4_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch_tk_4_6.isChecked()) {
                    spaceAddress.setElementQueue(new ElementQueue(spaceSetting.getTkArrayList().get(38).getRegister(), 1));
                    spaceAddress.setAddressSpace(startCellNumber + 38, 1);
                } else {
                    spaceAddress.setElementQueue(new ElementQueue(spaceSetting.getTkArrayList().get(38).getRegister(), 0));
                    spaceAddress.setAddressSpace(startCellNumber + 38, 0);
                }
            }
        });
        arrayList.add(switch_tk_4_6);
        switch_tk_4_7 = root.findViewById(R.id.switch_tk_4_7);
        switch_tk_4_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch_tk_4_7.isChecked()) {
                    spaceAddress.setElementQueue(new ElementQueue(spaceSetting.getTkArrayList().get(39).getRegister(), 1));
                    spaceAddress.setAddressSpace(startCellNumber + 39, 1);
                } else {
                    spaceAddress.setElementQueue(new ElementQueue(spaceSetting.getTkArrayList().get(39).getRegister(), 0));
                    spaceAddress.setAddressSpace(startCellNumber + 39, 0);
                }
            }
        });
        arrayList.add(switch_tk_4_7);

        switch_tk_5_0 = root.findViewById(R.id.switch_tk_5_0);
        switch_tk_5_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch_tk_5_0.isChecked()) {
                    spaceAddress.setElementQueue(new ElementQueue(spaceSetting.getTkArrayList().get(40).getRegister(), 1));
                    spaceAddress.setAddressSpace(startCellNumber + 40, 1);
                } else {
                    spaceAddress.setElementQueue(new ElementQueue(spaceSetting.getTkArrayList().get(40).getRegister(), 0));
                    spaceAddress.setAddressSpace(startCellNumber + 40, 0);
                }
            }
        });
        arrayList.add(switch_tk_5_0);
        switch_tk_5_1 = root.findViewById(R.id.switch_tk_5_1);
        switch_tk_5_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch_tk_5_1.isChecked()) {
                    spaceAddress.setElementQueue(new ElementQueue(spaceSetting.getTkArrayList().get(41).getRegister(), 1));
                    spaceAddress.setAddressSpace(startCellNumber + 41, 1);
                } else {
                    spaceAddress.setElementQueue(new ElementQueue(spaceSetting.getTkArrayList().get(41).getRegister(), 0));
                    spaceAddress.setAddressSpace(startCellNumber + 41, 0);
                }
            }
        });
        arrayList.add(switch_tk_5_1);
        switch_tk_5_2 = root.findViewById(R.id.switch_tk_5_2);
        switch_tk_5_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch_tk_5_2.isChecked()) {
                    spaceAddress.setElementQueue(new ElementQueue(spaceSetting.getTkArrayList().get(42).getRegister(), 1));
                    spaceAddress.setAddressSpace(startCellNumber + 42, 1);
                } else {
                    spaceAddress.setElementQueue(new ElementQueue(spaceSetting.getTkArrayList().get(42).getRegister(), 0));
                    spaceAddress.setAddressSpace(startCellNumber + 42, 0);
                }
            }
        });
        arrayList.add(switch_tk_5_2);
        switch_tk_5_3 = root.findViewById(R.id.switch_tk_5_3);
        switch_tk_5_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch_tk_5_3.isChecked()) {
                    spaceAddress.setElementQueue(new ElementQueue(spaceSetting.getTkArrayList().get(43).getRegister(), 1));
                    spaceAddress.setAddressSpace(startCellNumber + 43, 1);
                } else {
                    spaceAddress.setElementQueue(new ElementQueue(spaceSetting.getTkArrayList().get(43).getRegister(), 0));
                    spaceAddress.setAddressSpace(startCellNumber + 43, 0);
                }
            }
        });
        arrayList.add(switch_tk_5_3);
        switch_tk_5_4 = root.findViewById(R.id.switch_tk_5_4);
        switch_tk_5_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch_tk_5_4.isChecked()) {
                    spaceAddress.setElementQueue(new ElementQueue(spaceSetting.getTkArrayList().get(44).getRegister(), 1));
                    spaceAddress.setAddressSpace(startCellNumber + 44, 1);
                } else {
                    spaceAddress.setElementQueue(new ElementQueue(spaceSetting.getTkArrayList().get(44).getRegister(), 0));
                    spaceAddress.setAddressSpace(startCellNumber + 44, 0);
                }
            }
        });
        arrayList.add(switch_tk_5_4);
        switch_tk_5_5 = root.findViewById(R.id.switch_tk_5_5);
        switch_tk_5_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch_tk_5_5.isChecked()) {
                    spaceAddress.setElementQueue(new ElementQueue(spaceSetting.getTkArrayList().get(45).getRegister(), 1));
                    spaceAddress.setAddressSpace(startCellNumber + 45, 1);
                } else {
                    spaceAddress.setElementQueue(new ElementQueue(spaceSetting.getTkArrayList().get(45).getRegister(), 0));
                    spaceAddress.setAddressSpace(startCellNumber + 45, 0);
                }
            }
        });
        arrayList.add(switch_tk_5_5);
        switch_tk_5_6 = root.findViewById(R.id.switch_tk_5_6);
        switch_tk_5_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch_tk_5_6.isChecked()) {
                    spaceAddress.setElementQueue(new ElementQueue(spaceSetting.getTkArrayList().get(46).getRegister(), 1));
                    spaceAddress.setAddressSpace(startCellNumber + 46, 1);
                } else {
                    spaceAddress.setElementQueue(new ElementQueue(spaceSetting.getTkArrayList().get(46).getRegister(), 0));
                    spaceAddress.setAddressSpace(startCellNumber + 46, 0);
                }
            }
        });
        arrayList.add(switch_tk_5_6);
        switch_tk_5_7 = root.findViewById(R.id.switch_tk_5_7);
        switch_tk_5_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch_tk_5_7.isChecked()) {
                    spaceAddress.setElementQueue(new ElementQueue(spaceSetting.getTkArrayList().get(47).getRegister(), 1));
                    spaceAddress.setAddressSpace(startCellNumber + 47, 1);
                } else {
                    spaceAddress.setElementQueue(new ElementQueue(spaceSetting.getTkArrayList().get(47).getRegister(), 0));
                    spaceAddress.setAddressSpace(startCellNumber + 47, 0);
                }
            }
        });
        arrayList.add(switch_tk_5_7);

        switch_tk_6_0 = root.findViewById(R.id.switch_tk_6_0);
        switch_tk_6_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch_tk_6_0.isChecked()) {
                    spaceAddress.setElementQueue(new ElementQueue(spaceSetting.getTkArrayList().get(48).getRegister(), 1));
                    spaceAddress.setAddressSpace(startCellNumber + 48, 1);
                } else {
                    spaceAddress.setElementQueue(new ElementQueue(spaceSetting.getTkArrayList().get(48).getRegister(), 0));
                    spaceAddress.setAddressSpace(startCellNumber + 48, 0);
                }
            }
        });
        arrayList.add(switch_tk_6_0);
        switch_tk_6_1 = root.findViewById(R.id.switch_tk_6_1);
        switch_tk_6_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch_tk_6_1.isChecked()) {
                    spaceAddress.setElementQueue(new ElementQueue(spaceSetting.getTkArrayList().get(49).getRegister(), 1));
                    spaceAddress.setAddressSpace(startCellNumber + 49, 1);
                } else {
                    spaceAddress.setElementQueue(new ElementQueue(spaceSetting.getTkArrayList().get(49).getRegister(), 0));
                    spaceAddress.setAddressSpace(startCellNumber + 49, 0);
                }
            }
        });
        arrayList.add(switch_tk_6_1);
        switch_tk_6_2 = root.findViewById(R.id.switch_tk_6_2);
        switch_tk_6_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch_tk_6_2.isChecked()) {
                    spaceAddress.setElementQueue(new ElementQueue(spaceSetting.getTkArrayList().get(50).getRegister(), 1));
                    spaceAddress.setAddressSpace(startCellNumber + 50, 1);
                } else {
                    spaceAddress.setElementQueue(new ElementQueue(spaceSetting.getTkArrayList().get(50).getRegister(), 0));
                    spaceAddress.setAddressSpace(startCellNumber + 50, 0);
                }
            }
        });
        arrayList.add(switch_tk_6_2);
        switch_tk_6_3 = root.findViewById(R.id.switch_tk_6_3);
        switch_tk_6_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch_tk_6_3.isChecked()) {
                    spaceAddress.setElementQueue(new ElementQueue(spaceSetting.getTkArrayList().get(51).getRegister(), 1));
                    spaceAddress.setAddressSpace(startCellNumber + 51, 1);
                } else {
                    spaceAddress.setElementQueue(new ElementQueue(spaceSetting.getTkArrayList().get(51).getRegister(), 0));
                    spaceAddress.setAddressSpace(startCellNumber + 51, 0);
                }
            }
        });
        arrayList.add(switch_tk_6_3);
        switch_tk_6_4 = root.findViewById(R.id.switch_tk_6_4);
        switch_tk_6_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch_tk_6_4.isChecked()) {
                    spaceAddress.setElementQueue(new ElementQueue(spaceSetting.getTkArrayList().get(52).getRegister(), 1));
                    spaceAddress.setAddressSpace(startCellNumber + 52, 1);
                } else {
                    spaceAddress.setElementQueue(new ElementQueue(spaceSetting.getTkArrayList().get(52).getRegister(), 0));
                    spaceAddress.setAddressSpace(startCellNumber + 52, 0);
                }
            }
        });
        arrayList.add(switch_tk_6_4);
        switch_tk_6_5 = root.findViewById(R.id.switch_tk_6_5);
        switch_tk_6_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch_tk_6_5.isChecked()) {
                    spaceAddress.setElementQueue(new ElementQueue(spaceSetting.getTkArrayList().get(53).getRegister(), 1));
                    spaceAddress.setAddressSpace(startCellNumber + 53, 1);
                } else {
                    spaceAddress.setElementQueue(new ElementQueue(spaceSetting.getTkArrayList().get(53).getRegister(), 0));
                    spaceAddress.setAddressSpace(startCellNumber + 53, 0);
                }
            }
        });
        arrayList.add(switch_tk_6_5);
        switch_tk_6_6 = root.findViewById(R.id.switch_tk_6_6);
        switch_tk_6_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch_tk_6_6.isChecked()) {
                    spaceAddress.setElementQueue(new ElementQueue(spaceSetting.getTkArrayList().get(54).getRegister(), 1));
                    spaceAddress.setAddressSpace(startCellNumber + 54, 1);
                } else {
                    spaceAddress.setElementQueue(new ElementQueue(spaceSetting.getTkArrayList().get(54).getRegister(), 0));
                    spaceAddress.setAddressSpace(startCellNumber + 54, 0);
                }
            }
        });
        arrayList.add(switch_tk_6_6);
        switch_tk_6_7 = root.findViewById(R.id.switch_tk_6_7);
        switch_tk_6_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch_tk_6_7.isChecked()) {
                    spaceAddress.setElementQueue(new ElementQueue(spaceSetting.getTkArrayList().get(55).getRegister(), 1));
                    spaceAddress.setAddressSpace(startCellNumber + 55, 1);
                } else {
                    spaceAddress.setElementQueue(new ElementQueue(spaceSetting.getTkArrayList().get(55).getRegister(), 0));
                    spaceAddress.setAddressSpace(startCellNumber + 55, 0);
                }
            }
        });
        arrayList.add(switch_tk_6_7);

        switch_tk_7_0 = root.findViewById(R.id.switch_tk_7_0);
        switch_tk_7_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch_tk_7_0.isChecked()) {
                    spaceAddress.setElementQueue(new ElementQueue(spaceSetting.getTkArrayList().get(56).getRegister(), 1));
                    spaceAddress.setAddressSpace(startCellNumber + 56, 1);
                } else {
                    spaceAddress.setElementQueue(new ElementQueue(spaceSetting.getTkArrayList().get(56).getRegister(), 0));
                    spaceAddress.setAddressSpace(startCellNumber + 56, 0);
                }
            }
        });
        arrayList.add(switch_tk_7_0);
        switch_tk_7_1 = root.findViewById(R.id.switch_tk_7_1);
        switch_tk_7_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch_tk_7_1.isChecked()) {
                    spaceAddress.setElementQueue(new ElementQueue(spaceSetting.getTkArrayList().get(57).getRegister(), 1));
                    spaceAddress.setAddressSpace(startCellNumber + 57, 1);
                } else {
                    spaceAddress.setElementQueue(new ElementQueue(spaceSetting.getTkArrayList().get(57).getRegister(), 0));
                    spaceAddress.setAddressSpace(startCellNumber + 57, 0);
                }
            }
        });
        arrayList.add(switch_tk_7_1);
        switch_tk_7_2 = root.findViewById(R.id.switch_tk_7_2);
        switch_tk_7_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch_tk_7_2.isChecked()) {
                    spaceAddress.setElementQueue(new ElementQueue(spaceSetting.getTkArrayList().get(58).getRegister(), 1));
                    spaceAddress.setAddressSpace(startCellNumber + 58, 1);
                } else {
                    spaceAddress.setElementQueue(new ElementQueue(spaceSetting.getTkArrayList().get(58).getRegister(), 0));
                    spaceAddress.setAddressSpace(startCellNumber + 58, 0);
                }
            }
        });
        arrayList.add(switch_tk_7_2);
        switch_tk_7_3 = root.findViewById(R.id.switch_tk_7_3);
        switch_tk_7_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch_tk_7_3.isChecked()) {
                    spaceAddress.setElementQueue(new ElementQueue(spaceSetting.getTkArrayList().get(59).getRegister(), 1));
                    spaceAddress.setAddressSpace(startCellNumber + 59, 1);
                } else {
                    spaceAddress.setElementQueue(new ElementQueue(spaceSetting.getTkArrayList().get(59).getRegister(), 0));
                    spaceAddress.setAddressSpace(startCellNumber + 59, 0);
                }
            }
        });
        arrayList.add(switch_tk_7_3);
        switch_tk_7_4 = root.findViewById(R.id.switch_tk_7_4);
        switch_tk_7_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch_tk_7_4.isChecked()) {
                    spaceAddress.setElementQueue(new ElementQueue(spaceSetting.getTkArrayList().get(60).getRegister(), 1));
                    spaceAddress.setAddressSpace(startCellNumber + 60, 1);
                } else {
                    spaceAddress.setElementQueue(new ElementQueue(spaceSetting.getTkArrayList().get(60).getRegister(), 0));
                    spaceAddress.setAddressSpace(startCellNumber + 60, 0);
                }
            }
        });
        arrayList.add(switch_tk_7_4);
        switch_tk_7_5 = root.findViewById(R.id.switch_tk_7_5);
        switch_tk_7_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch_tk_7_5.isChecked()) {
                    spaceAddress.setElementQueue(new ElementQueue(spaceSetting.getTkArrayList().get(61).getRegister(), 1));
                    spaceAddress.setAddressSpace(startCellNumber + 61, 1);
                } else {
                    spaceAddress.setElementQueue(new ElementQueue(spaceSetting.getTkArrayList().get(61).getRegister(), 0));
                    spaceAddress.setAddressSpace(startCellNumber + 61, 0);
                }
            }
        });
        arrayList.add(switch_tk_7_5);
        switch_tk_7_6 = root.findViewById(R.id.switch_tk_7_6);
        switch_tk_7_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch_tk_7_6.isChecked()) {
                    spaceAddress.setElementQueue(new ElementQueue(spaceSetting.getTkArrayList().get(62).getRegister(), 1));
                    spaceAddress.setAddressSpace(startCellNumber + 62, 1);
                } else {
                    spaceAddress.setElementQueue(new ElementQueue(spaceSetting.getTkArrayList().get(62).getRegister(), 0));
                    spaceAddress.setAddressSpace(startCellNumber + 62, 0);
                }
            }
        });
        arrayList.add(switch_tk_7_6);
        switch_tk_7_7 = root.findViewById(R.id.switch_tk_7_7);
        switch_tk_7_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch_tk_7_7.isChecked()) {
                    spaceAddress.setElementQueue(new ElementQueue(spaceSetting.getTkArrayList().get(63).getRegister(), 1));
                    spaceAddress.setAddressSpace(startCellNumber + 63, 1);
                } else {
                    spaceAddress.setElementQueue(new ElementQueue(spaceSetting.getTkArrayList().get(63).getRegister(), 0));
                    spaceAddress.setAddressSpace(startCellNumber + 63, 0);
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
