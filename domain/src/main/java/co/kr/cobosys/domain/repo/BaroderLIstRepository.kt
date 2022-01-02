package co.kr.cobosys.domain.repo

import androidx.paging.PagingData
import co.kr.cobosys.domain.model.favoriteStore
import co.kr.cobosys.domain.model.Store
import kotlinx.coroutines.flow.Flow

interface BaroderLIstRepository {

    fun getFavoriteStoreList(ids: String): Flow<PagingData<favoriteStore>>
    fun getStoreList(ids: String): Flow<PagingData<Store>>

}