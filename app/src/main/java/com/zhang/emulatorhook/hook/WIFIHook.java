package com.zhang.emulatorhook.hook;

import com.zhang.emulatorhook.bean.WIFIInfo;
import com.zhang.emulatorhook.fake.FakeWIFI;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class WIFIHook {
    public WIFIHook(XC_LoadPackage.LoadPackageParam loadPackageParam) {
        hookMethod(loadPackageParam, FakeWIFI.makeWIFI());
        XposedBridge.log("hook wifi...");
    }

    public void hookMethod(XC_LoadPackage.LoadPackageParam loadPackageParam, final WIFIInfo wifiInfo) {
        hook("android.net.wifi.WifiInfo", loadPackageParam, "getMacAddress", wifiInfo.getMacAddress());
        // 内网IP
        hook("android.net.wifi.WifiInfo", loadPackageParam, "getIpAddress", wifiInfo.getIp());
        hook("android.net.wifi.WifiInfo", loadPackageParam, "getSSID", wifiInfo.getSsid());
        hook("android.net.wifi.WifiInfo", loadPackageParam, "getBSSID",wifiInfo.getBssid());// 基站的信号强度
    }

    public void hook(String className, XC_LoadPackage.LoadPackageParam loadPackageParam, String methodName, final String result){
        XposedHelpers.findAndHookMethod(className, loadPackageParam.classLoader, methodName, new XC_MethodHook() {
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                super.afterHookedMethod(param);
                param.setResult(result);
            }

        });
    }
    public void hook(String className, XC_LoadPackage.LoadPackageParam loadPackageParam, String methodName, final int result){
        XposedHelpers.findAndHookMethod(className, loadPackageParam.classLoader, methodName, new XC_MethodHook() {
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                super.afterHookedMethod(param);
                param.setResult(result);
            }

        });
    }
}
