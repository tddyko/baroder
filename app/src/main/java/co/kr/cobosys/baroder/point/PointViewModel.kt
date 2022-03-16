package co.kr.cobosys.baroder.point

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.kr.cobosys.baroder.auth.signin.SignInViewModel
import co.kr.cobosys.baroder.models.CouponPolicyModelUI
import co.kr.cobosys.baroder.models.PointModelUI
import co.kr.cobosys.baroder.models.mappers.coupon.toCouponPolicyModelUI
import co.kr.cobosys.baroder.models.mappers.point.toPointModelUI
import co.kr.cobosys.domain.base.Failure
import co.kr.cobosys.domain.models.PointModel
import co.kr.cobosys.domain.usecases.point.GetPointListParams
import co.kr.cobosys.domain.usecases.point.GetPointUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import java.util.concurrent.TimeoutException
import javax.inject.Inject

@HiltViewModel
class PointViewModel @Inject constructor(
    private val getPointListUseCase: GetPointUseCase
): ViewModel() {
    private val _getPointListResult: MutableStateFlow<Failure<PointModelUI>> =
        MutableStateFlow(Failure.Waiting())

    val getPointListResult = _getPointListResult.asStateFlow()

    fun getPointList() {
        viewModelScope.launch {
            getPointListUseCase(GetPointListParams(SignInViewModel.localToken)).map {
                it.toPointModelUI()
            }.onStart {
                _getPointListResult.value = Failure.Loading()
            }.catch {
                when(it.fillInStackTrace()) {
                    is UnknownHostException, is SocketTimeoutException, is TimeoutException -> {
                        _getPointListResult.value = Failure.Error(it.fillInStackTrace())
                    }
                    else -> _getPointListResult.value = Failure.Error(it.fillInStackTrace())
                }
            }.collect { data ->
                if (data.code == "0000") {
                    _getPointListResult.value = Failure.Success(data)
                } else {
                    _getPointListResult.value = Failure.ServerError(data.code, data.message)
                }
            }
        }
    }
}