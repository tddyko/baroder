package co.kr.cobosys.baroder.models

import android.os.Parcelable
import co.kr.cobosys.baroder.base.adapter.Code
import kotlinx.parcelize.Parcelize

/* 로그인 및 회원관련 */
@Parcelize
data class AccessTokenModelUI(
    override val code: String,
    val message: String,
    val data: AccessTokenDataUI
): Code, Parcelable

@Parcelize
data class AccessTokenDataUI(
    val accessToken: String
) : Parcelable

@Parcelize
data class MemberInfoModelUI (
    override val code: String,
    val message: String,
    val data: MemberInfoDataUI
): Code, Parcelable

@Parcelize
data class MemberInfoDataUI(
    val memberId: String,
    val memberName: String,
    val memberBirthDay: String,
    val memberGender: String,
    val memberPhoneNum: String,
    val memberQrCode: String
) : Parcelable

@Parcelize
data class SharedMessageModelUI (
    override val code: String,
    val message: String,
    val data: SharedMessageDataUI
): Code,Parcelable

@Parcelize
data class SharedMessageDataUI(
    val contents: String
) : Parcelable

@Parcelize
data class UserIDDuplicationCheckModelUI (
    override val code: String,
    val message: String,
    val data: UserIDDuplicationCheckDataUI
): Code, Parcelable

@Parcelize
data class UserIDDuplicationCheckDataUI(
    val isDuplication: Boolean
) : Parcelable

@Parcelize
data class CertifyCodeModelUI (
    override val code: String,
    val message: String,
    val data: CertifyCodeDataUI
): Code, Parcelable

@Parcelize
data class CertifyCodeDataUI(
    val certifyCode: String
) : Parcelable

@Parcelize
data class FoundMemberIdModelUI (
    override val code: String,
    val message: String,
    val data: List<FoundMemberIdDataUI>
): Code, Parcelable

@Parcelize
data class FoundMemberIdDataUI(
    val memberId: String,
    val regDate: String
) : Parcelable

@Parcelize
data class FoundMemberPwdModelUI (
    override val code: String,
    val message: String,
    val data: FoundMemberPwdUI
): Code, Parcelable

@Parcelize
data class FoundMemberPwdUI(
    val memberUUID: String
) : Parcelable

@Parcelize
data class TermsModelUI (
    override val code: String,
    val message: String,
    val data: List<TermsDataUI>
): Code, Parcelable

@Parcelize
data class TermsDataUI(
    val useTerms: String,
    val overYouth: String,
    val personalInfo: String,
    val locationInfo: String
) : Parcelable

/* 홈화면 및 상점 */
@Parcelize
data class HomeModelUI (
    override val code: String,
    val message: String,
    val data: List<HomeDataUI>
): Code, Parcelable

@Parcelize
data class HomeDataUI(
    val regularStoreList: List<RegularStoreListUI>,
    val recentlyVisitedStoreList: List<StoreListUI>
) : Parcelable

@Parcelize
data class StoreModelUI (
    override val code: String,
    val message: String,
    val data: StoreDataUI
): Code, Parcelable

@Parcelize
data class StoreDataUI(
    val storeList: List<StoreListUI>
) : Parcelable

@Parcelize
data class StoreListUI(
    override val code: String,
    val name: String,
    val address: String,
    val favorite: Boolean,
    val regular: String,
    val distance: Double,
    val imgUrl: List<String>?
) : Code, Parcelable {
    val storeName: String
        get() = name
    val storeAddress: String
        get() = address
    val storeDistance: String
        get() = "나와의 거리 $distance km"
    val srcImage: String
        get() = if ((null == imgUrl) || (imgUrl[0].isEmpty())) { "" } else { imgUrl[0] }
}

@Parcelize
data class StoreDetailModelUI (
    override val code: String,
    val message: String,
    val data: List<StoreDetailDataUI>
): Code, Parcelable

@Parcelize
data class StoreDetailDataUI(
    override val code: String,
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
    val menuList: List<MenuListUI>
) : Code, Parcelable

@Parcelize
data class MenuListUI(
    val menu: String,
    val product: List<ProductListUI>
) : Parcelable

@Parcelize
data class ProductListUI(
    val productName: String,
    val productFileName: String,
    val amt: String
) : Parcelable

@Parcelize
data class RegularStoreListUI(
    override val code: String,
    val regularStoreName: String,
    val point: String,
    val maxPoint: Int,
    val minPoint: Int,
    val coupon: Int,
    val bestProductImgUrl: List<String>?,
    val bestProduct: List<ProductListUI>
) : Code, Parcelable

/* 포인트 */

@Parcelize
data class PointModelUI (
    override val code: String,
    val message: String,
    val data: PointDataUI
): Code, Parcelable

@Parcelize
data class PointDataUI(
    val pointList: List<PointListUI>
) : Parcelable

@Parcelize
data class PointListUI(
    override val code: String,
    val storeName: String,
    val point: String,
    val pointHistory: List<PointHistoryUI>
) : Code, Parcelable

@Parcelize
data class PointHistoryUI(
    val total: List<TotalUI>,
    val use: List<UseUI>,
    val add: List<AddUI>
) : Parcelable

@Parcelize
data class TotalUI(
    val pointCategory: String,
    val pointAmt: String,
    val pointAssignAt: String
) : Parcelable

@Parcelize
data class UseUI(
    val pointCategory: String,
    val pointAmt: String,
    val pointAssignAt: String
) : Parcelable

@Parcelize
data class AddUI(
    val pointCategory: String,
    val pointAmt: String,
    val pointAssignAt: String
) : Parcelable

/* 쿠폰 */
@Parcelize
data class CouponPolicyModelUI (
    override val code: String,
    val message: String,
    val data: CouponPolicyDataUI
): Code, Parcelable

@Parcelize
data class CouponPolicyDataUI(
    val couponPolicyList: List<CouponPolicyListUI>
) : Parcelable

@Parcelize
data class CouponPolicyListUI(
    val couponNumber: Int,
    val couponPrice: String
) : Parcelable

@Parcelize
data class CouponModelUI (
    override val code: String,
    val message: String,
    val data: List<CouponDataUI>
): Code, Parcelable

@Parcelize
data class CouponDataUI(
    val count: Int,
    val couponList: List<CouponListUI>
) : Parcelable

@Parcelize
data class CouponListUI(
    val storeName: String,
    val couponPrice: String,
    val date: String,
    val time: String,
    val couponCode: String,
    val usedStatus: String,
    val expiredDate: String,
    val giftStatus: String,
    val expiredStatus: String
) : Parcelable

@Parcelize
data class CanBuyCouponStoreModelUI (
    override val code: String,
    val message: String,
    val data: CanBuyCouponStoreDataUI
): Code, Parcelable

@Parcelize
data class CanBuyCouponStoreDataUI(
    val canBuyCouponStoreList: List<CanBuyCouponStoreListUI>
) : Parcelable

@Parcelize
data class CanBuyCouponStoreListUI(
    override val code: String,
    val storeName: String,
    val remainPoint: String
) : Code, Parcelable

@Parcelize
data class LocalAccessTokenUI(
    val accessToken: String
): Parcelable

@Parcelize
data class LocalMemberUI(
    val id: String,
    val pwd: String
): Parcelable