package com.example.set12ma.ui.main;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class SpaceMemory implements Parcelable {

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

    public void setMemorySpaceArrayListByte(byte[] memorySpaceBytes) {
        memorySpaceArrayList.add(memorySpaceBytes);
    }

    public void setMemorySpaceArrayListByte(int i, byte[] memorySpaceByte) {
        memorySpaceArrayList.add(i, memorySpaceByte);
    }

    public void setMemorySpaceByte() {
        if (!memorySpaceArrayList.isEmpty()) {
            memorySpaceArrayList = new ArrayList<>();
        }
    }

    public SpaceMemory() {
        memorySpaceArrayList = new ArrayList<>();
    }

    protected SpaceMemory(Parcel in) {
//        byteArray = in.createByteArray();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<SpaceMemory> CREATOR = new Creator<SpaceMemory>() {
        @Override
        public SpaceMemory createFromParcel(Parcel in) {
            return new SpaceMemory(in);
        }

        @Override
        public SpaceMemory[] newArray(int size) {
            return new SpaceMemory[size];
        }
    };
}
