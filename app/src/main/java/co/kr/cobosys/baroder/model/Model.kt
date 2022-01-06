package co.kr.cobosys.baroder.model

import android.os.Parcelable
import co.kr.cobosys.baroder.base.adapter.RecyclerItem
import kotlinx.parcelize.Parcelize

@Parcelize
data class StoreUI(
    override val id: Int?,
    val name: String,
    val location: String,
    val address: String,
    val imgUrl: String?,
    val favorite: Boolean
): RecyclerItem, Parcelable

@Parcelize
data class EmptyFavoriteStoreUI(
    override val id: Int?,
    val emptyStoreName: String,
    val emptyPoint: String,
    val emptyMainText: String,
    val emptyStartPoint: Int,
    val emptyEndPoint: Int,
    val firstBtn: String,
    val secondBtn: String
): RecyclerItem, Parcelable

@Parcelize
data class FavoriteStoreUI(
    override val id: Int?,
    val storeName: String?,
    val point: String?,
    val mainText: String,
    val minPoint: Int,
    val maxPoint: Int,
    val coupon: String?,
    val bestProduct: List<String>?,
    val bestProductImgUrl: List<String>?
): RecyclerItem, Parcelable

@Parcelize
data class QRcode(
    val QrUrl: String
): Parcelable