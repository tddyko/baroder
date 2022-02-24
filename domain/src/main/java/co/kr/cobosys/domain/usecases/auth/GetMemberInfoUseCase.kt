package co.kr.cobosys.domain.usecases.auth

import co.kr.cobosys.domain.base.usecases.GeneralUseCase
import co.kr.cobosys.domain.models.MemberInfoModel
import co.kr.cobosys.domain.repos.auth.MemberInfoRepo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetMemberInfoUseCase @Inject constructor(
    private val storeRepository: MemberInfoRepo
) : GeneralUseCase<Flow<MemberInfoModel>> {
    override suspend fun invoke(): Flow<MemberInfoModel> =
        storeRepository.getMemberInfo()
}