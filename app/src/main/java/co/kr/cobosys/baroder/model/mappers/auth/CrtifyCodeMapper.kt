package co.kr.cobosys.baroder.model.mappers.auth

import co.kr.cobosys.baroder.model.CertifyCodeUI
import co.kr.cobosys.domain.base.map.Mapper
import co.kr.cobosys.domain.model.CertifyCode

class CrtifyCodeMapper: Mapper<CertifyCode, CertifyCodeUI> {
    override fun mapLeftToRight(obj: CertifyCode): CertifyCodeUI = with(obj) {
       CertifyCodeUI(
           certifyCode = certifyCode
       )
    }
}