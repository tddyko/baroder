package co.kr.cobosys.data.di.module

import co.kr.cobosys.data.datasources.auth.AccessTokenDataSource
import co.kr.cobosys.data.repos.auth.AccessTokenRepoImpl
import co.kr.cobosys.domain.repos.auth.AccessTokenRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import javax.inject.Singleton

@Module
@InstallIn(ViewModelComponent::class)
class RepoModule {

    @Provides
    @Singleton
    fun accessToken(
        accessToken: AccessTokenDataSource
    ): AccessTokenRepo = AccessTokenRepoImpl(accessToken)
}