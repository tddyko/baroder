package co.kr.cobosys.data.di.module

import co.kr.cobosys.data.datasources.auth.AccessTokenDataSource
import co.kr.cobosys.data.datasources.auth.AccessTokenDataSourceImpl
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
}