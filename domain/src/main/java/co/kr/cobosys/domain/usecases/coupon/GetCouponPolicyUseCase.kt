package co.kr.cobosys.domain.usecases.coupon

import co.kr.cobosys.domain.base.usecases.GeneralUseCase
import co.kr.cobosys.domain.models.CouponPolicyModel
import co.kr.cobosys.domain.repos.coupon.CouponPolicyRepo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCouponPolicyUseCase @Inject constructor(
    private val couponPolicy: CouponPolicyRepo
) : GeneralUseCase<Flow<CouponPolicyModel>> {
    override suspend fun invoke(): Flow<CouponPolicyModel> =
        couponPolicy.getCouponPolicy()
}