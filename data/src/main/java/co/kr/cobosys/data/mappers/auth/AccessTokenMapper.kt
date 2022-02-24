package co.kr.cobosys.data.mappers.auth

import co.kr.cobosys.data.api.AccessTokenResponseModel
import co.kr.cobosys.domain.base.mappers.Mapper
import co.kr.cobosys.domain.models.AccessTokenData
import co.kr.cobosys.domain.models.AccessTokenModel

class AccessTokenMapper: Mapper<AccessTokenResponseModel, AccessTokenModel> {

    override fun mapLeftToRight(obj: AccessTokenResponseModel): AccessTokenModel = with(obj) {
       AccessTokenModel(
           code = code,
           message = message,
           data = AccessTokenData(data.accessToken)
       )
    }
}