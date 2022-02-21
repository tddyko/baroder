package co.kr.cobosys.baroder.models.mappers.auth

import co.kr.cobosys.baroder.models.FoundMemberIdUI
import co.kr.cobosys.domain.base.mappers.Mapper
import co.kr.cobosys.domain.models.FoundMemberId

class FoundMemberIdMapper: Mapper<FoundMemberId, FoundMemberIdUI> {
    override fun mapLeftToRight(obj: FoundMemberId): FoundMemberIdUI = with(obj) {
       FoundMemberIdUI(
           memberId = memberId,
           regDate = regDate
       )
    }
}