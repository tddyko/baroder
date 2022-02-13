package co.kr.cobosys.baroder.model

import android.os.Parcelable
import co.kr.cobosys.baroder.base.adapter.Code
import kotlinx.parcelize.Parcelize

@Parcelize
data class StoreListUI(
    override val code: String,
    val name: String,
    val address: String,
    val favorite: Boolean,
    val regular: String,
    val distance: Double,
    val imgUrl: List<String>
) : Code, Parcelable

@Parcelize
data class StoreDetailUI(
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
    val imgUrl: List<String>
) : Code, Parcelable

@Parcelize
data class EmptyRegularStoreListUI(
    override val code: String,
    val emptyStoreName: String,
    val emptyPoint: String,
    val emptyMainText: String,
    val emptyStartPoint: Int,
    val emptyEndPoint: Int,
    val firstBtn: String,
    val secondBtn: String
) : Code, Parcelable

@Parcelize
data class RegularStoreListUI(
    override val code: String,
    val storeName: String,
    val point: String,
    val maxPoint: Int,
    val minPoint: Int,
    val coupon: Int,
    val bestProductImgUrl: List<String>,
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
    override val code: String,
    val storeName: String,
    val address: String,
    val favorite: Boolean,
    val regular: String,
    val distance: Double,
    val storeImgUrl: List<String>,
) : Code, Parcelable

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
data class MenuListUI(
    val menu: String,
    val product: List<ProductListUI>
): Parcelable

@Parcelize
data class ProductListUI(
    val productName: String,
    val productFileName: String,
    val amt: String
): Parcelable