package co.kr.cobosys.baroder.models.mappers.auth

import co.kr.cobosys.baroder.models.AccessTokenUI
import co.kr.cobosys.domain.base.mappers.Mapper
import co.kr.cobosys.domain.models.AccessToken

class AccessTokenMapper: Mapper<AccessToken, AccessTokenUI> {
    override fun mapLeftToRight(obj: AccessToken): AccessTokenUI = with(obj) {
       AccessTokenUI(
           accessToken = accessToken
       )
    }
}