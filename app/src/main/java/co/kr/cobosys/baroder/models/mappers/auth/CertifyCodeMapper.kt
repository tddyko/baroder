package co.kr.cobosys.baroder.models.mappers.auth

import co.kr.cobosys.baroder.models.CertifyCodeDataUI
import co.kr.cobosys.baroder.models.CertifyCodeModelUI
import co.kr.cobosys.domain.models.CertifyCodeData
import co.kr.cobosys.domain.models.CertifyCodeModel

fun CertifyCodeModelUI.toCertifyCodeModel(): CertifyCodeModel = CertifyCodeModel(
    code, message, data = CertifyCodeData(data.certifyCode)
)

fun CertifyCodeModel.toCertifyCodeModelUI(): CertifyCodeModelUI = CertifyCodeModelUI(
    code, message, data = CertifyCodeDataUI(data.certifyCode)
)