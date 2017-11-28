package com.zhang.emulatorhook.fake;

import com.zhang.emulatorhook.bean.WIFIInfo;
import com.zhang.emulatorhook.util.PhoneRndTools;

public class FakeWIFI {
    public static WIFIInfo makeWIFI(){
        WIFIInfo wifiInfo = new WIFIInfo();
        wifiInfo.setBssid(PhoneRndTools.randomMac());
        wifiInfo.setMacAddress(PhoneRndTools.randomMac1());
        wifiInfo.setIp(PhoneRndTools.randomIPNum());
        wifiInfo.setSsid("WIFI");
        wifiInfo.toString();
        return wifiInfo;
    }

}
