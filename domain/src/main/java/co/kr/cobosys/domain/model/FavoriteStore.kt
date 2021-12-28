package co.kr.cobosys.domain.model

data class FavoriteStore(
    val id: Int,
    val storeName: String?,
    val point: Int?,
    val nextPoint: Int?,
    val coupon: Int?,
    val bestProduct: List<String>?,
    val bestProductImgUrl: List<String>?
)