package co.kr.cobosys.baroder.shop

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import co.kr.cobosys.baroder.app.R
import co.kr.cobosys.baroder.app.databinding.FragmentShopBinding
import co.kr.cobosys.baroder.bottomnav.BottomNavFragmentDirections
import co.kr.cobosys.baroder.dialog.MessageDialog
import co.kr.cobosys.baroder.extension.gone
import co.kr.cobosys.baroder.extension.viewBinding
import co.kr.cobosys.baroder.models.CouponPolicyListUI
import co.kr.cobosys.baroder.shop.adapters.CouponPolicyListAdapter
import co.kr.cobosys.baroder.shop.viewholders.CouponPolicyListViewHolderListener
import co.kr.cobosys.domain.base.Failure
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import timber.log.Timber

@AndroidEntryPoint
class ShopFragment : Fragment(R.layout.fragment_shop), CouponPolicyListViewHolderListener {

    private val binding by viewBinding(FragmentShopBinding::bind)
    private val shopViewModel: ShopViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.shopAppBar.sharedAppBarMenu.setOnClickListener {
            findNavController().navigate(BottomNavFragmentDirections.actionBottomNavigationFragmentToMypageNavigation())
        }
        binding.shopAppBar.homeQr.gone()
        binding.shopRecyclerView.layoutManager = LinearLayoutManager(context)

        observe()

        shopViewModel.getList()
    }

    private fun attachCouponPolicyList(list: List<CouponPolicyListUI>) {
        binding.shopRecyclerView.adapter =
            CouponPolicyListAdapter(list, this)

    }

    private fun observe() {
        lifecycleScope.launchWhenStarted {
            shopViewModel.couponPolicyResult.collect { state ->
                when (state) {
                    is Failure.Success -> {
                        attachCouponPolicyList(state.data.data.couponPolicyList)
                    }
                    is Failure.Error -> {
                        MessageDialog.alert(
                            childFragmentManager,
                            state.message.toString(),
                            state.message.toString(),
                            "Ȯ��",
                            callback = {
                                Snackbar.make(
                                    binding.root,
                                    state.message.toString(),
                                    Snackbar.LENGTH_SHORT
                                ).show()
                            })
                    }
                    else -> {}
                }
            }
        }
    }

    override fun onClickCouponPolicy(idx: Int) {
        Timber.e("���õ� -> $idx")
    }
}