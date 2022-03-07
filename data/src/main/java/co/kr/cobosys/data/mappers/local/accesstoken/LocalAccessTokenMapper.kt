package co.kr.cobosys.data.mappers.local.accesstoken

import co.kr.cobosys.data.room.db.dto.RoomAccessToken
import co.kr.cobosys.domain.models.LocalAccessToken

fun LocalAccessToken.toRoomAccessToken(): RoomAccessToken = RoomAccessToken(
    accessToken
)

fun RoomAccessToken.toLocalAccessToken(): LocalAccessToken = LocalAccessToken(
    accessToken
)