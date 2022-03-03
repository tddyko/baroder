package co.kr.cobosys.data.mappers.auth

import co.kr.cobosys.data.api.FoundMemberPwdResponseData
import co.kr.cobosys.data.api.FoundMemberPwdResponseModel
import co.kr.cobosys.domain.models.FoundMemberPwdData
import co.kr.cobosys.domain.models.FoundMemberPwdModel

fun FoundMemberPwdResponseModel.toFoundMemberPwdModel(): FoundMemberPwdModel = FoundMemberPwdModel(
    code, message, data = FoundMemberPwdData(data.memberUUID)
)

fun FoundMemberPwdModel.toFoundMemberPwdResponseModel(): FoundMemberPwdResponseModel = FoundMemberPwdResponseModel(
    code, message, data = FoundMemberPwdResponseData(data.memberUUID)
)