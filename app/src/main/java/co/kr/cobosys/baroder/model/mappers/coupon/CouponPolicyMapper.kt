package co.kr.cobosys.baroder.model.mappers.coupon

import co.kr.cobosys.baroder.model.CouponPolicyUI
import co.kr.cobosys.domain.base.map.Mapper
import co.kr.cobosys.domain.model.CouponPolicy

class CouponPolicyMapper: Mapper<CouponPolicy, CouponPolicyUI> {
    override fun mapLeftToRight(obj: CouponPolicy): CouponPolicyUI = with(obj) {
        CouponPolicyUI(
            couponPolicyList = couponPolicyList.map { couponPolicy ->
                CouponPolicyListMapper().mapLeftToRight(couponPolicy)
            }
        )
    }
}