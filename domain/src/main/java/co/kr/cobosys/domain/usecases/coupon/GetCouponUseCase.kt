package co.kr.cobosys.domain.usecases.coupon

import co.kr.cobosys.domain.base.usecases.GeneralPagingUseCase
import co.kr.cobosys.domain.base.usecases.GeneralParamsUseCase
import co.kr.cobosys.domain.models.CouponModel
import co.kr.cobosys.domain.repos.coupon.CouponRepo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCouponUseCase @Inject constructor(
    private val coupon: CouponRepo
) : GeneralParamsUseCase<CouponModel, GetCouponParams> {
    override suspend fun invoke(params: GetCouponParams): CouponModel =
        coupon.getCoupon(params.ids)
}

@JvmInline
value class GetCouponParams(val ids: String)