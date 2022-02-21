package co.kr.cobosys.baroder.models.mappers.coupon

import co.kr.cobosys.baroder.models.CanBuyCouponStoreListUi
import co.kr.cobosys.domain.base.mappers.Mapper
import co.kr.cobosys.domain.models.CanBuyCouponStoreList

class CanBuyCouponStoreListMapper: Mapper<CanBuyCouponStoreList, CanBuyCouponStoreListUi> {
    override fun mapLeftToRight(obj: CanBuyCouponStoreList): CanBuyCouponStoreListUi = with(obj) {
        CanBuyCouponStoreListUi(
            code = code,
            storeName = storeName,
            remainPoint = remainPoint
        )
    }
}