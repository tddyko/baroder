package co.kr.cobosys.baroder.auth.signin

import android.app.Dialog
import android.os.Bundle
import android.view.View
import android.view.Window
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.viewModels
import co.kr.cobosys.baroder.app.R
import co.kr.cobosys.baroder.app.databinding.FragmentSignInBinding
import co.kr.cobosys.baroder.base.utils.Edge
import co.kr.cobosys.baroder.base.utils.edgeToEdge
import co.kr.cobosys.baroder.extension.viewBinding
import co.kr.cobosys.baroder.main.OnBoardingDialog
import co.kr.cobosys.baroder.models.AccessTokenDataUI
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SignInFragment: DialogFragment(R.layout.fragment_sign_in) {

    private val binding by viewBinding(FragmentSignInBinding::bind)
    private val signInViewModel: SignInViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        edgeToEdge { binding.signInCancelBtnArea.fit { Edge.TopArc } }

        binding.signInCancelBtn.setOnClickListener {
            dismiss()
        }

        binding.signInBtn.setOnClickListener {
            val id = binding.signInIdField.text.toString()
            val pwd = binding.signInPwdField.text.toString()
            signInViewModel.login(id, pwd)
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dlg =  super.onCreateDialog(savedInstanceState)
        dlg.requestWindowFeature(Window.FEATURE_NO_TITLE)
        return dlg
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setWindowAnimations(R.style.DialogAnimationSlideUp)
    }

//    companion object {
//        fun show(fragmentMgr: FragmentManager) {
//            val dlg = SignInFragment()
//            dlg.setStyle(STYLE_NO_TITLE, R.style.DialogThemeOnBoarding)
//            dlg.show(fragmentMgr, "onBoarding")
//        }
//    }

}