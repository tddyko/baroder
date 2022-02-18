package co.kr.cobosys.domain.usecase

import co.kr.cobosys.domain.base.usecase.GeneralPagingUseCase
import co.kr.cobosys.domain.base.usecase.GeneralUseCase
import co.kr.cobosys.domain.model.SharedMessage
import co.kr.cobosys.domain.repo.BaroderRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetSharedMessageUseCase @Inject constructor(
    private val storeRepository: BaroderRepository
) : GeneralUseCase<Flow<SharedMessage>> {
    override fun invoke(): Flow<SharedMessage> =
        storeRepository.getSharedMessage()
}