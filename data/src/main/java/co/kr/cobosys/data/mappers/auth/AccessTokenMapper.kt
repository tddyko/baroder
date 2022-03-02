package co.kr.cobosys.data.mappers.auth

import co.kr.cobosys.data.api.AccessTokenResponseData
import co.kr.cobosys.data.api.AccessTokenResponseModel
import co.kr.cobosys.domain.models.AccessTokenData
import co.kr.cobosys.domain.models.AccessTokenModel

fun AccessTokenModel.toResponseAccessTokenModel(): AccessTokenResponseModel = AccessTokenResponseModel(
    code, message, data = AccessTokenResponseData(data.accessToken)
)

fun AccessTokenResponseModel.toAccessTokenModel(): AccessTokenModel = AccessTokenModel(
    code, message, data = AccessTokenData(data.accessToken)
)