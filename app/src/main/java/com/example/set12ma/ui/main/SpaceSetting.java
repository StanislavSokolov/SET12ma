package com.example.set12ma.ui.main;

import android.content.SharedPreferences;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import java.util.ArrayList;

public class SpaceSetting implements Parcelable {

    private ArrayList<ADC> adcArrayList;
    private ArrayList<InOut> tkArrayList;
    private ArrayList<InOut> inArrayList;
    private ArrayList<InOut> outArrayList;

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    public void setSharedPreferences(String teg, int value) {
        editor.putInt(teg, value);
        editor.apply();
    }

    public void setSharedPreferences(String teg, String value) {
        editor.putString(teg, value);
        editor.apply();
    }

    public ArrayList<ADC> getAdcArrayList() {
        return adcArrayList;
    }

    public void setAdcArrayList(ArrayList<ADC> adcArrayList) {
        this.adcArrayList = adcArrayList;
    }

    public ArrayList<InOut> getTkArrayList() {
        return tkArrayList;
    }

    public void setTkArrayList(ArrayList<InOut> tkArrayList) {
        this.tkArrayList = tkArrayList;
    }

    public ArrayList<InOut> getInArrayList() {
        return inArrayList;
    }

    public void setInArrayList(ArrayList<InOut> inArrayList) {
        this.inArrayList = inArrayList;
    }

    public ArrayList<InOut> getOutArrayList() {
        return outArrayList;
    }

    public void setOutArrayList(ArrayList<InOut> outArrayList) {
        this.outArrayList = outArrayList;
    }

    public SpaceSetting(SharedPreferences sharedPreferences) {
        adcArrayList = new ArrayList<>();
        for (int j = 0; j < 3; j++) {
            for (int i = 0; i < 16; i++) {
                if (i < 8) adcArrayList.add(new ADC("Channel " + i, 1024, 1024, i, 96 + i + j*16));
                else adcArrayList.add(new ADC("Channel " + i, 1024, 1024, i - 8, 96 + i + j*16));
            }
        }

        tkArrayList = new ArrayList<>();
        for (int j = 0; j < 8; j++) {
            for (int i = 0; i < 8; i++) {
                tkArrayList.add(new InOut("Channel " + i, 144 + i + j*8));
            }
        }

        inArrayList = new ArrayList<>();
        for (int j = 0; j < 3; j++) {
            for (int i = 0; i < 16; i++) {
                inArrayList.add(new InOut("Channel " + i, i + j*16));
            }
        }

        outArrayList = new ArrayList<>();
        for (int j = 0; j < 3; j++) {
            for (int i = 0; i < 16; i++) {
                outArrayList.add(new InOut("Channel " + i, 48 + i + j*16));
            }

        }

        this.sharedPreferences = sharedPreferences;
        editor = sharedPreferences.edit();
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
