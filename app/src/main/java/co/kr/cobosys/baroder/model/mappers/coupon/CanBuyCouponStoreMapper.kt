package co.kr.cobosys.baroder.model.mappers.coupon

import co.kr.cobosys.baroder.model.CanBuyCouponStoreUI
import co.kr.cobosys.domain.base.map.Mapper
import co.kr.cobosys.domain.model.CanBuyCouponStore

class CanBuyCouponStoreMapper: Mapper<CanBuyCouponStore, CanBuyCouponStoreUI> {
    override fun mapLeftToRight(obj: CanBuyCouponStore): CanBuyCouponStoreUI = with(obj) {
        CanBuyCouponStoreUI(
            canBuyCouponStoreList = canBuyCouponStoreList.map { canBuy ->
                CanBuyCouponStoreListMapper().mapLeftToRight(canBuy)
            }
        )
    }
}