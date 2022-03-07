package co.kr.cobosys.domain.usecases.coupon

import android.os.Parcelable
import co.kr.cobosys.domain.base.usecases.GeneralParamsUseCase
import co.kr.cobosys.domain.models.CouponModel
import co.kr.cobosys.domain.repos.coupon.CheckCouponRepo
import kotlinx.coroutines.flow.Flow
import kotlinx.parcelize.Parcelize
import javax.inject.Inject

class GetCheckCouponUseCase @Inject constructor(
    private val coupon: CheckCouponRepo
) : GeneralParamsUseCase<Flow<CouponModel>, GetCheckCouponParams> {
    override suspend fun invoke(params: GetCheckCouponParams): Flow<CouponModel> =
        coupon.getCheckCoupon(params.token, params.usableStatus, params.code)
}

@Parcelize
data class GetCheckCouponParams(val token: String, val usableStatus: String, val code: String) : Parcelable