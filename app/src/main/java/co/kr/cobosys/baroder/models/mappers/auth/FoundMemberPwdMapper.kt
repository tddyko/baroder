package co.kr.cobosys.baroder.models.mappers.auth

import co.kr.cobosys.baroder.models.FoundMemberPwdModelUI
import co.kr.cobosys.baroder.models.FoundMemberPwdUI
import co.kr.cobosys.domain.models.FoundMemberPwdData
import co.kr.cobosys.domain.models.FoundMemberPwdModel

fun FoundMemberPwdModelUI.toFoundMemberPwdModel(): FoundMemberPwdModel = FoundMemberPwdModel(
    code, message, data = FoundMemberPwdData(data.memberUUID)
)

fun FoundMemberPwdModel.toFoundMemberPwdModelUI(): FoundMemberPwdModelUI = FoundMemberPwdModelUI(
    code, message, data = FoundMemberPwdUI(data.memberUUID)
)