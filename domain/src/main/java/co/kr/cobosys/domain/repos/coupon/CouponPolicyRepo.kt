package co.kr.cobosys.domain.repos.coupon

import co.kr.cobosys.domain.models.CouponPolicyModel


interface CouponPolicyRepo {
    fun getCouponPolicy(): CouponPolicyModel
}