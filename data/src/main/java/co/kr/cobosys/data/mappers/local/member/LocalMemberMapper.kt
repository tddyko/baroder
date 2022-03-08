package co.kr.cobosys.data.mappers.local.member

import co.kr.cobosys.data.room.db.dto.RoomMember
import co.kr.cobosys.domain.models.LocalMember

fun LocalMember.toRoomMember(): RoomMember = RoomMember(
    uuid, id, pwd
)

fun RoomMember.toLocalMember(): LocalMember = LocalMember(
    uuid, id, pwd
)