package co.kr.cobosys.baroder.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import co.kr.cobosys.baroder.app.R
import co.kr.cobosys.baroder.app.databinding.FragmentRootViewBinding
import co.kr.cobosys.baroder.extension.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class RootViewFragment : Fragment(R.layout.fragment_root_view) {

    private val binding by viewBinding(FragmentRootViewBinding::bind)
    private val viewModel: RootViewModel by viewModels()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUserInform()
    }

    private fun setUserInform() {
        findNavController().navigate(RootViewFragmentDirections.actionRootFragmentToBottomNavigationFragment())
    }

}