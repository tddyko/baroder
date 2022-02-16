package co.kr.cobosys.baroder.model.mappers.auth

import co.kr.cobosys.baroder.model.AccessTokenUI
import co.kr.cobosys.domain.base.map.Mapper
import co.kr.cobosys.domain.model.AccessToken

class AccessTokenMapper: Mapper<AccessToken, AccessTokenUI> {
    override fun mapLeftToRight(obj: AccessToken): AccessTokenUI = with(obj) {
       AccessTokenUI(
           accessToken = accessToken
       )
    }
}