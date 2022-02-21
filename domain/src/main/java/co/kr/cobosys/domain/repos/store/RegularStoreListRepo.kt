package co.kr.cobosys.domain.repos.store

import co.kr.cobosys.domain.models.RegularStoreList
import kotlinx.coroutines.flow.Flow

interface RegularStoreListRepo {
    fun getRegularStoreList(ids: String): Flow<RegularStoreList>
}