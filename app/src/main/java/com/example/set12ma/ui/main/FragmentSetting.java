package com.example.set12ma.ui.main;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import com.example.set12ma.R;

import java.io.*;

public class FragmentSetting extends Fragment {
    private static final String ARG_SECTION_NUMBER = "Setting";

    private SpaceStatus spaceStatus;
    private ResultReceiverStatusSpace resultReceiverStatusSpace;

    private UpDateGraphicalDisplay upDateGraphicalDisplay;
    private long timer = 500;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        resultReceiverStatusSpace = (ResultReceiverStatusSpace) context;
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
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_setting, container, false);
        return root;
    }

    private void download() {
        if (spaceStatus.isReadyFlagToExchangeData()) {
            if (!spaceStatus.isStatusProcessOfUpdatingSoftware() & !spaceStatus.isStatusProcessOfLoadingSoftware()) {
                if (!spaceStatus.isReadyFlagToDownloadLog()) {
                    Log.i("strartt", "start");
                    spaceStatus.setReadyFlagToDownloadLog(true);
                } else {
                    Toast.makeText(getContext(), "Дождитесь завершения загрузки логов", Toast.LENGTH_LONG).show();
                }

            } else {
                Toast.makeText(getContext(), "Дождитесь завершения обновления ПО", Toast.LENGTH_LONG).show();
            }
        } else Toast.makeText(getActivity(), "Подключитесь к устройству", Toast.LENGTH_SHORT).show();

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
