package co.kr.cobosys.domain.di.module

import co.kr.cobosys.domain.repos.auth.AccessTokenRepo
import co.kr.cobosys.domain.repos.auth.MemberInfoRepo
import co.kr.cobosys.domain.repos.local.accesstoken.LocalAccessTokenRepo
import co.kr.cobosys.domain.repos.local.member.LocalMemberRepo
import co.kr.cobosys.domain.repos.coupon.CheckCouponRepo
import co.kr.cobosys.domain.repos.coupon.CouponPolicyRepo
import co.kr.cobosys.domain.repos.point.PointRepo
import co.kr.cobosys.domain.repos.store.StoreRepo
import co.kr.cobosys.domain.usecases.auth.GetAccessTokenUseCase
import co.kr.cobosys.domain.usecases.auth.GetMemberInfoUseCase
import co.kr.cobosys.domain.usecases.coupon.GetCheckCouponUseCase
import co.kr.cobosys.domain.usecases.coupon.GetCouponPolicyUseCase
import co.kr.cobosys.domain.usecases.store.GetStoreListUseCase
import co.kr.cobosys.domain.usecases.local.accesstoken.DelLocalAccessTokenUseCase
import co.kr.cobosys.domain.usecases.local.accesstoken.GetLocalAccessTokenUseCase
import co.kr.cobosys.domain.usecases.local.accesstoken.InsertLocalAccessTokenUseCase
import co.kr.cobosys.domain.usecases.local.member.DelLocalMemberUseCase
import co.kr.cobosys.domain.usecases.local.member.GetLocalMemberUseCase
import co.kr.cobosys.domain.usecases.local.member.InsertLocalMemberUseCase
import co.kr.cobosys.domain.usecases.point.GetPointUseCase
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

    @Provides
    fun couponPolicyUseCase(couponPolicy: CouponPolicyRepo): GetCouponPolicyUseCase = GetCouponPolicyUseCase(couponPolicy)

    @Provides
    fun checkCouponUseCase(checkCoupon: CheckCouponRepo) : GetCheckCouponUseCase = GetCheckCouponUseCase(checkCoupon)

    @Provides
    fun getStoreListUserCase(getStoreList: StoreRepo) : GetStoreListUseCase = GetStoreListUseCase(getStoreList)

    @Provides
    fun getPointUseCase(pointRepo: PointRepo) : GetPointUseCase = GetPointUseCase(pointRepo)
}