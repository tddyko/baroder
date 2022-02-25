package co.kr.cobosys.data.mappers.auth

import co.kr.cobosys.data.api.FoundMemberIdResponseModel
import co.kr.cobosys.domain.base.mappers.Mapper
import co.kr.cobosys.domain.models.FoundMemberIdData
import co.kr.cobosys.domain.models.FoundMemberIdModel

class FoundMemberIdMapper: Mapper<FoundMemberIdResponseModel, FoundMemberIdModel> {
    override fun mapLeftToRight(obj: FoundMemberIdResponseModel): FoundMemberIdModel = with(obj) {
       FoundMemberIdModel(
           code = code,
           message = message,
           data = data.map { data ->
               FoundMemberIdData(
                   data.memberId,
                   data.regDate
               )
           }
       )
    }
}