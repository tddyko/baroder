package co.kr.cobosys.domain.repos.coupon

import co.kr.cobosys.domain.models.CouponModel

interface CouponRepo {
    fun getCoupon(ids: String): CouponModel
}