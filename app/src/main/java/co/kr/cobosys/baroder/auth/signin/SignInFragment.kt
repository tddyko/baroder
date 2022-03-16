package co.kr.cobosys.baroder.auth.signin

import android.app.Dialog
import android.os.Bundle
import android.view.View
import android.view.Window
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import co.kr.cobosys.baroder.app.R
import co.kr.cobosys.baroder.app.databinding.FragmentSignInBinding
import co.kr.cobosys.baroder.base.utils.Edge
import co.kr.cobosys.baroder.base.utils.edgeToEdge
import co.kr.cobosys.baroder.dialog.MessageDialog
import co.kr.cobosys.baroder.extension.hideKeyboard
import co.kr.cobosys.baroder.extension.validLoginButton
import co.kr.cobosys.baroder.extension.validatePwd
import co.kr.cobosys.baroder.extension.viewBinding
import co.kr.cobosys.domain.base.Failure
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

interface SignInFragmentListener {
    fun onSingInResult(accessToken: String)
}

interface DismissListener {
    fun getInfo()
}

@AndroidEntryPoint
class SignInFragment : DialogFragment(R.layout.fragment_sign_in) {

    private val binding by viewBinding(FragmentSignInBinding::bind)
    private val signInViewModel: SignInViewModel by viewModels()
    var listener: SignInFragmentListener? = null
    var dismissListener: DismissListener? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        edgeToEdge { binding.signInCancelBtnArea.fit { Edge.TopArc } }
        binding.signInCancelBtn.setOnClickListener { dismiss() }

        observe()
        getSignIn()
        validPwd()

    }

    private fun observe() {
        lifecycleScope.launchWhenStarted {
            signInViewModel.signInResult.collect { state ->
                when (state) {
                    is Failure.Waiting, is Failure.Loading -> {}
                    is Failure.Success -> {
                        listener?.onSingInResult(SignInViewModel.localToken)
                        dismissListener?.getInfo()
                    }
                    is Failure.ServerError -> {
                        Snackbar.make(binding.root, state.message, Snackbar.LENGTH_SHORT).show()
                    }
                    is Failure.Error -> {
                        MessageDialog.alert(
                            childFragmentManager,
                            "인터넷 에러!",
                            "인터넷 연결을 확인해주세요",
                            "확인",
                            callback = {}
                        )
                    }
                    else -> {
                        MessageDialog.alert(
                            childFragmentManager,
                            "에러!",
                            "알 수 없는 에러입니다.",
                            "확인",
                            callback = {}
                        )
                    }
                }
            }
        }
    }

    private fun validPwd() {
        val pwdArea = binding.signInPwd
        val pwdField = binding.signInPwdField
        pwdField.addTextChangedListener {
            pwdArea.helperText = validatePwd(it.toString())
        }
    }


    private fun getSignIn() {
        val idField = binding.signInIdField
        val pwdField = binding.signInPwdField
        val loginButton = binding.signInBtn

        idField.addTextChangedListener {
            loginButton.isEnabled = validLoginButton(idField.text.toString(), pwdField.text.toString())
        }
        pwdField.addTextChangedListener {
            loginButton.isEnabled = validLoginButton(idField.text.toString(), pwdField.text.toString())
        }

        loginButton.setOnClickListener {
            binding.root.hideKeyboard()
            signInViewModel.signIn(idField.text.toString(), pwdField.text.toString())
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dlg = super.onCreateDialog(savedInstanceState)
        dlg.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dlg.window?.setWindowAnimations(R.style.DialogAnimationSlideUp)
        return dlg
    }

}