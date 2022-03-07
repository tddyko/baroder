package co.kr.cobosys.data.di.module

import co.kr.cobosys.data.datasources.auth.*
import co.kr.cobosys.data.datasources.local.accesstoken.LocalAccessTokenDataSource
import co.kr.cobosys.data.datasources.local.accesstoken.LocalAccessTokenDataSourceImpl
import co.kr.cobosys.data.datasources.local.member.LocalMemberDataSource
import co.kr.cobosys.data.datasources.local.member.LocalMemberDataSourceImpl
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

}