package co.kr.cobosys.data.mappers

import co.kr.cobosys.data.api.SharedMessageResponseData
import co.kr.cobosys.data.api.SharedMessageResponseModel
import co.kr.cobosys.domain.models.SharedMessageData
import co.kr.cobosys.domain.models.SharedMessageModel

fun SharedMessageModel.toResponseShareMsgModel(): SharedMessageResponseModel = SharedMessageResponseModel(
    code, message, data = SharedMessageResponseData(data.contents)
)

fun SharedMessageResponseModel.toSharedMsgModel(): SharedMessageModel = SharedMessageModel(
    code, message, data = SharedMessageData(data.contents)
)