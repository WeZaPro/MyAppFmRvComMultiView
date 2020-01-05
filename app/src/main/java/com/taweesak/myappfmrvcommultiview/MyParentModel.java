package com.taweesak.myappfmrvcommultiview;

import android.os.Parcel;
import android.os.Parcelable;

public class MyParentModel implements Parcelable {

    double rate;
    int image;
    String country;
    String setTextText;

    public MyParentModel() {
    }

    public MyParentModel(double rate) {
        this.rate = rate;
    }

    public MyParentModel(double rate, int image, String country,String setTextText) {
        this.rate = rate;
        this.image = image;
        this.country = country;
        this.setTextText = setTextText;
    }

    protected MyParentModel(Parcel in) {
        rate = in.readDouble();
        image = in.readInt();
        country = in.readString();
    }

    public static final Creator<MyParentModel> CREATOR = new Creator<MyParentModel>() {
        @Override
        public MyParentModel createFromParcel(Parcel in) {
            return new MyParentModel(in);
        }

        @Override
        public MyParentModel[] newArray(int size) {
            return new MyParentModel[size];
        }
    };

    public double getRate() {
        return rate;
    }

    public int getImage() {
        return image;
    }

    public String getCountry() {
        return country;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeDouble(rate);
        parcel.writeInt(image);
        parcel.writeString(country);
    }
}
