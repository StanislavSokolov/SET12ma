package com.example.set12ma.ui.main;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import java.util.ArrayList;

public class MemorySpace implements Parcelable {

    private ArrayList<byte[]> memorySpaceArrayList;
    private int memorySpaceByteLength = 4096;

    public int getMemorySpaceArrayListSize() {
        return memorySpaceArrayList.size();
    }

    public byte[] getMemorySpaceByte(int number) {
        return memorySpaceArrayList.get(number);
    }

    public int getMemorySpaceByteLength(int number) {
        return memorySpaceArrayList.get(number).length;
    }

    public int getMemorySpaceByteLength() {
        return memorySpaceByteLength;
    }

    public void setMemorySpaceArrayListByte(byte[] memorySpaceByte) {
        memorySpaceArrayList.add(memorySpaceByte);
    }

    public void setMemorySpaceArrayListByte(int i, byte[] memorySpaceByte) {
        memorySpaceArrayList.add(i, memorySpaceByte);
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
