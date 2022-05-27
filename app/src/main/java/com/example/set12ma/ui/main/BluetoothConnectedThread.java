package com.example.set12ma.ui.main;

import android.bluetooth.BluetoothSocket;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class BluetoothConnectedThread extends Thread {
    private boolean statusConnecting = false;
    private static final String LOG_TAG = "AndroidExample";
    private final BluetoothSocket socket;
    private final InputStream inputStream;
    private final OutputStream outputStream;

    private byte addressDevice = 10;
    private byte readCommand = 56;
//private byte readCommand = 4;

    private byte writeCommand = 57;
    private int countBytes = 8;

    private AddressSpace addressSpace;
    private int addressSpaceNumber = 0;

    public BluetoothConnectedThread(BluetoothSocket socket, AddressSpace addressSpace) {
        this.addressSpace = addressSpace;
        Log.i(LOG_TAG, String.valueOf(this.addressSpace.getAddressSpaceNumber()));
        Log.i(LOG_TAG, String.valueOf(addressSpace.getAddressSpaceNumber()));
        this.socket = socket;
        InputStream inputStream = null;
        OutputStream outputStream = null;

        // Get the input and output streams, using temp objects because
        // member streams are final
        try {
            inputStream = socket.getInputStream();
            outputStream = socket.getOutputStream();
//            Log.i(LOG_TAG,"get Streams");
        } catch (IOException e) { Log.i(LOG_TAG,"don't get Streams");}

        this.inputStream = inputStream;
        this.outputStream = outputStream;
//        Log.i(LOG_TAG,"here");
    }

    public void run() {
        byte[] buffer = new byte[8];  // buffer store for the stream
//        buffer[0] = 1;
//        buffer[1] = 2;
//        buffer[2] = 3;
//        buffer[3] = 4;
//        buffer[4] = 5;
//        buffer[5] = 6;
//        buffer[6] = 7;
//        buffer[7] = 8;
        int bytes = 100; // bytes returned from read()
//        int count = 0;
//        // Keep listening to the InputStream until an exception occurs
//        while (count < 200) {
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            try {
//                mmOutStream.write(buffer);
//            } catch (IOException e) {}
//            count++;
//        }



        while (true) {
            try {
                // Read from the InputStream
//                    Log.i(LOG_TAG,"read answer");
                bytes = inputStream.read(buffer);
                // Send the obtained bytes to the UI activity
//                    mHandler.obtainMessage(MESSAGE_READ, bytes, -1, buffer)
//                            .sendToTarget();
                int intByte = 0;
                for (int i = 0; i < bytes; i++) {
                    if (buffer[i] < 0) intByte = (buffer [i] + 256); else intByte = buffer[i];
                    Log.i(LOG_TAG, String.valueOf(intByte));
                }
                statusConnecting = true;
                Log.i(LOG_TAG,"readed");
            } catch (IOException e) {
                Log.i(LOG_TAG,e.toString());
                break;
            }
        }
    }

    /* Call this from the main activity to send data to the remote device */
    public void write(byte[] bytes) {
        byte[] bytesToSend = new byte[countBytes];
        byte[] bytesToCreateCRC = new byte[countBytes - 2];
        bytesToSend[0] = addressDevice;
        bytesToSend[1] = readCommand;
//        bytesToSend[2] = 6;
        bytesToSend[2] = 62;
//        bytesToSend[3] = 32;
        bytesToSend[3] = 0;
        bytesToSend[4] = 0;
        bytesToSend[5] = 0;

//        byte[] bytesToSend = new byte[countBytes];
//        byte[] bytesToCreateCRC = new byte[countBytes - 2];
//        bytesToSend[0] = addressDevice;
//        bytesToSend[1] = writeCommand;
//        bytesToSend[2] = 0;
//        bytesToSend[3] = 0;
//        bytesToSend[4] = 0;
//        bytesToSend[5] = 1;
//        bytesToSend[6] = 0;
//        bytesToSend[7] = 1;
        for (int i = 0; i < bytesToCreateCRC.length; i++) {
            bytesToCreateCRC[i] = bytesToSend[i];
        }

//        Log.i(LOG_TAG, CRC16.getCRC(bytesToCreateCRC));
        int crc = (CRC16.getCRC4(bytesToCreateCRC));
//        Log.i(LOG_TAG, String.valueOf(crc));
        int high = crc/256;
//        Log.i(LOG_TAG, String.valueOf(high));
        int low = crc - high*256;
//        Log.i(LOG_TAG, String.valueOf(low));
        bytesToSend[6] = (byte) (crc - high*256);
        bytesToSend[7] = (byte) high;


//        for (byte cByte : bytesToSend) {
//            Log.i(LOG_TAG, String.valueOf(cByte));
//        }

        try {
//            Log.i(LOG_TAG, bytesToSend.toString());
//            mmOutStream.write(bytes);
            outputStream.write(bytesToSend);
        } catch (IOException e) {Log.i(LOG_TAG,"bytes3123123"); }
    }

    public void write() {


        byte[] bytesToSend = new byte[countBytes];
        byte[] bytesToCreateCRC = new byte[countBytes - 2];
        bytesToSend[0] = addressDevice;
        bytesToSend[1] = readCommand;
//        bytesToSend[2] = 6;
//        bytesToSend[2] = 62;
        Log.i(LOG_TAG, String.valueOf(addressSpaceNumber));
        Log.i(LOG_TAG, String.valueOf(addressSpace.getAddressSpace(addressSpaceNumber)));
        addressSpace.setAddressSpace(addressSpaceNumber, 1);
        Log.i(LOG_TAG, String.valueOf(addressSpace.getAddressSpace(addressSpaceNumber)));
        bytesToSend[2] = (byte) addressSpace.getAddressSpace(addressSpaceNumber);
//        bytesToSend[3] = 32;
//        bytesToSend[2] = (byte) addressSpace.getAddressSpace(addresssSpaceNumber);
        bytesToSend[3] = 0;
        bytesToSend[4] = 0;
        bytesToSend[5] = 0;

//        byte[] bytesToSend = new byte[countBytes];
//        byte[] bytesToCreateCRC = new byte[countBytes - 2];
//        bytesToSend[0] = addressDevice;
//        bytesToSend[1] = writeCommand;
//        bytesToSend[2] = 0;
//        bytesToSend[3] = 0;
//        bytesToSend[4] = 0;
//        bytesToSend[5] = 1;
//        bytesToSend[6] = 0;
//        bytesToSend[7] = 1;
        for (int i = 0; i < bytesToCreateCRC.length; i++) {
            bytesToCreateCRC[i] = bytesToSend[i];
        }

//        Log.i(LOG_TAG, CRC16.getCRC(bytesToCreateCRC));
        int crc = (CRC16.getCRC4(bytesToCreateCRC));
//        Log.i(LOG_TAG, String.valueOf(crc));
        int high = crc/256;
//        Log.i(LOG_TAG, String.valueOf(high));
        int low = crc - high*256;
//        Log.i(LOG_TAG, String.valueOf(low));
        bytesToSend[6] = (byte) (crc - high*256);
        bytesToSend[7] = (byte) high;


//        for (byte cByte : bytesToSend) {
//            Log.i(LOG_TAG, String.valueOf(cByte));
//        }

        if (addressSpaceNumber < 15) {
            addressSpaceNumber++;
        } else addressSpaceNumber = 0;

        try {
//            Log.i(LOG_TAG, bytesToSend.toString());
//            mmOutStream.write(bytes);
            outputStream.write(bytesToSend);
        } catch (IOException e) {Log.i(LOG_TAG,"bytes3123123"); }
    }

    /* Call this from the main activity to shutdown the connection */
    public void cancel() {
        try {
            socket.close();
        } catch (IOException e) { }
    }

    public boolean checkStatusConnecting() {
        return statusConnecting;
    }
}
