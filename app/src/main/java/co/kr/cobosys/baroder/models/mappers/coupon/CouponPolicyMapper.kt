package co.kr.cobosys.baroder.models.mappers.coupon

import co.kr.cobosys.baroder.models.CouponPolicyDataUI
import co.kr.cobosys.baroder.models.CouponPolicyModelUI
import co.kr.cobosys.domain.base.mappers.Mapper
import co.kr.cobosys.domain.models.CouponPolicyModel

class CouponPolicyMapper: Mapper<CouponPolicyModel, CouponPolicyModelUI> {
    override fun mapLeftToRight(obj: CouponPolicyModel): CouponPolicyModelUI = with(obj) {
        CouponPolicyModelUI(
            code = code,
            message = message,
            data = CouponPolicyDataUI(data.couponPolicyList.map { list ->
                CouponPolicyListMapper().mapLeftToRight(list.copy())
            })
        )
    }
}