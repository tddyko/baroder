package co.kr.cobosys.baroder.auth.signin

import android.app.Dialog
import android.os.Bundle
import android.view.View
import android.view.Window
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import co.kr.cobosys.baroder.app.R
import co.kr.cobosys.baroder.app.databinding.FragmentSignInBinding
import co.kr.cobosys.baroder.base.utils.Edge
import co.kr.cobosys.baroder.base.utils.Utils
import co.kr.cobosys.baroder.base.utils.edgeToEdge
import co.kr.cobosys.baroder.dialog.MessageDialog
import co.kr.cobosys.baroder.extension.viewBinding
import co.kr.cobosys.domain.base.Failure
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

interface SignInFragmentListener {
    fun onSingInResult(accessToken: String)
}

@AndroidEntryPoint
class SignInFragment : DialogFragment(R.layout.fragment_sign_in) {

    private val binding by viewBinding(FragmentSignInBinding::bind)
    private val signInViewModel: SignInViewModel by viewModels()
    var listener: SignInFragmentListener? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        edgeToEdge { binding.signInCancelBtnArea.fit { Edge.TopArc } }
        binding.signInCancelBtn.setOnClickListener { dismiss() }
        observe()

        binding.signInBtn.setOnClickListener {
            val id = binding.signInIdField.text.toString()
            val pwd = binding.signInPwdField.text.toString()
            signInViewModel.signIn(id, pwd)
        }

    }

    private fun observe() {
        lifecycleScope.launchWhenStarted {
            signInViewModel.loginResult.collect { state ->
                when (state) {
                    is Failure.Waiting, is Failure.Loading -> { }
                    is Failure.Success -> {
                        listener?.onSingInResult(SignInViewModel.localToken)
                        dismiss()
                    }
                    is Failure.ServerError -> {
                        MessageDialog.alert(
                            childFragmentManager,
                            state.message,
                            state.message,
                            "확인",
                            callback = {
                                Utils.showToast(requireContext(), state.message).show()
                            })
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

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dlg = super.onCreateDialog(savedInstanceState)
        dlg.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dlg.window?.setWindowAnimations(R.style.DialogAnimationSlideUp)
        return dlg
    }
//    companion object {
//        fun show(fragmentMgr: FragmentManager) {
//            val dlg = SignInFragment()
//            dlg.setStyle(STYLE_NO_TITLE, R.style.DialogThemeOnBoarding)
//            dlg.show(fragmentMgr, "onBoarding")
//        }
//    }
}