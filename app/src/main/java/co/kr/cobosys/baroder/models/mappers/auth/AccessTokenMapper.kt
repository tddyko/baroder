package co.kr.cobosys.baroder.models.mappers.auth

import co.kr.cobosys.baroder.models.AccessTokenDataUI
import co.kr.cobosys.baroder.models.AccessTokenModelUI
import co.kr.cobosys.domain.models.AccessTokenData
import co.kr.cobosys.domain.models.AccessTokenModel

fun AccessTokenModelUI.toAccessTokenModel(): AccessTokenModel = AccessTokenModel(
    code, message, data = AccessTokenData(data.accessToken)
)

fun AccessTokenModel.toAccessTokenModelUI(): AccessTokenModelUI = AccessTokenModelUI(
    code, message, data = AccessTokenDataUI(data.accessToken)
)