package co.kr.cobosys.baroder.auth.signup

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import co.kr.cobosys.baroder.app.R
import co.kr.cobosys.baroder.app.databinding.FragmentSignUpAgreementBinding
import co.kr.cobosys.baroder.extension.viewBinding

class SignUpAgreementFragment: Fragment(R.layout.fragment_sign_up_agreement) {

    private val binding by viewBinding(FragmentSignUpAgreementBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}