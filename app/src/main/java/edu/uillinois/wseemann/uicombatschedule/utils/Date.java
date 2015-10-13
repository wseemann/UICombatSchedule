package edu.uillinois.wseemann.uicombatschedule.utils;

import android.widget.TextView;

/**
 * Created by wseemann on 10/10/15.
 */
public class Date {

    private TextView mView;
    private String mDate;
    private String mInfo;

    public Date(String date, String info) {
        mDate = date;
        mInfo = info;
    }

    public TextView getView() {
        return mView;
    }

    public void setView(TextView mView) {
        this.mView = mView;
    }

    public String getDate() {
        return mDate;
    }

    public void setDate(String mDate) {
        this.mDate = mDate;
    }

    public String getInfo() {
        return mInfo;
    }

    public void setInfo(String mInfo) {
        this.mInfo = mInfo;
    }
}
