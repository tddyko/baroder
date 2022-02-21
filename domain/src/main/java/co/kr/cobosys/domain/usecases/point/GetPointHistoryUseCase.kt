package co.kr.cobosys.domain.usecases.point

import co.kr.cobosys.domain.base.usecases.GeneralUseCase
import co.kr.cobosys.domain.models.Home
import co.kr.cobosys.domain.models.PointHistory
import co.kr.cobosys.domain.repos.home.HomeRepo
import co.kr.cobosys.domain.repos.point.PointHistoryRepo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetPointHistoryUseCase @Inject constructor(
    private val pointHistory: PointHistoryRepo
) : GeneralUseCase<Flow<PointHistory>> {
    override suspend fun invoke(): Flow<PointHistory> =
        pointHistory.getPointHistoryAddList()
}