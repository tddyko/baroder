package co.kr.cobosys.baroder.coupon

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import co.kr.cobosys.baroder.app.R
import co.kr.cobosys.baroder.app.databinding.FragmentCouponBinding
import co.kr.cobosys.baroder.bottomnav.BottomNavFragmentDirections
import co.kr.cobosys.baroder.extension.gone
import co.kr.cobosys.baroder.extension.viewBinding
import co.kr.cobosys.baroder.extension.visible
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CouponFragment : Fragment(R.layout.fragment_coupon) {

    private val binding by viewBinding(FragmentCouponBinding::bind)
    private val couponViewModel: CouponViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.couponAppBar.sharedAppBarMenu.setOnClickListener {
            findNavController().navigate(BottomNavFragmentDirections.actionBottomNavigationFragmentToMypageNavigation())
        }


    }
}