package co.kr.cobosys.data.di.module

import co.kr.cobosys.data.datasources.auth.*
import co.kr.cobosys.data.datasources.coupon.CheckCouponListDataSource
import co.kr.cobosys.data.datasources.coupon.CheckCouponListDataSourceImpl
import co.kr.cobosys.data.datasources.coupon.CouponPolicyDataSource
import co.kr.cobosys.data.datasources.coupon.CouponPolicyDataSourceImpl
import co.kr.cobosys.data.datasources.store.StoreListDataSource
import co.kr.cobosys.data.datasources.store.StoreListDataSourceImpl
import co.kr.cobosys.data.datasources.local.accesstoken.LocalAccessTokenDataSource
import co.kr.cobosys.data.datasources.local.accesstoken.LocalAccessTokenDataSourceImpl
import co.kr.cobosys.data.datasources.local.member.LocalMemberDataSource
import co.kr.cobosys.data.datasources.local.member.LocalMemberDataSourceImpl
import co.kr.cobosys.data.datasources.point.GetPointDataSource
import co.kr.cobosys.data.datasources.point.GetPointDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataSourceModule {

    @Singleton
    @Provides
    fun accessTokenDataSource(accessTokenDataSource: AccessTokenDataSourceImpl): AccessTokenDataSource =
        accessTokenDataSource

    @Singleton
    @Provides
    fun certifyCodeDataSource(certifyCodeDataSource: CertifyCodeDataSourceImpl): CertifyCodeDataSource =
        certifyCodeDataSource

    @Singleton
    @Provides
    fun memberInfoDataSource(memberInfoDataSource: MemberInfoDataSourceImpl): MemberInfoDataSource =
        memberInfoDataSource

    @Singleton
    @Provides
    fun localAccessTokenDataSource(localAccessTokenDataSource: LocalAccessTokenDataSourceImpl): LocalAccessTokenDataSource =
        localAccessTokenDataSource

    @Singleton
    @Provides
    fun localMemberDataSource(localMemberDataSource: LocalMemberDataSourceImpl): LocalMemberDataSource =
        localMemberDataSource
        
    @Singleton
    @Provides
    fun couponPolicyDataSource(couponPolicyDataSource: CouponPolicyDataSourceImpl) : CouponPolicyDataSource =
        couponPolicyDataSource

    @Singleton
    @Provides
    fun checkCouponDataSource(checkCouponDataSource: CheckCouponListDataSourceImpl) : CheckCouponListDataSource =
        checkCouponDataSource

    @Singleton
    @Provides
    fun getStoreListDataSource(storeListDataSource: StoreListDataSourceImpl) : StoreListDataSource =
        storeListDataSource

    @Singleton
    @Provides
    fun getPointListDataSource(pointListDataSource: GetPointDataSourceImpl) : GetPointDataSource =
        pointListDataSource
}