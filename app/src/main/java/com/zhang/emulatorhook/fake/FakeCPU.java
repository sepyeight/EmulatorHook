package com.zhang.emulatorhook.fake;

import com.zhang.emulatorhook.bean.CPUInfo;
import com.zhang.emulatorhook.bean.ProcessInfo;
import com.zhang.emulatorhook.util.SDcardWrite;

import java.util.ArrayList;
import java.util.List;

public class FakeCPU {
    public static void makeFakeCPU(){
        List<ProcessInfo> processInfoList = new ArrayList<>();
        ProcessInfo processInfo = new ProcessInfo();
        processInfo.setBogoMIPS("38.40");
        processInfo.setCpu_architecture("8");
        processInfo.setCpu_implementer("0x51");
        processInfo.setProcessor("0");
        processInfo.setFeatures("fp asimd evtstrm aes pmull sha1 sha2 crc32");
        processInfo.setCpu_variant("0xa");
        processInfo.setCpu_part("0x801");
        processInfo.setCpu_revision("4");
        processInfoList.add(processInfo);

        ProcessInfo processInfo1 = new ProcessInfo();
        processInfo1.setBogoMIPS("38.40");
        processInfo1.setCpu_architecture("8");
        processInfo1.setCpu_implementer("0x51");
        processInfo1.setProcessor("1");
        processInfo1.setFeatures("fp asimd evtstrm aes pmull sha1 sha2 crc32");
        processInfo1.setCpu_variant("0xa");
        processInfo1.setCpu_part("0x801");
        processInfo1.setCpu_revision("4");
        processInfoList.add(processInfo1);

        ProcessInfo processInfo2 = new ProcessInfo();
        processInfo2.setBogoMIPS("38.40");
        processInfo2.setCpu_architecture("8");
        processInfo2.setCpu_implementer("0x51");
        processInfo2.setProcessor("2");
        processInfo2.setFeatures("fp asimd evtstrm aes pmull sha1 sha2 crc32");
        processInfo2.setCpu_variant("0xa");
        processInfo2.setCpu_part("0x801");
        processInfo2.setCpu_revision("4");
        processInfoList.add(processInfo2);

        ProcessInfo processInfo3 = new ProcessInfo();
        processInfo3.setBogoMIPS("38.40");
        processInfo3.setCpu_architecture("8");
        processInfo3.setCpu_implementer("0x51");
        processInfo3.setProcessor("3");
        processInfo3.setFeatures("fp asimd evtstrm aes pmull sha1 sha2 crc32");
        processInfo3.setCpu_variant("0xa");
        processInfo3.setCpu_part("0x801");
        processInfo3.setCpu_revision("4");
        processInfoList.add(processInfo3);

        ProcessInfo processInfo4 = new ProcessInfo();
        processInfo4.setBogoMIPS("38.40");
        processInfo4.setCpu_architecture("8");
        processInfo4.setCpu_implementer("0x51");
        processInfo4.setProcessor("4");
        processInfo4.setFeatures("fp asimd evtstrm aes pmull sha1 sha2 crc32");
        processInfo4.setCpu_variant("0xa");
        processInfo4.setCpu_part("0x800");
        processInfo4.setCpu_revision("1");
        processInfoList.add(processInfo4);

        ProcessInfo processInfo5 = new ProcessInfo();
        processInfo5.setBogoMIPS("38.40");
        processInfo5.setCpu_architecture("8");
        processInfo5.setCpu_implementer("0x51");
        processInfo5.setProcessor("5");
        processInfo5.setFeatures("fp asimd evtstrm aes pmull sha1 sha2 crc32");
        processInfo5.setCpu_variant("0xa");
        processInfo5.setCpu_part("0x8000");
        processInfo5.setCpu_revision("1");
        processInfoList.add(processInfo5);

        ProcessInfo processInfo6 = new ProcessInfo();
        processInfo6.setBogoMIPS("38.40");
        processInfo6.setCpu_architecture("8");
        processInfo6.setCpu_implementer("0x51");
        processInfo6.setProcessor("6");
        processInfo6.setFeatures("fp asimd evtstrm aes pmull sha1 sha2 crc32");
        processInfo6.setCpu_variant("0xa");
        processInfo6.setCpu_part("0x8000");
        processInfo6.setCpu_revision("1");
        processInfoList.add(processInfo6);

        ProcessInfo processInfo7 = new ProcessInfo();
        processInfo7.setBogoMIPS("38.40");
        processInfo7.setCpu_architecture("8");
        processInfo7.setCpu_implementer("0x51");
        processInfo7.setProcessor("7");
        processInfo7.setFeatures("fp asimd evtstrm aes pmull sha1 sha2 crc32");
        processInfo7.setCpu_variant("0xa");
        processInfo7.setCpu_part("0x8000");
        processInfo7.setCpu_revision("1");
        processInfoList.add(processInfo7);

        CPUInfo cpuInfo = new CPUInfo();
        cpuInfo.setProcessor("AArch64 Processor rev 4 (aarch64)");
        cpuInfo.setProcessInfoList(processInfoList);
        cpuInfo.setHardware("Qualcomm Technologies, Inc MSM8998");

        SDcardWrite.writeToSdCard("/cpuinfo", cpuInfo.toString());
    }

}
