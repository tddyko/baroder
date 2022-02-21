package co.kr.cobosys.baroder.models.mappers

import co.kr.cobosys.baroder.models.SharedMessageUI
import co.kr.cobosys.domain.base.mappers.Mapper
import co.kr.cobosys.domain.models.SharedMessage

class SharedMessageMapper: Mapper<SharedMessage, SharedMessageUI> {
    override fun mapLeftToRight(obj: SharedMessage): SharedMessageUI = with(obj) {
       SharedMessageUI(
           contents = contents
       )
    }
}