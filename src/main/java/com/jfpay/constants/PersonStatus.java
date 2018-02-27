package com.jfpay.constants;

import java.text.SimpleDateFormat;
import java.util.Date;

public class PersonStatus {
    //客户状态
    public static String CUSTOMER_TAG5="5";  //图片上传中
    public static String CUSTOMER_TAG2="2";  //图片上传完成，待审核


    //审核图片
    public static String CUSTOMER_TAG3="3";
    public static String CUSTOMER_TAG4="4";
    public static String CUSTOMER_TAGC="C";
    public static String CUSTOMER_TAGB="B";
    public static String CUSTOMER_TAG3A="8";//自动通过
    public static String CUSTOMER_TAG4A="9";//自动驳回

    public static String REMARK_TAGC="持证照不清晰";

    public static String AUDIT_CHANNEL ="2";  //查询状态为2的状态



    /********************
     * 查询当前时间
     * 格式yyyyMMddHHmmss
     */
    public static String day(){
        SimpleDateFormat formate = new SimpleDateFormat("yyyyMMddHHmmss");
        String day = formate.format(new Date());
        return day;
    }
}
