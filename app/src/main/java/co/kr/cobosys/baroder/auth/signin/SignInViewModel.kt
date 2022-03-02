package co.kr.cobosys.baroder.auth.signin

import androidx.lifecycle.viewModelScope
import co.kr.cobosys.baroder.base.viewmodels.BaseViewModel
import co.kr.cobosys.baroder.models.AccessTokenDataUI
import co.kr.cobosys.baroder.models.AccessTokenModelUI
import co.kr.cobosys.baroder.models.mappers.auth.AccessTokenMapper
import co.kr.cobosys.domain.models.AccessTokenData
import co.kr.cobosys.domain.usecases.auth.GetAccessTokenParams
import co.kr.cobosys.domain.usecases.auth.GetAccessTokenUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
    private val getAccessTokenUseCase: GetAccessTokenUseCase
) : BaseViewModel() {
    private val _accessToken = MutableStateFlow("")

    private suspend fun doLogin(id: String, pwd: String): AccessTokenModelUI =
        AccessTokenMapper().mapLeftToRight(getAccessTokenUseCase(GetAccessTokenParams(id = id, pwd = pwd)))

    fun login(id: String, pwd: String) {
        viewModelScope.launch {
            doLogin(id = id, pwd = pwd)

            val loginResult = doLogin(id = id, pwd = pwd)
            _accessToken.value = loginResult.data.accessToken

            Timber.e("액세스토큰값좀 봅시다 -> ${_accessToken.value}")
        }
    }
}