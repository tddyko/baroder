package co.kr.cobosys.baroder.auth.signin

import androidx.lifecycle.viewModelScope
import androidx.lifecycle.ViewModel
import co.kr.cobosys.baroder.models.AccessTokenModelUI
import co.kr.cobosys.baroder.models.mappers.auth.toAccessTokenModelUI
import co.kr.cobosys.baroder.models.mappers.local.accesstoken.toLocalAccessTokenUI
import co.kr.cobosys.baroder.models.mappers.local.member.toLocalMemberUI
import co.kr.cobosys.domain.base.Failure
import co.kr.cobosys.domain.models.LocalAccessToken
import co.kr.cobosys.domain.models.LocalMember
import co.kr.cobosys.domain.usecases.auth.GetAccessTokenParams
import co.kr.cobosys.domain.usecases.auth.GetAccessTokenUseCase
import co.kr.cobosys.domain.usecases.local.accesstoken.DelLocalAccessTokenUseCase
import co.kr.cobosys.domain.usecases.local.accesstoken.GetLocalAccessTokenUseCase
import co.kr.cobosys.domain.usecases.local.accesstoken.InsertLocalAccessTokenParams
import co.kr.cobosys.domain.usecases.local.accesstoken.InsertLocalAccessTokenUseCase
import co.kr.cobosys.domain.usecases.local.member.GetLocalMemberUseCase
import co.kr.cobosys.domain.usecases.local.member.InsertLocalMemberParams
import co.kr.cobosys.domain.usecases.local.member.InsertLocalMemberUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import java.util.*
import java.util.concurrent.TimeoutException
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
    private val getAccessTokenUseCase: GetAccessTokenUseCase,
    private val insertLocalAccessTokenUseCase: InsertLocalAccessTokenUseCase,
    private val getLocalAccessTokenUseCase: GetLocalAccessTokenUseCase,
    private val deleteLocalAccessTokenUseCase: DelLocalAccessTokenUseCase,
    private val getLocalMemberUseCase: GetLocalMemberUseCase,
    private val insertLocalMemberUseCase: InsertLocalMemberUseCase
) : ViewModel() {
    private val _loginResult: MutableStateFlow<Failure<AccessTokenModelUI>> =
        MutableStateFlow(Failure.Waiting())

    val loginResult = _loginResult.asStateFlow()

    fun signIn(id: String, pwd: String) {
        viewModelScope.launch {
            val uuid: UUID = UUID.randomUUID()
            insertLocalMemberUseCase(InsertLocalMemberParams(LocalMember(uuid, id, pwd)))
            getAccessTokenUseCase(GetAccessTokenParams(id = id, pwd = pwd))
                .map { it.toAccessTokenModelUI() }
                .catch {
                    when(it.cause) {
                        is UnknownHostException, is SocketTimeoutException, is TimeoutException -> {
                            _loginResult.value = Failure.Error(it.message)
                        }
                    }
                }
                .collect { data ->
                    if (data.code == "0000") {
                        val tokenUUID: UUID = UUID.randomUUID()
                        val token = "Bearer ${data.data.accessToken}"

                        insertLocalAccessTokenUseCase(InsertLocalAccessTokenParams(LocalAccessToken(tokenUUID, token)))
                        getLocalAccessTokenUseCase()
                            .map { it.toLocalAccessTokenUI() }
                            .collect {
                                localToken = it.accessToken
                                if(localToken != token) {
                                    deleteLocalAccessTokenUseCase()
                                    insertLocalAccessTokenUseCase(InsertLocalAccessTokenParams(
                                        LocalAccessToken(tokenUUID, token)
                                    ))
                                }
                                _loginResult.value = Failure.Success(data)
                            }
                    } else {
                        _loginResult.value = Failure.ServerError(data.code, data.message)
                    }
                }
        }
    }

    companion object {
        var localToken = ""
    }
}