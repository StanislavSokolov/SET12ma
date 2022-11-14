package com.example.set12ma.ui.main;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.usb.*;
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
import com.hoho.android.usbserial.driver.UsbSerialDriver;
import com.hoho.android.usbserial.driver.UsbSerialPort;
import com.hoho.android.usbserial.driver.UsbSerialProber;

import java.io.IOException;
import java.util.List;

public class FragmentUSB extends Fragment {
    private static final String ARG_SECTION_NUMBER = "USB";

    private UsbThreadInput usbThreadInput;
    private UsbThreadOutput usbThreadOutput;
    private UsbSerialPort port = null;

    private PageViewModel pageViewModel;

    private SpaceStatus spaceStatus;
    private ResultReceiverStatusSpace resultReceiverStatusSpace;

    private SpaceAddress spaceAddress;
    private ResultReceiverAddressSpace resultReceiverAddressSpace;

    private Spinner spinnerBaudRate;
    private Spinner spinnerDataBits;
    private Spinner spinnerStopBits;
    private Spinner spinnerParity;
    private Button buttonConnectToDevice;
    private TextView textViewConnectedToDevice;
    private ProgressBar progressBarConnectedToDevice;

    private ArrayAdapter<Integer> adapterBaudRate;
    private Integer[] baudRate = {9600, 19200, 57600, 115200};
    int itemSelectedBaudRate;

    private ArrayAdapter<Integer> adapterDataBits;
    private Integer[] dataBits = {5, 6, 7, 8};
    int itemSelectedDataBits;

    private ArrayAdapter<Integer> adapterStopBits;
    private Integer[] stopBits = {1, 2};
    int itemSelectedStopBits;

    private ArrayAdapter<String> adapterParity;
    private String[] parity = {"NONE", "ODD", "EVEN", "MARK", "SPACE"};
    int itemSelectedParity;

    PendingIntent permissionIntent;

//    Intent intent;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        resultReceiverStatusSpace = (ResultReceiverStatusSpace) context;
        resultReceiverAddressSpace = (ResultReceiverAddressSpace) context;
    }

    public static FragmentUSB newInstance(int index) {
        FragmentUSB fragment = new FragmentUSB();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_SECTION_NUMBER, index);
        fragment.setArguments(bundle);
        return fragment;
    }

    private static final String ACTION_USB_PERMISSION =
            "USB_PERMISSION";

    private static final String ACTION_USB_TEST =
            "TEST";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageViewModel = ViewModelProviders.of(this).get(PageViewModel.class);
        int index = 1;
        if (getArguments() != null) {
            index = getArguments().getInt(ARG_SECTION_NUMBER);
        }
        pageViewModel.setIndex(index);

        permissionIntent = PendingIntent.getBroadcast(getContext(), 0, new Intent(ACTION_USB_PERMISSION), 0);
        IntentFilter filter = new IntentFilter(ACTION_USB_PERMISSION);
        getContext().registerReceiver(usbReceiver, filter);
        IntentFilter filterConnect = new IntentFilter(UsbManager.ACTION_USB_DEVICE_ATTACHED);
        getContext().registerReceiver(usbReceiver, filterConnect);
        IntentFilter filterDisconnect = new IntentFilter(UsbManager.ACTION_USB_DEVICE_DETACHED);
        getContext().registerReceiver(usbReceiver, filterDisconnect);
    }

    private final BroadcastReceiver usbReceiver = new BroadcastReceiver() {

        public void onReceive(Context context, Intent intent) {

            String action = intent.getAction();

            if (UsbManager.ACTION_USB_DEVICE_ATTACHED.equals(action)) {
            }

            if (UsbManager.ACTION_USB_DEVICE_DETACHED.equals(action)) {
                Toast.makeText(getContext(), "Устройство отключено", Toast.LENGTH_LONG).show();
            }

            if (ACTION_USB_PERMISSION.equals(action)) {
                Toast.makeText(getContext(), "Выполните повторное подключение", Toast.LENGTH_LONG).show();
            }
        }

    };

    private final BroadcastReceiver mPermissionReceiver = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            Toast.makeText(getContext(), "1", Toast.LENGTH_LONG).show();
            String action = intent.getAction();
            if (ACTION_USB_TEST.equals(action)) {
                Toast.makeText(getContext(), "2", Toast.LENGTH_LONG).show();
                synchronized(this) {
                    UsbDevice device = (UsbDevice)intent.getParcelableExtra(UsbManager.EXTRA_DEVICE);
                    if (intent.getBooleanExtra(UsbManager.EXTRA_PERMISSION_GRANTED, false)) {
                        Toast.makeText(getContext(), "3", Toast.LENGTH_LONG).show();
                    }
                }
            }

        }
    };

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_usb, container, false);

        spaceStatus = resultReceiverStatusSpace.getSpaceStatus();
        spaceAddress = resultReceiverAddressSpace.getSpaceAddress();

        spinnerBaudRate = root.findViewById(R.id.spinner_baudRate);
        spinnerDataBits = root.findViewById(R.id.spinner_dataBits);
        spinnerStopBits = root.findViewById(R.id.spinner_stopBits);
        spinnerParity = root.findViewById(R.id.spinner_parity);
        buttonConnectToDevice = root.findViewById(R.id.button_connect_to_device_cp);
        textViewConnectedToDevice = root.findViewById(R.id.textView_path_to_load_file_for_sp6_cp);
        progressBarConnectedToDevice = root.findViewById(R.id.progressBar_loading_to_flesh_cp);

        buttonConnectToDevice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setConnecting();
            }
        });

        buttonConnectToDevice.setEnabled(true);

        adapterBaudRate = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item);
        adapterBaudRate.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        for (int i = 0; i < baudRate.length; i++) adapterBaudRate.add(baudRate[i]);
        spinnerBaudRate.setAdapter(adapterBaudRate);

        AdapterView.OnItemSelectedListener itemSelectedListenerBaudRate = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                itemSelectedBaudRate = (int) spinnerBaudRate.getSelectedItem();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        };
        spinnerBaudRate.setOnItemSelectedListener(itemSelectedListenerBaudRate);

        adapterDataBits = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item);
        adapterDataBits.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        for (int i = 0; i < dataBits.length; i++) adapterDataBits.add(dataBits[i]);
        spinnerDataBits.setAdapter(adapterDataBits);

        AdapterView.OnItemSelectedListener itemSelectedListenerDataBits = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                itemSelectedDataBits = (int) spinnerDataBits.getSelectedItem();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        };
        spinnerDataBits.setOnItemSelectedListener(itemSelectedListenerDataBits);

        adapterStopBits = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item);
        adapterStopBits.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        for (int i = 0; i < stopBits.length; i++) adapterStopBits.add(stopBits[i]);
        spinnerStopBits.setAdapter(adapterStopBits);

        AdapterView.OnItemSelectedListener itemSelectedListenerStopBits = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                itemSelectedStopBits = (int) spinnerStopBits.getSelectedItem();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        };
        spinnerStopBits.setOnItemSelectedListener(itemSelectedListenerStopBits);

        adapterParity= new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item);
        adapterParity.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        for (int i = 0; i < parity.length; i++) adapterParity.add(parity[i]);
        spinnerParity.setAdapter(adapterParity);

        AdapterView.OnItemSelectedListener itemSelectedListenerParity = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                itemSelectedParity = spinnerParity.getSelectedItemPosition();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        };
        spinnerParity.setOnItemSelectedListener(itemSelectedListenerParity);

        return root;
    }

    private void setConnecting() {
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

            // Find all available drivers from attached devices.
            UsbManager manager = spaceStatus.getMgr();
            List<UsbSerialDriver> availableDrivers = UsbSerialProber.getDefaultProber().findAllDrivers(manager);
            if (availableDrivers.isEmpty()) {
                Toast.makeText(getContext(), "Подключитесь к устройству", Toast.LENGTH_LONG).show();
                return;
            } else {
                Toast.makeText(getContext(), "Подключение к " + availableDrivers.get(0).getDevice().getProductName() + " " + availableDrivers.get(0).getDevice().getManufacturerName(), Toast.LENGTH_LONG).show();
            }

            // Open a connection to the first available driver.
            UsbSerialDriver driver = availableDrivers.get(0);
            UsbDeviceConnection connection = manager.openDevice(driver.getDevice());
            if (connection == null) {
                manager.requestPermission(driver.getDevice(), permissionIntent);
                return;
            }
            openPort(driver, availableDrivers, connection);
        } else {

            spaceStatus.setReadyFlagToExchangeData(false);
            spaceStatus.setReadyFlagToLoadSoftware(false);
            spaceStatus.setReadyFlagToUpdateSoftware(false);
            spaceStatus.setReadyFlagToFinishOfLoadingSoftware(false);
            spaceStatus.setReadyFlagToFinishOfUpdatingSoftware(false);
            spaceStatus.setStatusProcessOfLoadingSoftware(false);
            spaceStatus.setStatusProcessOfUpdatingSoftware(false);

            buttonConnectToDevice.setText("Подключить");
            textViewConnectedToDevice.setText("Отключено от устройства");
            progressBarConnectedToDevice.setVisibility(View.INVISIBLE);
            spaceStatus.setReadyFlagToExchangeData(false);
            spaceStatus.setDevice("");
            getActivity().findViewById(R.id.menu_indicator).setVisibility(View.VISIBLE);
            spaceStatus.setReadyFlagRecordingInitialValues(false);

            if (usbThreadInput.isAlive()) {
                usbThreadInput.interrupt();
            }
            if (usbThreadOutput.isAlive()) {
                usbThreadOutput.interrupt();
            }
        }
    }

    private void openPort(UsbSerialDriver driver, List<UsbSerialDriver> availableDrivers, UsbDeviceConnection connection) {
        port = driver.getPorts().get(0); // Most devices have just one port (port 0)
        spaceStatus.getCommunication().prepare();

        spaceStatus.setReadyFlagRecordingInitialValues(true);

        textViewConnectedToDevice.setText("Подключено к устройству " + availableDrivers.get(0).getDevice().getProductName() + " " + availableDrivers.get(0).getDevice().getManufacturerName());

        try {
            port.open(connection);
            port.setParameters(itemSelectedBaudRate, itemSelectedDataBits, itemSelectedStopBits, itemSelectedParity);
            usbThreadInput = new UsbThreadInput();
            usbThreadInput.start();
            usbThreadOutput = new UsbThreadOutput();
            usbThreadOutput.start();
        } catch (IOException e) {
            Toast.makeText(getContext(), String.valueOf(e.getMessage()), Toast.LENGTH_LONG).show();
        }

        buttonConnectToDevice.setText("Отключить");
        textViewConnectedToDevice.setVisibility(View.VISIBLE);
    }

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

//        customTable = new ProbeTable();
//        customTable.addProduct(0x110A, 0x1151, Driver.class);
//        UsbSerialProber prober = new UsbSerialProber(customTable);
//        List<UsbSerialDriver> drivers = prober.findAllDrivers(mUsbManager);

    public class UsbThreadOutput extends Thread {

        @Override
        public void run() {
            super.run();

            byte[] bytes;
            int prevStatus = 0;

            while (!isInterrupted()) {
                try {
                    int status = spaceStatus.getStatusCommunication();
                    if (prevStatus != status) {
                        prevStatus = status;
                        setStatus(status);
                    }
                    bytes = spaceStatus.getCommunication().communication();
                    if (bytes != null) port.write(bytes, 0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            portClose();
        }

        public UsbThreadOutput() {

        }
    }


    public class UsbThreadInput extends Thread {

        @Override
        public void run() {
            super.run();
            byte[] buffer = new byte[32];  // buffer store for the stream
            int bytes; // bytes returned from read()
            while (!isInterrupted()) {
                try {
                    bytes = port.read(buffer, 0);
                    byte[] buf = new byte[bytes];
                    for (int i = 0; i < buf.length; i++) {
                        buf[i] = buffer[i];
                    }
                    spaceAddress.setByteQueue(buf);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            portClose();
        }

        public UsbThreadInput() {

        }
    }

    private synchronized void portClose() {
        if (port.isOpen()) {
            try {
                port.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

