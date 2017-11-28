package com.zhang.emulatorhook.hook;

import com.zhang.emulatorhook.fake.FakeCPU;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage.LoadPackageParam;

import java.io.File;

public class CPUHook {

    public static final String CPUPATHORIG = "/proc/cpuinfo";
    public static final String CPUPATHNEW = "/sdcard/cpuinfo";

    public CPUHook(LoadPackageParam loadPackageParam){
        XposedBridge.log("CPU hook is starting...");
        FakeCPU.makeFakeCPU();
        CPUHookMethod(loadPackageParam);
    }

    public void CPUHookMethod(LoadPackageParam loadPackageParam) {
        XposedBridge.hookAllConstructors(File.class, new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                super.beforeHookedMethod(param);
                replaceFileArgs(param);
            }
        });
        XposedBridge.log("hook all File constructors");

        XposedHelpers.findAndHookMethod("java.lang.Runtime", loadPackageParam.classLoader, "exec", String[].class, String[].class, File.class, new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                super.beforeHookedMethod(param);
                replaceFileArgs(param);
            }
        });
        XposedBridge.log("hook Runtime...");

        XposedBridge.hookMethod(XposedHelpers.findConstructorExact(ProcessBuilder.class, String[].class), new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                super.beforeHookedMethod(param);
                if(param.args[0] != null){
                    String[] strArr = (String[])param.args[0];
                    for(String str:strArr){
                        if(CPUPATHORIG.equals(str)){
                            strArr[1] = CPUPATHNEW;
                        }
                    }
                    param.args[0] = strArr;
                }

            }
        });

        XposedHelpers.findAndHookMethod("java.util.regex.Pattern", loadPackageParam.classLoader, "matcher", CharSequence.class, new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                super.beforeHookedMethod(param);
                if(param.args.length == 1){
                    if(CPUPATHORIG.equals(param.args[0])){
                        param.args[0] = CPUPATHNEW;
                    }
                }
            }
        });

    }

    public static void replaceFileArgs(XC_MethodHook.MethodHookParam param){
        if(param.args.length == 1){
            if(CPUPATHORIG.equals(param.args[0])){
                param.args[0] = CPUPATHNEW;
            }
        }else if (param.args.length == 2 && !File.class.isInstance(param.args[0])){
            for(int i=0; i<2; i++){
                if(CPUPATHORIG.equals(param.args[i])){
                    param.args[i] = CPUPATHNEW;
                }
            }
        }
    }


}
