package com.taweesak.myappfmrvcommultiview;

public class MyChidModel extends MyParentModel{
    public static final int TYPE_A = 0;
    public static final int TYPE_B = 1;

    double result;
    int Type;


    public MyChidModel() {
    }

    public MyChidModel(double rate, double inputData) {
        super(rate);
        this.result = rate*inputData;
    }

    public MyChidModel(double rate, int image, String country, String setTextText,int Type) {
        super(rate, image, country, setTextText);
        this.Type = Type;
    }

    public double getResult() {
        return result;
    }

    public int getType() {
        return Type;
    }

    public String getSetTextText() {
        return setTextText;
    }
}
