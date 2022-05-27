package com.example.set12ma.ui.main;

import android.os.Parcel;
import android.os.Parcelable;

public class AddressSpace implements Parcelable {
    private int[] addressSpace;

    public AddressSpace(int addressSpaceNumber) {
        addressSpace = new int[addressSpaceNumber];
    }

    protected AddressSpace(Parcel in) {
        addressSpace = in.createIntArray();
    }

    public static final Creator<AddressSpace> CREATOR = new Creator<AddressSpace>() {
        @Override
        public AddressSpace createFromParcel(Parcel in) {
//            int[] addressSpace = in.readIntArray(addressSpace);
            return new AddressSpace(in);
        }

        @Override
        public AddressSpace[] newArray(int size) {
            return new AddressSpace[size];
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

