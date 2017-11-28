package com.zhang.emulatorhook.bean;

public class GPUInfo {
    private String renderer; // 渲染器 Mali-T628
    private String vender; //供应商 ARM
    private String gpuVersion; //OpenGl版本 OpenGL ES 3.0
    private int width; //分辨率 1080X1920
    private int height;
    private String density; //ppi 480dpi

    public String getRenderer() {
        return renderer;
    }

    public void setRenderer(String renderer) {
        this.renderer = renderer;
    }

    public String getVender() {
        return vender;
    }

    public void setVender(String vender) {
        this.vender = vender;
    }

    public String getGpuVersion() {
        return gpuVersion;
    }

    public void setGpuVersion(String gpuVersion) {
        this.gpuVersion = gpuVersion;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getDensity() {
        return density;
    }

    public void setDensity(String density) {
        this.density = density;
    }

    @Override
    public String toString() {
        return "GPUInfo{" +
                "renderer='" + renderer + '\'' +
                ", vender='" + vender + '\'' +
                ", gpuVersion='" + gpuVersion + '\'' +
                ", width='" + width + '\'' +
                ", height='" + height + '\'' +
                ", density='" + density + '\'' +
                '}';
    }
}
