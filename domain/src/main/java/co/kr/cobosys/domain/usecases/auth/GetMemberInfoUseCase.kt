package co.kr.cobosys.domain.usecases.auth

import android.os.Parcelable
import co.kr.cobosys.domain.base.usecases.GeneralParamsUseCase
import co.kr.cobosys.domain.models.MemberInfoModel
import co.kr.cobosys.domain.repos.auth.MemberInfoRepo
import kotlinx.coroutines.flow.Flow
import kotlinx.parcelize.Parcelize
import javax.inject.Inject

class GetMemberInfoUseCase @Inject constructor(
    private val storeRepository: MemberInfoRepo
) : GeneralParamsUseCase<Flow<MemberInfoModel>, PutAccessToken> {
    override suspend fun invoke(params: PutAccessToken): Flow<MemberInfoModel> =
        storeRepository.getMemberInfo(token = params.token)
}

@Parcelize
data class PutAccessToken(
    val token: String
): Parcelable