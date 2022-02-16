package co.kr.cobosys.baroder.model.mappers

import co.kr.cobosys.baroder.model.SharedMessageUI
import co.kr.cobosys.domain.base.map.Mapper
import co.kr.cobosys.domain.model.SharedMessage

class SharedMessageMapper: Mapper<SharedMessage, SharedMessageUI> {
    override fun mapLeftToRight(obj: SharedMessage): SharedMessageUI = with(obj) {
       SharedMessageUI(
           contents = contents
       )
    }
}