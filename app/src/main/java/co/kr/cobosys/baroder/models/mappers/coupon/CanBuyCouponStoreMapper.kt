package co.kr.cobosys.baroder.models.mappers.coupon

import co.kr.cobosys.baroder.models.CanBuyCouponStoreUI
import co.kr.cobosys.domain.base.mappers.Mapper
import co.kr.cobosys.domain.models.CanBuyCouponStore

class CanBuyCouponStoreMapper: Mapper<CanBuyCouponStore, CanBuyCouponStoreUI> {
    override fun mapLeftToRight(obj: CanBuyCouponStore): CanBuyCouponStoreUI = with(obj) {
        CanBuyCouponStoreUI(
            canBuyCouponStoreList = canBuyCouponStoreList.map { canBuy ->
                CanBuyCouponStoreListMapper().mapLeftToRight(canBuy)
            }
        )
    }
}