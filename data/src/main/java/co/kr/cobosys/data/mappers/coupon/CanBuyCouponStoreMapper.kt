package co.kr.cobosys.data.mappers.coupon

import co.kr.cobosys.data.api.CanBuyCouponStoreResponse
import co.kr.cobosys.domain.base.mappers.Mapper
import co.kr.cobosys.domain.models.CanBuyCouponStore

class CanBuyCouponStoreMapper: Mapper<CanBuyCouponStoreResponse, CanBuyCouponStore> {
    override fun mapLeftToRight(obj: CanBuyCouponStoreResponse): CanBuyCouponStore = with(obj) {
        CanBuyCouponStore(
            canBuyCouponStoreList = canBuyCouponStoreList.map { canBuy ->
                CanBuyCouponStoreListMapper().mapLeftToRight(canBuy)
            }
        )
    }
}