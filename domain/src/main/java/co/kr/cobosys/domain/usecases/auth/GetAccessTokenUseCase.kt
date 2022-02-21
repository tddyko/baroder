package co.kr.cobosys.domain.usecases.auth

import co.kr.cobosys.domain.base.usecases.GeneralUseCase
import co.kr.cobosys.domain.models.AccessToken
import co.kr.cobosys.domain.repos.auth.AccessTokenRepo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAccessTokenUseCase @Inject constructor(
    private val accessToken: AccessTokenRepo
) : GeneralUseCase<Flow<AccessToken>> {
    override fun invoke(): Flow<AccessToken> =
        accessToken.getAccessToken()
}