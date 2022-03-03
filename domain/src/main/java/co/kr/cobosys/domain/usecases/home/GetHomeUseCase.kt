package co.kr.cobosys.domain.usecases.home

import co.kr.cobosys.domain.base.usecases.GeneralUseCase
import co.kr.cobosys.domain.models.HomeModel
import co.kr.cobosys.domain.repos.home.HomeRepo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetHomeUseCase @Inject constructor(
    private val storeRepository: HomeRepo
) : GeneralUseCase<Flow<HomeModel>> {
    override suspend fun invoke(): Flow<HomeModel> =
        storeRepository.getHome()
}