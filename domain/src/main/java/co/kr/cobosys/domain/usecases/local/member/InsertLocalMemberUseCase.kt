package co.kr.cobosys.domain.usecases.local.member

import co.kr.cobosys.domain.base.usecases.GeneralNotTypeParamsUseCase
import co.kr.cobosys.domain.models.LocalMember
import co.kr.cobosys.domain.repos.local.member.LocalMemberRepo
import javax.inject.Inject

class InsertLocalMemberUseCase @Inject constructor(
    private val localMember: LocalMemberRepo
): GeneralNotTypeParamsUseCase<LocalMember, InsertLocalMemberParams>{
    override suspend fun invoke(params: InsertLocalMemberParams) = localMember.insertMember(member = params.member)

}

@JvmInline
value class InsertLocalMemberParams(val member: LocalMember)