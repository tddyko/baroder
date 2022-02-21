package co.kr.cobosys.data.mappers.auth

import co.kr.cobosys.data.api.CertifyCodeResponse
import co.kr.cobosys.domain.base.mappers.Mapper
import co.kr.cobosys.domain.models.CertifyCode

class CrtifyCodeMapper: Mapper<CertifyCodeResponse, CertifyCode> {
    override fun mapLeftToRight(obj: CertifyCodeResponse): CertifyCode = with(obj) {
       CertifyCode(
           certifyCode = certifyCode
       )
    }
}