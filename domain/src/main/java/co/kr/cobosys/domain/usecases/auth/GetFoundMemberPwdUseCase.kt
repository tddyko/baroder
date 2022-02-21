package co.kr.cobosys.domain.usecases.auth

import co.kr.cobosys.domain.base.usecases.GeneralUseCase
import co.kr.cobosys.domain.models.FoundMemberPwd
import co.kr.cobosys.domain.repos.auth.FoundMemberPwdRepo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetFoundMemberPwdUseCase @Inject constructor(
    private val foundMemberPwd: FoundMemberPwdRepo
) : GeneralUseCase<Flow<FoundMemberPwd>> {
    override suspend fun invoke(): Flow<FoundMemberPwd> =
        foundMemberPwd.getFoundMemberPwd()
}