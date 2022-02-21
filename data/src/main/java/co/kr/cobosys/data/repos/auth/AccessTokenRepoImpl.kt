package co.kr.cobosys.data.repos.auth

import co.kr.cobosys.data.datasources.auth.AccessTokenDataSource
import co.kr.cobosys.data.mappers.auth.AccessTokenMapper
import co.kr.cobosys.domain.models.AccessToken
import co.kr.cobosys.domain.repos.auth.AccessTokenRepo
import javax.inject.Inject

class AccessTokenRepoImpl @Inject constructor(
    private val accessDataSource: AccessTokenDataSource
): AccessTokenRepo {
    override suspend fun getAccessToken(id: String, pwd: String): AccessToken {
        return AccessTokenMapper().mapLeftToRight(accessDataSource.login(id = id, pwd = pwd))
    }
}