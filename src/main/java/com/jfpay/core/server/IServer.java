package com.jfpay.core.server;

public interface IServer {

    public void start(int  no) throws Exception;

    public void stop(int  no) throws Exception;

    public void restart(int  no) throws Exception;

    public void start() throws Exception;

    public void stop() throws Exception;

    public void restart() throws Exception;

}
