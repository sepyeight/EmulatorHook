package com.zhang.emulatorhook.bean;

public class WIFIInfo {
    public String bssid; //bssid
    public int ip; //本机ip
    public String macAddress; //mac地址
    public String ssid; //热点名称

    public String getBssid() {
        return bssid;
    }

    public void setBssid(String bssid) {
        this.bssid = bssid;
    }

    public int getIp() {
        return ip;
    }

    public void setIp(int ip) {
        this.ip = ip;
    }

    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    public String getSsid() {
        return ssid;
    }

    public void setSsid(String ssid) {
        this.ssid = ssid;
    }

    @Override
    public String toString() {
        return "WIFIInfo{" +
                "bssid='" + bssid + '\'' +
                ", ip='" + ip + '\'' +
                ", macAddress='" + macAddress + '\'' +
                ", ssid='" + ssid + '\'' +
                '}';
    }
}
