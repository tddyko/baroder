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
import kotlinx.coroutines.flow.collect
import java.lang.Exception
import java.net.NoRouteToHostException

@AndroidEntryPoint
class SignInFragment: DialogFragment(R.layout.fragment_sign_in) {

    private val binding by viewBinding(FragmentSignInBinding::bind)
    private val signInViewModel: SignInViewModel by viewModels()

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
                when(state) {
                    is Failure.Success -> {
                        dismiss()
                    }
                    is Failure.Error -> {
                        try {
                            MessageDialog.alert(childFragmentManager, state.message, state.message, "확인", callback = {
                                Utils.showToast(requireContext(), state.message).show()
                            })
                        } catch (e: Exception) {
                            when(e) {
                                is NoRouteToHostException,
                            }
                        }
                    }
                    else -> { }
                }
            }
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dlg =  super.onCreateDialog(savedInstanceState)
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