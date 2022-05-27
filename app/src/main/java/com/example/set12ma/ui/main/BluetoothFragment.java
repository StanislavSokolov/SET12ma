package com.example.set12ma.ui.main;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.os.ParcelUuid;
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

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Set;

import static java.lang.Thread.sleep;

public class BluetoothFragment extends Fragment {

    // for BluetoothSoketThread
    final String PBAP_UUID = "00001101-0000-1000-8000-00805f9b34fb";
    private BluetoothSocket bluetoothSocket;
    private BluetoothDevice bluetoothDevice;
    private long timer = 1000;


    // for BluetoothConnectedThread
    private InputStream inputStream;
    private OutputStream outputStream;
    private byte addressDevice = 10;
    private byte readCommand = 56;
    private boolean statusConnecting = false;
    private byte writeCommand = 57;
    private int countBytes = 8;
    private int addressSpaceNumber = 0;
    private boolean isStatusConnecting = false;
    private boolean isStatusReading = false;
    private int statement = 0;
    private int currentByte = 0;
    private int counterUnsuccessfulSending = 0;
    private int maxValueUnsuccessfulSending = 1000;
    byte[] bytesToSend;
    byte[] bytesFromBuffer;
    byte[] bytesToCreateCRC;

    // for
    private static final String ARG_SECTION_NUMBER = "BT";
    private static final String LOG_TAG = "AndroidExample";
    private String stringConnectedToDevice;
    private AddressSpace addressSpace;
    private ResultReceiver resultReceiver;

    private ArrayList<BluetoothDevice> arrayListAvailableDevices;                               // список устройств, доступных к сопряжению
    private ArrayList<BluetoothDevice> arrayListConnectedDevices;                               // список устройств, доступных к сопряжению
    private int itemSelectedFromConnectedDevices = 0;
    private BluetoothAdapter bluetooth;
    private ArrayAdapter<String> adapterConnectedDevices;
    private String firstStringAdapterConnectedDevices = "Выберите устройство";
    private ArrayAdapter<String> adapterAvailableDevices;
    private String firstStringAdapterAvailableDevices = "Выберите устройство";

    private BluetoothSoketThread bluetoothSoketThread;

    private PageViewModel pageViewModel;
    private TextView textViewConnectedDevices;
    private Spinner spinnerConnectedDevices;
    private Button buttonConnectToDevice;
    private static TextView textViewConnectedToDevice;
    private static ProgressBar progressBarConnectedToDevice;
    private TextView textViewAvailableDevices;
    private Spinner spinnerAvailableDevices;
    private Button buttonFindNewDevices;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        resultReceiver = (ResultReceiver) context;
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


    public static BluetoothFragment newInstance(int index) {
        BluetoothFragment fragment = new BluetoothFragment();
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

        addressSpace = resultReceiver.getAddressSpace();

        textViewConnectedDevices = root.findViewById(R.id.textView_connected_devices);
        spinnerConnectedDevices = root.findViewById(R.id.spinner_connected_devices);
        buttonConnectToDevice = root.findViewById(R.id.button_connect_to_device);
        textViewConnectedToDevice = root.findViewById(R.id.textView_connected_to_device);
        progressBarConnectedToDevice = root.findViewById(R.id.progressBar_connected_to_device);
        textViewAvailableDevices = root.findViewById(R.id.textView_available_devices);
        spinnerAvailableDevices = root.findViewById(R.id.spinner_available_devices);
        buttonFindNewDevices = root.findViewById(R.id.button_find_new_devices);

        checkEnableBluetooth();
        showConnectedDevices();
        showAvailableDevices();


        buttonConnectToDevice.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR2)
            @Override
            public void onClick(View v) { setConnecting();
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

    private void setConnecting(){
        if (!adapterConnectedDevices.getItem(itemSelectedFromConnectedDevices + 1).equals("Выберите устройство")) {
            if (buttonConnectToDevice.getText().equals("Подключить")) {
                stringConnectedToDevice = arrayListConnectedDevices.get(itemSelectedFromConnectedDevices).getName();
                bluetoothDevice = arrayListConnectedDevices.get(itemSelectedFromConnectedDevices);
                progressBarConnectedToDevice.setVisibility(View.VISIBLE);
                buttonConnectToDevice.setText("Отключить");
                textViewConnectedToDevice.setText("Подключение к " + stringConnectedToDevice);
                textViewConnectedToDevice.setVisibility(View.VISIBLE);
                bluetoothSoketThread = new BluetoothSoketThread();
                bluetoothSoketThread.start();
//                new ConnectingTask(getContext()).loadInBackground();
            } else {
                bluetoothSoketThread.cancel();
                buttonConnectToDevice.setText("Подключить");
                textViewConnectedToDevice.setText("Отключено от " + stringConnectedToDevice);
                progressBarConnectedToDevice.setVisibility(View.INVISIBLE);
//                isStatusConnecting = false;
            }
        }
    }

    private void checkEnableBluetooth(){
        if (bluetooth.isEnabled()) {
        }
        else
        {
            Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(enableBtIntent, 12);
        }
    }

    private void showConnectedDevices(){

        arrayListConnectedDevices = new ArrayList<>();
        adapterConnectedDevices = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item);
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
        adapterAvailableDevices = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item);
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
            boolean connect = false;
            try {
                bluetoothSocket.connect();
                connect = true;
            } catch (IOException e) {
                Log.i(LOG_TAG, e.toString());
            }
            // If a connection was accepted
            if (connect) {
                // Do work to manage the connection (in a separate thread)
                try {
                    manageConnectedSocket();
                    Log.i(LOG_TAG,"try to manage");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
            }
        }

        public void cancel() {
            try {
                bluetoothSocket.close();
            } catch (IOException e) { }
        }

        private void manageConnectedSocket() throws InterruptedException {
            BluetoothConnectedThread bluetoothConnectedThread = new BluetoothConnectedThread();
            bluetoothConnectedThread.start();

            while (true) {
                BluetoothSoketThread.sleep(timer);
                bluetoothConnectedThread.write();
            }
        }
    }

    public class BluetoothConnectedThread extends Thread {


        public BluetoothConnectedThread() {

            // Get the input and output streams, using temp objects because
            // member streams are final
            try {
                inputStream = bluetoothSocket.getInputStream();
                outputStream = bluetoothSocket.getOutputStream();
//            Log.i(LOG_TAG,"get Streams");
            } catch (IOException e) { Log.i(LOG_TAG,"don't get Streams");}
//        Log.i(LOG_TAG,"here");
        }

        public void run() {
            byte[] buffer = new byte[8];  // buffer store for the stream
            int bytes = 20; // bytes returned from read()
            while (true) {
                try {
                    // Read from the InputStream
                    bytes = inputStream.read(buffer);
                    // Send the obtained bytes to the UI activity
//                    mHandler.obtainMessage(MESSAGE_READ, bytes, -1, buffer)
//                            .sendToTarget();
                    if (bytes == 8) {
                        bytesFromBuffer = new byte[bytes];
                        bytesToCreateCRC = new byte[bytes - 2];
                        for (int i = 0; i < bytesFromBuffer.length; i++) {
//                        if (buffer[i] < 0) bytesFromBuffer[i] = (buffer[i] + 256); else bytesFromBuffer[i] = buffer[i];
                            bytesFromBuffer[i] = buffer[i];
                        }
                        for (int i = 0; i < bytesToCreateCRC.length; i++) {
                            bytesToCreateCRC[i] = bytesFromBuffer[i];
                        }
                        int crc = (CRC16.getCRC4(bytesToCreateCRC));

                        int high = crc/256;

//                        Log.i(LOG_TAG, String.valueOf(crc - high*256));
//                        Log.i(LOG_TAG, String.valueOf(high));

                        if ((bytesFromBuffer[bytesToCreateCRC.length] == (byte) (crc - high*256)) & (bytesFromBuffer[bytesToCreateCRC.length + 1] == (byte) high)) {
                            if (isStatusConnecting) {
                                addressSpace.setAddressSpace(currentByte, bytesFromBuffer[2]);
                                // Это счетчик битов, ктр увеличивает значение при каждом удачном приеме;
                                String answerTest = "";
                                for (byte readByte: bytesFromBuffer) {
                                    int bufInt = 0;
                                    if (readByte < 0) bufInt = readByte + 256; else bufInt = readByte;
                                    answerTest = answerTest + " " + bufInt;
                                }
                                Log.i(LOG_TAG, answerTest);
                                if (currentByte == 255) currentByte = 0; else currentByte++;
                            } else {
                                textViewConnectedToDevice.setText("Поключено к " + stringConnectedToDevice);
                                progressBarConnectedToDevice.setVisibility(View.INVISIBLE);
                                isStatusConnecting = true;
                            }
                            isStatusReading = true;
                        } else {
                            Log.i(LOG_TAG, "CRC не совпало");
                            textViewConnectedToDevice.setText("CRC не совпало");
                        }
                    } else if (bytes == 6) {
                        bytesFromBuffer = new byte[bytes];
                        bytesToCreateCRC = new byte[bytes - 4];
                        for (int i = 0; i < bytesFromBuffer.length; i++) {
//                        if (buffer[i] < 0) bytesFromBuffer[i] = (buffer[i] + 256); else bytesFromBuffer[i] = buffer[i];
                            bytesFromBuffer[i] = buffer[i];
                        }
                        for (int i = 0; i < bytesToCreateCRC.length; i++) {
                            bytesToCreateCRC[i] = bytesFromBuffer[i];
                        }
                        int crc = (CRC16.getCRC4(bytesToCreateCRC));

                        int high = crc/256;

//                        Log.i(LOG_TAG, String.valueOf(crc - high*256));
//                        Log.i(LOG_TAG, String.valueOf(high));

                        if ((bytesFromBuffer[bytesToCreateCRC.length] == (byte) (crc - high*256)) & (bytesFromBuffer[bytesToCreateCRC.length + 1] == (byte) high)) {
                            if (isStatusConnecting) {
                                // Это счетчик битов, ктр увеличивает значение при каждом удачном приеме;

                                String answerTest = "";
                                for (byte readByte: bytesFromBuffer) {
                                    int bufInt = 0;
                                    if (readByte < 0) bufInt = readByte + 256; else bufInt = readByte;
                                    answerTest = answerTest + " " + bufInt;
                                }
                                Log.i(LOG_TAG, answerTest);
                                if (currentByte == 255) currentByte = 0; else currentByte++;
                            } else {
                                textViewConnectedToDevice.setText("Поключено к " + stringConnectedToDevice);
                                progressBarConnectedToDevice.setVisibility(View.INVISIBLE);
                                isStatusConnecting = true;
                            }

                            isStatusReading = true;
                        } else {
                            Log.i(LOG_TAG, "CRC не совпало");
                            textViewConnectedToDevice.setText("CRC не совпало");
                        }
                    }




                } catch (IOException e) {
                    Log.i(LOG_TAG,e.toString());
                    break;
                }
            }
        }

        public void write() {
            if (isStatusConnecting) {
                if (counterUnsuccessfulSending < maxValueUnsuccessfulSending) {
                    switch (statement) {
                        // чтение IN
                        case 0:
                            if (isStatusReading) {
                                counterUnsuccessfulSending = 0;
                                Log.i(LOG_TAG, "statement 0");
                                sending(0);
                                isStatusReading = false;
                                if (currentByte == 47) statement = 1;
                            } else {
                                sending(0);
                                counterUnsuccessfulSending++;
                            }

                            break;
                        // запись out
                        case 1:
                            if (isStatusReading) {
                                counterUnsuccessfulSending = 0;
                                Log.i(LOG_TAG, "statement 1");
                                sending(1);
                                isStatusReading = false;
                                if (currentByte == 95) statement = 2;
                            } else {
                                sending(1);
                                counterUnsuccessfulSending++;
                            }
                            break;
                        // чтение ADC
                        case 2:
                            if (isStatusReading) {
                                counterUnsuccessfulSending = 0;
                                Log.i(LOG_TAG, "statement 2");
                                sending(0);
                                isStatusReading = false;
                                if (currentByte == 143) statement = 3;
                            } else {
                                sending(0);
                                counterUnsuccessfulSending++;
                            }
                            break;
                        // запись ТК
                        case 3:
                            if (isStatusReading) {
                                counterUnsuccessfulSending = 0;
                                Log.i(LOG_TAG, "statement 3");
                                sending(1);
                                isStatusReading = false;
                                if (currentByte == 207) statement = 4;
                            } else {
                                sending(1);
                                counterUnsuccessfulSending++;
                            }
                            break;
                        // чтение ADC
                        case 4:
                            if (isStatusReading) {
                                counterUnsuccessfulSending = 0;
                                Log.i(LOG_TAG, "statement 4");
                                sending(0);
                                isStatusReading = false;
                                if (currentByte == 255) statement = 0;
                            } else {
                                sending(0);
                                counterUnsuccessfulSending++;
                            }
                            break;
                        default:
                            break;
                    }

                } else Log.i(LOG_TAG, "множественные неудачные попытки прочитать значение");
            } else {
                bytesToSend = new byte[countBytes];
                bytesToCreateCRC = new byte[countBytes - 2];
                bytesToSend[0] = addressDevice;
                bytesToSend[1] = readCommand;
                bytesToSend[2] = 6;
                bytesToSend[3] = 32;
                bytesToSend[4] = 0;
                bytesToSend[5] = 0;
                for (int i = 0; i < bytesToCreateCRC.length; i++) {
                    bytesToCreateCRC[i] = bytesToSend[i];
                }
                int crc = (CRC16.getCRC4(bytesToCreateCRC));
                int high = crc / 256;
//                int low = crc - high * 256;
                bytesToSend[6] = (byte) (crc - high * 256);
                bytesToSend[7] = (byte) high;
                try {
                    outputStream.write(bytesToSend);
                } catch (IOException e) {}

            }
        }

        private void sending(int mode) {
            if (mode == 0) {
                bytesToSend = new byte[countBytes];
                bytesToCreateCRC = new byte[countBytes - 2];
                bytesToSend[0] = addressDevice;
                bytesToSend[1] = readCommand;
                bytesToSend[2] = (byte) currentByte;
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
            } else {
                bytesToSend = new byte[countBytes + 4];
                bytesToCreateCRC = new byte[countBytes + 2];
                bytesToSend[0] = addressDevice;
                bytesToSend[1] = writeCommand;
                bytesToSend[2] = (byte) currentByte;
                bytesToSend[3] = 0;
                bytesToSend[4] = 0;
                bytesToSend[5] = 0;
                int data = addressSpace.getAddressSpace(currentByte);
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

//                String respondTest = "";
//                for (byte writeByte: bytesToSend) {
//                    int bufInt = 0;
//                    if (writeByte < 0) bufInt = writeByte + 256; else bufInt = writeByte;
//                    respondTest = respondTest + " " + bufInt;
//                }
//                Log.i(LOG_TAG, respondTest);
            }
            try {
                outputStream.write(bytesToSend);
            } catch (IOException e) {}

        }

        /* Call this from the main activity to shutdown the connection */
        public void cancel() {
            try {
                bluetoothSocket.close();
            } catch (IOException e) { }
        }

//        public boolean checkStatusConnecting() {
//            return statusConnecting;
//        }
    }

//    class ConnectingTask extends AsyncTaskLoader {
//
//        public ConnectingTask(@NonNull Context context) {
//            super(context);
//        }
//
//        @Nullable
//        @Override
//        public String loadInBackground() {
//            try {
////                sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            bluetoothSoketThread = new BluetoothSoketThread();
//            bluetoothSoketThread.start();
//            return "Подключено";
//        }
//
//
//    }

}

