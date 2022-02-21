package co.kr.cobosys.domain.usecases.point

import androidx.paging.PagingData
import co.kr.cobosys.domain.base.usecases.GeneralPagingUseCase
import co.kr.cobosys.domain.models.PointList
import co.kr.cobosys.domain.repos.point.PointListRepo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetPagingPointListUseCase @Inject constructor(
    private val pointList: PointListRepo
) : GeneralPagingUseCase<Flow<PagingData<PointList>>, GetPointListParams> {
    override fun invoke(params: GetPointListParams): Flow<PagingData<PointList>> =
        pointList.getPointList(params.ids)
}

@JvmInline
value class GetPointListParams(val ids: String)