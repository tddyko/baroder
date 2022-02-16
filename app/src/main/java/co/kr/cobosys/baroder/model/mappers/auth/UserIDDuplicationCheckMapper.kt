package co.kr.cobosys.baroder.model.mappers.auth

import co.kr.cobosys.baroder.model.UserIDDuplicationCheckUI
import co.kr.cobosys.domain.base.map.Mapper
import co.kr.cobosys.domain.model.UserIDDuplicationCheck

class UserIDDuplicationCheckMapper: Mapper<UserIDDuplicationCheck, UserIDDuplicationCheckUI> {
    override fun mapLeftToRight(obj: UserIDDuplicationCheck): UserIDDuplicationCheckUI = with(obj) {
       UserIDDuplicationCheckUI(
           isDuplication = isDuplication
       )
    }
}