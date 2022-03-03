package co.kr.cobosys.domain.repos.coupon

import co.kr.cobosys.domain.models.CouponModel
import kotlinx.coroutines.flow.Flow

interface CouponRepo {
    fun getCoupon(ids: String): Flow<CouponModel>
}