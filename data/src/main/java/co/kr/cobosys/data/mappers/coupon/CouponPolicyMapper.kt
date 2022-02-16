package co.kr.cobosys.data.mappers.coupon

import co.kr.cobosys.data.api.CouponPolicyResponse
import co.kr.cobosys.domain.base.map.Mapper
import co.kr.cobosys.domain.model.CouponPolicy

class CouponPolicyMapper: Mapper<CouponPolicyResponse, CouponPolicy> {
    override fun mapLeftToRight(obj: CouponPolicyResponse): CouponPolicy = with(obj) {
        CouponPolicy(
            couponPolicyList = couponPolicyList.map { couponPolicy ->
                CouponPolicyListMapper().mapLeftToRight(couponPolicy)
            }
        )
    }
}