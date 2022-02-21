package co.kr.cobosys.domain.repos.coupon

import androidx.paging.PagingData
import co.kr.cobosys.domain.models.CanBuyCouponStoreList
import kotlinx.coroutines.flow.Flow

interface PagingCanBuyCouponStoreListRepo {
    fun getPagingCanBuyCouponStoreList(ids: String): Flow<PagingData<CanBuyCouponStoreList>>
}