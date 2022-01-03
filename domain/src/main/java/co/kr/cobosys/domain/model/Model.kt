package co.kr.cobosys.domain.model

data class Store(
    val id: Int,
    val name: String,
    val location: String,
    val address: String,
    val imgUrl: String?,
    val favorite: Boolean
)

data class FavoriteStore(
    val id: Int,
    val storeName: String?,
    val point: Int?,
    val mainText: String,
    val minPoint: Int,
    val maxPoint: Int,
    val coupon: Int?,
    val bestProduct: List<String>?,
    val bestProductImgUrl: List<String>?
)

data class QrCode(
    val QrUrl: String
)