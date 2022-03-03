package co.kr.cobosys.baroder.models.mappers.auth

import co.kr.cobosys.baroder.models.UserIDDuplicationCheckDataUI
import co.kr.cobosys.baroder.models.UserIDDuplicationCheckModelUI
import co.kr.cobosys.domain.models.UserIDDuplicationCheckData
import co.kr.cobosys.domain.models.UserIDDuplicationCheckModel

fun UserIDDuplicationCheckModelUI.toUserIdDuplucationCheckModel(): UserIDDuplicationCheckModel = UserIDDuplicationCheckModel(
    code, message, data = UserIDDuplicationCheckData(data.isDuplication)
)

fun UserIDDuplicationCheckModel.toUserIdDuplicationCheckModelUI(): UserIDDuplicationCheckModelUI = UserIDDuplicationCheckModelUI(
    code, message, data = UserIDDuplicationCheckDataUI(data.isDuplication)
)