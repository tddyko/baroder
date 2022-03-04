package co.kr.cobosys.domain.di.module

import co.kr.cobosys.domain.repos.auth.AccessTokenRepo
import co.kr.cobosys.domain.repos.auth.MemberInfoRepo
import co.kr.cobosys.domain.usecases.auth.GetAccessTokenUseCase
import co.kr.cobosys.domain.usecases.auth.GetMemberInfoUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class UseCaseModule {

    @Provides
    fun accessTokenRepoUseCase(accessTokenRepo: AccessTokenRepo): GetAccessTokenUseCase = GetAccessTokenUseCase(accessTokenRepo)

    @Provides
    fun memberInfoRepoUseCase(memberInfoRepo: MemberInfoRepo): GetMemberInfoUseCase = GetMemberInfoUseCase(memberInfoRepo)
}