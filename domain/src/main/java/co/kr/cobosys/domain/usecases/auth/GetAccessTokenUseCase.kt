package co.kr.cobosys.domain.usecases.auth

import android.os.Parcelable
import co.kr.cobosys.domain.base.usecases.GeneralParamsUseCase
import co.kr.cobosys.domain.models.AccessTokenModel
import co.kr.cobosys.domain.repos.auth.AccessTokenRepo
import kotlinx.coroutines.flow.Flow
import kotlinx.parcelize.Parcelize
import javax.inject.Inject

class GetAccessTokenUseCase @Inject constructor(
    private val accessToken: AccessTokenRepo
) : GeneralParamsUseCase<Flow<AccessTokenModel>, GetAccessTokenParams> {

    override suspend fun invoke(params: GetAccessTokenParams): Flow<AccessTokenModel> =
        accessToken.getAccessToken(id = params.id, pwd = params.pwd)
}

@Parcelize
data class GetAccessTokenParams(
    val id: String,
    val pwd: String
): Parcelable