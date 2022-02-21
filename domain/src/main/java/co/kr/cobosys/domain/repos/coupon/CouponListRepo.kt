package co.kr.cobosys.domain.repos.coupon

import androidx.paging.PagingData
import co.kr.cobosys.domain.models.CouponList
import kotlinx.coroutines.flow.Flow

interface CouponListRepo {
    fun getCouponList(ids: String): Flow<PagingData<CouponList>>
}