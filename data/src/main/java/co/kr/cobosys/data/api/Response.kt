package co.kr.cobosys.data.api

import com.google.gson.annotations.SerializedName

data class AccessTokenResponseModel(
    @SerializedName("code") val code: String,
    @SerializedName("message") val message: String,
    @SerializedName("data") val data: AccessTokenResponseData

)

data class AccessTokenResponseData(
    @SerializedName("access_token") val accessToken: String
)

data class MemberInfoResponseModel(
    @SerializedName("code") val code: String,
    @SerializedName("message") val message: String,
    @SerializedName("data") val data: MemberInfoResponseData
)

data class MemberInfoResponseData(
    @SerializedName ("member_id") val memberId: String,
    @SerializedName ("member_nm") val memberName: String,
    @SerializedName ("birth_day") val memberBirthDay: String,
    @SerializedName ("gender_mf") val memberGender: String,
    @SerializedName ("hp_no") val memberPhoneNum: String,
    @SerializedName ("qr_code") val memberQrCode: String
)

data class SharedMessageResponseModel(
    @SerializedName("code") val code: String,
    @SerializedName("message") val message: String,
    @SerializedName("data") val data: SharedMessageResponseData
)

data class SharedMessageResponseData(
    @SerializedName ("contents") val contents: String
)

data class UserIDDuplicationCheckResponseModel(
    @SerializedName("code") val code: String,
    @SerializedName("message") val message: String,
    @SerializedName("data") val data: UserIDDuplicationCheckResponseData
)

data class UserIDDuplicationCheckResponseData(
    @SerializedName ("is_duplicate") val isDuplication: Boolean
)

data class CertifyCodeResponseModel(
    @SerializedName("code") val code: String,
    @SerializedName("message") val message: String,
    @SerializedName("data") val data: CertifyCodeResponseData
)

data class CertifyCodeResponseData(
    @SerializedName ("certify_no") val certifyCode: String
)

data class FoundMemberIdResponseModel(
    @SerializedName("code") val code: String,
    @SerializedName("message") val message: String,
    @SerializedName("data") val data: List<FoundMemberIdResponseData>
)

data class FoundMemberIdResponseData(
    @SerializedName("member_id") val memberId: String,
    @SerializedName("reg_date") val regDate: String
)

data class FoundMemberPwdResponseModel(
    @SerializedName("code") val code: String,
    @SerializedName("message") val message: String,
    @SerializedName("data") val data:FoundMemberPwdResponseData
)

data class FoundMemberPwdResponseData(
    @SerializedName ("member_uuid") val memberUUID: String
)

data class TermsResponseModel(
    @SerializedName("code") val code: String,
    @SerializedName("message") val message: String,
    @SerializedName("data") val data: List<TermsResponseData>
)

data class TermsResponseData(
    @SerializedName ("use_clause") val useTerms: String,
    @SerializedName ("over_youth") val overYouth: String,
    @SerializedName ("personal_info") val personalInfo: String,
    @SerializedName ("location_info") val locationInfo: String
)

// 회원
data class HomeResponseModel(
    @SerializedName("code") val code: String,
    @SerializedName("message") val message: String,
    @SerializedName("data") val data: List<HomeResponseData>
)

data class HomeResponseData(
    @SerializedName ("patron_home") val regularStoreList: List<RegularStoreListResponse>,
    @SerializedName ("recent_home") val recentlyVisitedStoreList: List<StoreListResponse>
)

data class StoreResponseModel(
    @SerializedName("code") val code: String,
    @SerializedName("message") val message: String,
    @SerializedName("data") val data: StoreResponseData
)

data class StoreResponseData(
    @SerializedName ("store_list") val storeList: List<StoreListResponse>
)

data class StoreListResponse(
    @SerializedName("store_cd") val code: String,
    @SerializedName("store_nm") val name: String,
    @SerializedName("address") val address: String,
    @SerializedName("booked_status") val favorite: Boolean,
    @SerializedName("patron_yn") val regular: String,
    @SerializedName("distance") val distance: Double,
    @SerializedName("imgUrl") val imgUrl: List<String>?
)

data class StoreDetailResponseModel(
    @SerializedName("code") val code: String,
    @SerializedName("message") val message: String,
    @SerializedName("data") val data: List<StoreDetailResponseData>
)

data class StoreDetailResponseData(
    @SerializedName("store_cd") val code: String,
    @SerializedName("store_nm") val storeName: String,
    @SerializedName("address") val address: String,
    @SerializedName("address_desc") val addressDetail: String,
    @SerializedName("store_info") val storeInfo: String,
    @SerializedName("business_hrs") val businessHour: String,
    @SerializedName("store_latitude") val storeLatitude: Double,
    @SerializedName("store_longitude") val storeLongitude: Double,
    @SerializedName("coupon_cnt") val couponCount: Int,
    @SerializedName("booked_status") val favoriteStatus: Boolean,
    @SerializedName("patron_yn") val regular: String,
    @SerializedName("distance") val distance: Double,
    @SerializedName("tel_no") val telNumber: String,
    @SerializedName("images(List)") val imgUrl: List<String>?,
    @SerializedName("menu_list") val menuList: List<MenuListResponse>
)

data class MenuListResponse(
    @SerializedName ("menu") val menu: String,
    @SerializedName ("product_list") val product: List<ProductListResponse>
)

data class ProductListResponse(
    @SerializedName ("product_nm") val productName: String,
    @SerializedName ("prst_imgfile_path") val productFileName: String,
    @SerializedName ("amt") val amt: String
)

data class RegularStoreListResponse(
    @SerializedName("store_cd") val code: String,
    @SerializedName("store_nm") val storeName: String,
    @SerializedName("remain_mile") val point: String,
    @SerializedName("goal_mile") val maxPoint: Int,
    @SerializedName("less_mile") val minPoint: Int,
    @SerializedName("coupon_cnt") val coupon: Int,
    @SerializedName("file_path") val bestProductImgUrl: List<String>?,
    @SerializedName("product_list") val bestProduct: List<ProductListResponse>
)

data class PointResponseModel(
    @SerializedName("code") val code: String,
    @SerializedName("message") val message: String,
    @SerializedName("data") val data: PointResponseData
)

data class PointResponseData(
    @SerializedName ("store_point") val pointList: List<PointListResponse>
)

data class PointListResponse(
    @SerializedName ("store_cd")  val code: String,
    @SerializedName ("store_nm") val storeName: String,
    @SerializedName ("remain_mile") val point: String,
    @SerializedName ("point_history") val pointHistory: List<PointHistoryResponse>
)

data class PointHistoryResponse(
    @SerializedName ("total") val total: List<TotalResponse>,
    @SerializedName ("use") val use: List<UseResponse>,
    @SerializedName ("add") val add: List<AddResponse>
)

data class TotalResponse(
    @SerializedName ("mile_category") val pointCategory: String,
    @SerializedName ("mile_amt") val pointAssignAt: String,
    @SerializedName ("mile_assign_at") val pointAmt: String
)

data class UseResponse(
    @SerializedName ("mile_category") val pointCategory: String,
    @SerializedName ("mile_amt") val pointAssignAt: String,
    @SerializedName ("mile_assign_at") val pointAmt: String
)

data class AddResponse(
    @SerializedName ("mile_category") val pointCategory: String,
    @SerializedName ("mile_amt") val pointAssignAt: String,
    @SerializedName ("mile_assign_at") val pointAmt: String
)

data class CouponPolicyResponseModel(
    @SerializedName("code") val code: String,
    @SerializedName("message") val message: String,
    @SerializedName("data") val data: CouponPolicyResponseData
)

data class CouponPolicyResponseData(
    @SerializedName ("coupon_list") val couponPolicyList: List<CouponPolicyListResponse>
)

data class CouponPolicyListResponse(
    @SerializedName ("coupon_cm_pl_no") val couponNumber: Int,
    @SerializedName ("coupon_amt") val couponPrice: String
)

data class CouponResponseModel(
    @SerializedName("code") val code: String,
    @SerializedName("message") val message: String,
    @SerializedName("data") val data: List<CouponResponseData>
)

data class CouponResponseData(
    @SerializedName ("coupon_cnt") val count: Int,
    @SerializedName ("coupon_list") val couponList: List<CouponListResponse>
)

data class CouponListResponse(
    @SerializedName ("store_nm") val storeName: String,
    @SerializedName ("coupon_amt") val couponPrice: String,
    @SerializedName ("date") val date: String,
    @SerializedName ("time") val time: String,
    @SerializedName ("coupon_cd") val couponCode: String,
    @SerializedName ("used_yn") val usedStatus: String,
    @SerializedName ("expired_date") val expiredDate: String,
    @SerializedName ("gift_yn") val giftStatus: String,
    @SerializedName ("expired_yn") val expiredStatus: String
)

data class CanBuyCouponStoreResponseModel(
    @SerializedName("code") val code: String,
    @SerializedName("message") val message: String,
    @SerializedName("data") val data: CanBuyCouponStoreResponseData
)

data class CanBuyCouponStoreResponseData(
    @SerializedName ("coupon_list") val canBuyCouponStoreList: List<CanBuyCouponStoreListResponse>
)

data class CanBuyCouponStoreListResponse(
    @SerializedName ("store_cd") val code: String,
    @SerializedName ("store_nm") val storeName: String,
    @SerializedName ("remain_mile") val remainPoint: String
)