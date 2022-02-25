package co.kr.cobosys.data.mappers.auth

import co.kr.cobosys.data.api.FoundMemberPwdResponseModel
import co.kr.cobosys.domain.base.mappers.Mapper
import co.kr.cobosys.domain.models.FoundMemberPwdData
import co.kr.cobosys.domain.models.FoundMemberPwdModel

class FoundMemberPwdMapper: Mapper<FoundMemberPwdResponseModel, FoundMemberPwdModel> {
    override fun mapLeftToRight(obj: FoundMemberPwdResponseModel): FoundMemberPwdModel = with(obj) {
       FoundMemberPwdModel(
           code = code,
           message = message,
           data = FoundMemberPwdData(data.memberUUID)
       )
    }
}