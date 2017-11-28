package com.zhang.emulatorhook;

import android.os.Build;
import android.support.annotation.RequiresApi;
import com.zhang.emulatorhook.hook.*;
import com.zhang.emulatorhook.util.ChAntHook;
import com.zhang.emulatorhook.util.DynamicHook;
import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class MainHook implements IXposedHookLoadPackage {
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam loadPackageParam) throws Throwable {
        XposedBridge.log("Hook start ... ");

        //动态生效
        new DynamicHook().HookTest(loadPackageParam);

        new CPUHook(loadPackageParam);
        new BaseHook(loadPackageParam);
        new GPUHook(loadPackageParam);
        new GPSHook(loadPackageParam);
        new NetOperatorHook(loadPackageParam);
        new WIFIHook(loadPackageParam);
        new ChAntHook().handleLoadPackage(loadPackageParam);
    }
}
