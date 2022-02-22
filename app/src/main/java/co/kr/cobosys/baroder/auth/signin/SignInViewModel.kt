package co.kr.cobosys.baroder.auth.signin

import co.kr.cobosys.baroder.base.viewmodels.BaseViewModel
import co.kr.cobosys.domain.usecases.auth.GetAccessTokenParams
import co.kr.cobosys.domain.usecases.auth.GetAccessTokenUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
    private val getAccessTokenUseCase: GetAccessTokenUseCase
): BaseViewModel() {
    private val _accessToken = MutableStateFlow("access_token")
    val accessToken = _accessToken.asStateFlow()

    suspend fun getAccessToken(id: String, pwd: String) {
        getAccessTokenUseCase(GetAccessTokenParams(id = id, pwd = pwd))
    }
}