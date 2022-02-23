package co.kr.cobosys.baroder.auth.signin

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import co.kr.cobosys.baroder.app.R
import co.kr.cobosys.baroder.app.databinding.FragmentSignInBinding
import co.kr.cobosys.baroder.base.utils.Utils.showToast
import co.kr.cobosys.baroder.extension.viewBinding
import kotlinx.coroutines.flow.collect

class SignInFragment: Fragment(R.layout.fragment_sign_in) {

    private val binding by viewBinding(FragmentSignInBinding::bind)
    private val loginViewModel: SignInViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.signInSignUp.setOnClickListener {
            loginViewModel.login(binding.signInIdField.toString(), binding.signInPwdField.toString())
        }
    }
}