package co.kr.cobosys.domain.repo

import androidx.paging.PagingData
import co.kr.cobosys.domain.model.*
import kotlinx.coroutines.flow.Flow

interface BaroderRepository {
    fun getAccessToken(ids: String): Flow<AccessToken>
    fun getMemberInfo(ids: String): Flow<MemberInfo>
    fun getsharedMessage(ids: String): Flow<SharedMessage>
    fun getUserIDDuplicationCheck(ids: String): Flow<UserIDDuplicationCheck>
    fun getCertifyCode(ids: String): Flow<CertifyCode>
    fun getFoundMemberId(ids: String): Flow<FoundMemberId>
    fun getFoundMemberPwd(ids: String): Flow<FoundMemberPwd>
    fun getTerms(ids: String): Flow<Terms>
    fun getHome(ids: String): Flow<Home>
    fun getPointList(ids: String): Flow<RegularStoreList>
    fun getStoreList(ids: String): Flow<PagingData<StoreList>>
}