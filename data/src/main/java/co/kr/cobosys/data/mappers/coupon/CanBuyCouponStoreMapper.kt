package co.kr.cobosys.data.mappers.coupon

import co.kr.cobosys.data.api.CanBuyCouponStoreListResponse
import co.kr.cobosys.data.api.CanBuyCouponStoreResponseData
import co.kr.cobosys.data.api.CanBuyCouponStoreResponseModel
import co.kr.cobosys.domain.models.CanBuyCouponStoreData
import co.kr.cobosys.domain.models.CanBuyCouponStoreList
import co.kr.cobosys.domain.models.CanBuyCouponStoreModel

fun CanBuyCouponStoreResponseModel.toCanBuyCouponStoreModel(): CanBuyCouponStoreModel = CanBuyCouponStoreModel(
    code, message, data = CanBuyCouponStoreData(data.canBuyCouponStoreList.map { list ->
        CanBuyCouponStoreList(
            list.code,
            list.storeName,
            list.remainPoint
        )
    })
)

fun CanBuyCouponStoreModel.toCanBuyCouponStoreResponseModel(): CanBuyCouponStoreResponseModel = CanBuyCouponStoreResponseModel(
    code, message, data = CanBuyCouponStoreResponseData(data.canBuyCouponStoreList.map { list ->
        CanBuyCouponStoreListResponse(
            list.code,
            list.storeName,
            list.remainPoint
        )
    })
)