package co.kr.cobosys.baroder.mypage

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import co.kr.cobosys.baroder.app.R
import co.kr.cobosys.baroder.app.databinding.FragmentMyPageBinding
import co.kr.cobosys.baroder.extension.viewBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MyPageFragmnet: Fragment(R.layout.fragment_my_page) {

    private val binding by viewBinding(FragmentMyPageBinding::bind)
    private val mypageViewModel: MyPageViewModel by viewModels()
}