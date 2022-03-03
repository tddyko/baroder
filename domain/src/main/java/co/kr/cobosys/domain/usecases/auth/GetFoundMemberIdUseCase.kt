package co.kr.cobosys.domain.usecases.auth

import co.kr.cobosys.domain.base.usecases.GeneralUseCase
import co.kr.cobosys.domain.models.FoundMemberIdModel
import co.kr.cobosys.domain.repos.auth.FoundMemberIdRepo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetFoundMemberIdUseCase @Inject constructor(
    private val foundMemberId: FoundMemberIdRepo
) : GeneralUseCase<Flow<FoundMemberIdModel>> {
    override suspend fun invoke(): Flow<FoundMemberIdModel> =
        foundMemberId.getFoundMemberId()
}