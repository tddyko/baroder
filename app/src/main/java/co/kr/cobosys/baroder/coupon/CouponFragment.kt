package co.kr.cobosys.baroder.coupon

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import co.kr.cobosys.baroder.app.R
import co.kr.cobosys.baroder.app.databinding.FragmentCouponBinding
import co.kr.cobosys.baroder.extension.viewInflateBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CouponFragment : Fragment() {

    private val binding by viewInflateBinding(FragmentCouponBinding::inflate)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        statusBarColorChange()
        // Inflate the layout for this fragment
        return binding.root
    }

    private fun statusBarColorChange() {
        val window = requireActivity().window
        window.statusBarColor = ContextCompat.getColor(requireActivity(), R.color.starYellow)
    }

}