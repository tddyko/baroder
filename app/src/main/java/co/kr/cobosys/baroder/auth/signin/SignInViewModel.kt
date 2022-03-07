package co.kr.cobosys.baroder.auth.signin

import androidx.lifecycle.viewModelScope
import androidx.lifecycle.ViewModel
import co.kr.cobosys.baroder.models.AccessTokenModelUI
import co.kr.cobosys.baroder.models.MemberInfoDataUI
import co.kr.cobosys.baroder.models.mappers.auth.toAccessTokenModelUI
import co.kr.cobosys.domain.base.Failure
import co.kr.cobosys.domain.models.LocalAccessToken
import co.kr.cobosys.domain.usecases.auth.GetAccessTokenParams
import co.kr.cobosys.domain.usecases.auth.GetAccessTokenUseCase
import co.kr.cobosys.domain.usecases.local.accesstoken.GetLocalAccessTokenUseCase
import co.kr.cobosys.domain.usecases.local.accesstoken.InsertLocalAccessTokenParams
import co.kr.cobosys.domain.usecases.local.accesstoken.InsertLocalAccessTokenUseCase
import co.kr.cobosys.domain.usecases.local.member.GetLocalMemberUseCase
import co.kr.cobosys.domain.usecases.local.member.InsertLocalMemberUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
    private val getAccessTokenUseCase: GetAccessTokenUseCase,
    private val insertLocalAccessTokenUseCase: InsertLocalAccessTokenUseCase,
    private val getLocalAccessTokenUseCase: GetLocalAccessTokenUseCase,
    private val getLocalMemberUseCase: GetLocalMemberUseCase,
    private val insertLocalMemberUseCase: InsertLocalMemberUseCase
) : ViewModel() {
    private val _loginResult: MutableStateFlow<Failure<AccessTokenModelUI>> =
        MutableStateFlow(Failure.Waiting())
    private val _memberInfo: MutableStateFlow<Failure<MemberInfoDataUI>> =
        MutableStateFlow(Failure.Waiting())

    val loginResult = _loginResult.asStateFlow()
    val memberInfo = _memberInfo.asStateFlow()


//    private suspend fun doLogin(id: String, pwd: String): Flow<AccessTokenModelUI> =
//        getAccessTokenUseCase(GetAccessTokenParams(id = id, pwd = pwd)).map { it.toAccessTokenModelUI() }

    fun signIn(id: String, pwd: String) {
        viewModelScope.launch {
            getAccessTokenUseCase(GetAccessTokenParams(id = id, pwd = pwd)).map {
                it.toAccessTokenModelUI()
            }.onStart {
                _loginResult.value = Failure.Loading()
            }.catch {  e ->
                _loginResult.value = Failure.Error(e.message)
            }.collect { data ->
                if (data.code == "0000") {
                    _loginResult.value = Failure.Success(data)
                    token = "Bearer ${data.data.accessToken}"
                    Timber.e("액세스토큰값좀 봅시다 -> $token")
                } else {
                    _loginResult.value = Failure.ServerError(data.code, data.message)
                }
            }
        }
    }

    companion object {
        var token: String = ""
    }
}