package com.zhang.emulatorhook.bean;

import java.util.List;

public class GPSInfo{

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongtitude() {
        return longtitude;
    }

    public void setLongtitude(float longtitude) {
        this.longtitude = longtitude;
    }

    public int[] getCellLocation() {
        return cellLocation;
    }

    public void setCellLocation(int[] cellLocation) {
        this.cellLocation = cellLocation;
    }

    public float latitude;
    public float longtitude;
    public int[] cellLocation;

}
