package com.zhang.emulatorhook.bean;

import java.io.Serializable;
import java.util.List;

public class CPUInfo implements Serializable{
    public String processor;
    public List<ProcessInfo> processInfoList;
    public String hardware;

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public List<ProcessInfo> getProcessInfoList() {
        return processInfoList;
    }

    public void setProcessInfoList(List<ProcessInfo> processInfoList) {
        this.processInfoList = processInfoList;
    }

    public String getHardware() {
        return hardware;
    }

    public void setHardware(String hardware) {
        this.hardware = hardware;
    }

    @Override
    public String toString() {
        return "Processor       : " + processor + "\r\n" +
                listProcessInfo(processInfoList) +
                "Hardware        : " + hardware + "\r\n";
    }

    public String listProcessInfo(List<ProcessInfo> processInfoList){
        String str = "\r\n";
        for(ProcessInfo processInfo:processInfoList){
            str += processInfo.toString();
        }
        return str;
    }
}
