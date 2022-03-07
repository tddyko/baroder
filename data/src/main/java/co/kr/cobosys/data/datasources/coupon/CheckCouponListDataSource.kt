package co.kr.cobosys.data.datasources.coupon

import co.kr.cobosys.data.api.CouponResponseModel
import co.kr.cobosys.data.api.Request
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface CheckCouponListDataSource {
    fun getCheckCoupon(token: String, usableStatus: String, code: String): Flow<CouponResponseModel>
}

class CheckCouponListDataSourceImpl @Inject constructor(
    private val reqApi: Request
): CheckCouponListDataSource {
    override fun getCheckCoupon(token: String, usableStatus: String, code: String):
            Flow<CouponResponseModel> = reqApi.checkCouponList(token, usableStatus, code)
}