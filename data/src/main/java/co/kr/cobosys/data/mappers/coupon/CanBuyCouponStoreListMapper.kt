package co.kr.cobosys.data.mappers.coupon

import co.kr.cobosys.data.api.CanBuyCouponStoreListResponse
import co.kr.cobosys.domain.base.map.Mapper
import co.kr.cobosys.domain.model.CanBuyCouponStoreList

class CanBuyCouponStoreListMapper: Mapper<CanBuyCouponStoreListResponse, CanBuyCouponStoreList> {
    override fun mapLeftToRight(obj: CanBuyCouponStoreListResponse): CanBuyCouponStoreList = with(obj) {
        CanBuyCouponStoreList(
            code = code,
            storeName = storeName,
            remainPoint = remainPoint
        )
    }
}