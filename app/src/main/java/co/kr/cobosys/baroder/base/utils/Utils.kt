package co.kr.cobosys.baroder.base.utils

import android.content.Context
import android.view.Gravity
import android.view.LayoutInflater
import android.widget.Toast
import co.kr.cobosys.baroder.app.databinding.ItemCustomToastBinding

object Utils {

    fun showToast(context: Context, message: String): Toast {

        val inflater = LayoutInflater.from(context)
        val binding: ItemCustomToastBinding = ItemCustomToastBinding.inflate(inflater)

        binding.toastMessage.text = message

        return Toast(context).apply {
            setGravity(Gravity.TOP, 0, 0)
            duration = Toast.LENGTH_SHORT
            view = binding.root
        }
    }
}