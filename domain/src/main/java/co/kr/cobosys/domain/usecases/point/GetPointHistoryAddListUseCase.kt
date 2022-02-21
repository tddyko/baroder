package co.kr.cobosys.domain.usecases.point

import androidx.paging.PagingData
import co.kr.cobosys.domain.base.usecases.GeneralUseCase
import co.kr.cobosys.domain.models.Add
import co.kr.cobosys.domain.repos.point.PointHistoryAddListRepo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetPointHistoryAddListUseCase @Inject constructor(
    private val pointHistoryAddList: PointHistoryAddListRepo
) : GeneralUseCase<Flow<PagingData<Add>>> {
    override fun invoke(): Flow<PagingData<Add>> =
        pointHistoryAddList.getPointHistoryAddList()
}