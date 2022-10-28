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
import com.hoho.android.usbserial.driver.ProbeTable;
import com.hoho.android.usbserial.driver.UsbSerialDriver;
import com.hoho.android.usbserial.driver.UsbSerialPort;
import com.hoho.android.usbserial.driver.UsbSerialProber;
import com.moxa.mxuportapi.MxException;
import com.moxa.mxuportapi.MxUPort;
import com.moxa.mxuportapi.MxUPortService;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class FragmentUSB extends Fragment {
    private static final String ARG_SECTION_NUMBER = "ComPort";

    private UsbThread usbThread;
    UsbSerialPort port;
    private PageViewModel pageViewModel;

    private SpaceStatus spaceStatus;
    private ResultReceiverStatusSpace resultReceiverStatusSpace;

    private Spinner spinnerBaudRate;
    private Button buttonConnectToDevice;
    private TextView textViewConnectedToDevice;
    private ProgressBar progressBarConnectedToDevice;

    private ArrayAdapter<Integer> adapterBaudRate;
    private Integer[] baudRate = {9600, 19200, 57600, 115200};
    int itemSelectedBaudRate;

    PendingIntent permissionIntent;

//    Intent intent;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        resultReceiverStatusSpace = (ResultReceiverStatusSpace) context;
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

            }

            if (ACTION_USB_PERMISSION.equals(action)) {
            }
        }

    };

//    public void checkPortList() {
//        mPortList = MxUPortService.getPortInfoList(mUsbManager);
//    }

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
        View root = inflater.inflate(R.layout.fragment_comport, container, false);

        spaceStatus = resultReceiverStatusSpace.getSpaceStatus();

        spinnerBaudRate = root.findViewById(R.id.spinner_connected_devices_cp);
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

        AdapterView.OnItemSelectedListener itemSelectedListener = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                itemSelectedBaudRate = (int) spinnerBaudRate.getSelectedItem();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        };
        spinnerBaudRate.setOnItemSelectedListener(itemSelectedListener);

        return root;
    }

    private void setConnecting() {
        if (buttonConnectToDevice.getText().equals("Подключить")) {
            progressBarConnectedToDevice.setVisibility(View.VISIBLE);
            buttonConnectToDevice.setText("Отключить");
            textViewConnectedToDevice.setVisibility(View.VISIBLE);

            // Find all available drivers from attached devices.
            UsbManager manager = spaceStatus.getMgr();
            List<UsbSerialDriver> availableDrivers = UsbSerialProber.getDefaultProber().findAllDrivers(manager);
            if (availableDrivers.isEmpty()) {
                Toast.makeText(getContext(), "Подключитесь к устройству", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(getContext(), "Подключение к " + availableDrivers.get(0).getDevice().getProductName() + " " + availableDrivers.get(0).getDevice().getManufacturerName(), Toast.LENGTH_LONG).show();
            }

            // Open a connection to the first available driver.
            UsbSerialDriver driver = availableDrivers.get(0);
            UsbDeviceConnection connection = manager.openDevice(driver.getDevice());
            if (connection == null) {
                Toast.makeText(getContext(), "Has no permittion", Toast.LENGTH_LONG).show();
//             UsbManager.requestPermission(driver.getDevice(), permissionIntent);
                return;
            }

            port = driver.getPorts().get(0); // Most devices have just one port (port 0)

            textViewConnectedToDevice.setText("Подключено к устройству " + availableDrivers.get(0).getDevice().getProductName() + " " + availableDrivers.get(0).getDevice().getManufacturerName());

            try {
                port.open(connection);
                port.setParameters(115200, 8, UsbSerialPort.STOPBITS_1, UsbSerialPort.PARITY_NONE);
                usbThread = new UsbThread();
                usbThread.start();
            } catch (IOException e) {
                Toast.makeText(getContext(), String.valueOf(e.getMessage()), Toast.LENGTH_LONG).show();
            }
        } else {
            try {
                port.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            buttonConnectToDevice.setText("Подключить");
            textViewConnectedToDevice.setText("Отключено от устройства");
            progressBarConnectedToDevice.setVisibility(View.INVISIBLE);
            spaceStatus.setReadyFlagToExchangeData(false);
            spaceStatus.setDevice("");
            getActivity().findViewById(R.id.menu_indicator).setVisibility(View.VISIBLE);
            spaceStatus.setReadyFlagRecordingInitialValues(false);
        }
    }

//        customTable = new ProbeTable();
//        customTable.addProduct(0x110A, 0x1151, Driver.class);
//        UsbSerialProber prober = new UsbSerialProber(customTable);
//        List<UsbSerialDriver> drivers = prober.findAllDrivers(mUsbManager);

    public class UsbThread extends Thread {

        @Override
        public void run() {
            super.run();

            while (port.isOpen()) {
                try {
                    usbThread.sleep(1000);
                    port.write(spaceStatus.getCommunication().write(5, 11), 200);
                } catch (InterruptedException | IOException e) {
                    e.printStackTrace();
                }
            }
        }

        public UsbThread() {

        }
    }
}

