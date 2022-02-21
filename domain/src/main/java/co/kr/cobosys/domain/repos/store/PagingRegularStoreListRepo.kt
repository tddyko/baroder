package co.kr.cobosys.domain.repos.store

import androidx.paging.PagingData
import co.kr.cobosys.domain.models.RegularStoreList
import kotlinx.coroutines.flow.Flow

interface PagingRegularStoreListRepo {
    fun getPagingRegularStoreList(ids: String): Flow<PagingData<RegularStoreList>>
}