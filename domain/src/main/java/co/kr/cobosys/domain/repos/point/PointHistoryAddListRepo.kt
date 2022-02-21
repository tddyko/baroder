package co.kr.cobosys.domain.repos.point

import androidx.paging.PagingData
import co.kr.cobosys.domain.models.Add
import kotlinx.coroutines.flow.Flow

interface PointHistoryAddListRepo {
    fun getPointHistoryAddList(): Flow<PagingData<Add>>
}