package co.kr.cobosys.data.mappers.coupon

import co.kr.cobosys.data.api.CouponListResponse
import co.kr.cobosys.data.api.CouponResponseData
import co.kr.cobosys.data.api.CouponResponseModel
import co.kr.cobosys.domain.models.CouponData
import co.kr.cobosys.domain.models.CouponList
import co.kr.cobosys.domain.models.CouponModel

fun CouponResponseModel.toCouponModel(): CouponModel = CouponModel(
    code, message, data = data.map { data ->
        CouponData(
            data.count,
            data.couponList.map { list ->
                CouponList(
                    list.storeName,
                    list.couponPrice,
                    list.expiredDate,
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

fun CouponModel.toCouponResponseModel(): CouponResponseModel = CouponResponseModel(
    code, message, data = data.map { data ->
        CouponResponseData(
            data.count,
            data.couponList.map { list ->
                CouponListResponse(
                    list.storeName,
                    list.couponPrice,
                    list.expiredDate,
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