package co.kr.cobosys.data.repos.coupon

import co.kr.cobosys.data.datasources.coupon.CheckCouponListDataSourceImpl
import co.kr.cobosys.data.mappers.coupon.toCouponModel
import co.kr.cobosys.domain.models.CouponModel
import co.kr.cobosys.domain.repos.coupon.CheckCouponRepo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class CheckCouponRepoImpl @Inject constructor (
    private val dataSource: CheckCouponListDataSourceImpl
) : CheckCouponRepo
{
    override fun getCheckCoupon(token: String, usableStatus: String, code: String) : Flow<CouponModel> =
        dataSource.getCheckCoupon(token, usableStatus, code).map { it.toCouponModel() }
}