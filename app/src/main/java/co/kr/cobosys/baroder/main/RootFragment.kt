package co.kr.cobosys.baroder.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import co.kr.cobosys.baroder.app.R
import co.kr.cobosys.baroder.app.databinding.FragmentRootBinding
import co.kr.cobosys.baroder.extension.viewBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RootFragment : Fragment(R.layout.fragment_root) {

    private val binding by viewBinding(FragmentRootBinding::bind)
    private val viewModel: RootViewModel by viewModels()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUserInform()
    }

    private fun setUserInform() {
        findNavController().navigate(RootFragmentDirections.actionRootFragmentToBottomNavigationFragment())
    }
}