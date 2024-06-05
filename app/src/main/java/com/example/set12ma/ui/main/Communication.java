package com.example.set12ma.ui.main;

import android.util.Log;
import android.view.View;
import android.widget.Toast;
import com.example.set12ma.R;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Communication {

    private static final String LOG_TAG = "Communication";

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
    private final int INIT_ARTIX = 100;
    private final int READ = 56;
    private final int WRITE = 57;
    private final int INIT_LOAD = 58;
    private final int LOAD = 51;
    private final int TFLASH = 55;
    private final int EXTEND = 60;
    private final int UPLOAD = 52;
    private int BYTE_UPLOAD = 2048;
    private final int COUNT = 170;

//    for Artix
    private final int BUFFER_SIZE = 16;

    byte[] bytesToInitArtix = null;

    byte[] bytesToSend = null;
    byte[] bytesToCreateCRC = null;
    private int previousByte = 0;
    private int currentByte = 0;
    private int nextByte = 0;
    private int maxValueUnsuccessfulSending = 100;

    private volatile int currentCommand = INIT_LOAD;
    private boolean statusError = true;

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

    int countTest = 0;

    public void prepare(int deviceType) {
        if (deviceType == 0) currentByte = 48; else currentByte = 0;

        statusError = true;

        answerTest = "";
        countWaitConnection = 0;

        countReceivedMessage = 0;

        latchInit = true;
        latchQueue = false;
        latchLoad = false;
        latchFinish = false;
        latchDownloadLog = false;

        counterAttemptsToConection = 0;
        counterUnsuccessfulSending = 0;



        countByte = 0;

        statusAnswer = false; // true - ответ получен
    }

//    public byte[] communicationToARTIX() {
//        byte[] buffer = null;
//        if (!spaceAddress.isEmptyByteQueue()) {
//            buffer = spaceAddress.getByteQueue();
//        }
//        return buffer;
//    }

    public byte[] communicationToARTIX() {
        byte[] buffer0 = null;
        if (!spaceAddress.isEmptyByteQueue()) {
            byte[] buffer = spaceAddress.getByteQueue();
            if (buffer != null) {
                switch (getCommand()) {
                    case INIT_ARTIX:
                        if (buffer.length == BUFFER_SIZE) {
                            // проверяем корректность сообщения по идентификатору
                            byte[] bytesToCreateCRC = new byte[buffer.length - 2];
                            for (int i = 0; i < bytesToCreateCRC.length; i++) {
                                bytesToCreateCRC[i] = buffer[i];
                            }
                            crc = (CRC16.getCRC4(bytesToCreateCRC));
                            high = crc / 256;
                            if ((buffer[bytesToCreateCRC.length] == (byte) (crc - high * 256)) & (buffer[bytesToCreateCRC.length + 1] == (byte) high)) {
                                statusError = false;
                            } else {
                                statusError = true;
                            }
                            statusAnswer = true;
                        }
                    break;
                    case READ:
                        if (buffer.length == BUFFER_SIZE) {
//                            spaceAddress.setAddressSpace(100, 10 + currentByte);
                            if ((buffer[0] == ADDRESS_DEVICE) & (buffer[1] == READ)) {
                                // проверяем корректность сообщения по идентификатору
                                byte[] bytesToCreateCRC = new byte[buffer.length - 2];
                                for (int i = 0; i < bytesToCreateCRC.length; i++) {
                                    bytesToCreateCRC[i] = buffer[i];
                                }
                                crc = (CRC16.getCRC4(bytesToCreateCRC));
                                high = crc / 256;
                                if ((buffer[bytesToCreateCRC.length] == (byte) (crc - high * 256)) & (buffer[bytesToCreateCRC.length + 1] == (byte) high)) {
//                                    if (!spaceStatus.isReadyFlagRecordingInitialValues()) {
                                        int highByte = buffer[4];
                                        int lowByte = buffer[5];
                                        if (highByte < 0) {
                                            if (lowByte < 0) spaceAddress.setAddressSpace(currentByte, lowByte + 256 + highByte * 256);
                                            else spaceAddress.setAddressSpace(currentByte, lowByte + highByte * 256);
//                                            spaceAddress.setAddressSpace(currentByte, - lowByte);
                                        } else {
                                            if (lowByte < 0) lowByte = lowByte + 256;
                                            spaceAddress.setAddressSpace(currentByte, lowByte + highByte * 256);
//                                            spaceAddress.setAddressSpace(currentByte, 6);
                                        }

//                                        if (highByte < 0) lowByte = lowByte - 2 * lowByte;
//                                        if (highByte < 0) spaceAddress.setAddressSpace(currentByte, -lowByte + highByte * 256);
//                                        else if (lowByte < 0) spaceAddress.setAddressSpace(currentByte, lowByte);
//                                        else spaceAddress.setAddressSpace(currentByte, lowByte + highByte * 256);
//                                        spaceAddress.setAddressSpace(currentByte, lowByte + highByte * 256);
//                                        spaceAddress.setAddressSpace(currentByte, lowByte);
                                        if (currentByte == 47) {
                                            nextByte = 96;
                                        }

                                        if (currentByte == 143) {
                                            nextByte = 0;
                                        }

                                        if ((currentByte == 47) || (currentByte == 143))
                                            currentByte = nextByte;
                                        else currentByte++;
//                                    } else {
//                                        currentByte = 48;
//                                    }
                                    statusError = false;
                                } else {
//                                    Log.i(LOG_TAG, "CRC не совпало");
                                    statusError = true;
                                }
                            } else {
//                                Log.i(LOG_TAG, "Не смогли идентифицировать сообщение");
                                statusError = true;
                            }
                        } else {
                            statusError = true;
                        }
                        statusAnswer = true;
                        break;
                    case WRITE:
                        if (buffer.length == BUFFER_SIZE) {
                            if ((buffer[0] == ADDRESS_DEVICE) & (buffer[1] == WRITE)) {
                                // проверяем корректность сообщения по идентификатору
                                byte[] bytesToCreateCRC = new byte[buffer.length - 2];
                                for (int i = 0; i < bytesToCreateCRC.length; i++) {
                                    bytesToCreateCRC[i] = buffer[i];
                                }
                                crc = (CRC16.getCRC4(bytesToCreateCRC));
                                high = crc / 256;
                                if ((buffer[bytesToCreateCRC.length] == (byte) (crc - high * 256)) & (buffer[bytesToCreateCRC.length + 1] == (byte) high)) {
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
//                                    Log.i(LOG_TAG, "CRC не совпало");
                                    statusError = true;
                                }
                            } else {
//                                Log.i(LOG_TAG, "Не смогли идентифицировать сообщение");
                                statusError = true;
                            }
                        } else {
                            statusError = true;
                        }
                        statusAnswer = true;
                        break;
                    default:
                        break;
                }
            } else {
                statusError = true;
            }
        } else {
            if (statusAnswer) {
                if (latchInit) {
                    if (!statusError) {
                        latchInit = false;
                        spaceStatus.setReadyFlagToExchangeData(true);
                        spaceStatus.setStatusCommunication(1);
                        countWaitConnection = 0;
                        counterAttemptsToConection = 0;
                        statusAnswer = false;
                        setCommand(WRITE);
                        return writeArtix();
                    } else {
                        statusAnswer = false;
                    }
                } else {
                    if (counterUnsuccessfulSending < maxValueUnsuccessfulSending) {
                        if (statusError) {
                            counterUnsuccessfulSending = counterUnsuccessfulSending + 1;
                        } else {
                            counterUnsuccessfulSending = 0;
                        }
                        statusAnswer = false;
                        countWaitConnection = 0;
                        counterAttemptsToConection = 0;

                        if (spaceStatus.isReadyFlagRecordingInitialValues()) {
                            setCommand(WRITE);
                            return writeArtix();
                        } else {
                            if (!spaceAddress.isEmptyQueue()) {
                                if (!latchQueue) {
                                    previousByte = currentByte;
                                    latchQueue = true;
                                }
                                ElementQueue elementQueue = spaceAddress.getElementQueue();
                                setCommand(WRITE);
                                return writeArtix(elementQueue.getRegister(), elementQueue.getData());
                            } else {
                                if (latchQueue) {
                                    latchQueue = false;
                                    currentByte = previousByte;
                                }
                                setCommand(READ);
                                return readArtix();
                            }
                        }
                    } else {
                        spaceStatus.setReadyFlagToExchangeData(false);
                        spaceStatus.setDevice("");
                        spaceStatus.setReadyFlagRecordingInitialValues(false);
                        spaceStatus.setStatusCommunication(2);
                    }
                }
            } else {
                if (latchInit) {
                    // надо добавить проверку о том, известно ли нам, с каким устройством мы общаемся, тогда не надо повторно использовать функцию initArtix.
                    // иначе повторно к устройству подключиться не удается.
                    setCommand(INIT_ARTIX);
                    if (counterAttemptsToConection < 20) {
                        if (countWaitConnection < 100000) {
                            countWaitConnection = countWaitConnection + 1;
                        } else {
                            countWaitConnection = 0;
                            buffer0 = initArtix(counterAttemptsToConection);
                            counterAttemptsToConection = counterAttemptsToConection + 1;
                        }
                    } else {
//                        spaceStatus.setReadyFlagToExchangeData(false);
//                        spaceStatus.setDevice("");;
//                        spaceStatus.setReadyFlagRecordingInitialValues(false);
                        spaceStatus.setStatusCommunication(10);
                    }
                } else {
                    if (spaceStatus.isReadyFlagToExchangeData()) {
//                    if (getCommand() == READ) {
                        if (counterAttemptsToConection < 10) {
                            if (countWaitConnection < 100000) {
                                countWaitConnection = countWaitConnection + 1;
                            } else {
                                countWaitConnection = 0;
                                counterAttemptsToConection = counterAttemptsToConection + 1;
                            }
                        } else {
                            spaceStatus.setReadyFlagToExchangeData(false);
                            spaceStatus.setDevice("");
                            spaceStatus.setReadyFlagRecordingInitialValues(false);
                            spaceStatus.setStatusCommunication(4);
                        }
//                    }
                    }
                }


            }
        }
        return buffer0;
    }

    public byte[] writeArtix() {
        bytesToSend = new byte[BUFFER_SIZE];
        bytesToCreateCRC = new byte[BUFFER_SIZE - 2];
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
        bytesToSend[2] = (byte) currentByte;
        bytesToSend[3] = 0;
        int data = spaceAddress.getAddressSpace(currentByte);
        int high = data / 256;
        bytesToSend[4] = (byte) high;
        bytesToSend[5] = (byte) (data - high * 256);
        bytesToSend[6] = 0;
        bytesToSend[7] = 0;
        bytesToSend[8] = 0;
        bytesToSend[9] = 0;
        bytesToSend[10] = 0;
        bytesToSend[11] = 0;
        bytesToSend[12] = 0;
        bytesToSend[13] = 0;

        for (int i = 0; i < bytesToCreateCRC.length; i++) {
            bytesToCreateCRC[i] = bytesToSend[i];
        }
        int crc = (CRC16.getCRC4(bytesToCreateCRC));
        high = crc / 256;
        bytesToSend[BUFFER_SIZE - 2] = (byte) (crc - high * 256);
        bytesToSend[BUFFER_SIZE - 1] = (byte) high;
        return bytesToSend;
    }

    public byte[] writeArtix(int register, int value) {
        bytesToSend = new byte[BUFFER_SIZE];
        bytesToCreateCRC = new byte[BUFFER_SIZE - 2];
        bytesToSend[0] = ADDRESS_DEVICE;
        bytesToSend[1] = WRITE;
        bytesToSend[2] = (byte) register;
        bytesToSend[3] = 0;
        int high = value / 256;
        bytesToSend[4] = (byte) high;
        bytesToSend[5] = (byte) (value - high * 256);;
        bytesToSend[6] = 0;
        bytesToSend[7] = 0;
        bytesToSend[8] = 0;
        bytesToSend[9] = 0;
        bytesToSend[10] = 0;
        bytesToSend[11] = 0;
        bytesToSend[12] = 0;
        bytesToSend[13] = 0;

        for (int i = 0; i < bytesToCreateCRC.length; i++) {
            bytesToCreateCRC[i] = bytesToSend[i];
        }
        int crc = (CRC16.getCRC4(bytesToCreateCRC));
        high = crc / 256;
        bytesToSend[BUFFER_SIZE - 2] = (byte) (crc - high * 256);
        bytesToSend[BUFFER_SIZE - 1] = (byte) high;
        return bytesToSend;
    }

    public byte[] readArtix() {
        bytesToSend = new byte[16];
        bytesToCreateCRC = new byte[14];
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
//        if (currentByte < 255) currentByte++; else currentByte = 0;
        bytesToSend[2] = 0;
        bytesToSend[3] = (byte) currentByte;
        bytesToSend[4] = 0;
        bytesToSend[5] = 0;
        bytesToSend[6] = 0;
        bytesToSend[7] = 0;
        bytesToSend[8] = 0;
        bytesToSend[9] = 0;
        bytesToSend[10] = 0;
        bytesToSend[11] = 0;
        bytesToSend[12] = 0;
        bytesToSend[13] = 0;
        for (int i = 0; i < bytesToCreateCRC.length; i++) {
            bytesToCreateCRC[i] = bytesToSend[i];
        }
        int crc = (CRC16.getCRC4(bytesToCreateCRC));
        int high = crc / 256;
        bytesToSend[BUFFER_SIZE - 2] = (byte) (crc - high * 256);
        bytesToSend[BUFFER_SIZE - 1] = (byte) high;
        return bytesToSend;
    }

    public byte[] initArtix(int counterAttemptsToConection) {
        bytesToSend = null;
        if (counterAttemptsToConection < 16) {
            bytesToInitArtix = new byte[BUFFER_SIZE];
            bytesToCreateCRC = new byte[BUFFER_SIZE - 2];

            bytesToInitArtix[0] = ADDRESS_DEVICE;
            bytesToInitArtix[1] = INIT_ARTIX;
            bytesToInitArtix[2] = (byte) 48;

            for (int i = 0; i < bytesToCreateCRC.length; i++) {
                bytesToCreateCRC[i] = bytesToInitArtix[i];
            }
            int crc = (CRC16.getCRC4(bytesToCreateCRC));
            int high = crc / 256;
            bytesToInitArtix[BUFFER_SIZE - 2] = (byte) (crc - high * 256);
            bytesToInitArtix[BUFFER_SIZE - 1] = (byte) high;

            bytesToSend = new byte[1];
            bytesToSend[0] = bytesToInitArtix[counterAttemptsToConection];
        }
        return bytesToSend;
    }

    public int communicationToARTIXint() {
        byte[] buffer = null;
        if (!spaceAddress.isEmptyByteQueue()) {
            buffer = spaceAddress.getByteQueue();
            return buffer.length;
        }
        return 100;
    }

    public byte[] communication() {
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
                                        int highByte = bufferByte[3];
                                        int lowByte = bufferByte[2];
                                        if (lowByte < 0) lowByte = bufferByte[2] + 256;
                                        if (highByte < 0) lowByte = lowByte - 2 * lowByte;
                                        Log.i(LOG_TAG, String.valueOf(lowByte + highByte*256));
                                        spaceAddress.setAddressSpace(currentByte, lowByte + highByte*256);
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
                    case TFLASH:

                        Log.i(LOG_TAG, "count byte " + buffer.length + " TFLASH");

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
                            if ((bufferByte[0] == ADDRESS_DEVICE) & (bufferByte[1] == TFLASH)) {
                                Log.i(LOG_TAG, "Идентификатор корректен");
                                // проверяем корректность сообщения по идентификатору
                                byte[] bytesToCreateCRC = new byte[bufferByte.length - 4];
                                for (int i = 0; i < bytesToCreateCRC.length; i++) {
                                    bytesToCreateCRC[i] = bufferByte[i];
                                }
                                crc = (CRC16.getCRC4(bytesToCreateCRC));
                                high = crc / 256;
                                if ((bufferByte[bytesToCreateCRC.length] == (byte) (crc - high*256)) & (bufferByte[bytesToCreateCRC.length + 1] == (byte) high)) {
                                    Log.i(LOG_TAG, "CRC is good from FinishLoad");
                                    statusError = false;
                                } else {
                                    Log.i(LOG_TAG, "CRC is bed from FinishLoad");
                                }
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
                return null;
            } else {
                if (statusAnswer) {
                    countWaitConnection = 0;
                    counterAttemptsToConection = 0;
                    if (latchInit) {
                        spaceStatus.setReadyFlagToExchangeData(true);
                        spaceStatus.setStatusCommunication(1);
                    }
                    latchInit = false;
                    statusAnswer = false;

                    if (spaceStatus.isReadyFlagToLoadSoftware()) {
                        if (spaceStatus.isStatusProcessOfLoadingSoftware()) {
                            if (!latchLoad) {
                                setCommand(LOAD);
                                latchLoad = true;
                                return load();
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
                            return initLoad();
                        }
                    } else if (spaceStatus.isReadyFlagToUpdateSoftware()) {
                        spaceStatus.setReadyFlagToFinishOfLoadingSoftware(false);
                        if (!latchFinish) {
                            spaceStatus.setStatusProcessOfUpdatingSoftware(true);
                            String deviceSelected = spaceStatus.getDevice();
                            if (deviceSelected.equals("TMS2812")) {
                                setCommand(TFLASH);
                            } else if (deviceSelected.equals("SP2main")) {
                                setCommand(TFLASH);
                            } else {
                                setCommand(EXTEND);
                            }
                            latchFinish = true;
                            return startToLoad();
                        } else {
                            if (spaceStatus.isReadyFlagToFinishOfUpdatingSoftware()) {
                                latchFinish = false;
                                spaceStatus.setReadyFlagToUpdateSoftware(false);
                                spaceStatus.setStatusProcessOfUpdatingSoftware(false);
                                spaceStatus.setReadyFlagToLoadSoftware(false);
                                spaceStatus.setReadyFlagToFinishOfLoadingSoftware(false);
                                statusAnswer = true;
                            }
                        }
                    } else if (spaceStatus.isReadyFlagToDownloadLog()) {
                        if (!latchDownloadLog) {
                            if (countReceivedMessage == 0) {
                                spaceFileLogs.setSpaceFileLogsByte();
                            }
                            setCommand(UPLOAD);
                            latchDownloadLog = true;
                            BYTE_UPLOAD = spaceFileLogs.getSizeOfBlock();
                            return downloadLogs(spaceFileLogs.getStartOfRAM() + BYTE_UPLOAD*countReceivedMessage, BYTE_UPLOAD);
                        } else {
                            if (spaceStatus.isReadyFlagToFinishOfDownloadingLogs()) {
                                // ЦИКЛ ДЛЯ СЧИТЫВАНИЯ ЛОГОВ
                                spaceStatus.setReadyFlagToFinishOfDownloadingLogs(false);
                                latchDownloadLog = false;
                                Log.i(LOG_TAG, "Finish of downloadlog");
                                statusAnswer = true;
                                if (countReceivedMessage < spaceFileLogs.getLengthOfArray()/spaceFileLogs.getSizeOfBlock()) {
                                    countReceivedMessage = countReceivedMessage + 1;
                                    spaceStatus.setProgressBarDownload(countReceivedMessage);
                                } else {
                                    spaceStatus.setReadyFlagToDownloadLog(false);
                                    Log.i("strartt", "finish");
                                    countReceivedMessage = 0;
                                    Log.i("strartt", "Длинна записанная в SpaceFileLogs " + spaceFileLogs.getSpaceFileLogsArrayListSize());

//                                    logsToFile = new LogsToFile();
//                                    logsToFile.start();
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
                                return write();
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
//                                        currentByte = elementQueue.getRegister();
                                    Log.i(LOG_TAG, "SUPRIM");
                                    setCommand(WRITE);
                                    return write(elementQueue.getRegister(), elementQueue.getData());
                                } else {
                                    if (latchQueue) {
                                        latchQueue = false;
                                        currentByte = previousByte;
                                    }
                                    setCommand(READ);
                                    return read();
                                }
                            }
                        } else {
                            spaceStatus.setReadyFlagToExchangeData(false);
                            spaceStatus.setDevice("");
                            spaceStatus.setReadyFlagRecordingInitialValues(false);
                            spaceStatus.setStatusCommunication(2);
                        }
                    }
                } else {
                    if (latchInit) {
                        setCommand(READ);
                        if (counterAttemptsToConection < 10) {
                            if (countWaitConnection < 500000) {
                                countWaitConnection = countWaitConnection + 1;
                            } else {
                                countWaitConnection = 0;
                                counterAttemptsToConection = counterAttemptsToConection + 1;
                                return read();
                            }
                        } else {
                            spaceStatus.setReadyFlagToExchangeData(false);
                            spaceStatus.setDevice("");;
                            spaceStatus.setReadyFlagRecordingInitialValues(false);
                            spaceStatus.setStatusCommunication(3);
                            latchInit = false;
                        }
                    } if (spaceStatus.isReadyFlagToExchangeData()) {
                        if (getCommand() == READ) {
                            if (counterAttemptsToConection < 10) {
                                if (countWaitConnection < 500000) {
                                    countWaitConnection = countWaitConnection + 1;
                                } else {
                                    countWaitConnection = 0;
                                    counterAttemptsToConection = counterAttemptsToConection + 1;
                                }
                            } else {
                                spaceStatus.setReadyFlagToExchangeData(false);
                                spaceStatus.setDevice("");
                                spaceStatus.setReadyFlagRecordingInitialValues(false);
                                latchInit = false;
                                spaceStatus.setStatusCommunication(4);
                            }
                        }
                    }
                }
                return null;
            }
        }

    private synchronized int getCommand() { return currentCommand; }
    private synchronized void setCommand(int currentCommand) { this.currentCommand = currentCommand; }

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
        bytesToSend[2] = 0;
        bytesToSend[3] = 0;
        bytesToSend[4] = 10;
        bytesToSend[5] = 0;
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
        Log.i(LOG_TAG, String.valueOf(bytesToSend[0]));
        Log.i(LOG_TAG, String.valueOf(bytesToSend[1]));
        Log.i(LOG_TAG, String.valueOf(bytesToSend[2]));
        Log.i(LOG_TAG, String.valueOf(bytesToSend[3]));
        Log.i(LOG_TAG, String.valueOf(bytesToSend[4]));
        Log.i(LOG_TAG, String.valueOf(bytesToSend[5]));
        Log.i(LOG_TAG, String.valueOf(bytesToSend[6]));
        Log.i(LOG_TAG, String.valueOf(bytesToSend[7]));
        Log.i(LOG_TAG, String.valueOf(bytesToSend[8]));
        Log.i(LOG_TAG, String.valueOf(bytesToSend[9]));
        Log.i(LOG_TAG, String.valueOf(bytesToSend[10]));
        Log.i(LOG_TAG, String.valueOf(bytesToSend[11]));
        return bytesToSend;
    }

    private byte[] determineDownloadMode() {
        String deviceSelected = spaceStatus.getDevice();
        byte[] bytesToSendBuf = new byte[6];
        if (deviceSelected.equals("TMS2812")) {
            bytesToSendBuf[0] = 0;
            bytesToSendBuf[1] = 0;
            bytesToSendBuf[2] = 17;
            bytesToSendBuf[3] = 0;
            bytesToSendBuf[4] = 0;
            bytesToSendBuf[5] = TFLASH;
        } else if (deviceSelected.equals("SP2main")) {
            bytesToSendBuf[0] = 0;
            bytesToSendBuf[1] = 0;
            bytesToSendBuf[2] = 19;
            bytesToSendBuf[3] = 0;
            bytesToSendBuf[4] = 0;
            bytesToSendBuf[5] = TFLASH;
        } else if (deviceSelected.equals("SP2")) {
            bytesToSendBuf[0] = 0;
            bytesToSendBuf[1] = 0;
            bytesToSendBuf[2] = 0;
            bytesToSendBuf[3] = 0;
            bytesToSendBuf[4] = 6;
            bytesToSendBuf[5] = EXTEND;
        } else {
            bytesToSendBuf[0] = 0;
            bytesToSendBuf[1] = 0;
            bytesToSendBuf[2] = 0;
            bytesToSendBuf[3] = 0;
            bytesToSendBuf[4] = 10;
            bytesToSendBuf[5] = EXTEND;
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
        Log.i(LOG_TAG, "Загрузка в память");
        Log.i(LOG_TAG, String.valueOf(bytesToSend.length));
        return bytesToSend;
    }

    public byte[] startToLoad() {
        byte[] bytesToSendBuf;
        bytesToSendBuf = determineDownloadMode();
        if (bytesToSendBuf[5] == EXTEND) {
            bytesToSend = new byte[18];
            bytesToCreateCRC = new byte[16];
            bytesToSend[14] = bytesToSendBuf[4];
            bytesToSend[15] = (byte) spaceStatus.getAddressOfDevice();
        } else {
            bytesToSend = new byte[16];
            bytesToCreateCRC = new byte[14];
        }
        bytesToSend[0] = ADDRESS_DEVICE;
        bytesToSend[1] = bytesToSendBuf[5];
        bytesToSend[2] = 0;
        bytesToSend[3] = 0;
        bytesToSend[4] = 10;
        bytesToSend[5] = 0;
        bytesToSend[6] = bytesToSendBuf[0];
        bytesToSend[7] = bytesToSendBuf[1];
        bytesToSend[8] = bytesToSendBuf[2];
        bytesToSend[9] = bytesToSendBuf[3];
        int i = (spaceMemory.getMemorySpaceArrayListSize() - 1)* spaceMemory.getMemorySpaceByteLength() + spaceMemory.getMemorySpaceByteLength(spaceMemory.getMemorySpaceArrayListSize() - 1);
        int highH = i/16777216;
        bytesToSend[13] = (byte) highH;
        int highL = (i - (highH*16777216))/65536;
        bytesToSend[12] = (byte) highL;
        int lowH = (i - (highH*16777216) - (highL*65536))/256;
        bytesToSend[11] = (byte) lowH;
        int lowL = i - (highH*16777216) - (highL*65536) - (lowH*256);
        bytesToSend[10] = (byte) lowL;
        for (int j = 0; j < bytesToCreateCRC.length; j++) {
            bytesToCreateCRC[j] = bytesToSend[j];
        }
        int crc = (CRC16.getCRC4(bytesToCreateCRC));
        int high = crc / 256;
        bytesToSend[bytesToSend.length-2] = (byte) (crc - high * 256);
        bytesToSend[bytesToSend.length-1] = (byte) high;

        Log.i(LOG_TAG, "START TO LOAD");
        Log.i(LOG_TAG, String.valueOf(bytesToSend[0]));
        Log.i(LOG_TAG, String.valueOf(bytesToSend[1]));
        Log.i(LOG_TAG, String.valueOf(bytesToSend[2]));
        Log.i(LOG_TAG, String.valueOf(bytesToSend[3]));
        Log.i(LOG_TAG, String.valueOf(bytesToSend[4]));
        Log.i(LOG_TAG, String.valueOf(bytesToSend[5]));
        Log.i(LOG_TAG, String.valueOf(bytesToSend[6]));
        Log.i(LOG_TAG, String.valueOf(bytesToSend[7]));
        Log.i(LOG_TAG, String.valueOf(bytesToSend[8]));
        Log.i(LOG_TAG, String.valueOf(bytesToSend[9]));
        Log.i(LOG_TAG, String.valueOf(bytesToSend[10]));
        Log.i(LOG_TAG, String.valueOf(bytesToSend[11]));
        Log.i(LOG_TAG, String.valueOf(bytesToSend[12]));
        Log.i(LOG_TAG, String.valueOf(bytesToSend[13]));
        Log.i(LOG_TAG, String.valueOf(bytesToSend[14]));
        Log.i(LOG_TAG, String.valueOf(bytesToSend[15]));

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

        Log.i("LOG_TAG_1", String.valueOf(bytesToSend[0]));
        Log.i("LOG_TAG_1", String.valueOf(bytesToSend[1]));
        Log.i("LOG_TAG_1", String.valueOf(bytesToSend[2]));
        Log.i("LOG_TAG_1", String.valueOf(bytesToSend[3]));
        Log.i("LOG_TAG_1", String.valueOf(bytesToSend[4]));
        Log.i("LOG_TAG_1", String.valueOf(bytesToSend[5]));
        Log.i("LOG_TAG_1", String.valueOf(bytesToSend[6]));
        Log.i("LOG_TAG_1", String.valueOf(bytesToSend[7]));
        Log.i("LOG_TAG_1", String.valueOf(bytesToSend[8]));
        Log.i("LOG_TAG_1", String.valueOf(bytesToSend[9]));
        Log.i("LOG_TAG_1", String.valueOf(bytesToSend[10]));
        Log.i("LOG_TAG_1", String.valueOf(bytesToSend[11]));
        return bytesToSend;
    }
}
