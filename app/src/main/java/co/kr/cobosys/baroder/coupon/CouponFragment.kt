package co.kr.cobosys.baroder.coupon

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import co.kr.cobosys.baroder.app.R
import co.kr.cobosys.baroder.app.databinding.FragmentCouponBinding
import co.kr.cobosys.baroder.extension.gone
import co.kr.cobosys.baroder.extension.viewBinding
import co.kr.cobosys.baroder.extension.visible
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CouponFragment : Fragment(R.layout.fragment_coupon) {

    private val binding by viewBinding(FragmentCouponBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setNav()
    }

    private fun setNav() {
        val navController = findNavController()
        val appBarConfiguration = AppBarConfiguration(navController.graph)
        binding.couponToolBar.setupWithNavController(navController, appBarConfiguration)

        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.root_fragment,
                R.id.bottom_navigation_fragment
                -> {
                    binding.couponToolBar.gone()
                    binding.couponMenuArea.visible()
                }
                else -> {
                    binding.couponToolBar.visible()
                    binding.couponMenuArea.gone()
                }
            }
        }
    }

}