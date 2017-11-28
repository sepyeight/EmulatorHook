package com.zhang.emulatorhook.bean;

import java.io.Serializable;

public class BaseInfo implements Serializable{
    private String imei;
    private String imsi;
    private String number;
    private String simserial;
    private String wifimac;
    private String bluemac;
    private String serial;
    private String brand;
    private String android_id;
    private String baseBand; //固件号
    private String radioVersion;
    private String board;
    private String cpu_abi;
    private String cpu_abi2;
    private String device;
    private String display;
    private String fingerprint;
    private String hardware;
    private String id;
    private String manufacturer;
    private String model;
    private String product;
    private String bootloader;
    private String host;
    private String tags;
    private String type;
    private String incremental;
    private String release;
    private String sdk;
    private String codename;
    private String buildtime;
    private String discription;

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public String getCpu_abi() {
        return cpu_abi;
    }

    public void setCpu_abi(String cpu_abi) {
        this.cpu_abi = cpu_abi;
    }

    public String getCpu_abi2() {
        return cpu_abi2;
    }

    public void setCpu_abi2(String cpu_abi2) {
        this.cpu_abi2 = cpu_abi2;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public String getFingerprint() {
        return fingerprint;
    }

    public void setFingerprint(String fingerprint) {
        this.fingerprint = fingerprint;
    }

    public String getHardware() {
        return hardware;
    }

    public void setHardware(String hardware) {
        this.hardware = hardware;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getBootloader() {
        return bootloader;
    }

    public void setBootloader(String bootloader) {
        this.bootloader = bootloader;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIncremental() {
        return incremental;
    }

    public void setIncremental(String incremental) {
        this.incremental = incremental;
    }

    public String getRelease() {
        return release;
    }

    public void setRelease(String release) {
        this.release = release;
    }

    public String getSdk() {
        return sdk;
    }

    public void setSdk(String sdk) {
        this.sdk = sdk;
    }

    public String getCodename() {
        return codename;
    }

    public void setCodename(String codename) {
        this.codename = codename;
    }

    public String getBuildtime() {
        return buildtime;
    }

    public void setBuildtime(String buildtime) {
        this.buildtime = buildtime;
    }

    public String getBoard() {
        return board;
    }

    public void setBoard(String board) {
        this.board = board;
    }

    public String getRadioVersion() {
        return radioVersion;
    }

    public void setRadioVersion(String radioVersion) {
        this.radioVersion = radioVersion;
    }

    public String getBaseBand() {
        return baseBand;
    }

    public void setBaseBand(String baseBand) {
        this.baseBand = baseBand;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getImsi() {
        return imsi;
    }

    public void setImsi(String imsi) {
        this.imsi = imsi;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getSimserial() {
        return simserial;
    }

    public void setSimserial(String simserial) {
        this.simserial = simserial;
    }

    public String getWifimac() {
        return wifimac;
    }

    public void setWifimac(String wifimac) {
        this.wifimac = wifimac;
    }

    public String getBluemac() {
        return bluemac;
    }

    public void setBluemac(String bluemac) {
        this.bluemac = bluemac;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getAndroid_id() {
        return android_id;
    }

    public void setAndroid_id(String android_id) {
        this.android_id = android_id;
    }

    @Override
    public String toString() {
        return "BaseInfo{" +
                "imei='" + imei + '\'' +
                ", imsi='" + imsi + '\'' +
                ", number='" + number + '\'' +
                ", simserial='" + simserial + '\'' +
                ", wifimac='" + wifimac + '\'' +
                ", bluemac='" + bluemac + '\'' +
                ", serial='" + serial + '\'' +
                ", brand='" + brand + '\'' +
                ", android_id='" + android_id + '\'' +
                ", baseBand='" + baseBand + '\'' +
                ", radioVersion='" + radioVersion + '\'' +
                ", board='" + board + '\'' +
                ", cpu_abi='" + cpu_abi + '\'' +
                ", cpu_abi2='" + cpu_abi2 + '\'' +
                ", device='" + device + '\'' +
                ", display='" + display + '\'' +
                ", fingerprint='" + fingerprint + '\'' +
                ", hardware='" + hardware + '\'' +
                ", id='" + id + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", model='" + model + '\'' +
                ", product='" + product + '\'' +
                ", bootloader='" + bootloader + '\'' +
                ", host='" + host + '\'' +
                ", tags='" + tags + '\'' +
                ", type='" + type + '\'' +
                ", incremental='" + incremental + '\'' +
                ", release='" + release + '\'' +
                ", sdk='" + sdk + '\'' +
                ", codename='" + codename + '\'' +
                ", buildtime='" + buildtime + '\'' +
                ", discription='" + discription + '\'' +
                '}';
    }
}
