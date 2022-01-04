package co.kr.cobosys.baroder.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import co.kr.cobosys.baroder.app.R
import co.kr.cobosys.baroder.app.databinding.FragmentHomeBinding
import co.kr.cobosys.baroder.base.adapter.RecyclerItem
import co.kr.cobosys.baroder.extension.viewInflateBinding
import co.kr.cobosys.baroder.home.adapters.EmptyFavoriteStoreListAdapter
import co.kr.cobosys.baroder.model.EmptyFavoriteStoreUI
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private val binding by viewInflateBinding(FragmentHomeBinding::inflate)

    private val homeViewModel: HomeViewModel by viewModels()

    private val emptyAdapter = EmptyFavoriteStoreListAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        statusBarColorChange()
        setupPager()
        return binding.root
    }

    private fun statusBarColorChange() {
        val window = requireActivity().window
        window.statusBarColor = ContextCompat.getColor(requireActivity(), R.color.white)
    }

    private fun setupPager() {
        val emptyList = arrayListOf<RecyclerItem>(
            EmptyFavoriteStoreUI(1, "아직 등록된 매장이 없어요:(", 0, "회원가입하고 매장 포인트를 확인하세요!", 0, 500, "로그인 하기", "바로더 알아보기"),
            EmptyFavoriteStoreUI(1, "아직 등록된 매장이 없어요:(", 0, "회원가입하고 매장 포인트를 확인하세요!", 0, 500, "로그인 하기", "바로더 알아보기"),
        )
        emptyAdapter.submitList(emptyList)
        binding.homeViewpagerCard.adapter = emptyAdapter
        binding.viewpagerIndicator.setViewPager2(binding.homeViewpagerCard)
    }
}