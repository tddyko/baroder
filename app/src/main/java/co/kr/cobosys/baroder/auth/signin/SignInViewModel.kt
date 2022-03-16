package co.kr.cobosys.baroder.auth.signin

import androidx.lifecycle.viewModelScope
import androidx.lifecycle.ViewModel
import co.kr.cobosys.baroder.models.AccessTokenModelUI
import co.kr.cobosys.baroder.models.mappers.auth.toAccessTokenModelUI
import co.kr.cobosys.baroder.models.mappers.local.accesstoken.toLocalAccessTokenUI
import co.kr.cobosys.domain.base.Failure
import co.kr.cobosys.domain.models.LocalAccessToken
import co.kr.cobosys.domain.models.LocalMember
import co.kr.cobosys.domain.usecases.auth.GetAccessTokenParams
import co.kr.cobosys.domain.usecases.auth.GetAccessTokenUseCase
import co.kr.cobosys.domain.usecases.local.accesstoken.DelLocalAccessTokenUseCase
import co.kr.cobosys.domain.usecases.local.accesstoken.GetLocalAccessTokenUseCase
import co.kr.cobosys.domain.usecases.local.accesstoken.InsertLocalAccessTokenParams
import co.kr.cobosys.domain.usecases.local.accesstoken.InsertLocalAccessTokenUseCase
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
    private val insertLocalMemberUseCase: InsertLocalMemberUseCase
) : ViewModel() {
    private val _signInResult: MutableStateFlow<Failure<AccessTokenModelUI>> =
        MutableStateFlow(Failure.Waiting())

    val signInResult = _signInResult.asStateFlow()

    fun signIn(id: String, pwd: String) {
        viewModelScope.launch {
            val uuid: UUID = UUID.randomUUID()
            insertLocalMemberUseCase(InsertLocalMemberParams(LocalMember(uuid, id, pwd)))
            getAccessTokenUseCase(GetAccessTokenParams(id = id, pwd = pwd))
                .map { it.toAccessTokenModelUI() }
                .catch {
                    when(it.fillInStackTrace()) {
                        is UnknownHostException, is SocketTimeoutException, is TimeoutException -> {
                            _signInResult.value = Failure.Error(it.fillInStackTrace())
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
                                _signInResult.value = Failure.Success(data)
                            }
                    } else {
                        _signInResult.value = Failure.ServerError(data.code, data.message)
                    }
                }
        }
    }

    companion object {
        var localToken = ""
    }
}