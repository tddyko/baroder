package co.kr.cobosys.baroder.shop

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import co.kr.cobosys.baroder.app.R
import co.kr.cobosys.baroder.app.databinding.FragmentShopBinding
import co.kr.cobosys.baroder.extension.viewBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ShopFragment : Fragment(R.layout.fragment_shop) {

    private val binding by viewBinding(FragmentShopBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}