package co.kr.cobosys.domain.models

data class AccessTokenModel(
    val code: String,
    val message: String,
    val data: AccessTokenData
)

data class AccessTokenData(
    val accessToken: String
)

data class MemberInfoModel(
    val code: String,
    val message: String,
    val data: List<MemberInfoData>
)

data class MemberInfoData(
    val memberId: String,
    val memberName: String,
    val memberBirthDay: String,
    val memberGender: String,
    val memberPhoneNum: String,
    val memberQrCode: String
)

data class SharedMessage(
    val contents: String
)

data class UserIDDuplicationCheck(
    val isDuplication: Boolean
)

data class CertifyCode(
    val certifyCode: String
)

data class FoundMemberId(
    val memberId: String,
    val regDate: String
)

data class FoundMemberPwd(
    val memberUUID: String
)

data class Terms(
    val useTerms: String,
    val overYouth: String,
    val personalInfo: String,
    val locationInfo: String
)

data class Home(
    val regularStoreList: List<RegularStoreList>,
    val recentlyVisitedStoreList: List<StoreList>
)

data class Store(
    val storeList: List<StoreList>
)

data class StoreList(
    val code: String,
    val name: String,
    val address: String,
    val favorite: Boolean,
    val regular: String,
    val distance: Double,
    val imgUrl: List<String>?
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
    val favoriteStatus: Boolean,
    val regular: String,
    val distance: Double,
    val telNumber: String,
    val imgUrl: List<String>?,
    val menuList: List<MenuList>
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

data class RegularStoreList(
    val code: String,
    val regularStoreName: String,
    val point: String,
    val maxPoint: Int,
    val minPoint: Int,
    val coupon: Int,
    val bestProductImgUrl: List<String>?,
    val bestProduct: List<ProductList>
)

data class Point(
    val pointList: List<PointList>
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

data class CouponPolicy(
    val couponPolicyList: List<CouponPolicyList>
)

data class CouponPolicyList(
    val couponNumber: Int,
    val couponPrice: String
)

data class Coupon(
    val count: Int,
    val couponList: List<CouponList>
)

data class CouponList(
    val storeName: String,
    val couponPrice: String,
    val date: String,
    val time: String,
    val couponCode: String,
    val usedStatus: String,
    val expiredDate: String,
    val giftStatus: String,
    val expiredStatus: String
)

data class CanBuyCouponStore(
    val canBuyCouponStoreList: List<CanBuyCouponStoreList>
)

data class CanBuyCouponStoreList(
    val code: String,
    val storeName: String,
    val remainPoint: String
)