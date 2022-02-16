package co.kr.cobosys.data.mappers.auth

import co.kr.cobosys.data.api.FoundMemberIdResponse
import co.kr.cobosys.domain.base.map.Mapper
import co.kr.cobosys.domain.model.FoundMemberId

class FoundMemberIdMapper: Mapper<FoundMemberIdResponse, FoundMemberId> {
    override fun mapLeftToRight(obj: FoundMemberIdResponse): FoundMemberId = with(obj) {
       FoundMemberId(
           memberId = memberId,
           regDate = regDate
       )
    }
}