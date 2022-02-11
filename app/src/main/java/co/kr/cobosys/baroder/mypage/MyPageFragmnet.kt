package co.kr.cobosys.baroder.mypage

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import co.kr.cobosys.baroder.app.R
import co.kr.cobosys.baroder.app.databinding.FragmentMyPageBinding
import co.kr.cobosys.baroder.extension.viewBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MyPageFragmnet: Fragment(R.layout.fragment_my_page) {

    private val binding by viewBinding(FragmentMyPageBinding::bind)
    private val mypageViewModel: MyPageViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.mypageMyCouponArea.setOnClickListener{
            findNavController().navigate(MyPageFragmnetDirections.actionMypageFragmentToMypageCoupon())
        }
    }
}