package co.kr.cobosys.baroder.models.mappers.auth

import co.kr.cobosys.baroder.models.UserIDDuplicationCheckDataUI
import co.kr.cobosys.baroder.models.UserIDDuplicationCheckModelUI
import co.kr.cobosys.domain.base.mappers.Mapper
import co.kr.cobosys.domain.models.UserIDDuplicationCheckModel

class UserIDDuplicationCheckMapper :
    Mapper<UserIDDuplicationCheckModel, UserIDDuplicationCheckModelUI> {
    override fun mapLeftToRight(obj: UserIDDuplicationCheckModel): UserIDDuplicationCheckModelUI =
        with(obj) {
            UserIDDuplicationCheckModelUI(
                code = code,
                message = message,
                data = UserIDDuplicationCheckDataUI(data.isDuplication)
            )
        }
}