package co.kr.cobosys.baroder.models.mappers

import co.kr.cobosys.baroder.models.SharedMessageDataUI
import co.kr.cobosys.baroder.models.SharedMessageModelUI
import co.kr.cobosys.domain.models.SharedMessageData
import co.kr.cobosys.domain.models.SharedMessageModel

fun SharedMessageModelUI.toSharedMsgModel(): SharedMessageModel = SharedMessageModel(
    code, message, data = SharedMessageData(data.contents)
)

fun SharedMessageModel.toSharedMsgModelUI(): SharedMessageModelUI = SharedMessageModelUI(
    code, message, data = SharedMessageDataUI(data.contents)
)