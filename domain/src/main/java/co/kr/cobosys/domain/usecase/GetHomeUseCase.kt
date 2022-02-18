package co.kr.cobosys.domain.usecase

import co.kr.cobosys.domain.base.usecase.GeneralPagingUseCase
import co.kr.cobosys.domain.base.usecase.GeneralUseCase
import co.kr.cobosys.domain.model.Home
import co.kr.cobosys.domain.repo.BaroderRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetHomeUseCase @Inject constructor(
    private val storeRepository: BaroderRepository
) : GeneralUseCase<Flow<Home>> {
    override fun invoke(): Flow<Home> =
        storeRepository.getHome()
}