package co.kr.cobosys.domain.repos.point

import co.kr.cobosys.domain.models.PointHistory
import kotlinx.coroutines.flow.Flow

interface PointHistoryRepo {
    fun getPointHistoryAddList(): Flow<PointHistory>
}