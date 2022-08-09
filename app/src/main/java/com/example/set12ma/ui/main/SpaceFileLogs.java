package com.example.set12ma.ui.main;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class SpaceFileLogs implements Parcelable {

    private ArrayList<byte[]> spaceFileLogsArrayList;
    private int spaceFileLogsByteLength = 4096;

    public SpaceFileLogs() {
        spaceFileLogsArrayList = new ArrayList<>();
    }

    public int getSpaceFileLogsArrayListSize() {
        return spaceFileLogsArrayList.size();
    }

    public byte[] getSpaceFileLogsByte(int number) {
        return spaceFileLogsArrayList.get(number);
    }

    public int getSpaceFileLogsLength(int number) {
        return spaceFileLogsArrayList.get(number).length;
    }

    public int getSpaceFileLogsLength() {
        return spaceFileLogsByteLength;
    }

    public void setSpaceFileLogsArrayListByte(byte[] spaceFileLogsBytes) {
        spaceFileLogsArrayList.add(spaceFileLogsBytes);
    }

    public void setSpaceFileLogsArrayListByte(int i, byte[] memorySpaceBytes) {
        spaceFileLogsArrayList.add(i, memorySpaceBytes);
    }

    public void setSpaceFileLogsByte() {
        if (!spaceFileLogsArrayList.isEmpty()) {
            spaceFileLogsArrayList = new ArrayList<>();
        }
    }












    protected SpaceFileLogs(Parcel in) {
    }

    public static final Creator<SpaceFileLogs> CREATOR = new Creator<SpaceFileLogs>() {
        @Override
        public SpaceFileLogs createFromParcel(Parcel in) {
            return new SpaceFileLogs(in);
        }

        @Override
        public SpaceFileLogs[] newArray(int size) {
            return new SpaceFileLogs[size];
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
