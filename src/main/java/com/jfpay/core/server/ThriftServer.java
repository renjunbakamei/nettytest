package com.jfpay.core.server;


import com.jfpay.core.initializer.ThriftInitializer;
import com.jfpay.core.setting.ServerList;

public class ThriftServer  implements Runnable {

    @Override
    public void run() {
        try {
            ThriftInitializer thrift=(ThriftInitializer) ServerList.getCtx().getBean("thriftInitializer");
            thrift.startserver();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
