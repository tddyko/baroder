package co.kr.cobosys.domain.usecases.coupon

import co.kr.cobosys.domain.base.usecases.GeneralUseCase
import co.kr.cobosys.domain.models.CouponPolicyModel
import co.kr.cobosys.domain.repos.coupon.CouponPolicyRepo
import javax.inject.Inject

class GetCouponPolicyUseCase @Inject constructor(
    private val couponPolicy: CouponPolicyRepo
) : GeneralUseCase<CouponPolicyModel> {
    override suspend fun invoke(): CouponPolicyModel =
        couponPolicy.getCouponPolicy()
}