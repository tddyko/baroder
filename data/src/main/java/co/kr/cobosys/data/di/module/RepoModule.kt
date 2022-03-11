package co.kr.cobosys.data.di.module

import co.kr.cobosys.data.repos.auth.AccessTokenRepoImpl
import co.kr.cobosys.data.repos.auth.MemberInfoRepoImpl
import co.kr.cobosys.data.repos.local.accesstoken.LocalAccessTokenRepoImpl
import co.kr.cobosys.data.repos.local.member.LocalMemberRepoImpl
import co.kr.cobosys.data.repos.coupon.CheckCouponRepoImpl
import co.kr.cobosys.data.repos.coupon.CouponPolicyRepoImpl
import co.kr.cobosys.data.repos.point.PointRepoImpl
import co.kr.cobosys.data.repos.store.StoreRepoImpl
import co.kr.cobosys.domain.repos.auth.AccessTokenRepo
import co.kr.cobosys.domain.repos.auth.MemberInfoRepo
import co.kr.cobosys.domain.repos.local.accesstoken.LocalAccessTokenRepo
import co.kr.cobosys.domain.repos.local.member.LocalMemberRepo
import co.kr.cobosys.domain.repos.coupon.CheckCouponRepo
import co.kr.cobosys.domain.repos.coupon.CouponPolicyRepo
import co.kr.cobosys.domain.repos.point.PointRepo
import co.kr.cobosys.domain.repos.store.StoreRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepoModule {

    @Singleton
    @Provides
    fun accessTokenRepo(accessTokenRepo: AccessTokenRepoImpl): AccessTokenRepo =
        accessTokenRepo

    @Singleton
    @Provides
    fun memberInfoRepo(memberInfoRepo: MemberInfoRepoImpl): MemberInfoRepo =
        memberInfoRepo

    @Singleton
    @Provides
    fun localAccessTokenRepo(localAccessTokenRepo: LocalAccessTokenRepoImpl): LocalAccessTokenRepo =
        localAccessTokenRepo

    @Singleton
    @Provides
    fun localMemberRepo(localMemberRepo: LocalMemberRepoImpl): LocalMemberRepo =
        localMemberRepo

    @Singleton
    @Provides
    fun couponPolicyRepo(couponPolicyRepo: CouponPolicyRepoImpl) : CouponPolicyRepo =
        couponPolicyRepo

    @Singleton
    @Provides
    fun checkCouponRepo(checkCouponRepo: CheckCouponRepoImpl) : CheckCouponRepo =
        checkCouponRepo

    @Singleton
    @Provides
    fun getStoreListRepo(storeListRepo: StoreRepoImpl) : StoreRepo =
        storeListRepo

    @Singleton
    @Provides
    fun getPointListRepo(pointListRepo: PointRepoImpl) : PointRepo = pointListRepo
}