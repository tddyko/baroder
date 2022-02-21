package co.kr.cobosys.data.di.module

import co.kr.cobosys.data.datasources.auth.AccessTokenDataSource
import co.kr.cobosys.data.datasources.auth.AccessTokenDataSourceImpl
import co.kr.cobosys.data.repos.auth.AccessTokenRepoImpl
import co.kr.cobosys.domain.repos.auth.AccessTokenRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
class RepoModule {

    @Provides
    @ViewModelScoped
    fun accessToken(
        accessToken: AccessTokenDataSource
    ): AccessTokenRepo = AccessTokenRepoImpl(accessToken)
}