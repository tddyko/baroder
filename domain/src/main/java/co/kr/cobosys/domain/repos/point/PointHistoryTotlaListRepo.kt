package co.kr.cobosys.domain.repos.point

import androidx.paging.PagingData
import co.kr.cobosys.domain.models.Total
import kotlinx.coroutines.flow.Flow

interface PointHistoryTotlaListRepo {
    fun getPointHistoryTotalList(): Flow<PagingData<Total>>
}