package co.kr.cobosys.domain.usecases

import co.kr.cobosys.domain.base.usecases.GeneralUseCase
import co.kr.cobosys.domain.models.SharedMessage
import co.kr.cobosys.domain.repos.SharedMessageRepo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetSharedMessageUseCase @Inject constructor(
    private val storeRepository: SharedMessageRepo
) : GeneralUseCase<Flow<SharedMessage>> {
    override suspend fun invoke(): Flow<SharedMessage> =
        storeRepository.getSharedMessage()
}