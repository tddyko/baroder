package co.kr.cobosys.baroder.models.mappers.coupon

import co.kr.cobosys.baroder.models.CouponUI
import co.kr.cobosys.domain.base.mappers.Mapper
import co.kr.cobosys.domain.models.Coupon

class CouponMapper: Mapper<Coupon, CouponUI> {
    override fun mapLeftToRight(obj: Coupon): CouponUI = with(obj) {
        CouponUI(
            count = count,
            couponList = couponList.map { couponList ->
                CouponListMapper().mapLeftToRight(couponList)
            }
        )
    }
}