package co.kr.cobosys.baroder.dialog.qr

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.kr.cobosys.baroder.auth.signin.SignInViewModel
import co.kr.cobosys.baroder.models.AccessTokenModelUI
import co.kr.cobosys.baroder.models.MemberInfoDataUI
import co.kr.cobosys.baroder.models.MemberInfoModelUI
import co.kr.cobosys.baroder.models.mappers.auth.toAccessTokenModelUI
import co.kr.cobosys.baroder.models.mappers.auth.toMemberInfoModelUI
import co.kr.cobosys.domain.base.Failure
import co.kr.cobosys.domain.usecases.auth.GetAccessTokenParams
import co.kr.cobosys.domain.usecases.auth.GetMemberInfoUseCase
import co.kr.cobosys.domain.usecases.auth.PutAccessToken
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class QrCodeViewModel @Inject constructor(
    private val getMemberInfoUseCase: GetMemberInfoUseCase
): ViewModel() {
    private val _memberInfo: MutableStateFlow<Failure<MemberInfoModelUI>> =
        MutableStateFlow(Failure.Waiting())

    val memberInfo = _memberInfo.asStateFlow()

    fun getMemberInfo(token: String) {
        viewModelScope.launch {
            getMemberInfoUseCase(PutAccessToken(token)).map {
                it.toMemberInfoModelUI()
            }.onStart {
                _memberInfo.value = Failure.Loading()
            }.catch {  e ->
                _memberInfo.value = Failure.Error(e.fillInStackTrace())
            }.collect { data ->
                if (data.code == "0000") {
                    _memberInfo.value = Failure.Success(data)
                } else {
                    _memberInfo.value = Failure.ServerError(data.code, data.message)
                }
            }
        }
    }
}