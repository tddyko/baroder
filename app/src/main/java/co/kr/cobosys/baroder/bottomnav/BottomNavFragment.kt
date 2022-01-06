package co.kr.cobosys.baroder.bottomnav

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.fragment.app.commit
import co.kr.cobosys.baroder.app.R
import co.kr.cobosys.baroder.app.databinding.FragmentBottomNavBinding
import co.kr.cobosys.baroder.coupon.CouponFragment
import co.kr.cobosys.baroder.extension.viewInflateBinding
import co.kr.cobosys.baroder.home.HomeFragment
import co.kr.cobosys.baroder.point.PointFragment
import co.kr.cobosys.baroder.shop.ShopFragment
import co.kr.cobosys.baroder.store.StoreFragment

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
        if (childFragmentManager.fragments.isEmpty()) {
            onNavSelected(R.id.home_fragment)
        }
    }

    private fun createNewInstanceOf(itemId: Int): Fragment {
        return when (itemId) {
            R.id.home_fragment -> HomeFragment()
            R.id.store_fragment -> StoreFragment()
            R.id.coupon_fragment -> CouponFragment()
            R.id.point_fragment -> PointFragment()
            else -> ShopFragment()
        }
    }

    private fun onNavSelected(itemId: Int) {
        if (childFragmentManager.fragments.isEmpty()) {
            childFragmentManager.commit {
                add(binding.naviContainer.id, createNewInstanceOf(itemId))
            }
        } else {
            when (itemId) {
                R.id.home_fragment -> {
                    if (childFragmentManager.fragments[0] !is HomeFragment) {
                        replaceChildFragment(createNewInstanceOf(itemId))
                    }
                }
                R.id.store_fragment -> {
                    if (childFragmentManager.fragments[0] !is StoreFragment) {
                        replaceChildFragment(createNewInstanceOf(itemId))
                    }
                }
                R.id.coupon_fragment -> {
                    if (childFragmentManager.fragments[0] !is CouponFragment) {
                        replaceChildFragment(createNewInstanceOf(itemId))
                    }
                }
                R.id.point_fragment -> {
                    if (childFragmentManager.fragments[0] !is PointFragment) {
                        replaceChildFragment(createNewInstanceOf(itemId))
                    }
                }
                else -> {
                    if (childFragmentManager.fragments[0] !is ShopFragment) {
                        replaceChildFragment(createNewInstanceOf(itemId))
                    }
                }
            }
        }
    }

    private fun replaceChildFragment(childFragment: Fragment) {
        childFragmentManager.commit {
            replace(binding.naviContainer.id, childFragment)
        }
    }
}