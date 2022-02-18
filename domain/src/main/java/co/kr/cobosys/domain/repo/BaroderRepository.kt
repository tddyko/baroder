package co.kr.cobosys.domain.repo

import androidx.paging.PagingData
import co.kr.cobosys.domain.model.*
import kotlinx.coroutines.flow.Flow

interface BaroderRepository {
    fun getAccessToken(): Flow<AccessToken>
    fun getMemberInfo(): Flow<MemberInfo>
    fun getSharedMessage(): Flow<SharedMessage>
    fun getUserIDDuplicationCheck(): Flow<UserIDDuplicationCheck>
    fun getCertifyCode(): Flow<CertifyCode>
    fun getFoundMemberId(): Flow<FoundMemberId>
    fun getFoundMemberPwd(): Flow<FoundMemberPwd>
    fun getTerms(): Flow<Terms>
    fun getHome(): Flow<Home>
    fun getStoreList(ids: String): Flow<PagingData<StoreList>>
    fun getStoreDetail(ids: String): Flow<StoreDetail>
    fun getPagingRegularStoreList(ids: String): Flow<PagingData<RegularStoreList>>
    fun getRegularStoreList(ids: String): Flow<RegularStoreList>
    fun getPagingRecentlyVisitedStoreList(ids: String): Flow<PagingData<RecentlyVisitedStoreList>>
    fun getRecentlyVisitedStoreList(ids: String): Flow<RecentlyVisitedStoreList>
    fun getPointList(ids: String): Flow<PagingData<PointList>>
    fun getPointHistoryTotalList(ids: String): Flow<PagingData<Total>>
    fun getPointHistoryAddList(ids: String): Flow<PagingData<Add>>
    fun getPointhistoryUseList(ids: String): Flow<PagingData<Use>>
    fun getCouponPolicy(): Flow<CouponPolicy>
    fun getCoupon(ids: String): Flow<Coupon>
    fun getCouponList(ids: String): Flow<PagingData<CouponList>>
    fun getPagingCanBuyCouponStoreList(ids: String): Flow<PagingData<CanBuyCouponStoreList>>
    fun getCanBuyCouponStoreList(ids: String): Flow<CanBuyCouponStoreList>
}