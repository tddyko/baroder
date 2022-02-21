package co.kr.cobosys.domain.repos.coupon

import co.kr.cobosys.domain.models.Coupon
import kotlinx.coroutines.flow.Flow

interface CouponRepo {
    fun getCoupon(ids: String): Flow<Coupon>
}