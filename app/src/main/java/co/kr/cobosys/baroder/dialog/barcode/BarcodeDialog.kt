package co.kr.cobosys.baroder.dialog.barcode

import android.app.Dialog
import android.graphics.Bitmap
import android.os.Bundle
import android.util.TypedValue
import android.view.View
import android.view.Window
import androidx.core.content.ContextCompat
import androidx.fragment.app.DialogFragment
import co.kr.cobosys.baroder.app.R
import co.kr.cobosys.baroder.app.databinding.FragmentBarcodeBinding
import co.kr.cobosys.baroder.extension.viewBinding
import com.google.zxing.BarcodeFormat
import com.google.zxing.MultiFormatWriter
import com.google.zxing.common.BitMatrix

class BarcodeDialog: DialogFragment() {
    private val binding by viewBinding(FragmentBarcodeBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val code = "1234 5678 9000"
        val barcode = createBarcode(code)
        binding.barcodeImg.setImageBitmap(barcode)
        binding.barcodeIcCancel.setOnClickListener {
            dismiss()
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = super.onCreateDialog(savedInstanceState)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        return dialog
    }

    private fun createBarcode(code: String): Bitmap {
        val widthPx = TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP, 299f,
            resources.displayMetrics
        )

        val heighPx = TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP, 80f,
            resources.displayMetrics
        )

        val format: BarcodeFormat = BarcodeFormat.CODE_128
        val matrix: BitMatrix =
            MultiFormatWriter().encode(code, format, widthPx.toInt(), heighPx.toInt())
        return createBitmap(matrix)
    }

    private fun createBitmap(matrix: BitMatrix): Bitmap {
        val width = matrix.width
        val height = matrix.height
        val bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)

        for (x in 0 until width) {
            for (y in 0 until height) {
                bitmap.setPixel(x, y, if (matrix.get(x, y)) ContextCompat.getColor(requireActivity().applicationContext, R.color.black) else ContextCompat.getColor(requireActivity().applicationContext, R.color.white))
            }
        }
        return bitmap
    }

}

