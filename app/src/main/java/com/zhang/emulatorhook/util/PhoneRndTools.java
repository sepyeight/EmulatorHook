package com.zhang.emulatorhook.util;

import java.util.Random;

public class PhoneRndTools {
    /**
     * 随机生成n位数字
     */
    public static String randomNum(int n){
        Random rnd = new Random();
        String res = "";
        for(int i=0; i<n; i++){
            res = res + rnd.nextInt(10);
        }
        return res;
    }

    /**
     * 随机一个手机号码
     * @return
     */
    public static String randomPhoneNum() {
        String head[] = { "+8613", "+8615", "+8617", "+8618", "+8616" };
        Random rnd = new Random();
        String res = head[rnd.nextInt(head.length)];
        for (int i = 0; i < 9; i++)
        {
            res = res + rnd.nextInt(10);
        }
        return res;
    }

    public static String randomMac(){
        String chars = "abcde0123456789";
        String res = "";
        Random rnd = new Random();
        for(int i=0; i< 17; i++){
            if(i%3 == 2){
                res = res +":";
            }else {
                res = res + chars.charAt(rnd.nextInt(chars.length()));
            }
        }
        return res;
    }

    public static String randomMac1()
    {
        String chars = "ABCDE0123456789";
        String res = "";
        Random rnd = new Random();
        int leng = chars.length();
        for (int i = 0; i < 17; i++)
        {
            if (i % 3 == 2)
            {
                res = res + ":";
            } else
            {
                res = res + chars.charAt(rnd.nextInt(leng));
            }

        }
        return res;
    }

    public static String randomABC(int n)
    {
        String chars = "abcde0123456789";
        String res = "";
        Random rnd = new Random();
        int leng = chars.length();
        for (int i = 0; i < n; i++)
        {
            res = res + chars.charAt(rnd.nextInt(leng));

        }
        return res;
    }

    public static String randomIP(){
        //ip范围
        int[][] range = {{607649792,608174079},//36.56.0.0-36.63.255.255
                {1038614528,1039007743},//61.232.0.0-61.237.255.255
                {1783627776,1784676351},//106.80.0.0-106.95.255.255
                {2035023872,2035154943},//121.76.0.0-121.77.255.255
                {2078801920,2079064063},//123.232.0.0-123.235.255.255
                {-1950089216,-1948778497},//139.196.0.0-139.215.255.255
                {-1425539072,-1425014785},//171.8.0.0-171.15.255.255
                {-1236271104,-1235419137},//182.80.0.0-182.92.255.255
                {-770113536,-768606209},//210.25.0.0-210.47.255.255
                {-569376768,-564133889}, //222.16.0.0-222.95.255.255
        };

        Random rdint = new Random();
        int index = rdint.nextInt(10);
        String ip = num2ip(range[index][0]+new Random().nextInt(range[index][1]-range[index][0]));
        return ip;
    }

    public static int randomIPNum(){
        //ip范围
        int[][] range = {{607649792,608174079},//36.56.0.0-36.63.255.255
                {1038614528,1039007743},//61.232.0.0-61.237.255.255
                {1783627776,1784676351},//106.80.0.0-106.95.255.255
                {2035023872,2035154943},//121.76.0.0-121.77.255.255
                {2078801920,2079064063},//123.232.0.0-123.235.255.255
                {-1950089216,-1948778497},//139.196.0.0-139.215.255.255
                {-1425539072,-1425014785},//171.8.0.0-171.15.255.255
                {-1236271104,-1235419137},//182.80.0.0-182.92.255.255
                {-770113536,-768606209},//210.25.0.0-210.47.255.255
                {-569376768,-564133889}, //222.16.0.0-222.95.255.255
        };

        Random rd = new Random();
        int index = rd.nextInt(10);
        int base1 = range[index][0];
        int base2 = range[index][1];
        int rdIPNum = base1 + rd.nextInt(base2 -base1);
        return rdIPNum;
    }

    public static String num2ip(int ip) {
        int [] b=new int[4] ;
        String x = "";

        b[0] = (ip >> 24) & 0xff;
        b[1] = (ip >> 16) & 0xff;
        b[2] = (ip >> 8) & 0xff;
        b[3] = ip & 0xff;
        x=Integer.toString(b[0])+"."+Integer.toString(b[1])+"."+Integer.toString(b[2])+"."+Integer.toString(b[3]);

        return x;
    }
}
