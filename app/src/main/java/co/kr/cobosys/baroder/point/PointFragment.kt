package co.kr.cobosys.baroder.point

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.core.content.ContextCompat
import co.kr.cobosys.baroder.app.R
import co.kr.cobosys.baroder.app.databinding.FragmentPointBinding
import co.kr.cobosys.baroder.extension.viewBinding
import co.kr.cobosys.baroder.extension.viewInflateBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PointFragment : Fragment() {

    private val binding by viewBinding(FragmentPointBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.root
    }

//    private fun statusBarColorChange() {
//        val window = requireActivity().window
//        window.statusBarColor = ContextCompat.getColor(requireActivity(), R.color.disabled_text)
//    }

}