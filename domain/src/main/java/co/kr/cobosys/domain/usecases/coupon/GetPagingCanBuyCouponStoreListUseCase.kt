package co.kr.cobosys.domain.usecases.coupon

import androidx.paging.PagingData
import co.kr.cobosys.domain.base.usecases.GeneralPagingUseCase
import co.kr.cobosys.domain.models.CanBuyCouponStoreList
import co.kr.cobosys.domain.repos.coupon.PagingCanBuyCouponStoreListRepo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetPagingCanBuyCouponStoreListUseCase @Inject constructor(
    private val pagingCanBuyCouponStoreList: PagingCanBuyCouponStoreListRepo
) : GeneralPagingUseCase<Flow<PagingData<CanBuyCouponStoreList>>, GetPagingCanBuyCouponStoreListParams> {
    override fun invoke(params: GetPagingCanBuyCouponStoreListParams): Flow<PagingData<CanBuyCouponStoreList>> =
        pagingCanBuyCouponStoreList.getPagingCanBuyCouponStoreList(params.ids)
}

@JvmInline
value class GetPagingCanBuyCouponStoreListParams(val ids: String)