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

public class FragmentTK extends Fragment implements View.OnClickListener {
    private static final String ARG_SECTION_NUMBER = "TK";

    private ArrayList<Button> arrayListButton;
    private ArrayList<TextView> arrayListTextView;
    private int startCellNumber = 144;
    private int stopCellNumber = 208;
    private SpaceAddress spaceAddress;
    private ResultReceiverAddressSpace resultReceiverAddressSpace;

    private ArrayList<Switch> arrayList;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        resultReceiverAddressSpace = (ResultReceiverAddressSpace) context;
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
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_tk, container, false);

        arrayList = new ArrayList();

        spaceAddress = resultReceiverAddressSpace.getSpaceAddress();

        Switch switch_tk_0_0 = root.findViewById(R.id.switch_tk_0_0);
        switch_tk_0_0.setOnClickListener(this);
        arrayList.add(switch_tk_0_0);
        Switch switch_tk_0_1 = root.findViewById(R.id.switch_tk_0_1);
        switch_tk_0_1.setOnClickListener(this);
        arrayList.add(switch_tk_0_1);
        Switch switch_tk_0_2 = root.findViewById(R.id.switch_tk_0_2);
        switch_tk_0_2.setOnClickListener(this);
        arrayList.add(switch_tk_0_2);
        Switch switch_tk_0_3 = root.findViewById(R.id.switch_tk_0_3);
        switch_tk_0_3.setOnClickListener(this);
        arrayList.add(switch_tk_0_3);
        Switch switch_tk_0_4 = root.findViewById(R.id.switch_tk_0_4);
        switch_tk_0_4.setOnClickListener(this);
        arrayList.add(switch_tk_0_4);
        Switch switch_tk_0_5 = root.findViewById(R.id.switch_tk_0_5);
        switch_tk_0_5.setOnClickListener(this);
        arrayList.add(switch_tk_0_5);
        Switch switch_tk_0_6 = root.findViewById(R.id.switch_tk_0_6);
        switch_tk_0_6.setOnClickListener(this);
        arrayList.add(switch_tk_0_6);
        Switch switch_tk_0_7 = root.findViewById(R.id.switch_tk_0_7);
        switch_tk_0_7.setOnClickListener(this);
        arrayList.add(switch_tk_0_7);

        Switch switch_tk_1_0 = root.findViewById(R.id.switch_tk_1_0);
        switch_tk_1_0.setOnClickListener(this);
        arrayList.add(switch_tk_1_0);
        Switch switch_tk_1_1 = root.findViewById(R.id.switch_tk_1_1);
        switch_tk_1_1.setOnClickListener(this);
        arrayList.add(switch_tk_1_1);
        Switch switch_tk_1_2 = root.findViewById(R.id.switch_tk_1_2);
        switch_tk_1_2.setOnClickListener(this);
        arrayList.add(switch_tk_1_2);
        Switch switch_tk_1_3 = root.findViewById(R.id.switch_tk_1_3);
        switch_tk_1_3.setOnClickListener(this);
        arrayList.add(switch_tk_1_3);
        Switch switch_tk_1_4 = root.findViewById(R.id.switch_tk_1_4);
        switch_tk_1_4.setOnClickListener(this);
        arrayList.add(switch_tk_1_4);
        Switch switch_tk_1_5 = root.findViewById(R.id.switch_tk_1_5);
        switch_tk_1_5.setOnClickListener(this);
        arrayList.add(switch_tk_1_5);
        Switch switch_tk_1_6 = root.findViewById(R.id.switch_tk_1_6);
        switch_tk_1_6.setOnClickListener(this);
        arrayList.add(switch_tk_1_6);
        Switch switch_tk_1_7 = root.findViewById(R.id.switch_tk_1_7);
        switch_tk_1_7.setOnClickListener(this);
        arrayList.add(switch_tk_1_7);

        Switch switch_tk_2_0 = root.findViewById(R.id.switch_tk_2_0);
        switch_tk_2_0.setOnClickListener(this);
        arrayList.add(switch_tk_2_0);
        Switch switch_tk_2_1 = root.findViewById(R.id.switch_tk_2_1);
        switch_tk_2_1.setOnClickListener(this);
        arrayList.add(switch_tk_2_1);
        Switch switch_tk_2_2 = root.findViewById(R.id.switch_tk_2_2);
        switch_tk_2_2.setOnClickListener(this);
        arrayList.add(switch_tk_2_2);
        Switch switch_tk_2_3 = root.findViewById(R.id.switch_tk_2_3);
        switch_tk_2_3.setOnClickListener(this);
        arrayList.add(switch_tk_2_3);
        Switch switch_tk_2_4 = root.findViewById(R.id.switch_tk_2_4);
        switch_tk_2_4.setOnClickListener(this);
        arrayList.add(switch_tk_2_4);
        Switch switch_tk_2_5 = root.findViewById(R.id.switch_tk_2_5);
        switch_tk_2_5.setOnClickListener(this);
        arrayList.add(switch_tk_2_5);
        Switch switch_tk_2_6 = root.findViewById(R.id.switch_tk_2_6);
        switch_tk_2_6.setOnClickListener(this);
        arrayList.add(switch_tk_2_6);
        Switch switch_tk_2_7 = root.findViewById(R.id.switch_tk_2_7);
        switch_tk_2_7.setOnClickListener(this);
        arrayList.add(switch_tk_2_7);

        Switch switch_tk_3_0 = root.findViewById(R.id.switch_tk_3_0);
        switch_tk_3_0.setOnClickListener(this);
        arrayList.add(switch_tk_3_0);
        Switch switch_tk_3_1 = root.findViewById(R.id.switch_tk_3_1);
        switch_tk_3_1.setOnClickListener(this);
        arrayList.add(switch_tk_3_1);
        Switch switch_tk_3_2 = root.findViewById(R.id.switch_tk_3_2);
        switch_tk_3_2.setOnClickListener(this);
        arrayList.add(switch_tk_3_2);
        Switch switch_tk_3_3 = root.findViewById(R.id.switch_tk_3_3);
        switch_tk_3_3.setOnClickListener(this);
        arrayList.add(switch_tk_3_3);
        Switch switch_tk_3_4 = root.findViewById(R.id.switch_tk_3_4);
        switch_tk_3_4.setOnClickListener(this);
        arrayList.add(switch_tk_3_4);
        Switch switch_tk_3_5 = root.findViewById(R.id.switch_tk_3_5);
        switch_tk_3_5.setOnClickListener(this);
        arrayList.add(switch_tk_3_5);
        Switch switch_tk_3_6 = root.findViewById(R.id.switch_tk_3_6);
        switch_tk_3_6.setOnClickListener(this);
        arrayList.add(switch_tk_3_6);
        Switch switch_tk_3_7 = root.findViewById(R.id.switch_tk_3_7);
        switch_tk_3_7.setOnClickListener(this);
        arrayList.add(switch_tk_3_7);

        Switch switch_tk_4_0 = root.findViewById(R.id.switch_tk_4_0);
        switch_tk_4_0.setOnClickListener(this);
        arrayList.add(switch_tk_4_0);
        Switch switch_tk_4_1 = root.findViewById(R.id.switch_tk_4_1);
        switch_tk_4_1.setOnClickListener(this);
        arrayList.add(switch_tk_4_1);
        Switch switch_tk_4_2 = root.findViewById(R.id.switch_tk_4_2);
        switch_tk_4_2.setOnClickListener(this);
        arrayList.add(switch_tk_4_2);
        Switch switch_tk_4_3 = root.findViewById(R.id.switch_tk_4_3);
        switch_tk_4_3.setOnClickListener(this);
        arrayList.add(switch_tk_4_3);
        Switch switch_tk_4_4 = root.findViewById(R.id.switch_tk_4_4);
        switch_tk_4_4.setOnClickListener(this);
        arrayList.add(switch_tk_4_4);
        Switch switch_tk_4_5 = root.findViewById(R.id.switch_tk_4_5);
        switch_tk_4_5.setOnClickListener(this);
        arrayList.add(switch_tk_4_5);
        Switch switch_tk_4_6 = root.findViewById(R.id.switch_tk_4_6);
        switch_tk_4_6.setOnClickListener(this);
        arrayList.add(switch_tk_4_6);
        Switch switch_tk_4_7 = root.findViewById(R.id.switch_tk_4_7);
        switch_tk_4_7.setOnClickListener(this);
        arrayList.add(switch_tk_4_7);

        Switch switch_tk_5_0 = root.findViewById(R.id.switch_tk_5_0);
        switch_tk_5_0.setOnClickListener(this);
        arrayList.add(switch_tk_5_0);
        Switch switch_tk_5_1 = root.findViewById(R.id.switch_tk_5_1);
        switch_tk_5_1.setOnClickListener(this);
        arrayList.add(switch_tk_5_1);
        Switch switch_tk_5_2 = root.findViewById(R.id.switch_tk_5_2);
        switch_tk_5_2.setOnClickListener(this);
        arrayList.add(switch_tk_5_2);
        Switch switch_tk_5_3 = root.findViewById(R.id.switch_tk_5_3);
        switch_tk_5_3.setOnClickListener(this);
        arrayList.add(switch_tk_5_3);
        Switch switch_tk_5_4 = root.findViewById(R.id.switch_tk_5_4);
        switch_tk_5_4.setOnClickListener(this);
        arrayList.add(switch_tk_5_4);
        Switch switch_tk_5_5 = root.findViewById(R.id.switch_tk_5_5);
        switch_tk_5_5.setOnClickListener(this);
        arrayList.add(switch_tk_5_5);
        Switch switch_tk_5_6 = root.findViewById(R.id.switch_tk_5_6);
        switch_tk_5_6.setOnClickListener(this);
        arrayList.add(switch_tk_5_6);
        Switch switch_tk_5_7 = root.findViewById(R.id.switch_tk_5_7);
        switch_tk_5_7.setOnClickListener(this);
        arrayList.add(switch_tk_5_7);

        Switch switch_tk_6_0 = root.findViewById(R.id.switch_tk_6_0);
        switch_tk_6_0.setOnClickListener(this);
        arrayList.add(switch_tk_6_0);
        Switch switch_tk_6_1 = root.findViewById(R.id.switch_tk_6_1);
        switch_tk_6_1.setOnClickListener(this);
        arrayList.add(switch_tk_6_1);
        Switch switch_tk_6_2 = root.findViewById(R.id.switch_tk_6_2);
        switch_tk_6_2.setOnClickListener(this);
        arrayList.add(switch_tk_6_2);
        Switch switch_tk_6_3 = root.findViewById(R.id.switch_tk_6_3);
        switch_tk_6_3.setOnClickListener(this);
        arrayList.add(switch_tk_6_3);
        Switch switch_tk_6_4 = root.findViewById(R.id.switch_tk_6_4);
        switch_tk_6_4.setOnClickListener(this);
        arrayList.add(switch_tk_6_4);
        Switch switch_tk_6_5 = root.findViewById(R.id.switch_tk_6_5);
        switch_tk_6_5.setOnClickListener(this);
        arrayList.add(switch_tk_6_5);
        Switch switch_tk_6_6 = root.findViewById(R.id.switch_tk_6_6);
        switch_tk_6_6.setOnClickListener(this);
        arrayList.add(switch_tk_6_6);
        Switch switch_tk_6_7 = root.findViewById(R.id.switch_tk_6_7);
        switch_tk_6_7.setOnClickListener(this);
        arrayList.add(switch_tk_6_7);

        Switch switch_tk_7_0 = root.findViewById(R.id.switch_tk_7_0);
        switch_tk_7_0.setOnClickListener(this);
        arrayList.add(switch_tk_7_0);
        Switch switch_tk_7_1 = root.findViewById(R.id.switch_tk_7_1);
        switch_tk_7_1.setOnClickListener(this);
        arrayList.add(switch_tk_7_1);
        Switch switch_tk_7_2 = root.findViewById(R.id.switch_tk_7_2);
        switch_tk_7_2.setOnClickListener(this);
        arrayList.add(switch_tk_7_2);
        Switch switch_tk_7_3 = root.findViewById(R.id.switch_tk_7_3);
        switch_tk_7_3.setOnClickListener(this);
        arrayList.add(switch_tk_7_3);
        Switch switch_tk_7_4 = root.findViewById(R.id.switch_tk_7_4);
        switch_tk_7_4.setOnClickListener(this);
        arrayList.add(switch_tk_7_4);
        Switch switch_tk_7_5 = root.findViewById(R.id.switch_tk_7_5);
        switch_tk_7_5.setOnClickListener(this);
        arrayList.add(switch_tk_7_5);
        Switch switch_tk_7_6 = root.findViewById(R.id.switch_tk_7_6);
        switch_tk_7_6.setOnClickListener(this);
        arrayList.add(switch_tk_7_6);
        Switch switch_tk_7_7 = root.findViewById(R.id.switch_tk_7_7);
        switch_tk_7_7.setOnClickListener(this);
        arrayList.add(switch_tk_7_7);

        return root;
    }

    @Override
    public void onClick(View v){
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i).isChecked()) {
                spaceAddress.setAddressSpace(startCellNumber + i, 1);
            }
            else {
                spaceAddress.setAddressSpace(startCellNumber + i, 0);
            }
        }
    }
}
