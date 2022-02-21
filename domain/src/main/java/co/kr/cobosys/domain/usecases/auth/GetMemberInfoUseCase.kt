package co.kr.cobosys.domain.usecases.auth

import co.kr.cobosys.domain.base.usecases.GeneralUseCase
import co.kr.cobosys.domain.models.MemberInfo
import co.kr.cobosys.domain.repos.auth.MemberInfoRepo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetMemberInfoUseCase @Inject constructor(
    private val storeRepository: MemberInfoRepo
) : GeneralUseCase<Flow<MemberInfo>> {
    override suspend fun invoke(): Flow<MemberInfo> =
        storeRepository.getMemberInfo()
}