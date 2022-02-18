package co.kr.cobosys.domain.usecase

import co.kr.cobosys.domain.base.usecase.GeneralUseCase
import co.kr.cobosys.domain.model.MemberInfo
import co.kr.cobosys.domain.repo.BaroderRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetMemberInfoUseCase @Inject constructor(
    private val storeRepository: BaroderRepository
) : GeneralUseCase<Flow<MemberInfo>> {
    override fun invoke(): Flow<MemberInfo> =
        storeRepository.getMemberInfo()
}