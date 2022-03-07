package co.kr.cobosys.data.datasources.coupon

import co.kr.cobosys.data.api.CouponPolicyResponseModel
import co.kr.cobosys.data.api.Request
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface CouponPolicyDataSource {
    fun getCouponPolicy(): Flow<CouponPolicyResponseModel>
}

class CouponPolicyDataSourceImpl @Inject constructor(
    private val reqApi: Request
): CouponPolicyDataSource {
    override fun getCouponPolicy(): Flow<CouponPolicyResponseModel> = reqApi.checkCouponPolicy()
}