package co.kr.cobosys.data.di.module

import co.kr.cobosys.data.datasources.auth.AccessTokenDataSource
import co.kr.cobosys.data.datasources.auth.AccessTokenDataSourceImpl
import co.kr.cobosys.data.repos.auth.AccessTokenRepoImpl
import co.kr.cobosys.domain.repos.auth.AccessTokenRepo
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {

    @Singleton
    @Binds
    abstract fun accessTokenDataSource(
        accessTokenDataSource: AccessTokenDataSourceImpl
    ): AccessTokenDataSource
}