package co.kr.cobosys.baroder.models.mappers.auth

import co.kr.cobosys.baroder.models.FoundMemberIdDataUI
import co.kr.cobosys.baroder.models.FoundMemberIdModelUI
import co.kr.cobosys.domain.base.mappers.Mapper
import co.kr.cobosys.domain.models.FoundMemberIdModel

class FoundMemberIdMapper : Mapper<FoundMemberIdModel, FoundMemberIdModelUI> {
    override fun mapLeftToRight(obj: FoundMemberIdModel): FoundMemberIdModelUI = with(obj) {
        FoundMemberIdModelUI(
            code = code,
            message = message,
            data = data.map { data ->
                FoundMemberIdDataUI(
                    data.memberId,
                    data.regDate
                )
            }
        )
    }
}