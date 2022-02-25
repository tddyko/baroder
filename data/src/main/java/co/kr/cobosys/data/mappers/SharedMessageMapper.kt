package co.kr.cobosys.data.mappers

import co.kr.cobosys.data.api.SharedMessageResponseModel
import co.kr.cobosys.domain.base.mappers.Mapper
import co.kr.cobosys.domain.models.SharedMessageData
import co.kr.cobosys.domain.models.SharedMessageModel

class SharedMessageMapper: Mapper<SharedMessageResponseModel, SharedMessageModel> {
    override fun mapLeftToRight(obj: SharedMessageResponseModel): SharedMessageModel = with(obj) {
      SharedMessageModel(
          code = code,
          message = message,
          data = SharedMessageData(data.contents)
      )
    }
}