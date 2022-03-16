package co.kr.cobosys.baroder.store

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.kr.cobosys.baroder.models.StoreModelUI
import co.kr.cobosys.baroder.models.mappers.store.toStoreModelUI
import co.kr.cobosys.domain.base.Failure
import co.kr.cobosys.domain.usecases.store.GetStoreListParams
import co.kr.cobosys.domain.usecases.store.GetStoreListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import java.util.concurrent.TimeoutException
import javax.inject.Inject

@HiltViewModel
class StoreViewModel @Inject constructor(
    private val getStoreListUseCase : GetStoreListUseCase
): ViewModel() {
    private val _getStoreListResult: MutableStateFlow<Failure<StoreModelUI>> =
        MutableStateFlow(Failure.Waiting())

    val getStoreListResult = _getStoreListResult.asStateFlow()

    fun getList(token: String, latitude: Double, longitude: Double, options: Int) {
        viewModelScope.launch {
            getStoreListUseCase(GetStoreListParams(token, latitude, longitude, options)).map {
                it.toStoreModelUI()
            }.onStart {
                _getStoreListResult.value = Failure.Loading()
            }.catch {
                when(it.fillInStackTrace()) {
                    is UnknownHostException, is SocketTimeoutException, is TimeoutException -> {
                        _getStoreListResult.value = Failure.Error(it.fillInStackTrace())
                    }
                }
            }.collect { data ->
                if (data.code == "0000") {
                    _getStoreListResult.value = Failure.Success(data)
                } else {
                    _getStoreListResult.value = Failure.ServerError(data.code, data.message)
                }
                //Timber.e("Coupon Policy List -> ${data.data}")
            }
        }
    }
}