package co.kr.cobosys.baroder.mypage

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.fragment.app.DialogFragment.STYLE_NO_TITLE
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import co.kr.cobosys.baroder.app.R
import co.kr.cobosys.baroder.app.databinding.FragmentMyPageBinding
import co.kr.cobosys.baroder.auth.signin.SignInFragment
import co.kr.cobosys.baroder.dialog.MessageDialog
import co.kr.cobosys.baroder.extension.gone
import co.kr.cobosys.baroder.extension.viewBinding
import co.kr.cobosys.baroder.extension.visible
import co.kr.cobosys.baroder.main.OnBoardingDialog
import co.kr.cobosys.domain.base.Failure
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class MyPageFragment : Fragment(R.layout.fragment_my_page) {

    private val binding by viewBinding(FragmentMyPageBinding::bind)
    private val mypageViewModel: MyPageViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.mypageMyCouponArea.setOnClickListener {
            findNavController().navigate(MyPageFragmentDirections.actionMypageFragmentToMypageCoupon())
        }
        observe()
        getLogin()
        selectOnBoarding()

        binding.myPageLoginPls.visible()
        binding.mypageTermsOfUseArea.setOnClickListener {

        }

    }

    @SuppressLint("SetTextI18n")
    private fun observe() {
        lifecycleScope.launchWhenStarted {
            mypageViewModel.memberInfo.collect {
                when(it) {
                    is Failure.Waiting, is Failure.Loading -> { }
                    is Failure.Success -> {
                        val dlg = SignInFragment()
                        dlg.dismiss()
                        if(it.data.data.memberId != "") {
                            binding.myPageLoginPls.gone()
                            binding.myPageMyName.visible()
                            binding.myPageMyName.text = it.data.data.memberName
                            binding.mypageMyId.visible()
                            binding.mypageMyId.text = "@ ${it.data.data.memberId}"
                        } else {
                            binding.myPageLoginPls.visible()
                        }
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

    private fun getLogin(){
        binding.myPageLoginPls.setOnClickListener {
            val signInDialog = SignInFragment()
            signInDialog.setStyle(STYLE_NO_TITLE, R.style.DialogThemeOnBoarding)
            signInDialog.show(childFragmentManager, "myPage")
        }
    }

    private fun selectOnBoarding() {
        binding.mypageBaroderLearnMoreImg.setOnClickListener {

            val onBoardingDialog = OnBoardingDialog()
            onBoardingDialog.setStyle(STYLE_NO_TITLE, R.style.DialogThemeOnBoarding)
            onBoardingDialog.show(childFragmentManager, "myPage_onBoarding")

//            MessageDialog.show(childFragmentManager, "타이틀 테스트", "컨텐츠 테스트", "화악인", "취이소", callback = { type ->
//                when(type) {
//                    MessageDialog.YES -> Utils.showToast(requireContext(), "확인 버튼을 누르셨소").show()
//                }
//            })

        }
    }
}