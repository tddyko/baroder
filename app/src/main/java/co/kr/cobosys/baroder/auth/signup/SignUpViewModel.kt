package co.kr.cobosys.baroder.auth.signup

import androidx.lifecycle.ViewModel
import co.kr.cobosys.domain.base.Failure
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(

): ViewModel() {
    private val _signUpAgreementResult: MutableStateFlow<Failure<Boolean>> =
        MutableStateFlow(Failure.Waiting())
    private val _signUpPhoneNumberVerificationResult: MutableStateFlow<Failure<Boolean>> =
        MutableStateFlow(Failure.Waiting())
    private val _signUpMemberInfoResult: MutableStateFlow<Failure<Boolean>> =
        MutableStateFlow(Failure.Waiting())
    private val _signUpResult: MutableStateFlow<Failure<Boolean>> =
        MutableStateFlow(Failure.Waiting())

    val signUpAgreementResult = _signUpAgreementResult.asStateFlow()
    val signUpPhoneNumberVerificationResult = _signUpPhoneNumberVerificationResult.asStateFlow()
    val signUpMemberInfoResult = _signUpMemberInfoResult.asStateFlow()
    val signUpResult = _signUpResult.asStateFlow()

    fun signUpAgreement(): Boolean {
        return true
    }

}