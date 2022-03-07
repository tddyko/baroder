package co.kr.cobosys.domain.usecases.local.member

import co.kr.cobosys.domain.base.usecases.GeneralUseCase
import co.kr.cobosys.domain.models.LocalMember
import co.kr.cobosys.domain.repos.local.member.LocalMemberRepo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetLocalMemberUseCase @Inject constructor(
    private val localMember: LocalMemberRepo
): GeneralUseCase<Flow<List<LocalMember>>> {
    override suspend fun invoke(): Flow<List<LocalMember>> = localMember.getLocalMember()

}