package com.zhang.emulatorhook.fake;

import com.zhang.emulatorhook.bean.GPSInfo;

import java.util.Random;

public class FakeGPS {
    public static GPSInfo makeGPS(){
        GPSInfo gpsInfo = new GPSInfo();
        gpsInfo.setLatitude(new Random().nextFloat());
        gpsInfo.setLongtitude(new Random().nextFloat());
        gpsInfo.setCellLocation(new int[]{new Random().nextInt(10000), new Random().nextInt(10000)});
        return gpsInfo;
    }

}
