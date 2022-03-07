package co.kr.cobosys.data.repos.coupon

import co.kr.cobosys.data.datasources.coupon.CouponPolicyDataSourceImpl
import co.kr.cobosys.data.mappers.coupon.toCouponPolicyModel
import co.kr.cobosys.domain.models.CouponPolicyModel
import co.kr.cobosys.domain.repos.coupon.CouponPolicyRepo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class CouponPolicyRepoImpl @Inject constructor (
    private val dataSource: CouponPolicyDataSourceImpl
    ) : CouponPolicyRepo
{
    override fun getCouponPolicy(): Flow<CouponPolicyModel> =
        dataSource.getCouponPolicy().map { it.toCouponPolicyModel() }
}