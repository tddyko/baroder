package co.kr.cobosys.baroder.model.mappers.coupon

import co.kr.cobosys.baroder.model.CouponListUI
import co.kr.cobosys.domain.base.map.Mapper
import co.kr.cobosys.domain.model.CouponList

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