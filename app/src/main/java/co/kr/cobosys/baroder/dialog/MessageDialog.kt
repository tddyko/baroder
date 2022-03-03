package co.kr.cobosys.baroder.dialog

import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import co.kr.cobosys.baroder.app.R
import co.kr.cobosys.baroder.app.databinding.FragmentCustomDialogBinding
import co.kr.cobosys.baroder.extension.gone
import co.kr.cobosys.baroder.extension.viewBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MessageDialog(private val titleText: String,
                    private val contentText: String,
                    private val viewType: Int,
                    private val callback: (Int) -> Unit
) : DialogFragment(R.layout.fragment_custom_dialog) {
    private val binding by viewBinding(FragmentCustomDialogBinding::bind)
    var result: Int = CANCEL

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.dialogTitle.text = titleText
        binding.dialogContent.text = contentText

        binding.dialogYesBtn.setOnClickListener {
            callback(YES)
            dismiss()
        }

        binding.dialogConfirmBtn.setOnClickListener {
            callback(OK)
            dismiss()
        }

        binding.dialogNoBtn.setOnClickListener {
            callback(NO)
            dismiss()
        }

        when (viewType) {
            TYPE_SELECT -> {
                binding.dialogYesBtn.text = "확인"
                binding.dialogNoBtn.text = "취소"
            }
            TYPE_ALERT -> {
                binding.dialogYesBtn.gone()
                binding.dialogNoBtn.gone()
                binding.dialogConfirmBtn.text = "확인"
                binding.dialogConfirmBtn.visibility = View.VISIBLE
            }
        }

        dialog?.setOnKeyListener { _, keyCode, event ->
            if(keyCode == KeyEvent.KEYCODE_BACK && event.action == KeyEvent.ACTION_UP) {
                callback(CANCEL)
                dismiss()
                return@setOnKeyListener true
            }
            return@setOnKeyListener false
        }
    }

    companion object {
        val TYPE_ALERT = 0
        val TYPE_SELECT = 1

        val CANCEL : Int = 0
        val NO: Int = 1
        val OK : Int = 2
        val YES: Int = 3

        fun show(fragmentMgr: FragmentManager, title: String, contents: String, callback: (Int) -> Unit) {
            val dlg = MessageDialog(title, contents, TYPE_SELECT, callback)

            dlg.setStyle(STYLE_NO_TITLE, R.style.DialogThemeMessageDialog)
            dlg.show(fragmentMgr, "messageDialog")
        }

        fun alert(fragmentMgr: FragmentManager, title: String, contents: String, callback: (Int) -> Unit) {
            val dlg = MessageDialog(title, contents, TYPE_ALERT, callback)

            dlg.setStyle(STYLE_NO_TITLE, R.style.DialogThemeMessageDialog)
            dlg.show(fragmentMgr, "messageDialog")
        }

    }
}