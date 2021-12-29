package co.kr.cobosys.domain.repo

import androidx.paging.PagingData
import co.kr.cobosys.domain.model.FavoriteStore
import co.kr.cobosys.domain.model.Store
import kotlinx.coroutines.flow.Flow

interface BaroderLIstRepository {

    fun getFavoriteStoreList(ids: String): Flow<PagingData<FavoriteStore>>
    fun getStoreList(ids: String): Flow<PagingData<Store>>

}