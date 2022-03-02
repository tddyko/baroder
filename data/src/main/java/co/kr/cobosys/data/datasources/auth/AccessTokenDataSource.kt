package co.kr.cobosys.data.datasources.auth

import co.kr.cobosys.data.api.AccessTokenResponseModel
import co.kr.cobosys.data.api.Request
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface AccessTokenDataSource {
    fun login(id: String, pwd: String): Flow<AccessTokenResponseModel>
}

class AccessTokenDataSourceImpl @Inject constructor(
    private val reqApi: Request
): AccessTokenDataSource {

    override fun login(id: String, pwd: String): Flow<AccessTokenResponseModel> = reqApi.logIn(id, pwd)
}