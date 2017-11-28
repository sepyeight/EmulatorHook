package com.zhang.emulatorhook.util;

import android.os.Environment;
import de.robv.android.xposed.XposedBridge;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SDcardWrite {
    public static final String APKDIR = "emulatorhook";

    /**
     *判断sdcard是否存在
     */

    public static boolean isSdCardExist() {

        boolean isExist = false;
        try {
            isExist = Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);
        } catch (Exception e) {
            e.printStackTrace();
            XposedBridge.log("SD卡读取失败，e ：" + e.getMessage());
        }
        XposedBridge.log("SD card is ：" + isExist);

        return isExist;
    }

    /**
     *获取sd卡根目录路径
     */
    public static String getSdCardPath() {
        boolean exist = isSdCardExist();
        String sdpath = "";
        if (exist) {
            sdpath = Environment.getExternalStorageDirectory().getAbsolutePath();
        } else {
            XposedBridge.log("SDCard 不适用....");
        }
        return sdpath;
    }


    /**
     * 创建文件
     */
    public static void writeToSdCard(String path, String info) {

        File file = new File(getSdCardPath() + path);
        if(file.exists()){
            file.delete();
        }

        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            bufferedWriter.write(info);

            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();

        }


    }
}
