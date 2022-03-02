package co.kr.cobosys.data.repos.auth

import co.kr.cobosys.data.datasources.auth.AccessTokenDataSource
import co.kr.cobosys.data.mappers.auth.toAccessTokenModel
import co.kr.cobosys.domain.models.AccessTokenModel
import co.kr.cobosys.domain.repos.auth.AccessTokenRepo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class AccessTokenRepoImpl @Inject constructor(
    private val accessDataSource: AccessTokenDataSource
) : AccessTokenRepo {
    override fun getAccessToken(id: String, pwd: String): Flow<AccessTokenModel> =
//        AccessTokenMapper().mapLeftToRight(accessDataSource.login(id = id, pwd = pwd))
        accessDataSource.login(id = id, pwd = pwd).map { it.toAccessTokenModel() }
}