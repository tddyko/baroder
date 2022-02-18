package co.kr.cobosys.domain.usecase

import co.kr.cobosys.domain.base.usecase.GeneralUseCase
import co.kr.cobosys.domain.model.FoundMemberPwd
import co.kr.cobosys.domain.repo.BaroderRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetFoundMemberPwdUseCase @Inject constructor(
    private val foundMemberPwd: BaroderRepository
) : GeneralUseCase<Flow<FoundMemberPwd>> {
    override fun invoke(): Flow<FoundMemberPwd> =
        foundMemberPwd.getFoundMemberPwd()
}