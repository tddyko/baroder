package co.kr.cobosys.baroder.mypage

import androidx.lifecycle.ViewModel
import co.kr.cobosys.baroder.models.AccessTokenModelUI
import co.kr.cobosys.domain.base.Failure
import co.kr.cobosys.domain.usecases.auth.GetMemberInfoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class MyPageViewModel @Inject constructor(
    getMemberInfoUseCase: GetMemberInfoUseCase
): ViewModel() {
    private val _memberInfo: MutableStateFlow<Failure<AccessTokenModelUI>> =
        MutableStateFlow(Failure.Waiting())

    val memberInfo = _memberInfo.asStateFlow()


}