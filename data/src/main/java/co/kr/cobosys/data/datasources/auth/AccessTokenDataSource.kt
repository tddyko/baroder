package co.kr.cobosys.data.datasources.auth

import co.kr.cobosys.data.api.AccessTokenResponse
import co.kr.cobosys.data.api.Request
import javax.inject.Inject

interface AccessTokenDataSource {
    suspend fun login(id: String, pwd: String): AccessTokenResponse
}

class AccessTokenDataSourceImpl @Inject constructor(
    private val reqApi: Request
): AccessTokenDataSource {

    override suspend fun login(id: String, pwd: String): AccessTokenResponse {
        return reqApi.logIn(id, pwd)
    }
}