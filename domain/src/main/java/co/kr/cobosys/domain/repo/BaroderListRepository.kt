package co.kr.cobosys.domain.repo

import androidx.paging.PagingData
import co.kr.cobosys.domain.model.PointList
import co.kr.cobosys.domain.model.Store
import kotlinx.coroutines.flow.Flow

interface BaroderListRepository {

    fun getPointList(ids: String): Flow<PointList>
    fun getStoreList(ids: String): Flow<PagingData<Store>>
}