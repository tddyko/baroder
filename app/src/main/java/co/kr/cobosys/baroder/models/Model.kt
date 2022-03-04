package co.kr.cobosys.baroder.models

import android.os.Parcelable
import co.kr.cobosys.baroder.base.adapter.Code
import kotlinx.parcelize.Parcelize

/* 로그인 및 회원관련 */
@Parcelize
data class AccessTokenModelUI(
    val code: String,
    val message: String,
    val data: AccessTokenDataUI
): Parcelable

@Parcelize
data class AccessTokenDataUI(
    val accessToken: String
) : Parcelable

@Parcelize class MemberInfoModelUI (
    val code: String,
    val message: String,
    val data: MemberInfoDataUI
): Parcelable

@Parcelize
data class MemberInfoDataUI(
    val memberId: String,
    val memberName: String,
    val memberBirthDay: String,
    val memberGender: String,
    val memberPhoneNum: String,
    val memberQrCode: String
) : Parcelable

@Parcelize class SharedMessageModelUI (
    val code: String,
    val message: String,
    val data: SharedMessageDataUI
): Parcelable

@Parcelize
data class SharedMessageDataUI(
    val contents: String
) : Parcelable

@Parcelize class UserIDDuplicationCheckModelUI (
    val code: String,
    val message: String,
    val data: UserIDDuplicationCheckDataUI
): Parcelable

@Parcelize
data class UserIDDuplicationCheckDataUI(
    val isDuplication: Boolean
) : Parcelable

@Parcelize class CertifyCodeModelUI (
    val code: String,
    val message: String,
    val data: CertifyCodeDataUI
): Parcelable

@Parcelize
data class CertifyCodeDataUI(
    val certifyCode: String
) : Parcelable

@Parcelize class FoundMemberIdModelUI (
    val code: String,
    val message: String,
    val data: List<FoundMemberIdDataUI>
): Parcelable

@Parcelize
data class FoundMemberIdDataUI(
    val memberId: String,
    val regDate: String
) : Parcelable

@Parcelize class FoundMemberPwdModelUI (
    val code: String,
    val message: String,
    val data: FoundMemberPwdUI
): Parcelable

@Parcelize
data class FoundMemberPwdUI(
    val memberUUID: String
) : Parcelable

@Parcelize class TermsModelUI (
    val code: String,
    val message: String,
    val data: List<TermsDataUI>
): Parcelable

@Parcelize
data class TermsDataUI(
    val useTerms: String,
    val overYouth: String,
    val personalInfo: String,
    val locationInfo: String
) : Parcelable

/* 홈화면 및 상점 */
@Parcelize class HomeModelUI (
    val code: String,
    val message: String,
    val data: List<HomeDataUI>
): Parcelable

@Parcelize
data class HomeDataUI(
    val regularStoreList: List<RegularStoreListUI>,
    val recentlyVisitedStoreList: List<StoreListUI>
) : Parcelable

@Parcelize class StoreModelUI (
    val code: String,
    val message: String,
    val data: StoreDataUI
): Parcelable

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
) : Code, Parcelable

@Parcelize class StoreDetailModelUI (
    val code: String,
    val message: String,
    val data: List<StoreDetailDataUI>
): Parcelable

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

@Parcelize class PointModelUI (
    val code: String,
    val message: String,
    val data: PointDataUI
): Parcelable

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
@Parcelize class CouponPolicyModelUI (
    val code: String,
    val message: String,
    val data: CouponPolicyDataUI
): Parcelable

@Parcelize
data class CouponPolicyDataUI(
    val couponPolicyList: List<CouponPolicyListUI>
) : Parcelable

@Parcelize
data class CouponPolicyListUI(
    val couponNumber: Int,
    val couponPrice: String
) : Parcelable

@Parcelize class CouponModelUI (
    val code: String,
    val message: String,
    val data: List<CouponDataUI>
): Parcelable

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

@Parcelize class CanBuyCouponStoreModelUI (
    val code: String,
    val message: String,
    val data: CanBuyCouponStoreDataUI
): Parcelable

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
