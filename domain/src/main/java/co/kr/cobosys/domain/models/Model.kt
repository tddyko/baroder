package co.kr.cobosys.domain.models

import java.util.*

data class AccessTokenModel(
    val code: String,
    val message: String,
    val data: AccessTokenData
)

data class AccessTokenData(
    val accessToken: String?
)

data class MemberInfoModel(
    val code: String,
    val message: String,
    val data: MemberInfoData
)

data class MemberInfoData(
    val memberId: String,
    val memberName: String,
    val memberBirthDay: String,
    val memberGender: String,
    val memberPhoneNum: String,
    val memberQrCode: String
)

data class SharedMessageModel(
    val code: String,
    val message: String,
    val data: SharedMessageData
)

data class SharedMessageData(
    val contents: String
)

data class UserIDDuplicationCheckModel(
    val code: String,
    val message: String,
    val data: UserIDDuplicationCheckData
)

data class UserIDDuplicationCheckData(
    val isDuplication: Boolean
)

data class CertifyCodeModel(
    val code: String,
    val message: String,
    val data: CertifyCodeData
)

data class CertifyCodeData(
    val certifyCode: String
)

data class FoundMemberIdModel(
    val code: String,
    val message: String,
    val data: List<FoundMemberIdData>
)

data class FoundMemberIdData(
    val memberId: String,
    val regDate: String
)

data class FoundMemberPwdModel(
    val code: String,
    val message: String,
    val data: FoundMemberPwdData
)

data class FoundMemberPwdData(
    val memberUUID: String
)

data class TermsModel(
    val code: String,
    val message: String,
    val data: List<TermsData>
)

data class TermsData(
    val useTerms: String,
    val overYouth: String,
    val personalInfo: String,
    val locationInfo: String
)

data class HomeModel(
    val code: String,
    val message: String,
    val data: List<HomeData>
)

data class HomeData(
    val regularStoreList: List<RegularStoreList>,
    val recentlyVisitedStoreList: List<StoreList>
)

data class StoreModel(
    val code: String,
    val message: String,
    val data: StoreData
)

data class StoreData(
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

data class StoreDetailModel(
    val code: String,
    val message: String,
    val data: List<StoreDetailData>
)

data class StoreDetailData(
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

data class PointModel(
    val code: String,
    val message: String,
    val data: PointData
)

data class PointData(
    val pointList: List<PointList>
)

data class PointList(
    val code: String,
    val storeName: String,
    val point: String,
    val pointHistory: PointHistory
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

data class CouponPolicyModel(
    val code: String,
    val message: String,
    val data: CouponPolicyData
)

data class CouponPolicyData(
    val couponPolicyList: List<CouponPolicyList>
)

data class CouponPolicyList(
    val couponNumber: Int,
    val couponPrice: String
)

data class CouponModel(
    val code: String,
    val message: String,
    val data: List<CouponData>
)

data class CouponData(
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

data class CanBuyCouponStoreModel(
    val code: String,
    val message: String,
    val data: CanBuyCouponStoreData
)

data class CanBuyCouponStoreData(
    val canBuyCouponStoreList: List<CanBuyCouponStoreList>
)

data class CanBuyCouponStoreList(
    val code: String,
    val storeName: String,
    val remainPoint: String
)

data class LocalAccessToken(
    val uuid: UUID,
    val accessToken: String
)

data class LocalMember(
    val uuid: UUID,
    val id: String,
    val pwd: String
)