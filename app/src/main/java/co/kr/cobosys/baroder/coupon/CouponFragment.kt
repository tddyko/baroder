package co.kr.cobosys.baroder.coupon

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import co.kr.cobosys.baroder.app.R
import co.kr.cobosys.baroder.app.databinding.FragmentCouponBinding
import co.kr.cobosys.baroder.bottomnav.BottomNavFragmentDirections
import co.kr.cobosys.baroder.extension.gone
import co.kr.cobosys.baroder.extension.viewBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CouponFragment : Fragment(R.layout.fragment_coupon) {

    private val binding by viewBinding(FragmentCouponBinding::bind)
    private val couponViewModel: CouponViewModel by viewModels()
    private val args: CouponFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val isAppBarHide = try { args.appBarHide } catch (_: Exception) { 0 }
        if (1 == isAppBarHide) {
            binding.couponAppBar.sharedAppBarMenu.gone()
        }

        binding.couponAppBar.sharedAppBarMenu.setOnClickListener {
            findNavController().navigate(BottomNavFragmentDirections.actionBottomNavigationFragmentToMypageNavigation())
        }
        binding.couponAppBar.homeQr.gone()
    }
}