package co.kr.cobosys.baroder.dialog

import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import androidx.core.content.ContextCompat
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import co.kr.cobosys.baroder.app.R
import co.kr.cobosys.baroder.app.databinding.FragmentCustomDialogBinding
import co.kr.cobosys.baroder.extension.gone
import co.kr.cobosys.baroder.extension.viewBinding
import co.kr.cobosys.baroder.extension.visible
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MessageDialog(
    private val titleText: String,
    private val contentText: String,
    private val yesText: String,
    private val noText: String,
    private val confirmText: String,
    private val callback: (Int) -> Unit
) : DialogFragment(R.layout.fragment_custom_dialog) {
    private val binding by viewBinding(FragmentCustomDialogBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.dialogTitle.text = titleText
        binding.dialogContent.text = contentText
        binding.dialogYesBtn.text = yesText
        binding.dialogNoBtn.text = noText
        binding.dialogConfirmBtn.text = confirmText

        binding.dialogYesBtn.setOnClickListener {
            callback(YES)
            dismiss()
        }

        binding.dialogConfirmBtn.setOnClickListener {
            callback(NO)
            dismiss()
        }

        binding.dialogNoBtn.setOnClickListener {
            callback(OK)
            dismiss()
        }

        if(binding.dialogYesBtn.text == "" && binding.dialogNoBtn.text == "") {
            binding.dialogYesBtn.gone()
            binding.dialogNoBtn.gone()
            binding.dialogConfirmBtn.visible()
        }
    }

    companion object {

        const val YES: Int = 1
        const val NO: Int = 2
        const val OK : Int = 3

        fun show(
            fragmentMgr: FragmentManager,
            title: String,
            contents: String,
            yes: String,
            no: String,
            callback: (Int) -> Unit
        ) {
            val dlg = MessageDialog(title, contents, yes, no, "", callback)

            dlg.setStyle(STYLE_NO_TITLE, R.style.DialogThemeMessageDialog)
            dlg.show(fragmentMgr, "messageDialog")
        }

        fun alert(
            fragmentMgr: FragmentManager,
            title: String,
            contents: String,
            confirm: String,
            callback: (Int) -> Unit
        ) {
            val dlg = MessageDialog(title, contents, "", "", confirm, callback)

            dlg.setStyle(STYLE_NO_TITLE, R.style.DialogThemeMessageDialog)
            dlg.show(fragmentMgr, "messageDialog")
        }
    }
}