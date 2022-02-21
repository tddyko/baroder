package co.kr.cobosys.domain.repos.store

import co.kr.cobosys.domain.models.StoreDetail
import kotlinx.coroutines.flow.Flow

interface StoreDetailRepo {
    fun getStoreDetail(ids: String): Flow<StoreDetail>
}