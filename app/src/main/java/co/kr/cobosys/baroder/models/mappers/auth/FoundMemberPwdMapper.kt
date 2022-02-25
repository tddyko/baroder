package co.kr.cobosys.baroder.models.mappers.auth

import co.kr.cobosys.baroder.models.FoundMemberPwdModelUI
import co.kr.cobosys.baroder.models.FoundMemberPwdUI
import co.kr.cobosys.domain.base.mappers.Mapper
import co.kr.cobosys.domain.models.FoundMemberPwdModel

class FoundMemberPwdMapper: Mapper<FoundMemberPwdModel, FoundMemberPwdModelUI> {
    override fun mapLeftToRight(obj: FoundMemberPwdModel): FoundMemberPwdModelUI = with(obj) {
       FoundMemberPwdModelUI(
           code = code,
           message = message,
           data = FoundMemberPwdUI(data.memberUUID)
       )
    }
}