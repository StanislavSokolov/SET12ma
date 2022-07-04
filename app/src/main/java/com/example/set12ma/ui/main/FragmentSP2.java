package com.example.set12ma.ui.main;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import com.example.set12ma.R;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import static android.app.Activity.RESULT_OK;

public class FragmentSP2 extends Fragment {
    private static final String ARG_SECTION_NUMBER = "SP2";
    private static final String LOG_TAG = "AndroidExample";
    private TextView textViewPathToLoadFile;
    private TextView textViewStatusLoadToFlesh;
    private TextView textViewStatusLoadToDevice;
    private TextView textViewInformationAboutDevice;
    private TextView textViewTipChoiseAddressOfDeviceForSp2;

    private Button buttonChoicePath;
    private Button buttonLoadToFlesh;
    private Button buttonStartLoadSP2;

    private ProgressBar progressBarLoadToFlesh;
    private ProgressBar progressBarLoadToDevice;

    private Uri selectedFile;
    private String stringSelectedFile = "";
    private SpaceMemory spaceMemory;
    private ResultReceiverMemorySpace resultReceiverMemorySpace;
    private SpaceStatus spaceStatus;
    private ResultReceiverStatusSpace resultReceiverStatusSpace;

    private Spinner spinnerAddressOfDevice;
    private ArrayAdapter<String> adapterAddressOfDevice;
    private int itemSelectedFromConnectedDevices = 0;

    private boolean latchLoadToFlesh = false;
    private boolean latchLoadToDevice = false;

    private UpDateGraphicalDisplay upDateGraphicalDisplay;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        resultReceiverMemorySpace = (ResultReceiverMemorySpace) context;
        resultReceiverStatusSpace = (ResultReceiverStatusSpace) context;
    }

    private PageViewModel pageViewModel;

    public static FragmentSP2 newInstance(int index) {
        FragmentSP2 fragment = new FragmentSP2();
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
        upDateGraphicalDisplay = new UpDateGraphicalDisplay();
        upDateGraphicalDisplay.start();
        spaceMemory = resultReceiverMemorySpace.getSpaceMemory();
        spaceStatus = resultReceiverStatusSpace.getSpaceStatus();
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_sp2, container, false);
        buttonChoicePath = root.findViewById(R.id.button_choice_path_for_sp2);
        buttonChoicePath.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR2)
            @Override
            public void onClick(View v) { openFile();
            }
        });
        buttonLoadToFlesh = root.findViewById(R.id.button_load_to_flesh_for_sp2);
        buttonLoadToFlesh.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR2)
            @Override
            public void onClick(View v) {
                try {
                    loadFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        textViewPathToLoadFile = root.findViewById(R.id.textView_path_to_load_file_for_sp2);
        if (spaceStatus.getDevice().equals(ARG_SECTION_NUMBER)) textViewPathToLoadFile.setText(stringSelectedFile);

        buttonStartLoadSP2 = root.findViewById(R.id.button_start_load_for_sp2);
//        buttonStartLoadSP2.setOnClickListener(new View.OnClickListener() {
//            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR2)
//            @Override
//            public void onClick(View v) { startLoad();
//            }
//        });

        textViewStatusLoadToFlesh = root.findViewById(R.id.textView_status_load_to_flesh_for_sp2);
        textViewInformationAboutDevice = root.findViewById(R.id.textView_information_about_device_for_sp2);
        textViewStatusLoadToDevice = root.findViewById(R.id.textView_status_load_to_device_for_sp2);
        textViewTipChoiseAddressOfDeviceForSp2 = root.findViewById(R.id.textView_tip_choise_address_of_device_for_sp2);

        progressBarLoadToFlesh = root.findViewById(R.id.progressBar_load_to_flesh_for_sp2);
        progressBarLoadToDevice = root.findViewById(R.id.progressBar_load_to_device_for_sp2);

        spinnerAddressOfDevice = root.findViewById(R.id.spinner_address_of_device_for_sp2);
        adapterAddressOfDevice = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item);
        adapterAddressOfDevice.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        for (int i = 0; i < 16; i++) {
            adapterAddressOfDevice.add(String.valueOf(i));
        }
        spinnerAddressOfDevice.setAdapter(adapterAddressOfDevice);
        AdapterView.OnItemSelectedListener itemSelectedListener = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                itemSelectedFromConnectedDevices = spinnerAddressOfDevice.getSelectedItemPosition();
                textViewInformationAboutDevice.setText("Устройство с адресом " + itemSelectedFromConnectedDevices + " готово к обновлению ПО");
                spaceStatus.setAddressOfDevice(itemSelectedFromConnectedDevices);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        };
        spinnerAddressOfDevice.setOnItemSelectedListener(itemSelectedListener);
        return root;
    }

    private void openFile() {
        Intent intent = new Intent()
                .setType("*/*")
                .setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select a file"), 123);
    }

    private void loadFile() throws IOException {
        if (spaceStatus.getDevice().equals(ARG_SECTION_NUMBER)) {
            InputStream inputStream = null;
            try {
                inputStream = getContext().getContentResolver().openInputStream(selectedFile);
                spaceMemory.setMemorySpaceByte();
                byte[] data = new byte[spaceMemory.getMemorySpaceByteLength()];
                int count = inputStream.read(data);
                while (count != -1) {
                    byte[] dataLastByte = new byte[count];
                    for (int i = 0; i < count; i++) {
                        dataLastByte[i] = data[i];
                    }
                    spaceMemory.setMemorySpaceArrayListByte(dataLastByte);
                    count = inputStream.read(data);
                }
//                statusSpace.setReadyFlagToLoad(true);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                inputStream.close();
            }
        } else {
            Toast.makeText(getContext(), "Укажите путь для загрузки ПО", Toast.LENGTH_LONG).show();
        }
    }

//    private void startLoad() {
//        statusSpace.setReadyFlagToStart(true);
//    }

        @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 123 && resultCode == RESULT_OK) {
            selectedFile = data.getData(); //The uri with the location of the file
            spaceStatus.setDevice(ARG_SECTION_NUMBER);
            Toast.makeText(getContext(), selectedFile.toString(), Toast.LENGTH_LONG).show();
            stringSelectedFile = data.getDataString();
            textViewPathToLoadFile.setText(stringSelectedFile);
        }
    }

    public class UpDateGraphicalDisplay extends Thread {
        @Override
        public void run() {
            super.run();
            while (true) {
                try {
                    UpDateGraphicalDisplay.sleep(150);
//                    if (statusSpace.getDevice().equals(ARG_SECTION_NUMBER)) {
//                        if (statusSpace.isStatusLoadToDevice()) {
//                            progressBarLoadToDevice.post(new Runnable() {
//                                @Override
//                                public void run() {
//                                    progressBarLoadToDevice.setVisibility(View.VISIBLE);
//                                }
//                            });
//                            textViewStatusLoadToDevice.post(new Runnable() {
//                                @Override
//                                public void run() {
//                                    if (!latchLoadToDevice) {
//                                        textViewStatusLoadToDevice.setText("Обновление...");
//                                        textViewStatusLoadToDevice.setVisibility(View.VISIBLE);
//                                        latchLoadToDevice = true;
//                                    }
//
//                                }
//                            });
//                        } else {
//                            progressBarLoadToDevice.post(new Runnable() {
//                                @Override
//                                public void run() {
//                                    progressBarLoadToDevice.setVisibility(View.INVISIBLE);
//                                }
//                            });
//                            textViewStatusLoadToDevice.post(new Runnable() {
//                                @Override
//                                public void run() {
//                                    if (latchLoadToDevice) {
//                                        textViewStatusLoadToDevice.setText("Обновление завершено");
//                                        latchLoadToDevice = false;
//                                    }
//
//                                }
//                            });
//                        }
//                        if (statusSpace.isStatusLoadToFlesh()) {
//                            progressBarLoadToFlesh.post(new Runnable() {
//                                @Override
//                                public void run() {
//                                    progressBarLoadToFlesh.setVisibility(View.VISIBLE);
//                                }
//                            });
//                            textViewStatusLoadToFlesh.post(new Runnable() {
//                                @Override
//                                public void run() {
//                                    if (!latchLoadToFlesh) {
//                                        textViewStatusLoadToFlesh.setText("Загрузка...");
//                                        textViewStatusLoadToFlesh.setVisibility(View.VISIBLE);
//                                        latchLoadToFlesh = true;
//                                    }
//                                }
//                            });
//                        } else {
//                            progressBarLoadToFlesh.post(new Runnable() {
//                                @Override
//                                public void run() {
//                                    progressBarLoadToFlesh.setVisibility(View.INVISIBLE);
//                                }
//                            });
//                            textViewStatusLoadToFlesh.post(new Runnable() {
//                                @Override
//                                public void run() {
//                                    if (latchLoadToFlesh) {
//                                        textViewStatusLoadToFlesh.setText("Загрузка завершена");
//                                        latchLoadToFlesh = false;
//                                        textViewTipChoiseAddressOfDeviceForSp2.setVisibility(View.VISIBLE);
//                                        spinnerAddressOfDevice.setVisibility(View.VISIBLE);
//                                        textViewInformationAboutDevice.setVisibility(View.VISIBLE);
//                                        buttonStartLoadSP2.setVisibility(View.VISIBLE);
//                                    }
//                                }
//                            });
//                        }
//                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public UpDateGraphicalDisplay() {
        }
    }
}

