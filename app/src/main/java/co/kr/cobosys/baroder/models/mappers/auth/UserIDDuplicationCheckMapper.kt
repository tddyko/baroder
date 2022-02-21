package co.kr.cobosys.baroder.models.mappers.auth

import co.kr.cobosys.baroder.models.UserIDDuplicationCheckUI
import co.kr.cobosys.domain.base.mappers.Mapper
import co.kr.cobosys.domain.models.UserIDDuplicationCheck

class UserIDDuplicationCheckMapper: Mapper<UserIDDuplicationCheck, UserIDDuplicationCheckUI> {
    override fun mapLeftToRight(obj: UserIDDuplicationCheck): UserIDDuplicationCheckUI = with(obj) {
       UserIDDuplicationCheckUI(
           isDuplication = isDuplication
       )
    }
}