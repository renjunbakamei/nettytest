package com.jfpay.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.util.Locale;

public class Md5Utils {

    
    private static final String MD5KEY = "91b6cbc51a5046618af9b42641adeebe";

    public static String onMD5PwdByMD5key(String req){
        try {
            String result = MD5(URLEncoder.encode(req, "utf-8") + MD5KEY).toUpperCase();
            return result;
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return "";
        }
    }

    public static String onMD5Pwd(String pwd) {
        try {
            String result = MD5(URLEncoder.encode(pwd, "utf-8") + MD5KEY).toUpperCase(Locale.getDefault());
            return result;
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return "";
        }
    }

    public final static String MD5(String s) {
        char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
        try {
            byte[] btInput = s.getBytes();
            // 获得MD5摘要算法的 MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            // 使用指定的字节更新摘要
            mdInst.update(btInput);
            // 获得密文
            byte[] md = mdInst.digest();
            // 把密文转换成十六进制的字符串形式
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public static void main(String args[]){
        //String req = "{\"agent_id\":\"282162\",\"agent_name\":\"上海即富\",\"agent_mobile\":\"18301770001\",\"mobile\":\"18301770001\"}";
        //String req = "{\"mobile\":\"18301775804\"}";
        String req = "{\"mobile\":\"15026591344\",\"type\":\"0\",\"grade\":\"101103\",\"status\":\"1\",\"error_msg\":\"\"}";
        //pmout=91897d3098114db98bfa101cd29c781f
        //shenjian=91b6cbc51a5046618af9b42641adeebe
        //dianshua=ee5e0ba306614631b4b46f3f903df6cd
//        String md5Key = "91b6cbc51a5046618af9b42641adeebe";
        //BF9062C071F0732E0BB65809635589C4
        String sign =Md5Utils.onMD5PwdByMD5key(req);
        System.out.println("sign="+sign);

    }

}

