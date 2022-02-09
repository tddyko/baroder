package co.kr.cobosys.domain.usecase

import co.kr.cobosys.domain.base.usecase.GeneralUseCase
import co.kr.cobosys.domain.model.PointList
import co.kr.cobosys.domain.repo.BaroderListRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetFavoriteStoreListUseCase @Inject constructor(
    private val baroderListRepository: BaroderListRepository
) : GeneralUseCase<Flow<PointList>, GetPointListParams> {
    override fun invoke(params: GetPointListParams): Flow<PointList> =
        baroderListRepository.getPointList(params.ids)
}

@JvmInline
value class GetPointListParams(val ids: String)