package co.kr.cobosys.data.api

import retrofit2.http.*

interface Request {
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
    ): SharedMessageResponseModel

    @GET("v1/home/clause")
    suspend fun checkTerms(): TermsResponseModel

    @PUT("tku/v1/member/mod")
    suspend fun updateMemberInfo(
        @Header("Authorization") token: String,
        @Field("hp_no") phoneNum: String,
        @Field("gender_mf") gender: String,
        @Field("birth_day") birthDay: String
    )

    @FormUrlEncoded
    @POST("v1/login")
    suspend fun logIn(
        @Field("member_id") id: String,
        @Field("member_pwd") pwd: String
    ): AccessTokenResponseModel

    @DELETE("tku/v1/member/quit")
    suspend fun signOutMember(
        @Header("Authorization") token: String,
        @Path("reason") reason: String
    ): SharedMessageResponseModel

    @GET("tku/v1/member")
    suspend fun memberDetailInfo(
        @Header("Authorization") token: String
    ): MemberInfoResponseModel

    @PUT("tku/v1/member/pwd/mod")
    suspend fun changeMemberPwd(
        @Header("Authorization") token: String,
        @Field("current_password") curPassword: String,
        @Field("new_passoword") newPassword: String
    )

    @GET("v1/member/duplication")
    suspend fun checkUserIdDuplication(
        @Query("member_id") memberId: String
    ): UserIDDuplicationCheckResponseModel

    @FormUrlEncoded
    @POST("v1/member/id")
    suspend fun findMemberId(
        @Field("hp_no") PhoneNum: String
    ): FoundMemberIdResponseModel

    @POST("v1/member/certify")
    suspend fun requestCertifyCode(
        @Field("hp_no") PhoneNum: String,
        @Field("duplication") duplication: String
    ): CertifyCodeResponseModel

    @FormUrlEncoded
    @POST("v1/member/find/pwd")
    suspend fun findMemberPwd(
        @Field("member_id") id: String,
        @Field("hp_no") phoneNum: String
    ): FoundMemberPwdResponseModel

    @PUT("v1/member/new/pwd")
    suspend fun changePassword(
        @Field("member_uuid") uuid: String,
        @Field("new_password") pwd: String
    )

    @GET("tku/v1/member/point")
    suspend fun checkPointList(
        @Header("Authorization") token: String
    ): PointResponseModel

    @GET("v1/home/rmd")
    suspend fun checkHomeStoreList(
        @Header("Authorization") token: String,
        @Query("app_latitude") latitude: Double,
        @Query("app_longitude") longitude: Double
    ): StoreResponseModel

    @GET("tku/v1/home/recent")
    suspend fun checkHomeRecentStoreList(
        @Query("app_latitude") latitude: Double,
        @Query("app_longitude") longitude: Double
    ): StoreResponseModel

    @GET("tku/v1/home")
    suspend fun checkHomeList(
        @Header("Authorization") token: String,
        @Query("app_latitude") latitude: Double,
        @Query("app_longitude") longitude: Double
    ): HomeResponseModel

    @GET("v1/store/list")
    suspend fun checkStoreList(
        @Header("Authorization") token: String,
        @Query("app_latitude") latitude: Double,
        @Query("app_longitude") longitude: Double,
        @Query("options") options: Int
    ): StoreResponseModel

    @GET("v1/store")
    suspend fun checkStoreDtail(
        @Header("Authorization") token: String,
        @Query("store_cd") code: String,
        @Query("app_latitude") latitude: Double,
        @Query("app_longitude") longitude: Double
    ): StoreDetailResponseModel

    @FormUrlEncoded
    @POST("tku/v1/store/booked/status")
    suspend fun favoriteStoreRegister(
        @Header("Authorization") token: String,
        @Field("store_cd") code: String
    ): SharedMessageResponseModel

    @DELETE("tku/v1/store/booked/cancel")
    suspend fun favoriteStoreDelete(
        @Header("Authorization") token: String,
        @Path("store_cd") code: String,
    ): SharedMessageResponseModel

    @GET("tku/v1/store/patron")
    suspend fun recentlyVisitedStoreReq(
        @Header("Authorization") token: String,
        @Query("app_latitude") latitude: Double,
        @Query("app_longitude") longitude: Double
    ): StoreResponseModel

    @Headers("Content-Type: application/x-www-form-urlencoded")
    @PUT("tku/v1/store/patron/status")
    suspend fun changeRecentStore(
        @Header("Authorization") token: String,
        @Field("store_cd") code: Map<String, String>
    ): SharedMessageResponseModel

    @GET("tku/v1/store/booked")
    suspend fun checkFavoriteStore(
        @Header("Authorization") token: String,
        @Query("app_latitude") latitude: Double,
        @Query("app_longitude") longitude: Double
    ): StoreResponseModel

    @GET("v1/coupon/policy")
    suspend fun checkCouponPolicy(): CouponPolicyResponseModel

    @PUT("tku/v1/coupon/buy")
    suspend fun buyCoupon(
        @Header("Authorization") token: String,
        @Field("store_cd") code: String,
        @Field("coupon_cm_pl_no") couponNum: Int,
        @Field("remain_mile") remainPoint: Int,
        @Field("use_mile") usePoint: Int,
        @Field("prev_mile") prevPoint: Int
    )

    @GET("tku/v1/coupon/list")
    suspend fun checkCouponList(
        @Header("Authorization") token: String,
        @Query("usable_yn") usableStatus: String,
        @Query("store_cd") code: String
    ): CouponResponseModel

    @GET("tku/v1/coupon/buy/store/list")
    suspend fun canBuyCouponStoreList(
        @Header("Authorization") token: String,
        @Query("coupon_amt") couponPrice: String
    ): CanBuyCouponStoreResponseModel
}