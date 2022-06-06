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
import java.net.URI;
import java.util.ArrayList;

import static android.app.Activity.RESULT_OK;

public class SP6Fragment extends Fragment {
    private static final String ARG_SECTION_NUMBER = "SP6";
    private static final String LOG_TAG = "AndroidExample";
    private TextView textViewPathToLoadFile;
    private Button buttonChoicePath;
    private Button buttonLoadToFlesh;
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

            memorySpace.setReadyFlag(true);
            Log.i(LOG_TAG, String.valueOf(memorySpace.getMemorySpaceArrayListSize()));
            Log.i(LOG_TAG, String.valueOf(memorySpace.getMemorySpaceByte(memorySpace.getMemorySpaceArrayListSize()-1).length));




//            for (int i = 0; i < 100; i++) {
//                Log.i(LOG_TAG, String.valueOf(data[i]));
//                count = i;
//            }
//            Log.i(LOG_TAG, String.valueOf(count));
//            int count = inputStream.read(data);
//            int countByte = 0;
//            while (count != -1) {
////                dos.write(data, 0, count);
//                count = inputStream.read(data);
//                for (int i = 0; i < count; i++) {
//                    arrayList.add(data[i]);
//                    countByte++;
//                }
//                Log.i(LOG_TAG, String.valueOf(count));
//                Log.i(LOG_TAG, String.valueOf(data[0]));
//                Log.i(LOG_TAG, String.valueOf(countByte));
//                countByte++;
//                for (int i = 0; i < data.length; i++) {
//                    Log.i(LOG_TAG, "byte number    " + String.valueOf(i));
//                    Log.i(LOG_TAG, String.valueOf(data[i]));
//                    countByte++;
//                }
//            }
//            Log.i(LOG_TAG, String.valueOf(countByte));
//            Log.i(LOG_TAG, String.valueOf(arrayList.size()));
//
//            Log.i(LOG_TAG, String.valueOf(arrayList.get(0)));
//            Log.i(LOG_TAG, String.valueOf(arrayList.get(1)));
//            Log.i(LOG_TAG, String.valueOf(arrayList.get(2)));
//            Log.i(LOG_TAG, String.valueOf(arrayList.get(3)));
//            Log.i(LOG_TAG, String.valueOf(arrayList.get(4).byteValue()));
//            Log.i(LOG_TAG, String.valueOf(arrayList.get(5).byteValue()));
//            Log.i(LOG_TAG, String.valueOf(arrayList.get(6).byteValue()));
//            Log.i(LOG_TAG, String.valueOf(arrayList.get(7).byteValue()));
//            Log.i(LOG_TAG, String.valueOf(arrayList.get(8).byteValue()));
//            Log.i(LOG_TAG, String.valueOf(arrayList.get(9).byteValue()));
//            Log.i(LOG_TAG, String.valueOf(arrayList.get(10).byteValue()));
//            Log.i(LOG_TAG, String.valueOf(arrayList.get(11).byteValue()));
//            Log.i(LOG_TAG, String.valueOf(arrayList.get(12).byteValue()));
//            Log.i(LOG_TAG, String.valueOf(arrayList.get(13).byteValue()));
//            Log.i(LOG_TAG, String.valueOf(arrayList.get(14).byteValue()));
//            Log.i(LOG_TAG, String.valueOf(arrayList.get(15).byteValue()));


//            Log.i(LOG_TAG, String.valueOf(baos.toByteArray()));
//            try {
//
////                while ((line = bufferedReader.readLine()) != null){
////                    stringBuilder.append(line);
////                    Log.i(LOG_TAG, String.valueOf(i));
////                    Log.i(LOG_TAG, line);
////                    i++;
////                }
////            } catch (IOException e) {
////                e.printStackTrace();
////            }
//        } catch (FileNotFoundException | UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }

//        try {
//            FileInputStream inputStream = new FileInputStream(myFile);
//            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
//            StringBuilder stringBuilder = new StringBuilder();
//            String line;
//            try {
//                while ((line = bufferedReader.readLine()) != null){
//                    stringBuilder.append(line);
//                }
//                Log.i(LOG_TAG, stringBuilder.toString());
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
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

