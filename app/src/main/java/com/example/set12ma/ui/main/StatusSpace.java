package com.example.set12ma.ui.main;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

public class StatusSpace implements Parcelable {

    private boolean statusLoadToFlesh = false;
    private boolean statusLoadToDevice = false;

    public boolean isStatusLoadToFlesh() {
        return statusLoadToFlesh;
    }

    public void setStatusLoadToFlesh(boolean statusLoadToFlesh) {
        this.statusLoadToFlesh = statusLoadToFlesh;
    }

    public boolean isStatusLoadToDevice() {
        return statusLoadToDevice;
    }

    public void setStatusLoadToDevice(boolean statusLoadToDevice) {
        this.statusLoadToDevice = statusLoadToDevice;
    }

    private int addressOfDevice = 0;
    public int getAddressOfDevice() {
        return addressOfDevice;
    }
    public void setAddressOfDevice(int addressOfDevice) {
        this.addressOfDevice = addressOfDevice;
    }

    private boolean readyFlagToLoad = false;
    private boolean readyFlagToStart = false;
    public boolean isReadyFlagToLoad() {
        return readyFlagToLoad;
    }
    public void setReadyFlagToLoad(boolean readyFlagToLoad) {
        this.readyFlagToLoad = readyFlagToLoad;
    }
    public boolean isReadyFlagToStart() {
        return readyFlagToStart;
    }
    public void setReadyFlagToStart(boolean readyFlagToStart) {
        this.readyFlagToStart = readyFlagToStart;
    }


    private String device = "";
    public String getDevice() {
        return device;
    }
    public void setDevice(String device) {
        this.device = device;
    }

    public StatusSpace() {
    }

    public StatusSpace(Parcel in) {
    }

    public static final Creator<StatusSpace> CREATOR = new Creator<StatusSpace>() {
        @Override
        public StatusSpace createFromParcel(Parcel in) {
            return new StatusSpace(in);
        }

        @Override
        public StatusSpace[] newArray(int size) {
            return new StatusSpace[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }
}
