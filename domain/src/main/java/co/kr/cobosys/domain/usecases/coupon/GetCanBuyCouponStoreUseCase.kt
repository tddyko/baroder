package co.kr.cobosys.domain.usecases.coupon

import co.kr.cobosys.domain.base.usecases.GeneralPagingUseCase
import co.kr.cobosys.domain.models.CanBuyCouponStore
import co.kr.cobosys.domain.repos.coupon.CanBuyCouponStoreRepo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCanBuyCouponStoreUseCase @Inject constructor(
    private val canBuyCouponStore: CanBuyCouponStoreRepo
) : GeneralPagingUseCase<Flow<CanBuyCouponStore>, GetCanBuyCouponStoreParams> {
    override fun invoke(params: GetCanBuyCouponStoreParams): Flow<CanBuyCouponStore> =
        canBuyCouponStore.getCanBuyCouponStore(params.ids)
}

@JvmInline
value class GetCanBuyCouponStoreParams(val ids: String)