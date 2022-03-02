package co.kr.cobosys.baroder.mypage

import android.os.Bundle
import android.view.View
import androidx.fragment.app.DialogFragment.STYLE_NO_TITLE
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import co.kr.cobosys.baroder.app.R
import co.kr.cobosys.baroder.app.databinding.FragmentMyPageBinding
import co.kr.cobosys.baroder.auth.signin.SignInFragment
import co.kr.cobosys.baroder.extension.viewBinding
import co.kr.cobosys.baroder.extension.visible
import co.kr.cobosys.baroder.main.OnBoardingDialog
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MyPageFragment: Fragment(R.layout.fragment_my_page) {

    private val binding by viewBinding(FragmentMyPageBinding::bind)
    private val mypageViewModel: MyPageViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.mypageMyCouponArea.setOnClickListener{
            findNavController().navigate(MyPageFragmentDirections.actionMypageFragmentToMypageCoupon())
        }

        binding.mypageBaroderLearnMoreImg.setOnClickListener {
            OnBoardingDialog.show(childFragmentManager)
        }
        binding.myPageLoginPls.visible()
        binding.myPageLoginPls.setOnClickListener{
//            SignInFragment.show(childFragmentManager)
            val signInDialog = SignInFragment()
            signInDialog.setStyle(STYLE_NO_TITLE, R.style.DialogThemeOnBoarding)
            signInDialog.show(childFragmentManager, "myPage")
        }
    }
}