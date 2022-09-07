package com.example.set12ma.ui.main;

import android.content.Context;
import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbDeviceConnection;
import android.hardware.usb.UsbEndpoint;
import android.hardware.usb.UsbManager;
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
import com.example.set12ma.R;
import com.moxa.mxuportapi.MxException;
import com.moxa.mxuportapi.MxUPort;
import com.moxa.mxuportapi.MxUPortService;

import java.util.List;

public class FragmentComPort extends Fragment {
    private static final String ARG_SECTION_NUMBER = "ComPort";

    private UsbManager mgr;
    private UsbDevice mDevice;
    private UsbDeviceConnection mConnection;
    private UsbEndpoint mEndpointIntr;

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

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageViewModel = ViewModelProviders.of(this).get(PageViewModel.class);
        int index = 1;
        if (getArguments() != null) {
            index = getArguments().getInt(ARG_SECTION_NUMBER);
        }
        pageViewModel.setIndex(index);
        Log.i("LOG", String.valueOf(index));
    }

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
            textViewConnectedToDevice.setText("Подключение к устройству");
            textViewConnectedToDevice.setVisibility(View.VISIBLE);
            checkSend();
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

    private void checkSend() {
        mgr = spaceStatus.getMgr();
        MxUPortService.requestPermission( getContext(), mgr,
                "MY_PERMISSION", 0, 0, null);
        List<MxUPort> portList = MxUPortService.getPortInfoList(mgr);
        if( portList!=null ){
            MxUPort.IoctlMode m = new MxUPort.IoctlMode(itemSelectedBaudRate, MxUPort.DATA_BITS_8,
                    MxUPort.PARITY_NONE,
                    MxUPort.STOP_BITS_1);
            byte [] buf = {'H', 'e', 'l', 'l', 'o', ' ',
                    'W', 'o', 'r', 'l', 'd'};

            /* Get first UPort device */
            MxUPort p = portList.get(0);
            try {
                p.open();
                p.setIoctlMode(m);
                p.write(buf, buf.length);
                p.close();
            } catch (MxException e) {
                Log.i("USB11", "error");
            }
        } else {
            Log.i("USB11", "null");
        }
    }
}

