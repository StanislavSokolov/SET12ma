package com.example.set12ma.ui.main;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.drawable.Drawable;
import android.os.*;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import com.example.set12ma.R;

import java.io.*;
import java.util.ArrayList;
import java.util.Set;

import static android.content.Context.MODE_PRIVATE;

public class FragmentBluetooth extends Fragment {

    // for BluetoothSoketThread
    final String PBAP_UUID = "00001101-0000-1000-8000-00805f9b34fb";
    private BluetoothSocket bluetoothSocket;
    private BluetoothDevice bluetoothDevice;

    private BluetoothSoketThread bluetoothSoketThread;
    private BluetoothConnectedInputThread bluetoothConnectedInputThread;
    private BluetoothConnectedOutputThread bluetoothConnectedOutputThread;

    private LogsToFile logsToFile;

    private final int ADDRESS_DEVICE = 10;
    private final int READ = 56;
    private final int WRITE = 57;
    private final int INIT_LOAD = 58;
    private final int LOAD = 51;
    private final int EXTEND = 60;
    private final int UPLOAD = 52;
    private final int BYTE_UPLOAD = 2048;
    private final int ADDRESS_UPLOAD = 655360; // 000A0000
    private final int COUNT = 170;


    private volatile int currentCommand = INIT_LOAD;

    private boolean statusError = true;


    // for BluetoothConnectedThread
    byte[] bytesToSend = null;
    byte[] bytesToCreateCRC = null;
    private int previousByte = 0;
    private int currentByte = 0;
    private int nextByte = 0;
    private int maxValueUnsuccessfulSending = 10;

    // for
    private static final String ARG_SECTION_NUMBER = "BT";
    private static final String LOG_TAG = "AndroidExample";
    private String stringConnectedToDevice;
    private SpaceAddress spaceAddress;
    private ResultReceiverAddressSpace resultReceiverAddressSpace;

    private SpaceMemory spaceMemory;
    private ResultReceiverMemorySpace resultReceiverMemorySpace;

    private SpaceStatus spaceStatus;
    private ResultReceiverStatusSpace resultReceiverStatusSpace;

    private SpaceFileLogs spaceFileLogs;
    private ResultReceiverFileLogsSpace resultReceiverFileLogsSpace;

    private SpaceSetting spaceSetting;
    private ResultReceiverSettingSpace resultReceiverSettingSpace;

    private ArrayList<BluetoothDevice> arrayListAvailableDevices;                               // список устройств, доступных к сопряжению
    private ArrayList<BluetoothDevice> arrayListConnectedDevices;                               // список устройств, доступных к сопряжению
    private int itemSelectedFromConnectedDevices = 0;
    private BluetoothAdapter bluetooth;
    private ArrayAdapter<String> adapterConnectedDevices;
    private String firstStringAdapterConnectedDevices = "Выберите устройство";
    private ArrayAdapter<String> adapterAvailableDevices;
    private String firstStringAdapterAvailableDevices = "Выберите устройство";

    private PageViewModel pageViewModel;
    private TextView textViewConnectedDevices;
    private Spinner spinnerConnectedDevices;
    private Button buttonConnectToDevice;
    private TextView textViewConnectedToDevice;
    private ProgressBar progressBarConnectedToDevice;
    private TextView textViewAvailableDevices;
    private Spinner spinnerAvailableDevices;
    private Button buttonFindNewDevices;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        resultReceiverAddressSpace = (ResultReceiverAddressSpace) context;
        resultReceiverMemorySpace = (ResultReceiverMemorySpace) context;
        resultReceiverStatusSpace = (ResultReceiverStatusSpace) context;
        resultReceiverFileLogsSpace = (ResultReceiverFileLogsSpace) context;
        resultReceiverSettingSpace = (ResultReceiverSettingSpace) context;
    }


    final BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @RequiresApi(api = Build.VERSION_CODES.KITKAT)
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();

            if (BluetoothAdapter.ACTION_DISCOVERY_STARTED.equals(action)) {
                Log.d(LOG_TAG, "starting");
            }

            // При обнаружении устройства проверяется наличие дубликата в имеющемся адаптере и добавление нового устройства в адаптер
            if (BluetoothDevice.ACTION_FOUND.equals(action)) {
                boolean checkingDuplicates = false;
                BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
                for (int i = 0; i < adapterAvailableDevices.getCount(); i++) {
                    if (String.valueOf(device.getName()).equals("null")) {
                        if (device.getAddress().equals(adapterAvailableDevices.getItem(i))) {
                            Log.i(LOG_TAG, String.valueOf(adapterAvailableDevices.getItem(i)));
                            checkingDuplicates = true;
                        }
                    } else {
                        if (device.getName().equals(adapterAvailableDevices.getItem(i))) {
                            Log.i(LOG_TAG, String.valueOf(adapterAvailableDevices.getItem(i)));
                            checkingDuplicates = true;
                        }
                    }

                }
                if (!checkingDuplicates) {
                    if (String.valueOf(device.getName()).equals("null")) {
                        adapterAvailableDevices.add(device.getAddress());
                    } else {
                        adapterAvailableDevices.add(String.valueOf(device.getName()));
                    }
                    arrayListAvailableDevices.add(device);
                }

            }

            if (BluetoothDevice.ACTION_BOND_STATE_CHANGED.equals(action)) {
                showConnectedDevices();
                showAvailableDevices();
            }

            if (BluetoothAdapter.ACTION_DISCOVERY_FINISHED.equals(action)) {
                Log.d(LOG_TAG, "finishing");
            }

        }
    };


    public static FragmentBluetooth newInstance(int index) {
        FragmentBluetooth fragment = new FragmentBluetooth();
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

        IntentFilter filterFound = new IntentFilter(BluetoothDevice.ACTION_FOUND);
        getContext().registerReceiver(broadcastReceiver, filterFound);

        IntentFilter filterConnected = new IntentFilter(BluetoothDevice.ACTION_BOND_STATE_CHANGED);
        getContext().registerReceiver(broadcastReceiver, filterConnected);

        IntentFilter filterStart = new IntentFilter(BluetoothAdapter.ACTION_DISCOVERY_STARTED);
        getContext().registerReceiver(broadcastReceiver, filterStart);

        IntentFilter filterFinish = new IntentFilter(BluetoothAdapter.ACTION_DISCOVERY_FINISHED);
        getContext().registerReceiver(broadcastReceiver, filterFinish);



    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, final ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_bluetooth, container, false);
        bluetooth = BluetoothAdapter.getDefaultAdapter();

        spaceAddress = resultReceiverAddressSpace.getSpaceAddress();
        spaceMemory = resultReceiverMemorySpace.getSpaceMemory();
        spaceStatus = resultReceiverStatusSpace.getSpaceStatus();
        spaceFileLogs = resultReceiverFileLogsSpace.getSpaceFileLogs();
        spaceSetting = resultReceiverSettingSpace.getSpaceSetting();

        textViewConnectedDevices = root.findViewById(R.id.textView_tip_find_file);
        spinnerConnectedDevices = root.findViewById(R.id.spinner_connected_devices);
        buttonConnectToDevice = root.findViewById(R.id.button_connect_to_device);
        textViewConnectedToDevice = root.findViewById(R.id.textView_path_to_load_file_for_sp6);
        progressBarConnectedToDevice = root.findViewById(R.id.progressBar_loading_to_flesh);
        textViewAvailableDevices = root.findViewById(R.id.textView_available_devices);
        spinnerAvailableDevices = root.findViewById(R.id.spinner_available_devices);
        buttonFindNewDevices = root.findViewById(R.id.button_find_new_devices);

        checkEnableBluetooth();
        showConnectedDevices();
        showAvailableDevices();


        buttonConnectToDevice.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR2)
            @Override
            public void onClick(View v) {         if (bluetooth.isEnabled()) { setConnecting();
            } else
                Toast.makeText(getActivity(), "Необходимо включить Bluetooth", Toast.LENGTH_SHORT).show();
            }
        });

        buttonFindNewDevices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findNewDevices(container);
            }
        });

        return root;
    }


    private void setConnecting() {
        if (!adapterConnectedDevices.getItem(itemSelectedFromConnectedDevices + 1).equals("Выберите устройство")) {

            spaceStatus.setReadyFlagToExchangeData(false);
            spaceStatus.setReadyFlagToLoadSoftware(false);
            spaceStatus.setReadyFlagToUpdateSoftware(false);
            spaceStatus.setReadyFlagToFinishOfLoadingSoftware(false);
            spaceStatus.setReadyFlagToFinishOfUpdatingSoftware(false);
            spaceStatus.setStatusProcessOfLoadingSoftware(false);
            spaceStatus.setStatusProcessOfUpdatingSoftware(false);

            setCommand(INIT_LOAD);
            statusError = true;

            if (buttonConnectToDevice.getText().equals("Подключить")) {
                stringConnectedToDevice = arrayListConnectedDevices.get(itemSelectedFromConnectedDevices).getName();
                bluetoothDevice = arrayListConnectedDevices.get(itemSelectedFromConnectedDevices);
                progressBarConnectedToDevice.setVisibility(View.VISIBLE);
                buttonConnectToDevice.setText("Отключить");
                textViewConnectedToDevice.setText("Подключение к " + stringConnectedToDevice);
                textViewConnectedToDevice.setVisibility(View.VISIBLE);
                currentByte = 0;
                bluetoothSoketThread = new BluetoothSoketThread();
                bluetoothSoketThread.start();
            } else {
                buttonConnectToDevice.setText("Подключить");
                textViewConnectedToDevice.setText("Отключено от " + stringConnectedToDevice);
                progressBarConnectedToDevice.setVisibility(View.INVISIBLE);
                spaceStatus.setReadyFlagToExchangeData(false);
                spaceStatus.setDevice("");
                getActivity().findViewById(R.id.menu_indicator).setVisibility(View.VISIBLE);
                spaceStatus.setReadyFlagRecordingInitialValues(false);
                bluetoothSoketThread.cancel();
            }
        } else {
            if (buttonConnectToDevice.getText().equals("Подключить")) {
                Toast.makeText(getActivity(), "Для подключения необходимо выбрать сопряженное устройство", Toast.LENGTH_SHORT).show();
            } else {
                buttonConnectToDevice.setText("Подключить");
                textViewConnectedToDevice.setText("Отключено от " + stringConnectedToDevice);
                progressBarConnectedToDevice.setVisibility(View.INVISIBLE);
                spaceStatus.setReadyFlagToExchangeData(false);
                spaceStatus.setDevice("");
                getActivity().findViewById(R.id.menu_indicator).setVisibility(View.VISIBLE);
                bluetoothSoketThread.cancel();
            }

        }
    }

    private void checkEnableBluetooth(){
        if (!bluetooth.isEnabled()) {
            Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(enableBtIntent, 12);
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 12) {
            showConnectedDevices();
            showAvailableDevices();
        }
    }

    private void showConnectedDevices(){

        arrayListConnectedDevices = new ArrayList<>();
        adapterConnectedDevices = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item);
        adapterConnectedDevices.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Set<BluetoothDevice> pairedDevices = bluetooth.getBondedDevices();

        if(pairedDevices.size()>0){
            textViewConnectedDevices.setText("Сопряженные устройства");
            adapterConnectedDevices.add(firstStringAdapterConnectedDevices);
            for(BluetoothDevice device: pairedDevices){
                adapterConnectedDevices.add(device.getName());
                arrayListConnectedDevices.add(device);
            }
            spinnerConnectedDevices.setAdapter(adapterConnectedDevices);

            AdapterView.OnItemSelectedListener itemSelectedListener = new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                    if (spinnerConnectedDevices.getSelectedItemId() != 0) {
                    itemSelectedFromConnectedDevices = spinnerConnectedDevices.getSelectedItemPosition() - 1;
                    Log.i(LOG_TAG, String.valueOf(spinnerConnectedDevices.getSelectedItemPosition()));
//                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                }
            };
            spinnerConnectedDevices.setOnItemSelectedListener(itemSelectedListener);
            spinnerConnectedDevices.setVisibility(View.VISIBLE);
        } else {
            textViewConnectedDevices.setText("Нет сопряженных устройств");
            spinnerConnectedDevices.setVisibility(View.INVISIBLE);
        }
    }

    private void showAvailableDevices(){
        arrayListAvailableDevices = new ArrayList<>();
        adapterAvailableDevices = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item);
        adapterAvailableDevices.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterAvailableDevices.add(firstStringAdapterAvailableDevices);
        spinnerAvailableDevices.setAdapter(adapterAvailableDevices);

        AdapterView.OnItemSelectedListener itemSelectedListener = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (spinnerAvailableDevices.getSelectedItemId() != 0) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                        if (!arrayListAvailableDevices.get(spinnerAvailableDevices.getSelectedItemPosition()-1).createBond()) Log.i(LOG_TAG, "Не удается выполнить сопряжение");
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        };
        spinnerAvailableDevices.setOnItemSelectedListener(itemSelectedListener);
        spinnerAvailableDevices.setVisibility(View.VISIBLE);
    }

    private void findNewDevices(ViewGroup container) {
        if (bluetooth.isDiscovering()) {
            Toast.makeText(container.getContext(), "Идёт сканирование", Toast.LENGTH_LONG).show();
        } else {
            if (bluetooth.startDiscovery()) {
                Toast.makeText(container.getContext(), "Поиск", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(container.getContext(), "Нет доступных устройств", Toast.LENGTH_LONG).show();
            }
        }
    }

    public class BluetoothSoketThread extends Thread {

        public BluetoothSoketThread() {
            try {
                bluetoothSocket = bluetoothDevice.createRfcommSocketToServiceRecord(ParcelUuid.fromString(PBAP_UUID).getUuid());
            } catch (IOException e) {
                Log.i(LOG_TAG, e.toString());
            }
            Log.i(LOG_TAG, String.valueOf(bluetoothSocket.getRemoteDevice()));
        }

        @Override
        public void run() {
            bluetoothConnectedInputThread = new BluetoothConnectedInputThread();
            bluetoothConnectedOutputThread = new BluetoothConnectedOutputThread();
            boolean connect = false;
            try {
                bluetoothSocket.connect();
                connect = true;
            } catch (IOException e) {
                textViewConnectedToDevice.post(new Runnable() {
                    @Override
                    public void run() {
                        textViewConnectedToDevice.setText("Не удалось подключиться к устройству. Проверьте питание " + spinnerConnectedDevices.getSelectedItem());
                        Toast.makeText(getContext(), "Не удалось подключиться к устройству. Проверьте питание " + spinnerConnectedDevices.getSelectedItem(), Toast.LENGTH_LONG).show();
                        progressBarConnectedToDevice.setVisibility(View.INVISIBLE);
                        buttonConnectToDevice.setText("Подключить");
                    }
                });
                cancel();
            }
            // If a connection was accepted
            if (connect) {
                spaceStatus.setReadyFlagRecordingInitialValues(true);
                // Do work to manage the connection (in a separate thread)
                try {
                    manageConnectedSocket();
                } catch (InterruptedException | IOException e) {
                    e.printStackTrace();
                }
            }
        }

        public void cancel() {
            try {
                interrupt();
                bluetoothSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private void manageConnectedSocket() throws InterruptedException, IOException {
            bluetoothConnectedInputThread.start();
            while (!bluetoothConnectedInputThread.isAlive()) {
                BluetoothSoketThread.sleep(1);
            }

            bluetoothConnectedOutputThread.start();
            while (!bluetoothConnectedOutputThread.isAlive()) {
                BluetoothSoketThread.sleep(1);
            }

            int countByte = 0;
            byte[] bufferByte = null;

            int crc;
            int high;

            String answerTest;
            int countWaitConnection = 0;

            int countReceivedMessage = 0;

            boolean latchInit = true;
            boolean latchQueue = false;
            boolean latchLoad = false;
            boolean latchFinish = false;
            boolean latchDownloadLog = false;

            int counterAttemptsToConection = 0;
            int counterUnsuccessfulSending = 0;


            boolean statusAnswer = false; // true - ответ получен

            while (!isInterrupted()) {
                if (!spaceAddress.isEmptyByteQueue()) {
                    byte[] buffer = spaceAddress.getByteQueue();
                    switch (getCommand()) {
                        case READ:

                            Log.i(LOG_TAG, "count byte " + buffer.length);

                            if (countByte == 0) {
                                // здесь нужно проверять не countByte, а было ли в буфере начало нового сообщения
                                bufferByte = new byte[10];
                                Log.i(LOG_TAG, "Начало сообщения");
                            }

                            if (buffer.length > 10 - countByte) {
                                // получили избыточное количество байт в посылке
                                // остаток положим во временный буфер
                                Log.i(LOG_TAG, "Избыточное количество байт");
                            } else {
                                // получили байты
                                for (int i = 0; i < buffer.length; i++) {
                                    bufferByte[i + countByte] = buffer[i];
                                }
                                countByte = countByte + buffer.length;
                                Log.i(LOG_TAG, "Текущее количестов принятых байт " + countByte);
                            }

                            if (countByte == 10) {
                                Log.i(LOG_TAG, "Получили нужное количество байт");
                                answerTest = "";
                                for (byte readByte : bufferByte) {
                                    int bufInt;
                                    if (readByte < 0) bufInt = readByte + 256;
                                    else bufInt = readByte;
                                    answerTest = answerTest + " " + bufInt;
                                }
                                Log.i(LOG_TAG, answerTest);
                                countByte = 0;
                                if ((bufferByte[0] == ADDRESS_DEVICE) & (bufferByte[1] == READ)) {
                                    Log.i(LOG_TAG, "Идентификатор корректен");
                                    // проверяем корректность сообщения по идентификатору
                                    byte[] bytesToCreateCRC = new byte[bufferByte.length - 2];
                                    for (int i = 0; i < bytesToCreateCRC.length; i++) {
                                        bytesToCreateCRC[i] = bufferByte[i];
                                    }
                                    crc = (CRC16.getCRC4(bytesToCreateCRC));
                                    high = crc / 256;
//                                    answerTest = "";
//                                    for (byte readByte: buffer) {
//                                        int bufInt = 0;
//                                        if (readByte < 0) bufInt = readByte + 256; else bufInt = readByte;
//                                        answerTest = answerTest + " " + bufInt;
//                                    }
//                                    Log.i(LOG_TAG, answerTest);
                                    if ((bufferByte[bytesToCreateCRC.length] == (byte) (crc - high * 256)) & (bufferByte[bytesToCreateCRC.length + 1] == (byte) high)) {
                                        Log.i(LOG_TAG, "ЦРЦ в порядке");
                                        if (!spaceStatus.isReadyFlagRecordingInitialValues()) {
                                            spaceAddress.setAddressSpace(currentByte, bufferByte[2]);
                                            if (currentByte == 47) {
                                                nextByte = 96;
                                            }

                                            if (currentByte == 143) {
                                                nextByte = 0;
                                            }

                                            if ((currentByte == 47) || (currentByte == 143))
                                                currentByte = nextByte;
                                            else currentByte++;
                                        } else {
                                            currentByte = 48;
                                        }
                                        statusError = false;
                                    } else {
                                        Log.i(LOG_TAG, "CRC не совпало");
                                        statusError = true;
                                    }
                                } else {
                                    Log.i(LOG_TAG, "Не смогли идентифицировать сообщение");
                                    statusError = true;
                                }
                                statusAnswer = true;
                            }
                            break;
                        case WRITE:

                            Log.i(LOG_TAG, "count byte " + buffer.length + " for Write");

                            if (countByte == 0) {
                                // здесь нужно проверять не countByte, а было ли в буфере начало нового сообщения
                                bufferByte = new byte[6];
                                Log.i(LOG_TAG, "Начало сообщения");
                            }

                            if (buffer.length > 6 - countByte) {
                                // получили избыточное количество байт в посылке
                                // остаток положим во временный буфер
                                Log.i(LOG_TAG, "Избыточное количество байт");
                            } else {
                                // получили байты
                                for (int i = 0; i < buffer.length; i++) {
                                    bufferByte[i + countByte] = buffer[i];
                                }
                                countByte = countByte + buffer.length;
                                Log.i(LOG_TAG, "Текущее количестов принятых байт " + countByte);
                            }

                            if (countByte == 6) {
                                Log.i(LOG_TAG, "Получили нужное количество байт");
                                answerTest = "";
                                for (byte readByte : bufferByte) {
                                    int bufInt;
                                    if (readByte < 0) bufInt = readByte + 256;
                                    else bufInt = readByte;
                                    answerTest = answerTest + " " + bufInt;
                                }
                                Log.i(LOG_TAG, answerTest);
                                countByte = 0;
                                if ((bufferByte[0] == ADDRESS_DEVICE) & (bufferByte[1] == WRITE)) {
                                    Log.i(LOG_TAG, "Идентификатор корректен");
                                    // проверяем корректность сообщения по идентификатору
                                    byte[] bytesToCreateCRC = new byte[bufferByte.length - 4];
                                    for (int i = 0; i < bytesToCreateCRC.length; i++) {
                                        bytesToCreateCRC[i] = bufferByte[i];
                                    }
                                    crc = (CRC16.getCRC4(bytesToCreateCRC));
                                    high = crc / 256;
                                    if ((bufferByte[bytesToCreateCRC.length] == (byte) (crc - high * 256)) & (bufferByte[bytesToCreateCRC.length + 1] == (byte) high)) {
                                        Log.i(LOG_TAG, "ЦРЦ в порядке");
                                        if (currentByte == 207) {
                                            spaceStatus.setReadyFlagRecordingInitialValues(false);
                                            nextByte = 0;
                                        }
                                        if (currentByte == 95) {
                                            nextByte = 144;
                                        }
                                        if ((currentByte == 95) || (currentByte == 207)) currentByte = nextByte;
                                        else currentByte++;
                                        statusError = false;
                                    } else {
                                        Log.i(LOG_TAG, "CRC не совпало");
                                        statusError = true;
                                    }
                                } else {
                                    Log.i(LOG_TAG, "Не смогли идентифицировать сообщение");
                                    statusError = true;
                                }
                                statusAnswer = true;
                            }

                            break;
                        case INIT_LOAD:

                            Log.i(LOG_TAG, "count byte " + buffer.length + " INIT_LOAD");

                            if (countByte == 0) {
                                // здесь нужно проверять не countByte, а было ли в буфере начало нового сообщения
                                bufferByte = new byte[6];
                                Log.i(LOG_TAG, "Начало сообщения");
                            }

                            if (buffer.length > 6 - countByte) {
                                // получили избыточное количество байт в посылке
                                // остаток положим во временный буфер
                                Log.i(LOG_TAG, "Избыточное количество байт");
                            } else {
                                // получили байты
                                for (int i = 0; i < buffer.length; i++) {
                                    bufferByte[i + countByte] = buffer[i];
                                }
                                countByte = countByte + buffer.length;
                                Log.i(LOG_TAG, "Текущее количестов принятых байт " + countByte);
                            }

                            if (countByte == 6) {
                                Log.i(LOG_TAG, "Получили нужное количество байт");
                                answerTest = "";
                                for (byte readByte : bufferByte) {
                                    int bufInt;
                                    if (readByte < 0) bufInt = readByte + 256;
                                    else bufInt = readByte;
                                    answerTest = answerTest + " " + bufInt;
                                }
                                Log.i(LOG_TAG, answerTest);
                                countByte = 0;
                                if ((bufferByte[0] == ADDRESS_DEVICE) & (bufferByte[1] == INIT_LOAD)) {
                                    Log.i(LOG_TAG, "Идентификатор корректен");
                                    // проверяем корректность сообщения по идентификатору
                                    byte[] bytesToCreateCRC = new byte[bufferByte.length - 4];
                                    for (int i = 0; i < bytesToCreateCRC.length; i++) {
                                        bytesToCreateCRC[i] = bufferByte[i];
                                    }
                                    crc = (CRC16.getCRC4(bytesToCreateCRC));
                                    high = crc / 256;
                                    if ((bufferByte[bytesToCreateCRC.length] == (byte) (crc - high * 256)) & (bufferByte[bytesToCreateCRC.length + 1] == (byte) high)) {
                                        Log.i(LOG_TAG, "ЦРЦ в порядке");
                                        statusError = false;
                                    } else {
                                        Log.i(LOG_TAG, "CRC не совпало");
                                        statusError = true;
                                    }
                                } else {
                                    Log.i(LOG_TAG, "Не смогли идентифицировать сообщение");
                                    statusError = true;
                                }
                                statusAnswer = true;
                            }

                            break;
                        case LOAD:

                            Log.i(LOG_TAG, "count byte " + buffer.length + " LOAD");

                            if (countByte == 0) {
                                // здесь нужно проверять не countByte, а было ли в буфере начало нового сообщения
                                bufferByte = new byte[6];
                                Log.i(LOG_TAG, "Начало сообщения");
                            }

                            if (buffer.length > 6 - countByte) {
                                // получили избыточное количество байт в посылке
                                // остаток положим во временный буфер
                                Log.i(LOG_TAG, "Избыточное количество байт");
                            } else {
                                // получили байты
                                for (int i = 0; i < buffer.length; i++) {
                                    bufferByte[i + countByte] = buffer[i];
                                }
                                countByte = countByte + buffer.length;
                                Log.i(LOG_TAG, "Текущее количестов принятых байт " + countByte);
                            }

                            if (countByte == 6) {
                                Log.i(LOG_TAG, "Получили нужное количество байт");
                                answerTest = "";
                                for (byte readByte : bufferByte) {
                                    int bufInt;
                                    if (readByte < 0) bufInt = readByte + 256;
                                    else bufInt = readByte;
                                    answerTest = answerTest + " " + bufInt;
                                }
                                Log.i(LOG_TAG, answerTest);
                                countByte = 0;
                                if ((bufferByte[0] == ADDRESS_DEVICE) & (bufferByte[1] == LOAD)) {
                                    Log.i(LOG_TAG, "Идентификатор корректен");
                                    // проверяем корректность сообщения по идентификатору
                                    byte[] bytesToCreateCRC = new byte[bufferByte.length - 4];
                                    for (int i = 0; i < bytesToCreateCRC.length; i++) {
                                        bytesToCreateCRC[i] = bufferByte[i];
                                    }
                                    crc = (CRC16.getCRC4(bytesToCreateCRC));
                                    high = crc / 256;
                                    if ((bufferByte[bytesToCreateCRC.length] == (byte) (crc - high * 256)) & (bufferByte[bytesToCreateCRC.length + 1] == (byte) high)) {
                                        Log.i(LOG_TAG, "ЦРЦ в порядке");
                                        spaceStatus.setReadyFlagToFinishOfLoadingSoftware(true);
                                        statusError = false;
                                    } else {
                                        Log.i(LOG_TAG, "CRC не совпало");
                                        statusError = true;
                                    }
                                } else {
                                    Log.i(LOG_TAG, "Не смогли идентифицировать сообщение");
                                    statusError = true;
                                }
                                statusAnswer = true;
                            }

                            break;
                        case EXTEND:

                            Log.i(LOG_TAG, "count byte " + buffer.length + " EXTEND");

                            if (countByte == 0) {
                                // здесь нужно проверять не countByte, а было ли в буфере начало нового сообщения
                                bufferByte = new byte[18];
                                Log.i(LOG_TAG, "Начало сообщения");
                            }

                            if (buffer.length > 18 - countByte) {
                                // получили избыточное количество байт в посылке
                                // остаток положим во временный буфер
                                Log.i(LOG_TAG, "Избыточное количество байт");
                            } else {
                                // получили байты
                                for (int i = 0; i < buffer.length; i++) {
                                    bufferByte[i + countByte] = buffer[i];
                                }
                                countByte = countByte + buffer.length;
                                Log.i(LOG_TAG, "Текущее количестов принятых байт " + countByte);
                            }

                            if (countByte == 18) {
                                Log.i(LOG_TAG, "Получили нужное количество байт");
                                answerTest = "";
                                for (byte readByte : bufferByte) {
                                    int bufInt;
                                    if (readByte < 0) bufInt = readByte + 256;
                                    else bufInt = readByte;
                                    answerTest = answerTest + " " + bufInt;
                                }
                                Log.i(LOG_TAG, answerTest);
                                countByte = 0;
                                if ((bufferByte[0] == ADDRESS_DEVICE) & (bufferByte[1] == EXTEND)) {
                                    Log.i(LOG_TAG, "Идентификатор корректен");
                                    // проверяем корректность сообщения по идентификатору
                                    byte[] bytesToCreateCRC = new byte[bufferByte.length - 4];
                                    for (int i = 0; i < bytesToCreateCRC.length; i++) {
                                        bytesToCreateCRC[i] = bufferByte[i];
                                    }
                                    crc = (CRC16.getCRC4(bytesToCreateCRC));
                                    high = crc / 256;
                                    if ((bufferByte[14] == (byte) (crc - high*256)) & (bufferByte[15] == (byte) high)) {
                                        Log.i(LOG_TAG, "CRC is good from FinishLoad");
                                        statusError = false;
                                    } else {
                                        Log.i(LOG_TAG, "CRC is bed from FinishLoad");
                                    }
                                    spaceStatus.setLastNumberError(bufferByte[6]);
                                    spaceStatus.setReadyFlagToFinishOfUpdatingSoftware(true);
                                } else {
                                    Log.i(LOG_TAG, "Не смогли идентифицировать сообщение");
                                    statusError = true;
                                }
                                statusAnswer = true;
                            }
                            break;
                        case UPLOAD:

                            Log.i(LOG_TAG, "count byte " + buffer.length + " UPLOAD");

                            if (countByte == 0) {
                                // здесь нужно проверять не countByte, а было ли в буфере начало нового сообщения
                                bufferByte = new byte[BYTE_UPLOAD + 8];
                                Log.i(LOG_TAG, "Начало сообщения");
                            }

                            if (buffer.length > BYTE_UPLOAD + 8 - countByte) {
                                // получили избыточное количество байт в посылке
                                // остаток положим во временный буфер
                                Log.i(LOG_TAG, "Избыточное количество байт");
                            } else {
                                // получили байты
                                for (int i = 0; i < buffer.length; i++) {
                                    bufferByte[i + countByte] = buffer[i];
                                }
                                countByte = countByte + buffer.length;
                                Log.i(LOG_TAG, "Текущее количестов принятых байт " + countByte);
                            }

                            if (countByte == BYTE_UPLOAD + 8) {
                                Log.i(LOG_TAG, "Получили нужное количество байт");
                                answerTest = "";
                                for (byte readByte : bufferByte) {
                                    int bufInt;
                                    if (readByte < 0) bufInt = readByte + 256;
                                    else bufInt = readByte;
                                    answerTest = answerTest + " " + bufInt;
                                }
                                Log.i(LOG_TAG, answerTest);
                                countByte = 0;
                                if ((bufferByte[0] == ADDRESS_DEVICE) & (bufferByte[1] == UPLOAD)) {
                                    Log.i(LOG_TAG, "Идентификатор корректен");
                                    // проверяем корректность сообщения по идентификатору
                                    byte[] bytesToCreateCRC = new byte[bufferByte.length - 6];
                                    for (int i = 0; i < bytesToCreateCRC.length; i++) {
                                        bytesToCreateCRC[i] = bufferByte[i];
                                    }
                                    crc = (CRC16.getCRC4(bytesToCreateCRC));
                                    high = crc / 256;
                                    if ((bufferByte[bytesToCreateCRC.length] == (byte) (crc - high*256)) & (bufferByte[bytesToCreateCRC.length + 1] == (byte) high)) {
                                        Log.i(LOG_TAG, "CRC is good from UPLOAD");
                                        spaceStatus.setReadyFlagToFinishOfDownloadingLogs(true);
                                        statusError = false;
                                        byte[] bytes = new byte[BYTE_UPLOAD];
                                        for (int i = 0; i < BYTE_UPLOAD; i++) {
                                            bytes[i] = bufferByte[i+2];
                                        }
                                        spaceFileLogs.setSpaceFileLogsArrayListByte(bytes);
                                    } else {
                                        Log.i(LOG_TAG, "CRC is bed from UPLOAD");
                                    }
                                } else {
                                    Log.i(LOG_TAG, "Не смогли идентифицировать сообщение");
//                                    statusError = true;
                                }
                                statusAnswer = true;
                            }


                            break;
                    }
                } else {
                    if (statusAnswer) {
                        if (latchInit) {
                            spaceStatus.setReadyFlagToExchangeData(true);
                            textViewConnectedToDevice.post(new Runnable() {
                                @Override
                                public void run() {
                                    textViewConnectedToDevice.setText("Подключено к " + stringConnectedToDevice);
                                    progressBarConnectedToDevice.setVisibility(View.INVISIBLE);
                                    Toast.makeText(getContext(), "Устройство подключено к процессорному модулю", Toast.LENGTH_LONG).show();
                                }
                            });
                        }
                        latchInit = false;
                        statusAnswer = false;

                        if (spaceStatus.isReadyFlagToLoadSoftware()) {
                            if (spaceStatus.isStatusProcessOfLoadingSoftware()) {
                                if (!latchLoad) {
                                    setCommand(LOAD);
                                    bluetoothConnectedOutputThread.load();
                                    latchLoad = true;
                                } else {
                                    if (spaceStatus.isReadyFlagToFinishOfLoadingSoftware()) {
                                        spaceStatus.setReadyFlagToLoadSoftware(false);
                                        spaceStatus.setStatusProcessOfLoadingSoftware(false);
                                        latchLoad = false;
                                        statusAnswer = true;
                                    }

                                }
                            } else {
                                spaceStatus.setStatusProcessOfLoadingSoftware(true);
                                setCommand(INIT_LOAD);
                                bluetoothConnectedOutputThread.initLoad();
                            }
                        } else if (spaceStatus.isReadyFlagToUpdateSoftware()) {
                            spaceStatus.setReadyFlagToFinishOfLoadingSoftware(false);
                            if (!latchFinish) {
                                spaceStatus.setStatusProcessOfUpdatingSoftware(true);
                                setCommand(EXTEND);
                                bluetoothConnectedOutputThread.startToLoad();
                                latchFinish = true;
                                Log.i(LOG_TAG, "зАЙДЕМ сюда!");
                            } else {
                                if (spaceStatus.isReadyFlagToFinishOfUpdatingSoftware()) {
                                    latchFinish = false;
                                    spaceStatus.setReadyFlagToUpdateSoftware(false);
                                    spaceStatus.setStatusProcessOfUpdatingSoftware(false);
                                    spaceStatus.setReadyFlagToLoadSoftware(false);
                                    spaceStatus.setReadyFlagToFinishOfLoadingSoftware(false);
                                    Log.i(LOG_TAG, "всё в ноль!!!!");
                                    statusAnswer = true;
                                }
                            }
                        } else if (spaceStatus.isReadyFlagToDownloadLog()) {
                            if (!latchDownloadLog) {
                                if (countReceivedMessage == 0) {
                                    spaceFileLogs.setSpaceFileLogsByte();
                                }
                                setCommand(UPLOAD);
                                bluetoothConnectedOutputThread.downloadLogs(ADDRESS_UPLOAD + BYTE_UPLOAD*countReceivedMessage, BYTE_UPLOAD);
                                latchDownloadLog = true;
                                Log.i(LOG_TAG, "We  are here!");
                            } else {
                                if (spaceStatus.isReadyFlagToFinishOfDownloadingLogs()) {
                                    // ЦИКЛ ДЛЯ СЧИТЫВАНИЯ ЛОГОВ
                                    spaceStatus.setReadyFlagToFinishOfDownloadingLogs(false);
                                    latchDownloadLog = false;
                                    Log.i(LOG_TAG, "Finish of downloadlog");
                                    statusAnswer = true;
                                    if (countReceivedMessage < COUNT) {
                                        countReceivedMessage = countReceivedMessage + 1;
                                        spaceStatus.setProgressBarDownload(countReceivedMessage);
                                    } else {
                                        spaceStatus.setReadyFlagToDownloadLog(false);
                                        Log.i("strartt", "finish");
                                        countReceivedMessage = 0;
                                        Log.i("strartt", "Длинна записанная в SpaceFileLogs " + spaceFileLogs.getSpaceFileLogsArrayListSize());

                                        logsToFile = new LogsToFile();
                                        logsToFile.start();
                                    }
                                }
                            }
                        } else {
                            if (counterUnsuccessfulSending < maxValueUnsuccessfulSending) {
                                if (statusError) {
                                    counterUnsuccessfulSending = counterUnsuccessfulSending + 1;
                                } else {
                                    counterUnsuccessfulSending = 0;
                                }

                                if (spaceStatus.isReadyFlagRecordingInitialValues()) {
                                    setCommand(WRITE);
                                    bluetoothConnectedOutputThread.write();
                                } else {
                                    if (!spaceAddress.isEmptyQueue()) {
                                        if (!latchQueue) {
                                            previousByte = currentByte;
                                            latchQueue = true;
                                        }
                                        ElementQueue elementQueue = spaceAddress.getElementQueue();
//                                        if (elementQueue.getSectionNumber() == 0) {
//                                            currentByte = 48;
//                                        }
//                                        if (elementQueue.getSectionNumber() == 1) {
//                                            currentByte = 144;
//                                        }
//                                        currentByte = currentByte + elementQueue.getId();
                                        currentByte = elementQueue.getRegister();
                                        Log.i(LOG_TAG, "SUPRIM");
                                        setCommand(WRITE);
                                        bluetoothConnectedOutputThread.write(elementQueue.getRegister(), elementQueue.getData());
                                    } else {
                                        if (latchQueue) {
                                            latchQueue = false;
                                            currentByte = previousByte;
                                        }
                                        setCommand(READ);
                                        bluetoothConnectedOutputThread.read();
                                    }
                                }
                            } else {
                                textViewConnectedToDevice.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        buttonConnectToDevice.setText("Подключить");
                                        textViewConnectedToDevice.setText("Процессорный модуль не отвечает. Проверьте соединение.");
                                        progressBarConnectedToDevice.setVisibility(View.INVISIBLE);
                                        spaceStatus.setReadyFlagToExchangeData(false);
                                        spaceStatus.setDevice("");
                                        getActivity().findViewById(R.id.menu_indicator).setVisibility(View.VISIBLE);
                                        spaceStatus.setReadyFlagRecordingInitialValues(false);
                                        bluetoothSoketThread.cancel();
                                        Toast.makeText(getContext(), "Процессорный модуль не отвечает. Проверьте соединение.", Toast.LENGTH_LONG).show();
                                    }
                                });
                            }
                        }
                        countWaitConnection = 0;
                        counterAttemptsToConection = 0;
                    } else {
                        if (latchInit) {
                            setCommand(READ);
                            if (counterAttemptsToConection < 10) {
                                if (countWaitConnection < 500000) {
                                    countWaitConnection = countWaitConnection + 1;
                                } else {
                                    countWaitConnection = 0;
                                    counterAttemptsToConection = counterAttemptsToConection + 1;
                                    bluetoothConnectedOutputThread.read();
                                }
                            } else {
                                textViewConnectedToDevice.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        buttonConnectToDevice.setText("Подключить");
                                        textViewConnectedToDevice.setText("Не удается связаться с процессорным модулем. Проверьте соединение.");
                                        progressBarConnectedToDevice.setVisibility(View.INVISIBLE);
                                        spaceStatus.setReadyFlagToExchangeData(false);
                                        spaceStatus.setDevice("");
                                        getActivity().findViewById(R.id.menu_indicator).setVisibility(View.VISIBLE);
                                        spaceStatus.setReadyFlagRecordingInitialValues(false);
                                        bluetoothSoketThread.cancel();
                                        Toast.makeText(getContext(), "Не удается связаться с процессорным модулем. Проверьте соединение.", Toast.LENGTH_LONG).show();
                                    }
                                });
                                latchInit = false;
                                interrupt();
                            }
                        } if (spaceStatus.isReadyFlagToExchangeData()) {
                            if (getCommand() == READ) {
                                if (counterAttemptsToConection < 5) {
                                    if (countWaitConnection < 500000) {
                                        countWaitConnection = countWaitConnection + 1;
                                    } else {
                                        countWaitConnection = 0;
                                        counterAttemptsToConection = counterAttemptsToConection + 1;
                                    }
                                } else {
                                    textViewConnectedToDevice.post(new Runnable() {
                                        @Override
                                        public void run() {
                                            buttonConnectToDevice.setText("Подключить");
                                            textViewConnectedToDevice.setText("Не удается связаться с процессорным модулем. Проверьте соединение.");
                                            progressBarConnectedToDevice.setVisibility(View.INVISIBLE);
                                            spaceStatus.setReadyFlagToExchangeData(false);
                                            spaceStatus.setDevice("");
                                            getActivity().findViewById(R.id.menu_indicator).setVisibility(View.VISIBLE);
                                            spaceStatus.setReadyFlagRecordingInitialValues(false);
                                            bluetoothSoketThread.cancel();
                                            Toast.makeText(getContext(), "Не удается связаться с процессорным модулем. Проверьте соединение.", Toast.LENGTH_LONG).show();
                                        }
                                    });
                                    latchInit = false;
                                    interrupt();
                                }
                            }
                        }
                    }
                }
            }
            bluetoothConnectedInputThread.interrupt();
            bluetoothConnectedOutputThread.interrupt();
        }
    }

    private synchronized int getCommand() { return currentCommand; }
    private synchronized void setCommand(int currentCommand) { this.currentCommand = currentCommand; }

    private Handler handler = new Handler(Looper.getMainLooper()){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            byte[] buf;
            buf = (byte[]) msg.obj;
            byte[] buffer = new byte[msg.arg1];
            String s = "";
            for (int i = 0; i < buffer.length; i++) {
                buffer[i] = buf[i];
                s = s + " " + buf[i];
            }

            Log.i(LOG_TAG, "Принято байт в handler " + buffer.length);
            Log.i(LOG_TAG, s);

            spaceAddress.setByteQueue(buffer);


        }
    };

    public class BluetoothConnectedInputThread extends Thread {

        InputStream inputStream;

        public BluetoothConnectedInputThread() {
            // Get the input and output streams, using temp objects because
            // member streams are final
            try {
                inputStream = bluetoothSocket.getInputStream();
            } catch (IOException e) { Log.i(LOG_TAG,"don't get Streams");}
        }

        public void run() {
            byte[] buffer = new byte[32];  // buffer store for the stream
            int bytes; // bytes returned from read()
            while (!isInterrupted()) {
                try {
                    // Read from the InputStream
                    bytes = inputStream.read(buffer);
                    byte[] buf = new byte[bytes];
//                    String s = "";
                    for (int i = 0; i < buf.length; i++) {
                        buf[i] = buffer[i];
//                        s = s + " " + buf[i];
                    }
                    spaceAddress.setByteQueue(buf);
                    // Send the obtained bytes to the UI activity
//                    byte[] buf = new byte[bytes];
//                    buf = buffer;
//                    handler.obtainMessage(1, bytes, buf.length, buf)
//                            .sendToTarget();
//                    isStatusReading = true;
//                    changeStateIndicator();
//                    spaceStatus.setReadyFlagToExchangeData(true);
                } catch (IOException e) {
                    Log.i(LOG_TAG,e.toString());
                    break;
                }
            }
            try {
                Log.i(LOG_TAG, "INPUT STREAM CLOSE");
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public class BluetoothConnectedOutputThread extends Thread {

        OutputStream outputStream;

        public BluetoothConnectedOutputThread() {
            // Get the input and output streams, using temp objects because
            // member streams are final
            try {
                outputStream = bluetoothSocket.getOutputStream();
            } catch (IOException e) { Log.i(LOG_TAG,"don't get Streams");}
        }

        public void run() {

            while (!isInterrupted()) {

            }
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void write() {
            bytesToSend = new byte[12];
            bytesToCreateCRC = new byte[10];
            bytesToSend[0] = ADDRESS_DEVICE;
            bytesToSend[1] = WRITE;
            if ((currentByte > 47) & (currentByte < 96)) {
                bytesToSend[2] = (byte) spaceSetting.getOutArrayList().get(currentByte - 48).getRegister();
            } else if ((currentByte > 143) & (currentByte < 208)) {
                bytesToSend[2] = (byte) spaceSetting.getTkArrayList().get(currentByte - 144).getRegister();
            }
            bytesToSend[3] = 0;
            bytesToSend[4] = 0;
            bytesToSend[5] = 0;
            int data = spaceAddress.getAddressSpace(currentByte);
            int high = data / 256;
            bytesToSend[6] = (byte) (data - high * 256);
            bytesToSend[7] = (byte) high;
            bytesToSend[8] = 0;
            bytesToSend[9] = 0;

            for (int i = 0; i < bytesToCreateCRC.length; i++) {
                bytesToCreateCRC[i] = bytesToSend[i];
            }
            int crc = (CRC16.getCRC4(bytesToCreateCRC));
            high = crc / 256;
            bytesToSend[10] = (byte) (crc - high * 256);
            bytesToSend[11] = (byte) high;

            Log.i(LOG_TAG, "Номер регистра " + bytesToSend[2] + " WRITE");

            try {
                outputStream.write(bytesToSend);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        public void write(int register, int value) {
            bytesToSend = new byte[12];
            bytesToCreateCRC = new byte[10];
            bytesToSend[0] = ADDRESS_DEVICE;
            bytesToSend[1] = WRITE;
            bytesToSend[2] = (byte) register;
            bytesToSend[3] = 0;
            bytesToSend[4] = 0;
            bytesToSend[5] = 0;
            int high = value / 256;
            bytesToSend[6] = (byte) (value - high * 256);
            bytesToSend[7] = (byte) high;
            bytesToSend[8] = 0;
            bytesToSend[9] = 0;

            for (int i = 0; i < bytesToCreateCRC.length; i++) {
                bytesToCreateCRC[i] = bytesToSend[i];
            }
            int crc = (CRC16.getCRC4(bytesToCreateCRC));
            high = crc / 256;
            bytesToSend[10] = (byte) (crc - high * 256);
            bytesToSend[11] = (byte) high;

            Log.i(LOG_TAG, "Номер регистра " + register + " WRITE");

            try {
                outputStream.write(bytesToSend);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        public void read() {
            bytesToSend = new byte[8];
            bytesToCreateCRC = new byte[6];
            bytesToSend[0] = ADDRESS_DEVICE;
            bytesToSend[1] = READ;
            boolean b = true;
            while (b) {
                if ((currentByte > -1) & (currentByte < 48)) {
                    if (spaceSetting.getInArrayList().get(currentByte).isEnable()) {
                        bytesToSend[2] = (byte) spaceSetting.getInArrayList().get(currentByte).getRegister();
                        b = false;
                    } else {
                        if (currentByte < 47) currentByte++; else currentByte = 96;
                    }
                } else if ((currentByte > 95) & (currentByte < 144)) {
                    if (spaceSetting.getAdcArrayList().get(currentByte - 96).isEnable()) {
                        bytesToSend[2] = (byte) spaceSetting.getAdcArrayList().get(currentByte - 96).getRegister();
                        b = false;
                    } else {
                        if (currentByte < 143) currentByte++; else currentByte = 0;
                    }
                }
            }
            bytesToSend[3] = 0;
            bytesToSend[4] = 0;
            bytesToSend[5] = 0;
            for (int i = 0; i < bytesToCreateCRC.length; i++) {
                bytesToCreateCRC[i] = bytesToSend[i];
            }
            int crc = (CRC16.getCRC4(bytesToCreateCRC));
            int high = crc / 256;
            bytesToSend[6] = (byte) (crc - high * 256);
            bytesToSend[7] = (byte) high;
            Log.i(LOG_TAG, "Номер регистра " + currentByte + " READ");

            try {
                outputStream.write(bytesToSend);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        /* Call this from the main activity to shutdown the connection */
        public void cancel() {
            try {
                outputStream.close();
            } catch (IOException e) { }
        }

        public void initLoad() {
            bytesToSend = new byte[12];
            bytesToCreateCRC = new byte[bytesToSend.length - 2];
            bytesToSend[0] = ADDRESS_DEVICE;
            bytesToSend[1] = INIT_LOAD;
            byte[] bytesToSendBuf;
            bytesToSendBuf = determineDownloadMode();
            Log.i("LoGF", String.valueOf(bytesToSendBuf[0]));
            Log.i("LoGF", String.valueOf(bytesToSendBuf[1]));
            Log.i("LoGF", String.valueOf(bytesToSendBuf[2]));
            Log.i("LoGF", String.valueOf(bytesToSendBuf[3]));
            bytesToSend[2] = bytesToSendBuf[0];
            bytesToSend[3] = bytesToSendBuf[1];
            bytesToSend[4] = bytesToSendBuf[2];
            bytesToSend[5] = bytesToSendBuf[3];
            int i = (spaceMemory.getMemorySpaceArrayListSize() - 1)* spaceMemory.getMemorySpaceByteLength() + spaceMemory.getMemorySpaceByteLength(spaceMemory.getMemorySpaceArrayListSize() - 1);
            int highH = i/16777216;
            bytesToSend[9] = (byte) highH;
            int highL = (i - (highH*16777216))/65536;
            bytesToSend[8] = (byte) highL;
            int lowH = (i - (highH*16777216) - (highL*65536))/256;
            bytesToSend[7] = (byte) lowH;
            int lowL = i - (highH*16777216) - (highL*65536) - (lowH*256);
            bytesToSend[6] = (byte) lowL;
            for (int j = 0; j < bytesToCreateCRC.length; j++) {
                bytesToCreateCRC[j] = bytesToSend[j];
            }
            int crc = (CRC16.getCRC4(bytesToCreateCRC));
            int high = crc / 256;
            bytesToSend[10] = (byte) (crc - high * 256);
            bytesToSend[11] = (byte) high;

            Log.i(LOG_TAG, "START INIT LOAD");

            try {
                outputStream.write(bytesToSend);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private byte[] determineDownloadMode() {
            String deviceSelected = spaceStatus.getDevice();
            byte[] bytesToSendBuf = new byte[5];
            if (deviceSelected.equals("TMS2812")) {
                bytesToSendBuf[0] = 0;
                bytesToSendBuf[1] = 0;
                bytesToSendBuf[2] = 10;
                bytesToSendBuf[3] = 0;
                bytesToSendBuf[4] = 10;
            } else if (deviceSelected.equals("SP2main")) {
                bytesToSendBuf[0] = 0;
                bytesToSendBuf[1] = 0;
                bytesToSendBuf[2] = 10;
                bytesToSendBuf[3] = 0;
                bytesToSendBuf[4] = 1;
            } else if (deviceSelected.equals("SP2")) {
                bytesToSendBuf[0] = 0;
                bytesToSendBuf[1] = 0;
                bytesToSendBuf[2] = 10;
                bytesToSendBuf[3] = 0;
                bytesToSendBuf[4] = 6;
            } else {
                bytesToSendBuf[0] = 0;
                bytesToSendBuf[1] = 0;
                bytesToSendBuf[2] = 10;
                bytesToSendBuf[3] = 0;
                bytesToSendBuf[4] = 10;
            }
            return bytesToSendBuf;
        }

        public void load() {
            bytesToSend = new byte[2 + (spaceMemory.getMemorySpaceArrayListSize() - 1)* spaceMemory.getMemorySpaceByteLength() + spaceMemory.getMemorySpaceByteLength(spaceMemory.getMemorySpaceArrayListSize() - 1) + 2];
            bytesToCreateCRC = new byte[bytesToSend.length - 2];
            bytesToSend[0] = ADDRESS_DEVICE;
            bytesToSend[1] = LOAD;
            for (int i = 0; i < spaceMemory.getMemorySpaceArrayListSize(); i++) {
                byte[] bytesBuffer = spaceMemory.getMemorySpaceByte(i);
                for (int j = 0; j < bytesBuffer.length; j++) {
                    bytesToSend[i* spaceMemory.getMemorySpaceByteLength()+j+2] = bytesBuffer[j];
                }
            }
            for (int i = 0; i < bytesToCreateCRC.length; i++) {
                bytesToCreateCRC[i] = bytesToSend[i];
            }
            int crc = (CRC16.getCRC4(bytesToCreateCRC));
            int high = crc / 256;
            bytesToSend[bytesToSend.length-2] = (byte) (crc - high * 256);
            bytesToSend[bytesToSend.length-1] = (byte) high;
            Log.i(LOG_TAG, "Загрузка в память");

            Log.i(LOG_TAG, "LOAD");

            try {
                outputStream.write(bytesToSend);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void startToLoad() {
            Log.i(LOG_TAG, "startToLoad");
            bytesToSend = new byte[18];
            bytesToCreateCRC = new byte[16];
            bytesToSend[0] = ADDRESS_DEVICE;
            bytesToSend[1] = EXTEND;
            byte[] bytesToSendBuf;
            bytesToSendBuf = determineDownloadMode();
            Log.i("LoGF", String.valueOf(bytesToSendBuf[0]));
            Log.i("LoGF", String.valueOf(bytesToSendBuf[1]));
            Log.i("LoGF", String.valueOf(bytesToSendBuf[2]));
            Log.i("LoGF", String.valueOf(bytesToSendBuf[3]));
            Log.i("LoGF", String.valueOf(bytesToSendBuf[4]));
            bytesToSend[2] = bytesToSendBuf[0];
            bytesToSend[3] = bytesToSendBuf[1];
            bytesToSend[4] = bytesToSendBuf[2];
            bytesToSend[5] = bytesToSendBuf[3];
            bytesToSend[6] = 0;
            bytesToSend[7] = 0;
            bytesToSend[8] = 0;
            bytesToSend[9] = 0;
            int i = (spaceMemory.getMemorySpaceArrayListSize() - 1)* spaceMemory.getMemorySpaceByteLength() + spaceMemory.getMemorySpaceByteLength(spaceMemory.getMemorySpaceArrayListSize() - 1);
            int highH = i/16777216;
            bytesToSend[13] = (byte) highH;
            int highL = (i - (highH*16777216))/65536;
            bytesToSend[12] = (byte) highL;
            int lowH = (i - (highH*16777216) - (highL*65536))/256;
            bytesToSend[11] = (byte) lowH;
            int lowL = i - (highH*16777216) - (highL*65536) - (lowH*256);
            bytesToSend[10] = (byte) lowL;
            bytesToSend[14] = bytesToSendBuf[4];
            bytesToSend[15] = (byte) spaceStatus.getAddressOfDevice();
            for (int j = 0; j < bytesToCreateCRC.length; j++) {
                bytesToCreateCRC[j] = bytesToSend[j];
            }
            int crc = (CRC16.getCRC4(bytesToCreateCRC));
            int high = crc / 256;
            bytesToSend[bytesToSend.length-2] = (byte) (crc - high * 256);
            bytesToSend[bytesToSend.length-1] = (byte) high;

            try {
                outputStream.write(bytesToSend);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void downloadLogs(int address, int length) {
            bytesToSend = new byte[12];
            bytesToCreateCRC = new byte[bytesToSend.length - 2];
            int highH = address/16777216;
            int highL = (address - (highH*16777216))/65536;
            int lowH = (address - (highH*16777216) - (highL*65536))/256;
            int lowL = address - (highH*16777216) - (highL*65536) - (lowH*256);
            bytesToSend[0] = ADDRESS_DEVICE;
            bytesToSend[1] = UPLOAD;
            bytesToSend[2] = (byte) lowL;
            bytesToSend[3] = (byte) lowH;
            bytesToSend[4] = (byte) highL;
            bytesToSend[5] = (byte) highH;
            highH = length/16777216;
            highL = (length - (highH*16777216))/65536;
            lowH = (length - (highH*16777216) - (highL*65536))/256;
            lowL = length - (highH*16777216) - (highL*65536) - (lowH*256);
            bytesToSend[9] = (byte) highH;
            bytesToSend[8] = (byte) highL;
            bytesToSend[7] = (byte) lowH;
            bytesToSend[6] = (byte) lowL;
            for (int j = 0; j < bytesToCreateCRC.length; j++) {
                bytesToCreateCRC[j] = bytesToSend[j];
            }
            int crc = (CRC16.getCRC4(bytesToCreateCRC));
            int high = crc / 256;
            bytesToSend[bytesToSend.length-2] = (byte) (crc - high * 256);
            bytesToSend[bytesToSend.length-1] = (byte) high;
//            Log.i(LOG_TAG, "highH " + highH + "; highL " + highL + "; lowH " + lowH + "; lowL " + lowL + ";");
            Log.i(LOG_TAG, "DOWNLOAD");

            try {
                outputStream.write(bytesToSend);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public class LogsToFile extends Thread {

        @Override
        public void run() {
            super.run();
            File file = new File(getContext().getFilesDir() + "/logs.txt");
            if (file.exists()) file.delete();
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            FileOutputStream fileOutputStream = null;
            try {
                fileOutputStream = new FileOutputStream(file, true);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < spaceFileLogs.getSpaceFileLogsArrayListSize(); i++) {
                byte[] bytes;
                bytes = spaceFileLogs.getSpaceFileLogsByte(i);
                try {
                    fileOutputStream.write(bytes);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}