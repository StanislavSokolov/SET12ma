package com.example.set12ma.ui.main;

import android.os.Parcel;
import android.os.Parcelable;

public class SpaceSetting implements Parcelable {

    public SpaceSetting() {
    }

    protected SpaceSetting(Parcel in) {
    }

    public static final Creator<SpaceSetting> CREATOR = new Creator<SpaceSetting>() {
        @Override
        public SpaceSetting createFromParcel(Parcel in) {
            return new SpaceSetting(in);
        }

        @Override
        public SpaceSetting[] newArray(int size) {
            return new SpaceSetting[size];
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
