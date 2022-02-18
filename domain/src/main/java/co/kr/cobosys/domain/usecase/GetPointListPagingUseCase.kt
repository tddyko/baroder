package co.kr.cobosys.domain.usecase

import androidx.paging.PagingData
import co.kr.cobosys.domain.base.usecase.GeneralPagingUseCase
import co.kr.cobosys.domain.model.PointList
import co.kr.cobosys.domain.repo.BaroderRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetPointListPagingUseCase @Inject constructor(
    private val pointList: BaroderRepository
) : GeneralPagingUseCase<Flow<PagingData<PointList>>, GetPointListParams> {
    override fun invoke(params: GetPointListParams): Flow<PagingData<PointList>> =
        pointList.getPointList(params.ids)
}

@JvmInline
value class GetPointListParams(val ids: String)