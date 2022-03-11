package co.kr.cobosys.baroder.dialog.qr

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewModelScope
import co.kr.cobosys.baroder.app.R
import co.kr.cobosys.baroder.app.databinding.FragmentQrCodeBinding
import co.kr.cobosys.baroder.auth.signin.SignInFragment
import co.kr.cobosys.baroder.auth.signin.SignInFragmentListener
import co.kr.cobosys.baroder.auth.signin.SignInViewModel
import co.kr.cobosys.baroder.base.utils.Utils
import co.kr.cobosys.baroder.dialog.MessageDialog
import co.kr.cobosys.baroder.extension.gone
import co.kr.cobosys.baroder.extension.viewBinding
import co.kr.cobosys.domain.base.Failure
import com.google.zxing.BarcodeFormat
import com.google.zxing.MultiFormatWriter
import com.journeyapps.barcodescanner.BarcodeEncoder
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import timber.log.Timber
import java.util.*


@AndroidEntryPoint
class QrCodeDialog: DialogFragment(R.layout.fragment_qr_code) {
    private val binding by viewBinding(FragmentQrCodeBinding::bind)
    private val qrCodeViewModel: QrCodeViewModel by viewModels()
    private var timerOnesecond: Timer? = null
    private var restResetCount = 60

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.qrIcCancel.setOnClickListener {
            timerOnesecond?.cancel()
            timerOnesecond = null
            dismiss()
        }
        binding.qrLoginBtn.setOnClickListener {
            val signInDialog = SignInFragment()
            signInDialog.setStyle(STYLE_NO_TITLE, R.style.DialogThemeOnBoarding)
            signInDialog.listener = object : SignInFragmentListener {
                override fun onSingInResult(accessToken: String) {
                    if (accessToken.isNotEmpty()) {
                        qrCodeViewModel.getMemberInfo(accessToken)
                    }
                }
            }
            signInDialog.show(childFragmentManager, "myPage")
        }
        observe()

        if (SignInViewModel.localToken.isNotEmpty()) {
            qrCodeViewModel.getMemberInfo(SignInViewModel.localToken)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        timerOnesecond?.cancel()
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog =  super.onCreateDialog(savedInstanceState)
        dialog.window?.setWindowAnimations(R.style.DialogAnimationSlideUpDown)
        return dialog
    }

    private fun createQRcode(text: String) {
        val multiFormatWriter = MultiFormatWriter()
        try {
            val bitMatrix = multiFormatWriter.encode(text, BarcodeFormat.QR_CODE, 200, 200)
            val barcodeEncoder = BarcodeEncoder()
            val bitmap = barcodeEncoder.createBitmap(bitMatrix)

            binding.qrCode.setImageBitmap(bitmap)
            binding.qrMemberScreen.visibility = View.VISIBLE
            binding.qrVisitorScreen.gone()

            timerOnesecond?.cancel()
            val timer = Timer()
            restResetCount = 60
            binding.qrCountText.text = "$restResetCount"
            timer.schedule(object : TimerTask(){
                override fun run(){
                    if (--restResetCount <= 0) {
                        timerOnesecond?.cancel()
                        timerOnesecond = null
                        qrCodeViewModel.getMemberInfo(SignInViewModel.localToken)
                    } else {
                        CoroutineScope(Dispatchers.Main).launch {
                            binding.qrCountText.text = "$restResetCount"
                        }
                    }
                }
            }, 0,1000)
            timerOnesecond = timer
        } catch (e: Exception) {
            Timber.e("ERROR Create QRCode -> $e")
        }
    }

    private fun observe() {
        lifecycleScope.launchWhenStarted {
            qrCodeViewModel.memberInfo.collect { state ->
                when (state) {
                    is Failure.Waiting, is Failure.Loading -> {}
                    is Failure.Success -> {
                        // dismiss()
                        // state.data.data.memberQrCode 로 QR 이미지를 만들어야 하고, 60초 타임 아웃 ?
                        CoroutineScope(Dispatchers.Main).launch {
                            createQRcode(state.data.data.memberQrCode)
                        }
                    }
                    is Failure.ServerError -> {
                        MessageDialog.alert(
                            childFragmentManager,
                            state.message,
                            state.message,
                            "확인",
                            callback = {
                                Utils.showToast(requireContext(), state.message).show()
                            })
                    }
                    is Failure.Error -> {
                        MessageDialog.alert(
                            childFragmentManager,
                            "인터넷 에러!",
                            "인터넷 연결을 확인해주세요. ${state.message}",
                            "확인",
                            callback = {}
                        )
                    }
                    else -> {
                        MessageDialog.alert(
                            childFragmentManager,
                            "에러!",
                            "알 수 없는 에러입니다.",
                            "확인",
                            callback = {}
                        )
                    }
                }
            }
        }
    }

    companion object {
        fun show(
            fragmentMgr: FragmentManager
        ) {
            val dlg = QrCodeDialog()

            dlg.setStyle(STYLE_NO_TITLE, R.style.DialogThemeQrCodeDialog)
            dlg.show(fragmentMgr, "qrDialog")
        }
    }
}