package co.kr.cobosys.data.mappers.auth

import co.kr.cobosys.data.api.UserIDDuplicationCheckResponseData
import co.kr.cobosys.data.api.UserIDDuplicationCheckResponseModel
import co.kr.cobosys.domain.models.UserIDDuplicationCheckData
import co.kr.cobosys.domain.models.UserIDDuplicationCheckModel

fun UserIDDuplicationCheckResponseModel.toUserIdDuplicationCheckModel(): UserIDDuplicationCheckModel = UserIDDuplicationCheckModel(
    code, message, data = UserIDDuplicationCheckData(data.isDuplication)
)

fun UserIDDuplicationCheckModel.toUserIdDuplicationCheckResponseModel(): UserIDDuplicationCheckResponseModel = UserIDDuplicationCheckResponseModel(
    code, message, data = UserIDDuplicationCheckResponseData(data.isDuplication)
)