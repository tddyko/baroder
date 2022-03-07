package co.kr.cobosys.domain.usecases.local.member

import co.kr.cobosys.domain.base.usecases.GeneralNotTypeUseCase
import co.kr.cobosys.domain.models.LocalMember
import co.kr.cobosys.domain.repos.local.member.LocalMemberRepo
import javax.inject.Inject

class DelLocalMemberUseCase @Inject constructor(
    private val localMember: LocalMemberRepo
): GeneralNotTypeUseCase<LocalMember> {
    override suspend fun invoke() = localMember.delLocalMember()
}