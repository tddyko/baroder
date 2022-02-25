package co.kr.cobosys.data.mappers.coupon

import co.kr.cobosys.data.api.CouponPolicyResponseModel
import co.kr.cobosys.domain.base.mappers.Mapper
import co.kr.cobosys.domain.models.CouponPolicyData
import co.kr.cobosys.domain.models.CouponPolicyModel

class CouponPolicyMapper: Mapper<CouponPolicyResponseModel, CouponPolicyModel> {
    override fun mapLeftToRight(obj: CouponPolicyResponseModel): CouponPolicyModel = with(obj) {
        CouponPolicyModel(
            code = code,
            message = message,
            data = CouponPolicyData(data.couponPolicyList.map { list ->
                CouponPolicyListMapper().mapLeftToRight(list.copy())
            })
        )
    }
}