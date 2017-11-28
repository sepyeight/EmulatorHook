package com.zhang.emulatorhook.bean;

public class ProcessInfo {
    public String processor;
    public String bogoMIPS;
    public String features;
    public String cpu_implementer;
    public String cpu_architecture;
    public String cpu_variant;
    public String cpu_part;
    public String cpu_revision;

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public String getBogoMIPS() {
        return bogoMIPS;
    }

    public void setBogoMIPS(String bogoMIPS) {
        this.bogoMIPS = bogoMIPS;
    }

    public String getFeatures() {
        return features;
    }

    public void setFeatures(String features) {
        this.features = features;
    }

    public String getCpu_implementer() {
        return cpu_implementer;
    }

    public void setCpu_implementer(String cpu_implementer) {
        this.cpu_implementer = cpu_implementer;
    }

    public String getCpu_architecture() {
        return cpu_architecture;
    }

    public void setCpu_architecture(String cpu_architecture) {
        this.cpu_architecture = cpu_architecture;
    }

    public String getCpu_variant() {
        return cpu_variant;
    }

    public void setCpu_variant(String cpu_variant) {
        this.cpu_variant = cpu_variant;
    }

    public String getCpu_part() {
        return cpu_part;
    }

    public void setCpu_part(String cpu_part) {
        this.cpu_part = cpu_part;
    }

    public String getCpu_revision() {
        return cpu_revision;
    }

    public void setCpu_revision(String cpu_revision) {
        this.cpu_revision = cpu_revision;
    }

    @Override
    public String toString() {
        return "processor       : " + processor + "\r\n"+
                "BogoMIPS        : " + bogoMIPS + "\r\n"+
                "Features        : " + features + "\r\n" +
                "CPU implementer : " + cpu_implementer + "\r\n" +
                "CPU architecture: " + cpu_architecture + "\r\n" +
                "CPU variant     : " + cpu_variant + "\r\n" +
                "CPU part        : " + cpu_part + "\r\n" +
                "CPU revision    : " + cpu_revision +"\r\n\r\n";
    }
}
