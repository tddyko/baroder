package co.kr.cobosys.data.mappers.auth

import co.kr.cobosys.data.api.FoundMemberIdResponseData
import co.kr.cobosys.data.api.FoundMemberIdResponseModel
import co.kr.cobosys.domain.models.FoundMemberIdData
import co.kr.cobosys.domain.models.FoundMemberIdModel

fun FoundMemberIdResponseModel.toFoundMemberIdModel(): FoundMemberIdModel = FoundMemberIdModel(
    code, message, data = data.map { data ->
        FoundMemberIdData(
            data.memberId,
            data.regDate
        )
    }
)

fun FoundMemberIdModel.toFoundMemberIdResponseModel(): FoundMemberIdResponseModel = FoundMemberIdResponseModel(
    code, message, data = data.map { data ->
        FoundMemberIdResponseData(
            data.memberId,
            data.regDate
        )
    }
)