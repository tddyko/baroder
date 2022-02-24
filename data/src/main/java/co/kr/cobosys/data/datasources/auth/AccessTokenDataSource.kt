package co.kr.cobosys.data.datasources.auth

import co.kr.cobosys.data.api.AccessTokenResponseModel
import co.kr.cobosys.data.api.Request
import javax.inject.Inject

interface AccessTokenDataSource {
    suspend fun login(id: String, pwd: String): AccessTokenResponseModel
}

class AccessTokenDataSourceImpl @Inject constructor(
    private val reqApi: Request
): AccessTokenDataSource {

    override suspend fun login(id: String, pwd: String): AccessTokenResponseModel = reqApi.logIn(id, pwd)
}