package co.kr.cobosys.baroder.auth.signin

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import co.kr.cobosys.baroder.app.R
import co.kr.cobosys.baroder.app.databinding.FragmentSignInBinding
import co.kr.cobosys.baroder.extension.viewBinding

class SignInFragment: Fragment(R.layout.fragment_sign_in) {

    private val binding by viewBinding(FragmentSignInBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}