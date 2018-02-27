package com.jfpay.core.setting;
import io.netty.channel.EventLoopGroup;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;


/**
 * 系统变量类
 */

public class SystemInfo {

    private static Logger log= LoggerFactory.getLogger(SystemInfo.class);

    private String protocolType;

    private Integer port;

    private Boolean ssl;

    private String jksPath;

    private String jksPwd;

    private Integer channelType;

    private ApplicationContext ctx;

    private EventLoopGroup bossGroup ;

    private EventLoopGroup workerGroup;

    private Integer bossGroupSize;

    private Integer workerGroupSize;

    public SystemInfo(){}

    /**
     * 系统配置
     * @param protocolType 协议类型
     * @param port 启动端口
     * @param channelType 通道类型
     * @throws Exception
     */
    public SystemInfo(String protocolType,Integer port,Integer channelType) throws Exception{

        /**
         * 基础校验
         */
        if(StringUtils.isBlank(protocolType)){
            throw new Exception("没有设置通信协议");
        }
        if(port==null){
            throw new Exception("没有设置启动端口号");
        }
        if(channelType==null){
            throw new Exception("没有设置通道类型");
        }

        this.protocolType=protocolType.toUpperCase();
        this.port=port;
        this.ssl=false;
        this.channelType=channelType;

    }


    /**
     * 系统设置
     * @param protocolType 协议类型
     * @param port 启动端口
     * @param channelType 通道类型
     * @param bossGroupSize 主线程池大小
     * @param workerGroupSize 工作线程池大小
     * @throws Exception
     */
    public SystemInfo(String protocolType,Integer port,Integer channelType,
                      Integer bossGroupSize,Integer workerGroupSize) throws Exception{

        /**
         * 基础校验
         */
        if(StringUtils.isEmpty(protocolType)){
            throw new Exception("没有设置通信协议");
        }

        if(port == null){
            throw new Exception("没有设置启动端口号");
        }
        if(channelType == null){
            throw new Exception("没有设置通道类型");
        }

        this.protocolType=protocolType.toUpperCase();
        this.port=port;
        this.ssl=false;
        this.channelType=channelType;
        this.bossGroupSize=bossGroupSize;
        this.workerGroupSize=workerGroupSize;
    }

    /**
     * 系统配置
     * @param protocolType
     * @param port
     * @param channelType
     * @param ssl
     * @param jksPath
     * @param jksPwd
     * @throws Exception
     */
    public SystemInfo(String protocolType,Integer port,Integer channelType, boolean ssl,String jksPath,
                      String jksPwd) throws Exception{

        /**
         * 基础校验
         */
        if(StringUtils.isBlank(protocolType)){
            throw new Exception("没有设置通信协议");
        }

        if(port == null){
            throw new Exception("没有设置启动端口号");
        }
        if(ssl){
            if(StringUtils.isBlank(jksPath)){
                throw new Exception("ssl加密需要的jks文件路径为空");
            }
            if(StringUtils.isBlank(jksPwd)){
                throw new Exception("jks秘钥为空");
            }
        }

        if(channelType == null){
            throw new Exception("没有设置通道类型");
        }

        this.protocolType=protocolType.toUpperCase();
        this.port=port;
        this.ssl=ssl;
        this.jksPath=jksPath;
        this.jksPwd=jksPwd;
        this.channelType=channelType;
    }

    /**
     * 系统配置
     * @param protocolType
     * @param port
     * @param channelType
     * @param ssl
     * @param jksPath
     * @param jksPwd
     * @param bossGroupSize
     * @param workerGroupSize
     * @throws Exception
     */
    public SystemInfo(String protocolType,Integer port,Integer channelType, boolean ssl,String jksPath,
                      String jksPwd,Integer bossGroupSize,Integer workerGroupSize) throws Exception{

        /**
         * 基础校验
         */
        if(StringUtils.isBlank(protocolType)){
            throw new Exception("没有设置通信协议");
        }

        if(port == null){
            throw new Exception("没有设置启动端口号");
        }
        if(ssl){
            if(StringUtils.isBlank(jksPath)){
                throw new Exception("ssl加密需要的jks文件路径为空");
            }
            if(StringUtils.isBlank(jksPwd)){
                throw new Exception("jks秘钥为空");
            }
        }

        if(channelType == null){
            throw new Exception("没有设置通道类型");
        }

        this.protocolType=protocolType.toUpperCase();
        this.port=port;
        this.ssl=ssl;
        this.jksPath=jksPath;
        this.jksPwd=jksPwd;
        this.channelType=channelType;
        this.bossGroupSize=bossGroupSize;
        this.workerGroupSize=workerGroupSize;
    }

    public  void printSysInfo(){
        log.info("**************SYSTEM INFO******************");
        log.info("protocolType  : " + protocolType);
        log.info("port          : " + port);
        log.info("channelType   : " + channelType + " (0=NIO 1=OIO)");
        log.info("ssl         : " + ssl);
        if(StringUtils.isNotBlank(jksPath))
            log.info("jksPath       : " + jksPath);
        if(StringUtils.isNotBlank(jksPwd))
            log.info("jksPwd        : " + jksPwd);
        if(bossGroupSize!=null)
            log.info("bossGroupSize : " + bossGroupSize);
        if(workerGroupSize!=null)
            log.info("workerGroupSize: " + workerGroupSize);
        log.info("**************SYSTEM INFO******************");
    }

    public void shutDownGraceFully(){
        bossGroup.shutdownGracefully();
        workerGroup.shutdownGracefully();
    }


    public String getProtocolType() {
        return protocolType;
    }

    public void setProtocolType(String protocolType) {
        this.protocolType = protocolType;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public Boolean getSsl() {
        return ssl;
    }

    public void setSsl(Boolean ssl) {
        ssl = ssl;
    }

    public String getJksPath() {
        return jksPath;
    }

    public void setJksPath(String jksPath) {
        this.jksPath = jksPath;
    }

    public String getJksPwd() {
        return jksPwd;
    }

    public void setJksPwd(String jksPwd) {
        this.jksPwd = jksPwd;
    }

    public Integer getChannelType() {
        return channelType;
    }

    public void setChannelType(Integer channelType) {
        this.channelType = channelType;
    }

    public ApplicationContext getCtx() {
        return ctx;
    }

    public void setCtx(ApplicationContext ctx) {
        this.ctx = ctx;
    }

    public EventLoopGroup getBossGroup() {
        return bossGroup;
    }

    public void setBossGroup(EventLoopGroup bossGroup) {
        this.bossGroup = bossGroup;
    }

    public EventLoopGroup getWorkerGroup() {
        return workerGroup;
    }

    public void setWorkerGroup(EventLoopGroup workerGroup) {
        this.workerGroup = workerGroup;
    }

    public Integer getBossGroupSize() {
        return bossGroupSize;
    }

    public void setBossGroupSize(Integer bossGroupSize) {
        this.bossGroupSize = bossGroupSize;
    }

    public Integer getWorkerGroupSize() {
        return workerGroupSize;
    }

    public void setWorkerGroupSize(Integer workerGroupSize) {
        this.workerGroupSize = workerGroupSize;
    }
}
