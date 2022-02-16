package co.kr.cobosys.baroder.model.mappers.coupon

import co.kr.cobosys.baroder.model.CouponUI
import co.kr.cobosys.domain.base.map.Mapper
import co.kr.cobosys.domain.model.Coupon

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