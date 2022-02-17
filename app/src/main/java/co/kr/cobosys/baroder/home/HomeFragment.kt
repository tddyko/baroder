package co.kr.cobosys.baroder.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import co.kr.cobosys.baroder.app.R
import co.kr.cobosys.baroder.app.databinding.FragmentHomeBinding
import co.kr.cobosys.baroder.bottomnav.BottomNavFragmentDirections
import co.kr.cobosys.baroder.extension.viewBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home) {

    private val binding by viewBinding(FragmentHomeBinding::bind)

    private val homeViewModel: HomeViewModel by viewModels()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.homeAppBar.sharedAppBarMenu.setOnClickListener {
            findNavController().navigate(BottomNavFragmentDirections.actionBottomNavigationFragmentToMypageNavigation())
        }

    }
}