package co.kr.cobosys.baroder.model

import android.os.Parcelable
import co.kr.cobosys.baroder.base.adapter.Code
import kotlinx.parcelize.Parcelize

/* 로그인 및 회원관련 */
@Parcelize
data class AccessTokenUI(
    val accessToken: String
) : Parcelable

@Parcelize
data class MemberInfoUI(
    val memberId: String,
    val memberName: String,
    val memberBirthDay: String,
    val memberGender: String,
    val memberPhoneNum: String,
    val memberQrCode: String
) : Parcelable

@Parcelize
data class SharedMessageUI(
    val contents: String
) : Parcelable

@Parcelize
data class UserIDDuplicationCheckUI(
    val isDuplication: Boolean
) : Parcelable

@Parcelize
data class CrtifyCodeUI(
    val certifyCode: String
) : Parcelable

@Parcelize
data class FoundMemberIdUI(
    val memberId: String,
    val regDate: String
) : Parcelable

@Parcelize
data class FoundMemberPwdUI(
    val memberUUID: String
) : Parcelable

@Parcelize
data class TermsUI(
    val useTerms: String,
    val overYouth: String,
    val personalInfo: String,
    val locationInfo: String
) : Parcelable

/* 홈화면 및 상점 */

@Parcelize
data class HomeUI(
    val regularStoreList: List<RegularStoreListUI>,
    val RecentlyVisitedStoreList: List<RecentlyVisitedStoreListUI>
) : Parcelable

@Parcelize
data class StoreUI(
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

@Parcelize
data class StoreDetaiUI(
    override val code: String,
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
    val bestProduct: List<RegularStoreBestProductUI>
) : Code, Parcelable

@Parcelize
data class RegularStoreBestProductUI(
    val productName: String,
    val productFileName: String,
    val amt: String
) : Parcelable

@Parcelize
data class RecentlyVisitedStoreListUI(
    val recentlyStoreList: List<StoreListUI>
) : Parcelable

@Parcelize
data class FavoriteStoreListUI(
    val favoriteStoreList: List<StoreListUI>
) : Parcelable

/* 포인트 */

@Parcelize
data class PointUI(
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
data class CouponPolicyUI(
    val couponPolicyList: List<CouponPolicyListUI>
) : Parcelable

@Parcelize
data class CouponPolicyListUI(
    val couponNumber: Int,
    val couponPrice: String
) : Parcelable

@Parcelize
data class CouponUI(
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
data class CanBuyCouponStoreUI(
    val canBuyCouponStoreList: List<CanBuyCouponStoreListUi>
) : Parcelable

@Parcelize
data class CanBuyCouponStoreListUi(
    override val code: String,
    val storeName: String,
    val remainPoint: String
) : Code, Parcelable
