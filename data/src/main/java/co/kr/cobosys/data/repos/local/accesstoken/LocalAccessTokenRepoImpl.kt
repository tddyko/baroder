package co.kr.cobosys.data.repos.local.accesstoken

import co.kr.cobosys.data.datasources.local.accesstoken.LocalAccessTokenDataSource
import co.kr.cobosys.data.mappers.local.accesstoken.toLocalAccessToken
import co.kr.cobosys.data.mappers.local.accesstoken.toRoomAccessToken
import co.kr.cobosys.domain.models.LocalAccessToken
import co.kr.cobosys.domain.repos.local.accesstoken.LocalAccessTokenRepo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class LocalAccessTokenRepoImpl @Inject constructor(
    private val localAccessTokenDataSource: LocalAccessTokenDataSource
): LocalAccessTokenRepo {
    override suspend fun insertLocalAccessToken(token: LocalAccessToken) = localAccessTokenDataSource.insertAccessToken(token.toRoomAccessToken())

    override fun getLocalAccessToken(): Flow<LocalAccessToken> = localAccessTokenDataSource.getAccessToken().map { it.toLocalAccessToken() }

    override suspend fun delLocalAccessToken() = localAccessTokenDataSource.delAccessToken()

}