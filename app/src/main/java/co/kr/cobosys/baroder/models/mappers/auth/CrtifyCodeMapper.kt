package co.kr.cobosys.baroder.models.mappers.auth

import co.kr.cobosys.baroder.models.CertifyCodeUI
import co.kr.cobosys.domain.base.mappers.Mapper
import co.kr.cobosys.domain.models.CertifyCode

class CrtifyCodeMapper: Mapper<CertifyCode, CertifyCodeUI> {
    override fun mapLeftToRight(obj: CertifyCode): CertifyCodeUI = with(obj) {
       CertifyCodeUI(
           certifyCode = certifyCode
       )
    }
}