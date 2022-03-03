package co.kr.cobosys.data.mappers.coupon

import co.kr.cobosys.data.api.CouponPolicyListResponse
import co.kr.cobosys.data.api.CouponPolicyResponseData
import co.kr.cobosys.data.api.CouponPolicyResponseModel
import co.kr.cobosys.domain.models.CouponPolicyData
import co.kr.cobosys.domain.models.CouponPolicyList
import co.kr.cobosys.domain.models.CouponPolicyModel

fun CouponPolicyResponseModel.toCouponPolicyModel(): CouponPolicyModel = CouponPolicyModel(
    code, message, data = CouponPolicyData(data.couponPolicyList.map { list ->
        CouponPolicyList(
            list.couponNumber,
            list.couponPrice
        )
    })
)

fun CouponPolicyModel.toCouponPolicyResponseModel(): CouponPolicyResponseModel = CouponPolicyResponseModel(
    code, message, data = CouponPolicyResponseData(data.couponPolicyList.map { list ->
        CouponPolicyListResponse(
            list.couponNumber,
            list.couponPrice
        )
    })
)