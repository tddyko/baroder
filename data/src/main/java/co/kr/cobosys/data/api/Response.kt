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

data class FavoriteStoreResponse(
    @SerializedName("id") val id: Int,
    @SerializedName("storeName") val storeName: String,
    @SerializedName("point") val point: String,
    @SerializedName("mainText") val mainText: String,
    @SerializedName("minPoint") val minPoint: Int,
    @SerializedName("maxPoint") val maxPoint: Int,
    @SerializedName("coupon") val coupon: String,
    @SerializedName("bestProduct") val bestProduct: List<String>,
    @SerializedName("bestProductImgUrl") val bestProductImgUrl: List<String>
)