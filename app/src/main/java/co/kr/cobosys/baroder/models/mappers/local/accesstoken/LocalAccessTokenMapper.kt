package co.kr.cobosys.baroder.models.mappers.local.accesstoken

import co.kr.cobosys.baroder.models.LocalAccessTokenUI
import co.kr.cobosys.domain.models.LocalAccessToken

fun LocalAccessTokenUI.toLocalAccessToken(): LocalAccessToken = LocalAccessToken(
    accessToken
)

fun LocalAccessToken.toLocalAccessTokenUI(): LocalAccessTokenUI = LocalAccessTokenUI(
    accessToken
)