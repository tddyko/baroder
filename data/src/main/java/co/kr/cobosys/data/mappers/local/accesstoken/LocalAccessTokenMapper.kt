package co.kr.cobosys.data.mappers.local.accesstoken

import co.kr.cobosys.data.room.db.dto.RoomAccessToken
import co.kr.cobosys.domain.models.LocalAccessToken

fun LocalAccessToken.toRoomAccessToken(): RoomAccessToken = RoomAccessToken(
    uuid, accessToken
)

fun RoomAccessToken.toLocalAccessToken(): LocalAccessToken = LocalAccessToken(
    uuid, accessToken
)