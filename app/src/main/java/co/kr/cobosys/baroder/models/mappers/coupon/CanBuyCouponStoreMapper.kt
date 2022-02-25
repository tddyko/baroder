package co.kr.cobosys.baroder.models.mappers.coupon

import co.kr.cobosys.baroder.models.CanBuyCouponStoreDataUI
import co.kr.cobosys.baroder.models.CanBuyCouponStoreModelUI
import co.kr.cobosys.domain.base.mappers.Mapper
import co.kr.cobosys.domain.models.CanBuyCouponStoreModel

class CanBuyCouponStoreMapper : Mapper<CanBuyCouponStoreModel, CanBuyCouponStoreModelUI> {
    override fun mapLeftToRight(obj: CanBuyCouponStoreModel): CanBuyCouponStoreModelUI = with(obj) {
        CanBuyCouponStoreModelUI(
            code = code,
            message = message,
            data = CanBuyCouponStoreDataUI(
                data.canBuyCouponStoreList.map { data ->
                    CanBuyCouponStoreListMapper().mapLeftToRight(
                        data.copy()
                    )
                }
            )
        )
    }
}