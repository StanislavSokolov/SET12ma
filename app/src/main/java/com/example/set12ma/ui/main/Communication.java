package com.example.set12ma.ui.main;

import android.util.Log;

import java.io.IOException;

public class Communication {

    private SpaceStatus spaceStatus;
    private SpaceSetting spaceSetting;
    private SpaceAddress spaceAddress;
    private SpaceMemory spaceMemory;
    private SpaceFileLogs spaceFileLogs;

    public Communication(SpaceStatus spaceStatus, SpaceSetting spaceSetting, SpaceAddress spaceAddress, SpaceMemory spaceMemory, SpaceFileLogs spaceFileLogs) {
        this.spaceStatus = spaceStatus;
        this.spaceSetting = spaceSetting;
        this.spaceAddress = spaceAddress;
        this.spaceMemory = spaceMemory;
        this.spaceFileLogs = spaceFileLogs;
    }

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

    byte[] bytesToSend = null;
    byte[] bytesToCreateCRC = null;
    private int previousByte = 0;
    private int currentByte = 0;
    private int nextByte = 0;
    private int maxValueUnsuccessfulSending = 10;

    public byte[] write() {
        bytesToSend = new byte[12];
        bytesToCreateCRC = new byte[10];
        bytesToSend[0] = ADDRESS_DEVICE;
        bytesToSend[1] = WRITE;
        boolean b = true;
        while (b) {
            if ((currentByte > 47) & (currentByte < 96)) {
                if (spaceSetting.getOutArrayList().get(currentByte - 48).isEnable()) {
                    bytesToSend[2] = (byte) spaceSetting.getOutArrayList().get(currentByte - 48).getRegister();
                    b = false;
                } else {
                    if (currentByte < 95) currentByte++; else currentByte = 144;
                }
            } else if ((currentByte > 143) & (currentByte < 208)) {
                if (spaceSetting.getTkArrayList().get(currentByte - 144).isEnable()) {
                    bytesToSend[2] = (byte) spaceSetting.getTkArrayList().get(currentByte - 144).getRegister();
                    b = false;
                } else {
                    // не сможем выйти из цикла;
                    // здесь надо запрещать передачу данных, если cuttentByte == 207
                    // и возвращаться в менеджер потоков и обнулить значения контролирующих
                    // положение дел переменных, чтобы начать новую передачу.
                    if (currentByte < 206) currentByte++; else currentByte = 48;
                }
            }
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

        Log.i("LOG_TAG_1", "Номер регистра " + bytesToSend[2] + " WRITE");
        return bytesToSend;
    }

    public byte[] write(int register, int value) {
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

        Log.i("LOG_TAG_1", "Номер регистра " + register + " WRITE");

        return bytesToSend;
    }

    public byte[] read() {
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
        Log.i("LOG_TAG_1", "Номер регистра " + currentByte + " READ");
        return bytesToSend;
    }

    public byte[] initLoad() {
        bytesToSend = new byte[12];
        bytesToCreateCRC = new byte[bytesToSend.length - 2];
        bytesToSend[0] = ADDRESS_DEVICE;
        bytesToSend[1] = INIT_LOAD;
        byte[] bytesToSendBuf;
        bytesToSendBuf = determineDownloadMode();
        Log.i("LOG_TAG_1", String.valueOf(bytesToSendBuf[0]));
        Log.i("LOG_TAG_1", String.valueOf(bytesToSendBuf[1]));
        Log.i("LOG_TAG_1", String.valueOf(bytesToSendBuf[2]));
        Log.i("LOG_TAG_1", String.valueOf(bytesToSendBuf[3]));
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

        Log.i("LOG_TAG_1", "START INIT LOAD");
        return bytesToSend;
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

    public byte[] load() {
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
        Log.i("LOG_TAG_1", "Загрузка в память");
        return bytesToSend;
    }

    public byte[] startToLoad() {
        Log.i("LOG_TAG_1", "startToLoad");
        bytesToSend = new byte[18];
        bytesToCreateCRC = new byte[16];
        bytesToSend[0] = ADDRESS_DEVICE;
        bytesToSend[1] = EXTEND;
        byte[] bytesToSendBuf;
        bytesToSendBuf = determineDownloadMode();
        Log.i("LOG_TAG_1", String.valueOf(bytesToSendBuf[0]));
        Log.i("LOG_TAG_1", String.valueOf(bytesToSendBuf[1]));
        Log.i("LOG_TAG_1", String.valueOf(bytesToSendBuf[2]));
        Log.i("LOG_TAG_1", String.valueOf(bytesToSendBuf[3]));
        Log.i("LOG_TAG_1", String.valueOf(bytesToSendBuf[4]));
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
        return bytesToSend;
    }

    public byte[] downloadLogs(int address, int length) {
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
        Log.i("LOG_TAG_1", "DOWNLOAD");
        return bytesToSend;
    }
}
