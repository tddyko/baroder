package co.kr.cobosys.baroder.store

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import co.kr.cobosys.baroder.app.R
import co.kr.cobosys.baroder.app.databinding.FragmentStoreBinding
import co.kr.cobosys.baroder.extension.viewBinding
import co.kr.cobosys.baroder.extension.viewInflateBinding

class StoreFragment : Fragment() {

    private val binding by viewBinding(FragmentStoreBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        statusBarColorChange()
    }

    private fun statusBarColorChange() {
        val window = requireActivity().window
        window.statusBarColor = ContextCompat.getColor(requireActivity(), R.color.mainGreen)
    }

}