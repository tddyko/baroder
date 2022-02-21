package co.kr.cobosys.baroder.models.mappers.coupon

import co.kr.cobosys.baroder.models.CouponPolicyUI
import co.kr.cobosys.domain.base.mappers.Mapper
import co.kr.cobosys.domain.models.CouponPolicy

class CouponPolicyMapper: Mapper<CouponPolicy, CouponPolicyUI> {
    override fun mapLeftToRight(obj: CouponPolicy): CouponPolicyUI = with(obj) {
        CouponPolicyUI(
            couponPolicyList = couponPolicyList.map { couponPolicy ->
                CouponPolicyListMapper().mapLeftToRight(couponPolicy)
            }
        )
    }
}