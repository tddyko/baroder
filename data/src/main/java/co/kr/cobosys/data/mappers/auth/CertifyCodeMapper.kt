package co.kr.cobosys.data.mappers.auth

import co.kr.cobosys.data.api.CertifyCodeResponseModel
import co.kr.cobosys.domain.base.mappers.Mapper
import co.kr.cobosys.domain.models.CertifyCodeData
import co.kr.cobosys.domain.models.CertifyCodeModel

class CertifyCodeMapper : Mapper<CertifyCodeResponseModel, CertifyCodeModel> {
    override fun mapLeftToRight(obj: CertifyCodeResponseModel): CertifyCodeModel = with(obj) {
        CertifyCodeModel(
            code = code,
            message = message,
            data = CertifyCodeData(data.certifyCode)
        )
    }
}