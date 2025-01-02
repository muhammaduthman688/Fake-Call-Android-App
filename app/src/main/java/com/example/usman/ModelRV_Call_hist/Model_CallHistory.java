package com.example.usman.ModelRV_Call_hist;

import android.graphics.Bitmap;

public class Model_CallHistory {

    Bitmap pic;
    String caller_name,caller_number,time;
    int call_duration;

    public Model_CallHistory(Bitmap pic, String caller_name, String caller_number, int call_duration, String time) {
        this.pic = pic;
        this.caller_name = caller_name;
        this.caller_number = caller_number;
        this.call_duration = call_duration;
        this.time = time;
    }

    public Model_CallHistory(String name, String number, int callDuration, Bitmap imageBitmap) {
    }


//    public Model_CallHistory(String caller_name, String caller_number, Bitmap imageBitmap, int call_duration) {
//    }

    public Bitmap getPic() {
        return pic;
    }

    public void setPic(Bitmap pic) {
        this.pic = pic;
    }

    public String getCaller_name() {
        return caller_name;
    }

    public void setCaller_name(String caller_name) {
        this.caller_name = caller_name;
    }

    public String getCaller_number() {
        return caller_number;
    }

    public void setCaller_number(String caller_number) {
        this.caller_number = caller_number;
    }

    public int getCall_duration() {
        return call_duration;
    }

    public void setCall_duration(int call_duration) {
        this.call_duration = call_duration;
    }

    public String getTime() {
        return time;
    }

    public void setDate(String date) {
        this.time = date;
    }
}
