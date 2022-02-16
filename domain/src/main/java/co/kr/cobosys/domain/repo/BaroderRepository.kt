package co.kr.cobosys.domain.repo

import androidx.paging.PagingData
import co.kr.cobosys.domain.model.*
import kotlinx.coroutines.flow.Flow

interface BaroderRepository {
    fun getAccessToken(ids: String): Flow<AccessToken>
    fun getMemberInfo(ids: String): Flow<MemberInfo>
    fun getHome(ids: String): Flow<Home>
    fun getPointList(ids: String): Flow<RegularStoreList>
    fun getStoreList(ids: String): Flow<PagingData<StoreList>>
}