package co.kr.cobosys.baroder.models.mappers.coupon

import co.kr.cobosys.baroder.models.CouponPolicyDataUI
import co.kr.cobosys.baroder.models.CouponPolicyListUI
import co.kr.cobosys.baroder.models.CouponPolicyModelUI
import co.kr.cobosys.domain.models.CouponPolicyData
import co.kr.cobosys.domain.models.CouponPolicyList
import co.kr.cobosys.domain.models.CouponPolicyModel

fun CouponPolicyModelUI.toCouponPolicyModel(): CouponPolicyModel = CouponPolicyModel(
    code, message, data = CouponPolicyData(data.couponPolicyList.map { list ->
        CouponPolicyList(
            list.couponNumber,
            list.couponPrice
        )
    })
)

fun CouponPolicyModel.toCouponPolicyModelUI(): CouponPolicyModelUI = CouponPolicyModelUI(
    code, message, data = CouponPolicyDataUI(data.couponPolicyList.map { list ->
        CouponPolicyListUI(
            list.couponNumber,
            list.couponPrice
        )
    })
)