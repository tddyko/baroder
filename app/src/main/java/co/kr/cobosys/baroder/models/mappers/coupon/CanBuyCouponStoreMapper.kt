package co.kr.cobosys.baroder.models.mappers.coupon

import co.kr.cobosys.baroder.models.CanBuyCouponStoreDataUI
import co.kr.cobosys.baroder.models.CanBuyCouponStoreListUI
import co.kr.cobosys.baroder.models.CanBuyCouponStoreModelUI
import co.kr.cobosys.domain.models.CanBuyCouponStoreData
import co.kr.cobosys.domain.models.CanBuyCouponStoreList
import co.kr.cobosys.domain.models.CanBuyCouponStoreModel

fun CanBuyCouponStoreModelUI.toCanBuyCouponstoreModel(): CanBuyCouponStoreModel =
    CanBuyCouponStoreModel(
        code, message, data = CanBuyCouponStoreData(data.canBuyCouponStoreList.map { list ->
            CanBuyCouponStoreList(
                list.code,
                list.storeName,
                list.remainPoint,
            )
        })
    )

fun CanBuyCouponStoreModel.toCanBuyCouponStoreModelUI(): CanBuyCouponStoreModelUI =
    CanBuyCouponStoreModelUI(
        code,
        message,
        data = CanBuyCouponStoreDataUI(data.canBuyCouponStoreList.map { list ->
            CanBuyCouponStoreListUI(
                list.code,
                list.storeName,
                list.remainPoint
            )
        })
    )