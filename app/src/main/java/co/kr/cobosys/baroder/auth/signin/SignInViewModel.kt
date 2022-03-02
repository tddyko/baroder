package co.kr.cobosys.baroder.auth.signin

import androidx.lifecycle.viewModelScope
import androidx.lifecycle.ViewModel
import co.kr.cobosys.baroder.models.AccessTokenDataUI
import co.kr.cobosys.baroder.models.AccessTokenModelUI
import co.kr.cobosys.baroder.models.mappers.auth.toAccessTokenModelUI
import co.kr.cobosys.domain.base.Failure
import co.kr.cobosys.domain.models.AccessTokenData
import co.kr.cobosys.domain.usecases.auth.GetAccessTokenParams
import co.kr.cobosys.domain.usecases.auth.GetAccessTokenUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
    private val getAccessTokenUseCase: GetAccessTokenUseCase
) : ViewModel() {
    private val _loginResult: MutableStateFlow<Failure<AccessTokenModelUI>> =
        MutableStateFlow(Failure.Waiting())
    val loginResult = _loginResult.asStateFlow()

//    private suspend fun doLogin(id: String, pwd: String): Flow<AccessTokenModelUI> =
//        getAccessTokenUseCase(GetAccessTokenParams(id = id, pwd = pwd)).map { it.toAccessTokenModelUI() }

    fun login(id: String, pwd: String) {
        viewModelScope.launch {
            getAccessTokenUseCase(GetAccessTokenParams(id = id, pwd = pwd))
                .onStart {
                    _loginResult.value = Failure.Loading()
                }.collect { data ->
                    if (data.code == "0000") {
                        _loginResult.value = Failure.Success(data.data.accessToken)
                    } else {
                        _loginResult.value = Failure.Error(data.code, data.message)
                    }
                }
            Timber.e("액세스토큰값좀 봅시다 -> ${_loginResult.value}")
        }
    }
}