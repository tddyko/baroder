package co.kr.cobosys.baroder.model.mappers.auth

import co.kr.cobosys.baroder.model.FoundMemberIdUI
import co.kr.cobosys.domain.base.map.Mapper
import co.kr.cobosys.domain.model.FoundMemberId

class FoundMemberIdMapper: Mapper<FoundMemberId, FoundMemberIdUI> {
    override fun mapLeftToRight(obj: FoundMemberId): FoundMemberIdUI = with(obj) {
       FoundMemberIdUI(
           memberId = memberId,
           regDate = regDate
       )
    }
}