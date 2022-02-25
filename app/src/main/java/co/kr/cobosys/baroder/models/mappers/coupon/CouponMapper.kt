package co.kr.cobosys.baroder.models.mappers.coupon

import co.kr.cobosys.baroder.models.CouponDataUI
import co.kr.cobosys.baroder.models.CouponModelUI
import co.kr.cobosys.domain.base.mappers.Mapper
import co.kr.cobosys.domain.models.CouponModel

class CouponMapper: Mapper<CouponModel, CouponModelUI> {
    override fun mapLeftToRight(obj: CouponModel): CouponModelUI = with(obj) {
        CouponModelUI(
            code = code,
            message = message,
            data = data.map { data ->
                CouponDataUI(
                    data.count,
                    data.couponList.map { list ->
                        CouponListMapper().mapLeftToRight(list.copy())
                    }
                )
            }
        )
    }
}