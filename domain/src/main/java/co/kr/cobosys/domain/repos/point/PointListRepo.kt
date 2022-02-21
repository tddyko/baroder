package co.kr.cobosys.domain.repos.point

import androidx.paging.PagingData
import co.kr.cobosys.domain.models.PointList
import kotlinx.coroutines.flow.Flow

interface PointListRepo {
    fun getPointList(ids: String): Flow<PagingData<PointList>>
}