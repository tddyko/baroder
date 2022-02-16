package co.kr.cobosys.data.mappers.auth

import co.kr.cobosys.data.api.AccessTokenResponse
import co.kr.cobosys.domain.base.map.Mapper
import co.kr.cobosys.domain.model.AccessToken

class AccessTokenMapper: Mapper<AccessTokenResponse, AccessToken> {
    override fun mapLeftToRight(obj: AccessTokenResponse): AccessToken = with(obj) {
       AccessToken(
           accessToken = accessToken
       )
    }
}