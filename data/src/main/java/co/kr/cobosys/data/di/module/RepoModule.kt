package co.kr.cobosys.data.di.module

import co.kr.cobosys.data.repos.auth.AccessTokenRepoImpl
import co.kr.cobosys.data.repos.auth.MemberInfoRepoImpl
import co.kr.cobosys.domain.repos.auth.AccessTokenRepo
import co.kr.cobosys.domain.repos.auth.MemberInfoRepo
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
}