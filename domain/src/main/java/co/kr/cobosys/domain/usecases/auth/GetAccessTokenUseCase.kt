package co.kr.cobosys.domain.usecases.auth

import android.os.Parcelable
import co.kr.cobosys.domain.base.usecases.GeneralParamsUseCase
import co.kr.cobosys.domain.models.AccessToken
import co.kr.cobosys.domain.repos.auth.AccessTokenRepo
import kotlinx.coroutines.flow.Flow
import kotlinx.parcelize.Parcelize
import javax.inject.Inject

class GetAccessTokenUseCase @Inject constructor(
    private val accessToken: AccessTokenRepo
) : GeneralParamsUseCase <AccessToken,  GetAccessTokenParams> {

    override suspend fun invoke(params: GetAccessTokenParams): AccessToken =
        accessToken.getAccessToken(params.id, params.pwd)
}

@Parcelize
data class GetAccessTokenParams(
    val id: String,
    val pwd: String
): Parcelable