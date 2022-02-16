package co.kr.cobosys.data.mappers.auth

import co.kr.cobosys.data.api.FoundMemberPwdResponse
import co.kr.cobosys.domain.base.map.Mapper
import co.kr.cobosys.domain.model.FoundMemberPwd

class FoundMemberPwdMapper: Mapper<FoundMemberPwdResponse, FoundMemberPwd> {
    override fun mapLeftToRight(obj: FoundMemberPwdResponse): FoundMemberPwd = with(obj) {
       FoundMemberPwd(
           memberUUID = memberUUID
       )
    }
}