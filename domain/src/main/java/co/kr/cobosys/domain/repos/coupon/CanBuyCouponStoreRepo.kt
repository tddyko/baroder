package co.kr.cobosys.domain.repos.coupon

import co.kr.cobosys.domain.models.CanBuyCouponStoreModel
import kotlinx.coroutines.flow.Flow

interface CanBuyCouponStoreRepo {
    fun getCanBuyCouponStore(ids: String): Flow<CanBuyCouponStoreModel>
}