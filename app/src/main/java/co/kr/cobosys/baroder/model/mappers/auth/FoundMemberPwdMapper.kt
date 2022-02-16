package co.kr.cobosys.baroder.model.mappers.auth

import co.kr.cobosys.baroder.model.FoundMemberPwdUI
import co.kr.cobosys.data.api.FoundMemberPwdResponse
import co.kr.cobosys.domain.base.map.Mapper
import co.kr.cobosys.domain.model.FoundMemberPwd

class FoundMemberPwdMapper: Mapper<FoundMemberPwd, FoundMemberPwdUI> {
    override fun mapLeftToRight(obj: FoundMemberPwd): FoundMemberPwdUI = with(obj) {
       FoundMemberPwdUI(
           memberUUID = memberUUID
       )
    }
}