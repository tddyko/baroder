package co.kr.cobosys.baroder.models.mappers.auth

import co.kr.cobosys.baroder.models.FoundMemberIdDataUI
import co.kr.cobosys.baroder.models.FoundMemberIdModelUI
import co.kr.cobosys.domain.models.FoundMemberIdData
import co.kr.cobosys.domain.models.FoundMemberIdModel

fun FoundMemberIdModelUI.toFoundMemberIdModel(): FoundMemberIdModel = FoundMemberIdModel(
    code, message, data = data.map { data ->
        FoundMemberIdData(data.memberId, data.regDate)
    }
)

fun FoundMemberIdModel.toFoundMemberIdModelUI(): FoundMemberIdModelUI = FoundMemberIdModelUI(
    code, message, data = data.map { data ->
        FoundMemberIdDataUI(data.memberId, data.regDate)
    }
)