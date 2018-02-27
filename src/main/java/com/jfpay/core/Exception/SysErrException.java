package com.jfpay.core.Exception;

public class SysErrException extends Exception{


    private String errorCode;

    public SysErrException(String message){
        super(message);
    }

    public SysErrException(String errorCode,String message){
        super(message);
        this.setErrorCode(errorCode);
    }

    public SysErrException(String errorCode,String message,Throwable cause){
        super(message,cause);
        this.setErrorCode(errorCode);
    }
    public SysErrException(Throwable cause){
        super(cause);
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }
}
