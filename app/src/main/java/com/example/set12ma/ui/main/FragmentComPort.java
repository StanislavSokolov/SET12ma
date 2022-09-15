package com.example.set12ma.ui.main;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.usb.*;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import com.example.set12ma.MainActivity;
import com.example.set12ma.R;


import com.moxa.mxuportapi.MxException;
import com.moxa.mxuportapi.MxUPort;
import com.moxa.mxuportapi.MxException.ErrorCode;
import com.moxa.mxuportapi.MxUPort.*;
import com.moxa.mxuportapi.MxUPortService;
import com.moxa.mxuportapi.Version;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class FragmentComPort extends Fragment {
    private static final String ARG_SECTION_NUMBER = "ComPort";

    private List<MxUPort> mPortList = null;
    private UsbDevice mDevice;
    private UsbDeviceConnection mConnection;
//    private UsbEndpoint mEndpointIntr;

    boolean b = false;


    private UsbManager mUsbManager;
    HashMap<String, UsbDevice> deviceList;
    private Collection<UsbDevice> mUsbDevice;
    private boolean mExitThread = false;
    private MxUPort mCurrentUPort = null;
    private int mPortSelection = -1;
    private int mBaudRate = -1;
    private int mDataBits = 8;
    private int mParity = 0;
    private int mStopBits = 1;
    private int mFlowControl = 0;

    private int mRtsEnable = MxUPort.RTS_ON;
    private int mDtrEnable = MxUPort.DSR_ON;


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

    public static FragmentComPort newInstance(int index) {
        FragmentComPort fragment = new FragmentComPort();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_SECTION_NUMBER, index);
        fragment.setArguments(bundle);
        return fragment;
    }

    private static final String ACTION_USB_PERMISSION =
            "USB_PERMISSION";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageViewModel = ViewModelProviders.of(this).get(PageViewModel.class);
        int index = 1;
        if (getArguments() != null) {
            index = getArguments().getInt(ARG_SECTION_NUMBER);
        }
        pageViewModel.setIndex(index);

        mUsbManager = (UsbManager) getActivity().getSystemService(Context.USB_SERVICE);
//        IntentFilter usbFilter = new IntentFilter(UsbManager.ACTION_USB_DEVICE_ATTACHED);
//        getContext().registerReceiver(mUsbReceiver, usbFilter);

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
                buttonConnectToDevice.setEnabled(true);


//                mDevice = intent.getParcelableExtra(UsbManager.EXTRA_DEVICE);
//
//                Toast.makeText(getContext(), "Подключение к " + mDevice.getVendorId(), Toast.LENGTH_SHORT).show();
//
//                mPortList = MxUPortService.getPortInfoList(mUsbManager);

            }

            if (UsbManager.ACTION_USB_DEVICE_DETACHED.equals(action)) {
                buttonConnectToDevice.setEnabled(false);

//                mDevice = intent.getParcelableExtra(UsbManager.EXTRA_DEVICE);
//
//                Toast.makeText(getContext(), "Подключение к " + mDevice.getVendorId(), Toast.LENGTH_SHORT).show();
//
//                mPortList = MxUPortService.getPortInfoList(mUsbManager);

            }

            if (ACTION_USB_PERMISSION.equals(action)) {
                Toast.makeText(getContext(), "XP", Toast.LENGTH_SHORT).show();

                synchronized (this) {
                        UsbDevice device = (UsbDevice)intent.getParcelableExtra(UsbManager.EXTRA_DEVICE);

                        if (intent.getBooleanExtra(UsbManager.EXTRA_PERMISSION_GRANTED, false)) {
                            if(device != null){
                                Toast.makeText(getContext(), "call method to set up device communication " + mDevice.getVendorId(), Toast.LENGTH_SHORT).show();
                            }
                        }
                        else {
                            Toast.makeText(getContext(), "XP", Toast.LENGTH_SHORT).show();
                        }
                    }

//                action = intent.getAction();
//                if (ACTION_USB_PERMISSION.equals(action)) {
//                    synchronized (this) {
//                        UsbDevice device = (UsbDevice)intent.getParcelableExtra(UsbManager.EXTRA_DEVICE);
//
//                        if (intent.getBooleanExtra(UsbManager.EXTRA_PERMISSION_GRANTED, false)) {
//                            if(device != null){
//                                Toast.makeText(getContext(), "call method to set up device communication " + mDevice.getVendorId(), Toast.LENGTH_SHORT).show();
//                            }
//                        }
//                        else {
//                            Toast.makeText(getContext(), "XP", Toast.LENGTH_SHORT).show();
//                        }
//                    }
//                }

            }
        }

    };

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    private final BroadcastReceiver mPermissionReceiver = new BroadcastReceiver() {

        public void onReceive(Context context, Intent intent) {

            String action = intent.getAction();

            if (ACTION_USB_PERMISSION.equals(action)) {
//                UsbDevice device = intent.getParcelableExtra(UsbManager.EXTRA_DEVICE);
                if (intent.getBooleanExtra(UsbManager.EXTRA_PERMISSION_GRANTED, false)) {
                    if (mDevice != null) {
                        Toast.makeText(getContext(), "Подключение к " + mDevice.getVendorId(), Toast.LENGTH_SHORT).show();
                        Toast.makeText(getContext(), String.valueOf(mUsbManager.hasPermission(mDevice)), Toast.LENGTH_SHORT).show();
                        try {
                            Toast.makeText(getContext(), String.valueOf(mPortList.get(0).hasUsbPermission()), Toast.LENGTH_SHORT).show();
                        } catch (MxException e) {
                            Toast.makeText(getContext(), String.valueOf(e.getErrorCodeString()), Toast.LENGTH_SHORT).show();
                        }

                    }
                }
            }
        }
    };

//    private static final String ACTION_USB_PERMISSION =
//            "USB_PERMISSION";

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

        buttonConnectToDevice.setEnabled(false);

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


//        mUsbManager = (UsbManager) getActivity().getSystemService(Context.USB_SERVICE);

//        mUsbManager = spaceStatus.getMgr();

//        MxUPortService.requestPermission(getContext(), mUsbManager, ACTION_USB_PERMISSION, 4362, 4433, null);

        return root;
    }

    private void setConnecting() {
        if (buttonConnectToDevice.getText().equals("Подключить")) {
            progressBarConnectedToDevice.setVisibility(View.VISIBLE);
            buttonConnectToDevice.setText("Отключить");
            textViewConnectedToDevice.setText("Подключение к устройству");
            textViewConnectedToDevice.setVisibility(View.VISIBLE);
            step();
//            firstStep();
//            checkFind();
//            checkSend();
//            currentByte = 0;
        } else {
            buttonConnectToDevice.setText("Подключить");
            textViewConnectedToDevice.setText("Отключено от устройства");
            progressBarConnectedToDevice.setVisibility(View.INVISIBLE);
            spaceStatus.setReadyFlagToExchangeData(false);
            spaceStatus.setDevice("");
            getActivity().findViewById(R.id.menu_indicator).setVisibility(View.VISIBLE);
            spaceStatus.setReadyFlagRecordingInitialValues(false);
        }
    }

    private void step() {
//        mDevice = mUsbManager.getDeviceList().get(0);
        mUsbDevice = mUsbManager.getDeviceList().values();
        mDevice = mUsbDevice.iterator().next();
        if (mDevice != null) mUsbManager.requestPermission(mDevice, permissionIntent);
        else Toast.makeText(getContext(), String.valueOf(deviceList.size()), Toast.LENGTH_LONG).show();

//        if (mPortList != null) {
//            for( MxUPort p : mPortList ){
//                try {
//                    if( !p.hasUsbPermission() ){
//                        Thread.sleep(3000);
//                        MxUPortService.requestPermission(getContext(), mUsbManager, ACTION_USB_PERMISSION, 0, 0, mPermissionReceiver);
//                        break;
//                    }
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        }
    }


    private void firstStep() {
//        mUsbManager = spaceStatus.getMgr();


//        ProbeTable customTable = new ProbeTable();
////        customTable.addProduct(0x110A, 0x1151, FtdiSerialDriver.class);
//
//        customTable.addProduct(0x110A, 0x1151, Driver.class);
////        customTable.addProduct(0x110A, 0x1151, ProlificSerialDriver.class);
////        customTable.addProduct(0x110A, 0x1151, Ch34xSerialDriver.class);
////        customTable.addProduct(0x110A, 0x1151, Cp21xxSerialDriver.class);
////        customTable.addProduct(0x110A, 0x1151, CdcAcmSerialDriver.class);
//        UsbSerialProber prober = new UsbSerialProber(customTable);
//        List<UsbSerialDriver> drivers = prober.findAllDrivers(mUsbManager);



//        List<UsbSerialDriver> availableDrivers = UsbSerialProber.getDefaultProber().findAllDrivers(mUsbManager);


//        if (drivers.isEmpty()) {
//            Toast.makeText(getContext(), "we are here 1", Toast.LENGTH_LONG).show();
//            return;
//        }
//
//        // Open a connection to the first available driver.
//        UsbSerialDriver driver = drivers.get(0);
//        UsbDeviceConnection connection = mUsbManager.openDevice(driver.getDevice());
//        if (connection == null) {
//            // add UsbManager.requestPermission(driver.getDevice(), ..) handling here
//            Toast.makeText(getContext(), "we are here 2", Toast.LENGTH_LONG).show();
//            return;
//        }
//
//        byte [] buf = {'H', 'e', 'l', 'l', 'o', ' ',
//                'W', 'o', 'r', 'l', 'd'};
//
//        Toast.makeText(getContext(), String.valueOf(driver.getDevice().getProductName()), Toast.LENGTH_LONG).show();
//        Toast.makeText(getContext(), String.valueOf(driver.getDevice().getManufacturerName()), Toast.LENGTH_LONG).show();
//
//        UsbSerialPort port = driver.getPorts().get(0); // Most devices have just one port (port 0)
//        try {
//
//            Toast.makeText(getContext(), "we are here 3", Toast.LENGTH_LONG).show();
//            port.open(connection);
//            Toast.makeText(getContext(), "we are here 4", Toast.LENGTH_LONG).show();
//            port.setParameters(115200, 8, UsbSerialPort.STOPBITS_1, UsbSerialPort.PARITY_NONE);
//            Toast.makeText(getContext(), "we are here 5", Toast.LENGTH_LONG).show();
//            port.write(buf, 200);
//            Toast.makeText(getContext(), "we are here 6", Toast.LENGTH_LONG).show();
//            port.close();
//        } catch (IOException e) {
//            Toast.makeText(getContext(), e.getLocalizedMessage(), Toast.LENGTH_LONG).show();
//        }


    }



//    if (mPortList != null) {
//
//        IoctlMode m = new IoctlMode( 115000, MxUPort.DATA_BITS_8,
//                MxUPort.PARITY_NONE,
//                MxUPort.STOP_BITS_1 );
//        byte [] buf = {'H', 'e', 'l', 'l', 'o', ' ',
//                'W', 'o', 'r', 'l', 'd'};
//        MxUPort p = mPortList.get(0);
//
//        mDevice = p.getUsbDevice();
//        Toast.makeText(getContext(), "Подключено к устройству product-id " + mDevice.getProductId(), Toast.LENGTH_LONG).show();
//
//        try {
//            Toast.makeText(getContext(), "Шаг 1", Toast.LENGTH_LONG).show();
//            p.open();
//            Toast.makeText(getContext(), "Шаг 2", Toast.LENGTH_LONG).show();
//            p.setIoctlMode(m);
//            Toast.makeText(getContext(), "Шаг 3", Toast.LENGTH_LONG).show();
//            p.write(buf, buf.length);
//            Toast.makeText(getContext(), "Шаг 4", Toast.LENGTH_LONG).show();
//            p.close();
//        } catch (MxException e) {
//            Toast.makeText(getContext(), "Шаг 5", Toast.LENGTH_LONG).show();
//            Toast.makeText(getContext(), e.getErrorCodeString(), Toast.LENGTH_LONG).show();
//        }
//
//    } else Toast.makeText(getContext(), "Нет доступных устройств", Toast.LENGTH_LONG).show();

    private void checkSend() {

    }
}

