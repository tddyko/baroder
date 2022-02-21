package co.kr.cobosys.data.mappers.coupon

import co.kr.cobosys.data.api.CouponResponse
import co.kr.cobosys.domain.base.mappers.Mapper
import co.kr.cobosys.domain.models.Coupon

class CouponMapper: Mapper<CouponResponse, Coupon> {
    override fun mapLeftToRight(obj: CouponResponse): Coupon = with(obj) {
        Coupon(
            count = count,
            couponList = couponList.map { couponList ->
                CouponListMapper().mapLeftToRight(couponList)
            }
        )
    }
}