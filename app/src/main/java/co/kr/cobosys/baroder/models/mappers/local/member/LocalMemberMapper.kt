package co.kr.cobosys.baroder.models.mappers.local.member

import co.kr.cobosys.baroder.models.LocalMemberUI
import co.kr.cobosys.domain.models.LocalMember

fun LocalMemberUI.toLocalMember(): LocalMember = LocalMember(
    id, pwd
)

fun LocalMember.toLocalMemberUI(): LocalMemberUI = LocalMemberUI(
    id, pwd
)