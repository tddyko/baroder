package co.kr.cobosys.domain.repos.coupon

import co.kr.cobosys.domain.models.CouponPolicyModel
import kotlinx.coroutines.flow.Flow


interface CouponPolicyRepo {
    fun getCouponPolicy(): Flow<CouponPolicyModel>
}