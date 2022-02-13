package co.kr.cobosys.domain.model

data class StoreList(
    val code: String,
    val name: String,
    val address: String,
    val favorite: Boolean,
    val regular: String,
    val distance: Double,
    val imgUrl: List<String>
)

data class StoreDetail(
    val code: String,
    val storeName: String,
    val address: String,
    val addressDetail: String,
    val storeInfo: String,
    val businessHour: String,
    val storeLatitude: Double,
    val storeLongitude: Double,
    val couponCount: Int,
    val favoriteStatusL: Boolean,
    val regular: String,
    val distance: Double,
    val telNumber: String,
    val imgUrl: List<String>
)

data class RegularStoreList(
    val code: String,
    val storeName: String,
    val point: String,
    val maxPoint: Int,
    val minPoint: Int,
    val coupon: Int,
    val bestProductImgUrl: List<String>,
    val bestProduct: List<RegularStoreBestProduct>
)

data class RegularStoreBestProduct(
    val productName: String,
    val productFileName: String,
    val amt: String
)

data class RecentlyVisitedStoreList(
    val code: String,
    val storeName: String,
    val address: String,
    val favorite: Boolean,
    val regular: String,
    val distance: Double,
    val storeImgUrl: List<String>,
)

data class PointList(
    val code: String,
    val storeName: String,
    val point: String,
    val pointHistory: List<PointHistory>
)

data class PointHistory(
    val total: List<Total>,
    val use: List<Use>,
    val add: List<Add>
)

data class Total(
    val pointCategory: String,
    val pointAmt: String,
    val pointAssignAt: String
)

data class Use(
    val pointCategory: String,
    val pointAmt: String,
    val pointAssignAt: String
)

data class Add(
    val pointCategory: String,
    val pointAmt: String,
    val pointAssignAt: String
)

data class MemberInfo(
    val memberId: String,
    val memberName: String,
    val memberBirthDay: String,
    val memberGender: String,
    val memberPhoneNum: String,
    val memberQrCode: String
)

data class MenuList(
    val menu: String,
    val product: List<ProductList>
)

data class ProductList(
    val productName: String,
    val productFileName: String,
    val amt: String
)