package co.kr.cobosys.domain.repo

import androidx.paging.PagingData
import co.kr.cobosys.domain.model.RegularStoreList
import co.kr.cobosys.domain.model.StoreList
import kotlinx.coroutines.flow.Flow

interface BaroderListRepository {

    fun getPointList(ids: String): Flow<RegularStoreList>
    fun getStoreList(ids: String): Flow<PagingData<StoreList>>
}