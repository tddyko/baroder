package co.kr.cobosys.baroder.store

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import co.kr.cobosys.baroder.app.R
import co.kr.cobosys.baroder.app.databinding.FragmentStoreBinding
import co.kr.cobosys.baroder.bottomnav.BottomNavFragmentDirections
import co.kr.cobosys.baroder.extension.viewBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StoreFragment : Fragment(R.layout.fragment_store) {

    private val binding by viewBinding(FragmentStoreBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.storeAppBar.sharedAppBarMenu.setOnClickListener {
            findNavController().navigate(BottomNavFragmentDirections.actionBottomNavigationFragmentToMypageNavigation())
        }
    }
}