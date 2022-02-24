package co.kr.cobosys.baroder.models.mappers.auth

import co.kr.cobosys.baroder.models.AccessTokenDataUI
import co.kr.cobosys.baroder.models.AccessTokenModelUI
import co.kr.cobosys.domain.base.mappers.Mapper
import co.kr.cobosys.domain.models.AccessTokenModel

class AccessTokenMapper: Mapper<AccessTokenModel, AccessTokenModelUI> {
    override fun mapLeftToRight(obj: AccessTokenModel): AccessTokenModelUI = with(obj) {
       AccessTokenModelUI(
           code = code,
           message = message,
           data = AccessTokenDataUI(data.accessToken)
       )
    }
}