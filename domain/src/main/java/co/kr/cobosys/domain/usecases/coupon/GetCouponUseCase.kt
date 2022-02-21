package co.kr.cobosys.domain.usecases.coupon

import co.kr.cobosys.domain.base.usecases.GeneralPagingUseCase
import co.kr.cobosys.domain.models.CanBuyCouponStoreList
import co.kr.cobosys.domain.models.Coupon
import co.kr.cobosys.domain.repos.coupon.CanBuyCouponStoreListRepo
import co.kr.cobosys.domain.repos.coupon.CouponRepo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCouponUseCase @Inject constructor(
    private val coupon: CouponRepo
) : GeneralPagingUseCase<Flow<Coupon>, GetCouponParams> {
    override fun invoke(params: GetCouponParams): Flow<Coupon> =
        coupon.getCoupon(params.ids)
}

@JvmInline
value class GetCouponParams(val ids: String)