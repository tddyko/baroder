package co.kr.cobosys.baroder.model

import android.os.Parcelable
import co.kr.cobosys.baroder.base.adapter.RecyclerItem
import kotlinx.parcelize.Parcelize

@Parcelize
data class StoreUI(
    override val code: String?,
    val name: String,
    val location: String,
    val address: String,
    val imgUrl: String?,
    val favorite: Boolean
): RecyclerItem, Parcelable

@Parcelize
data class PointListUI(
    override val code: String?,
    val storeName: String?,
    val point: String?,
    val minPoint: Int,
    val maxPoint: Int,
    val coupon: String?,
    val bestProduct: List<String>?,
    val bestProductImgUrl: List<String>?
): RecyclerItem, Parcelable

@Parcelize
data class QRcode(
    val qrUrl: String
): Parcelable

@Parcelize
data class BarCode(
    val barCodeUrl: String
): Parcelable