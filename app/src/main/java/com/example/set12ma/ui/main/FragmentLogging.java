package com.example.set12ma.ui.main;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import com.example.set12ma.R;

import java.io.IOException;

public class FragmentLogging extends Fragment {
    private static final String ARG_SECTION_NUMBER = "Logging";

    private SpaceStatus spaceStatus;
    private ResultReceiverStatusSpace resultReceiverStatusSpace;

    private UpDateGraphicalDisplay upDateGraphicalDisplay;
    private long timer = 100;

    private Button buttonDownload;
    private Button buttonSave;
    private Button buttonSend;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        resultReceiverStatusSpace = (ResultReceiverStatusSpace) context;
    }

    private PageViewModel pageViewModel;

    public static FragmentLogging newInstance(int index) {
        FragmentLogging fragment = new FragmentLogging();
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
        View root = inflater.inflate(R.layout.fragment_logging, container, false);
        buttonDownload = root.findViewById(R.id.button_download);
        buttonSave = root.findViewById(R.id.button_save);
        buttonSend = root.findViewById(R.id.button_send);

        buttonDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                download();
            }
        });
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save();
            }
        });
        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                send();
            }
        });



        upDateGraphicalDisplay = new UpDateGraphicalDisplay();
        upDateGraphicalDisplay.start();

        return root;
    }

    private void download() {
        if (spaceStatus.isReadyFlagToExchangeData()) {
            if (!spaceStatus.isStatusProcessOfUpdatingSoftware() & !spaceStatus.isStatusProcessOfLoadingSoftware()) {
                spaceStatus.setReadyFlagToDownloadLog(true);
                Log.i("strartt", "start");
            } else {
                Toast.makeText(getContext(), "Дождитесь завершения обновления ПО", Toast.LENGTH_LONG).show();
            }
        } else Toast.makeText(getActivity(), "Подключитесь к устройству", Toast.LENGTH_SHORT).show();

    }

    private void save() {
        if (spaceStatus.isReadyFlagToExchangeData()) {
            Toast.makeText(getActivity(), "save", Toast.LENGTH_SHORT).show();
        } else Toast.makeText(getActivity(), "Подключитесь к устройству", Toast.LENGTH_SHORT).show();
    }

    private void send() {
        if (spaceStatus.isReadyFlagToExchangeData()) {
            Toast.makeText(getActivity(), "send", Toast.LENGTH_SHORT).show();
//            Intent intent = new Intent()
//                    .setType("*/*")
//                    .setAction(Intent.ACTION_SEND);
//            startActivityForResult(Intent.createChooser(intent, "Select a file"), 123);

            Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_TEXT, "This is my text to send.");
            sendIntent.setType("text/plain");

            Intent shareIntent = Intent.createChooser(sendIntent, null);
            startActivity(shareIntent);
        } else Toast.makeText(getActivity(), "Подключитесь к устройству", Toast.LENGTH_SHORT).show();
    }

    public class UpDateGraphicalDisplay extends Thread {
        @Override
        public void run() {
            super.run();
        }

        public UpDateGraphicalDisplay() {
        }
    }
}
