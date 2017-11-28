package com.zhang.emulatorhook.hook;

import android.content.ContentResolver;
import android.os.Build;
import android.provider.Settings;
import com.zhang.emulatorhook.bean.BaseInfo;
import com.zhang.emulatorhook.fake.FackBase;
import de.robv.android.xposed.XC_MethodHook;

import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

import java.lang.reflect.Member;


public class BaseHook {

    public BaseHook(XC_LoadPackage.LoadPackageParam loadPackageParam){
        BaseInfo baseInfo = FackBase.getInstance();

        if ("".equals(loadPackageParam.packageName)){
            return;
        }
        hookAll(baseInfo,loadPackageParam);
    }

    public void hookMethod(final String className, final ClassLoader classLoader, final String methodName, final String result){
        XposedHelpers.findAndHookMethod(className, classLoader, methodName, new XC_MethodHook() {
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                super.afterHookedMethod(param);
                param.setResult(result);
                XposedBridge.log("result is " + result);
            }
        });
    }

    /**
     *
     * @param baseInfo
     */
    private void hookAll(final BaseInfo baseInfo, XC_LoadPackage.LoadPackageParam loadPackageParam) {


        hookMethod("android.telephony.TelephonyManager", loadPackageParam.classLoader, "getDeviceId", baseInfo.getImei());
        hookMethod("android.telephony.TelephonyManager", loadPackageParam.classLoader,"getSubscriberId", baseInfo.getImsi());
        hookMethod("android.bluetooth.BluetoothAdapter", loadPackageParam.classLoader,"getAddress", baseInfo.getBluemac());
        hookMethod("android.bluetooth.BluetoothDevice", loadPackageParam.classLoader,"getAddress", baseInfo.getBluemac());
        hookMethod("android.os.Build", loadPackageParam.classLoader,"getRadioVersion", baseInfo.getRadioVersion());
        //修改field值
        try {
            XposedHelpers.findField(Build.class,"BOARD").set(null,baseInfo.getBoard());
            XposedHelpers.findField(android.os.Build.class, "SERIAL").set(null, baseInfo.getSerial()); //串口序列号
            XposedHelpers.findField(android.os.Build.class, "BRAND").set(null, baseInfo.getBrand()); // 手机品牌
            XposedHelpers.findField(Build.class, "CPU_ABI").set(null, baseInfo.getCpu_abi());
            XposedHelpers.findField(Build.class, "CPU_ABI2").set(null, baseInfo.getCpu_abi2());
            XposedHelpers.findField(Build.class, "DEVICE").set(null, baseInfo.getDevice());
            XposedHelpers.findField(Build.class, "DISPLAY").set(null, baseInfo.getDisplay());
            XposedHelpers.findField(Build.class, "FINGERPRINT").set(null, baseInfo.getFingerprint());
            XposedHelpers.findField(Build.class, "HARDWARE").set(null, baseInfo.getHardware());
            XposedHelpers.findField(Build.class, "ID").set(null, baseInfo.getId());
            XposedHelpers.findField(Build.class, "MANUFACTURER").set(null, baseInfo.getManufacturer());
            XposedHelpers.findField(Build.class, "MODEL").set(null, baseInfo.getModel());
            XposedHelpers.findField(Build.class, "PRODUCT").set(null, baseInfo.getProduct());
            XposedHelpers.findField(Build.class, "BOOTLOADER").set(null, baseInfo.getBootloader()); //主板引导程序
            XposedHelpers.findField(Build.class, "HOST").set(null, baseInfo.getHost());  // 设备主机地址
            XposedHelpers.findField(Build.class, "TAGS").set(null, baseInfo.getTags());  //描述build的标签
            XposedHelpers.findField(Build.class, "TYPE").set(null, baseInfo.getType()); //设备版本类型
            XposedHelpers.findField(Build.VERSION.class, "INCREMENTAL").set(null, baseInfo.getIncremental()); //源码控制版本号
            XposedHelpers.findField(android.os.Build.VERSION.class, "RELEASE").set(null, baseInfo.getRelease());
            XposedHelpers.findField(android.os.Build.VERSION.class, "SDK").set(null, baseInfo.getSdk());
            XposedHelpers.findField(android.os.Build.VERSION.class, "CODENAME").set(null, "REL"); //写死就行 这个值为固定
            XposedHelpers.findField(Build.class, "TIME").set(null, Integer.parseInt(baseInfo.getBuildtime()));  // 固件时间build

        } catch (Throwable e)
        {
            XposedBridge.log("修改 Build 失败!" + e.getMessage());
        }
       try {

            XposedHelpers.findAndHookMethod("android.os.SystemProperties", loadPackageParam.classLoader, "get", String.class, new XC_MethodHook() {
                @Override
                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    super.afterHookedMethod(param);
                    String baseBand = (String) param.args[0];
                    if("gsm.version.baseband".equals(baseBand)||"no message".equals(baseBand)){
                        param.setResult(baseInfo.getBaseBand());
                    }
                }
            });


            XposedHelpers.findAndHookMethod(android.provider.Settings.Secure.class, "getString", ContentResolver.class, String.class, new XC_MethodHook() {
                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    if (param.args[1].equals(Settings.Secure.ANDROID_ID)){
                        param.setResult(baseInfo.getAndroid_id());
                    }

                }

            });
        } catch (Throwable e) {
            XposedBridge.log("修改 androidid 失败!" + e.getMessage());
        }

        Class<?> cls = null;
        try {
            cls = Class.forName("android.os.SystemProperties");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        if(cls != null){
            for (Member mem : cls.getDeclaredMethods()) {
                XposedBridge.hookMethod(mem, new XC_MethodHook() {

                    @Override
                    protected void beforeHookedMethod(MethodHookParam param)
                            throws Throwable {
                        // TODO Auto-generated method stub
                        super.beforeHookedMethod(param);
                        // 用户的KEY
                        if (param.args.length > 0 && param.args[0] != null && param.args[0].equals("ro.build.description")) {
                            param.setResult(baseInfo.getDiscription());
                        }
                    }
                });
            }
        }
    }



}
