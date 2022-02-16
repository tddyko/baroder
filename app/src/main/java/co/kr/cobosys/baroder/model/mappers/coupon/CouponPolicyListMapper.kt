package co.kr.cobosys.baroder.model.mappers.coupon

import co.kr.cobosys.baroder.model.CouponPolicyListUI
import co.kr.cobosys.domain.base.map.Mapper
import co.kr.cobosys.domain.model.CouponPolicyList

class CouponPolicyListMapper: Mapper<CouponPolicyList, CouponPolicyListUI> {
    override fun mapLeftToRight(obj: CouponPolicyList): CouponPolicyListUI = with(obj) {
        CouponPolicyListUI(
            couponNumber = couponNumber,
            couponPrice = couponPrice
        )
    }
}