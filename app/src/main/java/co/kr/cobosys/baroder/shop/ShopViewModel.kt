package co.kr.cobosys.baroder.shop

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.kr.cobosys.baroder.models.AccessTokenModelUI
import co.kr.cobosys.baroder.models.CouponPolicyModelUI
import co.kr.cobosys.baroder.models.mappers.auth.toAccessTokenModelUI
import co.kr.cobosys.baroder.models.mappers.coupon.toCouponPolicyModelUI
import co.kr.cobosys.domain.base.Failure
import co.kr.cobosys.domain.usecases.auth.GetAccessTokenParams
import co.kr.cobosys.domain.usecases.coupon.GetCouponPolicyUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class ShopViewModel @Inject constructor(
    private val getCouponPolicyUseCase: GetCouponPolicyUseCase
) : ViewModel() {
    private val _couponPolicyResult: MutableStateFlow<Failure<CouponPolicyModelUI>> =
        MutableStateFlow(Failure.Waiting())

    val couponPolicyResult = _couponPolicyResult.asStateFlow()

    fun getList() {
        viewModelScope.launch {
            getCouponPolicyUseCase().map {
                it.toCouponPolicyModelUI()
            }.onStart {
                _couponPolicyResult.value = Failure.Loading()
            }.collect { data ->
                if (data.code == "0000") {
                    _couponPolicyResult.value = Failure.Success(data)
                } else {
                    _couponPolicyResult.value = Failure.ServerError(data.code, data.message)
                }
                //Timber.e("Coupon Policy List -> ${data.data}")
            }
        }
    }
}