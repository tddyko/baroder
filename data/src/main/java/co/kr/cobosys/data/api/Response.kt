package co.kr.cobosys.data.api

import com.google.gson.annotations.SerializedName

data class StoreResponse(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("location") val location: String,
    @SerializedName("address") val address: String,
    @SerializedName("imgUrl") val imgUrl: String,
    @SerializedName("favorite") val favorite: Boolean

)

data class PointListResponse(
    @SerializedName("store_cd") val code: String,
    @SerializedName("store_nm") val storeName: String,
    @SerializedName("remain_mile") val point: String,
    @SerializedName("less_mile") val minPoint: Int,
    @SerializedName("goal_mile") val maxPoint: Int,
    @SerializedName("coupon_cnt") val coupon: String,
    @SerializedName("product_nm") val bestProduct: List<String>,
    @SerializedName("file_path") val bestProductImgUrl: List<String>
)