package co.kr.cobosys.baroder.models.mappers.auth

import co.kr.cobosys.baroder.models.FoundMemberPwdUI
import co.kr.cobosys.domain.base.mappers.Mapper
import co.kr.cobosys.domain.models.FoundMemberPwd

class FoundMemberPwdMapper: Mapper<FoundMemberPwd, FoundMemberPwdUI> {
    override fun mapLeftToRight(obj: FoundMemberPwd): FoundMemberPwdUI = with(obj) {
       FoundMemberPwdUI(
           memberUUID = memberUUID
       )
    }
}