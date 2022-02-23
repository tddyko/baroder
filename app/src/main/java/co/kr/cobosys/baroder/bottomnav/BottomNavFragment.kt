package co.kr.cobosys.baroder.bottomnav

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.addCallback
import co.kr.cobosys.baroder.app.R
import co.kr.cobosys.baroder.app.databinding.FragmentBottomNavBinding
import co.kr.cobosys.baroder.base.utils.Edge
import co.kr.cobosys.baroder.base.utils.Utils.showToast
import co.kr.cobosys.baroder.base.utils.edgeToEdge
import co.kr.cobosys.baroder.coupon.CouponFragment
import co.kr.cobosys.baroder.extension.viewInflateBinding
import co.kr.cobosys.baroder.home.HomeFragment
import co.kr.cobosys.baroder.point.PointFragment
import co.kr.cobosys.baroder.shop.ShopFragment
import co.kr.cobosys.baroder.store.StoreFragment
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class BottomNavFragment : Fragment() {

    private val binding by viewInflateBinding(FragmentBottomNavBinding::inflate)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding.bottomNavi.setOnItemSelectedListener {
            onNavSelected(it.itemId)
            true
        }

        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner) {
            if (binding.bottomNavi.selectedItemId == R.id.home_fragment) {
                requireActivity().finish()
            } else {
                binding.bottomNavi.selectedItemId = R.id.home_fragment
            }
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        edgeToEdge { binding.naviContainer.fit { Edge.TopArc } }
        if (childFragmentManager.fragments.isEmpty()) {
            onNavSelected(R.id.home_fragment)
        }
    }

//    private fun createNewInstanceOf(itemId: Int): Fragment {
//        return when (itemId) {
//            R.id.home_fragment -> HomeFragment()
//            R.id.store_fragment -> StoreFragment()
//            R.id.coupon_fragment -> CouponFragment()
//            R.id.point_fragment -> PointFragment()
//            else -> ShopFragment()
//        }
//    }

    private fun onNavSelected(itemId: Int): Boolean {
        return when (itemId) {
            R.id.home_fragment -> {
//                    if (childFragmentManager.fragments[0] !is HomeFragment) {
//                        replaceChildFragment(createNewInstanceOf(itemId))
//                    }
                changeChildFragment(HomeFragment(), itemId)
//                Toast.makeText(context, "홈 버튼", Toast.LENGTH_SHORT).show()
//                showToast(requireContext(), "눌렸다고 제발 나와라 텍스트야").show()
                true
            }
            R.id.store_fragment -> {
//                    if (childFragmentManager.fragments[0] !is StoreFragment) {
//                        replaceChildFragment(createNewInstanceOf(itemId))
//                    }
                changeChildFragment(StoreFragment(), itemId)
                Toast.makeText(context, "스토어 버튼", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.coupon_fragment -> {
//                    if (childFragmentManager.fragments[0] !is CouponFragment) {
//                        replaceChildFragment(createNewInstanceOf(itemId))
//                    }
                changeChildFragment(CouponFragment(), itemId)
                Toast.makeText(context, "쿠폰 버튼", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.point_fragment -> {
//                    if (childFragmentManager.fragments[0] !is PointFragment) {
//                        replaceChildFragment(createNewInstanceOf(itemId))
//                    }
                changeChildFragment(PointFragment(), itemId)
                Toast.makeText(context, "포인트 버튼", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.shop_fragment -> {
//                    if (childFragmentManager.fragments[0] !is ShopFragment) {
//                        replaceChildFragment(createNewInstanceOf(itemId))
//                    }
                changeChildFragment(ShopFragment(), itemId)
                Toast.makeText(context, "상점 버튼", Toast.LENGTH_SHORT).show()
                true
            }
            else -> false
        }
    }

//    private fun replaceChildFragment(childFragment: Fragment) {
//        childFragmentManager.commit {
//            replace(binding.naviContainer.id, childFragment)
//        }
//    }

    private fun changeChildFragment(fragment: Fragment, id: Int) {
        val findFragment = childFragmentManager.findFragmentByTag(id.toString())
        Timber.e("값좀 보여다오~ ${childFragmentManager.fragments}, $id")
        childFragmentManager.fragments.forEach { fm ->
            childFragmentManager.beginTransaction().hide(fm).commit()
        }
        findFragment?.let {
            childFragmentManager.beginTransaction().show(it).commit()
        } ?: kotlin.run {
            childFragmentManager.beginTransaction()
                .add(R.id.navi_container, fragment, id.toString())
                .commitAllowingStateLoss()
        }
    }
}