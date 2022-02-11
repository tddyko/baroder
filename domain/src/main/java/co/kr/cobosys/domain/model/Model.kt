package co.kr.cobosys.domain.model

data class Store(
    val code: String,
    val name: String,
    val location: String,
    val address: String,
    val imgUrl: String?,
    val favorite: Boolean
)

data class PointList(
    val code: String,
    val storeName: String?,
    val point: String?,
    val minPoint: Int,
    val maxPoint: Int,
    val coupon: String?,
    val bestProduct: List<String>?,
    val bestProductImgUrl: List<String>?
)

data class RecentlyVisitedStoreList(
    val code: String,
    val storeName: String?,
    val imgUrl: String?
)

data class QrCode(
    val QrUrl: String
)