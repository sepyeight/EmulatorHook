package com.zhang.emulatorhook.hook;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.Display;
import com.zhang.emulatorhook.bean.GPUInfo;
import com.zhang.emulatorhook.fake.FakeGPU;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;
import de.robv.android.xposed.callbacks.XCallback;

public class GPUHook {


    public GPUHook(XC_LoadPackage.LoadPackageParam loadPackageParam) {
        GPUInfo gpuInfo = FakeGPU.makeARMGPU();
        GPUInfoHook(loadPackageParam, gpuInfo);
        XposedBridge.log("GPU hook is starting... ");
    }

    public void GPUInfoHook(XC_LoadPackage.LoadPackageParam loadPkgParam, final GPUInfo gpuInfo) {

        //verder renderer
        try {
            XposedHelpers.findAndHookMethod("com.google.android.gles_jni.GLImpl", loadPkgParam.classLoader, "glGetString", Integer.TYPE, new XC_MethodHook() {

                @Override
                protected void beforeHookedMethod(XC_MethodHook.MethodHookParam param) throws Throwable {
                    //super.beforeHookedMethod(param);
                    if (param.args[0] != null) {
                        if (param.args[0].equals(Integer.valueOf(7936))) {
                            param.setResult(gpuInfo.getVender());
                        }
                        if (param.args[0].equals(Integer.valueOf(7937))) {
                            param.setResult(gpuInfo.getRenderer());
                        }
                    }
                }

            });
        } catch (Exception e) {
            XposedBridge.log("HOOK GPU failure" + e.getMessage());
        }

        //dpi
        try {
            XposedHelpers.findAndHookMethod("android.view.Display", loadPkgParam.classLoader, "getMetrics", DisplayMetrics.class, new XC_MethodHook(XCallback.PRIORITY_LOWEST) {

                @Override
                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    super.afterHookedMethod(param);
                    final int dpi = Integer.parseInt(gpuInfo.getDensity());
                    DisplayMetrics metrics = (DisplayMetrics) param.args[0];
                    metrics.densityDpi = dpi;

                }

            });
        } catch (Exception e) {
            XposedBridge.log("Fake DPI ERROR: " + e.getMessage());
        }

        try {
            XposedHelpers.findAndHookMethod("android.view.Display", loadPkgParam.classLoader, "getRealMetrics", DisplayMetrics.class, new XC_MethodHook(XCallback.PRIORITY_LOWEST) {

                @Override
                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    super.afterHookedMethod(param);
                    final int dpi = Integer.parseInt(gpuInfo.getDensity());
                    DisplayMetrics metrics = (DisplayMetrics) param.args[0];
                    metrics.densityDpi = dpi;

                }

            });
        } catch (Exception e) {

        }
        //modify resolution method 1
        XposedHelpers.findAndHookMethod("android.view.Display", loadPkgParam.classLoader, "getWidth", new XC_MethodHook() {
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                super.afterHookedMethod(param);
                param.setResult(gpuInfo.getWidth());
            }
        });

        XposedHelpers.findAndHookMethod("android.view.Display", loadPkgParam.classLoader, "getHeight", new XC_MethodHook() {
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                super.afterHookedMethod(param);
                param.setResult(gpuInfo.getHeight());
            }
        });


        //modify resolution method 2
        XposedHelpers.findAndHookMethod(Display.class, "getMetrics", DisplayMetrics.class, new XC_MethodHook(XCallback.PRIORITY_LOWEST) {
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                final int  width = gpuInfo.getWidth();
                DisplayMetrics metrics = (DisplayMetrics) param.args[0];
                metrics.widthPixels = width ;

            }
        });
        XposedHelpers.findAndHookMethod(Display.class, "getMetrics", DisplayMetrics.class, new XC_MethodHook(XCallback.PRIORITY_LOWEST) {
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                final int  height = gpuInfo.getHeight();

                DisplayMetrics metrics = (DisplayMetrics) param.args[0];
                metrics.heightPixels = height ;
            }
        });


        //modify resolution method 3
        XposedHelpers.findAndHookMethod(Resources.class,"getDisplayMetrics", new XC_MethodHook() {
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                super.afterHookedMethod(param);
                if (DisplayMetrics.class.isInstance(param.getResult())){
                    DisplayMetrics metrics = (DisplayMetrics) param.getResult();
                    metrics.widthPixels = gpuInfo.getWidth();
                    metrics.heightPixels = gpuInfo.getHeight();
                    param.setResult(metrics);
                }

            }
        });

    }

}
