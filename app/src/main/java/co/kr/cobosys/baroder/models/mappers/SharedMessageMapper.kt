package co.kr.cobosys.baroder.models.mappers

import co.kr.cobosys.baroder.models.SharedMessageDataUI
import co.kr.cobosys.baroder.models.SharedMessageModelUI
import co.kr.cobosys.domain.base.mappers.Mapper
import co.kr.cobosys.domain.models.SharedMessageModel

class SharedMessageMapper : Mapper<SharedMessageModel, SharedMessageModelUI> {
    override fun mapLeftToRight(obj: SharedMessageModel): SharedMessageModelUI = with(obj) {
        SharedMessageModelUI(
            code = code,
            message = message,
            data = SharedMessageDataUI(data.contents)
        )
    }
}