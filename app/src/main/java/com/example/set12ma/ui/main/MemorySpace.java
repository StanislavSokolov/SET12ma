package com.example.set12ma.ui.main;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class MemorySpace implements Parcelable {

    private ArrayList<byte[]> memorySpaceArrayList;
    int memorySpaceByteSize = 4096;
    boolean readyFlag = false;

    public boolean isReadyFlag() {
        return readyFlag;
    }

    public void setReadyFlag(boolean readyFlag) {
        this.readyFlag = readyFlag;
    }

    public int getMemorySpaceArrayList() {
        return memorySpaceArrayList.size();
    }

    public byte[] getMemorySpaceByte(int number) {
        return memorySpaceArrayList.get(number);
    }

    public int getMemorySpaceByteSize() {
        return memorySpaceByteSize;
    }

    public void setMemorySpaceArrayListByte(byte[] memorySpaceByte) {
        memorySpaceArrayList.add(memorySpaceByte);
    }

    public void setMemorySpaceByte() {
        if (!memorySpaceArrayList.isEmpty()) {
            memorySpaceArrayList = null;
        }
    }



    public MemorySpace() {
        memorySpaceArrayList = new ArrayList<>();
    }

    protected MemorySpace(Parcel in) {
//        byteArray = in.createByteArray();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<MemorySpace> CREATOR = new Creator<MemorySpace>() {
        @Override
        public MemorySpace createFromParcel(Parcel in) {
            return new MemorySpace(in);
        }

        @Override
        public MemorySpace[] newArray(int size) {
            return new MemorySpace[size];
        }
    };
}
