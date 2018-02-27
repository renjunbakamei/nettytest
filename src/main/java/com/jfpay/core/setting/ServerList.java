package com.jfpay.core.setting;

import org.springframework.context.ApplicationContext;

import java.util.List;

public class ServerList {

    private static List<SystemInfo> servers;

    private static ApplicationContext ctx;

    public static void update(int serverNo,SystemInfo systemInfo){
        servers.set(serverNo,systemInfo);
    }

    public static SystemInfo getSystemInfo(int serverNo){
        return servers.get(serverNo);
    }

    public static Integer getServerNum() {
        return servers.size();
    }

    public static void shutDownGraceFully(int serverNo){
        servers.get(serverNo).shutDownGraceFully();
    }

    public List<SystemInfo> getServers(){
        return servers;
    }

    public void setServers(List<SystemInfo> servers){
        ServerList.servers=servers;
    }

    public static ApplicationContext getCtx() {
        return ctx;
    }

    public static void setCtx(ApplicationContext ctx) {
        ServerList.ctx = ctx;
    }
}
