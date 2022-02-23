package co.kr.cobosys.baroder.auth.signin

import androidx.lifecycle.viewModelScope
import co.kr.cobosys.baroder.base.viewmodels.BaseViewModel
import co.kr.cobosys.baroder.models.AccessTokenUI
import co.kr.cobosys.baroder.models.mappers.auth.AccessTokenMapper
import co.kr.cobosys.domain.usecases.auth.GetAccessTokenParams
import co.kr.cobosys.domain.usecases.auth.GetAccessTokenUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
    private val getAccessTokenUseCase: GetAccessTokenUseCase
) : BaseViewModel() {
    private val _idInput = MutableStateFlow("")
    private val _pwdInput = MutableStateFlow("")
    private val _accessToken = MutableStateFlow("")

    val idInput = _idInput.asStateFlow()
    val pwdInput = _pwdInput.asStateFlow()
    val accessToken = _accessToken.asStateFlow()

    private suspend fun getAccessToken(id: String, pwd: String): AccessTokenUI =
        AccessTokenMapper().mapLeftToRight(
            getAccessTokenUseCase(GetAccessTokenParams(id = id, pwd = pwd))
        )

    init { }

    fun login(id: String, pwd: String) {
        viewModelScope.launch {
            _accessToken.value = getAccessToken(id = id, pwd = pwd).accessToken
        }
    }
}