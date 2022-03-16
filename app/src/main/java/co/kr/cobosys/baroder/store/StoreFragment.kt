package co.kr.cobosys.baroder.store

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import co.kr.cobosys.baroder.app.R
import co.kr.cobosys.baroder.app.databinding.FragmentStoreBinding
import co.kr.cobosys.baroder.dialog.MessageDialog
import co.kr.cobosys.baroder.extension.gone
import co.kr.cobosys.baroder.extension.viewBinding
import co.kr.cobosys.baroder.store.adapters.StoreListAdapter
import co.kr.cobosys.domain.base.Failure
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import java.lang.Exception

@AndroidEntryPoint
class StoreFragment : Fragment(R.layout.fragment_store) {
    private val binding by viewBinding(FragmentStoreBinding::bind)
    private val storeViewModel: StoreViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.storeAppBar.homeQr.gone()
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        observe()

        storeViewModel.getList("", 37.48559200297889, 127.11780128486238, 0)
    }

    private fun observe() {
        lifecycleScope.launchWhenStarted {
            storeViewModel.getStoreListResult.collect { state ->
                when (state) {
                    is Failure.Success -> {
                        binding.recyclerView.adapter = StoreListAdapter(state.data.data.storeList)
                        //binding.shopRecyclerView.adapter = CouponPolicyListAdapter(state.data.data.couponPolicyList)
                    }
                    is Failure.Error -> {
                            MessageDialog.alert(
                                childFragmentManager,
                                state.message.toString(),
                                state.message.toString(),
                                "Ȯ��",
                                callback = {
                                    Snackbar.make(binding.root, state.message.toString(), Snackbar.LENGTH_SHORT).show()
                                })
                        }
                    else -> {}
                }
            }
        }
    }
}