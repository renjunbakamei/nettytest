package com.jfpay.core.util;

import java.util.Date;

public class FormatUtil {

    public static int getSeconds(Date startdate, Date enddate) {
        long time = enddate.getTime() - startdate.getTime();
        int totalS = new Long(time / 1000).intValue();
        return totalS;
    }

}
