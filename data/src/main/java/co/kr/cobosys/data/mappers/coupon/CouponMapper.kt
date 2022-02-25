package co.kr.cobosys.data.mappers.coupon

import co.kr.cobosys.data.api.CouponResponseModel
import co.kr.cobosys.domain.base.mappers.Mapper
import co.kr.cobosys.domain.models.CouponData
import co.kr.cobosys.domain.models.CouponModel

class CouponMapper : Mapper<CouponResponseModel, CouponModel> {
    override fun mapLeftToRight(obj: CouponResponseModel): CouponModel = with(obj) {
        CouponModel(
            code = code,
            message = message,
            data = data.map { data ->
                CouponData(
                    data.count,
                    data.couponList.map { list ->
                        CouponListMapper().mapLeftToRight(list.copy())
                    }
                )
            }
        )
    }
}