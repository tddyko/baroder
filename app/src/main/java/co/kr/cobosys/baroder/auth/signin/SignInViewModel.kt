package co.kr.cobosys.baroder.auth.signin

import androidx.lifecycle.viewModelScope
import androidx.lifecycle.ViewModel
import co.kr.cobosys.baroder.models.AccessTokenModelUI
import co.kr.cobosys.baroder.models.mappers.auth.AccessTokenMapper
import co.kr.cobosys.domain.usecases.auth.GetAccessTokenParams
import co.kr.cobosys.domain.usecases.auth.GetAccessTokenUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
    private val getAccessTokenUseCase: GetAccessTokenUseCase
) : ViewModel() {
    private val _accessToken = MutableStateFlow("")

    val accessToken = _accessToken.asStateFlow()

    private suspend fun getAccessToken(id: String, pwd: String): AccessTokenModelUI =
       AccessTokenMapper().mapLeftToRight(getAccessTokenUseCase(GetAccessTokenParams(id = id, pwd = pwd)))


    fun login(id: String, pwd: String) {
        viewModelScope.launch {
            _accessToken.value =
                getAccessToken(id = id, pwd = pwd).toString()
        }
    }
}