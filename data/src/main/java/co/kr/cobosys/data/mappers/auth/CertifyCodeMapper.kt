package co.kr.cobosys.data.mappers.auth

import co.kr.cobosys.data.api.CertifyCodeResponseData
import co.kr.cobosys.data.api.CertifyCodeResponseModel
import co.kr.cobosys.domain.models.CertifyCodeData
import co.kr.cobosys.domain.models.CertifyCodeModel

fun CertifyCodeResponseModel.toCertifyCodeModel(): CertifyCodeModel = CertifyCodeModel(
    code, message, data = CertifyCodeData(data.certifyCode)
)


fun CertifyCodeModel.toResponseCertifyCodeModel(): CertifyCodeResponseModel = CertifyCodeResponseModel(
    code, message, data = CertifyCodeResponseData(data.certifyCode)
)