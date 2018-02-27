package com.jfpay.core.constant;

public enum ImpRespCode {

    /** 成功 */
    RESULT_SUCCESS("PN_00", "操作成功"),
    /** 请求报文不能为空 */
    REQ_CONTENT_NOT_BLANK("PN_01", "请求报文不能为空"),

    /** 请求报文不能为空 */
    METHOD_NOT_BLANK("PN_06", "请求方法不存在"),
    /** 报文体不能为空 */
    REQBEAN_NOT_BLANK("PN_11", "报文体不能为空"),
    /** 参数不能为空 */
    PARAMS_NOT_BLANK("PN_02", "参数不能为空"),
    /** 缺少必填参数 */
    MISSING_ARGUMENT("PN_03", "缺少必填参数"),
    /** 验签失败 */
    SIGN_FAIL("PN_04", "验签失败"),
    /** 请求报文验证异常  */
    REQUEST_BODY_EXCEPTION("PN_05", "请求报文验证异常"),
    /**json解析异常*/
    JSON_PARSE_ERROR("PN_07", "json解析异常！"),
    /**插入数据库异常*/
    SYSTEM_INSERT_ERROT("PN_08", "数据库操作异常！"),
    /** 系统错误 */
    SYSTEM_ERRROR("PN_99", "系统错误");

    private String resultCode,resultMsg;

    private ImpRespCode(String resultCode,String resultMsg) {
        this.resultMsg = resultMsg;
        this.resultCode = resultCode;
    }

    // 普通方法通过驳回码查询驳回原因
    public static String getResultMsg(String code) {
        for (ImpRespCode c : ImpRespCode.values()) {
            if (c.getResultCode().equals(code)) {
                return c.resultMsg;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return this.resultCode + ":" + this.resultMsg;
    }

    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

}
