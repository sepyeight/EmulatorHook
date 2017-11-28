package com.zhang.emulatorhook.hook;

import android.net.NetworkInfo;
import com.zhang.emulatorhook.bean.NetOperatorInfo;
import com.zhang.emulatorhook.fake.FakeNetOperator;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class NetOperatorHook {
    public NetOperatorHook(XC_LoadPackage.LoadPackageParam loadPackageParam) {
        hookMethod(loadPackageParam, new FakeNetOperator().makeNetOperator());

    }

    public void hookMethod(XC_LoadPackage.LoadPackageParam loadPackageParam, final NetOperatorInfo netOperatorInfo){
        //电话号码
        hookTelephone("android.telephony.TelephonyManager", loadPackageParam, "getLine1Number",netOperatorInfo.getPhoneNum());
        //手机卡序列号
        hookTelephone("android.telephony.TelephonyManager", loadPackageParam, "getSimSerialNumber", netOperatorInfo.getPhoneCardNum());
        //网络运营商类型
        hookTelephone("android.telephony.TelephonyManager", loadPackageParam, "getNetworkOperator", netOperatorInfo.getNetwrokOperator());
        // 网络类型名
        hookTelephone("android.telephony.TelephonyManager", loadPackageParam, "getNetworkOperatorName", netOperatorInfo.getCarrier());
        // 运营商
        hookTelephone("android.telephony.TelephonyManager", loadPackageParam, "getSimOperator", netOperatorInfo.getNetwrokOperator());
        // 运营商名字
        hookTelephone("android.telephony.TelephonyManager", loadPackageParam, "getSimOperatorName", netOperatorInfo.getCarrier());
        // 国家iso代码
        hookTelephone("android.telephony.TelephonyManager", loadPackageParam, "getNetworkCountryIso",netOperatorInfo.getNationalISONum());
        // 手机卡国家
        hookTelephone("android.telephony.TelephonyManager", loadPackageParam, "getSimCountryIso", netOperatorInfo.getCountryCode());
        //联网方式
        hookTelephone("android.net.NetworkInfo", loadPackageParam, "getType", Integer.parseInt(netOperatorInfo.getType()));
        // 网络类型
        hookTelephone("android.telephony.TelephonyManager", loadPackageParam, "getNetworkType", Integer.parseInt(netOperatorInfo.getNetType()));
        // 手机类型
        hookTelephone("android.telephony.TelephonyManager", loadPackageParam, "getPhoneType", Integer.parseInt(netOperatorInfo.getPhoneType()));
        // 手机卡状态
        hookTelephone("android.telephony.TelephonyManager", loadPackageParam, "getSimState", Integer.parseInt(netOperatorInfo.getSimState()));
        //系统版本号
        hookTelephone("android.telephony.TelephonyManager", loadPackageParam, "getDeviceSoftwareVersion", netOperatorInfo.getDeviceversion());
    }

    public void hookTelephone(String hookclass, XC_LoadPackage.LoadPackageParam loadPackageParam, String funcName, final String value){
        XposedHelpers.findAndHookMethod(hookclass, loadPackageParam.classLoader, funcName, new XC_MethodHook() {
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                super.afterHookedMethod(param);
                param.setResult(value);
            }
        });
    }

    public void hookTelephone(String hookclass, XC_LoadPackage.LoadPackageParam loadPackageParam, String funcName, final int value){
        XposedHelpers.findAndHookMethod(hookclass, loadPackageParam.classLoader, funcName, new XC_MethodHook() {
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                super.afterHookedMethod(param);
                param.setResult(value);
            }
        });
    }
}
