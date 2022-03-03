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
import co.kr.cobosys.baroder.dialog.MessageDialog
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
            //OnBoardingDialog.show(childFragmentManager)
            MessageDialog.show(
                childFragmentManager,
                "알림",
                "바로더 알아보기를 누르셨습니다."
            ) { ret: Int ->
                MessageDialog.alert(childFragmentManager, "선택한건 !", "당신의 선택은: $ret") { }
            }
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