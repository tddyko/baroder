package co.kr.cobosys.baroder.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import co.kr.cobosys.baroder.app.R
import co.kr.cobosys.baroder.app.databinding.FragmentHomeBinding
import co.kr.cobosys.baroder.base.adapter.RecyclerItem
import co.kr.cobosys.baroder.extension.gone
import co.kr.cobosys.baroder.extension.viewBinding
import co.kr.cobosys.baroder.extension.visible
import co.kr.cobosys.baroder.home.adapters.EmptyFavoriteStoreListAdapter
import co.kr.cobosys.baroder.home.adapters.FavoriteStoreListAdapter
import co.kr.cobosys.baroder.model.EmptyFavoriteStoreUI
import co.kr.cobosys.baroder.model.FavoriteStoreUI
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home) {

    private val binding by viewBinding(FragmentHomeBinding::bind)

    private val homeViewModel: HomeViewModel by viewModels()

    private val emptyAdapter = EmptyFavoriteStoreListAdapter()
    private val favoriteAdapter = FavoriteStoreListAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupPager()
    }

//    private fun statusBarColorChange() {
//        val window = requireActivity().window
//        window.statusBarColor = ContextCompat.getColor(requireActivity(), R.color.white)
//    }

    private fun setupPager() {
        val emptyList = arrayListOf<RecyclerItem>(
            EmptyFavoriteStoreUI(
                0,
                "아직 등록된 매장이 없어요:(",
                "0 P",
                "회원가입하고 매장 포인트를 확인하세요!",
                0,
                500,
                "로그인 하기",
                "바로더 알아보기"
            ),
            EmptyFavoriteStoreUI(
                1,
                "아직 등록된 매장이 없어요:(",
                "0 P",
                "[즐겨찾기 매장]에서 단골 매장을 설정해 보세요",
                0,
                500,
                "단골매장 설정",
                "바로더 알아보기"
            )
        )

        val favoriteStoreList = arrayListOf<RecyclerItem>(
            FavoriteStoreUI(
                0,
                "바로더 매장 문정점",
                "4,055 P",
                "5,000 포인트까지 945 포인트 남았어요!",
                0,
                5000,
                "내 쿠폰 10개",
                arrayListOf("녹차라떼", "바닐라 라떼", "딸기라떼"),
                arrayListOf("", "", "")
            ),
            FavoriteStoreUI(
                0,
                "바로더 매장 문정점",
                "4,055 P",
                "5,000 포인트까지 945 포인트 남았어요!",
                0,
                5000,
                "내 쿠폰 10개",
                arrayListOf("녹차라떼", "바닐라 라떼", "딸기라떼"),
                arrayListOf("", "", "")
            ),
            FavoriteStoreUI(
                0,
                "바로더 매장 문정점",
                "4,055 P",
                "5,000 포인트까지 945 포인트 남았어요!",
                0,
                5000,
                "내 쿠폰 10개",
                arrayListOf("녹차라떼", "바닐라 라떼", "달고나 라떼"),
                arrayListOf("", "", "")
            )
        )
        emptyAdapter.submitList(emptyList)
        binding.homeViewpagerCard.adapter = emptyAdapter
        binding.viewpagerIndicator.setViewPager2(binding.homeViewpagerCard)

        favoriteAdapter.submitList(favoriteStoreList)
        binding.homeExpandViewpagerCard.adapter = favoriteAdapter
        binding.expandViewpagerIndicator.setViewPager2(binding.homeExpandViewpagerCard)

        binding.editButton.setOnClickListener {
            if(binding.homeViewpagerArea.visibility == View.VISIBLE) {
                binding.homeViewpagerArea.gone()
                binding.homeExpandViewpagerArea.visible()
            } else {
                binding.homeViewpagerArea.visible()
                binding.homeExpandViewpagerArea.gone()
            }
        }
    }
}