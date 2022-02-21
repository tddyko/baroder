package co.kr.cobosys.domain.repos.coupon

import co.kr.cobosys.domain.models.CanBuyCouponStoreList
import kotlinx.coroutines.flow.Flow

interface CanBuyCouponStoreListRepo {
    fun getCanBuyCouponStoreList(ids: String): Flow<CanBuyCouponStoreList>
}