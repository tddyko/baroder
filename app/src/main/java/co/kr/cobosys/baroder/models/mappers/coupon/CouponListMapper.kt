package co.kr.cobosys.baroder.models.mappers.coupon

import co.kr.cobosys.baroder.models.CouponListUI
import co.kr.cobosys.domain.base.mappers.Mapper
import co.kr.cobosys.domain.models.CouponList

class CouponListMapper: Mapper<CouponList, CouponListUI> {
    override fun mapLeftToRight(obj: CouponList): CouponListUI = with(obj) {
        CouponListUI(
            storeName = storeName,
            couponPrice = couponPrice,
            date = date,
            time = time,
            couponCode =couponCode,
            usedStatus = usedStatus,
            expiredDate = expiredDate,
            giftStatus = giftStatus,
            expiredStatus = expiredStatus
        )
    }
}