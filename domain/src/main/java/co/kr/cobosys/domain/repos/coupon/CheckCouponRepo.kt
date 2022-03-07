package co.kr.cobosys.domain.repos.coupon


import co.kr.cobosys.domain.models.CouponModel
import kotlinx.coroutines.flow.Flow

interface CheckCouponRepo {
    fun getCheckCoupon(token: String, usableStatus: String, code: String) : Flow<CouponModel>
}