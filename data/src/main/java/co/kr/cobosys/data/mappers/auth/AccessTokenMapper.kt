package co.kr.cobosys.data.mappers.auth

import co.kr.cobosys.data.api.AccessTokenResponse
import co.kr.cobosys.domain.base.mappers.Mapper
import co.kr.cobosys.domain.models.AccessToken

class AccessTokenMapper: Mapper<AccessTokenResponse, AccessToken> {
    override fun mapLeftToRight(obj: AccessTokenResponse): AccessToken = with(obj) {
       AccessToken(
           accessToken = accessToken
       )
    }
}