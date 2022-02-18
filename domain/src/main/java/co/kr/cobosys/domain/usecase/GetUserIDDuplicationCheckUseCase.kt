package co.kr.cobosys.domain.usecase

import co.kr.cobosys.domain.base.usecase.GeneralPagingUseCase
import co.kr.cobosys.domain.base.usecase.GeneralUseCase
import co.kr.cobosys.domain.model.UserIDDuplicationCheck
import co.kr.cobosys.domain.repo.BaroderRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetUserIDDuplicationCheckUseCase @Inject constructor(
    private val storeRepository: BaroderRepository
) : GeneralUseCase<Flow<UserIDDuplicationCheck>> {
    override fun invoke(): Flow<UserIDDuplicationCheck> =
        storeRepository.getUserIDDuplicationCheck()
}