package co.kr.cobosys.domain.usecase

import co.kr.cobosys.domain.base.usecase.GeneralPagingUseCase
import co.kr.cobosys.domain.base.usecase.GeneralUseCase
import co.kr.cobosys.domain.model.CouponPolicy
import co.kr.cobosys.domain.repo.BaroderRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCouponPolicyUseCase @Inject constructor(
    private val couponPolicy: BaroderRepository
) : GeneralUseCase<Flow<CouponPolicy>> {
    override fun invoke(): Flow<CouponPolicy> =
        couponPolicy.getCouponPolicy()
}