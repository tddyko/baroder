package co.kr.cobosys.baroder.mypage

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.kr.cobosys.baroder.auth.signin.SignInViewModel
import co.kr.cobosys.baroder.models.MemberInfoModelUI
import co.kr.cobosys.baroder.models.mappers.auth.toMemberInfoModelUI
import co.kr.cobosys.domain.base.Failure
import co.kr.cobosys.domain.usecases.auth.GetMemberInfoUseCase
import co.kr.cobosys.domain.usecases.auth.PutAccessToken
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import timber.log.Timber
import java.lang.NullPointerException
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import java.util.concurrent.TimeoutException
import javax.inject.Inject

@HiltViewModel
class MyPageViewModel @Inject constructor(
    private val getMemberInfoUseCase: GetMemberInfoUseCase,
) : ViewModel() {
    private val _memberInfo: MutableStateFlow<Failure<MemberInfoModelUI>> =
        MutableStateFlow(Failure.Waiting())

    val memberInfo = _memberInfo.asStateFlow()

    init { getMemberInfo() }

    fun getMemberInfo() {
        viewModelScope.launch {
//            getLocalAccessTokenUseCase().map { it.toLocalAccessTokenUI() }
//                .catch { _memberInfo.value = Failure.Error(it.message) }
//                .collect { token ->
//                    if (token.accessToken != "") {
//                        getMemberInfoUseCase(PutAccessToken(token.accessToken))
//                            .map { it.toMemberInfoModelUI() }
//                            .onStart { _memberInfo.value = Failure.Loading() }
//                            .catch { _memberInfo.value = Failure.Error(it.message) }
//                            .collect {
//                                if (it.code == "0000") {
//                                    _memberInfo.value = Failure.Success(it)
//                                } else {
//                                    _memberInfo.value = Failure.ServerError(it.code, it.message)
//                                }
//                            }
//                    }
//                }
//            getLocalAccessTokenUseCase().map { it.toLocalAccessTokenUI() }
//                .onStart { _memberInfo.value = Failure.Waiting() }
//                .catch {
//                    when (it.cause) {
//                        is NullPointerException -> Timber.e(it.message)
//                        is UnknownHostException, is SocketTimeoutException, is TimeoutException -> {
//                            _memberInfo.value = Failure.Error(it.message)
//                        }
//                    }
//                }
//                .collect {
//                    if (it.accessToken != "") {
//                        getMemberInfoUseCase(PutAccessToken(it.accessToken)).map { member -> member.toMemberInfoModelUI() }
//                            .onStart { _memberInfo.value = Failure.Loading() }
//                            .catch { e -> _memberInfo.value = Failure.Error(e.message) }
//                            .collect { mem ->
//                                if (mem.code == "0000") {
//                                    _memberInfo.value = Failure.Success(mem)
//                                } else {
//                                    _memberInfo.value = Failure.ServerError(mem.code, mem.message)
//                                }
//                            }
//                    }
//                }
            if (SignInViewModel.localToken.isNotEmpty())
                getMemberInfoUseCase(PutAccessToken(SignInViewModel.localToken)).map { member -> member.toMemberInfoModelUI() }
                    .onStart { _memberInfo.value = Failure.Loading() }
                    .catch {
                        when (it.cause) {
                            is NullPointerException -> Timber.e(it.message)
                            is UnknownHostException, is SocketTimeoutException, is TimeoutException -> {
                                _memberInfo.value = Failure.Error(it.message)
                            }
                        }
                    }
                    .collect { mem ->
                        if (mem.code == "0000") {
                            _memberInfo.value = Failure.Success(mem)
                        } else {
                            _memberInfo.value = Failure.ServerError(mem.code, mem.message)
                        }
                    }
        }
    }
}