package co.kr.cobosys.data.mappers.coupon

import co.kr.cobosys.data.api.CouponListResponse
import co.kr.cobosys.domain.base.map.Mapper
import co.kr.cobosys.domain.model.CouponList

class CouponListMapper: Mapper<CouponListResponse, CouponList> {
    override fun mapLeftToRight(obj: CouponListResponse): CouponList = with(obj) {
        CouponList(
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