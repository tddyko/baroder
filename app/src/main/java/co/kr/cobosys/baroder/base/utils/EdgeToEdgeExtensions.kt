package co.kr.cobosys.baroder.base.utils

import android.app.Activity
import android.app.Dialog
import android.os.Build
import android.view.View
import android.view.Window
import androidx.fragment.app.Fragment

inline fun Fragment.edgeToEdge(block: EdgeToEdgeBuilder.() -> Unit) {
    val window = requireNotNull(activity?.window) { "fragment's activity must be not null" }
    EdgeToEdgeBuilder(requireView(), window).also(block).build()
}

fun Fragment.fitEdgeToEdge() {
    requireView().dispatchWindowInsets()
}

inline fun Dialog.edgeToEdge(block: EdgeToEdgeBuilder.() -> Unit) {
    val window = requireNotNull(window) { "Dialog's window must be not null" }
    val contentView = findViewById<View>(android.R.id.content)
    EdgeToEdgeBuilder(contentView, window).also(block).build()
}

inline fun Activity.edgeToEdge(block: EdgeToEdgeBuilder.() -> Unit) {
    val window = requireNotNull(window) { "Activity's window must be not null" }
    val contentView = findViewById<View>(android.R.id.content)
    EdgeToEdgeBuilder(contentView, window).also(block).build()
}

fun Window.setEdgeToEdgeFlags() {
    with(decorView) {
        systemUiVisibility = systemUiVisibility or
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE or
                View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
    }
}