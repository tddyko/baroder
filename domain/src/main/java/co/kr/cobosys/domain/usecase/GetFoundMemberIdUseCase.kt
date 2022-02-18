package co.kr.cobosys.domain.usecase

import co.kr.cobosys.domain.base.usecase.GeneralUseCase
import co.kr.cobosys.domain.model.FoundMemberId
import co.kr.cobosys.domain.repo.BaroderRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetFoundMemberIdUseCase @Inject constructor(
    private val foundMemberId: BaroderRepository
) : GeneralUseCase<Flow<FoundMemberId>> {
    override fun invoke(): Flow<FoundMemberId> =
        foundMemberId.getFoundMemberId()
}