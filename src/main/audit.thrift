/*
* 用于实名认证审核的thrift文件
*
*/

namespace java com.jfpay.generated

struct CertificateBean{
    1:string customer
    2:string num_mobile
    3:string flag_audit
    4:string remark
    5:string id_task
    6:string date_check
    7:string date_exam
    8:string user_audit
    9:string date_pidValidity
    10:string code_reject
    11:string reason_reject
    12:string viplevel
    13:string audittype
}

struct CertificateResp{
    1:string code_resp
    2:string message_resp
}

service CertifacationService
{
    CertificateResp doCertifacate(1:CertificateBean param)
}
