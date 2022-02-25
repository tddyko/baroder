package co.kr.cobosys.data.mappers.coupon

import co.kr.cobosys.data.api.CanBuyCouponStoreResponseModel
import co.kr.cobosys.domain.base.mappers.Mapper
import co.kr.cobosys.domain.models.CanBuyCouponStoreData
import co.kr.cobosys.domain.models.CanBuyCouponStoreModel

class CanBuyCouponStoreMapper: Mapper<CanBuyCouponStoreResponseModel, CanBuyCouponStoreModel> {
    override fun mapLeftToRight(obj: CanBuyCouponStoreResponseModel): CanBuyCouponStoreModel = with(obj) {
        CanBuyCouponStoreModel(
            code = code,
            message = message,
            data = CanBuyCouponStoreData(data.canBuyCouponStoreList.map { list ->
                CanBuyCouponStoreListMapper().mapLeftToRight(list.copy())
            })
        )
    }
}