package com.zhang.emulatorhook.fake;

import com.zhang.emulatorhook.bean.GPUInfo;

public class FakeGPU {

    public static GPUInfo makeARMGPU(){
        GPUInfo gpuInfo = new GPUInfo();

        gpuInfo.setRenderer("Mali-T628");
        gpuInfo.setVender("ARM");
        gpuInfo.setGpuVersion("OpenGL ES 3.0");
        gpuInfo.setWidth(1080);
        gpuInfo.setHeight(1920);
        gpuInfo.setDensity("480");
        return gpuInfo;
    }

    public static GPUInfo makeAdrenoGPU(){
        GPUInfo gpuInfo = new GPUInfo();

        gpuInfo.setRenderer("Adreno (TM) 111");
        gpuInfo.setVender("UFU");
        gpuInfo.setGpuVersion("OpenGL ES 3.0");
        gpuInfo.setWidth(560);
        gpuInfo.setHeight(320);
        gpuInfo.setDensity("500");
        return gpuInfo;
    }
}
