package co.kr.cobosys.domain.repos.point

import androidx.paging.PagingData
import co.kr.cobosys.domain.models.Use
import kotlinx.coroutines.flow.Flow

interface PointhistoryUseListRepo {
    fun getPointhistoryUseList(): Flow<PagingData<Use>>
}