package co.kr.cobosys.baroder.models.mappers.auth

import co.kr.cobosys.baroder.models.CertifyCodeDataUI
import co.kr.cobosys.baroder.models.CertifyCodeModelUI
import co.kr.cobosys.domain.base.mappers.Mapper
import co.kr.cobosys.domain.models.CertifyCodeModel

class CrtifyCodeMapper: Mapper<CertifyCodeModel, CertifyCodeModelUI> {
    override fun mapLeftToRight(obj: CertifyCodeModel): CertifyCodeModelUI = with(obj) {
       CertifyCodeModelUI(
           code = code,
           message = message,
           data = CertifyCodeDataUI(data.certifyCode)
       )
    }
}