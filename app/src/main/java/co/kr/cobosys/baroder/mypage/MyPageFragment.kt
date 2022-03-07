package co.kr.cobosys.baroder.mypage

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.DialogFragment.STYLE_NO_TITLE
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import co.kr.cobosys.baroder.app.R
import co.kr.cobosys.baroder.app.databinding.FragmentMyPageBinding
import co.kr.cobosys.baroder.auth.signin.SignInFragment
import co.kr.cobosys.baroder.base.utils.Utils
import co.kr.cobosys.baroder.dialog.MessageDialog
import co.kr.cobosys.baroder.extension.viewBinding
import co.kr.cobosys.baroder.extension.visible
import co.kr.cobosys.baroder.main.OnBoardingDialog
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MyPageFragment : Fragment(R.layout.fragment_my_page) {

    private val binding by viewBinding(FragmentMyPageBinding::bind)
    private val mypageViewModel: MyPageViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.mypageMyCouponArea.setOnClickListener {
            findNavController().navigate(MyPageFragmentDirections.actionMypageFragmentToMypageCoupon())
        }

        binding.mypageBaroderLearnMoreImg.setOnClickListener {

//            val onBoardingDialog = OnBoardingDialog()
//            onBoardingDialog.setStyle(STYLE_NO_TITLE, R.style.DialogThemeOnBoarding)
//            onBoardingDialog.show(childFragmentManager, "myPage_onBoarding")

            MessageDialog.show(childFragmentManager, "타이틀 테스트", "컨텐츠 테스트", "화악인", "취이소", callback = { type ->
                when(type) {
                    MessageDialog.YES -> Utils.showToast(requireContext(), "확인 버튼을 누르셨소").show()
                }
            })
//            MessageDialog.alert(childFragmentManager, "타이트트트틀", "메인메시지", "눌러봐라", callback = {})

        }
        binding.myPageLoginPls.visible()
        binding.myPageLoginPls.setOnClickListener {
//            SignInFragment.show(childFragmentManager)
            val signInDialog = SignInFragment()
            signInDialog.setStyle(STYLE_NO_TITLE, R.style.DialogThemeOnBoarding)
            signInDialog.show(childFragmentManager, "myPage")
        }

        binding.mypageTermsOfUseArea.setOnClickListener {

        }

    }
}