package com.example.set12ma.ui.main;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import com.example.set12ma.R;

public class FragmentTest extends Fragment {

    private static final String LOG_TAG = "AndroidExample";
    private static final String ARG_SECTION_NUMBER = "Output";

    private SpaceAddress spaceAddress;
    private SpaceStatus spaceStatus;
    private SpaceSetting spaceSetting;
    private ResultReceiverAddressSpace resultReceiverAddressSpace;
    private ResultReceiverStatusSpace resultReceiverStatusSpace;
    private ResultReceiverSettingSpace resultReceiverSettingSpace;

//    private UpDateGraphicalDisplay upDateGraphicalDisplay;
    private long timer = 100;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        resultReceiverAddressSpace = (ResultReceiverAddressSpace) context;
        resultReceiverStatusSpace = (ResultReceiverStatusSpace) context;
        resultReceiverSettingSpace = (ResultReceiverSettingSpace) context;
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
        spaceSetting = resultReceiverSettingSpace.getSpaceSetting();
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_test, container, false);
        return root;
    }

}
