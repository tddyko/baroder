package co.kr.cobosys.baroder.point

import android.os.Bundle
import android.view.*
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import co.kr.cobosys.baroder.app.R
import co.kr.cobosys.baroder.app.databinding.FragmentPointBinding
import co.kr.cobosys.baroder.auth.signin.DismissListener
import co.kr.cobosys.baroder.auth.signin.SignInFragment
import co.kr.cobosys.baroder.bottomnav.BottomNavFragmentDirections
import co.kr.cobosys.baroder.dialog.MessageDialog
import co.kr.cobosys.baroder.extension.gone
import co.kr.cobosys.baroder.extension.viewBinding
import co.kr.cobosys.baroder.models.PointDataUI
import co.kr.cobosys.baroder.point.adapters.PointListAdapter
import co.kr.cobosys.baroder.point.viewholders.PointViewHolderListener
import co.kr.cobosys.domain.base.Failure
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import java.io.EOFException
import java.net.UnknownHostException

@AndroidEntryPoint
class PointFragment : Fragment(R.layout.fragment_point), PointViewHolderListener {
    private val binding by viewBinding(FragmentPointBinding::bind)
    private val pointViewModel: PointViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.pointAppBar.sharedAppBarMenu.setOnClickListener {
            findNavController().navigate(BottomNavFragmentDirections.actionBottomNavigationFragmentToMypageNavigation())
        }
        binding.pointAppBar.homeQr.gone()
        binding.pointRecyclerView.layoutManager = LinearLayoutManager(context)
        observe()

        pointViewModel.getPointList()
    }

    private fun attachPointList(pointList: PointDataUI) {
        binding.pointRecyclerView.adapter = PointListAdapter(pointList, this)
    }

    private fun observe() {
        lifecycleScope.launchWhenStarted {
            pointViewModel.getPointListResult.collect { state ->
                when (state) {
                    is Failure.Success -> {
                        attachPointList(state.data.data)
                    }
                    is Failure.Error -> {
                        when(state.message) {
                            is EOFException -> {
                                val signInDialog = SignInFragment()
                                signInDialog.setStyle(DialogFragment.STYLE_NO_TITLE, R.style.DialogThemeOnBoarding)
                                signInDialog.show(childFragmentManager, "myPage")
                                childFragmentManager.executePendingTransactions()
                                signInDialog.dismissListener = object: DismissListener {
                                    override fun getInfo() {
                                        pointViewModel.getPointList()
                                        signInDialog.dismiss()
                                    }
                                }
                            }
                            else -> MessageDialog.alert(
                                childFragmentManager,
                                state.message.toString(),
                                state.message.toString(),
                                "확인",
                                callback = {}
                            )
                        }
                    }
                    else -> {}
                }
            }
        }
    }

    override fun onClickPoint(idx: Int, cmd: Int) {
        // idx : Point Item Idx
        // cmd : Detail(0), Convert Coupon(1)
    }

}