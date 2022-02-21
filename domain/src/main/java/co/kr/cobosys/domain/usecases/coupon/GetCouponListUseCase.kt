package co.kr.cobosys.domain.usecases.coupon

import androidx.paging.PagingData
import co.kr.cobosys.domain.base.usecases.GeneralPagingUseCase
import co.kr.cobosys.domain.models.CouponList
import co.kr.cobosys.domain.repos.coupon.CouponListRepo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCouponListUseCase @Inject constructor(
    private val couponList: CouponListRepo
) : GeneralPagingUseCase<Flow<PagingData<CouponList>>, GetCouponListParams> {
    override fun invoke(params: GetCouponListParams): Flow<PagingData<CouponList>> =
        couponList.getCouponList(params.ids)
}

@JvmInline
value class GetCouponListParams(val ids: String)