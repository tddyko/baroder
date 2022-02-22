package co.kr.cobosys.data.di.module

import co.kr.cobosys.data.repos.auth.AccessTokenRepoImpl
import co.kr.cobosys.domain.repos.auth.AccessTokenRepo
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepoModule {

    @Singleton
    @Binds
    abstract fun accessTokenRepo(
        accessTokenRepo: AccessTokenRepoImpl
    ): AccessTokenRepo
}