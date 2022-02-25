package co.kr.cobosys.domain.usecases.auth

import co.kr.cobosys.domain.base.usecases.GeneralUseCase
import co.kr.cobosys.domain.models.FoundMemberIdModel
import co.kr.cobosys.domain.repos.auth.FoundMemberIdRepo
import javax.inject.Inject

class GetFoundMemberIdUseCase @Inject constructor(
    private val foundMemberId: FoundMemberIdRepo
) : GeneralUseCase<FoundMemberIdModel> {
    override suspend fun invoke(): FoundMemberIdModel =
        foundMemberId.getFoundMemberId()
}