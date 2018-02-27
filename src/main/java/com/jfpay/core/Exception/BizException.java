package com.jfpay.core.Exception;

/**
 * Created by renjun on 2017/8/27.
 */
public class  BizException extends Exception {

    private String errorCode;

    private String errorMessage;

    public BizException(String errorMessage){
        super(errorMessage);
        this.errorMessage=errorMessage;
    }

    public BizException(String errorCode,String message){
        super(message);
        this.errorMessage=message;
        this.setErrorCode(errorCode);
    }

    public BizException(String errorCode,String message,Throwable cause){
        super(message,cause);
        this.errorMessage=message;
        this.setErrorCode(errorCode);
    }
    public BizException(Throwable cause){
        super(cause);
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

}
