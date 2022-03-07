package co.kr.cobosys.domain.usecases.local.accesstoken

import co.kr.cobosys.domain.base.usecases.GeneralNotTypeParamsUseCase
import co.kr.cobosys.domain.models.LocalAccessToken
import co.kr.cobosys.domain.repos.local.accesstoken.LocalAccessTokenRepo
import javax.inject.Inject

class InsertLocalAccessTokenUseCase @Inject constructor(
    private val localAccessToken: LocalAccessTokenRepo
): GeneralNotTypeParamsUseCase<LocalAccessToken, InsertLocalAccessTokenParams> {
    override suspend fun invoke(params: InsertLocalAccessTokenParams) = localAccessToken.insertLocalAccessToken(token = params.token)

}

@JvmInline
value class InsertLocalAccessTokenParams(val token: LocalAccessToken)
