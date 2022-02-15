package co.kr.cobosys.data.api

import co.kr.cobosys.data.network.ApiService
import retrofit2.http.*

interface Request: ApiService {

    @POST("v1/member/reg")
    suspend fun signUpMember(
        @Field("member_id") id: String,
        @Field("member_pwd") pwd: String,
        @Field("member_nm") name: String,
        @Field("birth_day") birthDay: String,
        @Field("gender_mf") gender: String,
        @Field("hp_no") phoneNum: String,
        @Field("use_clause_yn") clause: String,
        @Field("over_youth_yn") older: String,
        @Field("personal_info_yn") personal: String,
        @Field("location_info_yn") location: String
    ): ShareMessageResponse

    @GET("v1/home/clause")
    suspend fun checkTerms(): TermsResponse

    @PUT("tku/v1/member/mod")
    suspend fun updateMemberInfo(
        @Field("hp_no") phoneNum: String,
        @Field("gender_mf") gender: String,
        @Field("birth_day") birthDay: String
    )

    @GET("v1/login")
    suspend fun logIn(
        @Query("member_id") id: String,
        @Query("member_pwd") pwd: String
    ): AccessTokenResponse

    @DELETE("tku/v1/member/quit")
    suspend fun signOutMember(
        @Field("reason") reason: String
    ): ShareMessageResponse

    @GET("tku/v1/member")
    suspend fun memberDetailInfo(): MemberInfoResponse

    @PUT("tku/v1/member/pwd/mod")
    suspend fun changeMemberPwd(
        @Field("current_password") curPassword: String,
        @Field("new_passoword") newPassword: String
    )

    @GET("v1/member/duplication")
    suspend fun checkUserIdDuplication(
        @Query("member_id") memberId: String
    ): UserIDDuplicationCheckResponse

    @POST("v1/member/id")
    suspend fun findMemberId(
        @Field("hp_no") PhoneNum: String
    ): FoundMemberIdResponse

    @POST("v1/member/certify")
    suspend fun requestCertifyCode(
        @Field("hp_no") PhoneNum: String,
        @Field("duplication") duplication: String
    ): CertifyCodeResponse

    @POST("v1/member/find/pwd")
    suspend fun findMemberPwd(
        @Field("member_id") id: String,
        @Field("hp_no") phoneNum: String
    ): FoundMemberPwdResponse

    @PUT("v1/member/new/pwd")
    suspend fun changePassword(
        @Field("member_uuid") uuid: String,
        @Field("new_password") pwd: String
    )

    @GET("tku/v1/member/point")
    suspend fun checkPointList(): PointListResponse

    @GET("v1/home/rmd")
    suspend fun checkHomeStoreList(
        @Query("app_latitude") latitude: Double,
        @Query("app_longitude") longitude: Double
    ): StoreListResponse

    @GET("tku/v1/home/recent")
    suspend fun checkHomeRecentStoreList(
        @Query("app_latitude") latitude: Double,
        @Query("app_longitude") longitude: Double
    ): StoreListResponse

    @GET("tku/v1/home")
    suspend fun checkHomeList(
        @Query("app_latitude") latitude: Double,
        @Query("app_longitude") longitude: Double
    ): HomeResponse

    @GET("v1/store/list")
    suspend fun checkStoreList(
        @Query("app_latitude") latitude: Double,
        @Query("app_longitude") longitude: Double,
        @Query("options") options: Int
    ): StoreListResponse

    @GET("v1/store")
    suspend fun checkStoreDtail(
        @Query("store_cd") code: String,
        @Query("app_latitude") latitude: Double,
        @Query("app_longitude") longitude: Double
    ): StoreDetailResponse

    @POST("tku/v1/store/booked/status")
    suspend fun favoriteStoreRegister(
        @Field("store_cd") code: String
    ): ShareMessageResponse

    @DELETE("tku/v1/store/booked/cancel")
    suspend fun favoriteStoreDelete(
        @Field("store_cd") code: String,
    ): ShareMessageResponse

    @GET("tku/v1/store/patron")
    suspend fun recentStoreRegister(
        @Query("app_latitude") latitude: Double,
        @Query("app_longitude") longitude: Double
    ): StoreListResponse

    @Headers("Content-Type: application/x-www-form-urlencoded")
    @PUT("tku/v1/store/patron/status")
    suspend fun changeRecentStore(
        @Field("store_cd") code: Map<String, String>
    ): ShareMessageResponse

    @GET("tku/v1/store/booked")
    suspend fun checkFavoriteStore(
        @Query("app_latitude") latitude: Double,
        @Query("app_longitude") longitude: Double
    ): StoreListResponse

    @GET("v1/coupon/policy")
    suspend fun checkCouponPolicy(): CouponPolicyResponse

    @PUT("tku/v1/coupon/buy")
    suspend fun buyCoupon(
        @Field("store_cd") code: String,
        @Field("coupon_cm_pl_no") couponNum: Int,
        @Field("remain_mile") remainPoint: Int,
        @Field("use_mile") usePoint: Int,
        @Field("prev_mile") prevPoint: Int
    )

    @GET("tku/v1/coupon/list")
    suspend fun checkCouponList(
        @Query("usable_yn") usableStatus: String,
        @Query("store_cd") code: String
    ): CouponResponse

    @GET("tku/v1/coupon/buy/store/list")
    suspend fun canBuyCouponStoreList(
        @Query("coupon_amt") couponPrice: String
    ): CanBuyCouponStoreResponse
}