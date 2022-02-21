package co.kr.cobosys.data.mappers.auth

import co.kr.cobosys.data.api.UserIDDuplicationCheckResponse
import co.kr.cobosys.domain.base.mappers.Mapper
import co.kr.cobosys.domain.models.UserIDDuplicationCheck

class UserIDDuplicationCheckMapper: Mapper<UserIDDuplicationCheckResponse, UserIDDuplicationCheck> {
    override fun mapLeftToRight(obj: UserIDDuplicationCheckResponse): UserIDDuplicationCheck = with(obj) {
       UserIDDuplicationCheck(
           isDuplication = isDuplication
       )
    }
}