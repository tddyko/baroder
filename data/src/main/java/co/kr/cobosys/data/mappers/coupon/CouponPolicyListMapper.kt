package co.kr.cobosys.data.mappers.coupon

import co.kr.cobosys.data.api.CouponPolicyListResponse
import co.kr.cobosys.domain.base.map.Mapper
import co.kr.cobosys.domain.model.CouponPolicyList

class CouponPolicyListMapper: Mapper<CouponPolicyListResponse, CouponPolicyList> {
    override fun mapLeftToRight(obj: CouponPolicyListResponse): CouponPolicyList = with(obj) {
        CouponPolicyList(
            couponNumber = couponNumber,
            couponPrice = couponPrice
        )
    }
}