package com.example.set12ma.ui.main;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import com.example.set12ma.R;

import java.io.*;

import static android.app.Activity.RESULT_OK;

public class SP6Fragment extends Fragment {
    private static final String ARG_SECTION_NUMBER = "SP6";
    private static final String LOG_TAG = "AndroidExample";
    private TextView textViewPathToLoadFile;
    private Button buttonChoicePath;
    private Button buttonLoadToFlesh;
    private Button buttonStartLoadSP6;
    Uri selectedFile;
    MemorySpace memorySpace;
    ResultReceiverMemorySpace resultReceiverMemorySpace;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        resultReceiverMemorySpace = (ResultReceiverMemorySpace) context;
    }

    private PageViewModel pageViewModel;

    public static SP6Fragment newInstance(int index) {
        SP6Fragment fragment = new SP6Fragment();
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
        View root = inflater.inflate(R.layout.fragment_sp6, container, false);
        buttonChoicePath = root.findViewById(R.id.button_choice_path);
        buttonChoicePath.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR2)
            @Override
            public void onClick(View v) { openFile();
            }
        });
        buttonLoadToFlesh = root.findViewById(R.id.button_load_to_flesh);
        buttonLoadToFlesh.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR2)
            @Override
            public void onClick(View v) { loadFile();
            }
        });
        buttonStartLoadSP6 = root.findViewById(R.id.button_start_load_sp6);
        buttonStartLoadSP6.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR2)
            @Override
            public void onClick(View v) { startLoad();
            }
        });
        textViewPathToLoadFile = root.findViewById(R.id.textView_path_to_load_file);

        memorySpace = resultReceiverMemorySpace.getMemorySpace();
        return root;
    }

    private void openFile() {
        Intent intent = new Intent()
                .setType("*/*")
                .setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select a file"), 123);
    }

    private void loadFile() {
        try {
            InputStream inputStream = getContext().getContentResolver().openInputStream(selectedFile);
            memorySpace.setMemorySpaceByte();
            byte[] data = new byte[memorySpace.getMemorySpaceByteLength()];
            int count = inputStream.read(data);
            while (count != -1) {
                byte[] dataLastByte = new byte[count];
                for (int i = 0; i < count; i++) {
                    dataLastByte[i] = data[i];
                }
                memorySpace.setMemorySpaceArrayListByte(dataLastByte);
                count = inputStream.read(data);
            }
            memorySpace.setReadyFlagToLoad(true);
            memorySpace.setDevice("SP6");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void startLoad() {
        memorySpace.setReadyFlagToStart(true);
    }

        @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 123 && resultCode == RESULT_OK) {
            selectedFile = data.getData(); //The uri with the location of the file
//            selectedFile = (URI) data.getData();
            Toast.makeText(getContext(), selectedFile.toString(), Toast.LENGTH_LONG).show();
            textViewPathToLoadFile.setText(data.getDataString());
        }
    }
}

