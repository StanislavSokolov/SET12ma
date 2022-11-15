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

    // for
    private static final String ARG_SECTION_NUMBER = "BT";
    private static final String LOG_TAG = "AndroidExample";
    private String stringConnectedToDevice;
    private SpaceAddress spaceAddress;
    private ResultReceiverAddressSpace resultReceiverAddressSpace;

    private SpaceStatus spaceStatus;
    private ResultReceiverStatusSpace resultReceiverStatusSpace;

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
        resultReceiverStatusSpace = (ResultReceiverStatusSpace) context;
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
        spaceStatus = resultReceiverStatusSpace.getSpaceStatus();

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

            if (buttonConnectToDevice.getText().equals("Подключить")) {
                if (spaceStatus.isReadyFlagToExchangeData()) {
                    Toast.makeText(getContext(), "Устройство уже подключено", Toast.LENGTH_LONG).show();
                    return;
                }

                spaceStatus.setReadyFlagToExchangeData(false);
                spaceStatus.setReadyFlagToLoadSoftware(false);
                spaceStatus.setReadyFlagToUpdateSoftware(false);
                spaceStatus.setReadyFlagToFinishOfLoadingSoftware(false);
                spaceStatus.setReadyFlagToFinishOfUpdatingSoftware(false);
                spaceStatus.setStatusProcessOfLoadingSoftware(false);
                spaceStatus.setStatusProcessOfUpdatingSoftware(false);

                spaceStatus.getCommunication().prepare();

                stringConnectedToDevice = arrayListConnectedDevices.get(itemSelectedFromConnectedDevices).getName();
                bluetoothDevice = arrayListConnectedDevices.get(itemSelectedFromConnectedDevices);
                progressBarConnectedToDevice.setVisibility(View.VISIBLE);
                buttonConnectToDevice.setText("Отключить");
                textViewConnectedToDevice.setText("Подключение к " + stringConnectedToDevice);
                textViewConnectedToDevice.setVisibility(View.VISIBLE);
                bluetoothSoketThread = new BluetoothSoketThread();
                bluetoothSoketThread.start();
            } else {
                spaceStatus.setReadyFlagToExchangeData(false);
                spaceStatus.setReadyFlagToLoadSoftware(false);
                spaceStatus.setReadyFlagToUpdateSoftware(false);
                spaceStatus.setReadyFlagToFinishOfLoadingSoftware(false);
                spaceStatus.setReadyFlagToFinishOfUpdatingSoftware(false);
                spaceStatus.setStatusProcessOfLoadingSoftware(false);
                spaceStatus.setStatusProcessOfUpdatingSoftware(false);

                spaceStatus.getCommunication().prepare();

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

            while (!isInterrupted()) {

            }
            bluetoothConnectedInputThread.interrupt();
            bluetoothConnectedOutputThread.interrupt();
        }
    }

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

    public void setStatus(int status) {
        switch (status) {
            case 0:
                textViewConnectedToDevice.post(new Runnable() {
                    @Override
                    public void run() {
                        textViewConnectedToDevice.setText("Устройство не подключено");
                        setConnecting();
                    }
                });
                break;
            case 1:
                textViewConnectedToDevice.post(new Runnable() {
                    @Override
                    public void run() {
                        textViewConnectedToDevice.setText("Подключено к устройству");
                    }
                });
                progressBarConnectedToDevice.post(new Runnable() {
                    @Override
                    public void run() {
                        progressBarConnectedToDevice.setVisibility(View.INVISIBLE);
                    }
                });
                break;
            case 2:
                textViewConnectedToDevice.post(new Runnable() {
                    @Override
                    public void run() {
                        textViewConnectedToDevice.setText("Процессорный модуль не отвечает. Проверьте соединение.");
                        getActivity().findViewById(R.id.menu_indicator).setVisibility(View.VISIBLE);
                        setConnecting();
                    }
                });
                break;
            case 3:
                textViewConnectedToDevice.post(new Runnable() {
                    @Override
                    public void run() {
                        textViewConnectedToDevice.setText("Не удается связаться с процессорным модулем. Проверьте соединение.");
                        getActivity().findViewById(R.id.menu_indicator).setVisibility(View.VISIBLE);
                        setConnecting();
                    }
                });
                break;
            case 4:
                textViewConnectedToDevice.post(new Runnable() {
                    @Override
                    public void run() {
                        textViewConnectedToDevice.setText("Не удается связаться с процессорным модулем. Проверьте соединение.");
                        getActivity().findViewById(R.id.menu_indicator).setVisibility(View.VISIBLE);
                        Toast.makeText(getContext(), "Не удается связаться с процессорным модулем. Проверьте соединение.", Toast.LENGTH_LONG).show();
                        setConnecting();
                    }
                });
                break;
            default:
                break;
        }
    }

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
                    for (int i = 0; i < buf.length; i++) {
                        buf[i] = buffer[i];
                    }
                    spaceAddress.setByteQueue(buf);
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
        byte[] bytes;
        int prevStatus = 0;

        public BluetoothConnectedOutputThread() {
            // Get the input and output streams, using temp objects because
            // member streams are final
            try {
                outputStream = bluetoothSocket.getOutputStream();
            } catch (IOException e) { Log.i(LOG_TAG,"don't get Streams");}
        }

        public void run() {

            while (!isInterrupted()) {
                int status = spaceStatus.getStatusCommunication();
                if (prevStatus != status) {
                    prevStatus = status;
                    setStatus(status);
                }
                bytes = spaceStatus.getCommunication().communication();
                if (bytes != null) {
                    try {
                        outputStream.write(bytes);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            try {
                outputStream.close();
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
    }
}