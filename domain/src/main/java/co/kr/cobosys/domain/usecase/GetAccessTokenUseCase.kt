package co.kr.cobosys.domain.usecase

import co.kr.cobosys.domain.base.usecase.GeneralUseCase
import co.kr.cobosys.domain.model.AccessToken
import co.kr.cobosys.domain.repo.BaroderRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAccessTokenUseCase @Inject constructor(
    private val accessToken: BaroderRepository
) : GeneralUseCase<Flow<AccessToken>> {
    override fun invoke(): Flow<AccessToken> =
        accessToken.getAccessToken()
}