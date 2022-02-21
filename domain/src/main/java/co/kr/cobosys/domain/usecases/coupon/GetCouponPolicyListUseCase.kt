package co.kr.cobosys.domain.usecases.coupon

import co.kr.cobosys.domain.base.usecases.GeneralUseCase
import co.kr.cobosys.domain.models.CouponPolicyList
import co.kr.cobosys.domain.repos.coupon.CouponPolicyListRepo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCouponPolicyListUseCase @Inject constructor(
    private val couponPolicyList: CouponPolicyListRepo
) : GeneralUseCase<Flow<CouponPolicyList>> {
    override fun invoke(): Flow<CouponPolicyList> =
        couponPolicyList.getCouponPolicyList()
}