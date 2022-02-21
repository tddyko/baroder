package co.kr.cobosys.data.mappers.auth

import co.kr.cobosys.data.api.FoundMemberIdResponse
import co.kr.cobosys.domain.base.mappers.Mapper
import co.kr.cobosys.domain.models.FoundMemberId

class FoundMemberIdMapper: Mapper<FoundMemberIdResponse, FoundMemberId> {
    override fun mapLeftToRight(obj: FoundMemberIdResponse): FoundMemberId = with(obj) {
       FoundMemberId(
           memberId = memberId,
           regDate = regDate
       )
    }
}