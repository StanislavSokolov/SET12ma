package com.example.set12ma.ui.main;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.os.ParcelUuid;
import android.util.Log;

import java.io.IOException;

public class BluetoothSoketThread extends Thread {
    final String PBAP_UUID = "00001101-0000-1000-8000-00805f9b34fb";
    private BluetoothSocket mmServerSocket = null;
    private static final String LOG_TAG = "AndroidExample";
    private long timer = 500;
    private AddressSpace addressSpace;

    public BluetoothSoketThread(BluetoothDevice bluetoothDevice, AddressSpace addressSpace) {
        this.addressSpace = addressSpace;
        try {
            mmServerSocket = bluetoothDevice.createRfcommSocketToServiceRecord(ParcelUuid.fromString(PBAP_UUID).getUuid());
        } catch (IOException e) {
            Log.i(LOG_TAG, e.toString());
        }
        Log.i(LOG_TAG, String.valueOf(mmServerSocket.getRemoteDevice()));
    }

    @Override
    public void run() {
        boolean connect = false;
        try {
            mmServerSocket.connect();
            connect = true;
        } catch (IOException e) {
            Log.i(LOG_TAG, e.toString());
        }
        // If a connection was accepted
        if (connect) {
//            Log.i(LOG_TAG,"if soket !null");
            // Do work to manage the connection (in a separate thread)
            try {
                manageConnectedSocket(mmServerSocket);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//                    try {
////                        Log.i(LOG_TAG,"try");
////                        mmServerSocket.close();
////                    } catch (IOException e) {
////                        e.printStackTrace();
////                    }
        } else {
//            Log.i(LOG_TAG,"socket = null");
        }
    }

    public void cancel() {
        try {
            mmServerSocket.close();
        } catch (IOException e) { }
    }

    private void manageConnectedSocket(BluetoothSocket mmServerSocket) throws InterruptedException {
        BluetoothConnectedThread bluetoothConnectedThread = new BluetoothConnectedThread(mmServerSocket, addressSpace);
//        OutputFragment.setBluetoothConnectedTread(bluetoothConnectedThread);
//        BluetoothFragment.setBluetoothConnectedTread(bluetoothConnectedThread);
        bluetoothConnectedThread.start();

//        while (true) {
//            BluetoothSoketThread.sleep(timer);
//            bluetoothConnectedThread.write();
//        }
        for (int i = 0; i < 10; i++) {
            BluetoothSoketThread.sleep(timer);
            bluetoothConnectedThread.write();
        }


    }
}

