package co.kr.cobosys.domain.repo

import androidx.paging.PagingData
import co.kr.cobosys.domain.model.FavoriteStore
import co.kr.cobosys.domain.model.Store
import kotlinx.coroutines.flow.StateFlow

interface BaroderLIstRepository {

    fun getFavoriteStoreList(ids: String): StateFlow<PagingData<FavoriteStore>>
    fun getStoreList(ids: String): StateFlow<PagingData<Store>>

}