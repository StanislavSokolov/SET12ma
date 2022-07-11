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
import android.widget.*;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import com.example.set12ma.R;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import static android.app.Activity.RESULT_OK;

public class FragmentLoading extends Fragment {
    private static final String ARG_SECTION_NUMBER = "TMS2812";
    private static final String LOG_TAG = "AndroidExample";

    private static final String DEVICE_0 = "TMS2812";
    private static final String DEVICE_1 = "SP2main";
    private static final String DEVICE_2 = "SP2";
    private static final String DEVICE_3 = "SP6";
    private String deviceSelected = "";
    private TextView textViewTipChoiceDevices;
    private TextView textViewPathToLoadFile;
    private TextView textViewStatusLoadToFlesh;
    private TextView textViewStatusLoadToDevice;
    private TextView textViewInformationAboutDevice;
    private TextView textViewTipChoiseAddressOfDeviceForTMS2812;
    private TextView textViewTipFindFile;

    private Button buttonChoicePath;
    private Button buttonLoadToFlesh;
    private Button buttonStartLoadTMS2812;

    private ProgressBar progressBarLoadToFlesh;
    private ProgressBar progressBarLoadToDevice;

    private Uri selectedFile = null;
    private String stringSelectedFile = "Путь не указан";
    private SpaceMemory spaceMemory;
    private ResultReceiverMemorySpace resultReceiverMemorySpace;
    private SpaceStatus spaceStatus;
    private ResultReceiverStatusSpace resultReceiverStatusSpace;

    private Spinner spinnerAddressOfDevice;
    private Spinner spinnerTypeOfDevice;
    private ArrayAdapter<String> adapterAddressOfDevice;
    private ArrayAdapter<String> adapterTypeOfDevice;
    private int itemSelectedFromConnectedDevices = 0;
    private int itemSelectedFromTypeOfDevices = 0;

    private boolean latchLoadToFlesh = false;
    private boolean latchLoadToDevice = false;

    private UpDateGraphicalDisplay upDateGraphicalDisplay;
    private long timer = 100;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        resultReceiverMemorySpace = (ResultReceiverMemorySpace) context;
        resultReceiverStatusSpace = (ResultReceiverStatusSpace) context;
    }

    private PageViewModel pageViewModel;

    public static FragmentLoading newInstance(int index) {
        FragmentLoading fragment = new FragmentLoading();
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
        spaceMemory = resultReceiverMemorySpace.getSpaceMemory();
        spaceStatus = resultReceiverStatusSpace.getSpaceStatus();
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_loading, container, false);
        textViewTipChoiceDevices = root.findViewById(R.id.textView_tip_choice_devices);
        textViewTipFindFile = root.findViewById(R.id.textView_tip_find_file);


        buttonChoicePath = root.findViewById(R.id.button_choice_path_for_tms2812);
        buttonChoicePath.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR2)
            @Override
            public void onClick(View v) { openFile();
            }
        });
        buttonLoadToFlesh = root.findViewById(R.id.button_load_to_flesh_for_tms2812);
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

        buttonStartLoadTMS2812 = root.findViewById(R.id.button_start_load_for_tms2812);
        buttonStartLoadTMS2812.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR2)
            @Override
            public void onClick(View v) { startLoad();
            }
        });
        textViewPathToLoadFile = root.findViewById(R.id.textView_path_to_load_file_for_tms2812);
        textViewStatusLoadToFlesh = root.findViewById(R.id.textView_status_load_to_flesh_for_tms2812);

        textViewInformationAboutDevice = root.findViewById(R.id.textView_information_about_device_for_tms2812);
        textViewStatusLoadToDevice = root.findViewById(R.id.textView_status_load_to_device_for_tms2812);
        textViewTipChoiseAddressOfDeviceForTMS2812 = root.findViewById(R.id.textView_tip_choise_address_of_device_for_tms2812);

        progressBarLoadToFlesh = root.findViewById(R.id.progressBar_load_to_flesh_for_tms2812);
        progressBarLoadToDevice = root.findViewById(R.id.progressBar_load_to_device_for_tms2812);

        spinnerTypeOfDevice = root.findViewById(R.id.spinner_type_of_device);
        adapterTypeOfDevice = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item);
        adapterTypeOfDevice.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterTypeOfDevice.add(DEVICE_0);
        adapterTypeOfDevice.add(DEVICE_1);
        adapterTypeOfDevice.add(DEVICE_2);
        adapterTypeOfDevice.add(DEVICE_3);

        spinnerTypeOfDevice.setAdapter(adapterTypeOfDevice);
        AdapterView.OnItemSelectedListener itemSelectedListener0 = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                itemSelectedFromTypeOfDevices = spinnerTypeOfDevice.getSelectedItemPosition();
                if (itemSelectedFromTypeOfDevices == 0) deviceSelected = DEVICE_0;
                if (itemSelectedFromTypeOfDevices == 1) deviceSelected = DEVICE_1;
                if (itemSelectedFromTypeOfDevices == 2) deviceSelected = DEVICE_2;
                if (itemSelectedFromTypeOfDevices == 3) deviceSelected = DEVICE_3;
                textViewTipFindFile.post(new Runnable() {
                    @Override
                    public void run() {
                        textViewTipFindFile.setText("Выберите файл для загрузки для " + deviceSelected);
                    }
                });
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        };
        spinnerTypeOfDevice.setOnItemSelectedListener(itemSelectedListener0);









        spinnerAddressOfDevice = root.findViewById(R.id.spinner_address_of_device_for_tms2812);
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
//            textViewTipChoiceDevices.setText("Выберите тип устройства");
//            textViewTipChoiceDevices.setVisibility(View.VISIBLE);
//            spinnerTypeOfDevice.setVisibility(View.VISIBLE);
//            spinnerAddressOfDevice.setVisibility(View.INVISIBLE);
//            textViewTipFindFile.setVisibility(View.VISIBLE);
//            buttonChoicePath.setVisibility(View.VISIBLE);
//            buttonLoadToFlesh.setVisibility(View.VISIBLE);
//            textViewPathToLoadFile.setVisibility(View.VISIBLE);
//            buttonChoicePath.setVisibility(View.INVISIBLE);
//            buttonLoadToFlesh.setVisibility(View.INVISIBLE);
//            textViewStatusLoadToFlesh.setVisibility(View.INVISIBLE);
//            buttonStartLoadTMS2812.setVisibility(View.INVISIBLE);
//            progressBarLoadToFlesh.setVisibility(View.INVISIBLE);
        } else {
            textViewTipChoiceDevices.setText("Подключитесь к устройству");
            spinnerTypeOfDevice.setVisibility(View.INVISIBLE);
            spinnerAddressOfDevice.setVisibility(View.INVISIBLE);
            textViewTipChoiceDevices.setVisibility(View.VISIBLE);
            textViewTipFindFile.setVisibility(View.INVISIBLE);
            buttonChoicePath.setVisibility(View.INVISIBLE);
            buttonLoadToFlesh.setVisibility(View.INVISIBLE);
            textViewPathToLoadFile.setVisibility(View.INVISIBLE);
            buttonChoicePath.setVisibility(View.INVISIBLE);
            buttonLoadToFlesh.setVisibility(View.INVISIBLE);
            textViewStatusLoadToFlesh.setVisibility(View.INVISIBLE);
            buttonStartLoadTMS2812.setVisibility(View.INVISIBLE);
            progressBarLoadToFlesh.setVisibility(View.INVISIBLE);
        }

        Log.i(LOG_TAG, "onCreateView1");
        upDateGraphicalDisplay = new UpDateGraphicalDisplay();
        upDateGraphicalDisplay.start();

        return root;
    }

    @Override
    public void onPause() {
        super.onPause();
        upDateGraphicalDisplay.interrupt();
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

            // если путь файла изменен, то надо разрешать загружать еще раз
            // сейчас это не работает

            // так же корректно не работает повторная прошивка по этому или любому другому адресу
            // здесь какие-то проблемы в логике
            // на самом деле прошивка стартует
            // но в приложении ее статус затирается

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
                    if (spaceStatus.isReadyFlagToExchangeData()){
                        if (spaceStatus.isReadyFlagToLoadSoftware() || (spaceStatus.isStatusProcessOfLoadingSoftware())) {
                            textViewTipChoiceDevices.post(new Runnable() {
                                @Override
                                public void run() {
                                    textViewTipChoiceDevices.setText("Выберите тип устройства для обновления ПО");
                                    textViewTipChoiceDevices.setVisibility(View.VISIBLE);
                                }
                            });
                            spinnerTypeOfDevice.post(new Runnable() {
                                @Override
                                public void run() {
                                    spinnerTypeOfDevice.setVisibility(View.VISIBLE);
                                    spinnerTypeOfDevice.setEnabled(true);
                                }
                            });
                            textViewTipFindFile.post(new Runnable() {
                                @Override
                                public void run() {
                                    textViewTipFindFile.setVisibility(View.VISIBLE);
                                }
                            });
                            buttonChoicePath.post(new Runnable() {
                                @Override
                                public void run() {
                                    buttonChoicePath.setVisibility(View.VISIBLE);
                                    buttonChoicePath.setEnabled(true);
                                }
                            });
                            buttonLoadToFlesh.post(new Runnable() {
                                @Override
                                public void run() {
                                    buttonLoadToFlesh.setVisibility(View.VISIBLE);
                                    buttonLoadToFlesh.setEnabled(true);
                                }
                            });
                            textViewPathToLoadFile.post(new Runnable() {
                                @Override
                                public void run() {
                                    textViewPathToLoadFile.setVisibility(View.VISIBLE);
                                }
                            });
                            progressBarLoadToFlesh.post(new Runnable() {
                                @Override
                                public void run() {
                                    progressBarLoadToFlesh.setVisibility(View.VISIBLE);
                                }
                            });
                            textViewStatusLoadToFlesh.post(new Runnable() {
                                @Override
                                public void run() {
                                    textViewStatusLoadToFlesh.setVisibility(View.VISIBLE);
                                    textViewTipChoiceDevices.setText("Загрузка в память...");
                                }
                            });
                            textViewTipChoiseAddressOfDeviceForTMS2812.post(new Runnable() {
                                @Override
                                public void run() {
                                    textViewTipChoiseAddressOfDeviceForTMS2812.setVisibility(View.INVISIBLE);
                                }
                            });
                            spinnerAddressOfDevice.post(new Runnable() {
                                @Override
                                public void run() {
                                    spinnerAddressOfDevice.setVisibility(View.INVISIBLE);
                                }
                            });
                            textViewInformationAboutDevice.post(new Runnable() {
                                @Override
                                public void run() {
                                    textViewInformationAboutDevice.setVisibility(View.INVISIBLE);
                                }
                            });
                            buttonStartLoadTMS2812.post(new Runnable() {
                                @Override
                                public void run() {
                                    buttonStartLoadTMS2812.setVisibility(View.INVISIBLE);
                                }
                            });
                            progressBarLoadToFlesh.post(new Runnable() {
                                @Override
                                public void run() {
                                    progressBarLoadToFlesh.setVisibility(View.INVISIBLE);
                                }
                            });
                            textViewStatusLoadToFlesh.post(new Runnable() {
                                @Override
                                public void run() {
                                    textViewStatusLoadToFlesh.setVisibility(View.INVISIBLE);
                                }
                            });
                        } else if (spaceStatus.isReadyFlagToFinishOfLoadingSoftware()) {
                            textViewTipChoiceDevices.post(new Runnable() {
                                @Override
                                public void run() {
                                    textViewTipChoiceDevices.setText("Выберите тип устройства для обновления ПО");
                                    textViewTipChoiceDevices.setVisibility(View.VISIBLE);
                                }
                            });
                            spinnerTypeOfDevice.post(new Runnable() {
                                @Override
                                public void run() {
                                    spinnerTypeOfDevice.setVisibility(View.VISIBLE);
                                    spinnerTypeOfDevice.setEnabled(false);
                                }
                            });
                            textViewTipFindFile.post(new Runnable() {
                                @Override
                                public void run() {
                                    textViewTipFindFile.setVisibility(View.VISIBLE);
                                }
                            });
                            buttonChoicePath.post(new Runnable() {
                                @Override
                                public void run() {
                                    buttonChoicePath.setVisibility(View.VISIBLE);
                                }
                            });
                            buttonLoadToFlesh.post(new Runnable() {
                                @Override
                                public void run() {
                                    buttonLoadToFlesh.setVisibility(View.VISIBLE);
                                }
                            });
                            textViewPathToLoadFile.post(new Runnable() {
                                @Override
                                public void run() {
                                    textViewPathToLoadFile.setVisibility(View.VISIBLE);
                                }
                            });
                            progressBarLoadToFlesh.post(new Runnable() {
                                @Override
                                public void run() {
                                    progressBarLoadToFlesh.setVisibility(View.INVISIBLE);
                                }
                            });
                            textViewStatusLoadToFlesh.post(new Runnable() {
                                @Override
                                public void run() {
                                    textViewStatusLoadToFlesh.setVisibility(View.VISIBLE);
                                    textViewTipChoiceDevices.setText("Загрузка завершена");
                                }
                            });
                            textViewTipChoiseAddressOfDeviceForTMS2812.post(new Runnable() {
                                @Override
                                public void run() {
                                    textViewTipChoiseAddressOfDeviceForTMS2812.setVisibility(View.VISIBLE);
                                }
                            });
                            spinnerAddressOfDevice.post(new Runnable() {
                                @Override
                                public void run() {
                                    spinnerAddressOfDevice.setVisibility(View.VISIBLE);
                                }
                            });
                            textViewInformationAboutDevice.post(new Runnable() {
                                @Override
                                public void run() {
                                    textViewInformationAboutDevice.setVisibility(View.VISIBLE);
                                }
                            });
                            buttonStartLoadTMS2812.post(new Runnable() {
                                @Override
                                public void run() {
                                    buttonStartLoadTMS2812.setVisibility(View.VISIBLE);
                                }
                            });
                            progressBarLoadToFlesh.post(new Runnable() {
                                @Override
                                public void run() {
                                    progressBarLoadToFlesh.setVisibility(View.INVISIBLE);
                                }
                            });
                            textViewStatusLoadToFlesh.post(new Runnable() {
                                @Override
                                public void run() {
                                    textViewStatusLoadToFlesh.setVisibility(View.INVISIBLE);
                                }
                            });
                        } else if (spaceStatus.isReadyFlagToUpdateSoftware() || spaceStatus.isStatusProcessOfUpdatingSoftware()) {
                            textViewTipChoiceDevices.post(new Runnable() {
                                @Override
                                public void run() {
                                    textViewTipChoiceDevices.setText("Выберите тип устройства для обновления ПО");
                                    textViewTipChoiceDevices.setVisibility(View.VISIBLE);
                                }
                            });
                            spinnerTypeOfDevice.post(new Runnable() {
                                @Override
                                public void run() {
                                    spinnerTypeOfDevice.setVisibility(View.VISIBLE);
                                    spinnerTypeOfDevice.setEnabled(false);
                                }
                            });
                            textViewTipFindFile.post(new Runnable() {
                                @Override
                                public void run() {
                                    textViewTipFindFile.setVisibility(View.VISIBLE);
                                }
                            });
                            buttonChoicePath.post(new Runnable() {
                                @Override
                                public void run() {
                                    buttonChoicePath.setVisibility(View.VISIBLE);
                                    buttonChoicePath.setEnabled(false);
                                }
                            });
                            buttonLoadToFlesh.post(new Runnable() {
                                @Override
                                public void run() {
                                    buttonLoadToFlesh.setVisibility(View.VISIBLE);
                                    buttonLoadToFlesh.setEnabled(false);
                                }
                            });
                            textViewPathToLoadFile.post(new Runnable() {
                                @Override
                                public void run() {
                                    textViewPathToLoadFile.setVisibility(View.VISIBLE);
                                }
                            });
                            progressBarLoadToFlesh.post(new Runnable() {
                                @Override
                                public void run() {
                                    progressBarLoadToFlesh.setVisibility(View.INVISIBLE);
                                }
                            });
                            textViewStatusLoadToFlesh.post(new Runnable() {
                                @Override
                                public void run() {
                                    textViewStatusLoadToFlesh.setVisibility(View.VISIBLE);
                                    textViewTipChoiceDevices.setText("Загрузка завершена");
                                }
                            });
                            textViewTipChoiseAddressOfDeviceForTMS2812.post(new Runnable() {
                                @Override
                                public void run() {
                                    textViewTipChoiseAddressOfDeviceForTMS2812.setVisibility(View.VISIBLE);
                                }
                            });
                            spinnerAddressOfDevice.post(new Runnable() {
                                @Override
                                public void run() {
                                    spinnerAddressOfDevice.setVisibility(View.VISIBLE);
                                }
                            });
                            textViewInformationAboutDevice.post(new Runnable() {
                                @Override
                                public void run() {
                                    textViewInformationAboutDevice.setVisibility(View.VISIBLE);
                                }
                            });
                            buttonStartLoadTMS2812.post(new Runnable() {
                                @Override
                                public void run() {
                                    buttonStartLoadTMS2812.setVisibility(View.VISIBLE);
                                }
                            });
                            progressBarLoadToFlesh.post(new Runnable() {
                                @Override
                                public void run() {
                                    progressBarLoadToFlesh.setVisibility(View.INVISIBLE);
                                }
                            });
                            textViewStatusLoadToFlesh.post(new Runnable() {
                                @Override
                                public void run() {
                                    textViewStatusLoadToFlesh.setVisibility(View.INVISIBLE);
                                }
                            });
                        } else if (spaceStatus.isReadyFlagToFinishOfUpdatingSoftware()) {
//                            textViewStatusLoadToFlesh.setText("Загрузка завершена");
//                            textViewStatusLoadToFlesh.setVisibility(View.VISIBLE);
//                            progressBarLoadToFlesh.setVisibility(View.INVISIBLE);
//                            textViewTipChoiseAddressOfDeviceForTMS2812.setVisibility(View.VISIBLE);
//                            spinnerAddressOfDevice.setVisibility(View.VISIBLE);
//                            textViewInformationAboutDevice.setVisibility(View.VISIBLE);
//                            textViewStatusLoadToDevice.setText("Обновление завершено");
//                            textViewStatusLoadToDevice.setVisibility(View.VISIBLE);
//                            buttonStartLoadTMS2812.setVisibility(View.VISIBLE);
//                            progressBarLoadToDevice.setVisibility(View.INVISIBLE);
                        } else {
                            textViewTipChoiceDevices.post(new Runnable() {
                                @Override
                                public void run() {
                                    textViewTipChoiceDevices.setText("Выберите тип устройства для обновления ПО");
                                    textViewTipChoiceDevices.setVisibility(View.VISIBLE);
                                }
                            });
                            spinnerTypeOfDevice.post(new Runnable() {
                                @Override
                                public void run() {
                                    spinnerTypeOfDevice.setVisibility(View.VISIBLE);
                                }
                            });
                            textViewTipFindFile.post(new Runnable() {
                                @Override
                                public void run() {
                                    textViewTipFindFile.setVisibility(View.VISIBLE);
                                }
                            });
                            buttonChoicePath.post(new Runnable() {
                                @Override
                                public void run() {
                                    buttonChoicePath.setVisibility(View.VISIBLE);
                                }
                            });
                            buttonLoadToFlesh.post(new Runnable() {
                                @Override
                                public void run() {
                                    buttonLoadToFlesh.setVisibility(View.VISIBLE);
                                }
                            });
                            textViewPathToLoadFile.post(new Runnable() {
                                @Override
                                public void run() {
                                    textViewPathToLoadFile.setVisibility(View.VISIBLE);
                                }
                            });
                            progressBarLoadToFlesh.post(new Runnable() {
                                @Override
                                public void run() {
                                    progressBarLoadToFlesh.setVisibility(View.INVISIBLE);
                                }
                            });
                            textViewStatusLoadToFlesh.post(new Runnable() {
                                @Override
                                public void run() {
                                    textViewStatusLoadToFlesh.setVisibility(View.INVISIBLE);
                                }
                            });
                            textViewTipChoiseAddressOfDeviceForTMS2812.post(new Runnable() {
                                @Override
                                public void run() {
                                    textViewTipChoiseAddressOfDeviceForTMS2812.setVisibility(View.INVISIBLE);
                                }
                            });
                            spinnerAddressOfDevice.post(new Runnable() {
                                @Override
                                public void run() {
                                    spinnerAddressOfDevice.setVisibility(View.INVISIBLE);
                                }
                            });
                            textViewInformationAboutDevice.post(new Runnable() {
                                @Override
                                public void run() {
                                    textViewInformationAboutDevice.setVisibility(View.INVISIBLE);
                                }
                            });
                            buttonStartLoadTMS2812.post(new Runnable() {
                                @Override
                                public void run() {
                                    buttonStartLoadTMS2812.setVisibility(View.INVISIBLE);
                                }
                            });
                            progressBarLoadToFlesh.post(new Runnable() {
                                @Override
                                public void run() {
                                    progressBarLoadToFlesh.setVisibility(View.INVISIBLE);
                                }
                            });
                            textViewStatusLoadToFlesh.post(new Runnable() {
                                @Override
                                public void run() {
                                    textViewStatusLoadToFlesh.setVisibility(View.INVISIBLE);
                                }
                            });
                        }

////                        if (spaceStatus.isReadyFlagToFinishOfLoadingSoftware()) {
////                            textViewStatusLoadToFlesh.setText("Загрузка завершена");
////                            textViewStatusLoadToFlesh.setVisibility(View.VISIBLE);
////                            progressBarLoadToFlesh.setVisibility(View.INVISIBLE);
////                            textViewTipChoiseAddressOfDeviceForTMS2812.setVisibility(View.VISIBLE);
////                            spinnerAddressOfDevice.setVisibility(View.VISIBLE);
////                            textViewInformationAboutDevice.setVisibility(View.VISIBLE);
////                            textViewStatusLoadToDevice.setVisibility(View.INVISIBLE);
////                            buttonStartLoadTMS2812.setVisibility(View.VISIBLE);
////                            progressBarLoadToDevice.setVisibility(View.INVISIBLE);
////                        }
////                        if (spaceStatus.isReadyFlagToUpdateSoftware() || spaceStatus.isStatusProcessOfUpdatingSoftware()) {
////                            textViewStatusLoadToFlesh.setText("Загрузка завершена");
////                            textViewStatusLoadToFlesh.setVisibility(View.VISIBLE);
////                            progressBarLoadToFlesh.setVisibility(View.INVISIBLE);
////                            textViewTipChoiseAddressOfDeviceForTMS2812.setVisibility(View.VISIBLE);
////                            spinnerAddressOfDevice.setVisibility(View.VISIBLE);
////                            textViewInformationAboutDevice.setVisibility(View.VISIBLE);
////                            textViewStatusLoadToDevice.setText("Обновление ПО...");
////                            textViewStatusLoadToDevice.setVisibility(View.VISIBLE);
////                            buttonStartLoadTMS2812.setVisibility(View.VISIBLE);
////                            progressBarLoadToDevice.setVisibility(View.VISIBLE);
////                        }
////                        if (spaceStatus.isReadyFlagToFinishOfUpdatingSoftware()) {
////                            textViewStatusLoadToFlesh.setText("Загрузка завершена");
////                            textViewStatusLoadToFlesh.setVisibility(View.VISIBLE);
////                            progressBarLoadToFlesh.setVisibility(View.INVISIBLE);
////                            textViewTipChoiseAddressOfDeviceForTMS2812.setVisibility(View.VISIBLE);
////                            spinnerAddressOfDevice.setVisibility(View.VISIBLE);
////                            textViewInformationAboutDevice.setVisibility(View.VISIBLE);
////                            textViewStatusLoadToDevice.setText("Обновление завершено");
////                            textViewStatusLoadToDevice.setVisibility(View.VISIBLE);
////                            buttonStartLoadTMS2812.setVisibility(View.VISIBLE);
////                            progressBarLoadToDevice.setVisibility(View.INVISIBLE);
////                        }
                    } else {
                        textViewTipChoiceDevices.post(new Runnable() {
                            @Override
                            public void run() {
                                textViewTipChoiceDevices.setText("Подключитесь к устройству");
                                textViewTipChoiceDevices.setVisibility(View.VISIBLE);
                            }
                        });
                        spinnerTypeOfDevice.post(new Runnable() {
                            @Override
                            public void run() {
                                spinnerTypeOfDevice.setVisibility(View.INVISIBLE);
                            }
                        });
                        textViewTipFindFile.post(new Runnable() {
                            @Override
                            public void run() {
                                textViewTipFindFile.setVisibility(View.INVISIBLE);
                            }
                        });
                        buttonChoicePath.post(new Runnable() {
                            @Override
                            public void run() {
                                buttonChoicePath.setVisibility(View.INVISIBLE);
                            }
                        });
                        buttonLoadToFlesh.post(new Runnable() {
                            @Override
                            public void run() {
                                buttonLoadToFlesh.setVisibility(View.INVISIBLE);
                            }
                        });
                        textViewPathToLoadFile.post(new Runnable() {
                            @Override
                            public void run() {
                                textViewPathToLoadFile.setVisibility(View.INVISIBLE);
                            }
                        });
                        progressBarLoadToFlesh.post(new Runnable() {
                            @Override
                            public void run() {
                                progressBarLoadToFlesh.setVisibility(View.INVISIBLE);
                            }
                        });
                        textViewStatusLoadToFlesh.post(new Runnable() {
                            @Override
                            public void run() {
                                textViewStatusLoadToFlesh.setVisibility(View.INVISIBLE);
                            }
                        });
                        textViewTipChoiseAddressOfDeviceForTMS2812.post(new Runnable() {
                            @Override
                            public void run() {
                                textViewTipChoiseAddressOfDeviceForTMS2812.setVisibility(View.INVISIBLE);
                            }
                        });
                        spinnerAddressOfDevice.post(new Runnable() {
                            @Override
                            public void run() {
                                spinnerAddressOfDevice.setVisibility(View.INVISIBLE);
                            }
                        });
                        textViewInformationAboutDevice.post(new Runnable() {
                            @Override
                            public void run() {
                                textViewInformationAboutDevice.setVisibility(View.INVISIBLE);
                            }
                        });
                        buttonStartLoadTMS2812.post(new Runnable() {
                            @Override
                            public void run() {
                                buttonStartLoadTMS2812.setVisibility(View.INVISIBLE);
                            }
                        });
                        progressBarLoadToFlesh.post(new Runnable() {
                            @Override
                            public void run() {
                                progressBarLoadToFlesh.setVisibility(View.INVISIBLE);
                            }
                        });
                        textViewStatusLoadToFlesh.post(new Runnable() {
                            @Override
                            public void run() {
                                textViewStatusLoadToFlesh.setVisibility(View.INVISIBLE);
                            }
                        });
                    }
                } catch (InterruptedException e) {
                    break;
                }
            }
        }

        public UpDateGraphicalDisplay() {
        }
    }
}
