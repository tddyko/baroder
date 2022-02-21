package co.kr.cobosys.baroder.models.mappers.coupon

import co.kr.cobosys.baroder.models.CouponPolicyListUI
import co.kr.cobosys.domain.base.mappers.Mapper
import co.kr.cobosys.domain.models.CouponPolicyList

class CouponPolicyListMapper: Mapper<CouponPolicyList, CouponPolicyListUI> {
    override fun mapLeftToRight(obj: CouponPolicyList): CouponPolicyListUI = with(obj) {
        CouponPolicyListUI(
            couponNumber = couponNumber,
            couponPrice = couponPrice
        )
    }
}