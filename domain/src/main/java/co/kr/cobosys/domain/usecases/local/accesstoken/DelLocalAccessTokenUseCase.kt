package co.kr.cobosys.domain.usecases.local.accesstoken

import co.kr.cobosys.domain.base.usecases.GeneralNotTypeUseCase
import co.kr.cobosys.domain.models.LocalAccessToken
import co.kr.cobosys.domain.repos.local.accesstoken.LocalAccessTokenRepo
import javax.inject.Inject

class DelLocalAccessTokenUseCase @Inject constructor(
    private val localAccessToken: LocalAccessTokenRepo
): GeneralNotTypeUseCase<LocalAccessToken> {
    override suspend fun invoke() = localAccessToken.delLocalAccessToken()
}