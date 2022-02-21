package co.kr.cobosys.domain.repos.store

import androidx.paging.PagingData
import co.kr.cobosys.domain.models.StoreList
import kotlinx.coroutines.flow.Flow

interface StoreListRepo {
    fun getStoreList(ids: String): Flow<PagingData<StoreList>>
}