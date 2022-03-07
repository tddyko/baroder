package co.kr.cobosys.domain.usecases.local.accesstoken

import co.kr.cobosys.domain.base.usecases.GeneralUseCase
import co.kr.cobosys.domain.models.LocalAccessToken
import co.kr.cobosys.domain.repos.local.accesstoken.LocalAccessTokenRepo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetLocalAccessTokenUseCase @Inject constructor(
    private val localAccessToken: LocalAccessTokenRepo
): GeneralUseCase<Flow<LocalAccessToken>> {
    override suspend fun invoke(): Flow<LocalAccessToken> = localAccessToken.getLocalAccessToken()
}