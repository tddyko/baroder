package co.kr.cobosys.domain.usecases.point

import androidx.paging.PagingData
import co.kr.cobosys.domain.base.usecases.GeneralUseCase
import co.kr.cobosys.domain.models.Total
import co.kr.cobosys.domain.repos.point.PointHistoryTotlaListRepo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetPointHistoryTotalListUseCase @Inject constructor(
    private val pointHistoryTotalList: PointHistoryTotlaListRepo
) : GeneralUseCase<Flow<PagingData<Total>>> {
    override suspend fun invoke(): Flow<PagingData<Total>> =
        pointHistoryTotalList.getPointHistoryTotalList()
}