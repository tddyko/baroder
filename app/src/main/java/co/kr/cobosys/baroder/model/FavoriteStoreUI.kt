package co.kr.cobosys.baroder.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class FavoriteStoreUI(
    val id: Int,
    val storeName: String?,
    val point: Int?,
    val nextPoint: Int?,
    val coupon: Int,
    val bestProduct: List<String>?,
    val bestProductImgUrl: List<String>?
): Parcelable