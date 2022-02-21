package co.kr.cobosys.data.mappers.coupon

import co.kr.cobosys.data.api.CouponPolicyListResponse
import co.kr.cobosys.domain.base.mappers.Mapper
import co.kr.cobosys.domain.models.CouponPolicyList

class CouponPolicyListMapper: Mapper<CouponPolicyListResponse, CouponPolicyList> {
    override fun mapLeftToRight(obj: CouponPolicyListResponse): CouponPolicyList = with(obj) {
        CouponPolicyList(
            couponNumber = couponNumber,
            couponPrice = couponPrice
        )
    }
}