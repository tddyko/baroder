package co.kr.cobosys.baroder.models.mappers.coupon

import co.kr.cobosys.baroder.models.CouponModelUI
import co.kr.cobosys.domain.models.CouponData
import co.kr.cobosys.domain.models.CouponList
import co.kr.cobosys.domain.models.CouponModel

fun CouponModelUI.toCouponModel(): CouponModel = CouponModel(
    code, message, data = data.map { data ->
        CouponData(
            data.count, data.couponList.map { list ->
            CouponList(
                list.storeName,
                list.couponPrice,
                list.date,
                list.time,
                list.couponCode,
                list.usedStatus,
                list.expiredDate,
                list.giftStatus,
                list.expiredStatus
            )
        })
    }
)

fun CouponModel.toCouponModelUI(): CouponModel = CouponModel(
    code, message, data = data.map { data ->
        CouponData(
            data.count, data.couponList.map { list ->
                CouponList(
                    list.storeName,
                    list.couponPrice,
                    list.date,
                    list.time,
                    list.couponCode,
                    list.usedStatus,
                    list.expiredDate,
                    list.giftStatus,
                    list.expiredStatus
                )
            }
        )
    }
)