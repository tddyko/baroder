package co.kr.cobosys.domain.usecases.point

import androidx.paging.PagingData
import co.kr.cobosys.domain.base.usecases.GeneralUseCase
import co.kr.cobosys.domain.models.Use
import co.kr.cobosys.domain.repos.point.PointhistoryUseListRepo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetPointHistoryUseListUseCase @Inject constructor(
    private val pointHistoryUseList: PointhistoryUseListRepo
) : GeneralUseCase<Flow<PagingData<Use>>> {
    override fun invoke(): Flow<PagingData<Use>> =
        pointHistoryUseList.getPointhistoryUseList()
}