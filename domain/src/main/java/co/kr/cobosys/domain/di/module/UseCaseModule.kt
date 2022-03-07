package co.kr.cobosys.domain.di.module

import co.kr.cobosys.domain.repos.auth.AccessTokenRepo
import co.kr.cobosys.domain.repos.auth.MemberInfoRepo
import co.kr.cobosys.domain.repos.local.accesstoken.LocalAccessTokenRepo
import co.kr.cobosys.domain.repos.local.member.LocalMemberRepo
import co.kr.cobosys.domain.usecases.auth.GetAccessTokenUseCase
import co.kr.cobosys.domain.usecases.auth.GetMemberInfoUseCase
import co.kr.cobosys.domain.usecases.local.accesstoken.DelLocalAccessTokenUseCase
import co.kr.cobosys.domain.usecases.local.accesstoken.GetLocalAccessTokenUseCase
import co.kr.cobosys.domain.usecases.local.accesstoken.InsertLocalAccessTokenUseCase
import co.kr.cobosys.domain.usecases.local.member.DelLocalMemberUseCase
import co.kr.cobosys.domain.usecases.local.member.GetLocalMemberUseCase
import co.kr.cobosys.domain.usecases.local.member.InsertLocalMemberUseCase
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

    @Provides
    fun getLocalAccessTokenUseCase(localAccessTokenRepo: LocalAccessTokenRepo): GetLocalAccessTokenUseCase = GetLocalAccessTokenUseCase(localAccessTokenRepo)

    @Provides
    fun insertLocalAccessTokenUseCase(localAccessTokenRepo: LocalAccessTokenRepo): InsertLocalAccessTokenUseCase = InsertLocalAccessTokenUseCase(localAccessTokenRepo)

    @Provides
    fun delLocalAccessTokenUseCase(localAccessTokenRepo: LocalAccessTokenRepo): DelLocalAccessTokenUseCase = DelLocalAccessTokenUseCase(localAccessTokenRepo)

    @Provides
    fun insertLocalMemberUseCase(localMemberRepo: LocalMemberRepo): InsertLocalMemberUseCase = InsertLocalMemberUseCase(localMemberRepo)

    @Provides
    fun getLocalMemberUseCase(localMemberRepo: LocalMemberRepo): GetLocalMemberUseCase = GetLocalMemberUseCase(localMemberRepo)

    @Provides
    fun delLocalMemberUseCase(localMemberRepo: LocalMemberRepo): DelLocalMemberUseCase = DelLocalMemberUseCase(localMemberRepo)
}