package co.kr.cobosys.baroder.dialog.qr

import android.app.Dialog
import android.os.Bundle
import android.view.View
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import co.kr.cobosys.baroder.app.R
import co.kr.cobosys.baroder.app.databinding.FragmentQrCodeBinding
import co.kr.cobosys.baroder.dialog.MessageDialog
import co.kr.cobosys.baroder.extension.gone
import co.kr.cobosys.baroder.extension.viewBinding
import co.kr.cobosys.baroder.extension.visible

class QrCodeDialog: DialogFragment(R.layout.fragment_qr_code) {
    private val binding by viewBinding(FragmentQrCodeBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.qrIcCancel.setOnClickListener {
            dismiss()
        }
        binding.qrLoginBtn.setOnClickListener {
            // go to Login ~~~
        }
    }
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog =  super.onCreateDialog(savedInstanceState)
        dialog.window?.setWindowAnimations(R.style.DialogAnimationSlideUpDown)
        return dialog
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