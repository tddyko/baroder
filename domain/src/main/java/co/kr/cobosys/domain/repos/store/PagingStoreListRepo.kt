package co.kr.cobosys.domain.repos.store

import androidx.paging.PagingData
import co.kr.cobosys.domain.models.StoreList
import kotlinx.coroutines.flow.Flow

interface PagingStoreListRepo {
    fun getPagingStoreList(ids: String): Flow<PagingData<StoreList>>
}