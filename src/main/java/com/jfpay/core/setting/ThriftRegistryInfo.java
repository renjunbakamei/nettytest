package com.jfpay.core.setting;

import java.util.List;

public class ThriftRegistryInfo {

    private static Integer port;

    private static List<String> serviceList;

    public static Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public static List<String> getServiceList() {
        return serviceList;
    }

    public void setServiceList(List<String> serviceList) {
        this.serviceList = serviceList;
    }
}
