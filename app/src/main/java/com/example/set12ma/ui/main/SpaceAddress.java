package com.example.set12ma.ui.main;

import android.os.Parcel;
import android.os.Parcelable;

import java.lang.annotation.ElementType;
import java.util.LinkedList;
import java.util.Queue;

public class SpaceAddress implements Parcelable {
    private int[] addressSpace;
    private Queue<ElementQueue> queue;

    public ElementQueue getElementQueue() {
        return queue.remove();
    }

    public void setElementQueue(ElementQueue elementQueue) {
        queue.add(elementQueue);
    }

    public boolean isEmptyQueue(){
        return queue.isEmpty();
    }

    public SpaceAddress(int addressSpaceNumber) {
        addressSpace = new int[addressSpaceNumber];
        queue = new LinkedList<>();
    }

    protected SpaceAddress(Parcel in) {
        addressSpace = in.createIntArray();
    }

    public static final Creator<SpaceAddress> CREATOR = new Creator<SpaceAddress>() {
        @Override
        public SpaceAddress createFromParcel(Parcel in) {
//            int[] addressSpace = in.readIntArray(addressSpace);
            return new SpaceAddress(in);
        }

        @Override
        public SpaceAddress[] newArray(int size) {
            return new SpaceAddress[size];
        }
    };

    public int getAddressSpace(int number) {
        return addressSpace[number];
    }

    public void setAddressSpace(int number, int data) {
        addressSpace[number] = data;
    }

    public int getAddressSpaceNumber() {
        return addressSpace.length;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeIntArray(addressSpace);
    }
}

