package com.jfpay.core.setting;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ZookeeperRegistryInfo {

    private static final Logger logger = LoggerFactory.getLogger(ZookeeperRegistryInfo.class);


    private static final String DEFAULT_ROOT = "imp";

    private static final int DEFAULT_SESSION_TIMEOUT = 60000;

    private static final int DEFAULT_CONNECTION_TIMEOUT = 1000;

    private static final String DEFAULT_PROTOCOL = "tcp";

    private static String url;


    private static String nodeName;

    private static Integer sessionTimeout;

    private static Integer connectionTimeout;

    private static String root;

    public ZookeeperRegistryInfo(){}


    public ZookeeperRegistryInfo(String url){
        ZookeeperRegistryInfo.url=url;
        ZookeeperRegistryInfo.root=ZookeeperRegistryInfo.DEFAULT_ROOT;
        ZookeeperRegistryInfo.nodeName=ZookeeperRegistryInfo.DEFAULT_ROOT;
        ZookeeperRegistryInfo.sessionTimeout=DEFAULT_SESSION_TIMEOUT;
        ZookeeperRegistryInfo.connectionTimeout=DEFAULT_CONNECTION_TIMEOUT;
    }

    public ZookeeperRegistryInfo(String url, String nodeName){
        ZookeeperRegistryInfo.url=url;
        ZookeeperRegistryInfo.nodeName=nodeName;
        ZookeeperRegistryInfo.root=ZookeeperRegistryInfo.DEFAULT_ROOT;
        ZookeeperRegistryInfo.sessionTimeout=DEFAULT_SESSION_TIMEOUT;
        ZookeeperRegistryInfo.connectionTimeout=DEFAULT_CONNECTION_TIMEOUT;
    }

    public ZookeeperRegistryInfo(String url, String root, String nodeName){
        ZookeeperRegistryInfo.url=url;
        ZookeeperRegistryInfo.root=root;
        ZookeeperRegistryInfo.nodeName=nodeName;
        ZookeeperRegistryInfo.sessionTimeout=DEFAULT_SESSION_TIMEOUT;
        ZookeeperRegistryInfo.connectionTimeout=DEFAULT_CONNECTION_TIMEOUT;
    }

    public ZookeeperRegistryInfo(String url, String nodeName, int connectionTimeout){
        ZookeeperRegistryInfo.url=url;
        ZookeeperRegistryInfo.root=ZookeeperRegistryInfo.DEFAULT_ROOT;
        ZookeeperRegistryInfo.nodeName=nodeName;
        ZookeeperRegistryInfo.sessionTimeout=connectionTimeout;
        ZookeeperRegistryInfo.connectionTimeout=DEFAULT_CONNECTION_TIMEOUT;
    }

    public ZookeeperRegistryInfo(String url, String nodeName, int connectionTimeout, int sessionTimeout){
        ZookeeperRegistryInfo.url=url;
        ZookeeperRegistryInfo.root=ZookeeperRegistryInfo.DEFAULT_ROOT;
        ZookeeperRegistryInfo.nodeName=nodeName;
        ZookeeperRegistryInfo.sessionTimeout=sessionTimeout;
        ZookeeperRegistryInfo.connectionTimeout=connectionTimeout;

    }

    public ZookeeperRegistryInfo(String url, String root, String nodeName, int connectionTimeout, int sessionTimeout){
        ZookeeperRegistryInfo.url=url;
        ZookeeperRegistryInfo.root=root;
        ZookeeperRegistryInfo.nodeName=nodeName;
        ZookeeperRegistryInfo.sessionTimeout=connectionTimeout;
        ZookeeperRegistryInfo.connectionTimeout=sessionTimeout;

    }

    public static String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        ZookeeperRegistryInfo.url = url;
    }

    public static Integer getSessionTimeout() {
        return sessionTimeout;
    }

    public void setSessionTimeout(Integer sessionTimeout) {
        ZookeeperRegistryInfo.sessionTimeout = sessionTimeout;
    }

    public static Integer getConnectionTimeout() {
        return connectionTimeout;
    }

    public void setConnectionTimeout(Integer connectionTimeout) {
        ZookeeperRegistryInfo.connectionTimeout = connectionTimeout;
    }

    public static String getRoot() {
        return root;
    }

    public void setRoot(String root) {
        ZookeeperRegistryInfo.root = root;
    }

    public static String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        ZookeeperRegistryInfo.nodeName = nodeName;
    }

}
