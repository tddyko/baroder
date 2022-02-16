package co.kr.cobosys.baroder.model.mappers.coupon

import co.kr.cobosys.baroder.model.CanBuyCouponStoreListUi
import co.kr.cobosys.domain.base.map.Mapper
import co.kr.cobosys.domain.model.CanBuyCouponStoreList

class CanBuyCouponStoreListMapper: Mapper<CanBuyCouponStoreList, CanBuyCouponStoreListUi> {
    override fun mapLeftToRight(obj: CanBuyCouponStoreList): CanBuyCouponStoreListUi = with(obj) {
        CanBuyCouponStoreListUi(
            code = code,
            storeName = storeName,
            remainPoint = remainPoint
        )
    }
}