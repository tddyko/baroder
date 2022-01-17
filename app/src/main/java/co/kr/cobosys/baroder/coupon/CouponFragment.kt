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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.root
    }
}