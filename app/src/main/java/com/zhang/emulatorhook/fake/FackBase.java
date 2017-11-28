package com.zhang.emulatorhook.fake;

import com.zhang.emulatorhook.bean.BaseInfo;
import com.zhang.emulatorhook.util.PhoneRndTools;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;

public class FackBase {

    public static BaseInfo getInstance(){
        BaseInfo baseInfo = new BaseInfo();
        baseInfo.setImei(PhoneRndTools.randomNum(15));
        baseInfo.setImsi(PhoneRndTools.randomNum(15));
        baseInfo.setNumber(PhoneRndTools.randomPhoneNum());
        baseInfo.setSimserial(PhoneRndTools.randomNum(20));
        baseInfo.setWifimac(PhoneRndTools.randomMac());
        baseInfo.setBluemac(PhoneRndTools.randomMac1());
        baseInfo.setAndroid_id(PhoneRndTools.randomABC(16));
        baseInfo.setSerial(PhoneRndTools.randomNum(19) + "a");
        baseInfo.setBrand("Huawei");
        baseInfo.setBaseBand("SCL23KDU1BNG3");
        baseInfo.setRadioVersion("REL");
        baseInfo.setBoard("msm8916");
        baseInfo.setCpu_abi("armeabi-v7a");
        baseInfo.setCpu_abi2("armeabi");
        baseInfo.setDevice("hwG750-T01");
        baseInfo.setDisplay("R7c_11_151207");
        baseInfo.setFingerprint("Huawei/G750-T01/hwG750-T01:4.2.2/HuaweiG750-T01/C00B152:user/ota-rel-keys,release-keys");
        baseInfo.setHardware("mt6592");
        baseInfo.setId("KTU84P");
        baseInfo.setManufacturer("HUAWEI");
        baseInfo.setModel("HUAWEI MATE 10 pro");
        baseInfo.setProduct("hwG750-T01");
        baseInfo.setBootloader("unknown");
        baseInfo.setHost("ubuntu-121-114");
        baseInfo.setTags("release-keys");
        baseInfo.setType("user");
        baseInfo.setIncremental("eng.root.20171217");
        baseInfo.setRelease("5.1");
        baseInfo.setSdk("19");
        baseInfo.setCodename("REL");
        baseInfo.setBuildtime("1511753734");
        baseInfo.setDiscription("jfltexx-user 4.3 JSS15J I9505XXUEML1 release-keys");
        XposedBridge.log(baseInfo.toString());
        return baseInfo;
    }

}
