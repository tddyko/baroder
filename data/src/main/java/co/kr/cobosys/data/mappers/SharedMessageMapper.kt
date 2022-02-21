package co.kr.cobosys.data.mappers

import co.kr.cobosys.data.api.SharedMessageResponse
import co.kr.cobosys.domain.base.mappers.Mapper
import co.kr.cobosys.domain.models.SharedMessage

class SharedMessageMapper: Mapper<SharedMessageResponse, SharedMessage> {
    override fun mapLeftToRight(obj: SharedMessageResponse): SharedMessage = with(obj) {
       SharedMessage(
           contents = contents
       )
    }
}