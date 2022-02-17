package co.kr.cobosys.baroder.point

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import co.kr.cobosys.baroder.app.R
import co.kr.cobosys.baroder.app.databinding.FragmentPointBinding
import co.kr.cobosys.baroder.bottomnav.BottomNavFragmentDirections
import co.kr.cobosys.baroder.extension.gone
import co.kr.cobosys.baroder.extension.viewBinding
import co.kr.cobosys.baroder.extension.visible
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PointFragment : Fragment(R.layout.fragment_point) {

    private val binding by viewBinding(FragmentPointBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.pointAppBar.sharedAppBarMenu.setOnClickListener {
            findNavController().navigate(BottomNavFragmentDirections.actionBottomNavigationFragmentToMypageNavigation())
        }
        binding.pointAppBar.homeQr.gone()
    }
}