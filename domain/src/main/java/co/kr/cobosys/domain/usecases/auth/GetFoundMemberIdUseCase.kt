package co.kr.cobosys.domain.usecases.auth

import co.kr.cobosys.domain.base.usecases.GeneralUseCase
import co.kr.cobosys.domain.models.FoundMemberId
import co.kr.cobosys.domain.repos.auth.FoundMemberIdRepo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetFoundMemberIdUseCase @Inject constructor(
    private val foundMemberId: FoundMemberIdRepo
) : GeneralUseCase<Flow<FoundMemberId>> {
    override fun invoke(): Flow<FoundMemberId> =
        foundMemberId.getFoundMemberId()
}