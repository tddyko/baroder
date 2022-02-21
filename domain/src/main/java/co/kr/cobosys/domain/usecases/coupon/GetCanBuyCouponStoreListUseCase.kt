package co.kr.cobosys.domain.usecases.coupon

import co.kr.cobosys.domain.base.usecases.GeneralPagingUseCase
import co.kr.cobosys.domain.models.CanBuyCouponStoreList
import co.kr.cobosys.domain.repos.coupon.CanBuyCouponStoreListRepo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCanBuyCouponStoreListUseCase @Inject constructor(
    private val canBuyCouponList: CanBuyCouponStoreListRepo
) : GeneralPagingUseCase<Flow<CanBuyCouponStoreList>, GetCouponParams> {
    override fun invoke(params: GetCouponParams): Flow<CanBuyCouponStoreList> =
        canBuyCouponList.getCanBuyCouponStoreList(params.ids)
}

@JvmInline
value class GetStoreDetailParams(val ids: String)