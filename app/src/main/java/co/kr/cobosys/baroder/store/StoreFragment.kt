package co.kr.cobosys.baroder.store

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import co.kr.cobosys.baroder.app.R
import co.kr.cobosys.baroder.app.databinding.FragmentStoreBinding
import co.kr.cobosys.baroder.extension.viewInflateBinding

class StoreFragment : Fragment() {

    private val binding by viewInflateBinding(FragmentStoreBinding::inflate)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return binding.root
    }

}