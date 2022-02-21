package co.kr.cobosys.domain.repos.coupon

import co.kr.cobosys.domain.models.CouponPolicyList
import kotlinx.coroutines.flow.Flow

interface CouponPolicyListRepo {
    fun getCouponPolicyList(): Flow<CouponPolicyList>
}