package co.kr.cobosys.data.mappers.auth

import co.kr.cobosys.data.api.FoundMemberPwdResponse
import co.kr.cobosys.domain.base.mappers.Mapper
import co.kr.cobosys.domain.models.FoundMemberPwd

class FoundMemberPwdMapper: Mapper<FoundMemberPwdResponse, FoundMemberPwd> {
    override fun mapLeftToRight(obj: FoundMemberPwdResponse): FoundMemberPwd = with(obj) {
       FoundMemberPwd(
           memberUUID = memberUUID
       )
    }
}