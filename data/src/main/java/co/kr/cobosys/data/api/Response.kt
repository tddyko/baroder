package co.kr.cobosys.data.api

import com.google.gson.annotations.SerializedName

data class StoreListResponse(
    @SerializedName("store_cd") val code: String,
    @SerializedName("store_nm") val name: String,
    @SerializedName("address") val address: String,
    @SerializedName("booked_status") val favorite: Boolean,
    @SerializedName("patron_yn") val regular: String,
    @SerializedName("distance") val distance: Double,
    @SerializedName("imgUrl") val imgUrl: List<String>
)

data class StoreDetailResponse(
    @SerializedName("store_cd") val code: String,
    @SerializedName("store_nm") val storeName: String,
    @SerializedName("address") val address: String,
    @SerializedName("address_desc") val addressDetail: String,
    @SerializedName("store_info") val storeInfo: String,
    @SerializedName("business_hrs") val businessHour: String,
    @SerializedName("store_latitude") val storeLatitude: Double,
    @SerializedName("store_longitude") val storeLongitude: Double,
    @SerializedName("coupon_cnt") val couponCount: Int,
    @SerializedName("booked_status") val favoriteStatusL: Boolean,
    @SerializedName("patron_yn") val regular: String,
    @SerializedName("distance") val distance: Double,
    @SerializedName("tel_no") val telNumber: String,
    @SerializedName("images(List)") val imgUrl: String
)

data class RegularStoreListResponse(
    @SerializedName("store_cd") val code: String,
    @SerializedName("store_nm") val storeName: String,
    @SerializedName("remain_mile") val point: String,
    @SerializedName("goal_mile") val maxPoint: Int,
    @SerializedName("less_mile") val minPoint: Int,
    @SerializedName("coupon_cnt") val coupon: Int,
    @SerializedName("file_path") val bestProductImgUrl: List<String>,
    @SerializedName("product_list") val bestProduct: List<RegularStoreBestProductResponse>
)

data class RegularStoreBestProductResponse(
    @SerializedName("product_nm") val productName: String,
    @SerializedName("prst_imgfile_path") val productFileName: String,
    @SerializedName("amt") val amt: String
    )

data class RecentlyVisitedStoreListResponse(
    @SerializedName ("store_cd") val code: String,
    @SerializedName ("store_nm") val storeName: String,
    @SerializedName ("address") val address: String,
    @SerializedName ("booked_status") val favorite: Boolean,
    @SerializedName ("patron_yn") val regular: String,
    @SerializedName ("distance") val distance: Double,
    @SerializedName ("file_path")  val storeImgUrl: List<String>,
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

data class MemberInfoResponse(
    @SerializedName ("member_id") val memberId: String,
    @SerializedName ("member_nm") val memberName: String,
    @SerializedName ("birth_day") val memberBirthDay: String,
    @SerializedName ("gender_mf") val memberGender: String,
    @SerializedName ("hp_no") val memberPhoneNum: String,
    @SerializedName ("qr_code") val memberQrCode: String
)

data class MenuListUI(
    @SerializedName ("menu") val menu: String,
    @SerializedName ("product_list") val product: List<ProductListResponse>
)

data class ProductListResponse(
    @SerializedName ("product_nm") val productName: String,
    @SerializedName ("prst_imgfile_path") val productFileName: String,
    @SerializedName ("amt") val amt: String
)