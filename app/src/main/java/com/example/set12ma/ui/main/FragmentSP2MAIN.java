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

public class FragmentSP2MAIN extends Fragment {
    private static final String ARG_SECTION_NUMBER = "SP2MAIN";
    private static final String LOG_TAG = "AndroidExample";
    private TextView textViewPathToLoadFile;
    private TextView textViewStatusLoadToFlesh;
    private TextView textViewStatusLoadToDevice;
    private TextView textViewInformationAboutDevice;
    private TextView textViewTipChoiseAddressOfDeviceForSP2main;
    private TextView textViewTipFindFile;

    private Button buttonChoicePath;
    private Button buttonLoadToFlesh;
    private Button buttonStartLoadSP2main;

    private ProgressBar progressBarLoadToFlesh;
    private ProgressBar progressBarLoadToDevice;

    private Uri selectedFile = null;
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
    private long timer = 500;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        resultReceiverMemorySpace = (ResultReceiverMemorySpace) context;
        resultReceiverStatusSpace = (ResultReceiverStatusSpace) context;
    }

    private PageViewModel pageViewModel;

    public static FragmentSP2MAIN newInstance(int index) {
        FragmentSP2MAIN fragment = new FragmentSP2MAIN();
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
        View root = inflater.inflate(R.layout.fragment_sp2main, container, false);
        textViewTipFindFile = root.findViewById(R.id.textView_tip_find_file);
        buttonChoicePath = root.findViewById(R.id.button_choice_path_for_sp2main);
        buttonChoicePath.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR2)
            @Override
            public void onClick(View v) { openFile();
            }
        });
        buttonLoadToFlesh = root.findViewById(R.id.button_load_to_flesh_for_sp2main);
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

        buttonStartLoadSP2main = root.findViewById(R.id.button_start_load_for_sp2main);
        buttonStartLoadSP2main.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR2)
            @Override
            public void onClick(View v) { startLoad();
            }
        });
        textViewPathToLoadFile = root.findViewById(R.id.textView_path_to_load_file_for_sp2main);
        textViewStatusLoadToFlesh = root.findViewById(R.id.textView_status_load_to_flesh_for_sp2main);

        textViewInformationAboutDevice = root.findViewById(R.id.textView_information_about_device_for_sp2main);
        textViewStatusLoadToDevice = root.findViewById(R.id.textView_status_load_to_device_for_sp2main);
        textViewTipChoiseAddressOfDeviceForSP2main = root.findViewById(R.id.textView_tip_choise_address_of_device_for_sp2main);

        progressBarLoadToFlesh = root.findViewById(R.id.progressBar_load_to_flesh_for_sp2main);
        progressBarLoadToDevice = root.findViewById(R.id.progressBar_load_to_device_for_sp2main);

        spinnerAddressOfDevice = root.findViewById(R.id.spinner_address_of_device_for_sp2main);
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
                if (spaceStatus.isReadyFlagToFinishOfUpdatingSoftware()) {
                    textViewStatusLoadToDevice.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        };
        spinnerAddressOfDevice.setOnItemSelectedListener(itemSelectedListener);

        if (spaceStatus.isReadyFlagToExchangeData()){
            if (spaceStatus.getDevice().equals(ARG_SECTION_NUMBER)) {
                textViewTipFindFile.setText("Выберите файл для загрузки");
                textViewPathToLoadFile.setText(stringSelectedFile);
                textViewPathToLoadFile.setVisibility(View.VISIBLE);
                if (spaceStatus.isReadyFlagToLoadSoftware() || (spaceStatus.isStatusProcessOfLoadingSoftware())) {
                    textViewStatusLoadToFlesh.setText("Загрузка в память...");
                    textViewStatusLoadToFlesh.setVisibility(View.VISIBLE);
                    progressBarLoadToFlesh.setVisibility(View.VISIBLE);
                    textViewTipChoiseAddressOfDeviceForSP2main.setVisibility(View.INVISIBLE);
                    spinnerAddressOfDevice.setVisibility(View.INVISIBLE);
                    textViewInformationAboutDevice.setVisibility(View.INVISIBLE);
                    textViewStatusLoadToDevice.setVisibility(View.INVISIBLE);
                    progressBarLoadToDevice.setVisibility(View.INVISIBLE);
                }
                if (spaceStatus.isReadyFlagToFinishOfLoadingSoftware()) {
                    textViewStatusLoadToFlesh.setText("Загрузка завершена");
                    textViewStatusLoadToFlesh.setVisibility(View.VISIBLE);
                    progressBarLoadToFlesh.setVisibility(View.INVISIBLE);
                    textViewTipChoiseAddressOfDeviceForSP2main.setVisibility(View.VISIBLE);
                    spinnerAddressOfDevice.setVisibility(View.VISIBLE);
                    textViewInformationAboutDevice.setVisibility(View.VISIBLE);
                    textViewStatusLoadToDevice.setVisibility(View.INVISIBLE);
                    buttonStartLoadSP2main.setVisibility(View.VISIBLE);
                    progressBarLoadToDevice.setVisibility(View.INVISIBLE);
                }
                if (spaceStatus.isReadyFlagToUpdateSoftware() || spaceStatus.isStatusProcessOfUpdatingSoftware()) {
                    textViewStatusLoadToFlesh.setText("Загрузка завершена");
                    textViewStatusLoadToFlesh.setVisibility(View.VISIBLE);
                    progressBarLoadToFlesh.setVisibility(View.INVISIBLE);
                    textViewTipChoiseAddressOfDeviceForSP2main.setVisibility(View.VISIBLE);
                    spinnerAddressOfDevice.setVisibility(View.VISIBLE);
                    textViewInformationAboutDevice.setVisibility(View.VISIBLE);
                    textViewStatusLoadToDevice.setText("Обновление ПО...");
                    textViewStatusLoadToDevice.setVisibility(View.VISIBLE);
                    buttonStartLoadSP2main.setVisibility(View.VISIBLE);
                    progressBarLoadToDevice.setVisibility(View.VISIBLE);
                }
                if (spaceStatus.isReadyFlagToFinishOfUpdatingSoftware()) {
                    textViewStatusLoadToFlesh.setText("Загрузка завершена");
                    textViewStatusLoadToFlesh.setVisibility(View.VISIBLE);
                    progressBarLoadToFlesh.setVisibility(View.INVISIBLE);
                    textViewTipChoiseAddressOfDeviceForSP2main.setVisibility(View.VISIBLE);
                    spinnerAddressOfDevice.setVisibility(View.VISIBLE);
                    textViewInformationAboutDevice.setVisibility(View.VISIBLE);
                    textViewStatusLoadToDevice.setText("Обновление завершено");
                    textViewStatusLoadToDevice.setVisibility(View.VISIBLE);
                    buttonStartLoadSP2main.setVisibility(View.VISIBLE);
                    progressBarLoadToDevice.setVisibility(View.INVISIBLE);
                }
            } else {
                textViewPathToLoadFile.setText("Путь не указан");
                textViewPathToLoadFile.setVisibility(View.VISIBLE);
                buttonChoicePath.setVisibility(View.VISIBLE);
                buttonLoadToFlesh.setVisibility(View.VISIBLE);
                if (spaceStatus.isReadyFlagToLoadSoftware() || (spaceStatus.isStatusProcessOfLoadingSoftware()) || (spaceStatus.isReadyFlagToUpdateSoftware()) || (spaceStatus.isStatusProcessOfUpdatingSoftware())) {
                    textViewPathToLoadFile.setVisibility(View.INVISIBLE);
                    buttonChoicePath.setVisibility(View.INVISIBLE);
                    buttonLoadToFlesh.setVisibility(View.INVISIBLE);
                    textViewStatusLoadToFlesh.setText("Дождитесь завершения загрузки ПО для " + spaceStatus.getDevice());
                    textViewStatusLoadToFlesh.setVisibility(View.VISIBLE);
                    buttonStartLoadSP2main.setVisibility(View.INVISIBLE);
                    progressBarLoadToFlesh.setVisibility(View.VISIBLE);
                }
            }
        } else {
            buttonChoicePath.setVisibility(View.INVISIBLE);
            buttonLoadToFlesh.setVisibility(View.INVISIBLE);
            textViewPathToLoadFile.setVisibility(View.INVISIBLE);
            textViewTipFindFile.setText("Подключитесь к устройству");
//            Toast.makeText(getContext(), "Подключитесь к устройству", Toast.LENGTH_LONG).show();
        }

        return root;
    }

    private void openFile() {
        if (!spaceStatus.isStatusProcessOfUpdatingSoftware() & !spaceStatus.isStatusProcessOfLoadingSoftware()) {
            Intent intent = new Intent()
                    .setType("*/*")
                    .setAction(Intent.ACTION_GET_CONTENT);
            startActivityForResult(Intent.createChooser(intent, "Select a file"), 123);
        } else {
            Toast.makeText(getContext(), "Дождитесь завершения обновления ПО", Toast.LENGTH_LONG).show();
        }
    }

    private void loadFile() throws IOException {
        if (spaceStatus.getDevice().equals(ARG_SECTION_NUMBER)) {
            if (!spaceStatus.isReadyFlagToLoadSoftware() & (!spaceStatus.isStatusProcessOfLoadingSoftware() & (!spaceStatus.isReadyFlagToFinishOfLoadingSoftware()))) {
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
                    spaceStatus.setReadyFlagToLoadSoftware(true);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
//            inputStream.close();
                }
            } else {
                if (spaceStatus.isReadyFlagToLoadSoftware() || spaceStatus.isStatusProcessOfLoadingSoftware()) {
                    Toast.makeText(getContext(), "Дождитесь завершения загрузки ПО", Toast.LENGTH_LONG).show();
                } else if (spaceStatus.isReadyFlagToUpdateSoftware() || spaceStatus.isStatusProcessOfUpdatingSoftware()) {
                    Toast.makeText(getContext(), "Дождитесь завершения обновления ПО", Toast.LENGTH_LONG).show();
                }

            }
        } else {
            Toast.makeText(getContext(), "Укажите путь для загрузки ПО", Toast.LENGTH_LONG).show();
        }
    }

    private void startLoad() {
        if (!spaceStatus.isStatusProcessOfUpdatingSoftware() & !spaceStatus.isStatusProcessOfLoadingSoftware()) {
            spaceStatus.setReadyFlagToUpdateSoftware(true);
        } else {
            Toast.makeText(getContext(), "Дождитесь завершения обновления ПО", Toast.LENGTH_LONG).show();
        }
    }

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
                    UpDateGraphicalDisplay.sleep(timer);

                    if (spaceStatus.isReadyFlagToExchangeData()) {
                        textViewTipFindFile.post(new Runnable() {
                            @Override
                            public void run() {
                                textViewTipFindFile.setText("Выберите файл для загрузки");
                            }
                        });
                        if (spaceStatus.getDevice().equals(ARG_SECTION_NUMBER)) {
                            if (spaceStatus.isStatusProcessOfUpdatingSoftware()) {
                                progressBarLoadToDevice.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        progressBarLoadToDevice.setVisibility(View.VISIBLE);
                                    }
                                });
                                textViewStatusLoadToDevice.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        if (!latchLoadToDevice) {
                                            textViewStatusLoadToDevice.setText("Обновление ПО...");
                                            textViewStatusLoadToDevice.setVisibility(View.VISIBLE);
                                            latchLoadToDevice = true;
                                        }

                                    }
                                });
                            } else {
                                progressBarLoadToDevice.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        progressBarLoadToDevice.setVisibility(View.INVISIBLE);
                                    }
                                });
                                textViewStatusLoadToDevice.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        if (latchLoadToDevice) {
                                            textViewStatusLoadToDevice.setText("Обновление завершено");
                                            latchLoadToDevice = false;
                                        }

                                    }
                                });
                            }
                            if (spaceStatus.isStatusProcessOfLoadingSoftware()) {
                                progressBarLoadToFlesh.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        progressBarLoadToFlesh.setVisibility(View.VISIBLE);
                                    }
                                });
                                textViewStatusLoadToFlesh.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        if (!latchLoadToFlesh) {
                                            textViewStatusLoadToFlesh.setText("Загрузка в память...");
                                            textViewStatusLoadToFlesh.setVisibility(View.VISIBLE);
                                            latchLoadToFlesh = true;
                                        }
                                    }
                                });
                            } else {
                                progressBarLoadToFlesh.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        progressBarLoadToFlesh.setVisibility(View.INVISIBLE);
                                    }
                                });
                                textViewStatusLoadToFlesh.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        if (latchLoadToFlesh) {
                                            textViewStatusLoadToFlesh.setText("Загрузка завершена");
                                            latchLoadToFlesh = false;
                                            textViewTipChoiseAddressOfDeviceForSP2main.setVisibility(View.VISIBLE);
                                            spinnerAddressOfDevice.setVisibility(View.VISIBLE);
                                            textViewInformationAboutDevice.setVisibility(View.VISIBLE);
                                            buttonStartLoadSP2main.setVisibility(View.VISIBLE);
                                        }
                                    }
                                });
                            }

                        } else {
                            textViewPathToLoadFile.post(new Runnable() {
                                @Override
                                public void run() {

                                    if (spaceStatus.isReadyFlagToLoadSoftware() || (spaceStatus.isStatusProcessOfLoadingSoftware()) || (spaceStatus.isReadyFlagToUpdateSoftware()) || (spaceStatus.isStatusProcessOfUpdatingSoftware())) {
                                        textViewPathToLoadFile.setVisibility(View.INVISIBLE);
                                        buttonChoicePath.setVisibility(View.INVISIBLE);
                                        buttonLoadToFlesh.setVisibility(View.INVISIBLE);
                                        textViewStatusLoadToFlesh.setText("Дождитесь завершения загрузки ПО для " + spaceStatus.getDevice());
                                        textViewStatusLoadToFlesh.setVisibility(View.VISIBLE);
                                        buttonStartLoadSP2main.setVisibility(View.INVISIBLE);
                                        progressBarLoadToFlesh.setVisibility(View.VISIBLE);
                                    } else {
                                        textViewPathToLoadFile.setText("Путь не указан");
                                        textViewPathToLoadFile.setVisibility(View.VISIBLE);
                                        buttonChoicePath.setVisibility(View.VISIBLE);
                                        buttonLoadToFlesh.setVisibility(View.VISIBLE);
                                        textViewStatusLoadToFlesh.setVisibility(View.INVISIBLE);
                                        buttonStartLoadSP2main.setVisibility(View.INVISIBLE);
                                        progressBarLoadToFlesh.setVisibility(View.INVISIBLE);

                                        textViewTipChoiseAddressOfDeviceForSP2main.setVisibility(View.INVISIBLE);
                                        spinnerAddressOfDevice.setVisibility(View.INVISIBLE);
                                        textViewInformationAboutDevice.setVisibility(View.INVISIBLE);
                                        textViewStatusLoadToDevice.setVisibility(View.INVISIBLE);
                                        progressBarLoadToDevice.setVisibility(View.INVISIBLE);
                                    }
                                }
                            });
                        }
                    } else {
                        textViewTipFindFile.post(new Runnable() {
                            @Override
                            public void run() {

                                buttonChoicePath.setVisibility(View.INVISIBLE);
                                buttonLoadToFlesh.setVisibility(View.INVISIBLE);
                                textViewPathToLoadFile.setVisibility(View.INVISIBLE);
                                textViewTipFindFile.setText("Подключитесь к устройству");
                            }
                        });
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public UpDateGraphicalDisplay() {
        }
    }
}

