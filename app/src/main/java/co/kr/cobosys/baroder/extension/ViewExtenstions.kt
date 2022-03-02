package co.kr.cobosys.baroder.extension

import android.annotation.SuppressLint
import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.graphics.Paint
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.app.ActivityCompat
import co.kr.cobosys.baroder.app.R
import co.kr.cobosys.baroder.app.databinding.FragmentCustomDialogBinding
import co.kr.cobosys.baroder.base.utils.GlideApp
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.Target
import com.google.android.material.dialog.MaterialAlertDialogBuilder

fun View?.gone() {
    this?.let {
        visibility = View.GONE
    }
}

fun View.visible() {
    visibility = View.VISIBLE
}

fun View.invisible() {
    visibility = View.INVISIBLE
}

@SuppressLint("CheckResult")
fun ImageView.load(
    url: String?,
    @DrawableRes placeholderRes: Int = R.drawable.ic_preview_img,
    activity: Activity? = null
) {
    val safePlaceholderDrawable = AppCompatResources.getDrawable(context, placeholderRes)
    val requestOptions = RequestOptions().apply {
        placeholder(safePlaceholderDrawable)
        error(safePlaceholderDrawable)
    }
    val glideRequest = GlideApp
        .with(context)
        .setDefaultRequestOptions(requestOptions)
        .load(url)
        .dontAnimate()

    activity?.let {
        glideRequest
            .listener(object : RequestListener<Drawable> {
                override fun onLoadFailed(
                    e: GlideException?,
                    model: Any?,
                    target: Target<Drawable>?,
                    isFirstResource: Boolean,
                ): Boolean {
                    ActivityCompat.startPostponedEnterTransition(it)
                    return false
                }

                override fun onResourceReady(
                    resource: Drawable,
                    model: Any,
                    target: Target<Drawable>,
                    dataSource: DataSource,
                    isFirstResource: Boolean,
                ): Boolean {
                    ActivityCompat.startPostponedEnterTransition(it)
                    return false
                }
            })
    }

    glideRequest.into(this)
}